/* reading patches */

/* Copyright (C) 1986, 1987, 1988 Larry Wall

   Copyright (C) 1990-1993, 1997-2003, 2006, 2009-2012 Free Software
   Foundation, Inc.

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
#include <dirname.h>
#include <inp.h>
#include <quotearg.h>
#include <util.h>
#include <xalloc.h>
#include <xmemdup0.h>
#undef XTERN
#define XTERN
#include <pch.h>
#if HAVE_SETMODE_DOS
# include <io.h>
#endif

#define INITHUNKMAX 125			/* initial dynamic allocation size */

/* Patch (diff listing) abstract type. */

static FILE *pfp;			/* patch file pointer */
static int p_says_nonexistent[2];	/* [0] for old file, [1] for new:
		0 for existent and nonempty,
		1 for existent and probably (but not necessarily) empty,
		2 for nonexistent */
static int p_rfc934_nesting;		/* RFC 934 nesting level */
static char *p_name[3];			/* filenames in patch headers */
static char const *invalid_names[2];
bool p_copy[2];				/* Does this patch create a copy? */
bool p_rename[2];			/* Does this patch rename a file? */
static char *p_timestr[2];		/* timestamps as strings */
static char *p_sha1[2];			/* SHA1 checksums */
static mode_t p_mode[2];		/* file modes */
static off_t p_filesize;		/* size of the patch file */
static lin p_first;			/* 1st line number */
static lin p_newfirst;			/* 1st line number of replacement */
static lin p_ptrn_lines;		/* # lines in pattern */
static lin p_repl_lines;		/* # lines in replacement text */
static lin p_end = -1;			/* last line in hunk */
static lin p_max;			/* max allowed value of p_end */
static lin p_prefix_context;		/* # of prefix context lines */
static lin p_suffix_context;		/* # of suffix context lines */
static lin p_input_line;		/* current line # from patch file */
static char **p_line;			/* the text of the hunk */
static size_t *p_len;			/* line length including \n if any */
static char *p_Char;			/* +, -, and ! */
static lin hunkmax = INITHUNKMAX;	/* size of above arrays */
static size_t p_indent;			/* indent to patch */
static bool p_strip_trailing_cr;	/* true if stripping trailing \r */
static bool p_pass_comments_through;	/* true if not ignoring # lines */
static file_offset p_base;		/* where to intuit this time */
static lin p_bline;			/* line # of p_base */
static file_offset p_start;		/* where intuit found a patch */
static lin p_sline;			/* and the line number for it */
static lin p_hunk_beg;			/* line number of current hunk */
static lin p_efake = -1;		/* end of faked up lines--don't free */
static lin p_bfake = -1;		/* beg of faked up lines */
static char *p_c_function;		/* the C function a hunk is in */
static bool p_git_diff;			/* true if this is a git style diff */

static char *scan_linenum (char *, lin *);
static enum diff intuit_diff_type (bool, mode_t *);
static enum nametype best_name (char * const *, int const *);
static int prefix_components (char *, bool);
static size_t pget_line (size_t, int, bool, bool);
static size_t get_line (void);
static bool incomplete_line (void);
static bool grow_hunkmax (void);
static void malformed (void) __attribute__ ((noreturn));
static void next_intuit_at (file_offset, lin);
static void skip_to (file_offset, lin);
static char get_ed_command_letter (char const *);

/* Prepare to look for the next patch in the patch file. */

void
re_patch (void)
{
    p_first = 0;
    p_newfirst = 0;
    p_ptrn_lines = 0;
    p_repl_lines = 0;
    p_end = -1;
    p_max = 0;
    p_indent = 0;
    p_strip_trailing_cr = false;
}

/* Open the patch file at the beginning of time. */

void
open_patch_file (char const *filename)
{
    file_offset file_pos = 0;
    file_offset pos;
    struct stat st;

    if (!filename || !*filename || strEQ (filename, "-"))
      pfp = stdin;
    else
      {
	pfp = fopen (filename, binary_transput ? "rb" : "r");
	if (!pfp)
	  pfatal ("Can't open patch file %s", quotearg (filename));
      }
#if HAVE_SETMODE_DOS
    if (binary_transput)
      {
	if (isatty (fileno (pfp)))
	  fatal ("cannot read binary data from tty on this platform");
	setmode (fileno (pfp), O_BINARY);
      }
#endif
    if (fstat (fileno (pfp), &st) != 0)
      pfatal ("fstat");
    if (S_ISREG (st.st_mode) && (pos = file_tell (pfp)) != -1)
      file_pos = pos;
    else
      {
	size_t charsread;
	int fd = make_tempfile (&TMPPATNAME, 'p', NULL, O_RDWR | O_BINARY, 0);
	FILE *read_pfp = pfp;
	TMPPATNAME_needs_removal = true;
	pfp = fdopen (fd, "w+b");
	if (! pfp)
	  pfatal ("Can't open stream for file %s", quotearg (TMPPATNAME));
	for (st.st_size = 0;
	     (charsread = fread (buf, 1, bufsize, read_pfp)) != 0;
	     st.st_size += charsread)
	  if (fwrite (buf, 1, charsread, pfp) != charsread)
	    write_fatal ();
	if (ferror (read_pfp) || fclose (read_pfp) != 0)
	  read_fatal ();
	if (fflush (pfp) != 0
	    || file_seek (pfp, (file_offset) 0, SEEK_SET) != 0)
	  write_fatal ();
      }
    p_filesize = st.st_size;
    if (p_filesize != (file_offset) p_filesize)
      fatal ("patch file is too long");
    next_intuit_at (file_pos, 1);
}

/* Make sure our dynamically realloced tables are malloced to begin with. */

static void
set_hunkmax (void)
{
    if (!p_line)
	p_line = (char **) xmalloc (hunkmax * sizeof *p_line);
    if (!p_len)
	p_len = (size_t *) xmalloc (hunkmax * sizeof *p_len);
    if (!p_Char)
	p_Char = xmalloc (hunkmax * sizeof *p_Char);
}

/* Enlarge the arrays containing the current hunk of patch. */

static bool
grow_hunkmax (void)
{
    hunkmax *= 2;
    assert (p_line && p_len && p_Char);
    if ((p_line = (char **) realloc (p_line, hunkmax * sizeof (*p_line)))
	&& (p_len = (size_t *) realloc (p_len, hunkmax * sizeof (*p_len)))
	&& (p_Char = realloc (p_Char, hunkmax * sizeof (*p_Char))))
      return true;
    if (!using_plan_a)
      xalloc_die ();
    /* Don't free previous values of p_line etc.,
       since some broken implementations free them for us.
       Whatever is null will be allocated again from within plan_a (),
       of all places.  */
    return false;
}

static bool
maybe_reverse (char const *name, bool nonexistent, bool is_empty)
{
  bool looks_reversed = (! is_empty) < p_says_nonexistent[reverse ^ is_empty];

  /* Allow to create and delete empty files when we know that they are empty:
     in the "diff --git" format, we know that from the index header.  */
  if (is_empty
      && p_says_nonexistent[reverse ^ nonexistent] == 1
      && p_says_nonexistent[! reverse ^ nonexistent] == 2)
    return false;

  if (looks_reversed)
    reverse ^=
      ok_to_reverse ("The next patch%s would %s the file %s,\nwhich %s!",
		     reverse ? ", when reversed," : "",
		     (nonexistent ? "delete"
		      : is_empty ? "empty out"
		      : "create"),
		     quotearg (name),
		     (nonexistent ? "does not exist"
		      : is_empty ? "is already empty"
		      : "already exists"));
  return looks_reversed;
}

/* True if the remainder of the patch file contains a diff of some sort. */

bool
there_is_another_patch (bool need_header, mode_t *file_type)
{
    if (p_base != 0 && p_base >= p_filesize) {
	if (verbosity == VERBOSE)
	    say ("done\n");
	return false;
    }
    if (verbosity == VERBOSE)
	say ("Hmm...");
    diff_type = intuit_diff_type (need_header, file_type);
    if (diff_type == NO_DIFF) {
	if (verbosity == VERBOSE)
	  say (p_base
	       ? "  Ignoring the trailing garbage.\ndone\n"
	       : "  I can't seem to find a patch in there anywhere.\n");
	if (! p_base && p_filesize)
	  fatal ("Only garbage was found in the patch input.");
	return false;
    }
    if (skip_rest_of_patch)
      {
	Fseek (pfp, p_start, SEEK_SET);
	p_input_line = p_sline - 1;
	return true;
      }
    if (verbosity == VERBOSE)
	say ("  %sooks like %s to me...\n",
	    (p_base == 0 ? "L" : "The next patch l"),
	    diff_type == UNI_DIFF ? "a unified diff" :
	    diff_type == CONTEXT_DIFF ? "a context diff" :
	    diff_type == NEW_CONTEXT_DIFF ? "a new-style context diff" :
	    diff_type == NORMAL_DIFF ? "a normal diff" :
	    diff_type == GIT_BINARY_DIFF ? "a git binary diff" :
	    "an ed script" );

    if (no_strip_trailing_cr)
      p_strip_trailing_cr = false;

    if (verbosity != SILENT)
      {
	if (p_indent)
	  say ("(Patch is indented %lu space%s.)\n",
	       (unsigned long int) p_indent, p_indent==1?"":"s");
	if (p_strip_trailing_cr)
	  say ("(Stripping trailing CRs from patch; use --binary to disable.)\n");
	if (! inname)
	  {
	    char numbuf[LINENUM_LENGTH_BOUND + 1];
	    say ("can't find file to patch at input line %s\n",
		 format_linenum (numbuf, p_sline));
	    if (diff_type != ED_DIFF && diff_type != NORMAL_DIFF)
	      say (strippath == -1
		   ? "Perhaps you should have used the -p or --strip option?\n"
		   : "Perhaps you used the wrong -p or --strip option?\n");
	  }
      }

    skip_to(p_start,p_sline);
    while (!inname) {
	char *t;
	if (force | batch) {
	    say ("No file to patch.  Skipping patch.\n");
	    skip_rest_of_patch = true;
	    return true;
	}
	ask ("File to patch: ");
	t = buf + strlen (buf);
	if (t > buf + 1 && *(t - 1) == '\n')
	  {
	    inname = xmemdup0 (buf, t - buf - 1);
	    inerrno = stat_file (inname, &instat);
	    if (inerrno)
	      {
		perror (inname);
		fflush (stderr);
		free (inname);
		inname = 0;
	      }
	    else
	      invc = -1;
	  }
	if (!inname) {
	    ask ("Skip this patch? [y] ");
	    if (*buf != 'n') {
		if (verbosity != SILENT)
		    say ("Skipping patch.\n");
		skip_rest_of_patch = true;
		return true;
	    }
	}
    }
    return true;
}

