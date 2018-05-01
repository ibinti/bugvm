/* utility functions for 'patch' */

/* Copyright (C) 1986 Larry Wall

   Copyright (C) 1992-1993, 1997-1999, 2001-2003, 2006, 2009-2012 Free Software
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
#include <hash.h>
#include <quotearg.h>
#undef XTERN
#define XTERN
#include <util.h>
#include <xalloc.h>
#include <xmemdup0.h>

#include <getdate.h>
#include "ignore-value.h"
#include "error.h"

#include <signal.h>
#if !defined SIGCHLD && defined SIGCLD
#define SIGCHLD SIGCLD
#endif
#if ! HAVE_RAISE && ! defined raise
# define raise(sig) kill (getpid (), sig)
#endif

#include <stdarg.h>
#include <full-write.h>
#include <tempname.h>

#if USE_XATTR
# include <attr/error_context.h>
# include <attr/libattr.h>
# include <stdarg.h>
# include "verror.h"
#endif

static void makedirs (char const *);

typedef struct
{
  dev_t dev;
  ino_t ino;
  enum file_id_type type;
  bool queued_output;
} file_id;

/* Return an index for ENTRY into a hash table of size TABLE_SIZE.  */

static size_t
file_id_hasher (void const *entry, size_t table_size)
{
  file_id const *e = entry;
  size_t i = e->ino + e->dev;
  return i % table_size;
}

/* Do ENTRY1 and ENTRY2 refer to the same files?  */

static bool
file_id_comparator (void const *entry1, void const *entry2)
{
  file_id const *e1 = entry1;
  file_id const *e2 = entry2;
  return (e1->ino == e2->ino && e1->dev == e2->dev);
}

static Hash_table *file_id_table;

/* Initialize the hash table.  */

void
init_backup_hash_table (void)
{
  file_id_table = hash_initialize (0, NULL, file_id_hasher,
				   file_id_comparator, free);
  if (!file_id_table)
    xalloc_die ();
}

static file_id *
__insert_file_id (struct stat const *st, enum file_id_type type)
{
   file_id *p;
   static file_id *next_slot;

   if (!next_slot)
     next_slot = xmalloc (sizeof *next_slot);
   next_slot->dev = st->st_dev;
   next_slot->ino = st->st_ino;
   next_slot->queued_output = false;
   p = hash_insert (file_id_table, next_slot);
   if (!p)
     xalloc_die ();
   if (p == next_slot)
     next_slot = NULL;
   p->type = type;
   return p;
}

static file_id *
__lookup_file_id (struct stat const *st)
{
  file_id f;

  f.dev = st->st_dev;
  f.ino = st->st_ino;
  return hash_lookup (file_id_table, &f);
}

/* Insert a file with status ST and type TYPE into the hash table.
   The type of an existing entry can be changed by re-inserting it.  */

void
insert_file_id (struct stat const *st, enum file_id_type type)
{
  __insert_file_id (st, type);
}

/* Has the file identified by ST already been inserted into the hash
   table, and what type does it have?  */

enum file_id_type
lookup_file_id (struct stat const *st)
{
  file_id *p = __lookup_file_id (st);

  return p ? p->type : UNKNOWN;
}

void
set_queued_output (struct stat const *st, bool queued_output)
{
  file_id *p = __lookup_file_id (st);

  if (! p)
    p = __insert_file_id (st, UNKNOWN);
  p->queued_output = queued_output;
}

bool
has_queued_output (struct stat const *st)
{
  file_id *p = __lookup_file_id (st);

  return p && p->queued_output;
}

static bool _GL_ATTRIBUTE_PURE
contains_slash (const char *s)
{
  for (; *s; s++)
    if (ISSLASH(*s))
      return true;
  return false;
}

#if USE_XATTR

static void
copy_attr_error (struct error_context *ctx, char const *fmt, ...)
{
  int err = errno;
  va_list ap;

  if (err != ENOSYS && err != ENOTSUP && err != EPERM)
    {
      /* use verror module to print error message */
      va_start (ap, fmt);
      verror (0, err, fmt, ap);
      va_end (ap);
    }
}

static char const *
copy_attr_quote (struct error_context *ctx, char const *str)
{
  return quotearg (str);
}

static void
copy_attr_free (struct error_context *ctx, char const *str)
{
}

static int
copy_attr_check (const char *name, struct error_context *ctx)
{
	int action = attr_copy_action (name, ctx);
	return action == 0 || action == ATTR_ACTION_PERMISSIONS;
}

static int
copy_attr (char const *src_path, char const *dst_path)
{
  struct error_context ctx =
  {
    .error = copy_attr_error,
    .quote = copy_attr_quote,
    .quote_free = copy_attr_free
  };
  return attr_copy_file (src_path, dst_path, copy_attr_check, &ctx);
}

#else  /* USE_XATTR */

static int
copy_attr (char const *src_path, char const *dst_path)
{
  return 0;
}

#endif

void
set_file_attributes (char const *to, enum file_attributes attr,
		     char const *from, const struct stat *st, mode_t mode,
		     struct timespec *new_time)
{
  if (attr & FA_TIMES)
    {
      struct timespec times[2];
      if (new_time)
	times[0] = times[1] = *new_time;
      else
        {
	  times[0] = get_stat_atime (st);
	  times[1] = get_stat_mtime (st);
	}
      if (lutimens (to, times) != 0)
	pfatal ("Failed to set the timestamps of %s %s",
		S_ISLNK (mode) ? "symbolic link" : "file",
		quotearg (to));
    }
  if (attr & FA_IDS)
    {
      static uid_t euid = -1;
      static gid_t egid = -1;
      uid_t uid;
      uid_t gid;

      if (euid == -1)
        {
	  euid = geteuid ();
	  egid = getegid ();
	}
      uid = (euid == st->st_uid) ? -1 : st->st_uid;
      gid = (egid == st->st_gid) ? -1 : st->st_gid;

      /* May fail if we are not privileged to set the file owner, or we are
         not in group instat.st_gid.  Ignore those errors.  */
      if ((uid != -1 || gid != -1)
	  && lchown (to, uid, gid) != 0
	  && (errno != EPERM
	      || (uid != -1
		  && lchown (to, (uid = -1), gid) != 0
		  && errno != EPERM)))
	pfatal ("Failed to set the %s of %s %s",
		(uid == -1) ? "owner" : "owning group",
		S_ISLNK (mode) ? "symbolic link" : "file",
		quotearg (to));
    }
  if (attr & FA_XATTRS)
    if (copy_attr (from, to) != 0
	&& errno != ENOSYS && errno != ENOTSUP && errno != EPERM)
      fatal_exit (0);
  if (attr & FA_MODE)
    {
#if 0 && defined HAVE_LCHMOD
      /* The "diff --git" format does not store the file permissions of
	 symlinks, so don't try to set symlink file permissions even on
	 systems where we could.  */
      if (lchmod (to, mode))
#else
      if (! S_ISLNK (mode) && chmod (to, mode) != 0)
#endif
	pfatal ("Failed to set the permissions of %s %s",
		S_ISLNK (mode) ? "symbolic link" : "file",
		quotearg (to));
    }
}

