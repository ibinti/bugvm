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
#include <stddef.h>
#include <string.h>
#include "private.h"

#define LOG_TAG "core.exception"
#define THROW_FORMAT_BUF_SIZE 512

static InstanceField* stackStateField = NULL;
static Method* printStackTraceMethod = NULL;

jboolean bugvmInitExceptions(Env* env) {
    stackStateField = bugvmGetInstanceField(env, java_lang_Throwable, "stackState", "J");
    if (!stackStateField) return FALSE;
    printStackTraceMethod = bugvmGetInstanceMethod(env, java_lang_Thread, "printStackTrace", "(Ljava/lang/Throwable;)V");
    if (!printStackTraceMethod) return FALSE;
    return TRUE;
}

void bugvmRaiseException(Env* env, Object* e) {
    if (env->throwable != e) {
        bugvmThrow(env, e);
    }
    jboolean (*exceptionMatch)(Env*, TrycatchContext*) = env->vm->options->exceptionMatch;
    TrycatchContext* tc = env->trycatchContext;
    while (tc) {
        if (tc->sel != 0 && (tc->sel == CATCH_ALL_SEL || exceptionMatch(env, tc))) {
            bugvmRestoreThreadSignalMask(env);
            bugvmHookExceptionRaised(env, e, tc->prev? TRUE: FALSE);
            bugvmTrycatchJump(tc);
            // unreachable
        }
        bugvmTrycatchLeave(env);
        tc = env->trycatchContext;
    }

    /*
     * We only end up here if Java was called into from native without a
     * TrycatchContext being set up first. This only happens for @Callback
     * methods. The only sane thing to do here is to terminate the app. But
     * first we want to detach the current thread which will report the
     * uncaught exception to the uncaught exception handler.
     */
    env->gatewayFrames = NULL; // Needed to avoid the "Cannot detach thread when there are non native frames on the call stack" error
    bugvmDetachCurrentThread(env->vm, TRUE, TRUE);
    bugvmAbort("Unhandled exception (probably in a @Callback method called from native code): %s", e->clazz->name);
}

void bugvmExceptionPrintStackTrace(Env* env, Object* e, FILE* f) {
    // TODO: Write the stack trace to the FILE*
    fprintf(stderr, "Exception occurred: %s\n", e->clazz->name);
}

void bugvmPrintStackTrace(Env* env, Object* throwable) {
    jvalue args[1];
    args[0].l = (jobject) throwable;
    bugvmCallVoidInstanceMethodA(env, (Object*) env->currentThread, printStackTraceMethod, args);
}

void bugvmThrow(Env* env, Object* e) {
    // TODO: Check that e != NULL?
    if (env->throwable) {
        bugvmAbort("bugvmThrow() called with env->throwable already set");
    }
    if (IS_TRACE_ENABLED) {
        jlong stackState = bugvmGetLongInstanceFieldValue(env, e, stackStateField);
        CallStack* callStack = (CallStack*) LONG_TO_PTR(stackState);
        if (!callStack || callStack->length == 0) {
            TRACEF("Throwing a %s with empty call stack", e->clazz->name);
        } else {
            TRACEF("Throwing a %s. Call stack:", e->clazz->name);
            CallStackFrame* frame;
            jint index = 0;
            while ((frame = bugvmGetNextCallStackMethod(env, callStack, &index)) != NULL) {
                Method* m = frame->method;
                TRACEF("    %s.%s%s", m->clazz->name, m->name, m->desc);
            }
        }
    }
    env->throwable = e;
}

jboolean bugvmThrowNew(Env* env, Class* clazz, const char* message) {
    Method* constructor = bugvmGetInstanceMethod(env, clazz, "<init>", "(Ljava/lang/String;)V");
    if (!constructor) return FALSE;
    Object* string = NULL;
    // TODO: Check that clazz != NULL?
    if (message) {
        string = bugvmNewStringUTF(env, message, -1);
        if (!string) return FALSE;
    }
    jvalue args[1];
    args[0].l = (jobject) string;
    Object* e = bugvmNewObjectA(env, clazz, constructor, args);
    if (!e) return FALSE;
    bugvmThrow(env, e);
    return TRUE;
}

jboolean bugvmThrowNewf(Env* env, Class* clazz, const char* format, ...) {
    va_list ap;
    char message[THROW_FORMAT_BUF_SIZE];
    va_start(ap, format);
    vsnprintf(message, THROW_FORMAT_BUF_SIZE, format, ap);
    va_end(ap);
    return bugvmThrowNew(env, clazz, message);
}

jboolean bugvmThrowNewfv(Env* env, Class* clazz, const char* format, va_list ap) {
    char message[THROW_FORMAT_BUF_SIZE];
    vsnprintf(message, THROW_FORMAT_BUF_SIZE, format, ap);
    return bugvmThrowNew(env, clazz, message);
}

