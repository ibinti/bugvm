/*
 * Copyright (C) 2015 RoboVM AB.
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
package com.bugvm.gradle.tasks

class ConsoleTask : AbstractBugVMTask() {

    override fun invoke() {
        try {
            var arch = com.bugvm.compiler.config.Arch.getDefaultArch()
            if (extension.arch != null) {
                arch = com.bugvm.compiler.config.Arch.valueOf(extension.arch!!)
            }

            val compiler = build(com.bugvm.compiler.config.OS.getDefaultOS(), arch, com.bugvm.compiler.target.ConsoleTarget.TYPE)
            val config = compiler.config
            val launchParameters = config.target.createLaunchParameters()
            compiler.launch(launchParameters)


        } catch (t: Throwable) {
            throw org.gradle.api.GradleException("Failed to launch console application", t)
        }

    }
}