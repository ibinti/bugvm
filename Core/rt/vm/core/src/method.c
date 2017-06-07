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
#include <string.h>
#include <unwind.h>
#include "private.h"
#include "utlist.h"

#define LOG_TAG "core.method"

// Line numbers greater or equal to this value is used
// for methods which have no line number info.
#define FIRST_NO_LINE_NUMBERS_LINE 0x00100000

DynamicLib* bootNativeLibs = NULL;
DynamicLib* mainNativeLibs = NULL;

static Mutex nativeLibsLock;
static Mutex threadStackTraceLock;
static jvalue emptyJValueArgs[1];
static Class* java_lang_StackTraceElement = NULL;
static Method* java_lang_StackTraceElement_constructor = NULL;
static ObjectArray* empty_java_lang_StackTraceElement_array = NULL;


// A shared CallStack struct used by bugvmCaptureCallStackForThread() that can store at most MAX_CALL_STACK_LENGTH
// frames. dumpThreadStackTrace() assumes MAX_CALL_STACK_LENGTH.
static CallStack* shared_callStack = NULL;

static inline void obtainNativeLibsLock() {
    bugvmLockMutex(&nativeLibsLock);
}

static inline void releaseNativeLibsLock() {
    bugvmUnlockMutex(&nativeLibsLock);
}

static inline void obtainThreadStackTraceLock() {
    bugvmLockMutex(&threadStackTraceLock);
}

static inline void releaseThreadStackTraceLock() {
    bugvmUnlockMutex(&threadStackTraceLock);
}

static Method* findMethod(Env* env, Class* clazz, const char* name, const char* desc) {
    Method* method = bugvmGetMethods(env, clazz);
    if (bugvmExceptionCheck(env)) return NULL;
    for (; method != NULL; method = method->next) {
        if (!strcmp(method->name, name) && !strcmp(method->desc, desc)) {
            return method;
        }
    }
    return NULL;
}

static Method* getMethod(Env* env, Class* clazz, const char* name, const char* desc) {
    if (!strcmp("<init>", name) || !strcmp("<clinit>", name)) {
        // Constructors and static initializers are not inherited so we shouldn't check with the superclasses.
        return findMethod(env, clazz, name, desc);
    }

    Class* c = clazz;
    for (c = clazz; c != NULL; c = c->superclass) {
        Method* method = findMethod(env, c, name, desc);
        if (bugvmExceptionCheck(env)) return NULL;
        if (method) return method;
    }

    /*
     * Check with interfaces.
     * TODO: Should we really do this? Does the JNI GetMethodID() function do this?
     */
    for (c = clazz; c != NULL; c = c->superclass) {
        Interface* interfaze = bugvmGetInterfaces(env, c);
        if (bugvmExceptionCheck(env)) return NULL;
        for (; interfaze != NULL; interfaze = interfaze->next) {
            Method* method = getMethod(env, interfaze->interfaze, name, desc);
            if (bugvmExceptionCheck(env)) return NULL;
            if (method) return method;
        }
    }

    if (CLASS_IS_INTERFACE(clazz)) {
        /*
         * Class is an interface so check with java.lang.Object.
         * TODO: Should we really do this? Does the JNI GetMethodID() function do this?
         */
        return getMethod(env, java_lang_Object, name, desc);
    }

    return NULL;
}

jboolean bugvmInitMethods(Env* env) {
    if (bugvmInitMutex(&nativeLibsLock) != 0) {
        return FALSE;
    }
    if (bugvmInitMutex(&threadStackTraceLock) != 0) {
        return FALSE;
    }
    java_lang_StackTraceElement = bugvmFindClassUsingLoader(env, "java/lang/StackTraceElement", NULL);
    if (!java_lang_StackTraceElement) {
        return FALSE;
    }
    java_lang_StackTraceElement_constructor = bugvmGetInstanceMethod(env, java_lang_StackTraceElement, "<init>",
                                      "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V");
    if (!java_lang_StackTraceElement_constructor) {
        return FALSE;
    }
    empty_java_lang_StackTraceElement_array = bugvmNewObjectArray(env, 0, java_lang_StackTraceElement, NULL, NULL);
    if (!empty_java_lang_StackTraceElement_array) {
        return FALSE;
    }
    if (!bugvmAddGlobalRef(env, (Object*) empty_java_lang_StackTraceElement_array)) {
        return FALSE;
    }

    return TRUE;
}

jboolean bugvmHasMethod(Env* env, Class* clazz, const char* name, const char* desc) {
    Method* method = getMethod(env, clazz, name, desc);
    if (bugvmExceptionCheck(env)) return FALSE;
    return method ? TRUE : FALSE;
}

Method* bugvmGetMethod(Env* env, Class* clazz, const char* name, const char* desc) {
    Method* method = getMethod(env, clazz, name, desc);
    if (bugvmExceptionCheck(env)) return NULL;
    if (!method) {
        bugvmThrowNoSuchMethodError(env, name);
        return NULL;
    }
    return method;
}

