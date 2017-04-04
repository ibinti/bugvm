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
#ifndef BUGVM_INIT_H
#define BUGVM_INIT_H

extern Object* systemClassLoader;

extern void bugvmParseOption(char* arg, Options* options);
extern jboolean bugvmInitOptions(int argc, char* argv[], Options* options, jboolean ignoreRvmArgs);
extern Env* bugvmStartup(Options* options);
extern VM* bugvmCreateVM(Options* options);
extern Env* bugvmCreateEnv(VM* vm);
extern jboolean bugvmRun(Env* env);
extern jboolean bugvmDestroyVM(VM* vm);
extern void bugvmShutdown(Env* env, jint code);
extern void bugvmAbort(char* format, ...);

extern DynamicLib* bugvmOpenDynamicLib(Env* env, const char* file, char** errorMsg);
extern void bugvmCloseDynamicLib(Env* env, DynamicLib* lib);
extern jboolean bugvmHasDynamicLib(Env* env, DynamicLib* lib, DynamicLib* libs);
extern void bugvmAddDynamicLib(Env* env, DynamicLib* lib, DynamicLib** libs);
extern void* bugvmFindDynamicLibSymbol(Env* env, DynamicLib* first, const char* symbol, jboolean searchAll);

#endif

