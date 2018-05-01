# Customize maint.mk                           -*- makefile -*-
# Copyright (C) 2011-2012 Free Software Foundation, Inc.

# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.

# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.

# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.

config_h_header = <(common|config)\.h>

update-copyright-env = \
  UPDATE_COPYRIGHT_USE_INTERVALS=1 \
  UPDATE_COPYRIGHT_MAX_LINE_LENGTH=79

local-checks-to-skip = \
  sc_GPL_version \
  sc_bindtextdomain \
  sc_file_system \
  sc_immutable_NEWS \
  sc_obsolete_symbols \
  sc_prohibit_always_true_header_tests \
  sc_prohibit_magic_number_exit \
  sc_prohibit_strcmp \
  sc_prohibit_test_minus_ao \
  sc_require_test_exit_idiom

exclude_file_name_regexp--sc_prohibit_doubled_word = ^src/util\.c$$
exclude_file_name_regexp--sc_unmarked_diagnostics = ^src/util\.c$$
