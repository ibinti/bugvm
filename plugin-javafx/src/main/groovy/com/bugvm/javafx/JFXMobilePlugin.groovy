package com.bugvm.javafx

import com.android.build.gradle.internal.dsl.SigningConfig
import com.android.builder.core.BuilderConstants
import com.android.ide.common.res2.AssetSet
import com.android.ide.common.res2.ResourceSet
import com.android.sdklib.repository.FullRevision
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.Dependency
import org.gradle.api.plugins.ApplicationPlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.Sync
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.internal.reflect.Instantiator
import com.bugvm.javafx.android.task.AndroidTask
import com.bugvm.javafx.android.task.Apk
import com.bugvm.javafx.android.task.CreateMainDexList
import com.bugvm.javafx.android.task.CreateManifestKeepList
import com.bugvm.javafx.android.task.Dex
import com.bugvm.javafx.android.task.Install
import com.bugvm.javafx.android.task.MergeAssets
import com.bugvm.javafx.android.task.MergeResources
import com.bugvm.javafx.android.task.ProcessResources
import com.bugvm.javafx.android.task.Retrolambda
import com.bugvm.javafx.android.task.ValidateManifest
import com.bugvm.javafx.android.task.ValidateSigning
import com.bugvm.javafx.android.task.WriteDexInputListFile
import com.bugvm.javafx.android.task.ZipAlign
import com.bugvm.javafx.embedded.RemotePlatformConfiguration
import com.bugvm.javafx.embedded.task.CopyRemoteDir
import com.bugvm.javafx.embedded.task.RunEmbedded
import com.bugvm.javafx.ios.task.CreateDefaultLauncher
import com.bugvm.javafx.ios.task.CreateIpa
import com.bugvm.javafx.ios.task.IPadSimulator
import com.bugvm.javafx.ios.task.IPhoneSimulator
import com.bugvm.javafx.ios.task.IosDevice
import com.bugvm.javafx.ios.task.IosTask
import proguard.gradle.ProGuardTask

import javax.inject.Inject

/**
 *
 * @author joeri
 */
class JFXMobilePlugin implements Plugin<Project> {

    private static def RETROLAMBDA_COMPILE = 'net.orfjackal.retrolambda:retrolambda:2.3.0'

    private Instantiator instantiator
    private Project project

    List<Task> androidTasks = []
    List<Task> iosTasks = []
    List<Task> embeddedTasks = []

    @Inject
    JFXMobilePlugin(Instantiator instantiator) {
        this.instantiator = instantiator
    }

