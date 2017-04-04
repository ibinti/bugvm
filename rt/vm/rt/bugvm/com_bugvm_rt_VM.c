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
#include <string.h>
#include <bugvm.h>
#include "reflection_helpers.h"

static char* createClasspathFromClasspathEntries(Env* env, ClasspathEntry* first) {
    jint length = 0;
    ClasspathEntry* entry = first;
    while (entry) {
        length += strlen(entry->jarPath);
        entry = entry->next;
        if (entry) length++; // Make room for the :
    }

    char* p = bugvmAllocateMemoryAtomic(env, length + 1);
    if (!p) return NULL;

    entry = first;
    while (entry) {
        strcat(p, entry->jarPath);
        entry = entry->next;
        if (entry) strcat(p, ":");
    }

    return p;
}

Object* Java_com_bugvm_rt_VM_bootClassPath(Env* env, Class* c) {
    char* bootclasspath = createClasspathFromClasspathEntries(env, env->vm->options->bootclasspath);
    if (!bootclasspath) return NULL;
    return bugvmNewStringUTF(env, bootclasspath, -1);
}

Object* Java_com_bugvm_rt_VM_classPath(Env* env, Class* c) {
    char* classpath = createClasspathFromClasspathEntries(env, env->vm->options->classpath);
    if (!classpath) return NULL;
    return bugvmNewStringUTF(env, classpath, -1);
}

Object* Java_com_bugvm_rt_VM_resourcesPath(Env* env, Class* c) {
    return bugvmNewStringUTF(env, env->vm->options->resourcesPath, -1);
}

Object* Java_com_bugvm_rt_VM_imagePath(Env* env, Class* c) {
    return bugvmNewStringUTF(env, env->vm->options->imagePath, -1);
}

ObjectArray* Java_com_bugvm_rt_VM_staticLibs(Env* env, Class* c) {
    Options* options = env->vm->options;
    if (!options->staticLibs || options->staticLibs[0] == NULL) {
        return bugvmNewObjectArray(env, 0, java_lang_String, NULL, NULL);
    }

    jint length = 0;
    while (options->staticLibs[length] != NULL) {
        length++;
    }

    ObjectArray* result = bugvmNewObjectArray(env, length, java_lang_String, NULL, NULL);
    if (!result) return NULL;

    jint i;
    for (i = 0; i < length; i++) {
        Object* s = bugvmNewStringUTF(env, options->staticLibs[i], -1);
        if (!s) return NULL;
        result->values[i] = s;
    }

    return result;
}

ByteArray* Java_com_bugvm_rt_VM_getRuntimeData0(Env* env, Class* c) {
    Options* options = env->vm->options;
    if (!options->runtimeData) {
        return NULL;
    }
    void* p = options->runtimeData;
    jint length = *((jint*) p);
    if (length == 0) {
        return NULL;
    }
    p += sizeof(jint);
    ByteArray* data = bugvmNewByteArray(env, length);
    if (!data) {
        return NULL;
    }
    memcpy(data->values, p, length);
    return data;
}

ObjectArray* Java_com_bugvm_rt_VM_getStackClasses(Env* env, Class* c, jint skipNum, jint maxDepth) {
    CallStack* callStack = bugvmCaptureCallStack(env);
    if (!callStack) return NULL;

    jint index = 0;
    bugvmGetNextCallStackMethod(env, callStack, &index); // Skip VM.getStackClasses()
    bugvmGetNextCallStackMethod(env, callStack, &index); // Skip caller of VM.getStackClasses()

    while (skipNum > 0) {
        CallStackFrame* frame = bugvmGetNextCallStackMethod(env, callStack, &index);
        if (!frame) return NULL;
        skipNum--;
    }

    jint first = index;

    jint depth = 0;
    while (bugvmGetNextCallStackMethod(env, callStack, &index)) {
        depth++;
    }
    if (maxDepth > -1 && maxDepth < depth) {
        depth = maxDepth;
    }
    
    ObjectArray* result = bugvmNewObjectArray(env, depth, java_lang_Class, NULL, NULL);
    if (!result) return NULL;
    jint i;
    index = first;
    for (i = 0; i < depth; i++) {
        CallStackFrame* frame = bugvmGetNextCallStackMethod(env, callStack, &index);
        result->values[i] = (Object*) frame->method->clazz;
    }
    return result;
}

jlong Java_com_bugvm_rt_VM_allocateMemory(Env* env, Class* c, jint size) {
    return PTR_TO_LONG(bugvmAllocateMemory(env, size));
}