Method* bugvmGetClassMethod(Env* env, Class* clazz, const char* name, const char* desc) {
    Method* method = bugvmGetMethod(env, clazz, name, desc);
    if (!method) return NULL;
    if (!METHOD_IS_STATIC(method)) {
        // TODO: JNI spec doesn't say anything about throwing this
        bugvmThrowIncompatibleClassChangeErrorMethod(env, clazz, name, desc);
        return NULL;
    }
    return method;
}

Method* bugvmGetClassInitializer(Env* env, Class* clazz) {
    return getMethod(env, clazz, "<clinit>", "()V");
}

Method* bugvmGetInstanceMethod(Env* env, Class* clazz, const char* name, const char* desc) {
    Method* method = bugvmGetMethod(env, clazz, name, desc);
    if (!method) return NULL;
    if (METHOD_IS_STATIC(method)) {
        // TODO: JNI spec doesn't say anything about throwing this
        bugvmThrowIncompatibleClassChangeErrorMethod(env, clazz, name, desc);
        return NULL;
    }
    return method;
}

Method* bugvmFindMethodAtAddress(Env* env, void* address) {
    Class* clazz = env->vm->options->findClassAt(env, address);
    if (!clazz) return NULL;
    Method* method = bugvmGetMethods(env, clazz);
    if (bugvmExceptionCheck(env)) return NULL;
    for (; method != NULL; method = method->next) {
        void* start = method->impl;
        void* end = start + method->size;
        if (start && address >= start && address < end) {
            return method;
        }
    }
    // TODO: We should never end up here
    return NULL;
}

static jboolean getCallingMethodIterator(Env* env, void* pc, void* fp, ProxyMethod* proxyMethod, void* data) {
    Method** result = data;

    Method* method = bugvmFindMethodAtAddress(env, pc);
    if (method) {
        *result = method;
        return FALSE; // Stop iterating
    }
    return TRUE;
}

Method* bugvmGetCallingMethod(Env* env) {
    Method* result = NULL;
    unwindIterateCallStack(env, NULL, getCallingMethodIterator, &result);
    return result;
}

static jboolean captureCallStackCountFramesIterator(Env* env, void* pc, void* fp, ProxyMethod* proxyMethod, void* data) {
    jint* countPtr = (jint*) data;
    *countPtr += 1;
    return *countPtr < MAX_CALL_STACK_LENGTH ? TRUE : FALSE;
}

typedef struct {
    CallStack* data;
    jint maxLength;
} CaptureCallStackArgs;

static jboolean captureCallStackIterator(Env* env, void* pc, void* fp, ProxyMethod* proxyMethod, void* _args) {
    CaptureCallStackArgs* args =  (CaptureCallStackArgs*) _args;
    CallStack* data = args->data;
    data->frames[data->length].pc = pc;
    data->frames[data->length].fp = fp;
    data->frames[data->length].method = (Method*) proxyMethod;
    data->length++;
    return data->length < args->maxLength ? TRUE : FALSE;
}

jint countCallStackFrames(Env* env, Frame* fp) {
    jint count = 0;
    unwindIterateCallStack(env, fp, captureCallStackCountFramesIterator, &count);
    return count;
}

CallStack* allocateCallStackFrames(Env* env, jint maxLength) {
    return bugvmAllocateMemoryAtomic(env, sizeof(CallStack) + sizeof(CallStackFrame) * maxLength);
}

void captureCallStack(Env* env, Frame* fp, CallStack* data, jint maxLength) {
    CaptureCallStackArgs args = {data, maxLength};
    unwindIterateCallStack(env, fp, captureCallStackIterator, &args);
}

CallStack* captureCallStackFromFrame(Env* env, Frame* fp) {
    jint count = countCallStackFrames(env, fp);
    if (bugvmExceptionOccurred(env)) return NULL;
    CallStack* data = allocateCallStackFrames(env, count);
    if (!data) return NULL;
    captureCallStack(env, fp, data, count);
    if (bugvmExceptionOccurred(env)) return NULL;
    return data;
}

CallStack* bugvmCaptureCallStack(Env* env) {
    return captureCallStackFromFrame(env, NULL);
}

CallStack* bugvmCaptureCallStackForThread(Env* env, Thread* thread) {
    if (thread == env->currentThread) {
        return bugvmCaptureCallStack(env);
    }

    // dumpThreadStackTrace() must not be called concurrently
    obtainThreadStackTraceLock();
    
    if (!shared_callStack) {
        shared_callStack = bugvmAllocateMemoryAtomicUncollectable(env, sizeof(CallStack) + sizeof(CallStackFrame) * MAX_CALL_STACK_LENGTH);
        if (!shared_callStack) {
            releaseThreadStackTraceLock();
            return NULL;
        }
    }

    memset(shared_callStack, 0, sizeof(CallStack) + sizeof(CallStackFrame) * MAX_CALL_STACK_LENGTH);
    dumpThreadStackTrace(env, thread, shared_callStack);
    if (bugvmExceptionOccurred(env)) {
        releaseThreadStackTraceLock();
        return NULL;
    }

    // Make a copy of the CallStack that is just big enough
    CallStack* copy = allocateCallStackFrames(env, shared_callStack->length);
    if (!copy) {
        releaseThreadStackTraceLock();
        return NULL;
    }
    memcpy(copy, shared_callStack, sizeof(CallStack) + sizeof(CallStackFrame) * shared_callStack->length);

    releaseThreadStackTraceLock();

    return copy;
}