    void apply(Project project) {
        this.project = project

        def gradleVersion = project.gradle.gradleVersion.split("[\\.]")
        def gradleMajor = Integer.parseInt(gradleVersion[0])
        def gradleMinor = Integer.parseInt(gradleVersion[1])
        if (gradleMajor < 2 || gradleMajor == 2 && gradleMinor < 2) {
            throw new GradleException("You are using Gradle ${project.gradle.gradleVersion} but we require version 2.2 or higher")
        }

        project.plugins.apply JavaPlugin
        project.plugins.apply ApplicationPlugin

        project.sourceSets {
            desktop {
                java {
                    compileClasspath += main.output
                    runtimeClasspath += main.output
                }
            }
            android {
                java {
                    compileClasspath += main.output
                    runtimeClasspath += main.output
                }
            }
            ios {
                java {
                    compileClasspath += main.output
                    runtimeClasspath += main.output
                }
            }
            embedded {
                java {
                    compileClasspath += main.output
                    runtimeClasspath += main.output
                }
            }
        }

        project.extensions.create("jfxmobile", JFXMobileExtension, project, instantiator)

        JFXMobileConvention pluginConvention = new JFXMobileConvention(project)
        project.convention.plugins.'org.javafxports.jfxmobile' = pluginConvention

        project.configurations {
            retrolambdaConfig

            compileNoRetrolambda
            runtimeNoRetrolambda {
                extendsFrom compileNoRetrolambda
            }
            compile {
                extendsFrom compileNoRetrolambda
            }
            runtime {
                extendsFrom runtimeNoRetrolambda
            }

            androidBootclasspath
            iosBootclasspath

            androidSdk
            dalvikSdk
            iosSdk
            robovmSdk
            sshAntTask
        }

        project.dependencies {
            retrolambdaConfig RETROLAMBDA_COMPILE
        }

        project.configurations.desktopCompile.extendsFrom project.configurations.compile
        project.configurations.desktopRuntime.extendsFrom project.configurations.desktopCompile, project.configurations.runtime
        project.configurations.androidCompile.extendsFrom project.configurations.compile, project.configurations.androidBootclasspath, project.configurations.androidSdk
        project.configurations.androidRuntime.extendsFrom project.configurations.androidCompile, project.configurations.runtime
        project.configurations.iosCompile.extendsFrom project.configurations.compile
        project.configurations.iosRuntime.extendsFrom project.configurations.iosCompile, project.configurations.runtime
        project.configurations.embeddedCompile.extendsFrom project.configurations.compile
        project.configurations.embeddedRuntime.extendsFrom project.configurations.embeddedCompile, project.configurations.runtime

        createAndroidTasks()
        createIosTasks()
        createEmbeddedTasks()

        project.afterEvaluate {
            // apply downConfig to project configurations
            project.jfxmobile.downConfig.applyConfiguration(project.configurations.compile)
            project.jfxmobile.downConfig.applyConfiguration(project.configurations.desktopRuntime)
            project.jfxmobile.downConfig.applyConfiguration(project.configurations.androidRuntime)
            project.jfxmobile.downConfig.applyConfiguration(project.configurations.iosRuntime)
            project.jfxmobile.downConfig.applyConfiguration(project.configurations.embeddedRuntime)

            // try to set android.jar dependency as early as possible, but only
            // when the jar can be found
            File platformAndroidJar = getPlatformAndroidJar()
            if (platformAndroidJar != null && platformAndroidJar.exists()) {
                project.dependencies {
                    androidSdk project.files(platformAndroidJar.absolutePath)
                }
            }

            // configure android and ios dependencies
            project.dependencies {
                androidCompile "org.javafxports:jfxdvk:${project.jfxmobile.javafxportsVersion}"

                iosCompile "com.mobidevelop.robovm:robovm-cocoatouch:${project.jfxmobile.ios.robovmVersion}"

                iosBootclasspath "com.mobidevelop.robovm:robovm-rt:${project.jfxmobile.ios.robovmVersion}"

                dalvikSdk "org.javafxports:dalvik-sdk:${project.jfxmobile.javafxportsVersion}@zip"
                iosSdk "org.javafxports:ios-sdk:${project.jfxmobile.javafxportsVersion}@zip"
                bugvmSdk "com.bugvm:bugvm-dist:${project.jfxmobile.ios.bugvmVersion}@tar.gz"

                sshAntTask 'org.apache.ant:ant-jsch:1.9.6'
            }

            // set the encoding option for the javac compile tasks
            project.tasks.withType(JavaCompile) {
                options.encoding = project.jfxmobile.javacEncoding
            }

            // add our own debug task, calling replace because the NetBeans gradle plugin already creates one
            project.tasks.replace('debug', JavaExec)
            project.tasks.debug {
                description = 'Runs this program as a JVM application for debugging'
                group = 'application'
                main = project.mainClassName
                classpath = project.sourceSets.desktop.runtimeClasspath
                debug = true
            }
            project.tasks.debug.dependsOn project.tasks.classes

            // include desktop when creating jar and running application
            project.tasks.run {
                classpath = project.sourceSets.desktop.runtimeClasspath
                if (project.preloaderClassName != null && !project.preloaderClassName.empty) {
                    systemProperties('javafx.preloader' : project.preloaderClassName)
                }
            }
            project.tasks.jar {
                from project.sourceSets.desktop.output
                manifest {
                    if (project.preloaderClassName != null && !project.preloaderClassName.empty) {
                        attributes(
                            'Main-Class' : project.mainClassName,
                            'JavaFX-Preloader-Class' : project.preloaderClassName
                        )
                    } else {
                        attributes(
                            'Main-Class' : project.mainClassName
                        )
                    }
                }
            }
        }

        project.gradle.taskGraph.whenReady {
            project.logger.info("Using javafxports version ${project.jfxmobile.javafxportsVersion}")
            configure()

            // only configure android when one of the android tasks will be run
            if (androidTasks.find { project.gradle.taskGraph.hasTask(it) } != null) {
                configureAndroid()

                project.dependencies {
                    androidRuntime project.fileTree("${project.jfxmobile.android.dalvikSdkLib}/ext") {
                        include 'compat-1.0.0.jar'
                    }
                    runtimeNoRetrolambda project.fileTree("${project.jfxmobile.android.dalvikSdkLib}/ext") {
                        include 'jfxrt.jar'
                    }
                    runtimeNoRetrolambda project.files("${project.jfxmobile.android.androidSdk}/extras/android/support/multidex/library/libs/android-support-multidex.jar")
                }

                // configure android boot classpath
                def androidBootclasspath = project.configurations.androidBootclasspath.asPath
                if (!androidBootclasspath.empty) {
                    project.tasks.compileAndroidJava {
                        options.bootClasspath = androidBootclasspath
                    }
                }

                // NOTE: from is set after all configuration for androidRuntime has completed
                project.tasks.copyClassesForRetrolambda.from {
                    (project.configurations.androidRuntime - project.configurations.runtimeNoRetrolambda - project.configurations.androidSdk).filter {
                        !it.isDirectory()
                    }.collect {
                        project.logger.info("Apply Retrolambda to $it")
                        project.zipTree(it)
                    }
                }

                // NOTE: from is set after all configuration for runtimeNoRetrolambda has completed
                project.tasks.mergeClassesIntoJar.from {
                    project.configurations.runtimeNoRetrolambda.collect { project.zipTree(it) }
                }
            } else {
                // ignore tasks for android sourceSet
                project.tasks.androidClasses.enabled = false
                project.tasks.compileAndroidJava.enabled = false
                project.tasks.processAndroidResources.enabled = false
            }

            // only configure ios when one of the ios tasks will be run
            if (iosTasks.find { project.gradle.taskGraph.hasTask(it) } != null) {
                configureIos()

                project.dependencies {
                    iosRuntime project.fileTree("${project.jfxmobile.ios.iosSdkLib}/ext") {
                        include '*.jar'
                    }

                    iosBootclasspath project.fileTree("${project.jfxmobile.ios.iosSdkLib}/ext") {
                        include 'compat-1.0.0.jar'
                    }
                }

                // configure ios boot classpath
                project.tasks.compileIosJava {
                    options.bootClasspath = project.configurations.iosBootclasspath.asPath
                }

                // NOTE: from is set after all configuration for iosRuntime has completed
                project.tasks.iosExtractNativeLibs.from {
                    project.configurations.iosRuntime.collect { project.zipTree(it).matching { include 'native/*.a' }}
                }
            } else {
                // ignore tasks for ios sourceSet
                project.tasks.iosClasses.enabled = false
                project.tasks.compileIosJava.enabled = false
                project.tasks.processIosResources.enabled = false
            }
            // only configure embedded when one of the embedded tasks will be run
            if (embeddedTasks.find { project.gradle.taskGraph.hasTask(it) } != null) {
                configureEmbedded()
            }
        }
    }

