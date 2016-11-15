package org.javafxports.jfxmobile.plugin.ios.task

import org.gradle.api.tasks.TaskAction
import org.robovm.compiler.AppCompiler
import org.robovm.compiler.config.Arch
import org.robovm.compiler.config.Config
import org.robovm.compiler.config.OS
import org.robovm.compiler.target.ios.IOSTarget

/**
 *
 * @author joeri
 */
class IosDevice extends BaseIosTask {

    @TaskAction
    void iosDevice() {
        Config.Builder builder = configure(new Config.Builder())
                .os(OS.ios)
                .arch(Arch.valueOf(project.jfxmobile.ios.arch))
                .targetType(IOSTarget.TYPE)

        Config config = builder.build()
        if (config.iosInfoPList == null) {
            config = configureDefaultInfoPList(builder, config)
        }

        project.logger.info("ios device os ${config.os}")
        project.logger.info("ios device target ${config.target}")
        project.logger.info("ios device arch ${config.arch}")
        project.logger.info("ios device classpath entries ${config.classpath}")
        project.logger.info("ios device force link classes ${config.forceLinkClasses}")
        project.logger.info("ios device libs ${config.libs}")

        AppCompiler compiler = compile(config)
        compiler.launch(config.target.createLaunchParameters())
    }

}

