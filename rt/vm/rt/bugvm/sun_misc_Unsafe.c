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
#include <stddef.h>
#include <bugvm.h>
#include "reflection_helpers.h"

static inline jboolean checkNull(Env* env, Object* o) {
    if (!o) {
        bugvmThrowNullPointerException(env);
        return FALSE;
    }
    return TRUE;
}

static inline void* getFieldAddress(Object* o, jlong offset) {
    return (void*) (((jbyte*) o) + offset);
}

jlong Java_sun_misc_Unsafe_objectFieldOffset0(Env* env, Object* unsafe, Object* fieldObject) {
    if (!checkNull(env, fieldObject)) return 0;
    InstanceField* field = (InstanceField*) getFieldFromFieldObject(env, fieldObject);
    if (!field) return 0;
    return field->offset;
}

jint Java_sun_misc_Unsafe_arrayBaseOffset0(Env* env, Object* unsafe, Class* clazz) {
    if (clazz == array_Z) {
        return offsetof(BooleanArray, values);
    }
    if (clazz == array_B) {
        return offsetof(ByteArray, values);
    }
    if (clazz == array_C) {
        return offsetof(CharArray, values);
    }
    if (clazz == array_S) {
        return offsetof(ShortArray, values);
    }
    if (clazz == array_I) {
        return offsetof(IntArray, values);
    }
    if (clazz == array_J) {
        return offsetof(LongArray, values);
    }
    if (clazz == array_F) {
        return offsetof(FloatArray, values);
    }
    if (clazz == array_D) {
        return offsetof(DoubleArray, values);
    }
    return offsetof(ObjectArray, values);
}

jint Java_sun_misc_Unsafe_arrayIndexScale0(Env* env, Object* unsafe, Class* clazz) {
    return bugvmGetArrayElementSize(env, clazz);
}

jboolean Java_sun_misc_Unsafe_compareAndSwapInt(Env* env, Object* unsafe, Object* obj, jlong offset, jint expectedValue, jint newValue) {
    if (!checkNull(env, obj)) return FALSE;
    jint* address = (jint*) getFieldAddress(obj, offset);
    return bugvmAtomicCompareAndSwapInt(address, expectedValue, newValue);
}

jboolean Java_sun_misc_Unsafe_compareAndSwapLong(Env* env, Object* unsafe, Object* obj, jlong offset, jlong expectedValue, jlong newValue) {
    if (!checkNull(env, obj)) return FALSE;
    jlong* address = (jlong*) getFieldAddress(obj, offset);
    return bugvmAtomicCompareAndSwapLong(address, expectedValue, newValue);
}

jboolean Java_sun_misc_Unsafe_compareAndSwapObject(Env* env, Object* unsafe, Object* obj, jlong offset, Object* expectedValue, Object* newValue) {
    if (!checkNull(env, obj)) return FALSE;
    void** address = (void**) getFieldAddress(obj, offset);
    return bugvmAtomicCompareAndSwapPtr(address, expectedValue, newValue);
}

jint Java_sun_misc_Unsafe_getInt(Env* env, Object* unsafe, Object* obj, jlong offset) {
    if (!checkNull(env, obj)) return 0;
    jint* address = (jint*) getFieldAddress(obj, offset);
    return *address;
}

jint Java_sun_misc_Unsafe_getIntVolatile(Env* env, Object* unsafe, Object* obj, jlong offset) {
    if (!checkNull(env, obj)) return 0;
    jint* address = (jint*) getFieldAddress(obj, offset);
    return bugvmAtomicLoadInt(address);
}

jlong Java_sun_misc_Unsafe_getLong(Env* env, Object* unsafe, Object* obj, jlong offset) {
    if (!checkNull(env, obj)) return 0;
    jlong* address = (jlong*) getFieldAddress(obj, offset);
    return *address;
}

jlong Java_sun_misc_Unsafe_getLongVolatile(Env* env, Object* unsafe, Object* obj, jlong offset) {
    if (!checkNull(env, obj)) return 0;
    jlong* address = (jlong*) getFieldAddress(obj, offset);
    return bugvmAtomicLoadLong(address);
}

Object* Java_sun_misc_Unsafe_getObject(Env* env, Object* unsafe, Object* obj, jlong offset) {
    if (!checkNull(env, obj)) return NULL;
    Object** address = (Object**) getFieldAddress(obj, offset);
    return *address;
}

Object* Java_sun_misc_Unsafe_getObjectVolatile(Env* env, Object* unsafe, Object* obj, jlong offset) {
    if (!checkNull(env, obj)) return NULL;
    Object** address = (Object**) getFieldAddress(obj, offset);
    return (Object*) bugvmAtomicLoadPtr((void**) address);
}

void Java_sun_misc_Unsafe_putInt(Env* env, Object* unsafe, Object* obj, jlong offset, jint newValue) {
    if (!checkNull(env, obj)) return;
    jint* address = (jint*) getFieldAddress(obj, offset);
    *address = newValue;
}

void Java_sun_misc_Unsafe_putIntVolatile(Env* env, Object* unsafe, Object* obj, jlong offset, jint newValue) {
    if (!checkNull(env, obj)) return;
    jint* address = (jint*) getFieldAddress(obj, offset);
    bugvmAtomicStoreInt(address, newValue);
}

void Java_sun_misc_Unsafe_putLong(Env* env, Object* unsafe, Object* obj, jlong offset, jlong newValue) {
    if (!checkNull(env, obj)) return;
    jlong* address = (jlong*) getFieldAddress(obj, offset);
    *address = newValue;
}

void Java_sun_misc_Unsafe_putLongVolatile(Env* env, Object* unsafe, Object* obj, jlong offset, jlong newValue) {
    if (!checkNull(env, obj)) return;
    jlong* address = (jlong*) getFieldAddress(obj, offset);
    bugvmAtomicStoreLong(address, newValue);
}

void Java_sun_misc_Unsafe_putObject(Env* env, Object* unsafe, Object* obj, jlong offset, Object* newValue) {
    if (!checkNull(env, obj)) return;
    Object** address = (Object**) getFieldAddress(obj, offset);
    *address = newValue;
}

void Java_sun_misc_Unsafe_putObjectVolatile(Env* env, Object* unsafe, Object* obj, jlong offset, Object* newValue) {
    if (!checkNull(env, obj)) return;
    Object** address = (Object**) getFieldAddress(obj, offset);
    bugvmAtomicStorePtr((void**) address, newValue);
}

void Java_sun_misc_Unsafe_putOrderedInt(Env* env, Object* unsafe, Object* obj, jlong offset, jint newValue) {
    if (!checkNull(env, obj)) return;
    jint* address = (jint*) getFieldAddress(obj, offset);
    bugvmAtomicSynchronize();
    *address = newValue;
}

void Java_sun_misc_Unsafe_putOrderedLong(Env* env, Object* unsafe, Object* obj, jlong offset, jlong newValue) {
    if (!checkNull(env, obj)) return;
    jlong* address = (jlong*) getFieldAddress(obj, offset);
    bugvmAtomicSynchronize();
    *address = newValue;
}

void Java_sun_misc_Unsafe_putOrderedObject(Env* env, Object* unsafe, Object* obj, jlong offset, Object* newValue) {
    if (!checkNull(env, obj)) return;
    Object** address = (Object**) getFieldAddress(obj, offset);
    bugvmAtomicSynchronize();
    *address = newValue;
}

Object* Java_sun_misc_Unsafe_allocateInstance(Env* env, Object* unsafe, Class* c) {
  return bugvmAllocateObject(env, c);
}