    private void configure() {
        if (project.mainClassName == null || project.mainClassName.empty) {
            throw new GradleException("Missing or empty mainClassName property.");
        }
    }

    private void createAndroidTasks() {
        ValidateManifest validateManifestTask = project.tasks.create("validateManifest", ValidateManifest)
        validateManifestTask.conventionMapping.map("output") { project.file("${project.jfxmobile.android.temporaryDirectory}/AndroidManifest.xml") }
        androidTasks.add(validateManifestTask)

        CreateManifestKeepList manifestKeepListTask = project.tasks.create("collectMultiDexComponents", CreateManifestKeepList)
        manifestKeepListTask.conventionMapping.map("outputFile") { project.file("${project.jfxmobile.android.multidexOutputDirectory}/manifest_keep.txt") }
        manifestKeepListTask.conventionMapping.map("manifest") { validateManifestTask.output }
        manifestKeepListTask.conventionMapping.map("dexOptions") { project.jfxmobile.android.dexOptions }
        manifestKeepListTask.conventionMapping.map("proguardFile") { project.jfxmobile.android.proguardFile != null && !project.jfxmobile.android.proguardFile.trim().empty ? project.file(project.jfxmobile.android.proguardFile) : null }
        manifestKeepListTask.dependsOn validateManifestTask
        androidTasks.add(manifestKeepListTask)

        Copy copyClassesForRetrolambda = project.tasks.create("copyClassesForRetrolambda", Copy)
        copyClassesForRetrolambda.from project.sourceSets.main.output.classesDir
        copyClassesForRetrolambda.from project.sourceSets.android.output.classesDir
        copyClassesForRetrolambda.include '**/*.class'
        copyClassesForRetrolambda.includeEmptyDirs = false
        copyClassesForRetrolambda.destinationDir = project.file("${project.jfxmobile.android.temporaryDirectory}/retrolambda/input")
        copyClassesForRetrolambda.dependsOn project.tasks.compileJava, project.tasks.compileAndroidJava
        androidTasks.add(copyClassesForRetrolambda)

        Retrolambda retrolambdaTask = project.tasks.create("applyRetrolambda", Retrolambda)
        retrolambdaTask.conventionMapping.map("classpath") { project.files(project.configurations.compileNoRetrolambda, project.configurations.androidSdk) }
        retrolambdaTask.retrolambdaInput = copyClassesForRetrolambda.destinationDir
        retrolambdaTask.retrolambdaOutput = project.file("${project.jfxmobile.android.temporaryDirectory}/retrolambda/output")
        retrolambdaTask.dependsOn copyClassesForRetrolambda
        androidTasks.add(retrolambdaTask)

        Jar mergeClassesIntoJarTask = project.tasks.create("mergeClassesIntoJar", Jar)
        mergeClassesIntoJarTask.destinationDir = project.file("${project.jfxmobile.android.multidexOutputDirectory}")
        mergeClassesIntoJarTask.archiveName = 'allclasses.jar'
        mergeClassesIntoJarTask.from retrolambdaTask.retrolambdaOutput
        mergeClassesIntoJarTask.include '**/*.class'
        mergeClassesIntoJarTask.dependsOn retrolambdaTask
        androidTasks.add(mergeClassesIntoJarTask)

        ProGuardTask proguardComponentsTask = project.tasks.create("shrinkMultiDexComponents", ProGuardTask)
        proguardComponentsTask.dontobfuscate()
        proguardComponentsTask.dontoptimize()
        proguardComponentsTask.dontpreverify()
        proguardComponentsTask.dontnote()
        proguardComponentsTask.dontwarn()
        if (project.logger.debugEnabled) {
            proguardComponentsTask.verbose()
        }
        proguardComponentsTask.forceprocessing()
        proguardComponentsTask.configuration(manifestKeepListTask.outputFile)
        proguardComponentsTask.libraryjars({
            return project.file("${project.jfxmobile.android.buildToolsLib}/shrinkedAndroid.jar")
        })
        proguardComponentsTask.injars(mergeClassesIntoJarTask.archivePath)
        File componentsJarFile = project.file("${project.jfxmobile.android.multidexOutputDirectory}/componentClasses.jar")
        proguardComponentsTask.outjars(componentsJarFile)
        proguardComponentsTask.printconfiguration("${project.jfxmobile.android.multidexOutputDirectory}/components.flags")
        proguardComponentsTask.dependsOn manifestKeepListTask, mergeClassesIntoJarTask
        androidTasks.add(proguardComponentsTask)

        CreateMainDexList createMainDexListTask = project.tasks.create("createMainDexList", CreateMainDexList)
        createMainDexListTask.allClassesJarFile = mergeClassesIntoJarTask.archivePath
        createMainDexListTask.conventionMapping.map("componentsClassesJarFile") { componentsJarFile }
        createMainDexListTask.conventionMapping.map("dexOptions") { project.jfxmobile.android.dexOptions }
        createMainDexListTask.outputFile = project.file("${project.jfxmobile.android.multidexOutputDirectory}/maindexlist.txt")
        createMainDexListTask.dependsOn proguardComponentsTask
        androidTasks.add(createMainDexListTask)

        WriteDexInputListFile writeInputListFileTask = project.tasks.create("writeInputListFile", WriteDexInputListFile)
        writeInputListFileTask.inputListFile = project.file("${project.jfxmobile.android.dexOutputDirectory}/inputList.txt")
        writeInputListFileTask.jar = mergeClassesIntoJarTask.archivePath
        writeInputListFileTask.dependsOn mergeClassesIntoJarTask
        androidTasks.add(writeInputListFileTask)

        Dex dexTask = project.tasks.create("dex", Dex)
        dexTask.conventionMapping.map("mainDexListFile") { createMainDexListTask.outputFile }
        dexTask.conventionMapping.map("inputListFile") { writeInputListFileTask.inputListFile }
        dexTask.conventionMapping.map("dexOptions") { project.jfxmobile.android.dexOptions }
        dexTask.outputDirectory = project.file("${project.jfxmobile.android.dexOutputDirectory}")
        dexTask.dependsOn createMainDexListTask, writeInputListFileTask
        androidTasks.add(dexTask)

        MergeResources mergeResourcesTask = project.tasks.create("mergeAndroidResources", MergeResources)
        mergeResourcesTask.conventionMapping.map("aaptExe") { project.file("${project.jfxmobile.android.buildToolsDir}/aapt${platformExtension()}") }
        mergeResourcesTask.conventionMapping.map("inputResourceSets") {
            ResourceSet mainResourceSet = new ResourceSet(BuilderConstants.MAIN)
            mainResourceSet.addSource(project.file(project.jfxmobile.android.resDirectory))
            return [ mainResourceSet ]
        }
        mergeResourcesTask.conventionMapping.map("outputDir") { project.file("${project.jfxmobile.android.resourcesDirectory}/res") }
        androidTasks.add(mergeResourcesTask)

        MergeAssets mergeAssetsTask = project.tasks.create("mergeAndroidAssets", MergeAssets)
        mergeAssetsTask.conventionMapping.map("inputAssetSets") {
            AssetSet mainAssetSet = new AssetSet(BuilderConstants.MAIN)
            mainAssetSet.addSource(project.file(project.jfxmobile.android.assetsDirectory))
            return [ mainAssetSet ]
        }
        mergeAssetsTask.conventionMapping.map("outputDir") { project.file("${project.jfxmobile.android.resourcesDirectory}/assets") }
        androidTasks.add(mergeAssetsTask)

        SigningConfig releaseSigningConfig = project.jfxmobile.android.signingConfig
        ZipAlign zipAlignReleaseTask = createApkTasks('Release', releaseSigningConfig)

        AndroidTask androidReleaseTask = project.tasks.create("androidRelease", AndroidTask)
        androidReleaseTask.description("Generates a release Android apk containing the JavaFX application.")
        androidReleaseTask.dependsOn zipAlignReleaseTask
        androidTasks.add(androidReleaseTask)

        SigningConfig debugSigningConfig = new SigningConfig('debug')
        ZipAlign zipAlignDebugTask = createApkTasks('Debug', debugSigningConfig)

        Install installDebugTask = project.tasks.create("androidInstall", Install)
        installDebugTask.description("Launch the application on a connected android device.")
        installDebugTask.conventionMapping.map("adbExe") { project.file("${project.jfxmobile.android.androidSdk}/platform-tools/adb${platformExtension()}") }
        installDebugTask.conventionMapping.map("apk") { zipAlignDebugTask.outputFile }
        installDebugTask.dependsOn zipAlignDebugTask
        androidTasks.add(installDebugTask)

        AndroidTask androidDebugTask = project.tasks.create("android", AndroidTask)
        androidDebugTask.description("Generates a debug Android apk containing the JavaFX application.")
        androidDebugTask.dependsOn zipAlignDebugTask
        androidTasks.add(androidDebugTask)
    }