jboolean bugvmThrowInternalErrorErrno(Env* env, int errnum) {
    char message[THROW_FORMAT_BUF_SIZE];
    if (strerror_r(errnum, message, THROW_FORMAT_BUF_SIZE) == 0) {
        return bugvmThrowNew(env, java_lang_InternalError, message);
    } else {
        return bugvmThrowNew(env, java_lang_InternalError, NULL);
    }
}

jboolean bugvmThrowOutOfMemoryError(Env* env) {
    // Don't run the constructor on OutOfMemoryError instances since that will
    // likely cause more OOM.
    Object* e = bugvmAllocateObject(env, java_lang_OutOfMemoryError);
    if (!e) {
        return FALSE;
    }
    bugvmThrow(env, e);
    return TRUE;
}

jboolean bugvmThrowNoClassDefFoundError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_NoClassDefFoundError, message);
}

jboolean bugvmThrowLinkageError(Env* env) {
    return bugvmThrowNew(env, java_lang_LinkageError, "");
}

jboolean bugvmThrowIllegalAccessError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_IllegalAccessError, message);
}

jboolean bugvmThrowNoSuchFieldError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_NoSuchFieldError, message);
}

jboolean bugvmThrowNoSuchMethodError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_NoSuchMethodError, message);
}

jboolean bugvmThrowIncompatibleClassChangeError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_IncompatibleClassChangeError, message);
}

jboolean bugvmThrowIncompatibleClassChangeErrorClassField(Env* env, Class* clazz, const char* name, const char* desc) {
    // TODO: Message should look like "java.lang.ThrowIncompatibleClassChangeError: Expected static field a.C.x"
    return bugvmThrowNew(env, java_lang_IncompatibleClassChangeError, "");
}

jboolean bugvmThrowIncompatibleClassChangeErrorInstanceField(Env* env, Class* clazz, const char* name, const char* desc) {
    // TODO: Message should look like "java.lang.ThrowIncompatibleClassChangeError: Expected non-static field a.C.x"
    return bugvmThrowNew(env, java_lang_IncompatibleClassChangeError, "");
}

jboolean bugvmThrowIncompatibleClassChangeErrorMethod(Env* env, Class* clazz, const char* name, const char* desc) {
    // TODO: Message should look like ?
    return bugvmThrowNew(env, java_lang_IncompatibleClassChangeError, "");
}

jboolean bugvmThrowClassCastException(Env* env, Class* expectedType, Class* actualType) {
    const char* expectedTypeName = bugvmGetHumanReadableClassName(env, expectedType);
    if (!expectedTypeName) return FALSE;
    const char* actualTypeName = bugvmGetHumanReadableClassName(env, actualType);
    if (!actualTypeName) return FALSE;
    return bugvmThrowNewf(env, java_lang_ClassCastException, "%s cannot be cast to %s", actualTypeName, expectedTypeName);
}

jboolean bugvmThrowNullPointerException(Env* env) {
    return bugvmThrowNew(env, java_lang_NullPointerException, NULL);
}

jboolean bugvmThrowAbstractMethodError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_AbstractMethodError, message);
}

jboolean bugvmThrowArrayIndexOutOfBoundsException(Env* env, jint length, jint index) {
    return bugvmThrowNewf(env, java_lang_ArrayIndexOutOfBoundsException, "length=%d; index=%d", length, index);
}

jboolean bugvmThrowArrayStoreException(Env* env, Class* elemType, Class* arrayType) {
    const char* elemTypeName = bugvmGetHumanReadableClassName(env, elemType);
    if (!elemTypeName) return FALSE;
    const char* arrayTypeName = bugvmGetHumanReadableClassName(env, arrayType);
    if (!arrayTypeName) return FALSE;
    return bugvmThrowNewf(env, java_lang_ArrayStoreException,
        "%s cannot be stored in an array of type %s", elemTypeName, arrayTypeName);
}

jboolean bugvmThrowClassNotFoundException(Env* env, const char* className) {
    char* msg = bugvmToBinaryClassName(env, className);
    if (!msg) return FALSE;
    return bugvmThrowNew(env, java_lang_ClassNotFoundException, msg);
}

jboolean bugvmThrowNegativeArraySizeException(Env* env) {
    return bugvmThrowNew(env, java_lang_NegativeArraySizeException, "");
}

jboolean bugvmThrowUnsatisfiedLinkError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_UnsatisfiedLinkError, message);
}

jboolean bugvmThrowIllegalArgumentException(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_IllegalArgumentException, message);
}

jboolean bugvmThrowArithmeticException(Env* env) {
    return bugvmThrowNew(env, java_lang_ArithmeticException, NULL);
}

jboolean bugvmThrowIllegalMonitorStateException(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_IllegalMonitorStateException, message);
}

jboolean bugvmThrowInterruptedException(Env* env) {
    return bugvmThrowNew(env, java_lang_InterruptedException, NULL);
}

jboolean bugvmThrowIllegalStateException(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_IllegalStateException, message);
}

jboolean bugvmThrowInstantiationError(Env* env, const char* message) {
    return bugvmThrowNew(env, java_lang_InstantiationError, message);
}

