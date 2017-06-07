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
#ifndef BUGVM_METHOD_H
#define BUGVM_METHOD_H

#define METHOD_ACCESS_MASK   0x0000FFFF
#define METHOD_TYPE_BRIDGE   0x20000000
#define METHOD_TYPE_CALLBACK 0x40000000
#define METHOD_TYPE_PROXY    0x80000000

#define METHOD_IS_PUBLIC(m) (IS_PUBLIC((m)->access))
#define METHOD_IS_PRIVATE(m) (IS_PRIVATE((m)->access))
#define METHOD_IS_PROTECTED(m) (IS_PROTECTED((m)->access))
#define METHOD_IS_STATIC(m) (IS_STATIC((m)->access))
#define METHOD_IS_FINAL(m) (IS_FINAL((m)->access))
#define METHOD_IS_SYNCHRONIZED(m) (IS_SYNCHRONIZED((m)->access))
#define METHOD_IS_NATIVE(m) (IS_NATIVE((m)->access))
#define METHOD_IS_ABSTRACT(m) (IS_ABSTRACT((m)->access))
#define METHOD_IS_PACKAGE_PRIVATE(m) (IS_PACKAGE_PRIVATE((m)->access))
#define METHOD_IS_CONSTRUCTOR(m) (!strcmp("<init>", (m)->name))
#define METHOD_IS_CLASS_INITIALIZER(m) (!strcmp("<clinit>", (m)->name))

// The maximum number of CallStackFrames returned by bugvmCaptureCallStack() including native frames
#define MAX_CALL_STACK_LENGTH 2048

