# Copyright (C) 1993, 1997-1999, 2002-2003, 2006, 2009, 2011-2012 Free Software
# Foundation, Inc.

# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2, or (at your option)
# any later version.

# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.

# You should have received a copy of the GNU General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
# 02110-1301, USA.

AC_PREREQ([2.65])

AC_INIT([GNU patch],
	m4_esyscmd([build-aux/git-version-gen .tarball-version]),
	[bug-patch@gnu.org])

AC_CONFIG_SRCDIR([src/patch.c])
AC_CONFIG_AUX_DIR([build-aux])
AC_CONFIG_MACRO_DIR([m4])

AC_ARG_ENABLE([merge],
  [AS_HELP_STRING([--disable-merge],
    [disable support for merging])])
AM_CONDITIONAL([ENABLE_MERGE], [test "$enableval" != no])
AM_CONDITIONAL([ALPHA_VERSION],
  [[echo "$PACKAGE_VERSION" | grep -- "-[0-9a-f][0-9a-f]*\\(-dirty\\)\\?$" >/dev/null]])

AM_INIT_AUTOMAKE([1.11.2 -Wall gnu dist-bzip2 dist-xz color-tests parallel-tests])
AM_SILENT_RULES([yes])

AC_CONFIG_HEADER([config.h:config.hin])

AC_PROG_CC
AC_PROG_CC_STDC
gl_EARLY
gl_USE_SYSTEM_EXTENSIONS
AC_HEADER_STDC
gl_INIT
AM_PROG_AR

AC_ARG_ENABLE([gcc-warnings],
  [AS_HELP_STRING([--enable-gcc-warnings],
                  [turn on lots of GCC warnings (for developers)])],
  [case $enableval in
     yes|no) ;;
     *)      AC_MSG_ERROR([bad value $enableval for gcc-warnings option]) ;;
   esac
   gl_gcc_warnings=$enableval],
  [gl_gcc_warnings=no]
)

if test "$gl_gcc_warnings" = yes; then
  gl_WARN_ADD([-Werror], [WERROR_CFLAGS])
  AC_SUBST([WERROR_CFLAGS])

  nw=
  # This, $nw, is the list of warnings we disable.
  nw="$nw -Wdeclaration-after-statement" # too useful to forbid
  nw="$nw -Waggregate-return"       # anachronistic
  nw="$nw -Wlong-long"              # C90 is anachronistic (lib/gethrxtime.h)
  nw="$nw -Wc++-compat"             # We don't care about C++ compilers
  nw="$nw -Wundef"                  # Warns on '#if GNULIB_FOO' etc in gnulib
  nw="$nw -Wtraditional"            # Warns on #elif which we use often
  nw="$nw -Wcast-qual"              # Too many warnings for now
  nw="$nw -Wconversion"             # Too many warnings for now
  nw="$nw -Wsystem-headers"         # Don't let system headers trigger warnings
  nw="$nw -Wsign-conversion"        # Too many warnings for now
  nw="$nw -Wtraditional-conversion" # Too many warnings for now
  nw="$nw -Wunreachable-code"       # Too many warnings for now
  nw="$nw -Wpadded"                 # Our structs are not padded
  nw="$nw -Wredundant-decls"        # openat.h declares e.g., mkdirat
  nw="$nw -Wlogical-op"             # any use of fwrite provokes this
  nw="$nw -Wformat-nonliteral"      # who.c and pinky.c strftime uses
  nw="$nw -Wvla"                    # warnings in gettext.h
  nw="$nw -Wnested-externs"         # use of XARGMATCH/verify_function__
  nw="$nw -Wswitch-enum"            # Too many warnings for now
  nw="$nw -Wswitch-default"         # Too many warnings for now
  nw="$nw -Wstack-protector"        # not worth working around
  nw="$nw -Wmissing-format-attribute" # not worth working around in patch
  nw="$nw -Wsuggest-attribute=format" # warns about util.c
  # things to fix soon:
  nw="$nw -Wshadow"
  nw="$nw -Wstrict-overflow"
  nw="$nw -Wunsafe-loop-optimizations"
#  nw="$nw -Wfloat-equal"            # sort.c, seq.c
#  nw="$nw -Wmissing-format-attribute" # copy.c
#  nw="$nw -Winline"                 # system.h's readdir_ignoring_dot_and_dotdot
  # ?? -Wstrict-overflow

  gl_MANYWARN_ALL_GCC([ws])
  gl_MANYWARN_COMPLEMENT([ws], [$ws], [$nw])
  for w in $ws; do
    gl_WARN_ADD([$w])
  done
  gl_WARN_ADD([-Wno-missing-field-initializers]) # We need this one
  gl_WARN_ADD([-Wno-sign-compare])     # Too many warnings for now
  gl_WARN_ADD([-Wno-unused-parameter]) # Too many warnings for now

  # In spite of excluding -Wlogical-op above, it is enabled, as of
  # gcc 4.5.0 20090517, and it provokes warnings in cat.c, dd.c, truncate.c
  gl_WARN_ADD([-Wno-logical-op])

  gl_WARN_ADD([-fdiagnostics-show-option])
  gl_WARN_ADD([-funit-at-a-time])
  gl_WARN_ADD([-Wno-format-nonliteral])

  AC_SUBST([WARN_CFLAGS])

  AC_DEFINE([lint], [1], [Define to 1 if the compiler is checking for lint.])
  AC_DEFINE([_FORTIFY_SOURCE], [2],
    [enable compile-time and run-time bounds-checking, and some warnings])
  AC_DEFINE([GNULIB_PORTCHECK], [1], [enable some gnulib portability checks])

  # We use a slightly smaller set of warning options for lib/.
  # Remove the following and save the result in GNULIB_WARN_CFLAGS.
  nw=
  nw="$nw -Wuninitialized"
  nw="$nw -Wunused-macros"
  nw="$nw -Wmissing-prototypes"
  nw="$nw -Wold-style-definition"
  gl_MANYWARN_COMPLEMENT([GNULIB_WARN_CFLAGS], [$WARN_CFLAGS], [$nw])
  AC_SUBST([GNULIB_WARN_CFLAGS])

  # For gnulib-tests, the set is slightly smaller still.
  nw=
  nw="$nw -Wstrict-prototypes"
  gl_MANYWARN_COMPLEMENT([GNULIB_TEST_WARN_CFLAGS],
                         [$GNULIB_WARN_CFLAGS], [$nw])
  AC_SUBST([GNULIB_TEST_WARN_CFLAGS])
fi

AC_TYPE_MODE_T
AC_TYPE_OFF_T

gl_FUNC_XATTR

AC_CHECK_FUNCS(geteuid getuid raise sigaction sigprocmask sigsetmask)
AC_FUNC_SETMODE_DOS

AC_PATH_PROG([ED], [ed], [ed])
AC_DEFINE_UNQUOTED([EDITOR_PROGRAM], ["$ED"], [Name of editor program.])

AC_CONFIG_FILES([
  Makefile
  lib/Makefile
  src/Makefile
  tests/Makefile
])
AC_OUTPUT