static void
create_backup_copy (char const *from, char const *to, const struct stat *st,
		    bool to_dir_known_to_exist)
{
  copy_file (from, to, NULL, 0, st->st_mode, to_dir_known_to_exist);
  set_file_attributes (to, FA_TIMES | FA_IDS | FA_MODE, from, st, st->st_mode, NULL);
}

void
create_backup (char const *to, const struct stat *to_st, bool leave_original)
{
  /* When the input to patch modifies the same file more than once, patch only
     backs up the initial version of each file.

     To figure out which files have already been backed up, patch remembers the
     files that replace the original files.  Files not known already are backed
     up; files already known have already been backed up before, and are
     skipped.

     When a patch tries to delete a file, in order to not break the above
     logic, we merely remember which file to delete.  After the entire patch
     file has been read, we delete all files marked for deletion which have not
     been recreated in the meantime.  */

  if (to_st && ! (S_ISREG (to_st->st_mode) || S_ISLNK (to_st->st_mode)))
    fatal ("File %s is not a %s -- refusing to create backup",
	   to, S_ISLNK (to_st->st_mode) ? "symbolic link" : "regular file");

  if (to_st && lookup_file_id (to_st) == CREATED)
    {
      if (debug & 4)
	say ("File %s already seen\n", quotearg (to));
    }
  else
    {
      int try_makedirs_errno = 0;
      char *bakname;

      if (origprae || origbase || origsuff)
	{
	  char const *p = origprae ? origprae : "";
	  char const *b = origbase ? origbase : "";
	  char const *s = origsuff ? origsuff : "";
	  char const *t = to;
	  size_t plen = strlen (p);
	  size_t blen = strlen (b);
	  size_t slen = strlen (s);
	  size_t tlen = strlen (t);
	  char const *o;
	  size_t olen;

	  for (o = t + tlen, olen = 0;
	       o > t && ! ISSLASH (*(o - 1));
	       o--)
	    /* do nothing */ ;
	  olen = t + tlen - o;
	  tlen -= olen;
	  bakname = xmalloc (plen + tlen + blen + olen + slen + 1);
	  memcpy (bakname, p, plen);
	  memcpy (bakname + plen, t, tlen);
	  memcpy (bakname + plen + tlen, b, blen);
	  memcpy (bakname + plen + tlen + blen, o, olen);
	  memcpy (bakname + plen + tlen + blen + olen, s, slen + 1);

	  if ((origprae
	       && (contains_slash (origprae + FILE_SYSTEM_PREFIX_LEN (origprae))
		   || contains_slash (to)))
	      || (origbase && contains_slash (origbase)))
	    try_makedirs_errno = ENOENT;
	}
      else
	{
	  bakname = find_backup_file_name (to, backup_type);
	  if (!bakname)
	    xalloc_die ();
	}

      if (! to_st)
	{
	  int fd;

	  if (debug & 4)
	    say ("Creating empty file %s\n", quotearg (bakname));

	  try_makedirs_errno = ENOENT;
	  unlink (bakname);
	  while ((fd = creat (bakname, 0666)) < 0)
	    {
	      if (errno != try_makedirs_errno)
		pfatal ("Can't create file %s", quotearg (bakname));
	      makedirs (bakname);
	      try_makedirs_errno = 0;
	    }
	  if (close (fd) != 0)
	    pfatal ("Can't close file %s", quotearg (bakname));
	}
      else if (leave_original)
	create_backup_copy (to, bakname, to_st, try_makedirs_errno == 0);
      else
	{
	  if (debug & 4)
	    say ("Renaming file %s to %s\n",
		 quotearg_n (0, to), quotearg_n (1, bakname));
	  while (rename (to, bakname) != 0)
	    {
	      if (errno == try_makedirs_errno)
		{
		  makedirs (bakname);
		  try_makedirs_errno = 0;
		}
	      else if (errno == EXDEV)
		{
		  create_backup_copy (to, bakname, to_st,
				      try_makedirs_errno == 0);
		  unlink (to);
		  break;
		}
	      else
		pfatal ("Can't rename file %s to %s",
			quotearg_n (0, to), quotearg_n (1, bakname));
	    }
	}
      free (bakname);
    }
}

/* Only allow symlink targets which are relative and free of ".." components:
 * otherwise, the operating system may follow one of those symlinks in a
 * pathname component, leading to a path traversal vulnerability.
 *
 * An alternative to disallowing many kinds of symlinks would be to implement
 * path traversal in user space using openat() without following symlinks
 * altogether.
 */
static bool
symlink_target_is_valid (char const *target, char const *to)
{
  bool is_valid = filename_is_safe (target);

  /* Allow any symlink target if we are in the filesystem root.  */
  return is_valid || cwd_is_root (to);
}