static mode_t _GL_ATTRIBUTE_PURE
fetchmode (char const *str)
{
   const char *s;
   mode_t mode;

   while (ISSPACE ((unsigned char) *str))
     str++;

   for (s = str, mode = 0; s < str + 6; s++)
     {
       if (*s >= '0' && *s <= '7')
	mode = (mode << 3) + (*s - '0');
       else
	{
	 mode = 0;
	 break;
	}
     }
   if (*s == '\r')
     s++;
   if (*s != '\n')
     mode = 0;

    /* NOTE: The "diff --git" format always sets the file mode permission
       bits of symlinks to 0.  (On Linux, symlinks actually always have
       0777 permissions, so this is not even consistent.)  */

   return mode;
}

static void
get_sha1(char **sha1, char const *start, char const *end)
{
  unsigned int len = end - start;
  *sha1 = xmalloc (len + 1);
  memcpy (*sha1, start, len);
  (*sha1)[len] = 0;
}

static int _GL_ATTRIBUTE_PURE
sha1_says_nonexistent(char const *sha1)
{
  char const *empty_sha1 = "e69de29bb2d1d6434b8b29ae775ad8c2e48c5391";
  char const *s;

  /* Nonexisting files have an all-zero checksum.  */
  for (s = sha1; *s; s++)
    if (*s != '0')
      break;
  if (! *s)
    return 2;

  /* Empty files have empty_sha1 as their checksum.  */
  for (s = sha1; *s; s++, empty_sha1++)
    if (*s != *empty_sha1)
      break;
  return ! *s;
}

static char const * _GL_ATTRIBUTE_PURE
skip_hex_digits (char const *str)
{
  char const *s;

  for (s = str; (*s >= '0' && *s <= '9') || (*s >= 'a' && *s <= 'f'); s++)
    /* do nothing */ ;
  return s == str ? NULL : s;
}

static bool
name_is_valid (char const *name)
{
  char const *n;
  int i;
  bool is_valid = true;

  for (i = 0; i < ARRAY_SIZE (invalid_names); i++)
    {
      if (! invalid_names[i])
	break;
      if (! strcmp (invalid_names[i], name))
	return false;
    }

  is_valid = filename_is_safe (name);

  /* Allow any filename if we are in the filesystem root.  */
  if (! is_valid && cwd_is_root (name))
    is_valid = true;

  if (! is_valid)
    {
      say ("Ignoring potentially dangerous file name %s\n", quotearg (name));
      if (i < ARRAY_SIZE (invalid_names))
	invalid_names[i] = name;
    }
  return is_valid;
}

/* Determine what kind of diff is in the remaining part of the patch file. */

