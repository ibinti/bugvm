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
#ifndef BUGVM_MEMORY_H
#define BUGVM_MEMORY_H

extern jboolean bugvmInitMemory(Env* env);
extern Class* bugvmAllocateMemoryForClass(Env* env, jint classDataSize);
extern void bugvmSetupGcDescriptor(Env* env, Class* clazz);
extern Object* bugvmAllocateMemoryForObject(Env* env, Class* clazz);
extern jboolean bugvmIsCriticalOutOfMemoryError(Env* env, Object* throwable);
extern void bugvmRegisterFinalizer(Env* env, Object* obj);
extern void bugvmRegisterReference(Env* env, Object* reference, Object* referent);
extern void bugvmRegisterDisappearingLink(Env* env, void** address, Object* obj);
extern void bugvmUnregisterDisappearingLink(Env* env, void** address);
extern Array* bugvmAllocateMemoryForArray(Env* env, Class* arrayClass, jint length);
extern void* bugvmAllocateMemory(Env* env, size_t size);
extern void* bugvmAllocateMemoryUncollectable(Env* env, size_t size);
extern void* bugvmAllocateMemoryAtomic(Env* env, size_t size);
extern void* bugvmAllocateMemoryAtomicUncollectable(Env* env, size_t size);
extern void bugvmFreeMemoryUncollectable(Env* env, void* m);
extern void bugvmGCCollect(Env* env);
extern jboolean bugvmInitRefTable(Env* env, RefTable* refTable, jint size);
extern jboolean bugvmAddGlobalRef(Env* env, Object* object);
extern jboolean bugvmRemoveGlobalRef(Env* env, Object* object);
extern jboolean bugvmAddRef(Env* env, RefTable* refTable, Object* object);
extern jboolean bugvmRemoveRef(Env* env, RefTable* refTable, Object* object);
extern jlong bugvmGetFreeMemory(Env* env);
extern jlong bugvmGetTotalMemory(Env* env);
extern jlong bugvmGetMaxMemory(Env* env);
extern void* bugvmCopyMemoryAtomic(Env* env, const void* src, size_t size);
extern void* bugvmCopyMemoryAtomicZ(Env* env, const char* src);
extern void* bugvmCopyMemory(Env* env, const void* src, size_t size);
extern Object* bugvmNewDirectByteBuffer(Env* env, void* address, jlong capacity);
extern void* bugvmGetDirectBufferAddress(Env* env, Object* buf);
extern jlong bugvmGetDirectBufferCapacity(Env* env, Object* buf);
extern void bugvmGenerateHeapDump(Env* env);

// Moves n 16-bit values from src to dest. src and dest must be 16-bit aligned.
static inline void bugvmMoveMemory16(void* dest, const void* src, size_t n) {
    // This function is a modified version of the move16 function in Android's java_lang_System.cpp
    assert((((uintptr_t) dest | (uintptr_t) src) & 0x01) == 0);

    uint16_t* d = (uint16_t*) dest;
    const uint16_t* s = (uint16_t*) src;

    if (d < s) {
        /* copy forward */
        while (n--) {
            *d++ = *s++;
        }
    } else {
        /* copy backward */
        d += n;
        s += n;
        while (n--) {
            *--d = *--s;
        }
    }
}

// Moves n 32-bit values from src to dest. src and dest must be 32-bit aligned.
static inline void bugvmMoveMemory32(void* dest, const void* src, size_t n) {
    // This function is a modified version of the move32 function in Android's java_lang_System.cpp
    assert((((uintptr_t) dest | (uintptr_t) src) & 0x03) == 0);

    uint32_t* d = (uint32_t*) dest;
    const uint32_t* s = (uint32_t*) src;

    if (d < s) {
        /* copy forward */
        while (n--) {
            *d++ = *s++;
        }
    } else {
        /* copy backward */
        d += n;
        s += n;
        while (n--) {
            *--d = *--s;
        }
    }
}
#endif

