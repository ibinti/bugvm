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

static Field* getField(Env* env, Class* clazz, char* name, char* desc) {
    Field* field = bugvmGetFields(env, clazz);
    if (bugvmExceptionCheck(env)) return NULL;
    for (; field != NULL; field = field->next) {
        if (!strcmp(field->name, name) && !strcmp(field->desc, desc)) {
            return field;
        }
    }

    Interface* interfaze = bugvmGetInterfaces(env, clazz);
    if (bugvmExceptionCheck(env)) return NULL;
    for (; interfaze != NULL; interfaze = interfaze->next) {
        field = getField(env, interfaze->interfaze, name, desc);
        if (bugvmExceptionCheck(env)) return NULL;
        if (field) return field;
    }

    if (clazz->superclass) {
        return getField(env, clazz->superclass, name, desc);
    }

    return NULL;
}

Field* bugvmGetField(Env* env, Class* clazz, char* name, char* desc) {
    Field* field = getField(env, clazz, name, desc);
    if (bugvmExceptionCheck(env)) return NULL;
    if (!field) {
        bugvmThrowNoSuchFieldError(env, name);
        return NULL;
    }
    return field;
}

ClassField* bugvmGetClassField(Env* env, Class* clazz, char* name, char* desc) {
    Field* field = bugvmGetField(env, clazz, name, desc);
    if (!field) return NULL;
    if (!(field->access & ACC_STATIC)) {
        // TODO: JNI spec doesn't say anything about throwing this
        bugvmThrowIncompatibleClassChangeErrorClassField(env, clazz, name, desc);
        return NULL;
    }
    return (ClassField*) field;
}

InstanceField* bugvmGetInstanceField(Env* env, Class* clazz, char* name, char* desc) {
    Field* field = bugvmGetField(env, clazz, name, desc);
    if (!field) return NULL;
    if (field->access & ACC_STATIC) {
        // TODO: JNI spec doesn't say anything about throwing this
        bugvmThrowIncompatibleClassChangeErrorInstanceField(env, clazz, name, desc);
        return NULL;
    }
    return (InstanceField*) field;
}

static inline void* getFieldAddress(Object* obj, InstanceField* field) {
    return (void*) ((jbyte*) obj + field->offset);
}

Object* bugvmGetObjectInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(Object**) getFieldAddress(obj, field);
}

jboolean bugvmGetBooleanInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jboolean*) getFieldAddress(obj, field);
}

jbyte bugvmGetByteInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jbyte*) getFieldAddress(obj, field);
}

jchar bugvmGetCharInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jchar*) getFieldAddress(obj, field);
}

jshort bugvmGetShortInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jshort*) getFieldAddress(obj, field);
}

jint bugvmGetIntInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jint*) getFieldAddress(obj, field);
}

jlong bugvmGetLongInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jlong*) getFieldAddress(obj, field);
}

jfloat bugvmGetFloatInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jfloat*) getFieldAddress(obj, field);
}

jdouble bugvmGetDoubleInstanceFieldValue(Env* env, Object* obj, InstanceField* field) {
    return *(jdouble*) getFieldAddress(obj, field);
}

void bugvmSetObjectInstanceFieldValue(Env* env, Object* obj, InstanceField* field, Object* value) {
    *(Object**) getFieldAddress(obj, field) = value;
}

void bugvmSetBooleanInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jboolean value) {
    *(jboolean*) getFieldAddress(obj, field) = value;
}

void bugvmSetByteInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jbyte value) {
    *(jbyte*) getFieldAddress(obj, field) = value;
}

void bugvmSetCharInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jchar value) {
    *(jchar*) getFieldAddress(obj, field) = value;
}

void bugvmSetShortInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jshort value) {
    *(jshort*) getFieldAddress(obj, field) = value;
}

void bugvmSetIntInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jint value) {
    *(jint*) getFieldAddress(obj, field) = value;
}

void bugvmSetLongInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jlong value) {
    *(jlong*) getFieldAddress(obj, field) = value;
}

void bugvmSetFloatInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jfloat value) {
    *(jfloat*) getFieldAddress(obj, field) = value;
}

void bugvmSetDoubleInstanceFieldValue(Env* env, Object* obj, InstanceField* field, jdouble value) {
    *(jdouble*) getFieldAddress(obj, field) = value;
}

Object* bugvmGetObjectClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(Object**) field->address;
}

jboolean bugvmGetBooleanClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jboolean*) field->address;
}

jbyte bugvmGetByteClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jbyte*) field->address;
}

jchar bugvmGetCharClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jchar*) field->address;
}

jshort bugvmGetShortClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jshort*) field->address;
}

jint bugvmGetIntClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jint*) field->address;
}

jlong bugvmGetLongClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jlong*) field->address;
}

jfloat bugvmGetFloatClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jfloat*) field->address;
}

jdouble bugvmGetDoubleClassFieldValue(Env* env, Class* clazz, ClassField* field) {
    bugvmInitialize(env, field->field.clazz);
    return *(jdouble*) field->address;
}

void bugvmSetObjectClassFieldValue(Env* env, Class* clazz, ClassField* field, Object* value) {
    bugvmInitialize(env, field->field.clazz);
    *(Object**) field->address = value;
}

void bugvmSetBooleanClassFieldValue(Env* env, Class* clazz, ClassField* field, jboolean value) {
    bugvmInitialize(env, field->field.clazz);
    *(jboolean*) field->address = value;
}

void bugvmSetByteClassFieldValue(Env* env, Class* clazz, ClassField* field, jbyte value) {
    bugvmInitialize(env, field->field.clazz);
    *(jbyte*) field->address = value;
}

void bugvmSetCharClassFieldValue(Env* env, Class* clazz, ClassField* field, jchar value) {
    bugvmInitialize(env, field->field.clazz);
    *(jchar*) field->address = value;
}

void bugvmSetShortClassFieldValue(Env* env, Class* clazz, ClassField* field, jshort value) {
    bugvmInitialize(env, field->field.clazz);
    *(jshort*) field->address = value;
}

void bugvmSetIntClassFieldValue(Env* env, Class* clazz, ClassField* field, jint value) {
    bugvmInitialize(env, field->field.clazz);
    *(jint*) field->address = value;
}

void bugvmSetLongClassFieldValue(Env* env, Class* clazz, ClassField* field, jlong value) {
    bugvmInitialize(env, field->field.clazz);
    *(jlong*) field->address = value;
}

void bugvmSetFloatClassFieldValue(Env* env, Class* clazz, ClassField* field, jfloat value) {
    bugvmInitialize(env, field->field.clazz);
    *(jfloat*) field->address = value;
}

void bugvmSetDoubleClassFieldValue(Env* env, Class* clazz, ClassField* field, jdouble value) {
    bugvmInitialize(env, field->field.clazz);
    *(jdouble*) field->address = value;
}