static enum diff
intuit_diff_type (bool need_header, mode_t *p_file_type)
{
    file_offset this_line = 0;
    file_offset first_command_line = -1;
    char first_ed_command_letter = 0;
    lin fcl_line = 0; /* Pacify 'gcc -W'.  */
    bool this_is_a_command = false;
    bool stars_this_line = false;
    bool extended_headers = false;
    enum nametype i;
    struct stat st[3];
    int stat_errno[3];
    int version_controlled[3];
    enum diff retval;
    mode_t file_type;

    for (i = OLD;  i <= INDEX;  i++)
      if (p_name[i]) {
	  free (p_name[i]);
	  p_name[i] = 0;
        }
    for (i = 0; i < ARRAY_SIZE (invalid_names); i++)
	invalid_names[i] = NULL;
    for (i = OLD; i <= NEW; i++)
      if (p_timestr[i])
	{
	  free(p_timestr[i]);
	  p_timestr[i] = 0;
	}
    for (i = OLD; i <= NEW; i++)
      if (p_sha1[i])
	{
	  free (p_sha1[i]);
	  p_sha1[i] = 0;
	}
    p_git_diff = false;
    for (i = OLD; i <= NEW; i++)
      {
	p_mode[i] = 0;
	p_copy[i] = false;
	p_rename[i] = false;
      }

    /* Ed and normal format patches don't have filename headers.  */
    if (diff_type == ED_DIFF || diff_type == NORMAL_DIFF)
      need_header = false;

    version_controlled[OLD] = -1;
    version_controlled[NEW] = -1;
    version_controlled[INDEX] = -1;
    p_rfc934_nesting = 0;
    p_timestamp[OLD].tv_sec = p_timestamp[NEW].tv_sec = -1;
    p_says_nonexistent[OLD] = p_says_nonexistent[NEW] = 0;
    Fseek (pfp, p_base, SEEK_SET);
    p_input_line = p_bline - 1;
    for (;;) {
	char *s;
	char *t;
	file_offset previous_line = this_line;
	bool last_line_was_command = this_is_a_command;
	bool stars_last_line = stars_this_line;
	size_t indent = 0;
	char ed_command_letter;
	bool strip_trailing_cr;
	size_t chars_read;

	this_line = file_tell (pfp);
	chars_read = pget_line (0, 0, false, false);
	if (chars_read == (size_t) -1)
	  xalloc_die ();
	if (! chars_read) {
	    if (first_ed_command_letter) {
					/* nothing but deletes!? */
		p_start = first_command_line;
		p_sline = fcl_line;
		retval = ED_DIFF;
		goto scan_exit;
	    }
	    else {
		p_start = this_line;
		p_sline = p_input_line;
		if (extended_headers)
		  {
		    /* Patch contains no hunks; any diff type will do. */
		    retval = UNI_DIFF;
		    goto scan_exit;
		  }
		return NO_DIFF;
	    }
	}
	strip_trailing_cr = 2 <= chars_read && buf[chars_read - 2] == '\r';
	for (s = buf; *s == ' ' || *s == '\t' || *s == 'X'; s++) {
	    if (*s == '\t')
		indent = (indent + 8) & ~7;
	    else
		indent++;
	}
	if (ISDIGIT (*s))
	  {
	    for (t = s + 1; ISDIGIT (*t) || *t == ',';  t++)
	      /* do nothing */ ;
	    if (*t == 'd' || *t == 'c' || *t == 'a')
	      {
		for (t++;  ISDIGIT (*t) || *t == ',';  t++)
		  /* do nothing */ ;
		for (; *t == ' ' || *t == '\t'; t++)
		  /* do nothing */ ;
		if (*t == '\r')
		  t++;
		this_is_a_command = (*t == '\n');
	      }
	  }
	if (! need_header
	    && first_command_line < 0
	    && ((ed_command_letter = get_ed_command_letter (s))
		|| this_is_a_command)) {
	    first_command_line = this_line;
	    first_ed_command_letter = ed_command_letter;
	    fcl_line = p_input_line;
	    p_indent = indent;		/* assume this for now */
	    p_strip_trailing_cr = strip_trailing_cr;
	}
	if (!stars_last_line && strnEQ(s, "*** ", 4))
	  {
	    fetchname (s+4, strippath, &p_name[OLD], &p_timestr[OLD],
		       &p_timestamp[OLD]);
	    need_header = false;
	  }
	else if (strnEQ(s, "+++ ", 4))
	  {
	    /* Swap with NEW below.  */
	    fetchname (s+4, strippath, &p_name[OLD], &p_timestr[OLD],
		       &p_timestamp[OLD]);
	    need_header = false;
	    p_strip_trailing_cr = strip_trailing_cr;
	  }
	else if (strnEQ(s, "Index:", 6))
	  {
	    fetchname (s+6, strippath, &p_name[INDEX], (char **) 0, NULL);
	    need_header = false;
	    p_strip_trailing_cr = strip_trailing_cr;
	  }
	else if (strnEQ(s, "Prereq:", 7))
	  {
	    for (t = s + 7;  ISSPACE ((unsigned char) *t);  t++)
	      /* do nothing */ ;
	    revision = t;
	    for (t = revision;  *t;  t++)
	      if (ISSPACE ((unsigned char) *t))
		{
		  char const *u;
		  for (u = t + 1;  ISSPACE ((unsigned char) *u);  u++)
		    /* do nothing */ ;
		  if (*u)
		    {
		      char numbuf[LINENUM_LENGTH_BOUND + 1];
		      say ("Prereq: with multiple words at line %s of patch\n",
			   format_linenum (numbuf, this_line));
		    }
		  break;
		}
	    if (t == revision)
		revision = 0;
	    else {
		char oldc = *t;
		*t = '\0';
		revision = xstrdup (revision);
		*t = oldc;
	    }
	  }
	else if (strnEQ (s, "diff --git ", 11))
	  {
	    char const *u;

	    if (extended_headers)
	      {
		p_start = this_line;
		p_sline = p_input_line;
		/* Patch contains no hunks; any diff type will do. */
		retval = UNI_DIFF;
		goto scan_exit;
	      }

	    for (i = OLD; i <= NEW; i++)
	      {
		free (p_name[i]);
		p_name[i] = 0;
	      }
	    if (! ((p_name[OLD] = parse_name (s + 11, strippath, &u))
		   && ISSPACE ((unsigned char) *u)
		   && (p_name[NEW] = parse_name (u, strippath, &u))
		   && (u = skip_spaces (u), ! *u)))
	      for (i = OLD; i <= NEW; i++)
		{
		  free (p_name[i]);
		  p_name[i] = 0;
		}
	    p_git_diff = true;
	  }
	else if (p_git_diff && strnEQ (s, "index ", 6))
	  {
	    char const *u, *v;
	    if ((u = skip_hex_digits (s + 6))
		&& u[0] == '.' && u[1] == '.'
		&& (v = skip_hex_digits (u + 2))
		&& (! *v || ISSPACE ((unsigned char) *v)))
	      {
		get_sha1(&p_sha1[OLD], s + 6, u);
		get_sha1(&p_sha1[NEW], u + 2, v);
		p_says_nonexistent[OLD] = sha1_says_nonexistent (p_sha1[OLD]);
		p_says_nonexistent[NEW] = sha1_says_nonexistent (p_sha1[NEW]);
		if (*(v = skip_spaces (v)))
		  p_mode[OLD] = p_mode[NEW] = fetchmode (v);
		extended_headers = true;
	      }
	  }
	else if (p_git_diff && strnEQ (s, "old mode ", 9))
	  {
	    p_mode[OLD] = fetchmode (s + 9);
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "new mode ", 9))
	  {
	    p_mode[NEW] = fetchmode (s + 9);
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "deleted file mode ", 18))
	  {
	    p_mode[OLD] = fetchmode (s + 18);
	    p_says_nonexistent[NEW] = 2;
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "new file mode ", 14))
	  {
	    p_mode[NEW] = fetchmode (s + 14);
	    p_says_nonexistent[OLD] = 2;
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "rename from ", 12))
	  {
	    /* Git leaves out the prefix in the file name in this header,
	       so we can only ignore the file name.  */
	    p_rename[OLD] = true;
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "rename to ", 10))
	  {
	    /* Git leaves out the prefix in the file name in this header,
	       so we can only ignore the file name.  */
	    p_rename[NEW] = true;
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "copy from ", 10))
	  {
	    /* Git leaves out the prefix in the file name in this header,
	       so we can only ignore the file name.  */
	    p_copy[OLD] = true;
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "copy to ", 8))
	  {
	    /* Git leaves out the prefix in the file name in this header,
	       so we can only ignore the file name.  */
	    p_copy[NEW] = true;
	    extended_headers = true;
	  }
	else if (p_git_diff && strnEQ (s, "GIT binary patch", 16))
	  {
	    p_start = this_line;
	    p_sline = p_input_line;
	    retval = GIT_BINARY_DIFF;
	    goto scan_exit;
	  }
	else
	  {
	    for (t = s;  t[0] == '-' && t[1] == ' ';  t += 2)
	      /* do nothing */ ;
	    if (strnEQ(t, "--- ", 4))
	      {
		struct timespec timestamp;
		timestamp.tv_sec = -1;
		fetchname (t+4, strippath, &p_name[NEW], &p_timestr[NEW],
			   &timestamp);
		need_header = false;
		if (timestamp.tv_sec != -1)
		  {
		    p_timestamp[NEW] = timestamp;
		    p_rfc934_nesting = (t - s) >> 1;
		  }
		p_strip_trailing_cr = strip_trailing_cr;
	      }
	  }
	if (need_header)
	  continue;
	if ((diff_type == NO_DIFF || diff_type == ED_DIFF) &&
	  first_command_line >= 0 &&
	  strEQ(s, ".\n") ) {
	    p_start = first_command_line;
	    p_sline = fcl_line;
	    retval = ED_DIFF;
	    goto scan_exit;
	}
	if ((diff_type == NO_DIFF || diff_type == UNI_DIFF)
	    && strnEQ(s, "@@ -", 4)) {

	    /* 'p_name', 'p_timestr', and 'p_timestamp' are backwards;
	       swap them.  */
	    struct timespec ti = p_timestamp[OLD];
	    p_timestamp[OLD] = p_timestamp[NEW];
	    p_timestamp[NEW] = ti;
	    t = p_name[OLD];
	    p_name[OLD] = p_name[NEW];
	    p_name[NEW] = t;
	    t = p_timestr[OLD];
	    p_timestr[OLD] = p_timestr[NEW];
	    p_timestr[NEW] = t;

	    s += 4;
	    if (s[0] == '0' && !ISDIGIT (s[1]))
	      p_says_nonexistent[OLD] = 1 + ! p_timestamp[OLD].tv_sec;
	    while (*s != ' ' && *s != '\n')
	      s++;
	    while (*s == ' ')
	      s++;
	    if (s[0] == '+' && s[1] == '0' && !ISDIGIT (s[2]))
	      p_says_nonexistent[NEW] = 1 + ! p_timestamp[NEW].tv_sec;
	    p_indent = indent;
	    p_start = this_line;
	    p_sline = p_input_line;
	    retval = UNI_DIFF;
	    if (! ((p_name[OLD] || ! p_timestamp[OLD].tv_sec)
		   && (p_name[NEW] || ! p_timestamp[NEW].tv_sec))
		&& ! p_name[INDEX] && need_header)
	      {
		char numbuf[LINENUM_LENGTH_BOUND + 1];
		say ("missing header for unified diff at line %s of patch\n",
		     format_linenum (numbuf, p_sline));
	      }
	    goto scan_exit;
	}
	stars_this_line = strnEQ(s, "********", 8);
	if ((diff_type == NO_DIFF
	     || diff_type == CONTEXT_DIFF
	     || diff_type == NEW_CONTEXT_DIFF)
	    && stars_last_line && strnEQ (s, "*** ", 4)) {
	    s += 4;
	    if (s[0] == '0' && !ISDIGIT (s[1]))
	      p_says_nonexistent[OLD] = 1 + ! p_timestamp[OLD].tv_sec;
	    /* if this is a new context diff the character just before */
	    /* the newline is a '*'. */
	    while (*s != '\n')
		s++;
	    p_indent = indent;
	    p_strip_trailing_cr = strip_trailing_cr;
	    p_start = previous_line;
	    p_sline = p_input_line - 1;
	    retval = (*(s-1) == '*' ? NEW_CONTEXT_DIFF : CONTEXT_DIFF);

	    {
	      /* Scan the first hunk to see whether the file contents
		 appear to have been deleted.  */
	      file_offset saved_p_base = p_base;
	      lin saved_p_bline = p_bline;
	      Fseek (pfp, previous_line, SEEK_SET);
	      p_input_line -= 2;
	      if (another_hunk (retval, false)
		  && ! p_repl_lines && p_newfirst == 1)
		p_says_nonexistent[NEW] = 1 + ! p_timestamp[NEW].tv_sec;
	      next_intuit_at (saved_p_base, saved_p_bline);
	    }

	    if (! ((p_name[OLD] || ! p_timestamp[OLD].tv_sec)
		   && (p_name[NEW] || ! p_timestamp[NEW].tv_sec))
		&& ! p_name[INDEX] && need_header)
	      {
		char numbuf[LINENUM_LENGTH_BOUND + 1];
		say ("missing header for context diff at line %s of patch\n",
		     format_linenum (numbuf, p_sline));
	      }
	    goto scan_exit;
	}
	if ((diff_type == NO_DIFF || diff_type == NORMAL_DIFF) &&
	  last_line_was_command &&
	  (strnEQ(s, "< ", 2) || strnEQ(s, "> ", 2)) ) {
	    p_start = previous_line;
	    p_sline = p_input_line - 1;
	    p_indent = indent;
	    retval = NORMAL_DIFF;
	    goto scan_exit;
	}
    }

  scan_exit:

    /* The old, new, or old and new file types may be defined.  When both
       file types are defined, make sure they are the same, or else assume
       we do not know the file type.  */
    file_type = p_mode[OLD] & S_IFMT;
    if (file_type)
      {
	mode_t new_file_type = p_mode[NEW] & S_IFMT;
	if (new_file_type && file_type != new_file_type)
	  file_type = 0;
      }
    else
      {
	file_type = p_mode[NEW] & S_IFMT;
	if (! file_type)
	  file_type = S_IFREG;
      }
    *p_file_type = file_type;

    /* To intuit 'inname', the name of the file to patch,
       use the algorithm specified by POSIX 1003.1-2001 XCU lines 25680-26599
       (with some modifications if posixly_correct is zero):

       - Take the old and new names from the context header if present,
	 and take the index name from the 'Index:' line if present and
	 if either the old and new names are both absent
	 or posixly_correct is nonzero.
	 Consider the file names to be in the order (old, new, index).
       - If some named files exist, use the first one if posixly_correct
	 is nonzero, the best one otherwise.
       - If patch_get is nonzero, and no named files exist,
	 but an RCS or SCCS master file exists,
	 use the first named file with an RCS or SCCS master.
       - If no named files exist, no RCS or SCCS master was found,
	 some names are given, posixly_correct is zero,
	 and the patch appears to create a file, then use the best name
	 requiring the creation of the fewest directories.
       - Otherwise, report failure by setting 'inname' to 0;
	 this causes our invoker to ask the user for a file name.  */

    i = NONE;

    if (!inname)
      {
	enum nametype i0 = NONE;

	if (! posixly_correct && (p_name[OLD] || p_name[NEW]) && p_name[INDEX])
	  {
	    free (p_name[INDEX]);
	    p_name[INDEX] = 0;
	  }

	for (i = OLD;  i <= INDEX;  i++)
	  if (p_name[i])
	    {
	      if (i0 != NONE && strcmp (p_name[i0], p_name[i]) == 0)
		{
		  /* It's the same name as before; reuse stat results.  */
		  stat_errno[i] = stat_errno[i0];
		  if (! stat_errno[i])
		    st[i] = st[i0];
		}
	      else
		{
		  stat_errno[i] = stat_file (p_name[i], &st[i]);
		  if (! stat_errno[i])
		    {
		      if (lookup_file_id (&st[i]) == DELETE_LATER)
			stat_errno[i] = ENOENT;
		      else if (posixly_correct && name_is_valid (p_name[i]))
			break;
		    }
		}
	      i0 = i;
	    }

	if (! posixly_correct)
	  {
	    /* The best of all existing files. */
	    i = best_name (p_name, stat_errno);

	    if (i == NONE && patch_get)
	      {
		enum nametype nope = NONE;

		for (i = OLD;  i <= INDEX;  i++)
		  if (p_name[i])
		    {
		      char const *cs;
		      char *getbuf;
		      char *diffbuf;
		      bool readonly = (outfile
				       && strcmp (outfile, p_name[i]) != 0);

		      if (nope == NONE || strcmp (p_name[nope], p_name[i]) != 0)
			{
			  cs = (version_controller
			        (p_name[i], readonly, (struct stat *) 0,
				 &getbuf, &diffbuf));
			  version_controlled[i] = !! cs;
			  if (cs)
			    {
			      if (version_get (p_name[i], cs, false, readonly,
					       getbuf, &st[i]))
				stat_errno[i] = 0;
			      else
				version_controlled[i] = 0;

			      free (getbuf);
			      free (diffbuf);

			      if (! stat_errno[i])
				break;
			    }
			}

		      nope = i;
		    }
	      }

	    if (i0 != NONE
		&& (i == NONE || (st[i].st_mode & S_IFMT) == file_type)
		&& maybe_reverse (p_name[i == NONE ? i0 : i], i == NONE,
				  i == NONE || st[i].st_size == 0)
		&& i == NONE)
	      i = i0;

	    if (i == NONE && p_says_nonexistent[reverse])
	      {
		int newdirs[3];
		int newdirs_min = INT_MAX;
		int distance_from_minimum[3];

		for (i = OLD;  i <= INDEX;  i++)
		  if (p_name[i])
		    {
		      newdirs[i] = (prefix_components (p_name[i], false)
				    - prefix_components (p_name[i], true));
		      if (newdirs[i] < newdirs_min)
			newdirs_min = newdirs[i];
		    }

		for (i = OLD;  i <= INDEX;  i++)
		  if (p_name[i])
		    distance_from_minimum[i] = newdirs[i] - newdirs_min;

		/* The best of the filenames which create the fewest directories. */
		i = best_name (p_name, distance_from_minimum);
	      }
	  }
      }

    if ((pch_rename () || pch_copy ())
	&& ! inname
	&& ! ((i == OLD || i == NEW) &&
	      p_name[! reverse] &&
	      name_is_valid (p_name[! reverse])))
      {
	say ("Cannot %s file without two valid file names\n", pch_rename () ? "rename" : "copy");
	skip_rest_of_patch = true;
      }

    if (i == NONE)
      {
	if (inname)
	  {
	    inerrno = stat_file (inname, &instat);
	    if (inerrno || (instat.st_mode & S_IFMT) == file_type)
	      maybe_reverse (inname, inerrno, inerrno || instat.st_size == 0);
	  }
	else
          inerrno = -1;
      }
    else
      {
	inname = xstrdup (p_name[i]);
	inerrno = stat_errno[i];
	invc = version_controlled[i];
	instat = st[i];
      }

    return retval;
}

