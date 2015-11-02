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
package com.bugvm.apple.audiotoolbox;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.audiounit.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremidi.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAFAudioDescription/*</name>*/ 
    extends /*<extends>*/Struct<CAFAudioDescription>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAFAudioDescriptionPtr extends Ptr<CAFAudioDescription, CAFAudioDescriptionPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAFAudioDescription() {}
    public CAFAudioDescription(double sampleRate, AudioFormat format, CAFFormatFlags formatFlags, int bytesPerPacket, int framesPerPacket, int channelsPerFrame, int bitsPerChannel) {
        this.setSampleRate(sampleRate);
        this.setFormat(format);
        this.setFormatFlags(formatFlags);
        this.setBytesPerPacket(bytesPerPacket);
        this.setFramesPerPacket(framesPerPacket);
        this.setChannelsPerFrame(channelsPerFrame);
        this.setBitsPerChannel(bitsPerChannel);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native double getSampleRate();
    @StructMember(0) public native CAFAudioDescription setSampleRate(double sampleRate);
    @StructMember(1) public native AudioFormat getFormat();
    @StructMember(1) public native CAFAudioDescription setFormat(AudioFormat format);
    @StructMember(2) public native CAFFormatFlags getFormatFlags();
    @StructMember(2) public native CAFAudioDescription setFormatFlags(CAFFormatFlags formatFlags);
    @StructMember(3) public native int getBytesPerPacket();
    @StructMember(3) public native CAFAudioDescription setBytesPerPacket(int bytesPerPacket);
    @StructMember(4) public native int getFramesPerPacket();
    @StructMember(4) public native CAFAudioDescription setFramesPerPacket(int framesPerPacket);
    @StructMember(5) public native int getChannelsPerFrame();
    @StructMember(5) public native CAFAudioDescription setChannelsPerFrame(int channelsPerFrame);
    @StructMember(6) public native int getBitsPerChannel();
    @StructMember(6) public native CAFAudioDescription setBitsPerChannel(int bitsPerChannel);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
