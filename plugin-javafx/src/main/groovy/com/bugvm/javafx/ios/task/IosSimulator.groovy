package com.bugvm.javafx.ios.task

import org.gradle.api.GradleException
import com.bugvm.compiler.AppCompiler
import com.bugvm.compiler.config.Arch
import com.bugvm.compiler.config.Config
import com.bugvm.compiler.config.OS
import com.bugvm.compiler.target.ios.DeviceType
import com.bugvm.compiler.target.ios.DeviceType.DeviceFamily;
import com.bugvm.compiler.target.ios.IOSSimulatorLaunchParameters
import com.bugvm.compiler.target.ios.IOSTarget

/**
 *
 * @author joeri
 */
abstract class IosSimulator extends BaseIosTask {

    protected void launch(DeviceType deviceType) {
        Config.Builder builder = configure(new Config.Builder())
                .os(OS.ios)
                .arch(getArch())
                .targetType(IOSTarget.TYPE)

        Config config = builder.build()
        if (config.iosInfoPList == null) {
            config = configureDefaultInfoPList(builder, config)
        }

        project.logger.info("ios simulator os ${config.os}")
        project.logger.info("ios simulator target ${config.target}")
        project.logger.info("ios simulator arch ${config.arch}")
        project.logger.info("ios simulator device type ${deviceType}")
        project.logger.info("ios simulator device classpath entries ${config.classpath}")
        project.logger.info("ios simulator device force link classes ${config.forceLinkClasses}")
        project.logger.info("ios simulator device libs ${config.libs}")

        AppCompiler compiler = compile(config)

        IOSSimulatorLaunchParameters launchParameters = config.target.createLaunchParameters()
        launchParameters.deviceType = deviceType

        if (project.jfxmobile.ios.stdoutFifo != null) {
            File stdoutFifo = project.file(project.jfxmobile.ios.stdoutFifo)
            boolean isWritable
            
            if (stdoutFifo.exists()) {
                isWritable = stdoutFifo.isFile() && stdoutFifo.canWrite()
            } else {
                File parent = stdoutFifo.parentFile
                isWritable = parent != null && parent.isDirectory() && parent.canWrite()
            }

            if (!isWritable) {
                throw new GradleException("Unwritable 'stdoutFifo' specified for BugVM compile: ${stdoutFifo}")
            }

            launchParameters.stdoutFifo = stdoutFifo
        }

        if (project.jfxmobile.ios.stderrFifo != null) {
            File stderrFifo = project.file(project.jfxmobile.ios.stderrFifo)
            boolean isWritable
            
            if (stderrFifo.exists()) {
                isWritable = stderrFifo.isFile() && stderrFifo.canWrite()
            } else {
                File parent = stderrFifo.parentFile
                isWritable = parent != null && parent.isDirectory() && parent.canWrite()
            }

            if (!isWritable) {
                throw new GradleException("Unwritable 'stderrFifo' specified for BugVM compile: ${stderrFifo}")
            }

            launchParameters.stderrFifo = stderrFifo
        }

        compiler.launch(launchParameters)
    }

    private Arch getArch() {
        def Arch arch = Arch.x86
        if (project.jfxmobile.ios.arch && project.jfxmobile.ios.arch.equals(Arch.x86_64.name())) {
            arch = Arch.valueOf(project.jfxmobile.ios.arch)
        }
        return arch
    }

    protected DeviceType getDeviceType(DeviceFamily deviceFamily) {
        return DeviceType.getBestDeviceType(getArch(), deviceFamily, project.properties.get("bugvm.device.name"), project.properties.get("bugvm.sdk.version"))
    }

}