/* Count the path name components in FILENAME's prefix.
   If CHECKDIRS is true, count only existing directories.  */
static int
prefix_components (char *filename, bool checkdirs)
{
  int count = 0;
  struct stat stat_buf;
  int stat_result;
  char *f = filename + FILE_SYSTEM_PREFIX_LEN (filename);

  if (*f)
    while (*++f)
      if (ISSLASH (f[0]) && ! ISSLASH (f[-1]))
	{
	  if (checkdirs)
	    {
	      *f = '\0';
	      stat_result = stat (filename, &stat_buf);
	      *f = '/';
	      if (! (stat_result == 0 && S_ISDIR (stat_buf.st_mode)))
		break;
	    }

	  count++;
	}

  return count;
}

/* Return the index of the best of NAME[OLD], NAME[NEW], and NAME[INDEX].
   Ignore null names, and ignore NAME[i] if IGNORE[i] is nonzero.
   Return NONE if all names are ignored.  */
static enum nametype
best_name (char *const *name, int const *ignore)
{
  enum nametype i;
  int components[3];
  int components_min = INT_MAX;
  size_t basename_len[3];
  size_t basename_len_min = SIZE_MAX;
  size_t len[3];
  size_t len_min = SIZE_MAX;

  for (i = OLD;  i <= INDEX;  i++)
    if (name[i] && !ignore[i])
      {
	/* Take the names with the fewest prefix components.  */
	components[i] = prefix_components (name[i], false);
	if (components_min < components[i])
	  continue;
	components_min = components[i];

	/* Of those, take the names with the shortest basename.  */
	basename_len[i] = base_len (name[i]);
	if (basename_len_min < basename_len[i])
	  continue;
	basename_len_min = basename_len[i];

	/* Of those, take the shortest names.  */
	len[i] = strlen (name[i]);
	if (len_min < len[i])
	  continue;
	len_min = len[i];
      }

  /* Of those, take the first name.  */
  for (i = OLD;  i <= INDEX;  i++)
    if (name[i] && !ignore[i]
	&& name_is_valid (name[i])
	&& components[i] == components_min
	&& basename_len[i] == basename_len_min
	&& len[i] == len_min)
      break;

  return i;
}

/* Remember where this patch ends so we know where to start up again. */

static void
next_intuit_at (file_offset file_pos, lin file_line)
{
    p_base = file_pos;
    p_bline = file_line;
}

/* Basically a verbose fseek() to the actual diff listing. */

static void
skip_to (file_offset file_pos, lin file_line)
{
    FILE *i = pfp;
    FILE *o = stdout;
    int c;

    assert(p_base <= file_pos);
    if ((verbosity == VERBOSE || !inname) && p_base < file_pos) {
	Fseek (i, p_base, SEEK_SET);
	say ("The text leading up to this was:\n--------------------------\n");

	while (file_tell (i) < file_pos)
	  {
	    putc ('|', o);
	    do
	      {
		if ((c = getc (i)) == EOF)
		  read_fatal ();
		putc (c, o);
	      }
	    while (c != '\n');
	  }

	say ("--------------------------\n");
    }
    else
	Fseek (i, file_pos, SEEK_SET);
    p_input_line = file_line - 1;
}

/* Make this a function for better debugging.  */
static void
malformed (void)
{
    char numbuf[LINENUM_LENGTH_BOUND + 1];
    fatal ("malformed patch at line %s: %s",
	   format_linenum (numbuf, p_input_line), buf);
		/* about as informative as "Syntax error" in C */
}

/* Parse a line number from a string.
   Return the address of the first char after the number.  */
static char *
scan_linenum (char *s0, lin *linenum)
{
  char *s;
  lin n = 0;
  bool overflow = false;
  char numbuf[LINENUM_LENGTH_BOUND + 1];

  for (s = s0;  ISDIGIT (*s);  s++)
    {
      lin new_n = 10 * n + (*s - '0');
      overflow |= new_n / 10 != n;
      n = new_n;
    }

  if (s == s0)
    fatal ("missing line number at line %s: %s",
	   format_linenum (numbuf, p_input_line), buf);

  if (overflow)
    fatal ("line number %.*s is too large at line %s: %s",
	   (int) (s - s0), s0, format_linenum (numbuf, p_input_line), buf);

  *linenum = n;
  return s;
}

/* 1 if there is more of the current diff listing to process;
   0 if not; -1 if ran out of memory. */

