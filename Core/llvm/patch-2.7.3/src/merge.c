/*  Merge a patch

    Copyright (C) 2009-2012 Free Software Foundation, Inc.
    Written by Andreas Gruenbacher <agruen@gnu.org>, 2009.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

#define XTERN extern
#include <common.h>
#include <minmax.h>
#include <xalloc.h>
#include <inp.h>
#include <pch.h>
#include <util.h>

static lin count_context_lines (void);
static bool context_matches_file (lin, lin);
static void compute_changes (lin, lin, lin, lin, char *, char *);

#define OFFSET lin
#define EQUAL_IDX(x, y) (context_matches_file (x, y))
#include "bestmatch.h"

#define XVECREF_YVECREF_EQUAL(ctxt, x, y) (context_matches_file (x, y))
#define OFFSET lin
#define EXTRA_CONTEXT_FIELDS \
	char *xchar; \
	char *ychar;
#define NOTE_DELETE(ctxt, xoff) ctxt->xchar[xoff] = '-';
#define NOTE_INSERT(ctxt, yoff) ctxt->ychar[yoff] = '+';
#define USE_HEURISTIC 1
#include "diffseq.h"

static lin
locate_merge (lin *matched)
{
    lin first_guess = pch_first () + in_offset;
    lin pat_lines = pch_ptrn_lines ();
    lin context_lines = count_context_lines ();
    lin max_where = input_lines - pat_lines + context_lines + 1;
    lin min_where = last_frozen_line + 1;
    lin max_pos_offset = max_where - first_guess;
    lin max_neg_offset = first_guess - min_where;
    lin max_offset = (max_pos_offset < max_neg_offset
		      ? max_neg_offset : max_pos_offset);
    lin where = first_guess, max_matched = 0;
    lin min, max;
    lin offset;
    bool match_until_eof;

    /* Note: we need to preserve patch's property that it applies hunks at the
       best match closest to their original position in the file.  It is
       common for hunks to apply equally well in several places in a file.
       Applying at the first best match would be a lot easier.
     */

    if (context_lines == 0)
      goto out;  /* locate_hunk() already tried that */

    /* Allow at most CONTEXT_LINES lines to be replaced (replacing counts
       as insert + delete), and require the remaining MIN lines to match.  */
    max = 2 * context_lines;
    min = pat_lines - context_lines;

    if (debug & 1)
      {
	char numbuf0[LINENUM_LENGTH_BOUND + 1];
	char numbuf1[LINENUM_LENGTH_BOUND + 1];
	say ("locating merge: min=%s max=%s ",
	     format_linenum (numbuf0, min),
	     format_linenum (numbuf1, max));
      }

    /* Hunks from the start or end of the file have less context. Anchor them
       to the start or end, trying to make up for this disadvantage.  */
    offset = pch_suffix_context () - pch_prefix_context ();
    if (offset > 0 && pch_first () <= 1)
      max_pos_offset = 0;
    match_until_eof = offset < 0;

    /* Do not try lines <= 0.  */
    if (first_guess <= max_neg_offset)
      max_neg_offset = first_guess - 1;

    for (offset = 0; offset <= max_offset; offset++)
      {
	if (offset <= max_pos_offset)
	  {
	    lin guess = first_guess + offset;
	    lin last;
	    lin changes;

	    changes = bestmatch (1, pat_lines + 1, guess, input_lines + 1,
				 match_until_eof ? input_lines - guess + 1 : min,
				 max, &last);
	    if (changes <= max && max_matched < last - guess)
	      {
		max_matched = last - guess;
		where = guess;
		if (changes == 0)
		  break;
		min = last - guess;
		max = changes - 1;
	      }
	  }
	if (0 < offset && offset <= max_neg_offset)
	  {
	    lin guess = first_guess - offset;
	    lin last;
	    lin changes;

	    changes = bestmatch (1, pat_lines + 1, guess, input_lines + 1,
				 match_until_eof ? input_lines - guess + 1 : min,
				 max, &last);
	    if (changes <= max && max_matched < last - guess)
	      {
		max_matched = last - guess;
		where = guess;
		if (changes == 0)
		  break;
		min = last - guess;
		max = changes - 1;
	      }
	  }
      }
    if (debug & 1)
      {
	char numbuf0[LINENUM_LENGTH_BOUND + 1];
	char numbuf1[LINENUM_LENGTH_BOUND + 1];
	char numbuf2[LINENUM_LENGTH_BOUND + 1];
	say ("where=%s matched=%s changes=%s\n",
	     format_linenum (numbuf0, where),
	     format_linenum (numbuf1, max_matched),
	     format_linenum (numbuf2, max + 1));
      }

  out:
    *matched = max_matched;
    if (where < min_where)
      where = min_where;
    return where;
}

