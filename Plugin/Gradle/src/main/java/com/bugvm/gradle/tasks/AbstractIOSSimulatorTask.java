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
package com.bugvm.gradle.tasks;

/**
 *
 * @author Junji Takakura
 */
abstract public class AbstractIOSSimulatorTask extends AbstractBugVMTask {

    protected void launch(com.bugvm.compiler.target.ios.DeviceType type) {
        try {
            com.bugvm.compiler.AppCompiler compiler = build(com.bugvm.compiler.config.OS.ios, getArch(),  com.bugvm.compiler.target.ios.IOSTarget.TYPE);

            if (extension.isSkipLaunch()) {
                return;
            }

            com.bugvm.compiler.config.Config config = compiler.getConfig();
            com.bugvm.compiler.target.ios.IOSSimulatorLaunchParameters launchParameters = ( com.bugvm.compiler.target.ios.IOSSimulatorLaunchParameters) config.getTarget().createLaunchParameters();
            launchParameters.setDeviceType(type);

            if (extension.getStdoutFifo() != null) {
                java.io.File stdoutFifo = new java.io.File(extension.getStdoutFifo());
                boolean isWritable;

                if (stdoutFifo.exists()) {
                    isWritable = stdoutFifo.isFile() && stdoutFifo.canWrite();
                } else {
                    java.io.File parent = stdoutFifo.getParentFile();
                    isWritable = parent != null && parent.isDirectory() && parent.canWrite();
                }

                if (!isWritable) {
                    throw new org.gradle.api.GradleException("Unwritable 'stdoutFifo' specified for BugVM compile: " + stdoutFifo);
                }

                launchParameters.setStdoutFifo(stdoutFifo);
            }

            if (extension.getStderrFifo() != null) {
                java.io.File stderrFifo = new java.io.File(extension.getStderrFifo());
                boolean isWritable;

                if (stderrFifo.exists()) {
                    isWritable = stderrFifo.isFile() && stderrFifo.canWrite();
                } else {
                    java.io.File parent = stderrFifo.getParentFile();
                    isWritable = parent != null && parent.isDirectory() && parent.canWrite();
                }

                if (!isWritable) {
                    throw new org.gradle.api.GradleException("Unwritable 'stderrFifo' specified for BugVM compile: " + stderrFifo);
                }

                launchParameters.setStderrFifo(stderrFifo);
            }

            compiler.launch(launchParameters);
        } catch (Throwable t) {
            throw new org.gradle.api.GradleException("Failed to launch IOS Simulator", t);
        }
    }

    protected com.bugvm.compiler.config.Arch getArch() {
        com.bugvm.compiler.config.Arch arch = com.bugvm.compiler.config.Arch.x86_64;
        if (extension.getArch() != null && extension.getArch().equals(com.bugvm.compiler.config.Arch.x86.toString())) {
            arch = com.bugvm.compiler.config.Arch.x86;
        }
        return arch;
    }

    protected com.bugvm.compiler.target.ios.DeviceType getDeviceType(com.bugvm.compiler.target.ios.DeviceType.DeviceFamily family) {
        String deviceName = (String) project.getProperties().get("bugvm.device.name");
        String sdkVersion = (String) project.getProperties().get("bugvm.sdk.version");
        return com.bugvm.compiler.target.ios.DeviceType.getBestDeviceType(getArch(), family, deviceName, sdkVersion);
    }
}