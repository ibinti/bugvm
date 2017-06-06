/*
 * Copyright (C) 2014 RoboVM AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bugvm.gradle

import org.gradle.api.Project

/**

 * @author Junji Takakura
 */
class BugVMPluginExtension(val project: Project) {
    var propertiesFile: String? = null
    var configFile: String? = null
    var iosSignIdentity: String? = null
        get() = if (project.hasProperty("bugvm.iosSignIdentity"))
            project.properties["bugvm.iosSignIdentity"].toString()
        else
            field
    var iosProvisioningProfile: String? = null
        get() = if (project.hasProperty("bugvm.iosProvisioningProfile"))
            project.properties["bugvm.iosProvisioningProfile"].toString()
        else
            field
    var iosSimulatorSdk: String? = null
        get() = if (project.hasProperty("bugvm.iosSimulatorSdk"))
            project.properties["bugvm.iosSimulatorSdk"].toString()
        else
            field
    var stdoutFifo: String? = null
    var stderrFifo: String? = null
    var os: String? = null
        get() = if (project.hasProperty("bugvm.os")) project.properties["bugvm.os"].toString() else field
    var arch: String? = null
        get() = if (project.hasProperty("bugvm.arch")) project.properties["bugvm.arch"].toString() else field
    var isIosSkipSigning = false
        get() = if (project.hasProperty("bugvm.iosSkipSigning"))
            java.lang.Boolean.parseBoolean(project.properties["bugvm.iosSkipSigning"].toString())
        else
            field
    var isDebug = false
        get() = if (project.hasProperty("bugvm.debug"))
            java.lang.Boolean.parseBoolean(project.properties["bugvm.debug"].toString())
        else
            field
    var debugPort = -1
        get() = if (project.hasProperty("bugvm.debugPort"))
            Integer.parseInt(project.properties["bugvm.debugPort"].toString())
        else
            field
    var isSkipLaunch = false
        get() = if (project.hasProperty("bugvm.skipLaunch"))
            java.lang.Boolean.parseBoolean(project.properties["bugvm.skipLaunch"].toString())
        else
            field
    var archs: String? = null
        get() {
            if (project.hasProperty("bugvm.archs")) {
                return project.properties["bugvm.archs"].toString()
            }
            return field
        }
    var installDir: String? = null
        get() = if (project.hasProperty("bugvm.installDir")) project.properties["bugvm.installDir"].toString() else field
    var cacheDir: String? = null
        get() = if (project.hasProperty("bugvm.cacheDir")) project.properties["bugvm.cacheDir"].toString() else null

    companion object {

        val NAME = "bugvm"
    }
}