/* Move a file FROM (where *FROM_NEEDS_REMOVAL is nonzero if FROM
   needs removal when cleaning up at the end of execution, and where
   *FROMST is FROM's status if known),
   to TO, renaming it if possible and copying it if necessary.
   If we must create TO, use MODE to create it.
   If FROM is null, remove TO.
   FROM_NEEDS_REMOVAL must be nonnull if FROM is nonnull.
   and FROMST must be nonnull if both FROM and BACKUP are nonnull.
   Back up TO if BACKUP is true.  */

void
move_file (char const *from, bool *from_needs_removal,
	   struct stat const *fromst,
	   char const *to, mode_t mode, bool backup)
{
  struct stat to_st;
  int to_errno;

  to_errno = stat_file (to, &to_st);
  if (backup)
    create_backup (to, to_errno ? NULL : &to_st, false);
  if (! to_errno)
    insert_file_id (&to_st, OVERWRITTEN);

  if (from)
    {
      if (S_ISLNK (mode))
	{
	  bool to_dir_known_to_exist = false;

	  /* FROM contains the contents of the symlink we have patched; need
	     to convert that back into a symlink. */
	  char *buffer = xmalloc (PATH_MAX);
	  int fd, size = 0, i;

	  if ((fd = open (from, O_RDONLY | O_BINARY)) < 0)
	    pfatal ("Can't reopen file %s", quotearg (from));
	  while ((i = read (fd, buffer + size, PATH_MAX - size)) > 0)
	    size += i;
	  if (i != 0 || close (fd) != 0)
	    read_fatal ();
	  buffer[size] = 0;

	  /* If we are allowed to create a file with an absolute path name,
	     anywhere, we also don't need to worry about symlinks that can
	     leave the working directory.  */
	  if (! (IS_ABSOLUTE_FILE_NAME (to)
		 || symlink_target_is_valid (buffer, to)))
	    {
	      fprintf (stderr, "symbolic link target '%s' is invalid\n",
		       buffer);
	      fatal_exit (0);
	    }

	  if (! backup)
	    {
	      if (unlink (to) == 0)
		to_dir_known_to_exist = true;
	    }
	  if (symlink (buffer, to) != 0)
	    {
	      if (errno == ENOENT && ! to_dir_known_to_exist)
		makedirs (to);
	      if (symlink (buffer, to) != 0)
		pfatal ("Can't create %s %s", "symbolic link", to);
	    }
	  free (buffer);
	  if (lstat (to, &to_st) != 0)
	    pfatal ("Can't get file attributes of %s %s", "symbolic link", to);
	  insert_file_id (&to_st, CREATED);
	}
      else
	{
	  if (debug & 4)
	    say ("Renaming file %s to %s\n",
		 quotearg_n (0, from), quotearg_n (1, to));

	  if (rename (from, to) != 0)
	    {
	      bool to_dir_known_to_exist = false;

	      if (errno == ENOENT
		  && (to_errno == -1 || to_errno == ENOENT))
		{
		  makedirs (to);
		  to_dir_known_to_exist = true;
		  if (rename (from, to) == 0)
		    goto rename_succeeded;
		}

	      if (errno == EXDEV)
		{
		  struct stat tost;
		  if (! backup)
		    {
		      if (unlink (to) == 0)
			to_dir_known_to_exist = true;
		      else if (errno != ENOENT)
			pfatal ("Can't remove file %s", quotearg (to));
		    }
		  copy_file (from, to, &tost, 0, mode, to_dir_known_to_exist);
		  insert_file_id (&tost, CREATED);
		  return;
		}

	      pfatal ("Can't rename file %s to %s",
		      quotearg_n (0, from), quotearg_n (1, to));
	    }

	rename_succeeded:
	  insert_file_id (fromst, CREATED);
	  /* Do not clear *FROM_NEEDS_REMOVAL if it's possible that the
	     rename returned zero because FROM and TO are hard links to
	     the same file.  */
	  if ((0 < to_errno
	       || (to_errno == 0 && to_st.st_nlink <= 1))
	      && from_needs_removal)
	    *from_needs_removal = false;
	}
    }
  else if (! backup)
    {
      if (debug & 4)
	say ("Removing file %s\n", quotearg (to));
      if (unlink (to) != 0 && errno != ENOENT)
	pfatal ("Can't remove file %s", quotearg (to));
    }
}

/* Create FILE with OPEN_FLAGS, and with MODE adjusted so that
   we can read and write the file and that the file is not executable.
   Return the file descriptor.  */
int
create_file (char const *file, int open_flags, mode_t mode,
	     bool to_dir_known_to_exist)
{
  int try_makedirs_errno = to_dir_known_to_exist ? 0 : ENOENT;
  int fd;
  mode |= S_IRUSR | S_IWUSR;
  mode &= ~ (S_IXUSR | S_IXGRP | S_IXOTH);
  do
    {
      if (! (O_CREAT && O_TRUNC))
	close (creat (file, mode));
      fd = open (file, O_CREAT | O_TRUNC | open_flags, mode);
      if (fd < 0)
	{
	  char *f;
	  if (errno != try_makedirs_errno)
	    pfatal ("Can't create file %s", quotearg (file));
	  f = xstrdup (file);
	  makedirs (f);
	  free (f);
	  try_makedirs_errno = 0;
	}
    } while (fd < 0);
  return fd;
}

static void
copy_to_fd (const char *from, int tofd)
{
  int fromfd;
  ssize_t i;

  if ((fromfd = open (from, O_RDONLY | O_BINARY)) < 0)
    pfatal ("Can't reopen file %s", quotearg (from));
  while ((i = read (fromfd, buf, bufsize)) != 0)
    {
      if (i == (ssize_t) -1)
	read_fatal ();
      if (full_write (tofd, buf, i) != i)
	write_fatal ();
    }
  if (close (fromfd) != 0)
    read_fatal ();
}

/* Copy a file. */

