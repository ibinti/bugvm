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
#include "reflection_helpers.h"
#include "utlist.h"

static Class* java_lang_reflect_InvocationHandler = NULL;
static Method* java_lang_reflect_InvocationHandler_invoke = NULL;
static InstanceField* java_lang_reflect_Proxy_h = NULL;
static Class* java_lang_reflect_UndeclaredThrowableException = NULL;
static Method* java_lang_reflect_UndeclaredThrowableException_init = NULL;

static void handler(Env* env, Object* receiver, ProxyMethod* method, jvalue* args, jvalue* returnValue) {
    Class* proxyClass = receiver->clazz;
    Class* java_lang_reflect_Proxy = proxyClass->superclass;
    if (!java_lang_reflect_InvocationHandler) {
        java_lang_reflect_InvocationHandler = bugvmFindClassUsingLoader(env, "java/lang/reflect/InvocationHandler", NULL);
        if (!java_lang_reflect_InvocationHandler) return;
    }
    if (!java_lang_reflect_InvocationHandler_invoke) {
        java_lang_reflect_InvocationHandler_invoke = bugvmGetInstanceMethod(env, java_lang_reflect_InvocationHandler,
                "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;");
        if (!java_lang_reflect_InvocationHandler_invoke) return;
    }
    if (!java_lang_reflect_Proxy_h) {
        java_lang_reflect_Proxy_h = bugvmGetInstanceField(env, java_lang_reflect_Proxy, "h", "Ljava/lang/reflect/InvocationHandler;");
        if (!java_lang_reflect_Proxy_h) return;
    }
    Object* h = bugvmGetObjectInstanceFieldValue(env, receiver, java_lang_reflect_Proxy_h);
    if (bugvmExceptionCheck(env)) return;
    if (!h) {
        bugvmThrowNullPointerException(env);
        return;
    }

    // TODO: Reuse java.lang.reflect.Method objects?    
    Object* methodObject = createMethodObject(env, method->proxiedMethod);
    if (!methodObject) return;

    const char* desc = method->method.desc;
    const char* c;
    jint i = 0;
    while ((c = bugvmGetNextParameterType(&desc))) {
        if (c[0] != 'L' && c[0] != '[') {
            // Primitive. Needs wrapping.
            char typeName[2] = {c[0], 0};
            Class* type = bugvmFindClassByDescriptor(env, typeName, NULL);
            if (!type) return;
            args[i].l = (jobject) bugvmBox(env, type, &args[i]);
        }
        i++;
    }

    jint length = i;
    ObjectArray* argsArray = NULL;
    if (length > 0) {
        argsArray = bugvmNewObjectArray(env, length, java_lang_Object, NULL, NULL);
        if (!argsArray) return;
        for (i = 0; i < length; i++) {
            argsArray->values[i] = (Object*) args[i].l;
        }
    }

    jvalue invokeArgs[3];
    invokeArgs[0].l = (jobject) receiver;
    invokeArgs[1].l = (jobject) methodObject;
    invokeArgs[2].l = (jobject) argsArray;
    Object* result = bugvmCallObjectInstanceMethodA(env, h, java_lang_reflect_InvocationHandler_invoke, invokeArgs);
    Object* throwable = bugvmExceptionOccurred(env);
    if (throwable) {
        if (bugvmIsSubClass(java_lang_RuntimeException, throwable->clazz) || bugvmIsSubClass(java_lang_Error, throwable->clazz)) {
            // Instances of java.lang.RuntimeException and java.lang.Error can always be thrown
            return;
        }
        bugvmExceptionClear(env);

        ProxyMethodException* pme = NULL;
        LL_FOREACH(method->allowedExceptions, pme) {
            if (bugvmIsSubClass(pme->clazz, throwable->clazz)) {
                bugvmThrow(env, throwable);
                return;
            }
        }

        if (!java_lang_reflect_UndeclaredThrowableException) {
            java_lang_reflect_UndeclaredThrowableException = bugvmFindClassUsingLoader(env,
                "java/lang/reflect/UndeclaredThrowableException", NULL);
            if (!java_lang_reflect_UndeclaredThrowableException) return;
        }
        if (!java_lang_reflect_UndeclaredThrowableException_init) {
            java_lang_reflect_UndeclaredThrowableException_init = bugvmGetInstanceMethod(env,
                java_lang_reflect_UndeclaredThrowableException, 
                "<init>", "(Ljava/lang/Throwable;)V");
            if (!java_lang_reflect_UndeclaredThrowableException_init) return;
        }
        throwable = bugvmNewObject(env, java_lang_reflect_UndeclaredThrowableException, java_lang_reflect_UndeclaredThrowableException_init, throwable);
        if (!throwable) return;
        bugvmThrow(env, throwable);
        return;
    }

    const char* returnTypeDesc = bugvmGetReturnType(method->method.desc);
    if (returnTypeDesc[0] == 'V') {
        // void method. Just return.
        return;
    }

    if (returnTypeDesc[0] == 'L' || returnTypeDesc[0] == '[') {
        if (!result) {
            returnValue->l = NULL;
            return;
        }
        Class* type = bugvmFindClassByDescriptor(env, returnTypeDesc, proxyClass->classLoader);
        if (bugvmIsInstanceOf(env, result, type)) {
            returnValue->l = (jobject) result;
            return;
        }
        bugvmThrowClassCastException(env, type, result->clazz);
        return;
    }

    // Must be primitive. Cannot be NULL.
    if (!result) {
        bugvmThrowNullPointerException(env);
        return;
    }

    // Unwrap primitive.
    Class* type = bugvmFindClassByDescriptor(env, returnTypeDesc, NULL);
    switch (type->name[0]) {
    case 'Z':
        if (result->clazz == java_lang_Boolean) {
            returnValue->z = ((Boolean*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Boolean, result->clazz);
        break;
    case 'B':
        if (result->clazz == java_lang_Byte) {
            returnValue->b = ((Byte*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Byte, result->clazz);
        break;
    case 'S':
        if (result->clazz == java_lang_Short) {
            returnValue->s = ((Short*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Short, result->clazz);
        break;
    case 'C':
        if (result->clazz == java_lang_Character) {
            returnValue->c = ((Character*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Character, result->clazz);
        break;
    case 'I':
        if (result->clazz == java_lang_Integer) {
            returnValue->i = ((Integer*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Integer, result->clazz);
        break;
    case 'J':
        if (result->clazz == java_lang_Long) {
            returnValue->j = ((Long*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Long, result->clazz);
        break;
    case 'F':
        if (result->clazz == java_lang_Float) {
            returnValue->f = ((Float*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Float, result->clazz);
        break;
    case 'D':
        if (result->clazz == java_lang_Double) {
            returnValue->d = ((Double*) result)->value;
            return;
        }
        bugvmThrowClassCastException(env, java_lang_Double, result->clazz);
        break;
    }
}

Class* Java_java_lang_reflect_Proxy_generateProxy(Env* env, Class* java_lang_reflect_Proxy, 
      Object* name, ObjectArray* interfaces, Object* loader) {

    char* cname = bugvmGetStringUTFChars(env, name);
    if (!cname) return NULL;

    return bugvmProxyCreateProxyClass(env, java_lang_reflect_Proxy, loader, cname, interfaces->length, (Class**) interfaces->values,
                java_lang_reflect_Proxy->instanceDataSize, java_lang_reflect_Proxy->instanceDataOffset, 0, handler);
}