static inline jint getLineTableEntryB(uint8_t* table, jint index) {
    return table[index];
}
static inline jint getLineTableEntryS(uint16_t* table, jint index) {
    return table[index];
}
static inline jint getLineTableEntryI(jint* table, jint index) {
    return table[index];
}
static inline jint getLineTableEntry(void* table, jint entrySize, jint index) {
    if (entrySize == 1) {
        return getLineTableEntryB((uint8_t*) table, index);
    } else if (entrySize == 2) {
        return getLineTableEntryS((uint16_t*) table, index);
    }
    return getLineTableEntryI((jint*) table, index);
}

static jint getLinesIndex(void* addressOffsets, jint addressOffsetSize, jint size, jint frameOffset) {
    for (jint i = 0; i < size; i++) {
        jint entry = getLineTableEntry(addressOffsets, addressOffsetSize, i);
        if (frameOffset < entry) {
            return i - 1;
        }
    }
    return size - 1;
}

static jint getLineNumber(CallStackFrame* frame) {
    if (!frame->method || !frame->method->linetable) {
        return -1;
    }
    uint32_t* linetable = (uint32_t*) frame->method->linetable;
    if (*linetable == 0xffffffff) {
        return -1;
    }
    jint size = *linetable & 0xfffffff;
    if (size == 0) {
        return -1;
    }
    jint frameOffset = frame->pc - frame->method->impl;
    jint addressOffsetSize = ((*linetable >> 30) & 0x3) + 1;
    jint lineOffsetSize = ((*linetable >> 28) & 0x3) + 1;
    linetable++;
    jint firstLineNumber = *linetable;
    if (firstLineNumber >= FIRST_NO_LINE_NUMBERS_LINE) {
        return -1;
    }
    linetable++;

    jint index = getLinesIndex(linetable, addressOffsetSize, size, frameOffset);
    if (index == -1) {
        return firstLineNumber;
    }

    uint8_t* lineOffsets = ((uint8_t*) linetable) + size * addressOffsetSize;
    // Adjust lineOffsets for proper alignment
    lineOffsets += (lineOffsetSize - ((ptrdiff_t) lineOffsets & (lineOffsetSize - 1))) & (lineOffsetSize - 1);
    return firstLineNumber + getLineTableEntry(lineOffsets, lineOffsetSize, index);
}

CallStackFrame* bugvmResolveCallStackFrame(Env* env, CallStackFrame* frame) {
    if (frame->pc == NULL && frame->method == NULL) {
        // We've already tried to resolve this frame but 
        // it doesn't correspond to any method
        return NULL;
    }
    if (frame->method != NULL) {
        // We've already resolved this frame successfully or
        // the method is a ProxyMethod so no call to bugvmFindMethodAtAddress()
        // is required
        return frame;
    }
    frame->method = bugvmFindMethodAtAddress(env, frame->pc);
    if (!frame->method) {
        frame->pc = NULL;
        return NULL;
    }
    frame->lineNumber = METHOD_IS_NATIVE(frame->method) ? -2 : getLineNumber(frame);
    return frame;
}

ObjectArray* bugvmCallStackToStackTraceElements(Env* env, CallStack* callStack, jint first) {
    if (!callStack || callStack->length == 0) {
        return empty_java_lang_StackTraceElement_array;
    }

    // Count the number of methods
    jint index = first;
    jint length = 0;
    while (bugvmGetNextCallStackMethod(env, callStack, &index)) {
        length++;
    }

    if (length == 0) {
        return empty_java_lang_StackTraceElement_array;
    }

    ObjectArray* array = bugvmNewObjectArray(env, length, java_lang_StackTraceElement, NULL, NULL);
    if (!array) return NULL;

    if (length > 0) {
        jvalue args[4];
        index = first;
        jint i;
        for (i = 0; i < length; i++) {
            CallStackFrame* frame = bugvmGetNextCallStackMethod(env, callStack, &index);
            Method* m = frame->method;
            args[0].l = (jobject) m->clazz;
            args[1].l = (jobject) bugvmNewStringUTF(env, m->name, -1);
            if (!args[1].l) return NULL;
            args[2].l = (jobject) bugvmAttributeGetClassSourceFile(env, m->clazz);
            if (bugvmExceptionOccurred(env)) {
                return NULL;
            }
            args[3].i = frame->lineNumber;
            array->values[i] = bugvmNewObjectA(env, java_lang_StackTraceElement,
                java_lang_StackTraceElement_constructor, args);
            if (!array->values[i]) return NULL;
        }
    }

    return array;
}