void
copy_file (char const *from, char const *to, struct stat *tost,
	   int to_flags, mode_t mode, bool to_dir_known_to_exist)
{
  int tofd;

  if (debug & 4)
    say ("Copying %s %s to %s\n",
	 S_ISLNK (mode) ? "symbolic link" : "file",
	 quotearg_n (0, from), quotearg_n (1, to));

  if (S_ISLNK (mode))
    {
      char *buffer = xmalloc (PATH_MAX);

      if (readlink (from, buffer, PATH_MAX) < 0)
	pfatal ("Can't read %s %s", "symbolic link", from);
      if (symlink (buffer, to) != 0)
	pfatal ("Can't create %s %s", "symbolic link", to);
      if (tost && lstat (to, tost) != 0)
	pfatal ("Can't get file attributes of %s %s", "symbolic link", to);
      free (buffer);
    }
  else
    {
      assert (S_ISREG (mode));
      tofd = create_file (to, O_WRONLY | O_BINARY | to_flags, mode,
			  to_dir_known_to_exist);
      copy_to_fd (from, tofd);
      if (tost && fstat (tofd, tost) != 0)
	pfatal ("Can't get file attributes of %s %s", "file", to);
      if (close (tofd) != 0)
	write_fatal ();
    }
}

/* Append to file. */

void
append_to_file (char const *from, char const *to)
{
  int tofd;

  if ((tofd = open (to, O_WRONLY | O_BINARY | O_APPEND)) < 0)
    pfatal ("Can't reopen file %s", quotearg (to));
  copy_to_fd (from, tofd);
  if (close (tofd) != 0)
    write_fatal ();
}

static char const DEV_NULL[] = NULL_DEVICE;

static char const RCSSUFFIX[] = ",v";
static char const CHECKOUT[] = "co %s";
static char const CHECKOUT_LOCKED[] = "co -l %s";
static char const RCSDIFF1[] = "rcsdiff %s";

static char const SCCSPREFIX[] = "s.";
static char const GET[] = "get ";
static char const GET_LOCKED[] = "get -e ";
static char const SCCSDIFF1[] = "get -p ";
static char const SCCSDIFF2[] = "|diff - %s";

static char const CLEARTOOL_CO[] = "cleartool co -unr -nc ";

static char const PERFORCE_CO[] = "p4 edit ";

static size_t
quote_system_arg (char *quoted, char const *arg)
{
  char *q = quotearg_style (shell_quoting_style, arg);
  size_t len = strlen (q);

  if (quoted)
    memcpy (quoted, q, len + 1);
  return len;
}

/* Return "RCS" if FILENAME is controlled by RCS,
   "SCCS" if it is controlled by SCCS,
   "ClearCase" if it is controlled by Clearcase,
   "Perforce" if it is controlled by Perforce,
   and 0 otherwise.
   READONLY is true if we desire only readonly access to FILENAME.
   FILESTAT describes FILENAME's status or is 0 if FILENAME does not exist.
   If successful and if GETBUF is nonzero, set *GETBUF to a command
   that gets the file; similarly for DIFFBUF and a command to diff the file
   (but set *DIFFBUF to 0 if the diff operation is meaningless).
   *GETBUF and *DIFFBUF must be freed by the caller.  */
char const *
version_controller (char const *filename, bool readonly,
		    struct stat const *filestat, char **getbuf, char **diffbuf)
{
  struct stat cstat;
  char *dir = dir_name (filename);
  char *filebase = base_name (filename);
  char const *dotslash = *filename == '-' ? "./" : "";
  size_t dirlen = strlen (dir) + 1;
  size_t maxfixlen = sizeof "SCCS/" - 1 + sizeof SCCSPREFIX - 1;
  size_t maxtrysize = dirlen + strlen (filebase) + maxfixlen + 1;
  size_t quotelen = quote_system_arg (0, dir) + quote_system_arg (0, filebase);
  size_t maxgetsize = sizeof CLEARTOOL_CO + quotelen + maxfixlen;
  size_t maxdiffsize =
    (sizeof SCCSDIFF1 + sizeof SCCSDIFF2 + sizeof DEV_NULL - 1
     + 2 * quotelen + maxfixlen);
  char *trybuf = xmalloc (maxtrysize);
  char const *r = 0;

  sprintf (trybuf, "%s/", dir);

#define try1(f,a1)    (sprintf (trybuf + dirlen, f, a1),    stat (trybuf, &cstat) == 0)
#define try2(f,a1,a2) (sprintf (trybuf + dirlen, f, a1,a2), stat (trybuf, &cstat) == 0)

  /* Check that RCS file is not working file.
     Some hosts don't report file name length errors.  */

  if ((try2 ("RCS/%s%s", filebase, RCSSUFFIX)
       || try1 ("RCS/%s", filebase)
       || try2 ("%s%s", filebase, RCSSUFFIX))
      && ! (filestat
	    && filestat->st_dev == cstat.st_dev
	    && filestat->st_ino == cstat.st_ino))
    {
      if (getbuf)
	{
	  char *p = *getbuf = xmalloc (maxgetsize);
	  sprintf (p, readonly ? CHECKOUT : CHECKOUT_LOCKED, dotslash);
	  p += strlen (p);
	  p += quote_system_arg (p, filename);
	  *p = '\0';
	}

      if (diffbuf)
	{
	  char *p = *diffbuf = xmalloc (maxdiffsize);
	  sprintf (p, RCSDIFF1, dotslash);
	  p += strlen (p);
	  p += quote_system_arg (p, filename);
	  *p++ = '>';
	  strcpy (p, DEV_NULL);
	}

      r = "RCS";
    }
  else if (try2 ("SCCS/%s%s", SCCSPREFIX, filebase)
	   || try2 ("%s%s", SCCSPREFIX, filebase))
    {
      if (getbuf)
	{
	  char *p = *getbuf = xmalloc (maxgetsize);
	  sprintf (p, readonly ? GET : GET_LOCKED);
	  p += strlen (p);
	  p += quote_system_arg (p, trybuf);
	  *p = '\0';
	}

      if (diffbuf)
	{
	  char *p = *diffbuf = xmalloc (maxdiffsize);
	  strcpy (p, SCCSDIFF1);
	  p += sizeof SCCSDIFF1 - 1;
	  p += quote_system_arg (p, trybuf);
	  sprintf (p, SCCSDIFF2, dotslash);
	  p += strlen (p);
	  p += quote_system_arg (p, filename);
	  *p++ = '>';
	  strcpy (p, DEV_NULL);
	}

      r = "SCCS";
    }
  else if (!readonly && filestat
	   && try1 ("%s@@", filebase) && S_ISDIR (cstat.st_mode))
    {
      if (getbuf)
	{
	  char *p = *getbuf = xmalloc (maxgetsize);
	  strcpy (p, CLEARTOOL_CO);
	  p += sizeof CLEARTOOL_CO - 1;
	  p += quote_system_arg (p, filename);
	  *p = '\0';
	}

      if (diffbuf)
	*diffbuf = 0;

      r = "ClearCase";
     }
  else if (!readonly && filestat &&
           (getenv("P4PORT") || getenv("P4USER") || getenv("P4CONFIG")))
    {
      if (getbuf)
	{
	  char *p = *getbuf = xmalloc (maxgetsize);
	  strcpy (p, PERFORCE_CO);
	  p += sizeof PERFORCE_CO - 1;
	  p += quote_system_arg (p, filename);
	  *p = '\0';
	}

      if (diffbuf)
	*diffbuf = 0;

      r = "Perforce";
    }

