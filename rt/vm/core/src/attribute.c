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

#define SOURCE_FILE 1
#define SIGNATURE 2
#define INNER_CLASS 3
#define ENCLOSING_METHOD 4
#define EXCEPTIONS 5
#define RUNTIME_VISIBLE_ANNOTATIONS 6
#define RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS 7
#define ANNOTATION_DEFAULT 8

typedef union {
    jshort s;
    jint i;
    jlong j;
    jfloat f;
    jdouble d;
    void* p;
} unaligned __attribute__ ((aligned (1)));

static Class* java_lang_TypeNotPresentException = NULL;
static Class* java_lang_annotation_AnnotationFormatError = NULL;
static Class* java_lang_annotation_Annotation = NULL;
static Class* array_of_java_lang_annotation_Annotation = NULL;
static ObjectArray* emptyExceptionTypes = NULL;
static ObjectArray* emptyAnnotations = NULL;

static Class* findType(Env* env, const char* classDesc, Object* loader) {
    Class* c = bugvmFindClassByDescriptor(env, classDesc, loader);
    if (!c) {
        if (bugvmExceptionOccurred(env)->clazz == java_lang_ClassNotFoundException) {
            bugvmExceptionClear(env);
            char* className = bugvmCopyMemoryAtomicZ(env, classDesc);
            className[strlen(className)] = 0;
            bugvmThrowNew(env, java_lang_TypeNotPresentException, bugvmFromBinaryClassName(env, &className[1]));
        }
    }
    return c;
}

static jboolean throwFormatError(Env* env, char* expectedType) {
    char msg[64];
    snprintf(msg, sizeof(msg), "Invalid format: %s expected", expectedType);
    bugvmThrowNew(env, java_lang_annotation_AnnotationFormatError, msg);
    return FALSE;
}

static inline jbyte getByte(void** attributes) {
    jbyte v = *(jbyte*) *attributes;
    *attributes += sizeof(jbyte);
    return v;
}

static inline jchar getChar(void** attributes) {
    jchar v = *(jchar*) *attributes;
    *attributes += sizeof(jchar);
    return v;
}

static inline jint getInt(void** attributes) {
    jint v = ((unaligned*) *attributes)->i;
    *attributes += sizeof(jint);
    return v;
}

static inline jlong getLong(void** attributes) {
    jlong v = ((unaligned*) *attributes)->j;
    *attributes += sizeof(jlong);
    return v;
}

static inline jfloat getFloat(void** attributes) {
    jfloat v = ((unaligned*) *attributes)->f;
    *attributes += sizeof(jfloat);
    return v;
}

static inline jdouble getDouble(void** attributes) {
    jdouble v = ((unaligned*) *attributes)->d;
    *attributes += sizeof(jdouble);
    return v;
}

static inline char* getString(void** attributes) {
    char* v = (char*) ((unaligned*) *attributes)->p;
    *attributes += sizeof(char*);
    return v;
}

static void skipElementValue(void** attributes);

static void skipAnnotationElementValue(void** attributes) {
    jint length;
    getString(attributes); // Annotation class name
    length = getInt(attributes);
    while (length > 0) {
        getString(attributes); // Skip name
        skipElementValue(attributes);
        length--;
    }
}

static void skipElementValue(void** attributes) {
    jint length;

    jbyte tag = getByte(attributes);
    switch (tag) {
    case 'Z':
    case 'B':
    case 'S':
    case 'C':
    case 'I':
        getInt(attributes);
        break;
    case 'J':
        getLong(attributes);
        break;
    case 'F':
        getFloat(attributes);
        break;
    case 'D':
        getDouble(attributes);
        break;
    case 's':
        getString(attributes);
        break;
    case 'c':
        getString(attributes);
        break;
    case 'e':
        getString(attributes); // Enum class name
        getString(attributes); // Enum constant name
        break;
    case '[':
        length = getChar(attributes);
        while (length > 0) {
            skipElementValue(attributes);
            length--;
        }
        break;
    case '@':
        skipAnnotationElementValue(attributes);
        break;
    }
}

