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

Class* Java_java_lang_reflect_Field_getDeclaringClass(Env* env, Class* clazz, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    return field->clazz;
}

Object* Java_java_lang_reflect_Field_getName(Env* env, Class* clazz, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    return bugvmNewStringUTF(env, field->name, -1);
}

jint Java_java_lang_reflect_Field_getModifiers(Env* env, Class* clazz, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    return field->access & FIELD_ACCESS_MASK;
}

Class* Java_java_lang_reflect_Field_getType(Env* env, Class* clazz, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    return bugvmFindClassByDescriptor(env, field->desc, field->clazz->classLoader);
}

Object* Java_java_lang_reflect_Field_getSignatureAttribute(Env* env, Class* clazz, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    return bugvmAttributeGetFieldSignature(env, field);
}

ObjectArray* Java_java_lang_reflect_Field_getDeclaredAnnotations(Env* env, Class* clazz, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    return bugvmAttributeGetFieldRuntimeVisibleAnnotations(env, field);
}

jboolean Java_java_lang_reflect_Field_getZ(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetBooleanClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetBooleanInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

jbyte Java_java_lang_reflect_Field_getB(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetByteClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetByteInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

jchar Java_java_lang_reflect_Field_getC(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetCharClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetCharInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

jshort Java_java_lang_reflect_Field_getS(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetShortClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetShortInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

jint Java_java_lang_reflect_Field_getI(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetIntClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetIntInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

jlong Java_java_lang_reflect_Field_getJ(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetLongClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetLongInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

jfloat Java_java_lang_reflect_Field_getF(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetFloatClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetFloatInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

jdouble Java_java_lang_reflect_Field_getD(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetDoubleClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetDoubleInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

Object* Java_java_lang_reflect_Field_getL(Env* env, Class* clazz, Object* o, jlong fieldPtr) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        return bugvmGetObjectClassFieldValue(env, field->clazz, (ClassField*) field);
    } else {
        assert(o != NULL);
        return bugvmGetObjectInstanceFieldValue(env, o, (InstanceField*) field);
    }
}

void Java_java_lang_reflect_Field_setZ(Env* env, Class* clazz, Object* o, jlong fieldPtr, jboolean value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetBooleanClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetBooleanInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setB(Env* env, Class* clazz, Object* o, jlong fieldPtr, jbyte value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetByteClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetByteInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setC(Env* env, Class* clazz, Object* o, jlong fieldPtr, jchar value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetCharClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetCharInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setS(Env* env, Class* clazz, Object* o, jlong fieldPtr, jshort value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetShortClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetShortInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setI(Env* env, Class* clazz, Object* o, jlong fieldPtr, jint value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetIntClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetIntInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setJ(Env* env, Class* clazz, Object* o, jlong fieldPtr, jlong value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetLongClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetLongInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setF(Env* env, Class* clazz, Object* o, jlong fieldPtr, jfloat value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetFloatClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetFloatInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setD(Env* env, Class* clazz, Object* o, jlong fieldPtr, jdouble value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetDoubleClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetDoubleInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}

void Java_java_lang_reflect_Field_setL(Env* env, Class* clazz, Object* o, jlong fieldPtr, Object* value) {
    Field* field = (Field*) LONG_TO_PTR(fieldPtr);
    assert(field != NULL);
    if (FIELD_IS_STATIC(field)) {
        bugvmSetObjectClassFieldValue(env, field->clazz, (ClassField*) field, value);
    } else {
        assert(o != NULL);
        bugvmSetObjectInstanceFieldValue(env, o, (InstanceField*) field, value);
    }
}
