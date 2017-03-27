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
#ifndef BUGVM_STRING_H
#define BUGVM_STRING_H

extern jboolean bugvmInitStrings(Env* env);
extern Object* bugvmNewStringNoCopy(Env* env, CharArray* value, jint offset, jint length);
extern Object* bugvmNewString(Env* env, const jchar* chars, jint length);
extern Object* bugvmNewStringUTF(Env* env, const char* s, jint length);
extern Object* bugvmNewStringAscii(Env* env, const char* s, jint length);
extern Object* bugvmNewInternedStringUTF(Env* env, const char* s, jint length);
extern Object* bugvmInternString(Env* env, Object* str);
extern jint bugvmGetStringLength(Env* env, Object* str);
extern jchar* bugvmGetStringChars(Env* env, Object* str);
extern jint bugvmGetStringUTFLength(Env* env, Object* str);
extern char* bugvmGetStringUTFChars(Env* env, Object* str);
extern void bugvmGetStringRegion(Env* env, Object* str, jint start, jint len, jchar* buf);
extern void bugvmGetStringUTFRegion(Env* env, Object* str, jint start, jint len, char* buf);

#endif

