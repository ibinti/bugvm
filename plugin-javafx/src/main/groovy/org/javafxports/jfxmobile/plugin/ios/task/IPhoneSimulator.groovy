package org.javafxports.jfxmobile.plugin.ios.task

import org.gradle.api.tasks.TaskAction
import org.robovm.compiler.target.ios.DeviceType.DeviceFamily;

/**
 *
 * @author joeri
 */
class IPhoneSimulator extends IosSimulator {

    @TaskAction
    void iphoneSimulator() {
        launch(getDeviceType(DeviceFamily.iPhone))
    }

}