    private ZipAlign createApkTasks(String variant, SigningConfig signingConfig) {
        ProcessResources processResourcesTask = project.tasks.create("processAndroidResources${variant}", ProcessResources)
        if ("Debug" == variant) {
            processResourcesTask.setDebuggable(true)
        }
        processResourcesTask.conventionMapping.map("manifest") { project.tasks.collectMultiDexComponents.manifest }
        processResourcesTask.conventionMapping.map("resDir") { project.tasks.mergeAndroidResources.outputDir }
        processResourcesTask.conventionMapping.map("assetsDir") { project.tasks.mergeAndroidAssets.outputDir }
        processResourcesTask.conventionMapping.map("packageOutputFile") { project.file("${project.jfxmobile.android.resourcesDirectory}/resources.ap_") }
        processResourcesTask.conventionMapping.map("aaptExe") { project.file("${project.jfxmobile.android.buildToolsDir}/aapt${platformExtension()}") }
        processResourcesTask.dependsOn project.tasks.processAndroidResources, project.tasks.mergeAndroidResources, project.tasks.mergeAndroidAssets
        androidTasks.add(processResourcesTask)

        Apk apkTask = project.tasks.create("apk${variant}", Apk)
        apkTask.conventionMapping.map("resourceFile") { processResourcesTask.packageOutputFile }
        apkTask.conventionMapping.map("dexDirectory") { project.tasks.dex.outputDirectory }
        apkTask.conventionMapping.map("dexedLibraries") { Collections.<File> emptyList() }
        apkTask.conventionMapping.map("jniFolders") {
            project.files(
                "${project.jfxmobile.android.dalvikSdkLib}",
                "${project.jfxmobile.android.nativeDirectory}"
            ).files
        }
        apkTask.conventionMapping.map("outputFile") { project.file("${project.jfxmobile.android.installDirectory}/${project.name}-unaligned.apk") }
        apkTask.conventionMapping.map("mainResourcesDirectory") {
            def mainResourcesOutputDir = project.tasks.processResources.destinationDir
            mainResourcesOutputDir != null && mainResourcesOutputDir.isDirectory() ? mainResourcesOutputDir : null
        }
        apkTask.conventionMapping.map("androidResourcesDirectory") {
            def androidResourcesOutputDir = project.tasks.processAndroidResources.destinationDir
            androidResourcesOutputDir != null && androidResourcesOutputDir.isDirectory() ? androidResourcesOutputDir : null
        }
        apkTask.conventionMapping.map("signingConfig") {
            if (signingConfig.getStoreFile() != null) {
                signingConfig
            }
        }
        apkTask.conventionMapping.map("packagingOptions") { project.jfxmobile.android.packagingOptions }
        apkTask.dependsOn processResourcesTask, project.tasks.dex
        androidTasks.add(apkTask)

        if (signingConfig != null) {
            ValidateSigning validateSigningTask = project.tasks.create("validateSigning${variant}", ValidateSigning)
            validateSigningTask.signingConfig = signingConfig
            androidTasks.add(validateSigningTask)
            apkTask.dependsOn validateSigningTask
        }

        ZipAlign zipAlignTask = project.tasks.create("zipalign${variant}", ZipAlign)
        zipAlignTask.conventionMapping.map("inputFile") { apkTask.outputFile }
        zipAlignTask.conventionMapping.map("outputFile") { project.file("${project.jfxmobile.android.installDirectory}/${project.name}.apk") }
        zipAlignTask.conventionMapping.map("zipAlignExe") { project.file("${project.jfxmobile.android.buildToolsDir}/zipalign${platformExtension()}") }
        zipAlignTask.dependsOn apkTask
        androidTasks.add(zipAlignTask)

        return zipAlignTask
    }

