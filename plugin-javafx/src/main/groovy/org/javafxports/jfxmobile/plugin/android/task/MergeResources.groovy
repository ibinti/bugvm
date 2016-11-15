package org.javafxports.jfxmobile.plugin.android.task

import com.android.build.gradle.tasks.ResourceException
import com.android.ide.common.res2.MergedResourceWriter
import com.android.ide.common.res2.MergingException
import com.android.ide.common.res2.ResourceMerger
import com.android.ide.common.res2.ResourceSet
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

/**
 *
 * @author joeri
 */
class MergeResources extends DefaultTask {

    @OutputDirectory
    File outputDir

    List<ResourceSet> inputResourceSets

    @InputFile
    File aaptExe

    @Input
    boolean insertSourceMarkers = true

    @TaskAction
    void mergeResoures() {
        AaptSingleCruncher pngCruncher = new AaptSingleCruncher(project, getAaptExe())

        List<ResourceSet> resourceSets = getInputResourceSets()
        ResourceMerger merger = new ResourceMerger()

        try {
            resourceSets.each {
                it.loadFromFiles(null)
                merger.addDataSet(it)
            }

            MergedResourceWriter writer = new MergedResourceWriter(getOutputDir(), pngCruncher, true, true)
            writer.setInsertSourceMarkers(getInsertSourceMarkers())
            merger.mergeData(writer, false)
        } catch (MergingException ex) {
            throw new ResourceException(ex.message, ex)
        }
    }

}

