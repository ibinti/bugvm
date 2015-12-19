/*
 * Copyright (C) 2015 RoboVM AB
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */
package com.bugvm.idea.running;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.process.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.util.ReflectionUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.bugvm.compiler.AppCompiler;
import com.bugvm.compiler.config.Config;
import com.bugvm.compiler.config.OS;
import com.bugvm.compiler.target.LaunchParameters;
import com.bugvm.compiler.target.ios.DeviceType;
import com.bugvm.compiler.target.ios.IOSSimulatorLaunchParameters;
import com.bugvm.compiler.util.io.Fifos;
import com.bugvm.compiler.util.io.OpenOnReadFileInputStream;
import com.bugvm.idea.BugVmPlugin;

import java.io.*;

public class BugVmRunProfileState extends CommandLineState {
    public BugVmRunProfileState(ExecutionEnvironment environment) {
        super(environment);
    }

    protected ProcessHandler executeRun() throws Throwable {
        BugVmRunConfiguration runConfig = (BugVmRunConfiguration)getEnvironment().getRunnerAndConfigurationSettings().getConfiguration();
        Config config = runConfig.getConfig();
        AppCompiler compiler = runConfig.getCompiler();
        BugVmPlugin.logInfo(getEnvironment().getProject(), "Launching executable");
        String mainTypeName = config.getMainClass();

        LaunchParameters launchParameters = config.getTarget().createLaunchParameters();
        customizeLaunchParameters(runConfig, config, launchParameters);
        launchParameters.setArguments(runConfig.getProgramArguments());

        // launch plugin may proxy stdout/stderr fifo, which
        // it then writes to. Need to save the original fifos
        File stdOutFifo = launchParameters.getStdoutFifo();
        File stdErrFifo = launchParameters.getStderrFifo();
        PipedInputStream pipedIn = new PipedInputStream();
        PipedOutputStream pipedOut = new PipedOutputStream(pipedIn);
        Process process = compiler.launchAsync(launchParameters, pipedIn);
        if (stdOutFifo != null || stdErrFifo != null) {
            InputStream stdoutStream = null;
            InputStream stderrStream = null;
            if (launchParameters.getStdoutFifo() != null) {
                stdoutStream = new OpenOnReadFileInputStream(stdOutFifo);
            }
            if (launchParameters.getStderrFifo() != null) {
                stderrStream = new OpenOnReadFileInputStream(stdErrFifo);
            }
            process = new ProcessProxy(process, pipedOut, stdoutStream, stderrStream, compiler);
        }
        BugVmPlugin.logInfo(getEnvironment().getProject(), "Launch done");

        final OSProcessHandler processHandler = new ColoredProcessHandler(process, null);
        ProcessTerminatedListener.attach(processHandler);
        return processHandler;
    }

    protected void customizeLaunchParameters(BugVmRunConfiguration runConfig, Config config, LaunchParameters launchParameters) throws IOException {
        launchParameters.setStdoutFifo(Fifos.mkfifo("stdout"));
        launchParameters.setStderrFifo(Fifos.mkfifo("stderr"));

        if(config.getOs() != OS.ios) {
            if(runConfig.getWorkingDir() != null && !runConfig.getWorkingDir().isEmpty()) {
                launchParameters.setWorkingDirectory(new File(runConfig.getWorkingDir()));
            }
        } else {
            if(launchParameters instanceof IOSSimulatorLaunchParameters) {
                IOSSimulatorLaunchParameters simParams = (IOSSimulatorLaunchParameters)launchParameters;
                for(DeviceType type: DeviceType.listDeviceTypes()) {
                    if (type.getDeviceName().equals(runConfig.getSimulatorName())) {
                        simParams.setDeviceType(type);
                    }
                }
            }
        }
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        try {
            if (getEnvironment().getExecutor().getId().equals(BugVmRunner.RUN_EXECUTOR)) {
                return executeRun();
            } else if (getEnvironment().getExecutor().getId().equals(BugVmRunner.DEBUG_EXECUTOR)) {
                return executeRun();
            } else {
                return null;
            }
        } catch(Throwable t) {
            BugVmPlugin.logErrorThrowable(getEnvironment().getProject(), "Couldn't start application", t, true);
            return null;
        }
    }

    private static class ProcessProxy extends Process implements SelfKiller {
        private final Process target;
        private final OutputStream outputStream;
        private final InputStream inputStream;
        private final InputStream errorStream;
        private final AppCompiler appCompiler;
        private volatile boolean cleanedUp = false;
        private int pid;

        ProcessProxy(Process target, OutputStream outputStream, InputStream inputStream, InputStream errorStream,
                     AppCompiler appCompiler) {
            this.target = target;
            this.outputStream = outputStream;
            this.inputStream = inputStream;
            this.errorStream = errorStream;
            this.appCompiler = appCompiler;
        }

        public void destroy() {
            synchronized(this) {
                if(!cleanedUp) {
                    appCompiler.launchAsyncCleanup();
                    cleanedUp = true;
                }
            }
            target.destroy();
        }

        public boolean equals(Object obj) {
            return target.equals(obj);
        }

        public int exitValue() {
            return target.exitValue();
        }

        public InputStream getErrorStream() {
            if (errorStream != null) {
                return errorStream;
            }
            return target.getErrorStream();
        }

        public InputStream getInputStream() {
            if (inputStream != null) {
                return inputStream;
            }
            return target.getInputStream();
        }

        public OutputStream getOutputStream() {
            if (outputStream != null) {
                return outputStream;
            }
            return target.getOutputStream();
        }

        public int hashCode() {
            return target.hashCode();
        }

        public String toString() {
            return target.toString();
        }

        public int waitFor() {
            try {
                return target.waitFor();
            } catch (Throwable t) {
                synchronized(this) {
                    if(!cleanedUp) {
                        appCompiler.launchAsyncCleanup();
                        cleanedUp = true;
                    }
                }
                throw new RuntimeException(t);
            }
        }
    }
}
