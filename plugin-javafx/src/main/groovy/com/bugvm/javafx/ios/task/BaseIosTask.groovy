package com.bugvm.javafx.ios.task

import com.dd.plist.NSArray
import com.dd.plist.NSObject
import com.dd.plist.NSString
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import com.bugvm.compiler.AppCompiler
import com.bugvm.compiler.config.Config
import com.bugvm.compiler.config.Config.Lib
import com.bugvm.compiler.config.OS
import com.bugvm.compiler.config.Resource
import com.bugvm.compiler.log.Logger
import com.bugvm.compiler.target.ConsoleTarget
import com.bugvm.compiler.target.ios.IOSTarget
import com.bugvm.compiler.target.ios.ProvisioningProfile;
import com.bugvm.compiler.target.ios.SDK
import com.bugvm.compiler.target.ios.SigningIdentity;

/**
 *
 * @author joeri
 */
abstract class BaseIosTask extends DefaultTask {

    protected Config.Builder configure(Config.Builder builder) {
        builder.logger(createLogger())

        if (project.jfxmobile.ios.propertiesFile != null) {
            File propertiesFile = project.file(project.jfxmobile.ios.propertiesFile)
            if (!propertiesFile.exists()) {
                throw new GradleException("Invalid 'propertiesFile' specified for BugVM compile: ${propertiesFile}")
            }

            try {
                project.logger.debug("Including properties file in BugVM compiler config: ${propertiesFile}")
                builder.addProperties(propertiesFile)
            } catch (IOException ex) {
                throw new GradleException("Failed to add properties file to BugVM config: ${propertiesFile}")
            }
        } else {
            try {
                builder.readProjectProperties(project.rootDir, false)
            } catch (IOException ex) {
                throw new GradleException("Failed to read BugVM project properties file(s) in ${project.rootDir}", ex)
            }
        }

        if (project.jfxmobile.ios.configFile != null) {
            File configFile = project.file(project.jfxmobile.ios.configFile)
            if (!configFile.exists()) {
                throw new GradleException("Invalid 'configFile' specified for BugVM compile: ${configFile}")
            }

            try {
                project.logger.debug("Loading config file for BugVM compiler: ${configFile}")
                builder.read(configFile)
            } catch (IOException ex) {
                throw new GradleException("Failed to read BugVM config file: ${configFile}")
            }
        } else {
            try {
                builder.readProjectConfig(project.rootDir, false)
            } catch (IOException ex) {
                throw new GradleException("Failed to read BugVM config file in ${project.rootDir}", ex)
            }
        }

        builder.home(new Config.Home(project.file(project.jfxmobile.ios.robovmSdk)))
                .tmpDir(project.jfxmobile.ios.temporaryDirectory)
                .skipInstall(true)
                .installDir(project.jfxmobile.ios.installDirectory)
                .mainClass(project.jfxmobile.ios.launcherClassName)
                .executableName(project.name)

        if (project.jfxmobile.ios.debug) {
            builder.debug(true)
            if (project.jfxmobile.ios.debugPort != -1) {
                builder.addPluginArgument("debug:jdwpport=${project.jfxmobile.ios.debugPort}")
            }
        }

        if (project.jfxmobile.ios.iosSkipSigning) {
            builder.iosSkipSigning(true)
        } else {
            if (project.jfxmobile.ios.iosSignIdentity != null) {
                String iosSignIdentity = project.jfxmobile.ios.iosSignIdentity

                project.logger.debug("Using explicit iOS Signing identity: " + iosSignIdentity)
                builder.iosSignIdentity(SigningIdentity.find(SigningIdentity.list(), iosSignIdentity));
            }

            if (project.jfxmobile.ios.iosProvisioningProfile != null) {
                String iosProvisioningProfile = project.jfxmobile.ios.iosProvisioningProfile

                project.logger.debug("Using explicit iOS provisioning profile: " + iosProvisioningProfile);
                builder.iosProvisioningProfile(ProvisioningProfile.find(ProvisioningProfile.list(), iosProvisioningProfile));
            }
        }

        builder.clearClasspathEntries()
        project.configurations.iosRuntime.files.each {
            builder.addClasspathEntry(it)
        }
        // add ios-sdk/rt/lib to classpath to include properties and .a libraries
        builder.addClasspathEntry(project.jfxmobile.ios.iosSdkLib)
        builder.addClasspathEntry(project.tasks.compileJava.destinationDir)
        builder.addClasspathEntry(project.tasks.compileIosJava.destinationDir)

        def mainResourcesOutputDir = project.sourceSets.main.output.resourcesDir
        if (mainResourcesOutputDir != null && mainResourcesOutputDir.isDirectory()) {
            builder.addClasspathEntry(mainResourcesOutputDir)
        }
        def iosResourcesOutputDir = project.sourceSets.ios.output.resourcesDir
        if (iosResourcesOutputDir != null && iosResourcesOutputDir.isDirectory()) {
            builder.addClasspathEntry(iosResourcesOutputDir)
        }

        def iosAssetsDir = project.file(project.jfxmobile.ios.assetsDirectory)
        if (iosAssetsDir.exists() && iosAssetsDir.isDirectory()) {
            builder.addResource(new Resource(iosAssetsDir, ""))
        }

        if (project.jfxmobile.ios.infoPList != null) {
            builder.iosInfoPList(project.jfxmobile.ios.infoPList)
        }

        // add javafx native libraries
        builder.addLib(new Lib(new File(project.jfxmobile.ios.iosSdkLib, 'libglass.a').absolutePath, true))
                .addLib(new Lib(new File(project.jfxmobile.ios.iosSdkLib, 'libjavafx_font.a').absolutePath, true))
                .addLib(new Lib(new File(project.jfxmobile.ios.iosSdkLib, 'libjavafx_iio.a').absolutePath, true))
                .addLib(new Lib(new File(project.jfxmobile.ios.iosSdkLib, 'libjavafx_ios_webnode.a').absolutePath, true))
                .addLib(new Lib(new File(project.jfxmobile.ios.iosSdkLib, 'libprism_common.a').absolutePath, true))
                .addLib(new Lib(new File(project.jfxmobile.ios.iosSdkLib, 'libprism_es2.a').absolutePath, true))

        // add native libraries defined in project
        def iosNativeDir = project.file(project.jfxmobile.ios.nativeDirectory)
        if (iosNativeDir.exists() && iosNativeDir.isDirectory()) {
            project.files(iosNativeDir.listFiles()).each {
                project.logger.info("Adding native library from ios native dir: ${it}")
                builder.addLib(new Lib(it.absolutePath, true))
            }
        }

        // add native libraries found in native folder from runtime dependencies
        def iosTmpNativeDir = project.file("${project.jfxmobile.ios.temporaryDirectory}/native")
        if (iosTmpNativeDir.exists() && iosTmpNativeDir.isDirectory()) {
            project.files(iosTmpNativeDir.listFiles()).each {
                project.logger.info("Adding native library from runtime dependency: ${it}")
                builder.addLib(new Lib(it.absolutePath, true))
            }
        }

        builder.addForceLinkClass("javafx.**.*")
                .addForceLinkClass("com.sun.**.*")
                .addForceLinkClass("com.android.**.*")
                .addForceLinkClass("org.apache.harmony.security.provider.**.*")
                .addForceLinkClass("sun.util.logging.PlatformLogger")
                .addForceLinkClass("java.util.logging.**.*")
        project.jfxmobile.ios.forceLinkClasses.each {
            builder.addForceLinkClass(it)
        }

        builder.addFramework("UIKit")
                .addFramework("OpenGLES")
                .addFramework("QuartzCore")
                .addFramework("CoreGraphics")
                .addFramework("CoreText")
                .addFramework("ImageIO")
                .addFramework("MobileCoreServices")
                .addFramework("CoreBluetooth")
                .addFramework("CoreLocation")
                .addFramework("CoreMedia")
                .addFramework("CoreMotion")
                .addFramework("AVFoundation")
                .addFramework("AudioToolbox")
                .addFramework("MediaPlayer")

        return builder
    }

