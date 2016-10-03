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
package com.bugvm.ios.CoreAudio;

/*<imports>*/

import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioTimeStamp/*</name>*/ 
    extends /*<extends>*/Struct<AudioTimeStamp>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioTimeStampPtr extends Ptr<AudioTimeStamp, AudioTimeStampPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioTimeStamp() {}
    public AudioTimeStamp(double sampleTime, long hostTime, double rateScalar, long wordClockTime, SMPTETime smpteTime, com.bugvm.ios.CoreAudio.AudioTimeStampFlags flags) {
        this.setSampleTime(sampleTime);
        this.setHostTime(hostTime);
        this.setRateScalar(rateScalar);
        this.setWordClockTime(wordClockTime);
        this.setSmpteTime(smpteTime);
        this.setFlags(flags);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native double getSampleTime();
    @StructMember(0) public native AudioTimeStamp setSampleTime(double sampleTime);
    @StructMember(1) public native long getHostTime();
    @StructMember(1) public native AudioTimeStamp setHostTime(long hostTime);
    @StructMember(2) public native double getRateScalar();
    @StructMember(2) public native AudioTimeStamp setRateScalar(double rateScalar);
    @StructMember(3) public native long getWordClockTime();
    @StructMember(3) public native AudioTimeStamp setWordClockTime(long wordClockTime);
    @StructMember(4) public native @ByVal
    SMPTETime getSmpteTime();
    @StructMember(4) public native AudioTimeStamp setSmpteTime(@ByVal SMPTETime smpteTime);
    @StructMember(5) public native com.bugvm.ios.CoreAudio.AudioTimeStampFlags getFlags();
    @StructMember(5) public native AudioTimeStamp setFlags(com.bugvm.ios.CoreAudio.AudioTimeStampFlags flags);
    @StructMember(6) private native int getReserved();
    @StructMember(6) private native AudioTimeStamp setReserved(int reserved);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
