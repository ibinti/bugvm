package com.bugvm.gradle.android

import com.android.prefs.AndroidLocation
import com.android.prefs.AndroidLocation.EnvVar
import org.gradle.internal.reflect.DirectInstantiator

import java.nio.file.Paths
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import com.bugvm.gradle.BasicTest
import com.bugvm.gradle.JFXMobileExtension
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 *
 * @author joeri
 */
class ValidAndroidPlatformVersion extends BasicTest {

    private String oldAndroidHome
    private File androidHome
    private Project project

    @Before
    void beforeTest() {
        androidHome = File.createTempFile("androidhome_${ValidBuildToolsVersion.class.simpleName}_", null)
        androidHome.delete()
        androidHome.mkdirs()

        Paths.get(androidHome.absolutePath, "build-tools", "23.0.3").toFile().mkdirs()
        Paths.get(androidHome.absolutePath, "build-tools", "23.0.3", "aapt").toFile().createNewFile()

        oldAndroidHome = System.getProperty(EnvVar.ANDROID_SDK_HOME.name)
        System.setProperty(EnvVar.ANDROID_SDK_HOME.name, androidHome.absolutePath)
        AndroidLocation.resetFolder()

        project = ProjectBuilder.builder().build()

        project.extensions.create("jfxmobile", JFXMobileExtension, project, DirectInstantiator.INSTANCE)
        project.jfxmobile.android.androidSdk = androidHome.absolutePath
        project.jfxmobile.android.buildToolsVersion = "23.0.3"
        project.jfxmobile.android.compileSdkVersion = "21"
        project.jfxmobile.android.buildToolsDir = Paths.get(androidHome.absolutePath, "build-tools", "23.0.3").toFile()
        project.jfxmobile.android.buildToolsLib = Paths.get(androidHome.absolutePath, "build-tools", "23.0.3", "lib").toFile()
    }

    @After
    void afterTest() {
        if (oldAndroidHome == null) {
            System.clearProperty(EnvVar.ANDROID_SDK_HOME.name)
        } else {
            System.setProperty(EnvVar.ANDROID_SDK_HOME.name, oldAndroidHome)
        }
        AndroidLocation.resetFolder()
        deleteDir(androidHome)
    }

    @Test
    void testInvalidPlatformVersion() {
        try {
            project.jfxmobile.android.validate()
            fail("GradleException should have been thrown.")
        } catch (GradleException e) {
            println e.message
        }
    }

    @Test
    void testValidPlatformVersion() {
        Paths.get(androidHome.absolutePath, "platforms", "android-21").toFile().mkdirs()

        project.jfxmobile.android.validate()
    }
}

