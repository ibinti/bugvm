/*
 * Copyright (C) 2013-2015 RoboVM AB
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
package com.bugvm.ios.AudioToolbox;

/*<imports>*/
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioQueueLevelMeterState/*</name>*/ 
    extends /*<extends>*/Struct<AudioQueueLevelMeterState>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioQueueLevelMeterStatePtr extends Ptr<AudioQueueLevelMeterState, AudioQueueLevelMeterStatePtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioQueueLevelMeterState() {}
    public AudioQueueLevelMeterState(float averagePower, float peakPower) {
        this.setAveragePower(averagePower);
        this.setPeakPower(peakPower);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native float getAveragePower();
    @StructMember(0) public native AudioQueueLevelMeterState setAveragePower(float averagePower);
    @StructMember(1) public native float getPeakPower();
    @StructMember(1) public native AudioQueueLevelMeterState setPeakPower(float peakPower);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