static void iterateAttributes(Env* env, void* attributes, jboolean (*f)(Env*, jbyte, void*, void*), void* data) {
    if (!attributes) return;

    jint i, j;
    jint length = 0;
    jint numParams = 0;
    jint count = getInt(&attributes);

    while (count > 0) {
        jbyte type = getByte(&attributes);
        if (!f(env, type, attributes, data)) {
            return;
        }
        if (bugvmExceptionCheck(env)) return;

        switch (type) {
        case SOURCE_FILE:
        case SIGNATURE:
            attributes += sizeof(char*);
            break;
        case INNER_CLASS:
            attributes += 3 * sizeof(char*) + sizeof(jint);
            break;
        case ENCLOSING_METHOD:
            attributes += 3 * sizeof(char*);
            break;
        case EXCEPTIONS:
            length = getInt(&attributes);
            attributes += length * sizeof(char*);
            break;
        case ANNOTATION_DEFAULT:
            skipElementValue(&attributes);
            break;
        case RUNTIME_VISIBLE_ANNOTATIONS:
            length = getInt(&attributes);
            while (length > 0) {
                skipAnnotationElementValue(&attributes);
                length--;
            }
            break;
        case RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS:
            numParams = getInt(&attributes);
            for (i = 0; i < numParams; i++) {
                length = getInt(&attributes);
                for (j = 0; j < length; j++) {
                    skipAnnotationElementValue(&attributes);
                }
            }
            break;
        }
        count--;
    }
}

static jboolean parseElementValue(Env* env, void** attributes, Class* type, Object* classLoader, jvalue* result);

static jboolean parseBooleanElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'Z') return throwFormatError(env, "boolean");
    result->z = getInt(attributes);
    return TRUE;
}

static jboolean parseByteElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'B') return throwFormatError(env, "byte");
    result->b = getInt(attributes);
    return TRUE;
}

static jboolean parseShortElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'S') return throwFormatError(env, "short");
    result->s = getInt(attributes);
    return TRUE;
}

static jboolean parseCharElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'C') return throwFormatError(env, "char");
    result->c = getInt(attributes);
    return TRUE;
}

static jboolean parseIntElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'I') return throwFormatError(env, "int");
    result->i = getInt(attributes);
    return TRUE;
}

static jboolean parseLongElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'J') return throwFormatError(env, "long");
    result->j = getLong(attributes);
    return TRUE;
}

static jboolean parseFloatElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'F') return throwFormatError(env, "float");
    result->f = getFloat(attributes);
    return TRUE;
}

static jboolean parseDoubleElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'D') return throwFormatError(env, "double");
    result->d = getDouble(attributes);
    return TRUE;
}

static jboolean parseArrayElementValue(Env* env, void** attributes, Class* arrayClass, Object* classLoader, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != '[') return throwFormatError(env, "Array");

    Class* componentType = arrayClass->componentType;

    jint length = getChar(attributes);
    Array* array = NULL;
    if (CLASS_IS_PRIMITIVE(componentType)) {
        switch (componentType->name[0]) {
        case 'Z':
            array = (Array*) bugvmNewBooleanArray(env, length);
            break;
        case 'B':
            array = (Array*) bugvmNewByteArray(env, length);
            break;
        case 'S':
            array = (Array*) bugvmNewShortArray(env, length);
            break;
        case 'C':
            array = (Array*) bugvmNewCharArray(env, length);
            break;
        case 'I':
            array = (Array*) bugvmNewIntArray(env, length);
            break;
        case 'J':
            array = (Array*) bugvmNewLongArray(env, length);
            break;
        case 'F':
            array = (Array*) bugvmNewFloatArray(env, length);
            break;
        case 'D':
            array = (Array*) bugvmNewDoubleArray(env, length);
            break;
        }
    } else {
        array = (Array*) bugvmNewObjectArray(env, length, NULL, arrayClass, NULL);
    }
    if (!array) return FALSE;

    jint i = 0;
    for (i = 0; i < length; i++) {
        jvalue v;
        if (!parseElementValue(env, attributes, componentType, classLoader, &v)) return FALSE;
        if (CLASS_IS_PRIMITIVE(componentType)) {
            switch (componentType->name[0]) {
            case 'Z':
                ((BooleanArray*) array)->values[i] = v.z;
                break;
            case 'B':
                ((ByteArray*) array)->values[i] = v.b;
                break;
            case 'S':
                ((ShortArray*) array)->values[i] = v.s;
                break;
            case 'C':
                ((CharArray*) array)->values[i] = v.c;
                break;
            case 'I':
                ((IntArray*) array)->values[i] = v.i;
                break;
            case 'J':
                ((LongArray*) array)->values[i] = v.j;
                break;
            case 'F':
                ((FloatArray*) array)->values[i] = v.f;
                break;
            case 'D':
                ((DoubleArray*) array)->values[i] = v.d;
                break;
            }
        } else {
            ((ObjectArray*) array)->values[i] = (Object*) v.l;
        }
    }
    result->l = (jobject) array;
    return result->l ? TRUE : FALSE;
}

