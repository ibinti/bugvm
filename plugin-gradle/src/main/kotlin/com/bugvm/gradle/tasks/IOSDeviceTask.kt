/*
 * Copyright (C) 2014 RoboVM AB.
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

/**
 * @author Junji Takakura
 */
class IOSDeviceTask : AbstractBugVMTask() {
    override fun invoke() {
        try {
            var arch = com.bugvm.compiler.config.Arch.thumbv7
            if (extension.arch != null && extension.arch == com.bugvm.compiler.config.Arch.arm64.toString()) {
                arch = com.bugvm.compiler.config.Arch.arm64
            }

            val compiler = build(com.bugvm.compiler.config.OS.ios, arch, com.bugvm.compiler.target.ios.IOSTarget.TYPE)
            if (extension.isSkipLaunch) {
                return
            }
            val config = compiler.config
            val launchParameters = config.target.createLaunchParameters()
            compiler.launch(launchParameters)
        } catch (t: Throwable) {
            throw org.gradle.api.GradleException("Failed to launch IOS Device", t)
        }

    }
}