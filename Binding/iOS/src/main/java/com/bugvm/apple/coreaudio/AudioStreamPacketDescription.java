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
package com.bugvm.apple.coreaudio;

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
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioStreamPacketDescription/*</name>*/ 
    extends /*<extends>*/Struct<AudioStreamPacketDescription>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioStreamPacketDescriptionPtr extends Ptr<AudioStreamPacketDescription, AudioStreamPacketDescriptionPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioStreamPacketDescription() {}
    public AudioStreamPacketDescription(long startOffset, int variableFramesInPacket, int dataByteSize) {
        this.setStartOffset(startOffset);
        this.setVariableFramesInPacket(variableFramesInPacket);
        this.setDataByteSize(dataByteSize);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native long getStartOffset();
    @StructMember(0) public native AudioStreamPacketDescription setStartOffset(long startOffset);
    @StructMember(1) public native int getVariableFramesInPacket();
    @StructMember(1) public native AudioStreamPacketDescription setVariableFramesInPacket(int variableFramesInPacket);
    @StructMember(2) public native int getDataByteSize();
    @StructMember(2) public native AudioStreamPacketDescription setDataByteSize(int dataByteSize);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
