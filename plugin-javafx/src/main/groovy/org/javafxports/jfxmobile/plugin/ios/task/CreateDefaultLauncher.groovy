package org.javafxports.jfxmobile.plugin.ios.task

import java.nio.charset.StandardCharsets
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 * Copies the default launcher class from the plugin's classpath to a temporary
 * ios sources folder. It also replaces the strings "<mainClassName>" and
 * "<preloaderClassName>" in the file with the mainClassName and
 * preloaderClassName of the project respectively.
 *
 * @author joeri
 */
class CreateDefaultLauncher extends DefaultTask {

    @Input
    String mainClassName

    @Input
    @Optional
    String preloaderClassName

    @OutputFile
    File outputFile

    @TaskAction
    void createDefaultLauncher() {
        File basicLauncherSourceFile = getOutputFile()
        InputStream originalLauncherSourceFile = getClass().getClassLoader().getResourceAsStream('ios/sources/BasicLauncher.java')
        if (originalLauncherSourceFile != null) {
            String basicLauncherSourceString = originalLauncherSourceFile.getText(StandardCharsets.UTF_8.name())
            basicLauncherSourceString = basicLauncherSourceString.replaceAll('<mainClassName>', "${getMainClassName()}.class")
            if (getPreloaderClassName() != null && !getPreloaderClassName().empty) {
                basicLauncherSourceString = basicLauncherSourceString.replaceAll("<preloaderClassName>", "${getPreloaderClassName()}.class")
            } else {
                basicLauncherSourceString = basicLauncherSourceString.replaceAll("<preloaderClassName>", "null")
            }

            basicLauncherSourceFile.write(basicLauncherSourceString, StandardCharsets.UTF_8.name())
        }
    }

}

