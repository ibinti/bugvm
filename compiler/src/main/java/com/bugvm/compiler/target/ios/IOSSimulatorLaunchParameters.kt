/*
 * Copyright (C) 2013 RoboVM AB
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */
package com.bugvm.compiler.target.ios

import com.bugvm.compiler.target.LaunchParameters

/**
 * [LaunchParameters] implementation used by [IOSTarget] when
 * launching on the simulator.
 */
class IOSSimulatorLaunchParameters : LaunchParameters() {
    var deviceType: DeviceType? = null
}

//package com.bugvm.compiler.target.ios;
//
//import com.bugvm.compiler.target.LaunchParameters;
//
///**
// * {@link LaunchParameters} implementation used by {@link IOSTarget} when
// * launching on the simulator.
// */
//public class IOSSimulatorLaunchParameters extends LaunchParameters {
//    private DeviceType deviceType;
//
//    public DeviceType getDeviceType() {
//        return deviceType;
//    }
//
//    public void setDeviceType(DeviceType type) {
//        this.deviceType = type;
//    }
//}