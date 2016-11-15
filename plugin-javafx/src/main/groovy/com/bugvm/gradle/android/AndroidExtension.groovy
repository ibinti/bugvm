package com.bugvm.gradle.android

import com.android.build.gradle.internal.dsl.PackagingOptions
import com.android.build.gradle.internal.dsl.SigningConfig
import com.android.sdklib.repository.FullRevision
import org.gradle.api.GradleException
import org.gradle.api.Project

/**
 *
 * @author joeri
 */
class AndroidExtension {

    Project project

    String androidSdk
    String compileSdkVersion = "21"
    String minSdkVersion = "4"
    String targetSdkVersion
    boolean preview
    FullRevision minimalBuildToolsVersion = new FullRevision(23, 0, 1)
    String buildToolsVersion
    File buildToolsDir
    File buildToolsLib

    String dalvikSdk
    File dalvikSdkLib

    String assetsDirectory = 'src/android/assets'
    String resDirectory = 'src/android/res'
    String nativeDirectory = 'src/android/jniLibs'

    File installDirectory
    File temporaryDirectory
    File resourcesDirectory
    File multidexOutputDirectory
    File dexOutputDirectory

    String applicationPackage
    String manifest
    String proguardFile

    public AndroidExtension(Project project) {
        this.project = project

        extensions.create("signingConfig", SigningConfig, 'signing')
        extensions.create("packagingOptions", PackagingOptions)
        extensions.create("dexOptions", JFXMobileDexOptions)

        installDirectory = new File(project.buildDir, "javafxports/android")
        installDirectory.deleteDir()
        installDirectory.mkdirs()
        project.logger.info("Android install directory: " + installDirectory)

        temporaryDirectory = new File(project.buildDir, "javafxports/tmp/android")
        temporaryDirectory.deleteDir()
        temporaryDirectory.mkdirs()
        project.logger.info("Android temporary output directory: " + temporaryDirectory)

        resourcesDirectory = new File(temporaryDirectory, "resources")
        resourcesDirectory.mkdirs()
        project.logger.info("Resources directory: " + resourcesDirectory)

        multidexOutputDirectory = new File(temporaryDirectory, "multi-dex")
        multidexOutputDirectory.mkdirs()
        project.logger.info("Multi-dex output directory: " + multidexOutputDirectory)

        dexOutputDirectory = new File(temporaryDirectory, "dex")
        dexOutputDirectory.mkdirs()
        project.logger.info("Dex output directory: " + dexOutputDirectory)
    }

    String getMinSdkVersion() {
        if (minSdkVersion == null || minSdkVersion.isEmpty()) {
            return "4"
        }
        return minSdkVersion
    }

    String getTargetSdkVersion() {
        if (targetSdkVersion == null || targetSdkVersion.isEmpty()) {
            return compileSdkVersion
        }
        return targetSdkVersion
    }

    /**
     * Checks whether the properties on the android extension are valid after
     * everything was configured.
     */
    void validate() {
        // check if android build tool version is at least minimal required version
        FullRevision revBuildToolsVersion = FullRevision.parseRevision(buildToolsVersion)
        if (minimalBuildToolsVersion.compareTo(revBuildToolsVersion) > 0) {
            throw new GradleException("Android buildToolsVersion should be at least version ${minimalBuildToolsVersion}: currently using ${buildToolsVersion} from ${buildToolsDir}. See https://developer.android.com/studio/intro/update.html on how to update the build tools in the Android SDK.")
        }

        // check if valid android build tools exists
        if (! project.file("${buildToolsDir}/aapt").exists() &&
            ! project.file("${buildToolsDir}/aapt.exe").exists()) {
            throw new GradleException("Configured buildToolsVersion is invalid: ${buildToolsVersion} (${buildToolsDir})")
        }

        // check if android platform exists
        if (!project.file("${androidSdk}/platforms/android-${compileSdkVersion}").exists()) {
            throw new GradleException("Configured compileSdkVersion is invalid: ${compileSdkVersion} (${androidSdk}/platforms/android-${compileSdkVersion}")
        }
    }

}
