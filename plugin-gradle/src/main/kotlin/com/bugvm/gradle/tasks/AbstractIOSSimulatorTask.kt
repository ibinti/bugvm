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
abstract class AbstractIOSSimulatorTask : AbstractBugVMTask() {

    protected fun launch(type: com.bugvm.compiler.target.ios.DeviceType) {
        try {
            val compiler = build(com.bugvm.compiler.config.OS.ios, arch, com.bugvm.compiler.target.ios.IOSTarget.TYPE)

            if (extension.isSkipLaunch) {
                return
            }

            val config = compiler.config
            val launchParameters = config.target.createLaunchParameters() as com.bugvm.compiler.target.ios.IOSSimulatorLaunchParameters
            launchParameters.deviceType = type

            if (extension.stdoutFifo != null) {
                val stdoutFifo = java.io.File(extension.stdoutFifo)
                val isWritable: Boolean

                if (stdoutFifo.exists()) {
                    isWritable = stdoutFifo.isFile && stdoutFifo.canWrite()
                } else {
                    val parent = stdoutFifo.parentFile
                    isWritable = parent != null && parent.isDirectory && parent.canWrite()
                }

                if (!isWritable) {
                    throw org.gradle.api.GradleException("Unwritable 'stdoutFifo' specified for BugVM compile: " + stdoutFifo)
                }

                launchParameters.stdoutFifo = stdoutFifo
            }

            if (extension.stderrFifo != null) {
                val stderrFifo = java.io.File(extension.stderrFifo)
                val isWritable: Boolean

                if (stderrFifo.exists()) {
                    isWritable = stderrFifo.isFile && stderrFifo.canWrite()
                } else {
                    val parent = stderrFifo.parentFile
                    isWritable = parent != null && parent.isDirectory && parent.canWrite()
                }

                if (!isWritable) {
                    throw org.gradle.api.GradleException("Unwritable 'stderrFifo' specified for BugVM compile: " + stderrFifo)
                }

                launchParameters.stderrFifo = stderrFifo
            }

            compiler.launch(launchParameters)
        } catch (t: Throwable) {
            throw org.gradle.api.GradleException("Failed to launch IOS Simulator", t)
        }

    }

    protected val arch: com.bugvm.compiler.config.Arch
        get() {
            var arch = com.bugvm.compiler.config.Arch.x86_64
            if (extension.arch != null && extension.arch == com.bugvm.compiler.config.Arch.x86.toString()) {
                arch = com.bugvm.compiler.config.Arch.x86
            }
            return arch
        }

    protected fun getDeviceType(family: com.bugvm.compiler.target.ios.DeviceType.DeviceFamily): com.bugvm.compiler.target.ios.DeviceType {
        val deviceName = bugvmProject.properties["bugvm.device.name"] as String
        val sdkVersion = bugvmProject.properties["bugvm.sdk.version"] as String
        return com.bugvm.compiler.target.ios.DeviceType.getBestDeviceType(arch, family, deviceName, sdkVersion)
    }
}