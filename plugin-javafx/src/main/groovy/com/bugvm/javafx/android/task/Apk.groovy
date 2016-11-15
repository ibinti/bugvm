package com.bugvm.javafx.android.task

import com.android.build.gradle.internal.dsl.PackagingOptions
import com.android.build.gradle.internal.dsl.SigningConfig
import com.android.builder.internal.packaging.JavaResourceProcessor
import com.android.builder.internal.packaging.Packager
import com.android.ide.common.signing.CertificateInfo
import com.android.ide.common.signing.KeystoreHelper
import com.android.utils.NullLogger
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 *
 * @author joeri
 */
class Apk extends DefaultTask {

    @InputFile
    File resourceFile

    @InputDirectory
    File dexDirectory

    @InputFiles
    Collection<File> dexedLibraries

    @InputFiles
    Collection<File> jniFolders

    @InputDirectory @Optional
    File mainResourcesDirectory
    @InputDirectory @Optional
    File androidResourcesDirectory

    @Nested @Optional
    SigningConfig signingConfig

    @Nested
    PackagingOptions packagingOptions

    @OutputFile
    File outputFile

    @TaskAction
    void apk() {
        SigningConfig signingConfig = getSigningConfig()

        CertificateInfo certificateInfo = null
        if (signingConfig != null && signingConfig.signingReady) {
                project.logger.info("apk: will be signing with keystore ${signingConfig.getStoreFile()}")
                certificateInfo = KeystoreHelper.getCertificateInfo(signingConfig.getStoreType(),
                    signingConfig.getStoreFile(), signingConfig.getStorePassword(),
                    signingConfig.getKeyPassword(), signingConfig.getKeyAlias())
                if (certificateInfo == null) {
                    throw new GradleException("Failed to read key from keystore")
                }
        } else {
            throw new GradleException("You need to configure a valid signingConfig when releasing an APK.");
        }

        Packager packager = new Packager(getOutputFile().absolutePath, getResourceFile().absolutePath,
                certificateInfo, null, getPackagingOptions(), NullLogger.getLogger())
        packager.addDexFiles(getDexDirectory(), getDexedLibraries())
        packager.setJniDebugMode(false)

        JavaResourceProcessor resourceProcessor = new JavaResourceProcessor(packager)
        if (getMainResourcesDirectory() != null) {
            resourceProcessor.addSourceFolder(getMainResourcesDirectory().absolutePath)
        }
        if (getAndroidResourcesDirectory() != null) {
            resourceProcessor.addSourceFolder(getAndroidResourcesDirectory().absolutePath)
        }

        // add resources for all jar dependencies, except for android platform's android.jar
        project.configurations.androidRuntime.filter {
            it.name.endsWith('.jar') && !it.name.endsWith('android.jar')
        }.each() {
            project.logger.info("apk: adding ${it} to packager.addResourcesFromJar()")
            packager.addResourcesFromJar(project.file(it))
        }

        if (getJniFolders() != null) {
            getJniFolders().each {
                if (it.isDirectory()) {
                    packager.addNativeLibraries(it, null)
                }
            }
        }

        packager.sealApk()
    }

}