int
another_hunk (enum diff difftype, bool rev)
{
    char *s;
    lin context = 0;
    size_t chars_read;
    char numbuf0[LINENUM_LENGTH_BOUND + 1];
    char numbuf1[LINENUM_LENGTH_BOUND + 1];
    char numbuf2[LINENUM_LENGTH_BOUND + 1];
    char numbuf3[LINENUM_LENGTH_BOUND + 1];

    set_hunkmax();

    while (p_end >= 0) {
	if (p_end == p_efake)
	    p_end = p_bfake;		/* don't free twice */
	else
	    free(p_line[p_end]);
	p_end--;
    }
    assert(p_end == -1);
    p_efake = -1;

    if (p_c_function)
      {
	free (p_c_function);
	p_c_function = NULL;
      }

    p_max = hunkmax;			/* gets reduced when --- found */
    if (difftype == CONTEXT_DIFF || difftype == NEW_CONTEXT_DIFF) {
	file_offset line_beginning = file_tell (pfp);
					/* file pos of the current line */
	lin repl_beginning = 0;		/* index of --- line */
	lin fillcnt = 0;	/* #lines of missing ptrn or repl */
	lin fillsrc;		/* index of first line to copy */
	lin filldst;		/* index of first missing line */
	bool ptrn_spaces_eaten = false;	/* ptrn was slightly misformed */
	bool some_context = false;	/* (perhaps internal) context seen */
	bool repl_could_be_missing = true;
	bool ptrn_missing = false;	/* The pattern was missing.  */
	bool repl_missing = false;	/* Likewise for replacement.  */
	file_offset repl_backtrack_position = 0;
					/* file pos of first repl line */
	lin repl_patch_line;		/* input line number for same */
	lin repl_context;		/* context for same */
	lin ptrn_prefix_context = -1;	/* lines in pattern prefix context */
	lin ptrn_suffix_context = -1;	/* lines in pattern suffix context */
	lin repl_prefix_context = -1;	/* lines in replac. prefix context */
	lin ptrn_copiable = 0;		/* # of copiable lines in ptrn */
	lin repl_copiable = 0;		/* Likewise for replacement.  */

	/* Pacify 'gcc -Wall'.  */
	fillsrc = filldst = repl_patch_line = repl_context = 0;

	chars_read = get_line ();
	if (chars_read == (size_t) -1
	    || chars_read <= 8
	    || strncmp (buf, "********", 8) != 0) {
	    next_intuit_at(line_beginning,p_input_line);
	    return chars_read == (size_t) -1 ? -1 : 0;
	}
	s = buf;
	while (*s == '*')
	    s++;
	if (*s == ' ')
	  {
	    p_c_function = s;
	    while (*s != '\n')
		s++;
	    *s = '\0';
	    p_c_function = savestr (p_c_function);
	    if (! p_c_function)
	      return -1;
	  }
	p_hunk_beg = p_input_line + 1;
	while (p_end < p_max) {
	    chars_read = get_line ();
	    if (chars_read == (size_t) -1)
	      return -1;
	    if (!chars_read) {
		if (repl_beginning && repl_could_be_missing) {
		    repl_missing = true;
		    goto hunk_done;
		}
		if (p_max - p_end < 4) {
		    strcpy (buf, "  \n");  /* assume blank lines got chopped */
		    chars_read = 3;
		} else {
		    fatal ("unexpected end of file in patch");
		}
	    }
	    p_end++;
	    if (p_end == hunkmax)
	      fatal ("unterminated hunk starting at line %s; giving up at line %s: %s",
		     format_linenum (numbuf0, pch_hunk_beg ()),
		     format_linenum (numbuf1, p_input_line), buf);
	    assert(p_end < hunkmax);
	    p_Char[p_end] = *buf;
	    p_len[p_end] = 0;
	    p_line[p_end] = 0;
	    switch (*buf) {
	    case '*':
		if (strnEQ(buf, "********", 8)) {
		    if (repl_beginning && repl_could_be_missing) {
			repl_missing = true;
			goto hunk_done;
		    }
		    else
		      fatal ("unexpected end of hunk at line %s",
			     format_linenum (numbuf0, p_input_line));
		}
		if (p_end != 0) {
		    if (repl_beginning && repl_could_be_missing) {
			repl_missing = true;
			goto hunk_done;
		    }
		    fatal ("unexpected '***' at line %s: %s",
			   format_linenum (numbuf0, p_input_line), buf);
		}
		context = 0;
		p_len[p_end] = strlen (buf);
		if (! (p_line[p_end] = savestr (buf))) {
		    p_end--;
		    return -1;
		}
		for (s = buf;  *s && !ISDIGIT (*s);  s++)
		  /* do nothing */ ;
		if (strnEQ(s,"0,0",3))
		    remove_prefix (s, 2);
		s = scan_linenum (s, &p_first);
		if (*s == ',') {
		    while (*s && !ISDIGIT (*s))
		      s++;
		    scan_linenum (s, &p_ptrn_lines);
		    p_ptrn_lines += 1 - p_first;
		    if (p_ptrn_lines < 0)
		      malformed ();
		}
		else if (p_first)
		    p_ptrn_lines = 1;
		else {
		    p_ptrn_lines = 0;
		    p_first = 1;
		}
		if (p_first >= LINENUM_MAX - p_ptrn_lines ||
		    p_ptrn_lines >= LINENUM_MAX - 6)
		  malformed ();
		p_max = p_ptrn_lines + 6;	/* we need this much at least */
		while (p_max + 1 >= hunkmax)
		    if (! grow_hunkmax ())
			return -1;
		p_max = hunkmax;
		break;
	    case '-':
		if (buf[1] != '-')
		  goto change_line;
		if (ptrn_prefix_context == -1)
		  ptrn_prefix_context = context;
		ptrn_suffix_context = context;
		if (repl_beginning
		    || (p_end
			!= p_ptrn_lines + 1 + (p_Char[p_end - 1] == '\n')))
		  {
		    if (p_end == 1)
		      {
			/* 'Old' lines were omitted.  Set up to fill
			   them in from 'new' context lines.  */
			ptrn_missing = true;
			p_end = p_ptrn_lines + 1;
			ptrn_prefix_context = ptrn_suffix_context = -1;
			fillsrc = p_end + 1;
			filldst = 1;
			fillcnt = p_ptrn_lines;
		      }
		    else if (! repl_beginning)
		      fatal ("%s '---' at line %s; check line numbers at line %s",
			     (p_end <= p_ptrn_lines
			      ? "Premature"
			      : "Overdue"),
			     format_linenum (numbuf0, p_input_line),
			     format_linenum (numbuf1, p_hunk_beg));
		    else if (! repl_could_be_missing)
		      fatal ("duplicate '---' at line %s; check line numbers at line %s",
			     format_linenum (numbuf0, p_input_line),
			     format_linenum (numbuf1,
					     p_hunk_beg + repl_beginning));
		    else
		      {
			repl_missing = true;
			goto hunk_done;
		      }
		  }
		repl_beginning = p_end;
		repl_backtrack_position = file_tell (pfp);
		repl_patch_line = p_input_line;
		repl_context = context;
		p_len[p_end] = strlen (buf);
		if (! (p_line[p_end] = savestr (buf)))
		  {
		    p_end--;
		    return -1;
		  }
		p_Char[p_end] = '=';
		for (s = buf;  *s && ! ISDIGIT (*s);  s++)
		  /* do nothing */ ;
		s = scan_linenum (s, &p_newfirst);
		if (*s == ',')
		  {
		    do
		      {
			if (!*++s)
			  malformed ();
		      }
		    while (! ISDIGIT (*s));
		    scan_linenum (s, &p_repl_lines);
		    p_repl_lines += 1 - p_newfirst;
		    if (p_repl_lines < 0)
		      malformed ();
		  }
		else if (p_newfirst)
		  p_repl_lines = 1;
		else
		  {
		    p_repl_lines = 0;
		    p_newfirst = 1;
		  }
		if (p_newfirst >= LINENUM_MAX - p_repl_lines ||
		    p_repl_lines >= LINENUM_MAX - p_end)
		  malformed ();
		p_max = p_repl_lines + p_end;
		while (p_max + 1 >= hunkmax)
		  if (! grow_hunkmax ())
		    return -1;
		if (p_repl_lines != ptrn_copiable
		    && (p_prefix_context != 0
			|| context != 0
			|| p_repl_lines != 1))
		  repl_could_be_missing = false;
		context = 0;
		break;
	    case '+':  case '!':
		repl_could_be_missing = false;
	      change_line:
		s = buf + 1;
		chars_read--;
		if (*s == '\n' && canonicalize) {
		    strcpy (s, " \n");
		    chars_read = 2;
		}
		if (*s == ' ' || *s == '\t') {
		    s++;
		    chars_read--;
		} else if (repl_beginning && repl_could_be_missing) {
		    repl_missing = true;
		    goto hunk_done;
		}
		if (! repl_beginning)
		  {
		    if (ptrn_prefix_context == -1)
		      ptrn_prefix_context = context;
		  }
		else
		  {
		    if (repl_prefix_context == -1)
		      repl_prefix_context = context;
		  }
		chars_read -=
		  (1 < chars_read
		   && p_end == (repl_beginning ? p_max : p_ptrn_lines)
		   && incomplete_line ());
		p_len[p_end] = chars_read;
		p_line[p_end] = savebuf (s, chars_read);
		if (chars_read && ! p_line[p_end]) {
		    p_end--;
		    return -1;
	        }
		context = 0;
		break;
	    case '\t': case '\n':	/* assume spaces got eaten */
		s = buf;
		if (*buf == '\t') {
		    s++;
		    chars_read--;
		}
		if (repl_beginning && repl_could_be_missing &&
		    (!ptrn_spaces_eaten || difftype == NEW_CONTEXT_DIFF) ) {
		    repl_missing = true;
		    goto hunk_done;
		}
		chars_read -=
		  (1 < chars_read
		   && p_end == (repl_beginning ? p_max : p_ptrn_lines)
		   && incomplete_line ());
		p_len[p_end] = chars_read;
		p_line[p_end] = savebuf (buf, chars_read);
		if (chars_read && ! p_line[p_end]) {
		    p_end--;
		    return -1;
		}
		if (p_end != p_ptrn_lines + 1) {
		    ptrn_spaces_eaten |= (repl_beginning != 0);
		    some_context = true;
		    context++;
		    if (repl_beginning)
			repl_copiable++;
		    else
			ptrn_copiable++;
		    p_Char[p_end] = ' ';
		}
		break;
	    case ' ':
		s = buf + 1;
		chars_read--;
		if (*s == '\n' && canonicalize) {
		    strcpy (s, "\n");
		    chars_read = 2;
		}
		if (*s == ' ' || *s == '\t') {
		    s++;
		    chars_read--;
		} else if (repl_beginning && repl_could_be_missing) {
		    repl_missing = true;
		    goto hunk_done;
		}
		some_context = true;
		context++;
		if (repl_beginning)
		    repl_copiable++;
		else
		    ptrn_copiable++;
		chars_read -=
		  (1 < chars_read
		   && p_end == (repl_beginning ? p_max : p_ptrn_lines)
		   && incomplete_line ());
		p_len[p_end] = chars_read;
		p_line[p_end] = savebuf (s, chars_read);
		if (chars_read && ! p_line[p_end]) {
		    p_end--;
		    return -1;
		}
		break;
	    default:
		if (repl_beginning && repl_could_be_missing) {
		    repl_missing = true;
		    goto hunk_done;
		}
		malformed ();
	    }
	}

    hunk_done:
	if (p_end >=0 && !repl_beginning)
	  fatal ("no '---' found in patch at line %s",
		 format_linenum (numbuf0, pch_hunk_beg ()));

	if (repl_missing) {

	    /* reset state back to just after --- */
	    p_input_line = repl_patch_line;
	    context = repl_context;
	    for (p_end--; p_end > repl_beginning; p_end--)
		free(p_line[p_end]);
	    Fseek (pfp, repl_backtrack_position, SEEK_SET);

	    /* redundant 'new' context lines were omitted - set */
	    /* up to fill them in from the old file context */
	    fillsrc = 1;
	    filldst = repl_beginning+1;
	    fillcnt = p_repl_lines;
	    p_end = p_max;
	}
	else if (! ptrn_missing && ptrn_copiable != repl_copiable)
	  fatal ("context mangled in hunk at line %s",
		 format_linenum (numbuf0, p_hunk_beg));
	else if (!some_context && fillcnt == 1) {
	    /* the first hunk was a null hunk with no context */
	    /* and we were expecting one line -- fix it up. */
	    while (filldst < p_end) {
		p_line[filldst] = p_line[filldst+1];
		p_Char[filldst] = p_Char[filldst+1];
		p_len[filldst] = p_len[filldst+1];
		filldst++;
	    }
#if 0
	    repl_beginning--;		/* this doesn't need to be fixed */
#endif
	    p_end--;
	    p_first++;			/* do append rather than insert */
	    fillcnt = 0;
	    p_ptrn_lines = 0;
	}

	p_prefix_context = ((repl_prefix_context == -1
			     || (ptrn_prefix_context != -1
				 && ptrn_prefix_context < repl_prefix_context))
			    ? ptrn_prefix_context : repl_prefix_context);
	p_suffix_context = ((ptrn_suffix_context != -1
			     && ptrn_suffix_context < context)
			    ? ptrn_suffix_context : context);
	if (p_prefix_context == -1 || p_suffix_context == -1)
	    fatal ("replacement text or line numbers mangled in hunk at line %s",
		   format_linenum (numbuf0, p_hunk_beg));

	if (difftype == CONTEXT_DIFF
	    && (fillcnt
		|| (p_first > 1
		    && p_prefix_context + p_suffix_context < ptrn_copiable))) {
	    if (verbosity == VERBOSE)
		say ("%s\n%s\n%s\n",
"(Fascinating -- this is really a new-style context diff but without",
"the telltale extra asterisks on the *** line that usually indicate",
"the new style...)");
	    diff_type = difftype = NEW_CONTEXT_DIFF;
	}

	/* if there were omitted context lines, fill them in now */
	if (fillcnt) {
	    p_bfake = filldst;		/* remember where not to free() */
	    p_efake = filldst + fillcnt - 1;
	    while (fillcnt-- > 0) {
		while (fillsrc <= p_end && fillsrc != repl_beginning
		       && p_Char[fillsrc] != ' ')
		    fillsrc++;
		if (p_end < fillsrc || fillsrc == repl_beginning)
		  {
		    fatal ("replacement text or line numbers mangled in hunk at line %s",
			   format_linenum (numbuf0, p_hunk_beg));
		  }
		p_line[filldst] = p_line[fillsrc];
		p_Char[filldst] = p_Char[fillsrc];
		p_len[filldst] = p_len[fillsrc];
		fillsrc++; filldst++;
	    }
	    while (fillsrc <= p_end && fillsrc != repl_beginning)
	      {
		if (p_Char[fillsrc] == ' ')
		  fatal ("replacement text or line numbers mangled in hunk at line %s",
			 format_linenum (numbuf0, p_hunk_beg));
		fillsrc++;
	      }
	    if (debug & 64)
	      printf ("fillsrc %s, filldst %s, rb %s, e+1 %s\n",
		      format_linenum (numbuf0, fillsrc),
		      format_linenum (numbuf1, filldst),
		      format_linenum (numbuf2, repl_beginning),
		      format_linenum (numbuf3, p_end + 1));
	    assert(fillsrc==p_end+1 || fillsrc==repl_beginning);
	    assert(filldst==p_end+1 || filldst==repl_beginning);
	}
    }
    else if (difftype == UNI_DIFF) {
	file_offset line_beginning = file_tell (pfp);  /* file pos of the current line */
	lin fillsrc;  /* index of old lines */
	lin filldst;  /* index of new lines */
	char ch = '\0';

	chars_read = get_line ();
	if (chars_read == (size_t) -1
	    || chars_read <= 4
	    || strncmp (buf, "@@ -", 4) != 0) {
	    next_intuit_at(line_beginning,p_input_line);
	    return chars_read == (size_t) -1 ? -1 : 0;
	}
	s = scan_linenum (buf + 4, &p_first);
	if (*s == ',')
	    s = scan_linenum (s + 1, &p_ptrn_lines);
	else
	    p_ptrn_lines = 1;
	if (p_first >= LINENUM_MAX - p_ptrn_lines)
	  malformed ();
	if (*s == ' ') s++;
	if (*s != '+')
	    malformed ();
	s = scan_linenum (s + 1, &p_newfirst);
	if (*s == ',')
	    s = scan_linenum (s + 1, &p_repl_lines);
	else
	    p_repl_lines = 1;
	if (p_newfirst >= LINENUM_MAX - p_repl_lines)
	  malformed ();
	if (*s == ' ') s++;
	if (*s++ != '@')
	    malformed ();
	if (*s++ == '@' && *s == ' ')
	  {
	    p_c_function = s;
	    while (*s != '\n')
		s++;
	    *s = '\0';
	    p_c_function = savestr (p_c_function);
	    if (! p_c_function)
	      return -1;
	  }
	if (!p_ptrn_lines)
	    p_first++;			/* do append rather than insert */
	if (!p_repl_lines)
	    p_newfirst++;
	if (p_ptrn_lines >= LINENUM_MAX - (p_repl_lines + 1))
	  malformed ();
	p_max = p_ptrn_lines + p_repl_lines + 1;
	while (p_max + 1 >= hunkmax)
	    if (! grow_hunkmax ())
		return -1;
	fillsrc = 1;
	filldst = fillsrc + p_ptrn_lines;
	p_end = filldst + p_repl_lines;
	sprintf (buf, "*** %s,%s ****\n",
		 format_linenum (numbuf0, p_first),
		 format_linenum (numbuf1, p_first + p_ptrn_lines - 1));
	p_len[0] = strlen (buf);
	if (! (p_line[0] = savestr (buf))) {
	    p_end = -1;
	    return -1;
	}
	p_Char[0] = '*';
	sprintf (buf, "--- %s,%s ----\n",
		 format_linenum (numbuf0, p_newfirst),
		 format_linenum (numbuf1, p_newfirst + p_repl_lines - 1));
	p_len[filldst] = strlen (buf);
	if (! (p_line[filldst] = savestr (buf))) {
	    p_end = 0;
	    return -1;
	}
	p_Char[filldst++] = '=';
	p_prefix_context = -1;
	p_hunk_beg = p_input_line + 1;
	while (fillsrc <= p_ptrn_lines || filldst <= p_end) {
	    chars_read = get_line ();
	    if (!chars_read) {
		if (p_max - filldst < 3) {
		    strcpy (buf, " \n");  /* assume blank lines got chopped */
		    chars_read = 2;
		} else {
		    fatal ("unexpected end of file in patch");
		}
	    }
	    if (chars_read == (size_t) -1)
		s = 0;
	    else if (*buf == '\t' || *buf == '\n') {
		ch = ' ';		/* assume the space got eaten */
		s = savebuf (buf, chars_read);
	    }
	    else {
		ch = *buf;
		s = savebuf (buf+1, --chars_read);
	    }
	    if (chars_read && ! s)
	      {
		while (--filldst > p_ptrn_lines)
		    free(p_line[filldst]);
		p_end = fillsrc-1;
		return -1;
	      }
	    switch (ch) {
	    case '-':
		if (fillsrc > p_ptrn_lines) {
		    free(s);
		    p_end = filldst-1;
		    malformed ();
		}
		chars_read -= fillsrc == p_ptrn_lines && incomplete_line ();
		p_Char[fillsrc] = ch;
		p_line[fillsrc] = s;
		p_len[fillsrc++] = chars_read;
		break;
	    case '=':
		ch = ' ';
		/* FALL THROUGH */
	    case ' ':
		if (fillsrc > p_ptrn_lines) {
		    free(s);
		    while (--filldst > p_ptrn_lines)
			free(p_line[filldst]);
		    p_end = fillsrc-1;
		    malformed ();
		}
		context++;
		chars_read -= fillsrc == p_ptrn_lines && incomplete_line ();
		p_Char[fillsrc] = ch;
		p_line[fillsrc] = s;
		p_len[fillsrc++] = chars_read;
		s = savebuf (s, chars_read);
		if (chars_read && ! s) {
		    while (--filldst > p_ptrn_lines)
			free(p_line[filldst]);
		    p_end = fillsrc-1;
		    return -1;
		}
		/* FALL THROUGH */
	    case '+':
		if (filldst > p_end) {
		    free(s);
		    while (--filldst > p_ptrn_lines)
			free(p_line[filldst]);
		    p_end = fillsrc-1;
		    malformed ();
		}
		chars_read -= filldst == p_end && incomplete_line ();
		p_Char[filldst] = ch;
		p_line[filldst] = s;
		p_len[filldst++] = chars_read;
		break;
	    default:
		p_end = filldst;
		malformed ();
	    }
	    if (ch != ' ') {
		if (p_prefix_context == -1)
		    p_prefix_context = context;
		context = 0;
	    }
	}/* while */
	if (p_prefix_context == -1)
	  malformed ();
	p_suffix_context = context;
    }
    else {				/* normal diff--fake it up */
	char hunk_type;
	int i;
	lin min, max;
	file_offset line_beginning = file_tell (pfp);

	p_prefix_context = p_suffix_context = 0;
	chars_read = get_line ();
	if (chars_read == (size_t) -1 || !chars_read || !ISDIGIT (*buf)) {
	    next_intuit_at(line_beginning,p_input_line);
	    return chars_read == (size_t) -1 ? -1 : 0;
	}
	s = scan_linenum (buf, &p_first);
	if (*s == ',') {
	    s = scan_linenum (s + 1, &p_ptrn_lines);
	    p_ptrn_lines += 1 - p_first;
	}
	else
	    p_ptrn_lines = (*s != 'a');
	if (p_first >= LINENUM_MAX - p_ptrn_lines)
	  malformed ();
	hunk_type = *s;
	if (hunk_type == 'a')
	    p_first++;			/* do append rather than insert */
	s = scan_linenum (s + 1, &min);
	if (*s == ',')
	    scan_linenum (s + 1, &max);
	else
	    max = min;
	if (min > max || max - min == LINENUM_MAX)
	  malformed ();
	if (hunk_type == 'd')
	    min++;
	p_newfirst = min;
	p_repl_lines = max - min + 1;
	if (p_newfirst >= LINENUM_MAX - p_repl_lines)
	  malformed ();
	if (p_ptrn_lines >= LINENUM_MAX - (p_repl_lines + 1))
	  malformed ();
	p_end = p_ptrn_lines + p_repl_lines + 1;
	while (p_end + 1 >= hunkmax)
	  if (! grow_hunkmax ())
	    {
	      p_end = -1;
	      return -1;
	    }
	sprintf (buf, "*** %s,%s\n",
		 format_linenum (numbuf0, p_first),
		 format_linenum (numbuf1, p_first + p_ptrn_lines - 1));
	p_len[0] = strlen (buf);
	if (! (p_line[0] = savestr (buf))) {
	    p_end = -1;
	    return -1;
	}
	p_Char[0] = '*';
	for (i=1; i<=p_ptrn_lines; i++) {
	    chars_read = get_line ();
	    if (chars_read == (size_t) -1)
	      {
		p_end = i - 1;
		return -1;
	      }
	    if (!chars_read)
	      fatal ("unexpected end of file in patch at line %s",
		     format_linenum (numbuf0, p_input_line));
	    if (buf[0] != '<' || (buf[1] != ' ' && buf[1] != '\t'))
	      fatal ("'<' expected at line %s of patch",
		     format_linenum (numbuf0, p_input_line));
	    chars_read -= 2 + (i == p_ptrn_lines && incomplete_line ());
	    p_len[i] = chars_read;
	    p_line[i] = savebuf (buf + 2, chars_read);
	    if (chars_read && ! p_line[i]) {
		p_end = i-1;
		return -1;
	    }
	    p_Char[i] = '-';
	}
	if (hunk_type == 'c') {
	    chars_read = get_line ();
	    if (chars_read == (size_t) -1)
	      {
		p_end = i - 1;
		return -1;
	      }
	    if (! chars_read)
	      fatal ("unexpected end of file in patch at line %s",
		     format_linenum (numbuf0, p_input_line));
	    if (*buf != '-')
	      fatal ("'---' expected at line %s of patch",
		     format_linenum (numbuf0, p_input_line));
	}
	sprintf (buf, "--- %s,%s\n",
		 format_linenum (numbuf0, min),
		 format_linenum (numbuf1, max));
	p_len[i] = strlen (buf);
	if (! (p_line[i] = savestr (buf))) {
	    p_end = i-1;
	    return -1;
	}
	p_Char[i] = '=';
	for (i++; i<=p_end; i++) {
	    chars_read = get_line ();
	    if (chars_read == (size_t) -1)
	      {
		p_end = i - 1;
		return -1;
	      }
	    if (!chars_read)
	      fatal ("unexpected end of file in patch at line %s",
		     format_linenum (numbuf0, p_input_line));
	    if (buf[0] != '>' || (buf[1] != ' ' && buf[1] != '\t'))
	      fatal ("'>' expected at line %s of patch",
		     format_linenum (numbuf0, p_input_line));
	    chars_read -= 2 + (i == p_end && incomplete_line ());
	    p_len[i] = chars_read;
	    p_line[i] = savebuf (buf + 2, chars_read);
	    if (chars_read && ! p_line[i]) {
		p_end = i-1;
		return -1;
	    }
	    p_Char[i] = '+';
	}
    }
    if (rev)				/* backwards patch? */
	if (!pch_swap())
	    say ("Not enough memory to swap next hunk!\n");
    assert (p_end + 1 < hunkmax);
    p_Char[p_end + 1] = '^';  /* add a stopper for apply_hunk */
    if (debug & 2) {
	lin i;

	for (i = 0; i <= p_end + 1; i++) {
	    fprintf (stderr, "%s %c",
		     format_linenum (numbuf0, i),
		     p_Char[i]);
	    if (p_Char[i] == '*')
	      fprintf (stderr, " %s,%s\n",
		       format_linenum (numbuf0, p_first),
		       format_linenum (numbuf1, p_ptrn_lines));
	    else if (p_Char[i] == '=')
	      fprintf (stderr, " %s,%s\n",
		       format_linenum (numbuf0, p_newfirst),
		       format_linenum (numbuf1, p_repl_lines));
	    else if (p_Char[i] != '^')
	      {
		fputs(" |", stderr);
		pch_write_line (i, stderr);
	      }
	    else
	      fputc('\n', stderr);
	}
	fflush (stderr);
    }
    return 1;
}

