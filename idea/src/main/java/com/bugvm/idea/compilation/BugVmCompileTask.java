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
package com.bugvm.idea.compilation;

import com.intellij.compiler.options.CompileStepBeforeRun;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileTask;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.compiler.CompilerPaths;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.OrderRootsEnumerator;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.util.Computable;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.io.FileUtils;
import com.bugvm.compiler.AppCompiler;
import com.bugvm.compiler.config.Arch;
import com.bugvm.compiler.config.Config;
import com.bugvm.compiler.config.OS;
import com.bugvm.compiler.plugin.PluginArgument;
import com.bugvm.compiler.target.ConsoleTarget;
import com.bugvm.compiler.target.ios.IOSTarget;
import com.bugvm.compiler.target.ios.ProvisioningProfile;
import com.bugvm.compiler.target.ios.SigningIdentity;
import com.bugvm.idea.BugVmPlugin;
import com.bugvm.idea.actions.CreateIpaAction;
import com.bugvm.idea.running.BugVmRunConfiguration;
import com.bugvm.idea.running.BugVmIOSRunConfigurationSettingsEditor;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;

/**
 * Registered by {@link BugVmPlugin} on startup. Responsible
 * for compiling an app in case there's a run configuration in the {@link com.intellij.openapi.compiler.CompileContext}
 * or if we perform an ad-hoc/IPA build from the BugVM menu.
 */
public class BugVmCompileTask implements CompileTask {
    @Override
    public boolean execute(CompileContext context) {
        if(context.getMessageCount(CompilerMessageCategory.ERROR) > 0) {
            BugVmPlugin.logError(context.getProject(), "Can't compile application due to previous compilation errors");
            return false;
        }

        RunConfiguration c = context.getCompileScope().getUserData(CompileStepBeforeRun.RUN_CONFIGURATION);
        if(c == null || !(c instanceof BugVmRunConfiguration)) {
            CreateIpaAction.IpaConfig ipaConfig = context.getCompileScope().getUserData(CreateIpaAction.IPA_CONFIG_KEY);
            if(ipaConfig != null) {
                return compileForIpa(context, ipaConfig);
            } else {
                return true;
            }
        } else {
            return compileForRunConfiguration(context, (BugVmRunConfiguration)c);
        }
    }

    private boolean compileForIpa(CompileContext context, final CreateIpaAction.IpaConfig ipaConfig) {
        try {
            ProgressIndicator progress = context.getProgressIndicator();
            context.getProgressIndicator().pushState();
            BugVmPlugin.focusToolWindow(context.getProject());
            progress.setText("Creating IPA");

            BugVmPlugin.logInfo(context.getProject(), "Creating package in " + ipaConfig.getDestinationDir().getAbsolutePath() + " ...");

            Config.Builder builder = new Config.Builder();
            builder.logger(BugVmPlugin.getLogger(context.getProject()));
            File moduleBaseDir = new File(ModuleRootManager.getInstance(ipaConfig.getModule()).getContentRoots()[0].getPath());

            // load the bugvm.xml file
            loadConfig(context.getProject(), builder, moduleBaseDir, false);
            builder.os(OS.ios);
            builder.archs(ipaConfig.getArchs());
            builder.installDir(ipaConfig.getDestinationDir());
            builder.iosSignIdentity(SigningIdentity.find(SigningIdentity.list(), ipaConfig.getSigningIdentity()));
            if (ipaConfig.getProvisioningProfile() != null) {
                builder.iosProvisioningProfile(ProvisioningProfile.find(ProvisioningProfile.list(), ipaConfig.getProvisioningProfile()));
            }
            configureClassAndSourcepaths(context, builder, ipaConfig.getModule());
            builder.home(BugVmPlugin.getBugVmHome());
            Config config = builder.build();

            progress.setFraction(0.5);

            AppCompiler compiler = new AppCompiler(config);
            BugVmCompilerThread thread = new BugVmCompilerThread(compiler, progress) {
                protected void doCompile() throws Exception {
                    compiler.build();
                    compiler.archive();
                }
            };
            thread.compile();

            if(progress.isCanceled()) {
                BugVmPlugin.logInfo(context.getProject(), "Build canceled");
                return false;
            }

            progress.setFraction(1);
            BugVmPlugin.logInfo(context.getProject(), "Package successfully created in " + ipaConfig.getDestinationDir().getAbsolutePath());
        } catch(Throwable t) {
            BugVmPlugin.logErrorThrowable(context.getProject(), "Couldn't create IPA", t, false);
            return false;
        } finally {
            context.getProgressIndicator().popState();
        }
        return true;
    }

