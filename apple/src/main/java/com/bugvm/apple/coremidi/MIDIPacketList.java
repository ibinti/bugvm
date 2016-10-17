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
package com.bugvm.apple.coremidi;

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
/*<annotations>*/@Library("CoreMIDI")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIPacketList/*</name>*/ 
    extends /*<extends>*/Struct<MIDIPacketList>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIPacketListPtr extends Ptr<MIDIPacketList, MIDIPacketListPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(MIDIPacketList.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native int getNumPackets();
    @StructMember(0) public native MIDIPacketList setNumPackets(int numPackets);
    @StructMember(1) public native @Array({1}) MIDIPacket getPacket();
    @StructMember(1) public native MIDIPacketList setPacket(@Array({1}) MIDIPacket packet);
    /*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIPacketListInit", optional=true)
    public native MIDIPacket init();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIPacketListAdd", optional=true)
    protected native MIDIPacket add(@MachineSizedUInt long listSize, MIDIPacket curPacket, long time, @MachineSizedUInt long nData, BytePtr data);
    /*</methods>*/
}
