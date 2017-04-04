/*
 * Copyright (C) 2015 RoboVM AB
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

#define LOG_TAG "rt"

// NOTE: The compiler sorts fields. References first, then by alignment and then by name.
// So the order of the fields here don't match the order in Thread.java
typedef struct {
  Object object;
  Object* contextClassLoader;
  Object* group;
  Object* inheritableValues;
  Object* interruptActions;
  Object* localValues;
  Object* lock;
  Object* name;
  Object* parkBlocker;
  Object* target;
  Object* uncaughtHandler;
#if defined(BUGVM_THUMBV7)
  jlong id __attribute__ ((aligned (8))); // The compiler 8-byte aligns all long fields on ARM 32-bit.
#else
  jlong id;
#endif
  jlong stackSize;
  /*volatile*/ jlong threadPtr; // Points to the Thread
  jint parkState;
  jint priority;
  jboolean daemon;
  jboolean started;
} JavaThread;

// NOTE: The compiler sorts fields by type (ref, volatile long, double, long, float, int, char, short, boolean, byte) and then by name
// so the order of the fields here don't match the order in ClassLoader.java
typedef struct ClassLoader ClassLoader;
struct ClassLoader {
  Object object;
  Object* packages;
  ClassLoader* parent;
};


extern int registerCoreLibrariesJni(JNIEnv* env);

LAZY_CLASS(class_java_lang_String, "java/lang/String");
LAZY_CLASS(class_java_lang_Thread, "java/lang/Thread");
LAZY_INSTANCE_METHOD(method_java_lang_String_init, class_java_lang_String, "<init>", "(II[C)V");
LAZY_INSTANCE_METHOD(method_java_lang_Thread_init, class_java_lang_Thread, "<init>", "(JLjava/lang/String;Ljava/lang/ThreadGroup;Z)V");
LAZY_INSTANCE_FIELD(field_java_lang_String_value, class_java_lang_String, "value", "[C");
LAZY_INSTANCE_FIELD(field_java_lang_String_offset, class_java_lang_String, "offset", "I");
LAZY_INSTANCE_FIELD(field_java_lang_String_count, class_java_lang_String, "count", "I");

Object* bugvmRTNewString(Env* env, CharArray* value, jint offset, jint length) {
    jvalue args[3];
    args[0].i = offset;
    args[1].i = length;
    args[2].l = (jobject) value;
    return bugvmNewObjectA(env, class_java_lang_String(env), method_java_lang_String_init(env), args);
}

jint bugvmRTGetStringLength(Env* env, Object* str) {
    return bugvmGetIntInstanceFieldValue(env, str, field_java_lang_String_count(env));
}

jchar* bugvmRTGetStringChars(Env* env, Object* str) {
    CharArray* value = (CharArray*) bugvmGetObjectInstanceFieldValue(env, str, field_java_lang_String_value(env));
    jint offset = bugvmGetIntInstanceFieldValue(env, str, field_java_lang_String_offset(env));
    return value->values + offset;
}

void bugvmRTInitAttachedThread(Env* env, Object* threadObj, Thread* thread, Object* threadName, Object* group, jboolean daemon) {
    ((JavaThread*) threadObj)->threadPtr = PTR_TO_LONG(thread);
    bugvmCallNonvirtualVoidInstanceMethod(env, (Object*) threadObj, method_java_lang_Thread_init(env), PTR_TO_LONG(thread), threadName, group, daemon);
}

void bugvmRTSetThreadContextClassLoader(Env* env, Object* threadObj, Object* classLoader) {
    ((JavaThread*) threadObj)->contextClassLoader = classLoader;
}

Thread* bugvmRTGetNativeThread(Env* env, Object* threadObj) {
    return (Thread*) LONG_TO_PTR(((JavaThread*) threadObj)->threadPtr);
}

void bugvmRTClearNativeThread(Env* env, Object* threadObj) {
    bugvmAtomicStoreLong(&((JavaThread*) threadObj)->threadPtr, 0);
}

void bugvmRTSetNativeThread(Env* env, Object* threadObj, Thread* thread) {
    ((JavaThread*) threadObj)->threadPtr = PTR_TO_LONG(thread);
}

Object* bugvmRTGetThreadGroup(Env* env, Object* threadObj) {
    return ((JavaThread*) threadObj)->group;
}

jboolean bugvmRTIsDaemonThread(Env* env, Object* threadObj) {
    return ((JavaThread*) threadObj)->daemon;
}

jint bugvmRTGetThreadPriority(Env* env, Object* threadObj) {
    return ((JavaThread*) threadObj)->priority;
}

jint bugvmRTGetThreadStackSize(Env* env, Object* threadObj) {
    return ((JavaThread*) threadObj)->stackSize;
}

jlong bugvmRTGetThreadId(Env* env, Object* threadObj) {
    return ((JavaThread*) threadObj)->id;
}

void bugvmRTResumeJoiningThreads(Env* env, Object* threadObj) {
    // Notify anyone waiting on this thread (using Thread.join())
    Object* lock = ((JavaThread*) threadObj)->lock;
    bugvmLockObject(env, lock);
    bugvmObjectNotifyAll(env, lock);
    bugvmUnlockObject(env, lock);
}

Object* bugvmRTGetParentClassLoader(Env* env, Object* classLoader) {
    return (Object*) ((ClassLoader*) classLoader)->parent;
}

const char* bugvmRTGetName(void) {
    return "Android";
}

jboolean bugvmRTInit(Env* env) {
    registerCoreLibrariesJni((JNIEnv*) env);
    return TRUE;
}
