package org.javafxports.jfxmobile.plugin.android.task

import com.android.build.gradle.tasks.ResourceException
import com.android.ide.common.res2.AssetMerger
import com.android.ide.common.res2.AssetSet
import com.android.ide.common.res2.MergedAssetWriter
import com.android.ide.common.res2.MergingException
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

/**
 *
 * @author joeri
 */
class MergeAssets extends DefaultTask {

    @OutputDirectory
    File outputDir

    List<AssetSet> inputAssetSets

    @TaskAction
    void mergeAssets() {
        List<AssetSet> assetSets = getInputAssetSets()
        AssetMerger merger = new AssetMerger()

        try {
            assetSets.each {
                it.loadFromFiles(null)
                merger.addDataSet(it)
            }

            MergedAssetWriter writer = new MergedAssetWriter(getOutputDir())
            merger.mergeData(writer, false)
        } catch (MergingException ex) {
            throw new ResourceException(ex.message, ex)
        }
    }

}

