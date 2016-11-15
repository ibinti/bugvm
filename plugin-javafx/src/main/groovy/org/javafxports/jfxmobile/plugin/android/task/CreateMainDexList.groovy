package org.javafxports.jfxmobile.plugin.android.task

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.javafxports.jfxmobile.plugin.android.JFXMobileDexOptions

/**
 *
 * @author joeri
 */
class CreateMainDexList extends DefaultTask {

    @Nested
    JFXMobileDexOptions dexOptions

    @InputFile
    File componentsClassesJarFile

    @InputFile
    File allClassesJarFile

    @OutputFile
    File outputFile

    @TaskAction
    void createMainDexList() {
        project.ant.java(outputproperty: "createMainDexListCmdOut",
            errorProperty: "createMainDexListCmdErr",
            resultProperty: "createMainDexListResult",
            classname: "com.android.multidex.ClassReferenceListBuilder",
            fork: true,
            classpath: project.jfxmobile.android.buildToolsLib.absolutePath + "/dx.jar") {
            jvmarg(value: "-Xmx1024M")
            if (!getDexOptions().keepRuntimeAnnotatedClasses) {
                arg(value: "--disable-annotation-resolution-workaround")
            }
            arg(value: getComponentsClassesJarFile())
            arg(value: getAllClassesJarFile())
        }

        project.logger.debug("CreateMainDexList result value = ${project.ant.project.properties.createMainDexListResult}")
        if (project.ant.project.properties.createMainDexListResult != "0") {
            throw new GradleException(project.ant.project.properties.createMainDexListCmdErr)
        } else {
            getOutputFile().text = project.ant.project.properties.createMainDexListCmdOut
        }
    }

}

