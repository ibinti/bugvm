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
#ifndef BUGVM_ARRAY_H
#define BUGVM_ARRAY_H

extern BooleanArray* bugvmNewBooleanArray(Env* env, jint length);
extern ByteArray* bugvmNewByteArray(Env* env, jint length);
extern CharArray* bugvmNewCharArray(Env* env, jint length);
extern ShortArray* bugvmNewShortArray(Env* env, jint length);
extern IntArray* bugvmNewIntArray(Env* env, jint length);
extern LongArray* bugvmNewLongArray(Env* env, jint length);
extern FloatArray* bugvmNewFloatArray(Env* env, jint length);
extern DoubleArray* bugvmNewDoubleArray(Env* env, jint length);
extern ObjectArray* bugvmNewObjectArray(Env* env, jint length, Class* elementClass, Class* arrayClass, Object* init);
extern Array* bugvmNewMultiArray(Env* env, jint dims, jint* lengths, Class* type);
extern Array* bugvmCloneArray(Env* env, Array* array);
extern jint bugvmGetArrayDimensions(Env* env, Array* array);
extern jint bugvmGetArrayElementSize(Env* env, Class* arrayClass);
extern jlong bugvmGetArraySize(Env* env, Class* arrayClass, jint length);

#endif

