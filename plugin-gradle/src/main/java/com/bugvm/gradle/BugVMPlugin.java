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

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import com.bugvm.compiler.Version;
import com.bugvm.gradle.tasks.ArchiveTask;
import com.bugvm.gradle.tasks.ConsoleTask;
import com.bugvm.gradle.tasks.IOSDeviceTask;
import com.bugvm.gradle.tasks.IPadSimulatorTask;
import com.bugvm.gradle.tasks.IPhoneSimulatorTask;
import com.bugvm.gradle.tasks.InstallTask;

/**
 * Gradle plugin that extends the Java plugin for RoboVM development.
 *
 * @author Junji Takakura
 */
public class BugVMPlugin implements Plugin<Project> {

    public static String getBugVMVersion() {

        String Version = "0.0.0";

        Class clazz = BugVMPlugin.class;
        String className = clazz.getSimpleName() + ".class";
        String classPath = clazz.getResource(className).toString();
        String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) +
                "/META-INF/MANIFEST.MF";
        Manifest manifest = null;
        try {
            manifest = new Manifest(new URL(manifestPath).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Attributes attr = manifest.getMainAttributes();
        Version = attr.getValue("Implementation-Version");

        return  Version;

    }

    @Override
    public void apply(Project project) {
        project.getExtensions().create(BugVMPluginExtension.NAME, BugVMPluginExtension.class, project);
        project.task(Collections.singletonMap("type", IPhoneSimulatorTask.class), "launchIPhoneSimulator");
        project.task(Collections.singletonMap("type", IPadSimulatorTask.class), "launchIPadSimulator");
        project.task(Collections.singletonMap("type", IOSDeviceTask.class), "launchIOSDevice");
        project.task(Collections.singletonMap("type", ConsoleTask.class), "launchConsole");
        project.task(Collections.singletonMap("type", ArchiveTask.class), "createIPA");
        project.task(Collections.singletonMap("type", ArchiveTask.class), "bugvmArchive");
        project.task(Collections.singletonMap("type", InstallTask.class), "bugvmInstall");
    }
}
