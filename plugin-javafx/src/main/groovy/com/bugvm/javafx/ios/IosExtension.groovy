package com.bugvm.javafx.ios

import org.gradle.api.Project
import com.bugvm.compiler.config.Arch
import com.bugvm.compiler.config.OS

/**
 *
 * @author joeri
 */
class IosExtension {

    Project project

    /**
     * The fully qualified name of the iOS Launcher class.
     */
    String launcherClassName = 'com.bugvm.javafx.ios.BasicLauncher'

    String bugvmVersion = '1.2.1-SNAPSHOT'

    String os = OS.ios.name()
    String arch = Arch.thumbv7.name()
    List<String> ipaArchs

    String propertiesFile
    String configFile

    String stdoutFifo
    String stderrFifo

    List<String> forceLinkClasses = []

    File infoPList

    String iosSdk
    File iosSdkLib

    String bugvmSdk

    String assetsDirectory = 'src/ios/assets'
    String nativeDirectory = 'src/ios/jniLibs'

    File installDirectory
    File temporaryDirectory

    boolean iosSkipSigning = false
    String iosSignIdentity
    String iosProvisioningProfile

    boolean debug = false
    int debugPort = -1

    public IosExtension(Project project) {
        this.project = project

        installDirectory = new File(project.buildDir, "javafxports/ios")
        project.logger.info("iOS install directory: " + installDirectory)

        temporaryDirectory = new File(project.buildDir, "javafxports/tmp/ios")
        project.logger.info("iOS temporary output directory: " + temporaryDirectory)
    }

    boolean isIosSkipSigning() {
        return project.hasProperty("bugvm.iosSkipSigning") ?
                project.properties.get("bugvm.iosSkipSigning").toBoolean() :
                iosSkipSigning
    }

    String getIosSignIdentity() {
        return project.hasProperty("bugvm.iosSignIdentity") ?
                project.properties.get("bugvm.iosSignIdentity") :
                iosSignIdentity
    }

    String getIosProvisioningProfile() {
        return project.hasProperty("bugvm.iosProvisioningProfile") ?
                project.properties.get("bugvm.iosProvisioningProfile") :
                iosProvisioningProfile
    }

    boolean isDebug() {
        return project.hasProperty("bugvm.debug") ?
                project.properties.get("bugvm.debug").toBoolean() :
                debug
    }

    boolean getDebugPort() {
        return project.hasProperty("bugvm.debugPort") ?
                project.properties.get("bugvm.debugPort").toInteger() :
                debugPort
    }

    String getOs() {
        return project.hasProperty("bugvm.os") ?
                project.properties.get("bugvm.os") :
                os
    }

    String getArch() {
        return project.hasProperty("bugvm.arch") ?
                project.properties.get("bugvm.arch") :
                arch
    }
}