  free (trybuf);
  free (filebase);
  free (dir);
  return r;
}

/* Get FILENAME from version control system CS.  The file already exists if
   EXISTS.  Only readonly access is needed if READONLY.
   Use the command GETBUF to actually get the named file.
   Store the resulting file status into *FILESTAT.
   Return true if successful.  */
bool
version_get (char const *filename, char const *cs, bool exists, bool readonly,
	     char const *getbuf, struct stat *filestat)
{
  if (patch_get < 0)
    {
      ask ("Get file %s from %s%s? [y] ",
	   quotearg (filename), cs, readonly ? "" : " with lock");
      if (*buf == 'n')
	return 0;
    }

  if (dry_run)
    {
      if (! exists)
	fatal ("can't do dry run on nonexistent version-controlled file %s; invoke '%s' and try again",
	       quotearg (filename), getbuf);
    }
  else
    {
      if (verbosity == VERBOSE)
	say ("Getting file %s from %s%s...\n", quotearg (filename),
	     cs, readonly ? "" : " with lock");
      if (systemic (getbuf) != 0)
	fatal ("Can't get file %s from %s", quotearg (filename), cs);
      if (stat (filename, filestat) != 0)
	pfatal ("%s", quotearg (filename));
    }

  return 1;
}

/* Allocate a unique area for a string. */

char *
savebuf (char const *s, size_t size)
{
  char *rv;

  if (! size)
    return NULL;

  rv = malloc (size);

  if (! rv)
    {
      if (! using_plan_a)
	xalloc_die ();
    }
  else
    memcpy (rv, s, size);

  return rv;
}

char *
savestr (char const *s)
{
  return savebuf (s, strlen (s) + 1);
}

void
remove_prefix (char *p, size_t prefixlen)
{
  char const *s = p + prefixlen;
  while ((*p++ = *s++))
    /* do nothing */ ;
}

char *
format_linenum (char numbuf[LINENUM_LENGTH_BOUND + 1], lin n)
{
  char *p = numbuf + LINENUM_LENGTH_BOUND;
  *p = '\0';

  if (n < 0)
    {
      do
	*--p = '0' - (int) (n % 10);
      while ((n /= 10) != 0);

      *--p = '-';
    }
  else
    {
      do
	*--p = '0' + (int) (n % 10);
      while ((n /= 10) != 0);
    }

  return p;
}

/* Terminal output, pun intended. */

void
fatal (char const *format, ...)
{
  va_list args;
  fprintf (stderr, "%s: **** ", program_name);
  va_start (args, format);
  vfprintf (stderr, format, args);
  va_end (args);
  putc ('\n', stderr);
  fflush (stderr);
  fatal_exit (0);
}

void
xalloc_die (void)
{
  fatal ("out of memory");
}

void
read_fatal (void)
{
  pfatal ("read error");
}

void
write_fatal (void)
{
  pfatal ("write error");
}

/* Say something from patch, something from the system, then silence . . . */

void
pfatal (char const *format, ...)
{
  int errnum = errno;
  va_list args;
  fprintf (stderr, "%s: **** ", program_name);
  va_start (args, format);
  vfprintf (stderr, format, args);
  va_end (args);
  fflush (stderr); /* perror bypasses stdio on some hosts.  */
  errno = errnum;
  perror (" ");
  fflush (stderr);
  fatal_exit (0);
}

/* Tell the user something.  */

static void
vsay (char const *format, va_list args)
{
  vfprintf (stdout, format, args);
  fflush (stdout);
}

void
say (char const *format, ...)
{
  va_list args;
  va_start (args, format);
  vsay (format, args);
  va_end (args);
}

/* Get a response from the user, somehow or other. */

void
ask (char const *format, ...)
{
  static int ttyfd = -2;
  ssize_t r;
  va_list args;

  va_start (args, format);
  vfprintf (stdout, format, args);
  va_end (args);
  fflush (stdout);

  if (ttyfd == -2)
    {
      /* If standard output is not a tty, don't bother opening /dev/tty,
	 since it's unlikely that stdout will be seen by the tty user.
	 The isatty test also works around a bug in GNU Emacs 19.34 under Linux
	 which makes a call-process 'patch' hang when it reads from /dev/tty.
	 POSIX.1-2001 XCU line 26599 requires that we read /dev/tty,
	 though.  */
      ttyfd = (posixly_correct || isatty (STDOUT_FILENO)
	       ? open (TTY_DEVICE, O_RDONLY)
	       : -1);
    }

  if (ttyfd < 0)
    {
      /* No terminal at all -- default it.  */
      printf ("\n");
      buf[0] = '\n';
      buf[1] = '\0';
    }
  else
    {
      size_t s = 0;
      while ((r = read (ttyfd, buf + s, bufsize - 1 - s)) == bufsize - 1 - s
	     && buf[bufsize - 2] != '\n')
	{
	  s = bufsize - 1;
	  bufsize *= 2;
	  buf = realloc (buf, bufsize);
	  if (!buf)
	    xalloc_die ();
	}
      if (r == 0)
	printf ("EOF\n");
      else if (r < 0)
	{
	  error (0, errno, "tty read failed");
	  ignore_value (close (ttyfd));
	  ttyfd = -1;
	  r = 0;
	}
      buf[s + r] = '\0';
    }
}

