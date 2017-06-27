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
package com.bugvm.gradle;

/**
 * Gradle plugin that extends the Java plugin for RoboVM development.
 *
 * @author Junji Takakura
 */
public class BugVMPlugin implements org.gradle.api.Plugin<org.gradle.api.Project> {

    public static String getBugVMVersion() {

        Class clazz = BugVMPlugin.class;
        String className = clazz.getSimpleName() + ".class";
        String classPath = clazz.getResource(className).toString();
        String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) +
                "/META-INF/MANIFEST.MF";
        java.util.jar.Manifest manifest = null;
        try {
            manifest = new java.util.jar.Manifest(new java.net.URL(manifestPath).openStream());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        java.util.jar.Attributes attr = manifest.getMainAttributes();

        return  attr.getValue("Implementation-Version");

    }

    @Override
    public void apply(org.gradle.api.Project project) {
        project.getExtensions().create(BugVMPluginExtension.NAME, BugVMPluginExtension.class, project);
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.IPhoneSimulatorTask.class), "launchIPhoneSimulator");
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.IPadSimulatorTask.class), "launchIPadSimulator");
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.IOSDeviceTask.class), "launchIOSDevice");
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.ConsoleTask.class), "launchConsole");
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.CreateTask.class), "createIPA");
        project.task(java.util.Collections.singletonMap("type", com.bugvm.gradle.tasks.InstallTask.class), "bugvmInstall");
    }
}