const char* bugvmGetReturnType(const char* desc) {
    while (*desc != ')') desc++;
    desc++;
    return desc;
}

const char* bugvmGetNextParameterType(const char** desc) {
    const char* s = *desc;
    (*desc)++;
    switch (s[0]) {
    case 'B':
    case 'Z':
    case 'S':
    case 'C':
    case 'I':
    case 'J':
    case 'F':
    case 'D':
        return s;
    case '[':
        bugvmGetNextParameterType(desc);
        return s;
    case 'L':
        while (**desc != ';') (*desc)++;
        (*desc)++;
        return s;
    case '(':
        return bugvmGetNextParameterType(desc);
    }
    return 0;
}

jint bugvmGetParameterCount(Method* method) {
    const char* desc = method->desc;
    jint count = 0;
    while (bugvmGetNextParameterType(&desc)) {
        count++;
    }
    return count;
}

typedef struct {
    jint ptrArgsCount, intArgsCount, longArgsCount, floatArgsCount, doubleArgsCount;
} ArgsCount;

static void countArgs(Env* env, Method* method, ArgsCount* argsCount) {
    jint ptrArgsCount = 0, intArgsCount = 0, longArgsCount = 0, floatArgsCount = 0, doubleArgsCount = 0;
    ptrArgsCount = 1; // First arg is always the Env*
    if (!(method->access & ACC_STATIC)) {
        // Non-static methods takes the receiver object (this) as arg 2
        ptrArgsCount++;
    }    

    const char* desc = method->desc;
    const char* c;
    while ((c = bugvmGetNextParameterType(&desc))) {
        switch (c[0]) {
        case 'Z':
        case 'B':
        case 'S':
        case 'C':
        case 'I':
            intArgsCount++;
            break;
        case 'J':
            longArgsCount++;
            break;
        case 'F':
            floatArgsCount++;
            break;
        case 'D':
            doubleArgsCount++;
            break;
        case 'L':
        case '[':
            ptrArgsCount++;
            break;
        }
    }

    argsCount->ptrArgsCount = ptrArgsCount;
    argsCount->intArgsCount = intArgsCount;
    argsCount->longArgsCount = longArgsCount;
    argsCount->floatArgsCount = floatArgsCount;
    argsCount->doubleArgsCount = doubleArgsCount;
}

static void setArgs(Env* env, Object* obj, Method* method, CallInfo* callInfo, jvalue* args) {
    call0AddPtr(callInfo, env);
    if (!(method->access & ACC_STATIC)) {
        call0AddPtr(callInfo, obj);
    }    

    const char* desc = method->desc;
    const char* c;
    jint i = 0;
    while ((c = bugvmGetNextParameterType(&desc))) {
        switch (c[0]) {
        case 'Z':
            call0AddInt(callInfo, (jint) args[i++].z);
            break;
        case 'B':
            call0AddInt(callInfo, (jint) args[i++].b);
            break;
        case 'S':
            call0AddInt(callInfo, (jint) args[i++].s);
            break;
        case 'C':
            call0AddInt(callInfo, (jint) args[i++].c);
            break;
        case 'I':
            call0AddInt(callInfo, args[i++].i);
            break;
        case 'J':
            call0AddLong(callInfo, args[i++].j);
            break;
        case 'F':
            call0AddFloat(callInfo, args[i++].f);
            break;
        case 'D':
            call0AddDouble(callInfo, args[i++].d);
            break;
        case 'L':
        case '[':
            call0AddPtr(callInfo, args[i++].l);
            break;
        }
    }
}

#define /* CallInfo* */ INIT_CALL_INFO(/* Env* */ _env, /* Object* */ _obj, /* Method* */ _method, /* jboolean */ _virtual, /* jvalue* */ _args) ({ \
    CallInfo* _callInfo = NULL; \
    if (_virtual && !(_method->access & ACC_PRIVATE)) { \
        /* Lookup the real method to be invoked */ \
        _method = bugvmGetMethod(_env, ((Object*) _obj)->clazz, _method->name, _method->desc); \
    } \
    if (_method) { \
        ArgsCount _argsCount; \
        countArgs(_env, _method, &_argsCount); \
        void* _function = _method->synchronizedImpl ? _method->synchronizedImpl : _method->impl; \
        _callInfo = CALL0_ALLOCATE_CALL_INFO(_env, _function, _argsCount.ptrArgsCount, _argsCount.intArgsCount, _argsCount.longArgsCount, _argsCount.floatArgsCount, _argsCount.doubleArgsCount); \
        setArgs(_env, _obj, _method, _callInfo, _args); \
    } \
    _callInfo; \
})