/* Return nonzero if it OK to reverse a patch.  */

bool
ok_to_reverse (char const *format, ...)
{
  bool r = false;

  if (noreverse || ! (force && verbosity == SILENT))
    {
      va_list args;
      va_start (args, format);
      vsay (format, args);
      va_end (args);
    }

  if (noreverse)
    {
      say ("  Skipping patch.\n");
      skip_rest_of_patch = true;
    }
  else if (force)
    {
      if (verbosity != SILENT)
	say ("  Applying it anyway.\n");
    }
  else if (batch)
    {
      say (reverse ? "  Ignoring -R.\n" : "  Assuming -R.\n");
      r = true;
    }
  else
    {
      ask (reverse ? "  Ignore -R? [n] " : "  Assume -R? [n] ");
      r = *buf == 'y';
      if (! r)
	{
	  ask ("Apply anyway? [n] ");
	  if (*buf != 'y')
	    {
	      if (verbosity != SILENT)
		say ("Skipping patch.\n");
	      skip_rest_of_patch = true;
	    }
	}
    }

  return r;
}

/* How to handle certain events when not in a critical region. */

#define NUM_SIGS ((int) (sizeof (sigs) / sizeof (*sigs)))
static int const sigs[] = {
#ifdef SIGHUP
       SIGHUP,
#endif
#ifdef SIGPIPE
       SIGPIPE,
#endif
#ifdef SIGTERM
       SIGTERM,
#endif
#ifdef SIGXCPU
       SIGXCPU,
#endif
#ifdef SIGXFSZ
       SIGXFSZ,
#endif
       SIGINT
};

#if !HAVE_SIGPROCMASK
#define sigset_t int
#define sigemptyset(s) (*(s) = 0)
#ifndef sigmask
#define sigmask(sig) (1 << ((sig) - 1))
#endif
#define sigaddset(s, sig) (*(s) |= sigmask (sig))
#define sigismember(s, sig) ((*(s) & sigmask (sig)) != 0)
#define sigprocmask(how, n, o) \
  ((how) == SIG_BLOCK \
   ? ((o) ? *(o) = sigblock (*(n)) : sigblock (*(n))) \
   : (how) == SIG_UNBLOCK \
   ? sigsetmask (((o) ? *(o) = sigblock (0) : sigblock (0)) & ~*(n)) \
   : (o ? *(o) = sigsetmask (*(n)) : sigsetmask (*(n))))
#if !HAVE_SIGSETMASK
#define sigblock(mask) 0
#define sigsetmask(mask) 0
#endif
#endif

static sigset_t initial_signal_mask;
static sigset_t signals_to_block;

#if ! HAVE_SIGACTION
static void fatal_exit_handler (int) __attribute__ ((noreturn));
static void
fatal_exit_handler (int sig)
{
  signal (sig, SIG_IGN);
  fatal_exit (sig);
}
#endif

void
set_signals (bool reset)
{
  int i;
#if HAVE_SIGACTION
  struct sigaction initial_act, fatal_act;
  fatal_act.sa_handler = fatal_exit;
  sigemptyset (&fatal_act.sa_mask);
  fatal_act.sa_flags = 0;
#define setup_handler(sig) sigaction (sig, &fatal_act, (struct sigaction *) 0)
#else
#define setup_handler(sig) signal (sig, fatal_exit_handler)
#endif

  if (!reset)
    {
#ifdef SIGCHLD
      /* System V fork+wait does not work if SIGCHLD is ignored.  */
      signal (SIGCHLD, SIG_DFL);
#endif
      sigemptyset (&signals_to_block);
      for (i = 0;  i < NUM_SIGS;  i++)
	{
	  bool ignoring_signal;
#if HAVE_SIGACTION
	  if (sigaction (sigs[i], (struct sigaction *) 0, &initial_act) != 0)
	    continue;
	  ignoring_signal = initial_act.sa_handler == SIG_IGN;
#else
	  ignoring_signal = signal (sigs[i], SIG_IGN) == SIG_IGN;
#endif
	  if (! ignoring_signal)
	    {
	      sigaddset (&signals_to_block, sigs[i]);
	      setup_handler (sigs[i]);
	    }
	}
    }
  else
    {
      /* Undo the effect of ignore_signals.  */
#if HAVE_SIGPROCMASK || HAVE_SIGSETMASK
      sigprocmask (SIG_SETMASK, &initial_signal_mask, (sigset_t *) 0);
#else
      for (i = 0;  i < NUM_SIGS;  i++)
	if (sigismember (&signals_to_block, sigs[i]))
	  setup_handler (sigs[i]);
#endif
    }
}

/* How to handle certain events when in a critical region. */

void
ignore_signals (void)
{
#if HAVE_SIGPROCMASK || HAVE_SIGSETMASK
  sigprocmask (SIG_BLOCK, &signals_to_block, &initial_signal_mask);
#else
  int i;
  for (i = 0;  i < NUM_SIGS;  i++)
    if (sigismember (&signals_to_block, sigs[i]))
      signal (sigs[i], SIG_IGN);
#endif
}

void
exit_with_signal (int sig)
{
  sigset_t s;
  signal (sig, SIG_DFL);
  sigemptyset (&s);
  sigaddset (&s, sig);
  sigprocmask (SIG_UNBLOCK, &s, (sigset_t *) 0);
  raise (sig);
  exit (2);
}

int
systemic (char const *command)
{
  if (debug & 8)
    say ("+ %s\n", command);
  fflush (stdout);
  return system (command);
}

/* Replace '/' with '\0' in FILENAME if it marks a place that
   needs testing for the existence of directory.  Return the address
   of the last location replaced, or 0 if none were replaced.  */
