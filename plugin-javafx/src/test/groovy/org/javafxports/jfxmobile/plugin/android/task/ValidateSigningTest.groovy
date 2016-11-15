package org.javafxports.jfxmobile.plugin.android.task

import com.android.prefs.AndroidLocation
import com.android.prefs.AndroidLocation.EnvVar
import org.gradle.api.Project
import org.gradle.internal.reflect.DirectInstantiator
import org.gradle.testfixtures.ProjectBuilder
import org.javafxports.jfxmobile.plugin.BasicTest
import org.javafxports.jfxmobile.plugin.JFXMobileExtension
import static org.junit.Assert.*
import org.junit.Test

/**
 *
 */
class ValidateSigningTest extends BasicTest {

    @Test
    void testValidateWithNullStoreFile() {
        Project project = ProjectBuilder.builder().build()

        project.extensions.create("jfxmobile", JFXMobileExtension, project, DirectInstantiator.INSTANCE)

        project.jfxmobile.android.signingConfig.setStoreFile(null)

        ValidateSigning validateSigningTask = project.tasks.create("validateSigning", ValidateSigning)
        validateSigningTask.signingConfig = project.jfxmobile.android.signingConfig

        validateSigningTask.validate()
    }

    @Test
    void testValidateWithNonExistingStoreFile() {
        File androidHome = File.createTempFile("androidhome_${ValidateSigning.class.simpleName}_", null)
        androidHome.delete()
        androidHome.mkdirs()

        String oldAndroidHome = System.getProperty(EnvVar.ANDROID_SDK_HOME.name)
        System.setProperty(EnvVar.ANDROID_SDK_HOME.name, androidHome.absolutePath)
        AndroidLocation.resetFolder()

        Project project = ProjectBuilder.builder().build()

        project.extensions.create("jfxmobile", JFXMobileExtension, project, DirectInstantiator.INSTANCE)

        String uuid = UUID.randomUUID().toString()
        File storeFile = project.file("${AndroidLocation.folder}/debug.keystore")
        project.jfxmobile.android.signingConfig.setStoreFile(storeFile)
        project.jfxmobile.android.signingConfig.setStorePassword("android")
        project.jfxmobile.android.signingConfig.setKeyPassword("android")
        project.jfxmobile.android.signingConfig.setKeyAlias("android")

        assertFalse(storeFile.exists())

        ValidateSigning validateSigningTask = project.tasks.create("validateSigning", ValidateSigning)
        validateSigningTask.signingConfig = project.jfxmobile.android.signingConfig

        validateSigningTask.validate()

        assertTrue(storeFile.exists())

        if (oldAndroidHome == null) {
            System.clearProperty(EnvVar.ANDROID_SDK_HOME.name)
        } else {
            System.setProperty(EnvVar.ANDROID_SDK_HOME.name, oldAndroidHome)
        }
        AndroidLocation.resetFolder()
        deleteDir(androidHome)
    }

}
