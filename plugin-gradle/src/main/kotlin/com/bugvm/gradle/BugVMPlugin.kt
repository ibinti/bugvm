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
package com.bugvm.gradle

/**
 * Gradle plugin that extends the Java plugin for BugVM development.
 * @author Junji Takakura
 */
class BugVMPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {

    override fun apply(project: org.gradle.api.Project) {
        project.extensions.create(BugVMPluginExtension.NAME, BugVMPluginExtension::class.java, project)
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.IPhoneSimulatorTask::class.java), "launchIPhoneSimulator")
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.IPadSimulatorTask::class.java), "launchIPadSimulator")
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.IOSDeviceTask::class.java), "launchIOSDevice")
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.ConsoleTask::class.java), "launchConsole")
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.CreateTask::class.java), "createIPA")
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.InstallTask::class.java), "bugvmInstall")
    }

    companion object {

        val bugVMVersion: String
            get() {

                val clazz = BugVMPlugin::class.java
                val className = clazz.simpleName + ".class"
                val classPath = clazz.getResource(className).toString()
                val manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF"
                var manifest: java.util.jar.Manifest? = null
                try {
                    manifest = java.util.jar.Manifest(java.net.URL(manifestPath).openStream())
                } catch (e: java.io.IOException) {
                    e.printStackTrace()
                }

                val attr = manifest!!.mainAttributes

                return attr.getValue("Implementation-Version")

            }
    }
}