static jboolean parseClassElementValue(Env* env, void** attributes, Object* classLoader, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'c') return throwFormatError(env, "java.lang.Class");
    char* className = getString(attributes);
    result->l = (jobject) findType(env, className, classLoader);
    return result->l ? TRUE : FALSE;
}

static jboolean parseStringElementValue(Env* env, void** attributes, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 's') return throwFormatError(env, "java.lang.String");
    char* s = getString(attributes);
    result->l = (jobject) bugvmNewStringUTF(env, s, -1);
    return result->l ? TRUE : FALSE;
}

static jboolean parseEnumElementValue(Env* env, void** attributes, Object* classLoader, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != 'e') return throwFormatError(env, "java.lang.Enum");
    char* className = getString(attributes);
    char* constName = getString(attributes);
    Class* c = findType(env, className, classLoader);
    if (c) {
        ClassField* f = bugvmGetClassField(env, c, constName, className);
        if (f) {
            result->l = (jobject) bugvmGetObjectClassFieldValue(env, c, f);
        }
    }
    return result->l ? TRUE : FALSE;
}

static Method* getAnnotationValueMethod(Env* env, Class* clazz, char* name) {
    Method* method = bugvmGetMethods(env, clazz);
    for (; method != NULL; method = method->next) {
        if (!strcmp(method->name, name)) {
            return method;
        }
    }
    return NULL;
}

static Class* findAnnotationImplClass(Env* env, Class* annotationClass, Object* classLoader) {
    char* implName = alloca(strlen(annotationClass->name) + 5 + 1);
    strcpy(implName, annotationClass->name);
    strcat(implName, "$Impl");
    return bugvmFindClassUsingLoader(env, implName, classLoader);
}

static InstanceField* getAnnotationMemberField(Env* env, Class* annotationImplClass, const char* memberName) {
    char* fieldName = alloca(strlen(memberName) + 2 + 1);
    strcpy(fieldName, "m$");
    strcat(fieldName, memberName);
    return bugvmGetInstanceField(env, annotationImplClass, fieldName, "Ljava/lang/Object;");
}