    private boolean compileForRunConfiguration(CompileContext context, final BugVmRunConfiguration runConfig) {
        try {
            ProgressIndicator progress = context.getProgressIndicator();
            context.getProgressIndicator().pushState();
            BugVmPlugin.focusToolWindow(context.getProject());
            progress.setText("Compiling BugVM app");

            Config.Builder builder = new Config.Builder();
            builder.logger(BugVmPlugin.getLogger(context.getProject()));

            // get the module we are about to compile
            ModuleManager moduleManager = ModuleManager.getInstance(runConfig.getProject());
            Module module = ApplicationManager.getApplication().runReadAction(new Computable<Module>() {
                @Override
                public Module compute() {
                    return ModuleManager.getInstance(runConfig.getProject()).findModuleByName(runConfig.getModuleName());
                }
            });
            if(module == null) {
                BugVmPlugin.logBalloon(context.getProject(), MessageType.ERROR, "Couldn't find Module '" + runConfig.getModuleName() + "'");
                return false;
            }
            File moduleBaseDir = new File(ModuleRootManager.getInstance(module).getContentRoots()[0].getPath());

            // load the bugvm.xml file
            loadConfig(context.getProject(), builder, moduleBaseDir, false);

            // set OS and arch
            OS os = null;
            Arch arch = null;
            if(runConfig.getTargetType() == BugVmRunConfiguration.TargetType.Device) {
                os = OS.ios;
                arch = runConfig.getDeviceArch();
            } else if(runConfig.getTargetType() == BugVmRunConfiguration.TargetType.Simulator) {
                os = OS.ios;
                arch = runConfig.getSimArch();
            } else {
                os = OS.getDefaultOS();
                arch = Arch.getDefaultArch();
            }
            builder.os(os);
            builder.arch(arch);

            // set the plugin args
            List<String> args = splitArgs(runConfig.getArguments());
            applyPluginArguments(args, builder);

            // set build dir and install dir, pattern
            // module-basedir/bugvm-build/tmp/module-name/runconfig-name/os/arch.
            // module-basedir/bugvm-build/app/module-name/runconfig-name/os/arch.
            File buildDir = BugVmPlugin.getModuleBuildDir(module, runConfig.getName(), os, arch);
            builder.tmpDir(buildDir);
            builder.skipInstall(true);
            BugVmPlugin.logInfo(context.getProject(), "Building executable in %s", buildDir.getAbsolutePath());
            BugVmPlugin.logInfo(context.getProject(), "Installation of app in %s", buildDir.getAbsolutePath());

            // setup classpath entries, debug build parameters and target
            // parameters, e.g. signing identity etc.
            configureClassAndSourcepaths(context, builder, module);
            configureDebugging(builder, runConfig, module);
            configureTarget(builder, runConfig);

            // clean build dir
            BugVmPlugin.logInfo(context.getProject(), "Cleaning output dir " + buildDir.getAbsolutePath());
            FileUtils.deleteDirectory(buildDir);
            buildDir.mkdirs();

            // Set the Home to be used, create the Config and AppCompiler
            Config.Home home = BugVmPlugin.getBugVmHome();
            if(home.isDev()) {
                builder.useDebugLibs(true);
                builder.dumpIntermediates(true);
                builder.addPluginArgument("debug:logconsole=true");
            }
            builder.home(home);
            Config config = builder.build();
            AppCompiler compiler = new AppCompiler(config);
            if(progress.isCanceled()) {
                BugVmPlugin.logInfo(context.getProject(), "Build canceled");
                return false;
            }
            progress.setFraction(0.5);

            // Start the build in a separate thread, check if
            // user canceled it.
            BugVmCompilerThread thread = new BugVmCompilerThread(compiler, progress);
            thread.compile();
            if(progress.isCanceled()) {
                BugVmPlugin.logInfo(context.getProject(), "Build canceled");
                return false;
            }
            BugVmPlugin.logInfo(context.getProject(), "Build done");

            // set the config and compiler on the run configuration so
            // it knows where to find things.
            runConfig.setConfig(config);
            runConfig.setCompiler(compiler);
            runConfig.setProgramArguments(args);
        } catch(Throwable t) {
            BugVmPlugin.logErrorThrowable(context.getProject(), "Couldn't compile app", t, false);
            return false;
        } finally {
            context.getProgressIndicator().popState();
        }
        return true;
    }