    private void createIosTasks() {
        if (project.jfxmobile.ios.launcherClassName == 'org.javafxports.jfxmobile.ios.BasicLauncher') {
            CreateDefaultLauncher createDefaultLauncherTask = project.tasks.create('createDefaultIOSLauncher', CreateDefaultLauncher)
            createDefaultLauncherTask.conventionMapping.map('mainClassName') { project.mainClassName }
            createDefaultLauncherTask.conventionMapping.map('preloaderClassName') { project.preloaderClassName }
            createDefaultLauncherTask.outputFile = project.file("${project.jfxmobile.ios.temporaryDirectory}/sources/org/javafxports/jfxmobile/ios/BasicLauncher.java")

            project.tasks.compileIosJava {
                dependsOn createDefaultLauncherTask
                source project.file("${project.jfxmobile.ios.temporaryDirectory}/sources")
            }
        }

        // NOTE: the from input is taken from the iosRuntime configuration, but can only be applied
        // when that configuration is completely configured. the from is applied above at a later
        // time after the project's taskGraph is ready
        Sync extractNativeLibsTask = project.tasks.create("iosExtractNativeLibs", Sync) {
            into project.file("${project.jfxmobile.ios.temporaryDirectory}")
            include 'native/*.a'
        }

        IosDevice iosDeviceTask = project.tasks.create("launchIOSDevice", IosDevice)
        iosDeviceTask.description("Launch the application on a connected ios device.")
        iosDeviceTask.dependsOn([project.tasks.iosClasses, extractNativeLibsTask])
        iosTasks.add(iosDeviceTask)

        IPadSimulator ipadSimulatorTask = project.tasks.create("launchIPadSimulator", IPadSimulator)
        ipadSimulatorTask.description("Launch the application on an iPad simulator.")
        ipadSimulatorTask.dependsOn([project.tasks.iosClasses, extractNativeLibsTask])
        iosTasks.add(ipadSimulatorTask)

        IPhoneSimulator iphoneSimulatorTask = project.tasks.create("launchIPhoneSimulator", IPhoneSimulator)
        iphoneSimulatorTask.description("Launch the application on an iPhone simulator.")
        iphoneSimulatorTask.dependsOn([project.tasks.iosClasses, extractNativeLibsTask])
        iosTasks.add(iphoneSimulatorTask)

        CreateIpa createIpaTask = project.tasks.create("createIpa", CreateIpa)
        createIpaTask.description("Generates an iOS ipa containing the JavaFX application.")
        createIpaTask.dependsOn([project.tasks.iosClasses, extractNativeLibsTask])
        iosTasks.add(createIpaTask)

        IosTask iosTask = project.tasks.create('ios', IosTask)
        iosTask.dependsOn createIpaTask
        iosTasks.add(iosTask)
    }