static void
print_linerange (lin from, lin to)
{
  char numbuf0[LINENUM_LENGTH_BOUND + 1];
  char numbuf1[LINENUM_LENGTH_BOUND + 1];

  if (to <= from)
    printf ("%s",
	    format_linenum (numbuf0, from));
  else
    printf ("%s-%s",
	    format_linenum (numbuf0, from),
	    format_linenum (numbuf1, to));
}

static void
merge_result (bool *first_result, int hunk, char const *what, lin from, lin to)
{
  static char const *last_what;

  if (*first_result && what)
    {
      printf ("Hunk #%d %s at ", hunk, what);
      last_what = what;
    }
  else if (! what)
    {
      if (! *first_result)
	{
	  fputs (".\n", stdout);
	  fflush (stdout);
	  last_what = 0;
	}
      return;
    }
  else if (last_what == what)
    fputs (",", stdout);
  else
    printf (", %s at ", what);
  print_linerange (from + out_offset, to + out_offset);
  *first_result = false;
}

bool
merge_hunk (int hunk, struct outstate *outstate, lin where, bool *somefailed)
{
  bool applies_cleanly;
  bool first_result = true;
  bool already_applied;
  FILE *fp = outstate->ofp;
  lin old = 1;
  lin firstold = pch_ptrn_lines ();
  lin new = firstold + 1;
  lin firstnew = pch_end ();
  lin in;
  lin firstin;
  char *oldin;
  lin matched;
  lin lastwhere;

  /* Convert '!' markers into '-' and '+' to simplify things here.  */
  pch_normalize (UNI_DIFF);

  assert (pch_char (firstnew + 1) == '^');
  while (pch_char (new) == '=' || pch_char (new) == '\n')
    new++;

  if (where)
    {
      applies_cleanly = true;
      matched = pch_ptrn_lines ();
    }
  else
    {
      where = locate_merge (&matched);
      applies_cleanly = false;
    }

  in = firstold + 2;
  oldin = xmalloc (in + matched + 1);
  memset (oldin, ' ', in + matched);
  oldin[0] = '*';
  oldin[in - 1] = '=';
  oldin[in + matched] = '^';
  compute_changes (old, in - 1, where, where + matched,
		   oldin + old, oldin + in);

  if (debug & 2)
    {
      char numbuf0[LINENUM_LENGTH_BOUND + 1];
      char numbuf1[LINENUM_LENGTH_BOUND + 1];
      lin n;

      fputc ('\n', stderr);
      for (n = 0; n <= in + matched; n++)
	{
	  fprintf (stderr, "%s %c",
		  format_linenum (numbuf0, n),
		  oldin[n]);
	  if (n == 0)
	    fprintf(stderr, " %s,%s\n",
		    format_linenum (numbuf0, pch_first()),
		    format_linenum (numbuf1, pch_ptrn_lines()));
	  else if (n <= firstold)
	    fprintf (stderr, " |%.*s",
		     (int) pch_line_len (n), pfetch (n));
	  else if (n == in - 1)
	    fprintf(stderr, " %s,%s\n",
		    format_linenum (numbuf0, where),
		    format_linenum (numbuf1, matched));
	  else if (n >= in && n < in + matched)
	    {
	      size_t size;
	      const char *line;

	      line = ifetch (where + n - in, false, &size);
	      fprintf (stderr, " |%.*s",
		       (int) size, line);
	    }
	  else
	    fputc('\n', stderr);
	}
      fflush (stderr);
    }

  if (last_frozen_line < where - 1)
    if (! copy_till (outstate, where - 1))
      return false;

  for (;;)
    {
      firstold = old;
      firstnew = new;
      firstin = in;

      if (pch_char (old) == '-' || pch_char (new) == '+')
	{
	  lin lines;

	  while (pch_char (old) == '-')
	    {
	      if (oldin[old] == '-' || oldin[in] == '+')
		goto conflict;
	      else if (oldin[old] == ' ')
		{
		  assert (oldin[in] == ' ');
		  in++;
		}
	      old++;
	    }
	  if (oldin[old] == '-' || oldin[in] == '+')
	    goto conflict;
	  while (pch_char (new) == '+')
	    new++;

	  lines = new - firstnew;
	  if (verbosity == VERBOSE
	      || ((verbosity != SILENT) && ! applies_cleanly))
	    merge_result (&first_result, hunk, "merged",
			  where, where + lines - 1);
	  last_frozen_line += (old - firstold);
	  where += (old - firstold);
	  out_offset += new - firstnew;

	  if (firstnew < new)
	    {
	      while (firstnew < new)
		{
		  outstate->after_newline = pch_write_line (firstnew, fp);
		  firstnew++;
		}
	      outstate->zero_output = false;
	    }
	}
      else if (pch_char (old) == ' ')
	{
	  if (oldin[old] == '-')
	    {
	      while (pch_char (old) == ' ')
		{
		  if (oldin[old] != '-')
		    break;
		  if (pch_char (new) == '+')
		    goto conflict;
		  else
		    assert (pch_char (new) == ' ');
		  old++;
		  new++;
		}
	      if (pch_char (old) == '-' || pch_char (new) == '+')
		goto conflict;
	    }
	  else if (oldin[in] == '+')
	    {
	      while (oldin[in] == '+')
		in++;

	      /* Take these lines from the input file.  */
	      where += in - firstin;
	      if (! copy_till (outstate, where - 1))
		return false;
	    }
	  else if (oldin[old] == ' ')
	    {
	      while (pch_char (old) == ' '
		     && oldin[old] == ' '
		     && pch_char (new) == ' '
		     && oldin[in] == ' ')
		{
		  old++;
		  new++;
		  in++;
		}

	      /* Take these lines from the input file.  */
	      where += (in - firstin);
	      if (! copy_till (outstate, where - 1))
		return false;
	    }
	}
      else
	{
	  assert (pch_char (old) == '=' && pch_char (new) == '^');
	  /* Nothing more left to merge.  */
	  break;
	}
      continue;

    conflict:
      /* Find the end of the conflict.  */
      for (;;)
	{
	  if (pch_char (old) == '-')
	    {
	      while (oldin[in] == '+')
		in++;
	      if (oldin[old] == ' ')
		{
		  assert (oldin[in] == ' ');
		  in++;
		}
	      old++;
	    }
	  else if (oldin[old] == '-')
	    {
	      while (pch_char (new) == '+')
		new++;
	      if (pch_char (old) == ' ')
		{
		  assert (pch_char (new) == ' ');
		  new++;
		}
	      old++;
	    }
	  else if (pch_char (new) == '+')
	    while (pch_char (new) == '+')
	      new++;
	  else if (oldin[in] == '+')
	    while (oldin[in] == '+')
	      in++;
	  else
	    break;
	}
      assert (((pch_char (old) == ' ' && pch_char (new) == ' ')
	       || (pch_char (old) == '=' && pch_char (new) == '^'))
	      && ((oldin[old] == ' ' && oldin[in] == ' ')
		  || (oldin[old] == '=' && oldin[in] == '^')));

      /* Output common prefix lines.  */
      for (lastwhere = where;
	   firstin < in && firstnew < new
	     && context_matches_file (firstnew, lastwhere);
	   firstin++, firstnew++, lastwhere++)
	/* do nothing */ ;
      already_applied = (firstin == in && firstnew == new);
      if (already_applied)
	merge_result (&first_result, hunk, "already applied",
		      where, lastwhere - 1);
      if (conflict_style == MERGE_DIFF3)
	{
	  lin common_prefix = lastwhere - where;

	  /* Forget about common prefix lines.  */
	  firstin -= common_prefix;
	  firstnew -= common_prefix;
	  lastwhere -= common_prefix;
	}
      if (where != lastwhere)
	{
	  where = lastwhere;
	  if (! copy_till (outstate, where - 1))
	    return false;
	}

      if (! already_applied)
	{
	  lin common_suffix = 0;
	  lin lines;

	  if (conflict_style == MERGE_MERGE)
	    {
	      /* Remember common suffix lines.  */
	      for (lastwhere = where + (in - firstin);
		   firstin < in && firstnew < new
		   && context_matches_file (new - 1, lastwhere - 1);
		   in--, new--, lastwhere--, common_suffix++)
		/* do nothing */ ;
	    }

	  lines = 3 + (in - firstin) + (new - firstnew);
	  if (conflict_style == MERGE_DIFF3)
	    lines += 1 + (old - firstold);
	  merge_result (&first_result, hunk, "NOT MERGED",
			where, where + lines - 1);
	  out_offset += lines - (in - firstin);

	  fputs (outstate->after_newline + "\n<<<<<<<\n", fp);
	  outstate->after_newline = true;
	  if (firstin < in)
	    {
	      where += (in - firstin);
	      if (! copy_till (outstate, where - 1))
		return false;
	    }

	  if (conflict_style == MERGE_DIFF3)
	    {
	      fputs (outstate->after_newline + "\n|||||||\n", fp);
	      outstate->after_newline = true;
	      while (firstold < old)
		{
		  outstate->after_newline = pch_write_line (firstold, fp);
		  firstold++;
		}
	    }

	  fputs (outstate->after_newline + "\n=======\n", fp);
	  outstate->after_newline = true;
	  while (firstnew < new)
	    {
	      outstate->after_newline = pch_write_line (firstnew, fp);
	      firstnew++;
	    }
	  fputs (outstate->after_newline + "\n>>>>>>>\n", fp);
	  outstate->after_newline = true;
	  outstate->zero_output = false;
	  if (ferror (fp))
	    write_fatal ();

	  /* Output common suffix lines.  */
	  if (common_suffix)
	    {
	      where += common_suffix;
	      if (! copy_till (outstate, where - 1))
		return false;
	      in += common_suffix;
	      new += common_suffix;
	    }
	  *somefailed = true;
	}
    }
  merge_result (&first_result, 0, 0, 0, 0);

  assert (last_frozen_line == where - 1);
  free (oldin);
  return true;
}

