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
#ifndef BUGVM_MONITOR_H
#define BUGVM_MONITOR_H

jboolean bugvmInitMonitors(Env* env);
Monitor* bugvmCreateMonitor(Env* env, Object* obj);
Object* bugvmGetMonitorObject(Monitor* mon);
Thread* bugvmGetObjectLockHolder(Env* env, Object* obj);
jboolean bugvmHoldsLock(Env* env, Thread* thread, Object* obj);
void bugvmLockObject(Env* env, Object* obj);
jboolean bugvmUnlockObject(Env* env, Object* obj);
void bugvmObjectWait(Env* env, Object* obj, jlong msec, jint nsec, jboolean interruptShouldThrow);
void bugvmObjectNotify(Env* env, Object* obj);
void bugvmObjectNotifyAll(Env* env, Object* obj);
void bugvmThreadSleep(Env* env, jlong msec, jint nsec);
void bugvmThreadInterrupt(Env* env, Thread* thread);

#endif
