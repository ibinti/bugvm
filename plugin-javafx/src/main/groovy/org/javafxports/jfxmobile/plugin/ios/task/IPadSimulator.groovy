package org.javafxports.jfxmobile.plugin.ios.task

import org.gradle.api.tasks.TaskAction
import org.robovm.compiler.target.ios.DeviceType.DeviceFamily;

/**
 *
 * @author joeri
 */
class IPadSimulator extends IosSimulator {

    @TaskAction
    void ipadSimulator() {
        launch(getDeviceType(DeviceFamily.iPad))
    }

}