static jboolean getAnnotationValue(Env* env, void** attributes, Class* expectedAnnotationClass, Object* classLoader,
        jvalue* result, jboolean ignoreClassNotFound) {

    char* annotationTypeName = getString(attributes);
    if (expectedAnnotationClass && strncmp(&annotationTypeName[1], expectedAnnotationClass->name, strlen(expectedAnnotationClass->name))) {
        return throwFormatError(env, bugvmFromBinaryClassName(env, expectedAnnotationClass->name));
    }

    Class* annotationClass = expectedAnnotationClass;
    if (!annotationClass) {
        annotationClass = bugvmFindClassByDescriptor(env, annotationTypeName, classLoader);
        if (!annotationClass) {
            if (ignoreClassNotFound && bugvmExceptionOccurred(env)->clazz == java_lang_ClassNotFoundException) {
                bugvmExceptionClear(env);
                jint length = getInt(attributes);
                for (jint i = 0; i < length; i++) {
                    getString(attributes);
                    skipElementValue(attributes);
                }
            }
            return FALSE;
        }
    }

    // Find the annotation impl class
    Class* annotationImplClass = findAnnotationImplClass(env, annotationClass, classLoader);
    if (bugvmExceptionCheck(env)) return FALSE;

    jint length = getInt(attributes);
    if (length == 0) {
        // No member values specified. Use a singleton instance.
        Method* factoryMethod = bugvmGetClassMethod(env, annotationImplClass, "$createSingleton", "()Ljava/lang/Object;");
        if (bugvmExceptionCheck(env)) return FALSE;
        Object* annotationObject = bugvmCallObjectClassMethod(env, annotationImplClass, factoryMethod);
        if (bugvmExceptionCheck(env)) return FALSE;
        result->l = (jobject) annotationObject;
        return TRUE;
    }

    // Call the annotation impl $create() method
    Method* factoryMethod = bugvmGetClassMethod(env, annotationImplClass, "$create", "()Ljava/lang/Object;");
    if (bugvmExceptionCheck(env)) return FALSE;
    Object* annotationObject = bugvmCallObjectClassMethod(env, annotationImplClass, factoryMethod);
    if (bugvmExceptionCheck(env)) return FALSE;

    jint i = 0;
    for (i = 0; i < length; i++) {
        char* name = getString(attributes);
        Method* method = getAnnotationValueMethod(env, annotationClass, name);
        if (bugvmExceptionCheck(env)) return FALSE;
        if (!method) {
            skipElementValue(attributes);
        } else {
            const char* memberDesc = bugvmGetReturnType(method->desc);
            Class* type = findType(env, memberDesc, method->clazz->classLoader);
            Object* value = NULL;
            if (!type) {
                value = bugvmExceptionClear(env);
            } else {
                jvalue v = {0};
                if (!parseElementValue(env, attributes, type, classLoader, &v)) {
                    value = bugvmExceptionClear(env);
                } else {
                    value = bugvmBox(env, type, &v);
                }
            }

            InstanceField* field = getAnnotationMemberField(env, annotationImplClass, method->name);
            if (!field) return FALSE;

            bugvmSetObjectInstanceFieldValue(env, annotationObject, field, value);
            if (bugvmExceptionCheck(env)) return FALSE;
        }
    }

    result->l = (jobject) annotationObject;
    return TRUE;
}


static jboolean parseAnnotationElementValue(Env* env, void** attributes, Class* annotationClass, Object* classLoader, jvalue* result) {
    jbyte tag = getByte(attributes);
    if (tag != '@') return throwFormatError(env, "Annotation");

    return getAnnotationValue(env, attributes, annotationClass, classLoader, result, FALSE);
}

static jboolean parseElementValue(Env* env, void** attributes, Class* type, Object* classLoader, jvalue* result) {
    if (CLASS_IS_PRIMITIVE(type)) {
        switch (type->name[0]) {
        case 'Z':
            return parseBooleanElementValue(env, attributes, result);
        case 'B':
            return parseByteElementValue(env, attributes, result);
        case 'S':
            return parseShortElementValue(env, attributes, result);
        case 'C':
            return parseCharElementValue(env, attributes, result);
        case 'I':
            return parseIntElementValue(env, attributes, result);
        case 'J':
            return parseLongElementValue(env, attributes, result);
        case 'F':
            return parseFloatElementValue(env, attributes, result);
        case 'D':
            return parseDoubleElementValue(env, attributes, result);
        }
    } else if (CLASS_IS_ARRAY(type)) {
        return parseArrayElementValue(env, attributes, type, classLoader, result);
    } else if (type == java_lang_Class) {
        return parseClassElementValue(env, attributes, classLoader, result);
    } else if (type == java_lang_String) {
        return parseStringElementValue(env, attributes, result);
    } else if (CLASS_IS_ENUM(type) && type->superclass == java_lang_Enum) {
        return parseEnumElementValue(env, attributes, classLoader, result);
    } else if (CLASS_IS_ANNOTATION(type) && CLASS_IS_INTERFACE(type)) {
        return parseAnnotationElementValue(env, attributes, type, classLoader, result);
    }

    return FALSE;
}