    private void configureClassAndSourcepaths(CompileContext context, Config.Builder builder, Module module) {
        // gather the boot and user classpaths. BugVM RT libs may be
        // specified in a Maven/Gradle build file, in which case they'll
        // turn up as order entries. We filter them out here.
        // FIXME junit needs to include test classes
        OrderEnumerator classes = ModuleRootManager.getInstance(module).orderEntries().recursively().withoutSdk().compileOnly().productionOnly();
        Set<File> classPaths = new HashSet<File>();
        Set<File> bootClassPaths = new HashSet<File>();
        for(String path: classes.getPathsList().getPathList()) {
            if(!BugVmPlugin.isSdkLibrary(path)) {
                classPaths.add(new File(path));
            }
        }

        // add the output dirs of all affected modules to the
        // classpath. IDEA will make the output directory
        // of a module an order entry after the first compile
        // so we add the path twice. Fixed by using a set.
        // FIXME junit needs to include test output directories
        for(Module mod: context.getCompileScope().getAffectedModules()) {
            String path = CompilerPaths.getModuleOutputPath(mod, false);
            if(path != null && !path.isEmpty()) {
                classPaths.add(new File(path));
            } else {
                BugVmPlugin.logWarn(context.getProject(), "Output path of module %s not defined", mod.getName());
            }
        }

        // set the user classpath entries
        for(File path: classPaths) {
            BugVmPlugin.logInfo(context.getProject(), "classpath entry: %s", path.getAbsolutePath());
            builder.addClasspathEntry(path);
        }

        // Use the RT from the SDK
        BugVmPlugin.logInfo(context.getProject(), "Using SDK boot classpath");
        for(File path: BugVmPlugin.getSdkLibrariesWithoutSources()) {
            if(BugVmPlugin.isBootClasspathLibrary(path)) {
                builder.addBootClasspathEntry(path);
            } else {
                builder.addClasspathEntry(path);
            }
        }
    }

    private void configureDebugging(Config.Builder builder, BugVmRunConfiguration runConfig, Module module) {
        // setup debug configuration if necessary
        if(runConfig.isDebug()) {
            Set<String> sourcesPaths = new HashSet<String>();

            // source paths of dependencies and modules
            OrderRootsEnumerator sources = ModuleRootManager.getInstance(module).orderEntries().recursively().withoutSdk().sources();
            for (String path : sources.getPathsList().getPathList()) {
                BugVmPlugin.logInfo(module.getProject(), "source path entry: %s", path);
                sourcesPaths.add(path);
            }

            StringBuilder b = new StringBuilder();
            // SDK sourcepaths
            for(File path: BugVmPlugin.getSdkLibrarySources()) {
                b.append(path.getAbsolutePath());
                b.append(":");
            }

            for(String path: sourcesPaths) {
                b.append(path);
                b.append(":");
            }

            // set arguments for debug plugin
            runConfig.setDebugPort(findFreePort());
            builder.debug(true);
            builder.addPluginArgument("debug:sourcepath=" + b.toString());
            builder.addPluginArgument("debug:jdwpport=" + runConfig.getDebugPort());
            builder.addPluginArgument("debug:clientmode=true");
            builder.addPluginArgument("debug:logdir=" + BugVmPlugin.getModuleLogDir(module).getAbsolutePath());
        }
    }

