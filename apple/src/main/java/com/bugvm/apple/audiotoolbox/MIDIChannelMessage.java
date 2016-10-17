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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIChannelMessage/*</name>*/ 
    extends /*<extends>*/Struct<MIDIChannelMessage>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIChannelMessagePtr extends Ptr<MIDIChannelMessage, MIDIChannelMessagePtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MIDIChannelMessage() {}
    public MIDIChannelMessage(byte status, byte data1, byte data2) {
        this.setStatus(status);
        this.setData1(data1);
        this.setData2(data2);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native byte getStatus();
    @StructMember(0) public native MIDIChannelMessage setStatus(byte status);
    @StructMember(1) public native byte getData1();
    @StructMember(1) public native MIDIChannelMessage setData1(byte data1);
    @StructMember(2) public native byte getData2();
    @StructMember(2) public native MIDIChannelMessage setData2(byte data2);
    @StructMember(3) private native byte getReserved();
    @StructMember(3) private native MIDIChannelMessage setReserved(byte reserved);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