    protected AppCompiler compile(Config config) {
        AppCompiler compiler = new AppCompiler(config)
        compiler.build()

        return compiler
    }

    /**
     * Generate a default Info.plist if target is ios.
     */
    protected Config configureDefaultInfoPList(Config.Builder builder, Config config) {
        if (IOSTarget.TYPE.equals(config.targetType) ||
            (!ConsoleTarget.TYPE.equals(config.targetType) && config.os == OS.ios)) {
            builder.iosInfoPList(createDefaultInfoPList(config))
            return builder.build()
        } else {
            return config
        }
    }

    private File createDefaultInfoPList(Config config) {
        def sdk
        String sdkVersion = config.iosSdkVersion
        List<SDK> sdks = config.target.getSDKs()
        if (sdkVersion == null) {
            if (sdks.isEmpty()) {
                throw new IllegalArgumentException("No " + (IOSTarget.isDeviceArch(arch) ? "device" : "simulator") + " SDKs installed")
            }
            Collections.sort(sdks)
            sdk = sdks.get(sdks.size() - 1)
        } else {
            for (SDK availableSdk : sdks) {
                if (availableSdk.getVersion().equals(sdkVersion)) {
                    sdk = availableSdk
                    break
                }
            }
            if (sdk == null) {
                throw new IllegalArgumentException("No SDK found matching version string " + sdkVersion)
            }
        }

        def families = []
        NSObject supportedDeviceFamilies = sdk.getDefaultProperty("SUPPORTED_DEVICE_FAMILIES")
        if (supportedDeviceFamilies != null) {
            // SUPPORTED_DEVICE_FAMILIES is either a NSString of comma separated numbers
            // or an NSArray with NSStrings. UIDeviceFamily values should be NSNumbers.
            if (supportedDeviceFamilies instanceof NSString) {
                NSString defFamilies = (NSString) supportedDeviceFamilies
                defFamilies.toString().split(",").each {
                    families.add(it.trim().toInteger())
                }
            } else {
                NSArray defFamilies = (NSArray) supportedDeviceFamilies
                for (int i = 0; i < defFamilies.count(); i++) {
                    families.add(defFamilies.objectAtIndex(i).toString().toInteger())
                }
            }
        }

        config.tmpDir.mkdirs()
        File defaultInfoPList = new File(config.tmpDir, "Default-Info.plist")
        defaultInfoPList.withWriter { out ->
            out.writeLine("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            out.writeLine("<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">")
            out.writeLine("<plist version=\"1.0\">")
            out.writeLine("<dict>")
            out.writeLine("\t<key>CFBundleIdentifier</key>")
            out.writeLine("\t<string>${project.mainClassName}</string>")
            out.writeLine("\t<key>CFBundleVersion</key>")
            out.writeLine("\t<string>1.0</string>")
            out.writeLine("\t<key>CFBundleExecutable</key>")
            out.writeLine("\t<string>${config.executableName}</string>")
            out.writeLine("\t<key>CFBundleName</key>")
            out.writeLine("\t<string>${config.executableName}</string>")
            out.writeLine("\t<key>CFBundlePackageType</key>")
            out.writeLine("\t<string>APPL</string>")
            out.writeLine("\t<key>LSRequiresIPhoneOS</key>")
            out.writeLine("\t<true/>")
            out.writeLine("\t<key>UISupportedInterfaceOrientations</key>")
            out.writeLine("\t<array>")
            out.writeLine("\t\t<string>UIInterfaceOrientationPortrait</string>")
            out.writeLine("\t\t<string>UIInterfaceOrientationLandscapeLeft</string>")
            out.writeLine("\t\t<string>UIInterfaceOrientationLandscapeRight</string>")
            out.writeLine("\t\t<string>UIInterfaceOrientationPortraitUpsideDown</string>")
            out.writeLine("\t</array>")
            out.writeLine("\t<key>UISupportedInterfaceOrientations~ipad</key>")
            out.writeLine("\t<array>")
            out.writeLine("\t\t<string>UIInterfaceOrientationPortrait</string>")
            out.writeLine("\t\t<string>UIInterfaceOrientationLandscapeLeft</string>")
            out.writeLine("\t\t<string>UIInterfaceOrientationLandscapeRight</string>")
            out.writeLine("\t\t<string>UIInterfaceOrientationPortraitUpsideDown</string>")
            out.writeLine("\t</array>")
            out.writeLine("\t<key>UIRequiredDeviceCapabilities</key>")
            out.writeLine("\t<array>")
            out.writeLine("\t\t<string>armv7</string>")
            out.writeLine("\t</array>")
            out.writeLine("\t<key>UIDeviceFamily</key>")
            out.writeLine("\t<array>")
            families.each {
                out.writeLine("\t\t<integer>${it}</integer>")
            }
            out.writeLine("\t</array>")
            out.writeLine("</dict>")
            out.writeLine("</plist>")
        }
        return defaultInfoPList
    }

    private Logger robovmLogger
    private Logger createLogger() {
        if (robovmLogger == null) {
            robovmLogger = new Logger() {
                @Override
                void debug(String log, Object...objs) {
                    logger.debug(String.format(log, objs))
                }

                @Override
                void info(String log, Object...objs) {
                    logger.info(String.format(log, objs))
                }

                @Override
                void warn(String log, Object...objs) {
                    logger.warn(String.format(log, objs))
                }

                @Override
                void error(String log, Object...objs) {
                    logger.error(String.format(log, objs))
                }
            }
        }
        return robovmLogger
    }

}
