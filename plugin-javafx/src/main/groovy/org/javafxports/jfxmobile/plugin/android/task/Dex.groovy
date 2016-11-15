package org.javafxports.jfxmobile.plugin.android.task

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.javafxports.jfxmobile.plugin.android.JFXMobileDexOptions

/**
 *
 * @author joeri
 */
class Dex extends DefaultTask {

    @Nested
    JFXMobileDexOptions dexOptions

    @InputFile
    File mainDexListFile

    @InputFile
    File inputListFile

    @OutputDirectory
    File outputDirectory

    @TaskAction
    void dex() {
        project.ant.java(outputproperty: "dexCmdOut",
            errorProperty: "dexCmdErr",
            resultProperty : "dexResult",
            classname: "com.android.dx.command.Main",
            fork: true,
            classpath: project.jfxmobile.android.buildToolsLib.absolutePath + "/dx.jar") {
            if (getDexOptions().javaMaxHeapSize != null) {
                jvmarg(value: "-Xmx${getDexOptions().javaMaxHeapSize}")
            } else {
                jvmarg(value: "-Xmx2g")
            }
            arg(value: "--dex")
            if (project.logger.debugEnabled) {
                arg(value: "--debug")
            }
            arg(value: "--verbose")
            if (getDexOptions().jumboMode) {
                args(value: "--force-jumbo")
            }
            getDexOptions().additionalParameters.each {
                arg(value: it)
            }
            arg(value: "--no-optimize")
            arg(value: "--multi-dex")
            arg(value: "--main-dex-list=" + getMainDexListFile().absolutePath)
            arg(value: "--core-library")
            arg(value: "--output=" + getOutputDirectory().absolutePath)
            arg(value: "--input-list=" + getInputListFile().absolutePath)
        }

        project.logger.debug("Dex result value = ${project.ant.project.properties.dexResult}")
        if (project.ant.project.properties.dexResult != "0") {
            throw new GradleException(project.ant.project.properties.dexCmdErr)
        }
    }

}

