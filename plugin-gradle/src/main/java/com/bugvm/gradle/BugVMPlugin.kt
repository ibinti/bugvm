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

import java.io.IOException
import java.net.URL
import java.util.Collections
import java.util.jar.Attributes
import java.util.jar.Manifest

import org.gradle.api.Plugin
import org.gradle.api.Project

import com.bugvm.gradle.tasks.CreateTask
import com.bugvm.gradle.tasks.ConsoleTask
import com.bugvm.gradle.tasks.IOSDeviceTask
import com.bugvm.gradle.tasks.IPadSimulatorTask
import com.bugvm.gradle.tasks.IPhoneSimulatorTask
import com.bugvm.gradle.tasks.InstallTask

/**
 * Gradle plugin that extends the Java plugin for RoboVM development.

 * @author Junji Takakura
 */
class BugVMPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create(BugVMPluginExtension.NAME, BugVMPluginExtension::class.java, project)
        project.task(Collections.singletonMap("type", IPhoneSimulatorTask::class.java), "launchIPhoneSimulator")
        project.task(Collections.singletonMap("type", IPadSimulatorTask::class.java), "launchIPadSimulator")
        project.task(Collections.singletonMap("type", IOSDeviceTask::class.java), "launchIOSDevice")
        project.task(Collections.singletonMap("type", ConsoleTask::class.java), "launchConsole")
        project.task(Collections.singletonMap("type", CreateTask::class.java), "createIPA")
        project.task(Collections.singletonMap("type", InstallTask::class.java), "bugvmInstall")
    }

    companion object {

        val bugVMVersion: String
            get() {

                val clazz = BugVMPlugin::class.java
                val className = clazz.simpleName + ".class"
                val classPath = clazz.getResource(className).toString()
                val manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF"
                var manifest: Manifest? = null
                try {
                    manifest = Manifest(URL(manifestPath).openStream())
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                val attr = manifest!!.mainAttributes

                return attr.getValue("Implementation-Version")

            }
    }
}