jlong Java_com_bugvm_rt_VM_allocateMemoryUncollectable(Env* env, Class* c, jint size) {
    return PTR_TO_LONG(bugvmAllocateMemoryUncollectable(env, size));
}

jlong Java_com_bugvm_rt_VM_allocateMemoryAtomic(Env* env, Class* c, jint size) {
    return PTR_TO_LONG(bugvmAllocateMemoryAtomic(env, size));
}

void Java_com_bugvm_rt_VM_freeMemoryUncollectable(Env* env, Class* c, jlong address) {
    bugvmFreeMemoryUncollectable(env, LONG_TO_PTR(address));
}

void Java_com_bugvm_rt_VM_registerDisappearingLink(Env* env, Class* c, jlong address, Object* obj) {
    bugvmRegisterDisappearingLink(env, LONG_TO_PTR(address), obj);
}

void Java_com_bugvm_rt_VM_unregisterDisappearingLink(Env* env, Class* c, jlong address) {
    bugvmUnregisterDisappearingLink(env, LONG_TO_PTR(address));
}

jlong Java_com_bugvm_rt_VM_malloc(Env* env, Class* c, jint size) {
    void* m = malloc(size);
    if (!m) {
        bugvmThrowOutOfMemoryError(env);
        return 0;
    }
    memset(m, 0, size);
    return PTR_TO_LONG(m);
}

void Java_com_bugvm_rt_VM_free(Env* env, Class* c, jlong address) {
    free(LONG_TO_PTR(address));
}

Object* Java_com_bugvm_rt_VM_allocateObject(Env* env, Class* c, Class* cls) {
    Object *o = bugvmAllocateObject(env, cls);
    if (o && CLASS_IS_FINALIZABLE(cls)) {
        bugvmRegisterFinalizer(env, o);
    }
    return o;
}

Object* Java_com_bugvm_rt_VM_newDirectByteBuffer(Env* env, Class* c, jlong address, jlong capacity) {
    return bugvmNewDirectByteBuffer(env, LONG_TO_PTR(address), capacity);
}

void Java_com_bugvm_rt_VM_memcpy(Env* env, Class* c, jlong s1, jlong s2, jlong n) {
    memcpy(LONG_TO_PTR(s1), LONG_TO_PTR(s2), (size_t) n);
}

void Java_com_bugvm_rt_VM_memmove8(Env* env, Class* c, jlong s1, jlong s2, jlong n) {
    memmove(LONG_TO_PTR(s1), LONG_TO_PTR(s2), (size_t) n);
}

void Java_com_bugvm_rt_VM_memmove16(Env* env, Class* c, jlong s1, jlong s2, jlong n) {
    bugvmMoveMemory16(LONG_TO_PTR(s1), LONG_TO_PTR(s2), (size_t) n);
}

void Java_com_bugvm_rt_VM_memmove32(Env* env, Class* c, jlong s1, jlong s2, jlong n) {
    bugvmMoveMemory32(LONG_TO_PTR(s1), LONG_TO_PTR(s2), (size_t) n);
}

void Java_com_bugvm_rt_VM_memmove64(Env* env, Class* c, jlong s1, jlong s2, jlong n) {
    bugvmMoveMemory32(LONG_TO_PTR(s1), LONG_TO_PTR(s2), (size_t) (n << 1));
}

void Java_com_bugvm_rt_VM_memset(Env* env, Class* cls, jlong s, jbyte c, jlong n) {
    memset(LONG_TO_PTR(s), (unsigned char) c, (size_t) n);
}

jlong Java_com_bugvm_rt_VM_getCallbackMethodImpl(Env* env, Class* c, Object* methodObject) {
    Method* method = getMethodFromMethodObject(env, methodObject);
    return PTR_TO_LONG(((CallbackMethod*) method)->callbackImpl);
}

void Java_com_bugvm_rt_VM_bindBridgeMethod(Env* env, Class* c, Object* methodObject, jlong impl) {
    BridgeMethod* method = (BridgeMethod*) getMethodFromMethodObject(env, methodObject);
    if (!method) return;
    *method->targetFnPtr = LONG_TO_PTR(impl);
}

jboolean Java_com_bugvm_rt_VM_isBridgeMethodBound(Env* env, Class* c, Object* methodObject) {
    BridgeMethod* method = (BridgeMethod*) getMethodFromMethodObject(env, methodObject);
    if (!method) return FALSE;
    return *method->targetFnPtr == NULL ? FALSE : TRUE;
}