extern jboolean bugvmInitMethods(Env* env);
extern const char* bugvmGetReturnType(const char* desc);
extern const char* bugvmGetNextParameterType(const char** desc);
extern jint bugvmGetParameterCount(Method* method);
extern Method* bugvmGetMethod(Env* env, Class* clazz, const char* name, const char* desc);
extern jboolean bugvmHasMethod(Env* env, Class* clazz, const char* name, const char* desc);
extern Method* bugvmGetClassMethod(Env* env, Class* clazz, const char* name, const char* desc);
extern Method* bugvmGetClassInitializer(Env* env, Class* clazz);
extern Method* bugvmGetInstanceMethod(Env* env, Class* clazz, const char* name, const char* desc);
extern jboolean bugvmRegisterNative(Env* env, NativeMethod* method, void* impl);
extern jboolean bugvmUnregisterNative(Env* env, NativeMethod* method);
extern void* bugvmResolveNativeMethodImpl(Env* env, NativeMethod* method, const char* shortMangledName, const char* longMangledName, Object* classLoader, void** ptr);
extern jboolean bugvmLoadNativeLibrary(Env* env, const char* path, Object* classLoader);
extern Method* bugvmFindMethodAtAddress(Env* env, void* address);
extern Method* bugvmGetCallingMethod(Env* env);
extern CallStack* bugvmCaptureCallStack(Env* env);
extern CallStack* bugvmCaptureCallStackForThread(Env* env, Thread* thread);
extern CallStackFrame* bugvmResolveCallStackFrame(Env* env, CallStackFrame* frame);
extern ObjectArray* bugvmCallStackToStackTraceElements(Env* env, CallStack* callStack, jint first);
extern void bugvmCallVoidInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern void bugvmCallVoidInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern void bugvmCallVoidInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern Object* bugvmCallObjectInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern Object* bugvmCallObjectInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern Object* bugvmCallObjectInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jboolean bugvmCallBooleanInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jboolean bugvmCallBooleanInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jboolean bugvmCallBooleanInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jbyte bugvmCallByteInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jbyte bugvmCallByteInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jbyte bugvmCallByteInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jchar bugvmCallCharInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jchar bugvmCallCharInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jchar bugvmCallCharInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jshort bugvmCallShortInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jshort bugvmCallShortInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jshort bugvmCallShortInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jint bugvmCallIntInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jint bugvmCallIntInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jint bugvmCallIntInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jlong bugvmCallLongInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jlong bugvmCallLongInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jlong bugvmCallLongInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jfloat bugvmCallFloatInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jfloat bugvmCallFloatInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jfloat bugvmCallFloatInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jdouble bugvmCallDoubleInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jdouble bugvmCallDoubleInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jdouble bugvmCallDoubleInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern void bugvmCallNonvirtualVoidInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern void bugvmCallNonvirtualVoidInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern void bugvmCallNonvirtualVoidInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern Object* bugvmCallNonvirtualObjectInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern Object* bugvmCallNonvirtualObjectInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern Object* bugvmCallNonvirtualObjectInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jboolean bugvmCallNonvirtualBooleanInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jboolean bugvmCallNonvirtualBooleanInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jboolean bugvmCallNonvirtualBooleanInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jbyte bugvmCallNonvirtualByteInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jbyte bugvmCallNonvirtualByteInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jbyte bugvmCallNonvirtualByteInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jchar bugvmCallNonvirtualCharInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jchar bugvmCallNonvirtualCharInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jchar bugvmCallNonvirtualCharInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jshort bugvmCallNonvirtualShortInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jshort bugvmCallNonvirtualShortInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jshort bugvmCallNonvirtualShortInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jint bugvmCallNonvirtualIntInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jint bugvmCallNonvirtualIntInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jint bugvmCallNonvirtualIntInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jlong bugvmCallNonvirtualLongInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jlong bugvmCallNonvirtualLongInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jlong bugvmCallNonvirtualLongInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jfloat bugvmCallNonvirtualFloatInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jfloat bugvmCallNonvirtualFloatInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jfloat bugvmCallNonvirtualFloatInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern jdouble bugvmCallNonvirtualDoubleInstanceMethod(Env* env, Object* obj, Method* method, ...);
extern jdouble bugvmCallNonvirtualDoubleInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args);
extern jdouble bugvmCallNonvirtualDoubleInstanceMethodV(Env* env, Object* obj, Method* method, va_list args);
extern void bugvmCallVoidClassMethod(Env* env, Class* clazz, Method* method, ...);
extern void bugvmCallVoidClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern void bugvmCallVoidClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern Object* bugvmCallObjectClassMethod(Env* env, Class* clazz, Method* method, ...);
extern Object* bugvmCallObjectClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern Object* bugvmCallObjectClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jboolean bugvmCallBooleanClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jboolean bugvmCallBooleanClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jboolean bugvmCallBooleanClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jbyte bugvmCallByteClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jbyte bugvmCallByteClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jbyte bugvmCallByteClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jchar bugvmCallCharClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jchar bugvmCallCharClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jchar bugvmCallCharClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jshort bugvmCallShortClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jshort bugvmCallShortClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jshort bugvmCallShortClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jint bugvmCallIntClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jint bugvmCallIntClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jint bugvmCallIntClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jlong bugvmCallLongClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jlong bugvmCallLongClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jlong bugvmCallLongClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jfloat bugvmCallFloatClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jfloat bugvmCallFloatClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jfloat bugvmCallFloatClassMethodV(Env* env, Class* clazz, Method* method, va_list args);
extern jdouble bugvmCallDoubleClassMethod(Env* env, Class* clazz, Method* method, ...);
extern jdouble bugvmCallDoubleClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args);
extern jdouble bugvmCallDoubleClassMethodV(Env* env, Class* clazz, Method* method, va_list args);


static inline CallStackFrame* bugvmGetNextCallStackMethod(Env* env, CallStack* callStack, jint* index) {
    while (*index < callStack->length) {
        CallStackFrame* frame = bugvmResolveCallStackFrame(env, &callStack->frames[*index]);
        *index += 1;
        if (frame && frame->method) {
            return frame;
        }
    }
    return NULL;
}

#endif

