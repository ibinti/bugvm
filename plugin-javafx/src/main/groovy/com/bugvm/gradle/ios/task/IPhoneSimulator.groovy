package com.bugvm.gradle.ios.task

import org.gradle.api.tasks.TaskAction
import com.bugvm.compiler.target.ios.DeviceType.DeviceFamily;

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
