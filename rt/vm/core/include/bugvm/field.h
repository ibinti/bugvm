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
#ifndef BUGVM_FIELD_H
#define BUGVM_FIELD_H

#define FIELD_ACCESS_MASK   0x0000FFFF

#define FIELD_IS_PUBLIC(f) (IS_PUBLIC((f)->access))
#define FIELD_IS_PRIVATE(f) (IS_PRIVATE((f)->access))
#define FIELD_IS_PROTECTED(f) (IS_PROTECTED((f)->access))
#define FIELD_IS_STATIC(f) (IS_STATIC((f)->access))
#define FIELD_IS_FINAL(f) (IS_FINAL((f)->access))
#define FIELD_IS_PACKAGE_PRIVATE(f) (IS_PACKAGE_PRIVATE((f)->access))

extern Field* bugvmGetField(Env* env, Class* clazz, char* name, char* desc);

/**
 * Returns the class field with the specified name and descriptor defined by the specified
 * class or one of its super classes.
 *
 * @throws NoSuchFieldError
 * @throws IncompatibleClassChangeError if the field hasn't got the ACC_STATIC modifier.
 */
extern ClassField* bugvmGetClassField(Env* env, Class* clazz, char* name, char* desc);

/**
 * Returns the instance field with the specified name and descriptor defined by the specified
 * class or one of its super classes.
 *
 * @throws NoSuchFieldError
 * @throws IncompatibleClassChangeError if the field has got the ACC_STATIC modifier.
 */
extern InstanceField* bugvmGetInstanceField(Env* env, Class* clazz, char* name, char* desc);

extern Object* bugvmGetObjectInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jboolean bugvmGetBooleanInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jbyte bugvmGetByteInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jchar bugvmGetCharInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jshort bugvmGetShortInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jint bugvmGetIntInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jlong bugvmGetLongInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jfloat bugvmGetFloatInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern jdouble bugvmGetDoubleInstanceFieldValue(Env* env, Object* obj, InstanceField* field);
extern void bugvmSetObjectInstanceFieldValue(Env* env, Object* obj, InstanceField* field, Object* value);
extern void bugvmSetBooleanInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jboolean value);
extern void bugvmSetByteInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jbyte value);
extern void bugvmSetCharInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jchar value);
extern void bugvmSetShortInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jshort value);
extern void bugvmSetIntInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jint value);
extern void bugvmSetLongInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jlong value);
extern void bugvmSetFloatInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jfloat value);
extern void bugvmSetDoubleInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jdouble value);

extern Object* bugvmGetObjectClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jboolean bugvmGetBooleanClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jbyte bugvmGetByteClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jchar bugvmGetCharClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jshort bugvmGetShortClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jint bugvmGetIntClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jlong bugvmGetLongClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jfloat bugvmGetFloatClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern jdouble bugvmGetDoubleClassFieldValue(Env* env, Class* clazz, ClassField* field);
extern void bugvmSetObjectClassFieldValue(Env* env, Class* clazz, ClassField* field, Object* value);
extern void bugvmSetBooleanClassFieldValue(Env* env, Class* clazz, ClassField* field, jboolean value);
extern void bugvmSetByteClassFieldValue(Env* env, Class* clazz, ClassField* field, jbyte value);
extern void bugvmSetCharClassFieldValue(Env* env, Class* clazz, ClassField* field, jchar value);
extern void bugvmSetShortClassFieldValue(Env* env, Class* clazz, ClassField* field, jshort value);
extern void bugvmSetIntClassFieldValue(Env* env, Class* clazz, ClassField* field, jint value);
extern void bugvmSetLongClassFieldValue(Env* env, Class* clazz, ClassField* field, jlong value);
extern void bugvmSetFloatClassFieldValue(Env* env, Class* clazz, ClassField* field, jfloat value);
extern void bugvmSetDoubleClassFieldValue(Env* env, Class* clazz, ClassField* field, jdouble value);

#endif

