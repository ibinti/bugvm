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

Object* Java_java_lang_reflect_Array_createObjectArray(Env* env, Class* cls, Class* componentType, jint length) {
    return (Object*) bugvmNewObjectArray(env, length, componentType, NULL, NULL);
}

Object* Java_java_lang_reflect_Array_createMultiArray(Env* env, Class* cls, Class* componentType, IntArray* dimensions) {
    const char* componentTypeDesc = bugvmGetClassDescriptor(env, componentType);
    char* desc = bugvmAllocateMemoryAtomic(env, strlen(componentTypeDesc) + dimensions->length + 1);
    memset(desc, '[', dimensions->length);
    strcat(desc, componentTypeDesc);

    Class* clazz = bugvmFindClassByDescriptor(env, desc, componentType->classLoader);
    return (Object*) bugvmNewMultiArray(env, dimensions->length, dimensions->values, clazz);
}