jlong Java_com_bugvm_rt_VM_getObjectAddress(Env* env, Class* c, Object* object) {
    return PTR_TO_LONG(object);
}
    
Object* Java_com_bugvm_rt_VM_castAddressToObject(Env* env, Class* c, jlong address) {
    return (Object*) LONG_TO_PTR(address);
}

jlong Java_com_bugvm_rt_VM_getFieldAddress(Env* env, Class* c, Object* fieldObject) {
    Field* field = (Field*) getFieldFromFieldObject(env, fieldObject);
    return PTR_TO_LONG(field);
}

jint Java_com_bugvm_rt_VM_getInstanceFieldOffset(Env* env, Class* c, jlong fieldPtr) {
    InstanceField* field = (InstanceField*) LONG_TO_PTR(fieldPtr);
    return field->offset;
}

jlong Java_com_bugvm_rt_VM_getClassFieldAddress(Env* env, Class* c, jlong fieldPtr) {
    ClassField* field = (ClassField*) LONG_TO_PTR(fieldPtr);
    return PTR_TO_LONG(field->address);
}
    
Object* Java_com_bugvm_rt_VM_getObject(Env* env, Class* c, jlong address) {
    return *((Object**) LONG_TO_PTR(address));
}

jdouble Java_com_bugvm_rt_VM_getDouble(Env* env, Class* c, jlong address) {
    return *((jdouble*) LONG_TO_PTR(address));
}

jfloat Java_com_bugvm_rt_VM_getFloat(Env* env, Class* c, jlong address) {
    return *((jfloat*) LONG_TO_PTR(address));
}

jlong Java_com_bugvm_rt_VM_getLong(Env* env, Class* c, jlong address) {
    return *((jlong*) LONG_TO_PTR(address));
}

jint Java_com_bugvm_rt_VM_getInt(Env* env, Class* c, jlong address) {
    return *((jint*) LONG_TO_PTR(address));
}

jchar Java_com_bugvm_rt_VM_getChar(Env* env, Class* c, jlong address) {
    return *((jchar*) LONG_TO_PTR(address));
}

jshort Java_com_bugvm_rt_VM_getShort(Env* env, Class* c, jlong address) {
    return *((jshort*) LONG_TO_PTR(address));
}

jbyte Java_com_bugvm_rt_VM_getByte(Env* env, Class* c, jlong address) {
    return *((jbyte*) LONG_TO_PTR(address));
}

jboolean Java_com_bugvm_rt_VM_getBoolean(Env* env, Class* c, jlong address) {
    return *((jboolean*) LONG_TO_PTR(address));
}

