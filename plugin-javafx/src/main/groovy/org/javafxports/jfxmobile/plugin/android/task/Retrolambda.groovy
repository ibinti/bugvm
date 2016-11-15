package org.javafxports.jfxmobile.plugin.android.task

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.javafxports.jfxmobile.plugin.RetrolambdaExec

/**
 * Applies retrolambda on the provided input and outputs to the provided output
 */
class Retrolambda extends DefaultTask {

    @InputFiles @Optional
    FileCollection classpath

    @InputDirectory
    File retrolambdaInput

    @OutputDirectory
    File retrolambdaOutput

    @TaskAction
    void retrolambda() {
        def exec = new RetrolambdaExec(project)
        exec.inputDir = getRetrolambdaInput()
        exec.outputDir = getRetrolambdaOutput()

        exec.bytecodeVersion = 50

        if (getClasspath() == null || getClasspath().empty) {
            exec.retrolambdaClasspath = project.files(getRetrolambdaInput())
        } else {
            exec.retrolambdaClasspath = project.files(getRetrolambdaInput(), getClasspath())
        }

        exec.defaultMethods = true

        exec.jvmArgs = []
        exec.exec()
    }
}
