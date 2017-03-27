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
#ifndef BUGVM_MUTEX_H
#define BUGVM_MUTEX_H

#include <pthread.h>

/* Mutex wrappers around pthread mutexes */
static inline jint bugvmInitMutex(Mutex* mutex) {
    pthread_mutexattr_t mutexAttrs;
    pthread_mutexattr_init(&mutexAttrs);
    pthread_mutexattr_settype(&mutexAttrs, PTHREAD_MUTEX_RECURSIVE);
    return pthread_mutex_init(mutex, &mutexAttrs);
}
static inline jint bugvmDestroyMutex(Mutex* mutex) {
    return pthread_mutex_destroy(mutex);
}
static inline jint bugvmLockMutex(Mutex* mutex) {
    return pthread_mutex_lock(mutex);
}
static inline jint bugvmTryLockMutex(Mutex* mutex) {
    return pthread_mutex_trylock(mutex);
}
static inline jint bugvmUnlockMutex(Mutex* mutex) {
    return pthread_mutex_unlock(mutex);
}

#endif