    private void createEmbeddedTasks() {
        project.task('copyEmbeddedDependencies', type: Copy) {
            into project.file("$project.buildDir/javafxports/embedded/libs")
            from project.configurations.embeddedRuntime
        }
        embeddedTasks.add(project.tasks.copyEmbeddedDependencies)

        project.task('embeddedJar', type: Jar) {
            from project.sourceSets.embedded.output
            from project.sourceSets.main.output
            destinationDir project.tasks.copyEmbeddedDependencies.destinationDir
        }
        project.tasks.embeddedJar.conventionMapping.map('manifest') {
            project.manifest {
                if (project.preloaderClassName != null && !project.preloaderClassName.empty) {
                    attributes(
                            'Main-Class': project.mainClassName,
                            'JavaFX-Preloader-Class': project.preloaderClassName
                    )
                } else {
                    attributes(
                            'Main-Class': project.mainClassName
                    )
                }
            }
        }
        embeddedTasks.add(project.tasks.embeddedJar)

        CopyRemoteDir copyJarTask = project.tasks.create("copyJarToEmbeddedPlatform", CopyRemoteDir)
        copyJarTask.conventionMapping.map('from') { project.tasks.copyEmbeddedDependencies.destinationDir }
        copyJarTask.conventionMapping.map('remotePlatform') { getRemotePlatformConfiguration() }
        copyJarTask.dependsOn project.tasks.embeddedJar, project.tasks.copyEmbeddedDependencies
        embeddedTasks.add(copyJarTask)

        RunEmbedded runEmbeddedTask = project.tasks.create("runEmbedded", RunEmbedded)
        runEmbeddedTask.description('Launch the application on a remote embedded platform.')
        runEmbeddedTask.conventionMapping.map('remotePlatform') { getRemotePlatformConfiguration() }
        runEmbeddedTask.dependsOn copyJarTask
        embeddedTasks.add(runEmbeddedTask)
    }

