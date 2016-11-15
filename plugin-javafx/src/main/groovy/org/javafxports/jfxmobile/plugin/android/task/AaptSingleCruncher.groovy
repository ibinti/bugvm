package org.javafxports.jfxmobile.plugin.android.task

import com.android.ide.common.internal.PngCruncher
import com.android.ide.common.internal.PngException
import org.gradle.api.Project

/**
 *
 */
class AaptSingleCruncher implements PngCruncher {

    private Project project
    private File aaptExe

    AaptSingleCruncher(Project project, File aaptExe) {
        this.project = project
        this.aaptExe = aaptExe
    }

    void crunchPng(File from, File to) throws PngException {
        this.project.exec {
            executable = this.aaptExe
            args 'singleCrunch'
            args '-i', from.absolutePath
            args '-o', to.absolutePath
        }
    }

    void end() throws InterruptedException {
        // nothing to do, it's all synchronous.
    }

}

