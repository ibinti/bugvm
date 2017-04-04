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
#ifndef BUGVM_ATTRIBUTE_H
#define BUGVM_ATTRIBUTE_H

extern jboolean bugvmInitAttributes(Env* env);
extern Class* bugvmAttributeGetDeclaringClass(Env* env, Class* clazz);
extern Class* bugvmAttributeGetEnclosingClass(Env* env, Class* clazz);
extern Method* bugvmAttributeGetEnclosingMethod(Env* env, Class* clazz);
extern jboolean bugvmAttributeIsAnonymousClass(Env* env, Class* clazz);
extern Object* bugvmAttributeGetClassSignature(Env* env, Class* clazz);
extern Object* bugvmAttributeGetClassSourceFile(Env* env, Class* clazz);
extern Object* bugvmAttributeGetMethodSignature(Env* env, Method* method);
extern Object* bugvmAttributeGetFieldSignature(Env* env, Field* field);
extern Object* bugvmAttributeGetAnnotationDefault(Env* env, Method* method);
extern ObjectArray* bugvmAttributeGetExceptions(Env* env, Method* method);
extern ObjectArray* bugvmAttributeGetClassRuntimeVisibleAnnotations(Env* env, Class* clazz);
extern ObjectArray* bugvmAttributeGetMethodRuntimeVisibleAnnotations(Env* env, Method* method);
extern ObjectArray* bugvmAttributeGetFieldRuntimeVisibleAnnotations(Env* env, Field* field);
extern ObjectArray* bugvmAttributeGetMethodRuntimeVisibleParameterAnnotations(Env* env, Method* method);
extern ObjectArray* bugvmAttributeGetDeclaredClasses(Env* env, Class* clazz);
extern jboolean bugvmAttributeGetInnerClass(Env* env, Class* clazz, Object** innerClassName, jint* access);

#endif