static size_t
get_line (void)
{
   return pget_line (p_indent, p_rfc934_nesting, p_strip_trailing_cr,
		     p_pass_comments_through);
}

/* Input a line from the patch file, worrying about indentation.
   Strip up to INDENT characters' worth of leading indentation.
   Then remove up to RFC934_NESTING instances of leading "- ".
   If STRIP_TRAILING_CR is true, remove any trailing carriage-return.
   Unless PASS_COMMENTS_THROUGH is true, ignore any resulting lines
   that begin with '#'; they're comments.
   Ignore any partial lines at end of input, but warn about them.
   Succeed if a line was read; it is terminated by "\n\0" for convenience.
   Return the number of characters read, including '\n' but not '\0'.
   Return -1 if we ran out of memory.  */

static size_t
pget_line (size_t indent, int rfc934_nesting, bool strip_trailing_cr,
	   bool pass_comments_through)
{
  FILE *fp = pfp;
  int c;
  size_t i;
  char *b;
  size_t s;

  do
    {
      i = 0;
      for (;;)
	{
	  c = getc (fp);
	  if (c == EOF)
	    {
	      if (ferror (fp))
		read_fatal ();
	      return 0;
	    }
	  if (indent <= i)
	    break;
	  if (c == ' ' || c == 'X')
	    i++;
	  else if (c == '\t')
	    i = (i + 8) & ~7;
	  else
	    break;
	}

      i = 0;
      b = buf;

      while (c == '-' && 0 <= --rfc934_nesting)
	{
	  c = getc (fp);
	  if (c == EOF)
	    goto patch_ends_in_middle_of_line;
	  if (c != ' ')
	    {
	      i = 1;
	      b[0] = '-';
	      break;
	    }
	  c = getc (fp);
	  if (c == EOF)
	    goto patch_ends_in_middle_of_line;
	}

      s = bufsize;

      for (;;)
	{
	  if (i == s - 1)
	    {
	      s *= 2;
	      b = realloc (b, s);
	      if (!b)
		{
		  if (!using_plan_a)
		    xalloc_die ();
		  return (size_t) -1;
		}
	      buf = b;
	      bufsize = s;
	    }
	  b[i++] = c;
	  if (c == '\n')
	    break;
	  c = getc (fp);
	  if (c == EOF)
	    goto patch_ends_in_middle_of_line;
	}

      p_input_line++;
    }
  while (*b == '#' && !pass_comments_through);

  if (strip_trailing_cr && 2 <= i && b[i - 2] == '\r')
    b[i-- - 2] = '\n';
  b[i] = '\0';
  return i;

 patch_ends_in_middle_of_line:
  if (ferror (fp))
    read_fatal ();
  say ("patch unexpectedly ends in middle of line\n");
  return 0;
}

