package org.javafxports.jfxmobile.plugin.android.task

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 * Check if provided AndroidManifest.xml file exists if it is specified. When
 * it's not specified, create a default one.
 *
 * @author joeri
 */
class ValidateManifest extends DefaultTask {

    @OutputFile
    File output

    @TaskAction
    void validateManifest() {
        if (project.jfxmobile.android.manifest != null) {
            File manifestFile = project.file(project.jfxmobile.android.manifest)
            if (!manifestFile.exists()) {
                throw new GradleException("Configured manifest file is invalid: ${project.jfxmobile.android.manifest}")
            }

            java.nio.file.Files.copy(manifestFile.toPath(), getOutput().toPath())
        } else {
            def projectVersion = project.version == 'unspecified' ? '1.0' : project.version

            // creating default AndroidManifest.xml
            project.jfxmobile.android.temporaryDirectory.mkdirs()
            if (!getOutput().exists()) {
                getOutput().withWriter { out ->
                    out.writeLine("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                    out.writeLine("<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"${project.jfxmobile.android.applicationPackage}\" android:versionCode=\"1\" android:versionName=\"${projectVersion}\">")
                    out.writeLine("\t<supports-screens android:xlargeScreens=\"true\"/>")
                    out.writeLine("\t<uses-permission android:name=\"android.permission.INTERNET\"/>")
                    out.writeLine("\t<uses-permission android:name=\"android.permission.READ_EXTERNAL_STORAGE\"/>")
                    out.writeLine("\t<uses-permission android:name=\"android.permission.WRITE_EXTERNAL_STORAGE\"/>")
                    out.writeLine("\t<uses-sdk android:minSdkVersion=\"${project.jfxmobile.android.minSdkVersion}\" android:targetSdkVersion=\"${project.jfxmobile.android.targetSdkVersion}\"/>")
                    out.writeLine("\t<application android:label=\"${project.name}\" android:name=\"android.support.multidex.MultiDexApplication\">")
                    out.writeLine("\t\t<activity android:name=\"javafxports.android.FXActivity\" android:label=\"${project.name}\" android:configChanges=\"orientation|screenSize\">")
                    out.writeLine("\t\t\t<meta-data android:name=\"main.class\" android:value=\"${project.mainClassName}\"/>")
                    if (project.preloaderClassName != null && !project.preloaderClassName.empty) {
                        out.writeLine("\t\t\t<meta-data android:name=\"preloader.class\" android:value=\"${project.preloaderClassName}\"/>")
                    }
                    out.writeLine("\t\t\t<meta-data android:name=\"debug.port\" android:value=\"0\"/>")
                    out.writeLine("\t\t\t<intent-filter>")
                    out.writeLine("\t\t\t\t<action android:name=\"android.intent.action.MAIN\"/>")
                    out.writeLine("\t\t\t\t<category android:name=\"android.intent.category.LAUNCHER\"/>")
                    out.writeLine("\t\t\t</intent-filter>")
                    out.writeLine("\t\t</activity>")
                    out.writeLine("\t</application>")
                    out.writeLine("</manifest>")
                }
            }
        }
    }

}

