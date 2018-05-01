/* common definitions for 'patch' */

/* Copyright (C) 1986, 1988 Larry Wall

   Copyright (C) 1990-1993, 1997-1999, 2002-2003, 2006, 2009-2012 Free Software
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

#ifndef DEBUGGING
#define DEBUGGING 1
#endif

#include <config.h>

#include <assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <sys/types.h>
#include <time.h>

#include <sys/stat.h>

#include <limits.h>

#if HAVE_INTTYPES_H
# include <inttypes.h>
#elif HAVE_STDINT_H
# include <stdint.h>
#endif
#include <intprops.h>

#include <ctype.h>
/* CTYPE_DOMAIN (C) is nonzero if the unsigned char C can safely be given
   as an argument to <ctype.h> macros like 'isspace'.  */
#if STDC_HEADERS
#define CTYPE_DOMAIN(c) 1
#else
#define CTYPE_DOMAIN(c) ((unsigned) (c) <= 0177)
#endif
#ifndef ISSPACE
#define ISSPACE(c) (CTYPE_DOMAIN (c) && isspace (c))
#endif

#ifndef ISDIGIT
#define ISDIGIT(c) ((unsigned) (c) - '0' <= 9)
#endif

#include <progname.h>

/* handy definitions */

#define strEQ(s1,s2) (!strcmp(s1, s2))
#define strnEQ(s1,s2,l) (!strncmp(s1, s2, l))
#define ARRAY_SIZE(a) (sizeof (a) / sizeof ((a)[0]))

/* typedefs */

typedef off_t lin;			/* must be signed */

#define LINENUM_MIN TYPE_MINIMUM (lin)
#define LINENUM_MAX TYPE_MAXIMUM (lin)

/* globals */

XTERN char *buf;			/* general purpose buffer */
XTERN size_t bufsize;			/* allocated size of buf */

XTERN bool using_plan_a;		/* try to keep everything in memory */

XTERN char *inname;
XTERN char *outfile;
XTERN int inerrno;
XTERN int invc;
XTERN struct stat instat;
XTERN bool dry_run;
XTERN bool posixly_correct;

XTERN char const *origprae;
XTERN char const *origbase;
XTERN char const *origsuff;

XTERN char const * TMPINNAME;
XTERN char const * TMPOUTNAME;
XTERN char const * TMPPATNAME;

XTERN bool TMPINNAME_needs_removal;
XTERN bool TMPOUTNAME_needs_removal;
XTERN bool TMPPATNAME_needs_removal;

#ifdef DEBUGGING
XTERN int debug;
#else
# define debug 0
#endif
XTERN bool force;
XTERN bool batch;
XTERN bool noreverse;
XTERN bool reverse;
XTERN enum { DEFAULT_VERBOSITY, SILENT, VERBOSE } verbosity;
XTERN bool skip_rest_of_patch;
XTERN int strippath;
XTERN bool canonicalize;
XTERN int patch_get;
XTERN bool set_time;
XTERN bool set_utc;
XTERN bool follow_symlinks;

enum diff
  {
    NO_DIFF,
    CONTEXT_DIFF,
    NORMAL_DIFF,
    ED_DIFF,
    NEW_CONTEXT_DIFF,
    UNI_DIFF,
    GIT_BINARY_DIFF
  };

XTERN enum diff diff_type;

XTERN char *revision;			/* prerequisite revision, if any */

#ifndef __attribute__
/* The __attribute__ feature is available in gcc versions 2.5 and later.
   The __-protected variants of the attributes 'format' and 'printf' are
   accepted by gcc versions 2.6.4 (effectively 2.7) and later.
   We enable __attribute__ only if these are supported too, because
   gnulib and libintl do '#define printf __printf__' when they override
   the 'printf' function.  */
# if __GNUC__ < 2 || (__GNUC__ == 2 && __GNUC_MINOR__ < 7)
#  define __attribute__(Spec)   /* empty */
# endif
#endif

void fatal_exit (int) __attribute__ ((noreturn));

#include <errno.h>
#if !STDC_HEADERS && !defined errno
extern int errno;
#endif

#include <string.h>
#include <stdlib.h>
#include <unistd.h>

#if HAVE_FSEEKO
  typedef off_t file_offset;
# define file_seek fseeko
# define file_tell ftello
#else
  typedef long file_offset;
# define file_seek fseek
# define file_tell ftell
#endif

#if ! (HAVE_GETEUID || defined geteuid)
# if ! (HAVE_GETUID || defined getuid)
#  define geteuid() (-1)
# else
#  define geteuid() getuid ()
# endif
#endif

#include <fcntl.h>

#ifdef HAVE_SETMODE_DOS
  XTERN int binary_transput;	/* O_BINARY if binary i/o is desired */
#else
# define binary_transput 0
#endif

/* Disable the CR stripping heuristic?  */
XTERN bool no_strip_trailing_cr;

#ifndef NULL_DEVICE
#define NULL_DEVICE "/dev/null"
#endif

#ifndef TTY_DEVICE
#define TTY_DEVICE "/dev/tty"
#endif

/* Output stream state.  */
struct outstate
{
  FILE *ofp;
  bool after_newline;
  bool zero_output;
};

/* offset in the input and output at which the previous hunk matched */
XTERN lin in_offset;
XTERN lin out_offset;

/* how many input lines have been irretractably output */
XTERN lin last_frozen_line;

bool copy_till (struct outstate *, lin);
bool similar (char const *, size_t, char const *, size_t) _GL_ATTRIBUTE_PURE;

#ifdef ENABLE_MERGE
enum conflict_style { MERGE_MERGE, MERGE_DIFF3 };
XTERN enum conflict_style conflict_style;

bool merge_hunk (int hunk, struct outstate *, lin where, bool *);
#else
# define merge_hunk(hunk, outstate, where, somefailed) false
#endif
