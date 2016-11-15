package com.bugvm.gradle.ios.task

import org.gradle.api.tasks.TaskAction
import com.bugvm.compiler.target.ios.DeviceType.DeviceFamily;

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
