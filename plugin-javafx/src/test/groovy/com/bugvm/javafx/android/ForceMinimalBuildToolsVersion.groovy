package com.bugvm.javafx.android

import com.android.prefs.AndroidLocation
import com.android.prefs.AndroidLocation.EnvVar
import org.gradle.internal.reflect.DirectInstantiator

import java.nio.file.Paths
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import com.bugvm.javafx.BasicTest
import com.bugvm.javafx.JFXMobileExtension
import org.junit.After
import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 *
 * @author joeri
 */
class ForceMinimalBuildToolsVersion extends BasicTest {

    private String oldAndroidHome
    private File androidHome
    private Project project

    @Before
    void beforeTest() {
        androidHome = File.createTempFile("androidhome_${ForceMinimalBuildToolsVersion.class.simpleName}_", null)
        androidHome.delete()
        androidHome.mkdirs()

        Paths.get(androidHome.absolutePath, "build-tools", "19.1.0").toFile().mkdirs()
        Paths.get(androidHome.absolutePath, "build-tools", "23.0.1").toFile().mkdirs()
        Paths.get(androidHome.absolutePath, "build-tools", "24.0.1").toFile().mkdirs()
        Paths.get(androidHome.absolutePath, "build-tools", "19.1.0", "aapt").toFile().createNewFile()
        Paths.get(androidHome.absolutePath, "build-tools", "23.0.1", "aapt").toFile().createNewFile()
        Paths.get(androidHome.absolutePath, "build-tools", "24.0.1", "aapt").toFile().createNewFile()

        Paths.get(androidHome.absolutePath, "platforms", "android-21").toFile().mkdirs()

        oldAndroidHome = System.getProperty(EnvVar.ANDROID_SDK_HOME.name)
        System.setProperty(EnvVar.ANDROID_SDK_HOME.name, androidHome.absolutePath)
        AndroidLocation.resetFolder()

        project = ProjectBuilder.builder().build()

        project.extensions.create("jfxmobile", JFXMobileExtension, project, DirectInstantiator.INSTANCE)
        project.jfxmobile.android.androidSdk = androidHome.absolutePath
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
    void testLowerMinimalBuildToolsVersionSet() {
        project.jfxmobile.android.buildToolsVersion = "19.1.0"
        project.jfxmobile.android.buildToolsDir = Paths.get(androidHome.absolutePath, "build-tools", "19.1.0").toFile()
        project.jfxmobile.android.buildToolsLib = Paths.get(androidHome.absolutePath, "build-tools", "19.1.0", "lib").toFile()

        try {
            project.jfxmobile.android.validate()
            fail("GradleException should have been thrown.")
        } catch (GradleException e) {
            println e.message
        }
    }

    @Test
    void testEqualMinimalBuildToolsVersionSet() {
        project.jfxmobile.android.buildToolsVersion = "23.0.1"
        project.jfxmobile.android.buildToolsDir = Paths.get(androidHome.absolutePath, "build-tools", "23.0.1").toFile()
        project.jfxmobile.android.buildToolsLib = Paths.get(androidHome.absolutePath, "build-tools", "23.0.1", "lib").toFile()

        project.jfxmobile.android.validate()
    }

    @Test
    void testHigherMinimalBuildToolsVersionSet() {
        project.jfxmobile.android.buildToolsVersion = "24.0.1"
        project.jfxmobile.android.buildToolsDir = Paths.get(androidHome.absolutePath, "build-tools", "24.0.1").toFile()
        project.jfxmobile.android.buildToolsLib = Paths.get(androidHome.absolutePath, "build-tools", "24.0.1", "lib").toFile()

        project.jfxmobile.android.validate()
    }

}
