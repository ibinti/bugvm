package org.javafxports.jfxmobile.plugin.android.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class WriteDexInputListFile extends DefaultTask {

    @InputFile
    File jar

    @OutputFile
    File inputListFile

    @TaskAction
    void writeInputListFile() {
        getInputListFile().text = getJar().absolutePath
    }
}
