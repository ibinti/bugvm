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

import java.io.File;

import org.gradle.api.GradleException;
import com.bugvm.compiler.AppCompiler;
import com.bugvm.compiler.config.Arch;
import com.bugvm.compiler.config.Config;
import com.bugvm.compiler.config.OS;
import com.bugvm.compiler.target.ios.DeviceType;
import com.bugvm.compiler.target.ios.IOSSimulatorLaunchParameters;
import com.bugvm.compiler.target.ios.IOSTarget;

/**
 *
 * @author Junji Takakura
 */
abstract public class AbstractIOSSimulatorTask extends AbstractBugVMTask {

    protected void launch(DeviceType type) {
        try {
            AppCompiler compiler = build(OS.ios, getArch(), IOSTarget.TYPE);

            if (extension.isSkipLaunch()) {
                return;
            }

            Config config = compiler.getConfig();
            IOSSimulatorLaunchParameters launchParameters = (IOSSimulatorLaunchParameters) config.getTarget().createLaunchParameters();
            launchParameters.setDeviceType(type);

            if (extension.getStdoutFifo() != null) {
                File stdoutFifo = new File(extension.getStdoutFifo());
                boolean isWritable;

                if (stdoutFifo.exists()) {
                    isWritable = stdoutFifo.isFile() && stdoutFifo.canWrite();
                } else {
                    File parent = stdoutFifo.getParentFile();
                    isWritable = parent != null && parent.isDirectory() && parent.canWrite();
                }

                if (!isWritable) {
                    throw new GradleException("Unwritable 'stdoutFifo' specified for BugVM compile: " + stdoutFifo);
                }

                launchParameters.setStdoutFifo(stdoutFifo);
            }

            if (extension.getStderrFifo() != null) {
                File stderrFifo = new File(extension.getStderrFifo());
                boolean isWritable;

                if (stderrFifo.exists()) {
                    isWritable = stderrFifo.isFile() && stderrFifo.canWrite();
                } else {
                    File parent = stderrFifo.getParentFile();
                    isWritable = parent != null && parent.isDirectory() && parent.canWrite();
                }

                if (!isWritable) {
                    throw new GradleException("Unwritable 'stderrFifo' specified for BugVM compile: " + stderrFifo);
                }

                launchParameters.setStderrFifo(stderrFifo);
            }

            compiler.launch(launchParameters);
        } catch (Throwable t) {
            throw new GradleException("Failed to launch IOS Simulator", t);
        }
    }

    protected Arch getArch() {
        Arch arch = Arch.x86_64;
        if (extension.getArch() != null && extension.getArch().equals(Arch.x86.toString())) {
            arch = Arch.x86;
        }
        return arch;
    }

    protected DeviceType getDeviceType(DeviceType.DeviceFamily family) {
        String deviceName = (String) project.getProperties().get("bugvm.device.name");
        String sdkVersion = (String) project.getProperties().get("bugvm.sdk.version");
        return DeviceType.getBestDeviceType(getArch(), family, deviceName, sdkVersion);
    }
}