static jboolean innerClassesIterator(Env* env, jbyte type, void* attributes, void* data) {
    jboolean (*f)(Env*, char*, char*, char*, jint, void*) = ((void**) data)[0];
    void* fdata = ((void**) data)[1];
    if (type == INNER_CLASS) {
        char* innerClass = getString(&attributes);
        char* outerClass = getString(&attributes);
        char* innerName = getString(&attributes);
        jint access = getInt(&attributes);
        return f(env, innerClass, outerClass, innerName, access, fdata); // f decides whether we should stop iterating
    }
    return TRUE; // Continue with next attribute
}

static void iterateInnerClasses(Env* env, void* attributes, jboolean (*f)(Env*, char*, char*, char*, jint, void*), void* fdata) {
    void* data[2] = {f, fdata};
    iterateAttributes(env, attributes, innerClassesIterator, data);
}

static jboolean enclosingMethodsIterator(Env* env, jbyte type, void* attributes, void* data) {
    jboolean (*f)(Env*, char*, char*, char*, void*) = ((void**) data)[0];
    void* fdata = ((void**) data)[1];
    if (type == ENCLOSING_METHOD) {
        char* className = getString(&attributes);
        char* methodName = getString(&attributes);
        char* methodDesc = getString(&attributes);
        return f(env, className, methodName, methodDesc, fdata); // f decides whether we should stop iterating
    }
    return TRUE; // Continue with next attribute
}

static void iterateEnclosingMethods(Env* env, void* attributes, jboolean (*f)(Env*, char*, char*, char*, void*), void* fdata) {
    void* data[2] = {f, fdata};
    iterateAttributes(env, attributes, enclosingMethodsIterator, data);
}