    /**
     * Locates the android sdk and returns the android.jar for the configured
     * android platform. The android platform can be configured by setting the
     * compileSdkVersion. If no android sdk could be located, this method will
     * return <code>null</code>.
     * Please note that the returned file does not necessarily need to exist.
     */
    private File getPlatformAndroidJar() {
        String androidSdkLocation = locateAndroidSdk()
        if (androidSdkLocation != null) {
            return project.file("${androidSdkLocation}/platforms/android-${project.jfxmobile.android.compileSdkVersion}/android.jar")
        }
        return null
    }

    private void configureAndroid() {
        project.logger.info("Configuring Build for Android")

        if (project.jfxmobile.android.dalvikSdk == null) {
            project.jfxmobile.android.dalvikSdk = resolveSdk(project.configurations.dalvikSdk, "dalvik-sdk")
        }
        project.jfxmobile.android.dalvikSdkLib = project.file("${project.jfxmobile.android.dalvikSdk}/rt/lib")
        if (!project.jfxmobile.android.dalvikSdkLib.exists()) {
            throw new GradleException("Configured dalvikSdk is invalid: ${project.jfxmobile.android.dalvikSdk}")
        }
        project.logger.info("Using javafxports dalvik sdk from location ${project.jfxmobile.android.dalvikSdk}")

        // try and set the androidSdk extension value if it is not set
        project.jfxmobile.android.androidSdk = locateAndroidSdk()
        if (project.jfxmobile.android.androidSdk == null) {
            throw new GradleException("ANDROID_HOME not specified. Either set it as a gradle property, a system environment variable or directly in your build.gradle by setting the extension jfxmobile.android.androidSdk.")
        }
        project.logger.info("Using androidSdk from location: ${project.jfxmobile.android.androidSdk}")

        // check if android sdk points to correct directory by checking if the
        // configured androidSdk directory contains a build-tools subdirectory
        def buildToolsDir = project.file("${project.jfxmobile.android.androidSdk}/build-tools")
        if (!buildToolsDir.exists()) {
            throw new GradleException("Configured androidSdk is invalid: ${project.jfxmobile.android.androidSdk}")
        }

        // automatically figure out most recent build tools version if it is not
        // specified on extension
        if (project.jfxmobile.android.buildToolsVersion == null) {
            project.logger.info("There was no buildToolsVersion specified, looking for most recent installed version automatically")
            def maxRevisionDir = null
            def maxRevision = null
            buildToolsDir.eachDir { dir ->
                try {
                    def revision = FullRevision.parseRevision(dir.name)
                    if (revision.preview) {
                        project.logger.info("Ignoring directory ${dir.absolutePath} as it denotes a preview build tools version")
                    } else if (maxRevision == null || maxRevision.compareTo(revision) < 0) {
                        maxRevision = revision
                        maxRevisionDir = dir
                    }
                } catch (NumberFormatException ex) {
                    project.logger.info("Ignoring directory ${dir.absolutePath} as it does not denote a valid android build tools revision number")
                }
            }

            if (maxRevision == null) {
                throw new GradleException("No valid build tools version could be detected in ${project.jfxmobile.android.androidSdk}. Please check your androidSdk installation.")
            } else {
                project.jfxmobile.android.buildToolsVersion = maxRevisionDir.name
                project.logger.info("Using the following automatically detected buildToolsVersion: ${maxRevisionDir.name}")
            }
        }

        project.jfxmobile.android.buildToolsDir = project.file("${project.jfxmobile.android.androidSdk}/build-tools/${project.jfxmobile.android.buildToolsVersion}")
        project.jfxmobile.android.buildToolsLib = project.file("${project.jfxmobile.android.buildToolsDir}/lib")

        project.jfxmobile.android.validate()

        if (project.jfxmobile.android.applicationPackage == null) {
            def dotIndex = project.mainClassName.lastIndexOf('.')
            if (dotIndex != -1) {
                project.jfxmobile.android.applicationPackage = project.mainClassName[0..<dotIndex]
            } else {
                project.jfxmobile.android.applicationPackage = project.mainClassName
            }
        }
    }