static bool
incomplete_line (void)
{
  FILE *fp = pfp;
  int c;
  file_offset line_beginning = file_tell (fp);

  if (getc (fp) == '\\')
    {
      while ((c = getc (fp)) != '\n'  &&  c != EOF)
	/* do nothing */ ;
      return true;
    }
  else
    {
      /* We don't trust ungetc.  */
      Fseek (pfp, line_beginning, SEEK_SET);
      return false;
    }
}

/* Reverse the old and new portions of the current hunk. */

bool
pch_swap (void)
{
    char **tp_line;		/* the text of the hunk */
    size_t *tp_len;		/* length of each line */
    char *tp_char;		/* +, -, and ! */
    lin i;
    lin n;
    bool blankline = false;
    char *s;

    i = p_first;
    p_first = p_newfirst;
    p_newfirst = i;

    /* make a scratch copy */

    tp_line = p_line;
    tp_len = p_len;
    tp_char = p_Char;
    p_line = 0;	/* force set_hunkmax to allocate again */
    p_len = 0;
    p_Char = 0;
    set_hunkmax();
    if (!p_line || !p_len || !p_Char) {
	free (p_line);
	p_line = tp_line;
	free (p_len);
	p_len = tp_len;
	free (p_Char);
	p_Char = tp_char;
	return false;		/* not enough memory to swap hunk! */
    }

    /* now turn the new into the old */

    i = p_ptrn_lines + 1;
    if (tp_char[i] == '\n') {		/* account for possible blank line */
	blankline = true;
	i++;
    }
    if (p_efake >= 0) {			/* fix non-freeable ptr range */
	if (p_efake <= i)
	    n = p_end - i + 1;
	else
	    n = -i;
	p_efake += n;
	p_bfake += n;
    }
    for (n=0; i <= p_end; i++,n++) {
	p_line[n] = tp_line[i];
	p_Char[n] = tp_char[i];
	if (p_Char[n] == '+')
	    p_Char[n] = '-';
	p_len[n] = tp_len[i];
    }
    if (blankline) {
	i = p_ptrn_lines + 1;
	p_line[n] = tp_line[i];
	p_Char[n] = tp_char[i];
	p_len[n] = tp_len[i];
	n++;
    }
    assert(p_Char[0] == '=');
    p_Char[0] = '*';
    for (s=p_line[0]; *s; s++)
	if (*s == '-')
	    *s = '*';

    /* now turn the old into the new */

    assert(tp_char[0] == '*');
    tp_char[0] = '=';
    for (s=tp_line[0]; *s; s++)
	if (*s == '*')
	    *s = '-';
    for (i=0; n <= p_end; i++,n++) {
	p_line[n] = tp_line[i];
	p_Char[n] = tp_char[i];
	if (p_Char[n] == '-')
	    p_Char[n] = '+';
	p_len[n] = tp_len[i];
    }
    assert(i == p_ptrn_lines + 1);
    i = p_ptrn_lines;
    p_ptrn_lines = p_repl_lines;
    p_repl_lines = i;
    p_Char[p_end + 1] = '^';
    free (tp_line);
    free (tp_len);
    free (tp_char);
    return true;
}

