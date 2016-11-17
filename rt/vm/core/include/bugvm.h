/*
 * Copyright (C) 2012 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#ifndef BUGVM_H
#define BUGVM_H

#ifdef BUGVM_CORE_BUILD
#   ifndef GC_THREADS
#       define GC_THREADS
#   endif
#   include <gc.h>
#endif

#include <stdlib.h>
#include <stdint.h>
#include <stdio.h>
#include <stdarg.h>
#include <assert.h>

// Keep assert() even in release builds but just abort.
#ifdef NDEBUG
#   ifdef assert
#       undef assert
#   endif
#   define assert(e) ((void) ((e) ? 0 : rvmAbort(NULL)))
#endif

#ifdef __cplusplus
extern "C" {
#endif

#include "bugvm/types.h"
#include "bugvm/bitvector.h"
#include "bugvm/access.h"
#include "bugvm/atomic.h"
#include "bugvm/init.h"
#include "bugvm/memory.h"
#include "bugvm/method.h"
#include "bugvm/field.h"
#include "bugvm/class.h"
#include "bugvm/array.h"
#include "bugvm/exception.h"
#include "bugvm/string.h"
#include "bugvm/thread.h"
#include "bugvm/attribute.h"
#include "bugvm/native.h"
#include "bugvm/proxy.h"
#include "bugvm/log.h"
#include "bugvm/trycatch.h"
#include "bugvm/mutex.h"
#include "bugvm/monitor.h"
#include "bugvm/signal.h"
#include "bugvm/hooks.h"
#include "bugvm/rt.h"
#include "bugvm/lazy_helpers.h"

#ifdef __cplusplus
}
#endif

#endif

