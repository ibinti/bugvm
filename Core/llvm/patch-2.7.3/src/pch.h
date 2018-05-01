/* reading patches */

/* Copyright (C) 1986, 1987, 1988 Larry Wall

   Copyright (C) 1990-1993, 1997-2003, 2009-2012 Free Software Foundation, Inc.

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

enum nametype { OLD, NEW, INDEX, NONE };

lin pch_end (void) _GL_ATTRIBUTE_PURE;
lin pch_first (void) _GL_ATTRIBUTE_PURE;
lin pch_hunk_beg (void) _GL_ATTRIBUTE_PURE;
char const *pch_c_function (void) _GL_ATTRIBUTE_PURE;
bool pch_git_diff (void) _GL_ATTRIBUTE_PURE;
char const * pch_timestr (bool which) _GL_ATTRIBUTE_PURE;
char const *pch_sha1 (bool which) _GL_ATTRIBUTE_PURE;
mode_t pch_mode (bool which) _GL_ATTRIBUTE_PURE;
lin pch_newfirst (void) _GL_ATTRIBUTE_PURE;
lin pch_prefix_context (void) _GL_ATTRIBUTE_PURE;
lin pch_ptrn_lines (void) _GL_ATTRIBUTE_PURE;
lin pch_repl_lines (void) _GL_ATTRIBUTE_PURE;
lin pch_suffix_context (void) _GL_ATTRIBUTE_PURE;
bool pch_swap (void);
bool pch_write_line (lin, FILE *);
bool there_is_another_patch (bool, mode_t *);
char *pfetch (lin) _GL_ATTRIBUTE_PURE;
char pch_char (lin) _GL_ATTRIBUTE_PURE;
int another_hunk (enum diff, bool);
int pch_says_nonexistent (bool) _GL_ATTRIBUTE_PURE;
size_t pch_line_len (lin) _GL_ATTRIBUTE_PURE;
const char *pch_name(enum nametype) _GL_ATTRIBUTE_PURE;
bool pch_copy (void) _GL_ATTRIBUTE_PURE;
bool pch_rename (void) _GL_ATTRIBUTE_PURE;
void do_ed_script (char const *, char const *, bool *, FILE *);
void open_patch_file (char const *);
void re_patch (void);
void pch_normalize (enum diff);

XTERN struct timespec p_timestamp[2];  /* timestamps in patch headers */

/* Return timestamp of patch header for file WHICH (false = old, true = new),
   or a timestamp with tv_sec == -1 if there was no timestamp or an error in
   the timestamp.  */

static inline struct timespec pch_timestamp (bool which)
{
  return p_timestamp[which];
}
