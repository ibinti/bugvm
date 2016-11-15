package com.bugvm.javafx.ios.task

import org.gradle.api.tasks.TaskAction
import com.bugvm.compiler.AppCompiler
import com.bugvm.compiler.config.Arch
import com.bugvm.compiler.config.Config
import com.bugvm.compiler.target.ios.IOSTarget


/**
 *
 * @author joeri
 */
class CreateIpa extends BaseIosTask {

    @TaskAction
    void createIpa() {
        def finalIpaArchs = []
        if (project.hasProperty("bugvm.ipaArchs")) {
            String propIpaArchs = project.properties.get("bugvm.ipaArchs")
            if (!propIpaArchs.trim().isEmpty()) {
                propIpaArchs.trim().split(':').each {
                    finalIpaArchs.add(Arch.valueOf(it))
                }
            }
        } else {
            List<String> extIpaArchs = project.jfxmobile.ios.ipaArchs
            if (extIpaArchs != null && !extIpaArchs.isEmpty()) {
                extIpaArchs.each {
                    finalIpaArchs.add(Arch.valueOf(it))
                }
            }
        }

        Config.Builder builder = configure(new Config.Builder())
                .skipInstall(false)
                .targetType(IOSTarget.TYPE)

        if (!finalIpaArchs.isEmpty()) {
            builder.archs(finalIpaArchs)
        }

        Config config = builder.build()
        if (config.iosInfoPList == null) {
            config = configureDefaultInfoPList(builder, config)
        }

        if (finalIpaArchs.isEmpty()) {
            finalIpaArchs = config.target.getDefaultArchs()
        }

        project.logger.info("ipa os ${config.os}")
        project.logger.info("ipa target ${config.target}")
        project.logger.info("ipa archs ${finalIpaArchs}")
        project.logger.info("ipa classpath entries ${config.classpath}")
        project.logger.info("ipa force link classes ${config.forceLinkClasses}")
        project.logger.info("ipa libs ${config.libs}")

        AppCompiler compiler = new AppCompiler(config)
        
        compiler.build()
        compiler.archive()
    }

}
