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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIMetaEvent/*</name>*/ 
    extends /*<extends>*/Struct<MIDIMetaEvent>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIMetaEventPtr extends Ptr<MIDIMetaEvent, MIDIMetaEventPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MIDIMetaEvent() {}
    public MIDIMetaEvent(byte metaEventType) {
        this.setMetaEventType(metaEventType);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public byte[] getData() {
        return getData0().toByteArray(getDataLength0());
    }
    public ByteBuffer getDataAsByteBuffer() {
        return getData0().asByteBuffer(getDataLength0());
    }
    public MIDIMetaEvent setData(byte[] data) {
        setData0(VM.getArrayValuesAddress(data));
        setDataLength0(data.length);
        return this;
    }
    /*<members>*/
    @StructMember(0) public native byte getMetaEventType();
    @StructMember(0) public native MIDIMetaEvent setMetaEventType(byte metaEventType);
    @StructMember(1) private native byte getUnused1();
    @StructMember(1) private native MIDIMetaEvent setUnused1(byte unused1);
    @StructMember(2) private native byte getUnused2();
    @StructMember(2) private native MIDIMetaEvent setUnused2(byte unused2);
    @StructMember(3) private native byte getUnused3();
    @StructMember(3) private native MIDIMetaEvent setUnused3(byte unused3);
    @StructMember(4) protected native int getDataLength0();
    @StructMember(4) protected native MIDIMetaEvent setDataLength0(int dataLength0);
    /*</members>*/
    @StructMember(1) protected native BytePtr getData0();
    @StructMember(1) protected native MIDIMetaEvent setData0(@Pointer long data0);
    /*<methods>*//*</methods>*/
}
