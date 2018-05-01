/* Print the version number.  */

#define XTERN extern
#include <common.h>
#include <version.h>

static char const copyright_string[] = "\
Copyright (C) 2003, 2009-2012 Free Software Foundation, Inc.\n\
Copyright (C) 1988 Larry Wall";

static char const free_software_msgid[] = "\
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>.\n\
This is free software: you are free to change and redistribute it.\n\
There is NO WARRANTY, to the extent permitted by law.";

static char const authorship_msgid[] = "\
Written by Larry Wall and Paul Eggert";

void
version (void)
{
  printf ("%s %s\n%s\n\n%s\n\n%s\n", PACKAGE_NAME, PACKAGE_VERSION,
	  copyright_string, free_software_msgid, authorship_msgid);
}