static jvalue* va_list2jargs(Env* env, Method* method, va_list args) {
    jint argsCount = bugvmGetParameterCount(method);

    if (argsCount == 0) {
        return emptyJValueArgs;
    }

    jvalue *jvalueArgs = (jvalue*) bugvmAllocateMemory(env, sizeof(jvalue) * argsCount);
    if (!jvalueArgs) return NULL;

    const char* desc = method->desc;
    const char* c;
    jint i = 0;
    while ((c = bugvmGetNextParameterType(&desc))) {
        switch (c[0]) {
        case 'B':
            jvalueArgs[i++].b = (jbyte) va_arg(args, jint);
            break;
        case 'Z':
            jvalueArgs[i++].z = (jboolean) va_arg(args, jint);
            break;
        case 'S':
            jvalueArgs[i++].s = (jshort) va_arg(args, jint);
            break;
        case 'C':
            jvalueArgs[i++].c = (jchar) va_arg(args, jint);
            break;
        case 'I':
            jvalueArgs[i++].i = va_arg(args, jint);
            break;
        case 'J':
            jvalueArgs[i++].j = va_arg(args, jlong);
            break;
        case 'F':
            jvalueArgs[i++].f = (jfloat) va_arg(args, jdouble);
            break;
        case 'D':
            jvalueArgs[i++].d = va_arg(args, jdouble);
            break;
        case '[':
        case 'L':
            jvalueArgs[i++].l = va_arg(args, jobject);
            break;
        }
    }

    return jvalueArgs;
}

static void callVoidMethod(Env* env, CallInfo* callInfo) {
    void (*f)(CallInfo*) = _call0;
    bugvmPushGatewayFrame(env);
    TrycatchContext tc = {0};
    tc.sel = CATCH_ALL_SEL;
    if (!bugvmTrycatchEnter(env, &tc)) {
        f(callInfo);
    }
    bugvmTrycatchLeave(env);
    bugvmPopGatewayFrame(env);
}

static Object* callObjectMethod(Env* env, CallInfo* callInfo) {
    Object* result = NULL;
    Object* (*f)(CallInfo*) = (Object* (*)(CallInfo*)) _call0;
    bugvmPushGatewayFrame(env);
    TrycatchContext tc = {0};
    tc.sel = CATCH_ALL_SEL;
    if (!bugvmTrycatchEnter(env, &tc)) {
        result = f(callInfo);
    }
    bugvmTrycatchLeave(env);
    bugvmPopGatewayFrame(env);
    return result;
}

static jint callIntMethod(Env* env, CallInfo* callInfo) {
    jint result = 0;
    jint (*f)(CallInfo*) = (jint (*)(CallInfo*)) _call0;
    bugvmPushGatewayFrame(env);
    TrycatchContext tc = {0};
    tc.sel = CATCH_ALL_SEL;
    if (!bugvmTrycatchEnter(env, &tc)) {
        result = f(callInfo);
    }
    bugvmTrycatchLeave(env);
    bugvmPopGatewayFrame(env);
    return result;
}

static jboolean callBooleanMethod(Env* env, CallInfo* callInfo) {
    return ((jboolean) callIntMethod(env, callInfo)) == 0 ? FALSE : TRUE;
}

static jbyte callByteMethod(Env* env, CallInfo* callInfo) {
    return (jbyte) callIntMethod(env, callInfo);
}

static jchar callCharMethod(Env* env, CallInfo* callInfo) {
    return (jchar) callIntMethod(env, callInfo);
}

static jshort callShortMethod(Env* env, CallInfo* callInfo) {
    return (jshort) callIntMethod(env, callInfo);
}

static jlong callLongMethod(Env* env, CallInfo* callInfo) {
    jlong result = 0;
    jlong (*f)(CallInfo*) = (jlong (*)(CallInfo*)) _call0;
    bugvmPushGatewayFrame(env);
    TrycatchContext tc = {0};
    tc.sel = CATCH_ALL_SEL;
    if (!bugvmTrycatchEnter(env, &tc)) {
        result = f(callInfo);
    }
    bugvmTrycatchLeave(env);
    bugvmPopGatewayFrame(env);
    return result;
}

static jfloat callFloatMethod(Env* env, CallInfo* callInfo) {
    jfloat result = 0;
    jfloat (*f)(CallInfo*) = (jfloat (*)(CallInfo*)) _call0;
    bugvmPushGatewayFrame(env);
    TrycatchContext tc = {0};
    tc.sel = CATCH_ALL_SEL;
    if (!bugvmTrycatchEnter(env, &tc)) {
        result = f(callInfo);
    }
    bugvmTrycatchLeave(env);
    bugvmPopGatewayFrame(env);
    return result;
}

static jdouble callDoubleMethod(Env* env, CallInfo* callInfo) {
    jdouble result = 0;
    jdouble (*f)(CallInfo*) = (jdouble (*)(CallInfo*)) _call0;
    bugvmPushGatewayFrame(env);
    TrycatchContext tc = {0};
    tc.sel = CATCH_ALL_SEL;
    if (!bugvmTrycatchEnter(env, &tc)) {
        result = f(callInfo);
    }
    bugvmTrycatchLeave(env);
    bugvmPopGatewayFrame(env);
    return result;
}

void bugvmCallVoidInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    callVoidMethod(env, callInfo);
}

void bugvmCallVoidInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return;
    bugvmCallVoidInstanceMethodA(env, obj, method, jargs);
}

void bugvmCallVoidInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    bugvmCallVoidInstanceMethodV(env, obj, method, args);
}

Object* bugvmCallObjectInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return NULL;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callObjectMethod(env, callInfo);
}

Object* bugvmCallObjectInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return NULL;
    return bugvmCallObjectInstanceMethodA(env, obj, method, jargs);
}

Object* bugvmCallObjectInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallObjectInstanceMethodV(env, obj, method, args);
}

jboolean bugvmCallBooleanInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return FALSE;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callBooleanMethod(env, callInfo);
}

jboolean bugvmCallBooleanInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return FALSE;
    return bugvmCallBooleanInstanceMethodA(env, obj, method, jargs);
}

jboolean bugvmCallBooleanInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallBooleanInstanceMethodV(env, obj, method, args);
}

jbyte bugvmCallByteInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callByteMethod(env, callInfo);
}

jbyte bugvmCallByteInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallByteInstanceMethodA(env, obj, method, jargs);
}

jbyte bugvmCallByteInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallByteInstanceMethodV(env, obj, method, args);
}

jchar bugvmCallCharInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callCharMethod(env, callInfo);
}

jchar bugvmCallCharInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallCharInstanceMethodA(env, obj, method, jargs);
}

jchar bugvmCallCharInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallCharInstanceMethodV(env, obj, method, args);
}

jshort bugvmCallShortInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callShortMethod(env, callInfo);
}

jshort bugvmCallShortInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallShortInstanceMethodA(env, obj, method, jargs);
}

jshort bugvmCallShortInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallShortInstanceMethodV(env, obj, method, args);
}

jint bugvmCallIntInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callIntMethod(env, callInfo);
}

jint bugvmCallIntInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallIntInstanceMethodA(env, obj, method, jargs);
}

jint bugvmCallIntInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallIntInstanceMethodV(env, obj, method, args);
}

jlong bugvmCallLongInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callLongMethod(env, callInfo);
}

jlong bugvmCallLongInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallLongInstanceMethodA(env, obj, method, jargs);
}

jlong bugvmCallLongInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallLongInstanceMethodV(env, obj, method, args);
}

jfloat bugvmCallFloatInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return 0.0f;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callFloatMethod(env, callInfo);
}

jfloat bugvmCallFloatInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0.0f;
    return bugvmCallFloatInstanceMethodA(env, obj, method, jargs);
}

jfloat bugvmCallFloatInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallFloatInstanceMethodV(env, obj, method, args);
}

jdouble bugvmCallDoubleInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, TRUE, args);
    if (!callInfo) return 0.0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callDoubleMethod(env, callInfo);
}

jdouble bugvmCallDoubleInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0.0;
    return bugvmCallDoubleInstanceMethodA(env, obj, method, jargs);
}

jdouble bugvmCallDoubleInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallDoubleInstanceMethodV(env, obj, method, args);
}

void bugvmCallNonvirtualVoidInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    callVoidMethod(env, callInfo);
}

void bugvmCallNonvirtualVoidInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return;
    bugvmCallNonvirtualVoidInstanceMethodA(env, obj, method, jargs);
}

void bugvmCallNonvirtualVoidInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    bugvmCallNonvirtualVoidInstanceMethodV(env, obj, method, args);
}

Object* bugvmCallNonvirtualObjectInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return NULL;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callObjectMethod(env, callInfo);
}

Object* bugvmCallNonvirtualObjectInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return NULL;
    return bugvmCallNonvirtualObjectInstanceMethodA(env, obj, method, jargs);
}

Object* bugvmCallNonvirtualObjectInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualObjectInstanceMethodV(env, obj, method, args);
}

jboolean bugvmCallNonvirtualBooleanInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return FALSE;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callBooleanMethod(env, callInfo);
}

jboolean bugvmCallNonvirtualBooleanInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return FALSE;
    return bugvmCallNonvirtualBooleanInstanceMethodA(env, obj, method, jargs);
}

jboolean bugvmCallNonvirtualBooleanInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualBooleanInstanceMethodV(env, obj, method, args);
}

jbyte bugvmCallNonvirtualByteInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callByteMethod(env, callInfo);
}

jbyte bugvmCallNonvirtualByteInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallNonvirtualByteInstanceMethodA(env, obj, method, jargs);
}

jbyte bugvmCallNonvirtualByteInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualByteInstanceMethodV(env, obj, method, args);
}

jchar bugvmCallNonvirtualCharInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callCharMethod(env, callInfo);
}

jchar bugvmCallNonvirtualCharInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallNonvirtualCharInstanceMethodA(env, obj, method, jargs);
}

jchar bugvmCallNonvirtualCharInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualCharInstanceMethodV(env, obj, method, args);
}

jshort bugvmCallNonvirtualShortInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callShortMethod(env, callInfo);
}

jshort bugvmCallNonvirtualShortInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallNonvirtualShortInstanceMethodA(env, obj, method, jargs);
}

jshort bugvmCallNonvirtualShortInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualShortInstanceMethodV(env, obj, method, args);
}

jint bugvmCallNonvirtualIntInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callIntMethod(env, callInfo);
}

jint bugvmCallNonvirtualIntInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallNonvirtualIntInstanceMethodA(env, obj, method, jargs);
}

jint bugvmCallNonvirtualIntInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualIntInstanceMethodV(env, obj, method, args);
}

jlong bugvmCallNonvirtualLongInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return 0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callLongMethod(env, callInfo);
}

jlong bugvmCallNonvirtualLongInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallNonvirtualLongInstanceMethodA(env, obj, method, jargs);
}

jlong bugvmCallNonvirtualLongInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualLongInstanceMethodV(env, obj, method, args);
}

jfloat bugvmCallNonvirtualFloatInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return 0.0f;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callFloatMethod(env, callInfo);
}

jfloat bugvmCallNonvirtualFloatInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0.0f;
    return bugvmCallNonvirtualFloatInstanceMethodA(env, obj, method, jargs);
}

jfloat bugvmCallNonvirtualFloatInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualFloatInstanceMethodV(env, obj, method, args);
}

jdouble bugvmCallNonvirtualDoubleInstanceMethodA(Env* env, Object* obj, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, obj, method, FALSE, args);
    if (!callInfo) return 0.0;
    if (obj && CLASS_IS_PROXY(obj->clazz)) {
        env->reserved0 = (void*) method->name;
        env->reserved1 = (void*) method->desc;
    }
    return callDoubleMethod(env, callInfo);
}

jdouble bugvmCallNonvirtualDoubleInstanceMethodV(Env* env, Object* obj, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0.0;
    return bugvmCallNonvirtualDoubleInstanceMethodA(env, obj, method, jargs);
}

jdouble bugvmCallNonvirtualDoubleInstanceMethod(Env* env, Object* obj, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallNonvirtualDoubleInstanceMethodV(env, obj, method, args);
}

void bugvmCallVoidClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return;
    callVoidMethod(env, callInfo);
}

void bugvmCallVoidClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return;
    bugvmCallVoidClassMethodA(env, clazz, method, jargs);
}

void bugvmCallVoidClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    bugvmCallVoidClassMethodV(env, clazz, method, args);
}

Object* bugvmCallObjectClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return NULL;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return NULL;
    return callObjectMethod(env, callInfo);
}

Object* bugvmCallObjectClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return NULL;
    return bugvmCallObjectClassMethodA(env, clazz, method, jargs);
}

Object* bugvmCallObjectClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallObjectClassMethodV(env, clazz, method, args);
}

jboolean bugvmCallBooleanClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return FALSE;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return FALSE;
    return callBooleanMethod(env, callInfo);
}

jboolean bugvmCallBooleanClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return FALSE;
    return bugvmCallBooleanClassMethodA(env, clazz, method, jargs);
}

jboolean bugvmCallBooleanClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallBooleanClassMethodV(env, clazz, method, args);
}

jbyte bugvmCallByteClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return 0;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return 0;
    return callByteMethod(env, callInfo);
}

jbyte bugvmCallByteClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallByteClassMethodA(env, clazz, method, jargs);
}

jbyte bugvmCallByteClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallByteClassMethodV(env, clazz, method, args);
}

jchar bugvmCallCharClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return 0;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return 0;
    return callCharMethod(env, callInfo);
}

jchar bugvmCallCharClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallCharClassMethodA(env, clazz, method, jargs);
}

jchar bugvmCallCharClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallCharClassMethodV(env, clazz, method, args);
}

jshort bugvmCallShortClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return 0;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return 0;
    return callShortMethod(env, callInfo);
}

jshort bugvmCallShortClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallShortClassMethodA(env, clazz, method, jargs);
}

jshort bugvmCallShortClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallShortClassMethodV(env, clazz, method, args);
}

jint bugvmCallIntClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return 0;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return 0;
    return callIntMethod(env, callInfo);
}

jint bugvmCallIntClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallIntClassMethodA(env, clazz, method, jargs);
}

jint bugvmCallIntClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallIntClassMethodV(env, clazz, method, args);
}

jlong bugvmCallLongClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return 0;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return 0;
    return callLongMethod(env, callInfo);
}

jlong bugvmCallLongClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0;
    return bugvmCallLongClassMethodA(env, clazz, method, jargs);
}

jlong bugvmCallLongClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallLongClassMethodV(env, clazz, method, args);
}

jfloat bugvmCallFloatClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return 0.0f;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return 0.0f;
    return callFloatMethod(env, callInfo);
}

jfloat bugvmCallFloatClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0.0f;
    return bugvmCallFloatClassMethodA(env, clazz, method, jargs);
}

jfloat bugvmCallFloatClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallFloatClassMethodV(env, clazz, method, args);
}

