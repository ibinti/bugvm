/* Find a best match between two vectors.

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


/* Before including this file, you need to define:
     EQUAL_IDX(x, y)         A two-argument macro that tests elements
			     at index x and y for equality.
     OFFSET		     A signed integer type sufficient to hold the
			     difference between two indices. Usually
			     something like ssize_t.  */

/*
 * Shortest Edit Sequence
 *
 * Based on the Greedy LCS/SES Algorithm (Figure 2) in:
 *
 *   Eugene W. Myers, "An O(ND) Difference Algorithm and Its Variations",
 *   Algorithmica, Vol. 1, No. 1, pp. 251-266, March 1986.
 *   Available: http://dx.doi.org/10.1007/BF01840446
 *   http://xmailserver.org/diff2.pdf
 *
 * Returns the number of changes (insertions and deletions) required to get
 * from a[] to b[].  Returns MAX + 1 if a[] cannot be turned into b[] with
 * MAX or fewer changes, in which case *PY is not modified.
 *
 * MIN specifies the minimum number of elements in which a[] and b[] must
 * match. This allows to prevent trivial matches in which a sequence is
 * completely discarded, or completely made up.
 *
 * If PY is not NULL, matches a[] against a prefix of b[], and returns the
 * number of elements in b[] that were matched in *PY.  Otherwise, matches
 * all elements of b[].
 *
 * Note that the divide-and-conquer strategy discussed in section 4b of the
 * paper is more efficient, but does not allow an open-ended prefix string
 * search.
 */

static OFFSET
bestmatch(OFFSET xoff, OFFSET xlim, OFFSET yoff, OFFSET ylim,
	  OFFSET min, OFFSET max, OFFSET *py)
{
    const OFFSET dmin = xoff - ylim;      /* Minimum valid diagonal. */
    const OFFSET dmax = xlim - yoff;      /* Maximum valid diagonal. */
    const OFFSET fmid = xoff - yoff;      /* Center diagonal. */
    OFFSET fmin = fmid;
    OFFSET fmax = fmid;
    OFFSET *V, *fd;
    OFFSET fmid_plus_2_min, ymax = -1;
    OFFSET c;

    V = malloc ((2 * max + 3) * sizeof (OFFSET));
    fd = V + max + 1 - fmid;

    /*
       The number of elements that were matched in x and in y can be
       computed as either (x - x_skipped) or (y - y_skipped), with:

	 delta = (x - xoff) - (y - yoff)
	 x_skipped = (c + delta) / 2
	 y_skipped = (c - delta) / 2

       For searching for a minimum number of matching elements, we end up
       with this check:

         (x - x_skipped) >= min
	  ...
	 x + y - c >= (xoff - yoff) + 2 * min
	 x + y - c >= fmid + 2 * min
    */

    if (min)
      {
	fmid_plus_2_min = fmid + 2 * min;
	min += yoff;
	if (min > ylim)
	  {
	    c = max + 1;
	    goto free_and_return;
	  }
      }
    else
      fmid_plus_2_min = 0;  /* disable this check */
    if (!py)
      min = ylim;

    /* Handle the exact-match case. */
    while (xoff < xlim && yoff < ylim && EQUAL_IDX (xoff, yoff))
      {
	xoff++;
	yoff++;
      }
    if (xoff == xlim && yoff >= min
	&& xoff + yoff >= fmid_plus_2_min)
      {
	ymax = yoff;
        c = 0;
      }
    else
      {
	fd[fmid] = xoff;
	for (c = 1; c <= max; c++)
	  {
	    OFFSET d;

	    if (fmin > dmin)
	      fd[--fmin - 1] = -1;
	    else
	      ++fmin;
	    if (fmax < dmax)
	      fd[++fmax + 1] = -1;
	    else
	      --fmax;
	    for (d = fmax; d >= fmin; d -= 2)
	      {
		OFFSET x, y;

		if (fd[d - 1] < fd[d + 1])
		  x = fd[d + 1];
		else
		  x = fd[d - 1] + 1;
		for (y = x - d;
		     x < xlim && y < ylim && EQUAL_IDX (x, y);
		     x++, y++)
		  /* do nothing */ ;
		fd[d] = x;
		if (x == xlim && y >= min
		    && x + y - c >= fmid_plus_2_min)
		  {
		    if (ymax < y)
		      ymax = y;
		    if (y == ylim)
		      goto done;
		  }
	      }
	    if (ymax != -1)
	      goto done;
	  }
      }

  done:
    if (py)
      *py = ymax;

  free_and_return:
    free (V);
    return c;
}

#undef OFFSET
#undef EQUAL_IDX