static lin
count_context_lines (void)
{
  lin old;
  lin lastold = pch_ptrn_lines ();
  lin context;

  for (context = 0, old = 1; old <= lastold; old++)
    if (pch_char (old) == ' ')
      context++;
  return context;
}

static bool
context_matches_file (lin old, lin where)
{
  size_t size;
  const char *line;

  line = ifetch (where, false, &size);
  return size &&
	 (canonicalize ?
	  similar (pfetch (old), pch_line_len (old), line, size) :
	  (size == pch_line_len (old) &&
	   memcmp (line, pfetch (old), size) == 0));
}

static void
compute_changes (lin xmin, lin xmax, lin ymin, lin ymax,
		 char *xchar, char *ychar)
{
  struct context ctxt;
  lin diags;

  ctxt.xchar = xchar - xmin;
  ctxt.ychar = ychar - ymin;

  diags = xmax + ymax + 3;
  ctxt.fdiag = xmalloc (2 * diags * sizeof (*ctxt.fdiag));
  ctxt.bdiag = ctxt.fdiag + diags;
  ctxt.fdiag += ymax + 1;
  ctxt.bdiag += ymax + 1;

  ctxt.heuristic = true;

  compareseq (xmin, xmax, ymin, ymax, &ctxt);

  ctxt.fdiag -= ymax + 1;
  free (ctxt.fdiag);
}