/* Return whether file WHICH (false = old, true = new) appears to nonexistent.
   Return 1 for empty, 2 for nonexistent.  */

int
pch_says_nonexistent (bool which)
{
  return p_says_nonexistent[which];
}

const char *
pch_name (enum nametype type)
{
  return type == NONE ? NULL : p_name[type];
}

bool pch_copy (void)
{
  return p_copy[OLD] && p_copy[NEW];
}

bool pch_rename (void)
{
  return p_rename[OLD] && p_rename[NEW];
}

/* Return the specified line position in the old file of the old context. */

lin
pch_first (void)
{
    return p_first;
}

/* Return the number of lines of old context. */

lin
pch_ptrn_lines (void)
{
    return p_ptrn_lines;
}

/* Return the probable line position in the new file of the first line. */

lin
pch_newfirst (void)
{
    return p_newfirst;
}

/* Return the number of lines in the replacement text including context. */

lin
pch_repl_lines (void)
{
    return p_repl_lines;
}

/* Return the number of lines in the whole hunk. */

lin
pch_end (void)
{
    return p_end;
}

/* Return the number of context lines before the first changed line. */

lin
pch_prefix_context (void)
{
    return p_prefix_context;
}

/* Return the number of context lines after the last changed line. */

lin
pch_suffix_context (void)
{
    return p_suffix_context;
}

/* Return the length of a particular patch line. */

size_t
pch_line_len (lin line)
{
    return p_len[line];
}

/* Return the control character (+, -, *, !, etc) for a patch line.  A '\n'
   indicates an empty line in a hunk.  (The empty line is not part of the
   old or new context.  For some reson, the context format allows that.)  */

char
pch_char (lin line)
{
    return p_Char[line];
}

/* Return a pointer to a particular patch line. */

char *
pfetch (lin line)
{
    return p_line[line];
}

/* Output a patch line.  */

bool
pch_write_line (lin line, FILE *file)
{
  bool after_newline = p_line[line][p_len[line] - 1] == '\n';
  if (! fwrite (p_line[line], sizeof (*p_line[line]), p_len[line], file))
    write_fatal ();
  return after_newline;
}

/* Return where in the patch file this hunk began, for error messages. */

lin
pch_hunk_beg (void)
{
    return p_hunk_beg;
}

char const *
pch_c_function (void)
{
    return p_c_function;
}

/* Return true if in a git-style patch. */

bool
pch_git_diff (void)
{
  return p_git_diff;
}

char const *
pch_timestr (bool which)
{
  return p_timestr[which];
}

char const *
pch_sha1 (bool which)
{
  return p_sha1[which];
}

mode_t
pch_mode (bool which)
{
  return p_mode[which];
}

/* Is the newline-terminated line a valid 'ed' command for patch
   input?  If so, return the command character; if not, return 0.
   This accepts just a subset of the valid commands, but it's
   good enough in practice.  */

static char _GL_ATTRIBUTE_PURE
get_ed_command_letter (char const *line)
{
  char const *p = line;
  char letter;
  bool pair = false;

  if (ISDIGIT (*p))
    {
      while (ISDIGIT (*++p))
	/* do nothing */ ;
      if (*p == ',')
	{
	  if (! ISDIGIT (*++p))
	    return 0;
	  while (ISDIGIT (*++p))
	    /* do nothing */ ;
	  pair = true;
	}
    }

  letter = *p++;

  switch (letter)
    {
    case 'a':
    case 'i':
      if (pair)
	return 0;
      break;

    case 'c':
    case 'd':
      break;

    case 's':
      if (strncmp (p, "/.//", 4) != 0)
	return 0;
      p += 4;
      break;

    default:
      return 0;
    }

  while (*p == ' ' || *p == '\t')
    p++;
  if (*p == '\n')
    return letter;
  return 0;
}

/* Apply an ed script by feeding ed itself. */

void
do_ed_script (char const *inname, char const *outname,
	      bool *outname_needs_removal, FILE *ofp)
{
    static char const editor_program[] = EDITOR_PROGRAM;

    file_offset beginning_of_this_line;
    FILE *pipefp = 0;
    size_t chars_read;

    if (! dry_run && ! skip_rest_of_patch) {
	int exclusive = *outname_needs_removal ? 0 : O_EXCL;
	assert (! inerrno);
	*outname_needs_removal = true;
	copy_file (inname, outname, 0, exclusive, instat.st_mode, true);
	sprintf (buf, "%s %s%s", editor_program,
		 verbosity == VERBOSE ? "" : "- ",
		 outname);
	fflush (stdout);
	pipefp = popen(buf, binary_transput ? "wb" : "w");
	if (!pipefp)
	  pfatal ("Can't open pipe to %s", quotearg (buf));
    }
    for (;;) {
	char ed_command_letter;
	beginning_of_this_line = file_tell (pfp);
	chars_read = get_line ();
	if (! chars_read) {
	    next_intuit_at(beginning_of_this_line,p_input_line);
	    break;
	}
	ed_command_letter = get_ed_command_letter (buf);
	if (ed_command_letter) {
	    if (pipefp)
		if (! fwrite (buf, sizeof *buf, chars_read, pipefp))
		    write_fatal ();
	    if (ed_command_letter != 'd' && ed_command_letter != 's') {
	        p_pass_comments_through = true;
		while ((chars_read = get_line ()) != 0) {
		    if (pipefp)
			if (! fwrite (buf, sizeof *buf, chars_read, pipefp))
			    write_fatal ();
		    if (chars_read == 2  &&  strEQ (buf, ".\n"))
			break;
		}
		p_pass_comments_through = false;
	    }
	}
	else {
	    next_intuit_at(beginning_of_this_line,p_input_line);
	    break;
	}
    }
    if (!pipefp)
      return;
    if (fwrite ("w\nq\n", sizeof (char), (size_t) 4, pipefp) == 0
	|| fflush (pipefp) != 0)
      write_fatal ();
    if (pclose (pipefp) != 0)
      fatal ("%s FAILED", editor_program);

    if (ofp)
      {
	FILE *ifp = fopen (outname, binary_transput ? "rb" : "r");
	int c;
	if (!ifp)
	  pfatal ("can't open '%s'", outname);
	while ((c = getc (ifp)) != EOF)
	  if (putc (c, ofp) == EOF)
	    write_fatal ();
	if (ferror (ifp) || fclose (ifp) != 0)
	  read_fatal ();
      }
}

void
pch_normalize (enum diff format)
{
  lin old = 1;
  lin new = p_ptrn_lines + 1;

  while (p_Char[new] == '=' || p_Char[new] == '\n')
    new++;

  if (format == UNI_DIFF)
    {
      /* Convert '!' markers into '-' and '+' as defined by the Unified
         Format.  */

      for (; old <= p_ptrn_lines; old++)
	if (p_Char[old] == '!')
	  p_Char[old] = '-';
      for (; new <= p_end; new++)
	if (p_Char[new] == '!')
	  p_Char[new] = '+';
    }
  else
    {
      /* Convert '-' and '+' markers which are part of a group into '!' as
	 defined by the Context Format.  */

      while (old <= p_ptrn_lines)
	{
	  if (p_Char[old] == '-')
	    {
	      if (new <= p_end && p_Char[new] == '+')
		{
		  do
		    {
		      p_Char[old] = '!';
		      old++;
		    }
		  while (old <= p_ptrn_lines && p_Char[old] == '-');
		  do
		    {
		      p_Char[new] = '!';
		      new++;
		    }
		  while (new <= p_end && p_Char[new] == '+');
		}
	      else
		{
		  do
		    old++;
		  while (old <= p_ptrn_lines && p_Char[old] == '-');
		}
	    }
	  else if (new <= p_end && p_Char[new] == '+')
	    {
	      do
		new++;
	      while (new <= p_end && p_Char[new] == '+');
	    }
	  else
	    {
	      old++;
	      new++;
	    }
	}
    }
}