jdouble bugvmCallDoubleClassMethodA(Env* env, Class* clazz, Method* method, jvalue* args) {
    CallInfo* callInfo = INIT_CALL_INFO(env, NULL, method, FALSE, args);
    if (!callInfo) return 0.0;
    bugvmInitialize(env, method->clazz);
    if (bugvmExceptionOccurred(env)) return 0.0;
    return callDoubleMethod(env, callInfo);
}

jdouble bugvmCallDoubleClassMethodV(Env* env, Class* clazz, Method* method, va_list args) {
    jvalue* jargs = va_list2jargs(env, method, args);
    if (!jargs) return 0.0;
    return bugvmCallDoubleClassMethodA(env, clazz, method, jargs);
}

jdouble bugvmCallDoubleClassMethod(Env* env, Class* clazz, Method* method, ...) {
    va_list args;
    va_start(args, method);
    return bugvmCallDoubleClassMethodV(env, clazz, method, args);
}

jboolean bugvmRegisterNative(Env* env, NativeMethod* method, void* impl) {
    method->nativeImpl = impl;
    return TRUE;
}

jboolean bugvmUnregisterNative(Env* env, NativeMethod* method) {
    method->nativeImpl = NULL;
    return TRUE;
}

void* bugvmResolveNativeMethodImpl(Env* env, NativeMethod* method, const char* shortMangledName, const char* longMangledName, Object* classLoader, void** ptr) {
    void* f = method->nativeImpl;
    if (!f) {
        DynamicLib* nativeLibs = NULL;
        if (!classLoader || bugvmGetParentClassLoader(env, classLoader) == NULL) {
            // This is the bootstrap classloader
            nativeLibs = bootNativeLibs;
        } else if (bugvmGetParentParentClassLoader(env, classLoader) == NULL && classLoader->clazz->classLoader == NULL) {
            // This is the system classloader
            nativeLibs = mainNativeLibs;
        } else {
            // Unknown classloader
            bugvmThrowUnsatisfiedLinkError(env, "Unknown classloader");
            return NULL;
        }

        obtainNativeLibsLock();

        TRACEF("Searching for native method using short name: %s", shortMangledName);
        f = bugvmFindDynamicLibSymbol(env, nativeLibs, shortMangledName, TRUE);
        if (f) {
            TRACEF("Found native method using short name: %s", shortMangledName);
        } else if (strcmp(shortMangledName, longMangledName)) {
            TRACEF("Searching for native method using long name: %s", longMangledName);
            f = bugvmFindDynamicLibSymbol(env, nativeLibs, longMangledName, TRUE);
            if (f) {
                TRACEF("Found native method using long name: %s", longMangledName);
            }
        }

        method->nativeImpl = f;

        releaseNativeLibsLock();
    }

    if (!f) {
        char* className = bugvmToBinaryClassName(env, method->method.clazz->name);
        if (className) {
            bugvmThrowNewf(env, java_lang_UnsatisfiedLinkError, "%s.%s%s", className, method->method.name, method->method.desc);
        }
        return NULL;
    }
    // TODO: Remember ptr to allow it to be reset when the JNI RegisterNatives/UnregisterNatives functions are called
    *ptr = f;
    return f;
}


jboolean bugvmLoadNativeLibrary(Env* env, const char* path, Object* classLoader) {
    DynamicLib** nativeLibs = NULL;
    if (!classLoader || bugvmGetParentClassLoader(env, classLoader) == NULL) {
        // This is the bootstrap classloader
        nativeLibs = &bootNativeLibs;
    } else if (bugvmGetParentParentClassLoader(env, classLoader) == NULL && classLoader->clazz->classLoader == NULL) {
        // This is the system classloader
        nativeLibs = &mainNativeLibs;
    } else {
        // Unknown classloader
        bugvmThrowUnsatisfiedLinkError(env, "Unknown classloader");
        return FALSE;
    }

    char* errorMsg = NULL;
    DynamicLib* lib = bugvmOpenDynamicLib(env, path, &errorMsg);
    if (!lib) {
        if (!bugvmExceptionOccurred(env)) {
            bugvmThrowUnsatisfiedLinkError(env, errorMsg);
        }
        return FALSE;
    }

    obtainNativeLibsLock();

    if (bugvmHasDynamicLib(env, lib, *nativeLibs)) {
        // The lib is already in nativeLibs
        bugvmCloseDynamicLib(env, lib);
        releaseNativeLibsLock();
        return TRUE;
    }

    jint (*JNI_OnLoad)(JavaVM*, void*) = bugvmFindDynamicLibSymbol(env, lib, "JNI_OnLoad", FALSE);
    if (JNI_OnLoad) {
        // TODO: Check that JNI_OnLoad returns a supported JNI version?
        JNI_OnLoad(&env->vm->javaVM, NULL);
        if (bugvmExceptionOccurred(env)) {
            releaseNativeLibsLock();
            return FALSE;
        }
    }

    bugvmAddDynamicLib(env, lib, nativeLibs);

    releaseNativeLibsLock();

    return TRUE;
}

