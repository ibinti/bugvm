package org.javafxports.jfxmobile.plugin.ios

import org.gradle.api.Project
import org.robovm.compiler.config.Arch
import org.robovm.compiler.config.OS

/**
 *
 * @author joeri
 */
class IosExtension {

    Project project

    /**
     * The fully qualified name of the iOS Launcher class.
     */
    String launcherClassName = 'org.javafxports.jfxmobile.ios.BasicLauncher'

    String robovmVersion = '2.2.0'

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

    String robovmSdk

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
        return project.hasProperty("robovm.iosSkipSigning") ?
                project.properties.get("robovm.iosSkipSigning").toBoolean() :
                iosSkipSigning
    }

    String getIosSignIdentity() {
        return project.hasProperty("robovm.iosSignIdentity") ?
                project.properties.get("robovm.iosSignIdentity") :
                iosSignIdentity
    }

    String getIosProvisioningProfile() {
        return project.hasProperty("robovm.iosProvisioningProfile") ?
                project.properties.get("robovm.iosProvisioningProfile") :
                iosProvisioningProfile
    }

    boolean isDebug() {
        return project.hasProperty("robovm.debug") ?
                project.properties.get("robovm.debug").toBoolean() :
                debug
    }

    boolean getDebugPort() {
        return project.hasProperty("robovm.debugPort") ?
                project.properties.get("robovm.debugPort").toInteger() :
                debugPort
    }

    String getOs() {
        return project.hasProperty("robovm.os") ?
                project.properties.get("robovm.os") :
                os
    }

    String getArch() {
        return project.hasProperty("robovm.arch") ?
                project.properties.get("robovm.arch") :
                arch
    }
}