    private void configureTarget(Config.Builder builder, BugVmRunConfiguration runConfig) {
        if(runConfig.getTargetType() == BugVmRunConfiguration.TargetType.Device) {
            // configure device build
            builder.targetType(IOSTarget.TYPE);
            String signingId = runConfig.getSigningIdentity();
            String profile = runConfig.getProvisioningProfile();
            if (BugVmIOSRunConfigurationSettingsEditor.SKIP_SIGNING.equals(signingId)) {
                builder.iosSkipSigning(true);
            } else {
                if (signingId != null && !BugVmIOSRunConfigurationSettingsEditor.AUTO_SIGNING_IDENTITY.equals(signingId)) {
                    builder.iosSignIdentity(SigningIdentity.find(SigningIdentity.list(), signingId));
                }
                if (profile != null && !BugVmIOSRunConfigurationSettingsEditor.AUTO_PROVISIONING_PROFILE.equals(profile)) {
                    builder.iosProvisioningProfile(ProvisioningProfile.find(ProvisioningProfile.list(), profile));
                }
            }
        } else if(runConfig.getTargetType() == BugVmRunConfiguration.TargetType.Simulator) {
            builder.targetType(IOSTarget.TYPE);
        } else if(runConfig.getTargetType() == BugVmRunConfiguration.TargetType.Console) {
            builder.targetType(ConsoleTarget.TYPE);
        } else {
            throw new RuntimeException("Unsupported target type: " + runConfig.getTargetType());
        }
    }

    public static Config.Builder loadConfig(Project project, Config.Builder configBuilder, File projectRoot, boolean isTest) {
        try {
            configBuilder.readProjectProperties(projectRoot, isTest);
            configBuilder.readProjectConfig(projectRoot, isTest);
        } catch (IOException e) {
            BugVmPlugin.logErrorThrowable(project, "Couldn't load bugvm.xml", e, true);
            throw new RuntimeException(e);
        }

        // Ignore classpath entries in config XML file.
        configBuilder.clearBootClasspathEntries();
        configBuilder.clearClasspathEntries();

        return configBuilder;
    }

    public int findFreePort()
    {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(0);
            return socket.getLocalPort();
        } catch (IOException localIOException2) {
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException localIOException4) {
                }
            }
        }
        return -1;
    }

    private static String unquoteArg(String arg) {
        if (arg.startsWith("\"") && arg.endsWith("\"")) {
            return arg.substring(1, arg.length() - 1);
        }
        return arg;
    }

    public static List<String> splitArgs(String args) {
        if (args == null || args.trim().length() == 0) {
            return new ArrayList<String>();
        }
        String[] parts = CommandLine.parse("foo " + args).toStrings();
        if (parts.length <= 1) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<String>(parts.length - 1);
        for (int i = 1; i < parts.length; i++) {
            result.add(unquoteArg(parts[i]));
        }
        return result;
    }

    /**
     * Filters any plugin arguments and sets them on the provided builder
     * @param args
     * @param configBuilder builder or null to filter the args list
     */
    public static void applyPluginArguments(List<String> args, Config.Builder configBuilder) {
        Map<String, PluginArgument> pluginArguments = configBuilder.fetchPluginArguments();
        Iterator<String> iter = args.iterator();
        while (iter.hasNext()) {
            String arg = iter.next();
            if (!arg.startsWith("-rvm") && arg.startsWith("-")) {
                String argName = arg.substring(1);
                if (argName.contains("=")) {
                    argName = argName.substring(0, argName.indexOf('='));
                }
                PluginArgument pluginArg = pluginArguments.get(argName);
                if (pluginArg != null) {
                    if(configBuilder != null) {
                        configBuilder.addPluginArgument(arg.substring(1));
                        iter.remove();
                    }
                }
            }
        }
    }
}