static char *
replace_slashes (char *filename)
{
  char *f;
  char *last_location_replaced = 0;
  char const *component_start;

  for (f = filename + FILE_SYSTEM_PREFIX_LEN (filename);  ISSLASH (*f);  f++)
    /* do nothing */ ;

  component_start = f;

  for (; *f; f++)
    if (ISSLASH (*f))
      {
	char *slash = f;

	/* Treat multiple slashes as if they were one slash.  */
	while (ISSLASH (f[1]))
	  f++;

	/* Ignore slashes at the end of the path.  */
	if (! f[1])
	  break;

	/* "." and ".." need not be tested.  */
	if (! (slash - component_start <= 2
	       && component_start[0] == '.' && slash[-1] == '.'))
	  {
	    *slash = '\0';
	    last_location_replaced = slash;
	  }

	component_start = f + 1;
      }

  return last_location_replaced;
}

/* Make sure we'll have the directories to create a file.
   Ignore the last element of 'filename'.  */

static void
makedirs (char const *name)
{
  char *filename = xstrdup (name);
  char *f;
  char *flim = replace_slashes (filename);

  if (flim)
    {
      /* Create any missing directories, replacing NULs by '/'s.
	 Ignore errors.  We may have to keep going even after an EEXIST,
	 since the path may contain ".."s; and when there is an EEXIST
	 failure the system may return some other error number.
	 Any problems will eventually be reported when we create the file.  */
      for (f = filename;  f <= flim;  f++)
	if (!*f)
	  {
	    mkdir (filename,
		   S_IRUSR|S_IWUSR|S_IXUSR
		   |S_IRGRP|S_IWGRP|S_IXGRP
		   |S_IROTH|S_IWOTH|S_IXOTH);
	    *f = '/';
	  }
    }
  free (filename);
}

/* Remove empty ancestor directories of FILENAME.
   Ignore errors, since the path may contain ".."s, and when there
   is an EEXIST failure the system may return some other error number.  */
void
removedirs (char const *name)
{
  char *filename = xstrdup (name);
  size_t i;

  for (i = strlen (filename);  i != 0;  i--)
    if (ISSLASH (filename[i])
	&& ! (ISSLASH (filename[i - 1])
	      || (filename[i - 1] == '.'
		  && (i == 1
		      || ISSLASH (filename[i - 2])
		      || (filename[i - 2] == '.'
			  && (i == 2
			      || ISSLASH (filename[i - 3])))))))
      {
	filename[i] = '\0';
	if (rmdir (filename) == 0 && verbosity == VERBOSE)
	  say ("Removed empty directory %s\n", quotearg (filename));
	filename[i] = '/';
      }
  free (filename);
}

static struct timespec initial_time;

void
init_time (void)
{
  gettime (&initial_time);
}

static char *
parse_c_string (char const *s, char const **endp)
{
  char *u, *v;

  assert (*s == '"');
  s++;
  u = v = xmalloc (strlen (s));
  for (;;)
    {
      char c = *s++;

      switch (c)
	{
	  case 0:
	    goto fail;

	  case '"':
	    *v++ = 0;
	    v = realloc (u, v - u);
	    if (v)
	      u = v;
	    if (endp)
	      *endp = s;
	    return u;

	  case '\\':
	    break;

	  default:
	    *v++ = c;
	    continue;
	}

      c = *s++;
      switch (c)
	{
	  case 'a': c = '\a'; break;
	  case 'b': c = '\b'; break;
	  case 'f': c = '\f'; break;
	  case 'n': c = '\n'; break;
	  case 'r': c = '\r'; break;
	  case 't': c = '\t'; break;
	  case 'v': c = '\v'; break;
	  case '\\': case '"':
	    break;  /* verbatim */
	  case '0': case '1': case '2': case '3':
	    {
	      int acc = (c - '0') << 6;

	      c = *s++;
	      if (c < '0' || c > '7')
	        goto fail;
	      acc |= (c - '0') << 3;
	      c = *s++;
	      if (c < '0' || c > '7')
	        goto fail;
	      acc |= (c - '0');
	      c = acc;
	      break;
	    }
	  default:
	    goto fail;
	}
      *v++ = c;
    }

fail:
  free (u);
  if (endp)
    *endp = s;
  return NULL;
}

/* Strip up to STRIP_LEADING leading slashes.
   If STRIP_LEADING is negative, strip all leading slashes.
   Returns a pointer into NAME on success, and NULL otherwise.
  */
static bool
strip_leading_slashes (char *name, int strip_leading)
{
  int s = strip_leading;
  char *p, *n;

  for (p = n = name;  *p;  p++)
    {
      if (ISSLASH (*p))
	{
	  while (ISSLASH (p[1]))
	    p++;
	  if (strip_leading < 0 || --s >= 0)
	      n = p+1;
	}
    }
  if ((strip_leading < 0 || s <= 0) && *n)
    {
      memmove (name, n, strlen (n) + 1);
      return true;
    }
  else
    return false;
}


/* Make filenames more reasonable. */

