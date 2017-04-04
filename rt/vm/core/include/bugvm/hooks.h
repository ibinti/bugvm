/*
 * Copyright (C) 2014 RoboVM AB
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
#ifndef BUGVM_HOOKS_H
#define BUGVM_HOOKS_H

void _bugvmHookBeforeAppEntryPoint(Env* env, char* mainClass);
void _bugvmHookBeforeMainThreadAttached(Env* env);
void _bugvmHookThreadCreated(Env* env, Object* threadObj);
void _bugvmHookThreadAttached(Env* env, Object* threadObj, Thread* thread);
void _bugvmHookThreadStarting(Env* env, Object* threadObj, Thread* thread);
void _bugvmHookThreadDetaching(Env* env, Object* threadObj, Thread* thread, Object* throwable);
void _bugvmHookClassLoaded(Env* env, Class* clazz, void* classInfo);
void _bugvmHookExceptionRaised(Env* env, Object* throwable, jboolean isCaught);
jboolean _bugvmHookSetupTCPChannel(Options* options);
jboolean _bugvmHookHandshake(Options* options);
void _bugvmHookInstrumented(DebugEnv* debugEnv, jint lineNumber, jint lineNumberOffset, jbyte* bptable, void* pc);

void bugvmHookWaitForAttach(Options* options);
void bugvmHookDebuggerAttached(Options* options);
static inline void bugvmHookBeforeAppEntryPoint(Env* env, char* mainClass) {
    if (env->vm->options->enableHooks) {
        _bugvmHookBeforeAppEntryPoint(env, mainClass);
    }
}
static inline void bugvmHookBeforeMainThreadAttached(Env* env) {
    if (env->vm->options->enableHooks) {
        _bugvmHookBeforeMainThreadAttached(env);
    }
}
static inline void bugvmHookThreadCreated(Env* env, Object* threadObj) {
    if (env->vm->options->enableHooks) {
        _bugvmHookThreadCreated(env, threadObj);
    }
}
static inline void bugvmHookThreadAttached(Env* env, Object* threadObj, Thread* thread) {
    if (env->vm->options->enableHooks) {
        _bugvmHookThreadAttached(env, threadObj, thread);
    }
}
static inline void bugvmHookThreadStarting(Env* env, Object* threadObj, Thread* thread) {
    if (env->vm->options->enableHooks) {
        _bugvmHookThreadStarting(env, threadObj, thread);
    }
}
static inline void bugvmHookThreadDetaching(Env* env, Object* threadObj, Thread* thread, Object* throwable) {
    if (env->vm->options->enableHooks) {
        _bugvmHookThreadDetaching(env, threadObj, thread, throwable);
    }
}
static inline void bugvmHookClassLoaded(Env* env, Class* clazz, void* classInfo) {
    if (env->vm->options->enableHooks) {
        _bugvmHookClassLoaded(env, clazz, classInfo);
    }
}
static inline void bugvmHookExceptionRaised(Env* env, Object* throwable, jboolean isCaught) {
    if(env->vm->options->enableHooks) {
        _bugvmHookExceptionRaised(env, throwable, isCaught);
    }
}
static inline jboolean bugvmHookSetupTCPChannel(Options* options) {
    if(options->enableHooks) {
        return _bugvmHookSetupTCPChannel(options);
    } else {
        return TRUE;
    }
}
static inline jboolean bugvmHookHandshake(Options* options) {
    if(options->enableHooks) {
        return _bugvmHookHandshake(options);
    } else {
        return FALSE;
    }
}

static inline void bugvmHookInstrumented(DebugEnv* env, jint lineNumber, jint lineNumberOffset, jbyte* bptable, void* pc) {
    if (env->env.vm->options->enableHooks) {
        _bugvmHookInstrumented(env, lineNumber, lineNumberOffset, bptable, pc);
    }
}

#endif
