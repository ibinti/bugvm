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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAFMarker/*</name>*/ 
    extends /*<extends>*/Struct<CAFMarker>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAFMarkerPtr extends Ptr<CAFMarker, CAFMarkerPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAFMarker() {}
    public CAFMarker(CAFMarkerType type, double framePosition, int markerID, CAFSMPTETime SMPTETime, int channel) {
        this.setType(type);
        this.setFramePosition(framePosition);
        this.setMarkerID(markerID);
        this.setSMPTETime(SMPTETime);
        this.setChannel(channel);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native CAFMarkerType getType();
    @StructMember(0) public native CAFMarker setType(CAFMarkerType type);
    @StructMember(1) public native double getFramePosition();
    @StructMember(1) public native CAFMarker setFramePosition(double framePosition);
    @StructMember(2) public native int getMarkerID();
    @StructMember(2) public native CAFMarker setMarkerID(int markerID);
    @StructMember(3) public native @ByVal CAFSMPTETime getSMPTETime();
    @StructMember(3) public native CAFMarker setSMPTETime(@ByVal CAFSMPTETime SMPTETime);
    @StructMember(4) public native int getChannel();
    @StructMember(4) public native CAFMarker setChannel(int channel);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