    private String locateAndroidSdk() {
        if (project.jfxmobile.android.androidSdk == null) {
            // first see if there is a gradle property ANDROID_HOME
            if (project.hasProperty('ANDROID_HOME')) {
                return project.property('ANDROID_HOME')
            } else {
                // next see if there is a system environment variable ANDROID_HOME
                def envAndroidHome = System.env['ANDROID_HOME']
                if (envAndroidHome != null) {
                    return envAndroidHome
                }
            }
        }

        return project.jfxmobile.android.androidSdk
    }

    private void configureIos() {
        project.logger.info("Configuring build for iOS")

        if (project.jfxmobile.ios.iosSdk == null) {
            project.jfxmobile.ios.iosSdk = resolveSdk(project.configurations.iosSdk, "ios-sdk")
        }
        project.jfxmobile.ios.iosSdkLib = project.file("${project.jfxmobile.ios.iosSdk}/rt/lib")
        if (!project.jfxmobile.ios.iosSdkLib.exists()) {
            throw new GradleException("Configured iosSdk is invalid: ${project.jfxmobile.ios.iosSdk}")
        }
        project.logger.info("Using javafxports ios sdk from location ${project.jfxmobile.ios.iosSdk}")

        if (project.jfxmobile.ios.bugvmSdk == null) {
            project.jfxmobile.ios.bugvmSdk = resolveSdk(project.configurations.bugvmSdk, "bugvm-${project.jfxmobile.ios.bugvmVersion}")
        }
        project.logger.info("Using bugvm sdk from location ${project.jfxmobile.ios.bugvmSdk}")
    }

    private void configureEmbedded() {
        project.ant.taskdef(name: 'sshexec', classname: 'org.apache.tools.ant.taskdefs.optional.ssh.SSHExec',
                classpath: project.configurations.sshAntTask.asPath)
        project.ant.taskdef(name: 'scp', classname: 'org.apache.tools.ant.taskdefs.optional.ssh.Scp',
                classpath: project.configurations.sshAntTask.asPath)
    }

    private RemotePlatformConfiguration getRemotePlatformConfiguration() {
        if (project.hasProperty('remotePlatform')) {
            return project.jfxmobile.embedded.remotePlatforms.getByName(project.getProperty('remotePlatform'))
        } else {
            if (project.jfxmobile.embedded.remotePlatforms.size() == 0) {
                throw new GradleException("Can not execute embedded task because no remote platform was configured in jfxmobile.embedded.remotePlatforms")
            } else if (project.jfxmobile.embedded.remotePlatforms.size() == 1) {
                return project.jfxmobile.embedded.remotePlatforms.iterator().next()
            } else {
                RemotePlatformConfiguration first = project.jfxmobile.embedded.remotePlatforms.iterator().next()
                throw new GradleException("Multiple remote platforms are configured. Please specify which remote platform configuration to use by providing a gradle property with name 'remotePlatform', e.g.: gradle -PremotePlatform=${first.name} runEmbedded")
            }
        }
    }

    private String platformExtension() {
        def os = System.properties['os.name']
        if (os.startsWith('Windows')) {
            return '.exe'
        } else {
            return ''
        }
    }

    private String resolveSdk(Configuration configuration, String unpackedSubDirectory) {
        Set<File> files = configuration.resolve()
        if (!files.isEmpty()) {
            return unpackSdk(configuration.getAllDependencies().getAt(0), files.iterator().next(), unpackedSubDirectory).absolutePath
        }
        return null
    }

    private File unpackSdk(Dependency dependency, File archive, String unpackedSubDirectory) {
        final File unpackedDirectory = new File(archive.parent, "unpacked")
        final File unpackedDistDirectory = new File(unpackedDirectory, unpackedSubDirectory)

        if (unpackedDirectory.exists() && dependency.version.endsWith('-SNAPSHOT')) {
            unpackedDirectory.deleteDir()
        }

        if (!unpackedDirectory.exists()) {
            if (!unpackedDirectory.mkdirs()) {
                throw new GradleException("Unable to create base directory to unpack into: " + unpackedDirectory)
            }

            if (archive.name.endsWith(".zip")) {
                project.ant.unzip(src: archive, dest: unpackedDirectory)
            } else if (archive.name.endsWith(".tar.gz")) {
                project.ant.untar(src: archive, dest: unpackedDirectory, compression: 'gzip')
            }
            if (!unpackedDistDirectory.exists()) {
                throw new GradleException("Unable to unpack archive.")
            }

            File binDirectory = new File(unpackedDistDirectory, 'bin')
            if (binDirectory.exists()) {
                project.ant.chmod(dir: binDirectory, perm: '+x', includes: '*')
            }
        }

        return unpackedDistDirectory
    }

}
