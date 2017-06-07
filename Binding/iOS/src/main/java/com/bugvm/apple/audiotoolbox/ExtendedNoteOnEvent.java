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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ExtendedNoteOnEvent/*</name>*/ 
    extends /*<extends>*/Struct<ExtendedNoteOnEvent>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class ExtendedNoteOnEventPtr extends Ptr<ExtendedNoteOnEvent, ExtendedNoteOnEventPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public ExtendedNoteOnEvent() {}
    public ExtendedNoteOnEvent(int instrumentID, int groupID, float duration, MusicDeviceNoteParams extendedParams) {
        this.setInstrumentID(instrumentID);
        this.setGroupID(groupID);
        this.setDuration(duration);
        this.setExtendedParams(extendedParams);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native int getInstrumentID();
    @StructMember(0) public native ExtendedNoteOnEvent setInstrumentID(int instrumentID);
    @StructMember(1) public native int getGroupID();
    @StructMember(1) public native ExtendedNoteOnEvent setGroupID(int groupID);
    @StructMember(2) public native float getDuration();
    @StructMember(2) public native ExtendedNoteOnEvent setDuration(float duration);
    @StructMember(3) public native @ByVal MusicDeviceNoteParams getExtendedParams();
    @StructMember(3) public native ExtendedNoteOnEvent setExtendedParams(@ByVal MusicDeviceNoteParams extendedParams);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