static jboolean getDeclaringClassIterator(Env* env, char* innerClass, char* outerClass, char* innerName, jint access, void* data) {
    Class** result = (Class**) ((void**) data)[0];
    Class* clazz = (Class*) ((void**) data)[1];
    if (innerClass && outerClass && !strcmp(innerClass, clazz->name)) {
        *result = bugvmFindClassUsingLoader(env, outerClass, clazz->classLoader);
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getEnclosingClassIterator(Env* env, char* className, char* methodName, char* methodDesc, void* data) {
    Class** result = (Class**) ((void**) data)[0];
    Class* clazz = (Class*) ((void**) data)[1];
    *result = bugvmFindClassUsingLoader(env, className, clazz->classLoader);
    return FALSE; // Stop iterating
}

static jboolean getEnclosingMethodIterator(Env* env, char* className, char* methodName, char* methodDesc, void* data) {
    Method** result = (Method**) ((void**) data)[0];
    Class* clazz = (Class*) ((void**) data)[1];
    if (methodName && methodDesc) {
        Class* c = bugvmFindClassUsingLoader(env, className, clazz->classLoader);
        if (c) {
            *result = bugvmGetMethod(env, c, methodName, methodDesc);
        }
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean isAnonymousClassIterator(Env* env, char* innerClass, char* outerClass, char* innerName, jint access, void* data) {
    jboolean* result = (jboolean*) ((void**) data)[0];
    Class* clazz = (Class*) ((void**) data)[1];
    if (innerClass && !strcmp(innerClass, clazz->name)) {
        *result = innerName == NULL ? TRUE : FALSE;
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getSignatureIterator(Env* env, jbyte type, void* attributes, void* data) {
    Object** result = (Object**) data;
    if (type == SIGNATURE) {
        *result = bugvmNewStringUTF(env, getString(&attributes), -1);
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getSourceFileIterator(Env* env, jbyte type, void* attributes, void* data) {
    Object** result = (Object**) data;
    if (type == SOURCE_FILE) {
        *result = bugvmNewStringUTF(env, getString(&attributes), -1);
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getExceptionsIterator(Env* env, jbyte type, void* attributes, void* data) {
    ObjectArray** result = (ObjectArray**) ((void**) data)[0];
    Method* method = (Method*) ((void**) data)[1];
    if (type == EXCEPTIONS) {
        jint length = getInt(&attributes);
        ObjectArray* array = bugvmNewObjectArray(env, length, java_lang_Class, NULL, NULL);
        if (array) {
            jint i = 0;
            for (i = 0; i < length; i++) {
                char* className = getString(&attributes);
                Class* c = bugvmFindClassUsingLoader(env, className, method->clazz->classLoader);
                if (!c) return FALSE;
                array->values[i] = (Object*) c;
            }
            *result = array;
        }
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getAnnotationDefaultIterator(Env* env, jbyte type, void* attributes, void* data) {
    Object** result = (Object**) ((void**) data)[0];
    Method* method = (Method*) ((void**) data)[1];
    if (type == ANNOTATION_DEFAULT) {
        Class* c = findType(env, bugvmGetReturnType(method->desc), method->clazz->classLoader);
        if (c) {
            jvalue value = {0};
            if (parseElementValue(env, &attributes, c, method->clazz->classLoader, &value)) {
                *result = bugvmBox(env, c, &value);
            }
        }
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getRuntimeVisibleAnnotationsIterator(Env* env, jbyte type, void* attributes, void* data) {
    ObjectArray** result = (ObjectArray**) ((void**) data)[0];
    Object* classLoader = (Object*) ((void**) data)[1];
    if (type == RUNTIME_VISIBLE_ANNOTATIONS) {
        jint length = getInt(&attributes);
        ObjectArray* annotations = bugvmNewObjectArray(env, length, java_lang_annotation_Annotation, NULL, NULL);
        if (!annotations) return FALSE;
        jint i = 0;
        jint actualLength = 0;
        for (i = 0; i < length; i++) {
            jvalue value = {0};
            if (getAnnotationValue(env, &attributes, NULL, classLoader, &value, TRUE)) {
                annotations->values[actualLength++] = (Object*) value.l;
            } else if (bugvmExceptionCheck(env)) {
                return FALSE;
            }
        }
        if (actualLength != length) {
            // One or more annotations could not be loaded due to a missing class.
            // Reallocate the result array and copy over the non null values.
            ObjectArray* annotations2 = bugvmNewObjectArray(env, actualLength, java_lang_annotation_Annotation, NULL, NULL);
            if (!annotations2) return FALSE;
            memcpy(annotations2->values, annotations->values, actualLength * sizeof(Object*));
            annotations = annotations2;
        }
        *result = annotations;
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getRuntimeVisibleParameterAnnotationsIterator(Env* env, jbyte type, void* attributes, void* data) {
    ObjectArray** result = (ObjectArray**) ((void**) data)[0];
    Object* classLoader = (Object*) ((void**) data)[1];
    if (type == RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS) {
        jint numParams = getInt(&attributes);
        ObjectArray* paramAnnotations = bugvmNewObjectArray(env, numParams, array_of_java_lang_annotation_Annotation, NULL, NULL);
        if (!paramAnnotations) return FALSE;
        jint i = 0;
        for (i = 0; i < numParams; i++) {
            jint length = getInt(&attributes);
            ObjectArray* annotations = bugvmNewObjectArray(env, length, java_lang_annotation_Annotation, NULL, NULL);
            if (!annotations) return FALSE;
            jint j = 0;
            jint actualLength = 0;
            for (j = 0; j < length; j++) {
                jvalue value = {0};
                if (getAnnotationValue(env, &attributes, NULL, classLoader, &value, TRUE)) {
                    annotations->values[actualLength++] = (Object*) value.l;
                } else if (bugvmExceptionCheck(env)) {
                    return FALSE;
                }
                annotations->values[j] = (Object*) value.l;
            }
            if (actualLength != length) {
                // One or more annotations could not be loaded due to a missing class.
                // Reallocate the result array and copy over the non null values.
                ObjectArray* annotations2 = bugvmNewObjectArray(env, actualLength, java_lang_annotation_Annotation, NULL, NULL);
                if (!annotations2) return FALSE;
                memcpy(annotations2->values, annotations->values, actualLength * sizeof(Object*));
                annotations = annotations2;
            }
            paramAnnotations->values[i] = (Object*) annotations;
        }
        *result = paramAnnotations;
        return FALSE; // Stop iterating
    }
    return TRUE; // Continue with next attribute
}

static jboolean getDeclaredClassesCountIterator(Env* env, char* innerClass, char* outerClass, char* innerName, jint access, void* data) {
    jint* result = (jint*) ((void**) data)[0];
    Class* clazz = (Class*) ((void**) data)[1];
    if (!outerClass || strcmp(outerClass, clazz->name)) {
        return TRUE; // Continue with next attribute
    }
    *result = *result + 1;
    return TRUE; // Continue with next attribute
}

static jboolean getDeclaredClassesIterator(Env* env, char* innerClass, char* outerClass, char* innerName, jint access, void* data) {
    ObjectArray* result = (ObjectArray*) ((void**) data)[0];
    jint* index = (jint*) ((void**) data)[1];
    Class* clazz = (Class*) ((void**) data)[2];
    if (!outerClass || strcmp(outerClass, clazz->name)) {
        return TRUE; // Continue with next attribute
    }
    Class* c = bugvmFindClassUsingLoader(env, innerClass, clazz->classLoader);
    if (!c) return FALSE; // Stop iterating
    result->values[*index] = (Object*) c;
    *index = *index + 1;
    return TRUE; // Continue with next attribute
}

typedef struct {
    Class* clazz;
    Object** innerClassName;
    jint* access;
    jboolean found;
} GetInnerClassArgs;

static jboolean getInnerClassIterator(Env* env, char* innerClass, char* outerClass, char* innerName, jint access, void* data) {
    GetInnerClassArgs* args = (GetInnerClassArgs*) data;
    Class* clazz = args->clazz;
    if (!innerClass || strcmp(innerClass, clazz->name)) {
        return TRUE; // Continue with next attribute
    }
    if (args->access) {
        *args->access = access;
    }
    if (innerName && args->innerClassName) {
        *args->innerClassName = bugvmNewStringUTF(env, innerName, -1);
    }
    args->found = TRUE;
    return FALSE; // Stop iterating
}

jboolean bugvmInitAttributes(Env* env) {
    java_lang_TypeNotPresentException = bugvmFindClassUsingLoader(env, "java/lang/TypeNotPresentException", NULL);
    if (!java_lang_TypeNotPresentException) return FALSE;
    java_lang_annotation_AnnotationFormatError = bugvmFindClassUsingLoader(env, "java/lang/annotation/AnnotationFormatError", NULL);
    if (!java_lang_annotation_AnnotationFormatError) return FALSE;

    java_lang_annotation_Annotation = bugvmFindClassUsingLoader(env, "java/lang/annotation/Annotation", NULL);
    if (!java_lang_annotation_Annotation) return FALSE;
    array_of_java_lang_annotation_Annotation = bugvmFindClassUsingLoader(env, "[Ljava/lang/annotation/Annotation;", NULL);
    if (!array_of_java_lang_annotation_Annotation) return FALSE;

    Class* array_java_lang_Class = bugvmFindClassUsingLoader(env, "[Ljava/lang/Class;", NULL);
    if (!array_java_lang_Class) return FALSE;
    emptyExceptionTypes = bugvmNewObjectArray(env, 0, NULL, array_java_lang_Class, NULL);
    if (!emptyExceptionTypes) return FALSE;
    if (!bugvmAddGlobalRef(env, (Object*) emptyExceptionTypes)) return FALSE;

    emptyAnnotations = bugvmNewObjectArray(env, 0, NULL, array_of_java_lang_annotation_Annotation, NULL);
    if (!emptyAnnotations) return FALSE;
    if (!bugvmAddGlobalRef(env, (Object*) emptyAnnotations)) return FALSE;

    return TRUE;
}

Class* bugvmAttributeGetDeclaringClass(Env* env, Class* clazz) {
    Class* result = NULL;
    void* data[2] = {&result, clazz};
    iterateInnerClasses(env, clazz->attributes, getDeclaringClassIterator, data);
    return result;
}

Class* bugvmAttributeGetEnclosingClass(Env* env, Class* clazz) {
    Class* result = NULL;
    void* data[2] = {&result, clazz};
    iterateEnclosingMethods(env, clazz->attributes, getEnclosingClassIterator, data);
    return result;
}

Method* bugvmAttributeGetEnclosingMethod(Env* env, Class* clazz) {
    Method* result = NULL;
    void* data[2] = {&result, clazz};
    iterateEnclosingMethods(env, clazz->attributes, getEnclosingMethodIterator, data);
    return result;
}

jboolean bugvmAttributeIsAnonymousClass(Env* env, Class* clazz) {
    jboolean result = FALSE;
    void* data[2] = {&result, clazz};
    iterateInnerClasses(env, clazz->attributes, isAnonymousClassIterator, data);
    return result;
}

Object* bugvmAttributeGetClassSignature(Env* env, Class* clazz) {
    Object* result = NULL;
    iterateAttributes(env, clazz->attributes, getSignatureIterator, &result);
    return result;
}

Object* bugvmAttributeGetClassSourceFile(Env* env, Class* clazz) {
    Object* result = NULL;
    iterateAttributes(env, clazz->attributes, getSourceFileIterator, &result);
    return result;
}

Object* bugvmAttributeGetMethodSignature(Env* env, Method* method) {
    Object* result = NULL;
    iterateAttributes(env, method->attributes, getSignatureIterator, &result);
    return result;
}

Object* bugvmAttributeGetFieldSignature(Env* env, Field* field) {
    Object* result = NULL;
    iterateAttributes(env, field->attributes, getSignatureIterator, &result);
    return result;
}

ObjectArray* bugvmAttributeGetExceptions(Env* env, Method* method) {
    if (!method->attributes) return emptyExceptionTypes;
    ObjectArray* result = NULL;
    void* data[2] = {&result, method};
    iterateAttributes(env, method->attributes, getExceptionsIterator, data);
    return result ? result : emptyExceptionTypes;
}

Object* bugvmAttributeGetAnnotationDefault(Env* env, Method* method) {
    Object* result = NULL;
    void* data[2] = {&result, method};
    iterateAttributes(env, method->attributes, getAnnotationDefaultIterator, data);
    return result;
}

ObjectArray* bugvmAttributeGetClassRuntimeVisibleAnnotations(Env* env, Class* clazz) {
    ObjectArray* result = NULL;
    void* data[2] = {&result, clazz->classLoader};
    iterateAttributes(env, clazz->attributes, getRuntimeVisibleAnnotationsIterator, data);
    return result ? result : emptyAnnotations;
}

ObjectArray* bugvmAttributeGetMethodRuntimeVisibleAnnotations(Env* env, Method* method) {
    ObjectArray* result = NULL;
    void* data[2] = {&result, method->clazz->classLoader};
    iterateAttributes(env, method->attributes, getRuntimeVisibleAnnotationsIterator, data);
    return result ? result : emptyAnnotations;
}

ObjectArray* bugvmAttributeGetFieldRuntimeVisibleAnnotations(Env* env, Field* field) {
    ObjectArray* result = NULL;
    void* data[2] = {&result, field->clazz->classLoader};
    iterateAttributes(env, field->attributes, getRuntimeVisibleAnnotationsIterator, data);
    return result ? result : emptyAnnotations;
}

ObjectArray* bugvmAttributeGetMethodRuntimeVisibleParameterAnnotations(Env* env, Method* method) {
    ObjectArray* result = NULL;
    void* data[2] = {&result, method->clazz->classLoader};
    iterateAttributes(env, method->attributes, getRuntimeVisibleParameterAnnotationsIterator, data);
    return result ? result : emptyAnnotations;
}

ObjectArray* bugvmAttributeGetDeclaredClasses(Env* env, Class* clazz) {
    if (!clazz->attributes) return NULL;
    jint count = 0;
    void* countData[2] = {&count, clazz};
    iterateInnerClasses(env, clazz->attributes, getDeclaredClassesCountIterator, countData);
    if (count == 0) return NULL;
    ObjectArray* result = bugvmNewObjectArray(env, count, java_lang_Class, NULL, NULL);
    jint index = 0;
    void* data[3] = {result, &index, clazz};
    iterateInnerClasses(env, clazz->attributes, getDeclaredClassesIterator, data);
    return result;
}

jboolean bugvmAttributeGetInnerClass(Env* env, Class* clazz, Object** innerClassName, jint* access) {
    GetInnerClassArgs args = {0};
    args.clazz = clazz;
    args.innerClassName = innerClassName ? innerClassName : NULL;
    args.access = access ? access : NULL;
    iterateInnerClasses(env, clazz->attributes, getInnerClassIterator, &args);
    return args.found;
}
