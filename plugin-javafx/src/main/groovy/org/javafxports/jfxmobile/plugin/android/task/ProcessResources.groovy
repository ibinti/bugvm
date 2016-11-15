package org.javafxports.jfxmobile.plugin.android.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 *
 * @author joeri
 */
class ProcessResources extends DefaultTask {

    @InputFile
    File manifest

    @InputDirectory @Optional
    File resDir

    @InputDirectory @Optional
    File assetsDir

    @OutputFile
    File packageOutputFile

    @InputFile
    File aaptExe

    boolean debuggable

    @TaskAction
    void processResources() {
        project.exec {
            executable = getAaptExe()
            args 'package'
            args '-f'
            args '--no-crunch'
            args '-I', "${project.jfxmobile.android.androidSdk}/platforms/android-${project.jfxmobile.android.compileSdkVersion}/android.jar"
            args '-M', getManifest().absolutePath
            args '-S', getResDir().absolutePath
            args '-A', getAssetsDir().absolutePath
            args '-F', getPackageOutputFile().absolutePath
            if (isDebuggable()) {
                args '--debug-mode'
            }
            args '-0'
            args 'apk'
        }
    }

}