void
fetchname (char const *at, int strip_leading, char **pname,
	   char **ptimestr, struct timespec *pstamp)
{
    char *name;
    const char *t;
    char *timestr = NULL;
    struct timespec stamp;

    stamp.tv_sec = -1;
    stamp.tv_nsec = 0;

    while (ISSPACE ((unsigned char) *at))
	at++;
    if (debug & 128)
	say ("fetchname %s %d\n", at, strip_leading);

    if (*at == '"')
      {
	name = parse_c_string (at, &t);
	if (! name)
	  {
	    if (debug & 128)
	      say ("ignoring malformed filename %s\n", quotearg (at));
	    return;
	  }
      }
    else
      {
	for (t = at;  *t;  t++)
	  {
	    if (ISSPACE ((unsigned char) *t))
	      {
		/* Allow file names with internal spaces,
		   but only if a tab separates the file name from the date.  */
		char const *u = t;
		while (*u != '\t' && ISSPACE ((unsigned char) u[1]))
		  u++;
		if (*u != '\t' && (strchr (u + 1, pstamp ? '\t' : '\n')))
		  continue;
		break;
	      }
	  }
	name = xmemdup0 (at, t - at);
      }

    /* If the name is "/dev/null", ignore the name and mark the file
       as being nonexistent.  The name "/dev/null" appears in patches
       regardless of how NULL_DEVICE is spelled.  */
    if (strcmp (name, "/dev/null") == 0)
      {
	free (name);
	if (pstamp)
	  {
	    pstamp->tv_sec = 0;
	    pstamp->tv_nsec = 0;
	  }
	return;
      }

    /* Ignore the name if it doesn't have enough slashes to strip off.  */
    if (! strip_leading_slashes (name, strip_leading))
      {
	free (name);
	return;
      }

    if (ptimestr)
      {
	char const *u = t + strlen (t);

	if (u != t && *(u-1) == '\n')
	  u--;
	if (u != t && *(u-1) == '\r')
	  u--;
	timestr = xmemdup0 (t, u - t);
      }

      if (*t != '\n')
	{
	  if (! pstamp)
	    {
	      free (name);
	      free (timestr);
	      return;
	    }

	  if (set_time | set_utc)
	    get_date (&stamp, t, &initial_time);
	  else
	    {
	      /* The head says the file is nonexistent if the
		 timestamp is the epoch; but the listed time is
		 local time, not UTC, and POSIX.1 allows local
		 time offset anywhere in the range -25:00 <
		 offset < +26:00.  Match any time in that range.  */
	      const struct timespec lower = { -25L * 60 * 60 },
				    upper = {  26L * 60 * 60 };
	      if (get_date (&stamp, t, &initial_time)
		  && timespec_cmp (stamp, lower) > 0
		  && timespec_cmp (stamp, upper) < 0) {
		      stamp.tv_sec = 0;
		      stamp.tv_nsec = 0;
	      }
	    }
	}

    free (*pname);
    *pname = name;
    if (ptimestr)
      {
	free (*ptimestr);
	*ptimestr = timestr;
      }
    if (pstamp)
      *pstamp = stamp;
}

char *
parse_name (char const *s, int strip_leading, char const **endp)
{
  char *ret;

  while (ISSPACE ((unsigned char) *s))
    s++;
  if (*s == '"')
    ret = parse_c_string (s, endp);
  else
    {
      char const *t;

      for (t = s; *t && ! ISSPACE ((unsigned char) *t); t++)
	/* do nothing*/ ;
      ret = xmemdup0 (s, t - s);
      if (endp)
	*endp = t;
    }
  if (! strip_leading_slashes (ret, strip_leading))
    {
      free (ret);
      ret = NULL;
    }
  return ret;
}

void
Fseek (FILE *stream, file_offset offset, int ptrname)
{
  if (file_seek (stream, offset, ptrname) != 0)
    pfatal ("fseek");
}

#ifndef TMPDIR
#define TMPDIR "/tmp"
#endif

int
make_tempfile (char const **name, char letter, char const *real_name,
	       int flags, mode_t mode)
{
  int try_makedirs_errno = ENOENT;
  char *template;

  if (real_name && ! dry_run)
    {
      char *dirname, *basename;

      dirname = dir_name (real_name);
      basename = base_name (real_name);

      template = xmalloc (strlen (dirname) + 1 + strlen (basename) + 9);
      sprintf (template, "%s/%s.%cXXXXXX", dirname, basename, letter);
      free (dirname);
      free (basename);
    }
  else
    {
      char const *tmpdir;

      tmpdir = getenv ("TMPDIR");  /* Unix tradition */
      if (! tmpdir)
	tmpdir = getenv ("TMP");  /* DOS tradition */
      if (! tmpdir)
	tmpdir = getenv ("TEMP");  /* another DOS tradition */
      if (! tmpdir)
	tmpdir = TMPDIR;

      template = xmalloc (strlen (tmpdir) + 10);
      sprintf (template, "%s/p%cXXXXXX", tmpdir, letter);
    }
  for(;;)
    {
      int fd;

      if (gen_tempname (template, 0, flags, GT_NOCREATE))
        pfatal ("Can't create temporary file %s", template);
    retry:
      fd = open (template, O_CREAT | O_EXCL | flags, mode);
      if (fd == -1)
        {
	  if (errno == try_makedirs_errno)
	    {
	      makedirs (template);
	      /* FIXME: When patch fails, this may leave around empty
	         directories.  */
	      try_makedirs_errno = 0;
	      goto retry;
	    }
	  if (errno == EEXIST)
	    continue;
	  pfatal ("Can't create temporary file %s", template);
	}
      *name = template;
      return fd;
    }
}

int stat_file (char const *filename, struct stat *st)
{
  int (*xstat)(char const *, struct stat *) =
    follow_symlinks ? stat : lstat;

  return xstat (filename, st) == 0 ? 0 : errno;
}

/* Check if a filename is relative and free of ".." components.
   Such a path cannot lead to files outside the working tree
   as long as the working tree only contains symlinks that are
   "filename_is_safe" when followed.  */
bool
filename_is_safe (char const *name)
{
  if (IS_ABSOLUTE_FILE_NAME (name))
    return false;
  while (*name)
    {
      if (*name == '.' && *++name == '.'
	  && ( ! *++name || ISSLASH (*name)))
	return false;
      while (*name && ! ISSLASH (*name))
	name++;
      while (ISSLASH (*name))
	name++;
    }
  return true;
}

/* Check if we are in the root of a particular filesystem namespace ("/" on
   UNIX or a particular drive's root on DOS-like systems).  */
bool
cwd_is_root (char const *name)
{
  unsigned int prefix_len = FILE_SYSTEM_PREFIX_LEN (name);
  char root[prefix_len + 2];
  struct stat st;
  dev_t root_dev;
  ino_t root_ino;

  memcpy (root, name, prefix_len);
  root[prefix_len] = '/';
  root[prefix_len + 1] = 0;
  if (stat (root, &st))
    return false;
  root_dev = st.st_dev;
  root_ino = st.st_ino;
  if (stat (".", &st))
    return false;
  return root_dev == st.st_dev && root_ino == st.st_ino;
}
