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
#ifndef BUGVM_EXCEPTION_H
#define BUGVM_EXCEPTION_H

extern jboolean bugvmInitExceptions(Env* env);
extern void bugvmExceptionPrintStackTrace(Env* env, Object* e, FILE* f);
extern void bugvmPrintStackTrace(Env* env, Object* throwable);
extern void bugvmThrow(Env* env, Object* e);
extern jboolean bugvmThrowNew(Env* env, Class* clazz, const char* message);
extern jboolean bugvmThrowNewf(Env* env, Class* clazz, const char* format, ...);
extern jboolean bugvmThrowNewfv(Env* env, Class* clazz, const char* format, va_list ap);
extern jboolean bugvmThrowInternalErrorErrno(Env* env, int errnum);
extern jboolean bugvmThrowOutOfMemoryError(Env* env);
extern jboolean bugvmThrowNoClassDefFoundError(Env* env, const char* message);
extern jboolean bugvmThrowIllegalAccessError(Env* env, const char* message);
extern jboolean bugvmThrowNoSuchFieldError(Env* env, const char* message);
extern jboolean bugvmThrowNoSuchMethodError(Env* env, const char* message);
extern jboolean bugvmThrowIncompatibleClassChangeError(Env* env,const char* message);
extern jboolean bugvmThrowIncompatibleClassChangeErrorClassField(Env* env, Class* clazz, const char* name, const char* desc);
extern jboolean bugvmThrowIncompatibleClassChangeErrorInstanceField(Env* env, Class* clazz, const char* name, const char* desc);
extern jboolean bugvmThrowIncompatibleClassChangeErrorMethod(Env* env, Class* clazz, const char* name, const char* desc);
extern jboolean bugvmThrowInstantiationError(Env* env, const char* message);
extern jboolean bugvmThrowClassCastException(Env* env, Class* expectedType, Class* actualType);
extern jboolean bugvmThrowNullPointerException(Env* env);
extern jboolean bugvmThrowAbstractMethodError(Env* env, const char* message);
extern jboolean bugvmThrowArrayIndexOutOfBoundsException(Env* env, jint length, jint index);
extern jboolean bugvmThrowArrayStoreException(Env* env, Class* elemType, Class* arrayType);
extern jboolean bugvmThrowNegativeArraySizeException(Env* env);
extern jboolean bugvmThrowClassNotFoundException(Env* env, const char* className);
extern jboolean bugvmThrowUnsatisfiedLinkError(Env* env, const char* message);
extern jboolean bugvmThrowIllegalArgumentException(Env* env, const char* message);
extern jboolean bugvmThrowArithmeticException(Env* env);
extern jboolean bugvmThrowLinkageError(Env* env);
extern jboolean bugvmThrowIllegalMonitorStateException(Env* env, const char* message);
extern jboolean bugvmThrowInterruptedException(Env* env);
extern jboolean bugvmThrowIllegalStateException(Env* env, const char* message);
extern void bugvmRaiseException(Env* env, Object* e);

static inline jboolean bugvmExceptionCheck(Env* env) {
    return env->throwable ? TRUE : FALSE;
}

static inline Object* bugvmExceptionOccurred(Env* env) {
    return env->throwable;
}

static inline Object* bugvmExceptionClear(Env* env) {
    Object* e = env->throwable;
    env->throwable = NULL;
    return e;
}

#endif

