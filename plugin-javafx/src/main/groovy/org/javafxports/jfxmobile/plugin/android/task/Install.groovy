package org.javafxports.jfxmobile.plugin.android.task

import com.android.build.gradle.internal.LoggerWrapper
import com.android.builder.core.DefaultApiVersion
import com.android.builder.internal.InstallUtils
import com.android.builder.testing.ConnectedDeviceProvider
import com.android.builder.testing.api.DeviceConnector
import com.android.builder.testing.api.DeviceProvider
import com.android.ddmlib.IDevice
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

/**
 *
 * @author joeri
 */
class Install extends DefaultTask {

    @InputFile
    File adbExe

    @InputFile
    File apk

    int timeOut = 0
    
    @TaskAction
    void install() {
        boolean preview = project.jfxmobile.android.preview
        LoggerWrapper loggerWrapper = new LoggerWrapper(project.logger)

        DeviceProvider deviceProvider = new ConnectedDeviceProvider(getAdbExe())
        deviceProvider.init()

        boolean successFull = false
        for (DeviceConnector device : deviceProvider.getDevices()) {
            if (device.getState() != IDevice.DeviceState.UNAUTHORIZED) {
                if (preview || (device.getApiLevel()== 0) || InstallUtils.checkDeviceApiLevel(device, new DefaultApiVersion(1, null), loggerWrapper, project.name, 'debug')) {
                    if (getApk() != null) {
                        if (preview || (device.getApiLevel()== 0) || device.getApiLevel() >= 21) {
                            device.installPackages([ getApk() ], getTimeOut(), loggerWrapper)
                            successFull = true
                        } else {
                            device.installPackage(getApk(), getTimeOut(), loggerWrapper)
                            successFull = true
                        }
                    } else {
                        project.logger.lifecycle("Could not find apk file")
                    }
                }
            } else {
                project.logger.lifecycle("Skipping device '${device.getName()}' for '${project.name}:debug': Device not authorized, see http://developer.android.com/tools/help/adb.html#Enabling.")
            }
        }

        if (!successFull) {
            throw new GradleException("Failed to install on any devices.")
        } else {
            project.logger.quiet("Installed on device.")
        }

    }

}

