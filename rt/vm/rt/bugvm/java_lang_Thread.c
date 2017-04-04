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
#include <bugvm.h>

Object* Java_java_lang_Thread_currentThread(Env* env, Class* cls) {
    return env->currentThread->threadObj;
}

void Java_java_lang_Thread_internalStart(Env* env, Class* cls, Object* t) {
    bugvmStartThread(env, t);
}

void Java_java_lang_Thread_internalSleep(Env* env, Class* cls, jlong millis, jint nanos) {
    bugvmThreadSleep(env, millis, nanos);
}

void Java_java_lang_Thread_internalSetName(Env* env, Class* cls, Object* threadObj, Object* threadName) {
    bugvmLockThreadsList();
    Thread* thread = bugvmRTGetNativeThread(env, threadObj);
    if (thread) {
        bugvmThreadNameChanged(env, thread);
    }
    bugvmUnlockThreadsList();
}

jboolean Java_java_lang_Thread_internalInterrupted(Env* env, Class* cls) {
    jboolean interrupted = env->currentThread->interrupted;
    env->currentThread->interrupted = FALSE;
    return interrupted;
}

jboolean Java_java_lang_Thread_internalIsInterrupted(Env* env, Class* cls, Object* threadObj) {
    bugvmLockThreadsList();
    Thread* thread = bugvmRTGetNativeThread(env, threadObj);
    jboolean interrupted = FALSE;
    if (thread) {
        interrupted = thread->interrupted;
    }
    bugvmUnlockThreadsList();
    return interrupted;
}

void Java_java_lang_Thread_internalInterrupt(Env* env, Class* cls, Object* threadObj) {
    bugvmLockThreadsList();
    Thread* thread = bugvmRTGetNativeThread(env, threadObj);
    if (thread) {
        bugvmThreadInterrupt(env, thread);
    }
    bugvmUnlockThreadsList();
}

jboolean Java_java_lang_Thread_internalHoldsLock(Env* env, Class* cls, Object* obj) {
    if (!obj) {
        bugvmThrowNullPointerException(env);
        return FALSE;
    }
    bugvmLockThreadsList();
    jboolean result = bugvmHoldsLock(env, env->currentThread, obj);
    bugvmUnlockThreadsList();
    return result;
}

void Java_java_lang_Thread_internalYield(Env* env, Class* cls) {
    sched_yield();
}

jint Java_java_lang_Thread_internalGetState(Env* env, Class* cls, Object* threadObj) {
    bugvmLockThreadsList();
    Thread* thread = bugvmRTGetNativeThread(env, threadObj);
    jint status = THREAD_ZOMBIE; // If thread==NULL we assume the thread has been finished
    if (thread) {
        status = thread->status;
    }
    bugvmUnlockThreadsList();
    return status;
}

void Java_java_lang_Thread_internalSetPriority(Env* env, Class* cls, Object* threadObj, jint priority) {
    bugvmLockThreadsList();
    Thread* thread = bugvmRTGetNativeThread(env, threadObj);
    if (thread) {
        bugvmChangeThreadPriority(env, thread, priority);
    }
    bugvmUnlockThreadsList();
}

ObjectArray* Java_java_lang_Thread_internalGetStackTrace(Env* env, Class* cls, Object* threadObj) {
    Thread* thread = bugvmRTGetNativeThread(env, threadObj);
    CallStack* callStack = NULL;
    if (thread) {
        callStack = bugvmCaptureCallStackForThread(env, thread);
    }
    return bugvmCallStackToStackTraceElements(env, callStack, 0);
}

void Java_java_lang_Thread_hookThreadCreated(Env* env, Class* cls, Object* threadObj) {
    bugvmHookThreadCreated(env, threadObj);
}
