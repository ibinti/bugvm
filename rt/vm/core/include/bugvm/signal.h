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
#ifndef BUGVM_SIGNAL_H
#define BUGVM_SIGNAL_H

extern jboolean bugvmInitSignals(Env* env);
extern jboolean bugvmInstallThreadSignalMask(Env* env);
extern jboolean bugvmRestoreThreadSignalMask(Env* env);
extern jboolean bugvmInstallChainingSignals(Env* env);
extern jboolean bugvmReinstallSavedSignals(Env* env, void* state);
extern void* bugvmSaveSignals(Env* env);

#endif