void Java_com_bugvm_rt_VM_setObject(Env* env, Class* c, jlong address, Object* value) {
    *((Object**) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setDouble(Env* env, Class* c, jlong address, jdouble value) {
    *((jdouble*) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setFloat(Env* env, Class* c, jlong address, jfloat value) {
    *((jfloat*) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setLong(Env* env, Class* c, jlong address, jlong value) {
    *((jlong*) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setInt(Env* env, Class* c, jlong address, jint value) {
    *((jint*) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setChar(Env* env, Class* c, jlong address, jchar value) {
    *((jchar*) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setShort(Env* env, Class* c, jlong address, jshort value) {
    *((jshort*) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setByte(Env* env, Class* c, jlong address, jbyte value) {
    *((jbyte*) LONG_TO_PTR(address)) = value;
}

void Java_com_bugvm_rt_VM_setBoolean(Env* env, Class* c, jlong address, jboolean value) {
    *((jboolean*) LONG_TO_PTR(address)) = value;
}

jlong Java_com_bugvm_rt_VM_getPointer(Env* env, Class* c, jlong address) {
    return PTR_TO_LONG(*((void**) LONG_TO_PTR(address)));
}

void Java_com_bugvm_rt_VM_setPointer(Env* env, Class* c, jlong address, jlong value) {
    *((void**) LONG_TO_PTR(address)) = LONG_TO_PTR(value);
}

jlong Java_com_bugvm_rt_VM_getStringUTFChars(Env* env, Class* c, Object* s) {
    return PTR_TO_LONG(bugvmGetStringUTFChars(env, s));
}

Object* Java_com_bugvm_rt_VM_newStringUTF(Env* env, Class* c, jlong address) {
    return bugvmNewStringUTF(env, (char*) LONG_TO_PTR(address), -1);
}

Object* Java_com_bugvm_rt_VM_newStringNoCopy(Env* env, Class* c, CharArray* value, jint offset, jint length) {
    return bugvmNewStringNoCopy(env, value, offset, length);
}

jlong Java_com_bugvm_rt_VM_getArrayValuesAddress(Env* env, Class* c, Array* array) {
    if (array->object.clazz == array_Z) {
        return PTR_TO_LONG(((BooleanArray*) array)->values);
    }
    if (array->object.clazz == array_B) {
        return PTR_TO_LONG(((ByteArray*) array)->values);
    }
    if (array->object.clazz == array_C) {
        return PTR_TO_LONG(((CharArray*) array)->values);
    }
    if (array->object.clazz == array_S) {
        return PTR_TO_LONG(((ShortArray*) array)->values);
    }
    if (array->object.clazz == array_I) {
        return PTR_TO_LONG(((IntArray*) array)->values);
    }
    if (array->object.clazz == array_J) {
        return PTR_TO_LONG(((LongArray*) array)->values);
    }
    if (array->object.clazz == array_F) {
        return PTR_TO_LONG(((FloatArray*) array)->values);
    }
    if (array->object.clazz == array_D) {
        return PTR_TO_LONG(((DoubleArray*) array)->values);
    }
    return PTR_TO_LONG(((ObjectArray*) array)->values);
}

BooleanArray* Java_com_bugvm_rt_VM_newBooleanArray(Env* env, Class* c, jlong address, jint size) {
    BooleanArray* array = bugvmNewBooleanArray(env, size);
    if (array) {
        jbyte* data = (jbyte*) LONG_TO_PTR(address);
        jint i = 0;
        for (i = 0; i < size; i++) {
            array->values[i] = *data ? TRUE : FALSE;
            data++;
        }
    }
    return array;
}

ByteArray* Java_com_bugvm_rt_VM_newByteArray(Env* env, Class* c, jlong address, jint size) {
    ByteArray* array = bugvmNewByteArray(env, size);
    if (array) {
        memcpy(array->values, LONG_TO_PTR(address), size * sizeof(jbyte));
    }
    return array;
}

CharArray* Java_com_bugvm_rt_VM_newCharArray(Env* env, Class* c, jlong address, jint size) {
    CharArray* array = bugvmNewCharArray(env, size);
    if (array) {
        memcpy(array->values, LONG_TO_PTR(address), size * sizeof(jchar));
    }
    return array;
}

ShortArray* Java_com_bugvm_rt_VM_newShortArray(Env* env, Class* c, jlong address, jint size) {
    ShortArray* array = bugvmNewShortArray(env, size);
    if (array) {
        memcpy(array->values, LONG_TO_PTR(address), size * sizeof(jshort));
    }
    return array;
}

IntArray* Java_com_bugvm_rt_VM_newIntArray(Env* env, Class* c, jlong address, jint size) {
    IntArray* array = bugvmNewIntArray(env, size);
    if (array) {
        memcpy(array->values, LONG_TO_PTR(address), size * sizeof(jint));
    }
    return array;
}

LongArray* Java_com_bugvm_rt_VM_newLongArray(Env* env, Class* c, jlong address, jint size) {
    LongArray* array = bugvmNewLongArray(env, size);
    if (array) {
        memcpy(array->values, LONG_TO_PTR(address), size * sizeof(jlong));
    }
    return array;
}

FloatArray* Java_com_bugvm_rt_VM_newFloatArray(Env* env, Class* c, jlong address, jint size) {
    FloatArray* array = bugvmNewFloatArray(env, size);
    if (array) {
        memcpy(array->values, LONG_TO_PTR(address), size * sizeof(jfloat));
    }
    return array;
}

DoubleArray* Java_com_bugvm_rt_VM_newDoubleArray(Env* env, Class* c, jlong address, jint size) {
    DoubleArray* array = bugvmNewDoubleArray(env, size);
    if (array) {
        memcpy(array->values, LONG_TO_PTR(address), size * sizeof(jdouble));
    }
    return array;
}

ObjectArray* Java_com_bugvm_rt_VM_listClasses0(Env* env, Class* c, Class* instanceofClass, Object* classLoader) {
    return bugvmListClasses(env, instanceofClass, classLoader);
}

void Java_com_bugvm_rt_VM_generateHeapDump(Env* env, Class* c) {
    bugvmGenerateHeapDump(env);
}
