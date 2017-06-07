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
#include "reflection_helpers.h"

Object* Java_java_lang_reflect_Method_internalInvoke(Env* env, Class* clazz, jlong methodPtr, ObjectArray* parameterTypes, Object* receiver, ObjectArray* args) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);

    /*
     * The Java code has already checked that the method is accessible
     * to the the caller, that the receiver isn't null (for non static methods),
     * that the receiver is an instance of the declaring class (for non static methods)
     * and that the number of arguments are correct. The args array is never null.
     */

    jvalue* jvalueArgs = validateAndUnwrapArgs(env, parameterTypes, args);
    if (!jvalueArgs) return NULL;

    const char* retDesc = bugvmGetReturnType(method->desc);

    jvalue jvalueRet[1];
    if (METHOD_IS_STATIC(method)) {
        switch (retDesc[0]) {
        case 'V':
            bugvmCallVoidClassMethodA(env, method->clazz, method, jvalueArgs);
            jvalueRet->l = NULL;
            break;
        case 'Z':
            jvalueRet->z = bugvmCallBooleanClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        case 'B':
            jvalueRet->b = bugvmCallByteClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        case 'S':
            jvalueRet->s = bugvmCallShortClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        case 'C':
            jvalueRet->c = bugvmCallCharClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        case 'I':
            jvalueRet->i = bugvmCallIntClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        case 'J':
            jvalueRet->j = bugvmCallLongClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        case 'F':
            jvalueRet->f = bugvmCallFloatClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        case 'D':
            jvalueRet->d = bugvmCallDoubleClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        default:
            jvalueRet->l = (jobject) bugvmCallObjectClassMethodA(env, method->clazz, method, jvalueArgs);
            break;
        }
    } else {
        switch (retDesc[0]) {
        case 'V':
            bugvmCallVoidInstanceMethodA(env, receiver, method, jvalueArgs);
            jvalueRet->l = NULL;
            break;
        case 'Z':
            jvalueRet->z = bugvmCallBooleanInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        case 'B':
            jvalueRet->b = bugvmCallByteInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        case 'S':
            jvalueRet->s = bugvmCallShortInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        case 'C':
            jvalueRet->c = bugvmCallCharInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        case 'I':
            jvalueRet->i = bugvmCallIntInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        case 'J':
            jvalueRet->j = bugvmCallLongInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        case 'F':
            jvalueRet->f = bugvmCallFloatInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        case 'D':
            jvalueRet->d = bugvmCallDoubleInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        default:
            jvalueRet->l = (jobject) bugvmCallObjectInstanceMethodA(env, receiver, method, jvalueArgs);
            break;
        }
    }

    if (bugvmExceptionCheck(env)) {
        throwInvocationTargetException(env, bugvmExceptionOccurred(env));
        return NULL;
    }

    if (retDesc[0] != 'L' && retDesc[0] != '[') {
        // Return type is primitive. Box it.
        Class* retType = bugvmFindClassByDescriptor(env, retDesc, NULL);
        return bugvmBox(env, retType, jvalueRet);
    } else {
        return (Object*) jvalueRet->l;
    }
}

Class* Java_java_lang_reflect_Method_getDeclaringClass(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    return method->clazz;
}

jint Java_java_lang_reflect_Method_getModifiers(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    return method->access & METHOD_ACCESS_MASK;
}

Object* Java_java_lang_reflect_Method_getName(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    return bugvmNewStringUTF(env, method->name, -1);
}

Class* Java_java_lang_reflect_Method_getReturnType(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    return bugvmFindClassByDescriptor(env, bugvmGetReturnType(method->desc), method->clazz->classLoader);
}

Object* Java_java_lang_reflect_Method_getSignatureAttribute(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    Class* java_lang_reflect_Proxy = bugvmFindClassUsingLoader(env, "java/lang/reflect/Proxy", NULL);
    if (method->clazz->superclass == java_lang_reflect_Proxy) {
        return bugvmAttributeGetMethodSignature(env, ((ProxyMethod*) method)->proxiedMethod);
    }
    return bugvmAttributeGetMethodSignature(env, method);
}

ObjectArray* Java_java_lang_reflect_Method_getParameterTypes(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);

    jint argsCount = bugvmGetParameterCount(method);

    Class* array_java_lang_Class = bugvmFindClassUsingLoader(env, "[Ljava/lang/Class;", NULL);
    if (!array_java_lang_Class) return NULL;
    ObjectArray* paramTypes = bugvmNewObjectArray(env, argsCount, NULL, array_java_lang_Class, NULL);
    if (!paramTypes) return NULL;

    const char* desc = method->desc;
    const char* s;
    jint i = 0;
    while ((s = bugvmGetNextParameterType(&desc))) {
        char* paramTypeName = bugvmAllocateMemoryAtomic(env, desc - s + 1);
        if (!paramTypeName) return NULL;
        strncpy(paramTypeName, s, desc - s);
        Class* paramType = bugvmFindClassByDescriptor(env, paramTypeName, method->clazz->classLoader);
        if (!paramType) return NULL;
        paramTypes->values[i++] = (Object*) paramType;
    }

    return paramTypes;
}

ObjectArray* Java_java_lang_reflect_Method_getExceptionTypes(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    Class* java_lang_reflect_Proxy = bugvmFindClassUsingLoader(env, "java/lang/reflect/Proxy", NULL);
    if (method->clazz->superclass == java_lang_reflect_Proxy) {
        return bugvmAttributeGetExceptions(env, ((ProxyMethod*) method)->proxiedMethod);
    }
    return bugvmAttributeGetExceptions(env, method);
}

Object* Java_java_lang_reflect_Method_getDefaultValue(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    return bugvmAttributeGetAnnotationDefault(env, method);
}

ObjectArray* Java_java_lang_reflect_Method_getDeclaredAnnotations(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    return bugvmAttributeGetMethodRuntimeVisibleAnnotations(env, method);
}

ObjectArray* Java_java_lang_reflect_Method_getParameterAnnotations(Env* env, Class* clazz, jlong methodPtr) {
    Method* method = (Method*) LONG_TO_PTR(methodPtr);
    return bugvmAttributeGetMethodRuntimeVisibleParameterAnnotations(env, method);
}

