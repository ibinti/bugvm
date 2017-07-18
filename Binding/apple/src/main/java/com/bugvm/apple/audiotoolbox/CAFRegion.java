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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAFRegion/*</name>*/ 
    extends /*<extends>*/Struct<CAFRegion>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAFRegionPtr extends Ptr<CAFRegion, CAFRegionPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAFRegion() {}
    public CAFRegion(int regionID, CAFRegionFlags flags) {
        this.setRegionID(regionID);
        this.setFlags(flags);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public int getMarkerCount() {
        return getNumberMarkers();
    }
    
    public CAFMarker getMarker(int index) {
        if (index >= getMarkerCount()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return getMarkers0().next(index).get();
    }
    public CAFRegion setMarker(int index, CAFMarker value) {
        if (index >= getMarkerCount()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        getMarkers0().next(index).set(value);
        return this;
    }
    public CAFMarker[] getMarkers() {
        int count = getMarkerCount();
        CAFMarker[] array = new CAFMarker[count];
        CAFMarker.CAFMarkerPtr ptr = getMarkers0();
        for (int i = 0; i < count; i++) {
            array[i] = ptr.next(i).get();
        }
        return array;
    }
    public CAFRegion setMarkers(CAFMarker[] markers) {
        this.setNumberMarkers(markers.length);
        getMarkers0().set(markers);
        return this;
    }
    /*<members>*/
    @StructMember(0) public native int getRegionID();
    @StructMember(0) public native CAFRegion setRegionID(int regionID);
    @StructMember(1) public native CAFRegionFlags getFlags();
    @StructMember(1) public native CAFRegion setFlags(CAFRegionFlags flags);
    @StructMember(2) protected native int getNumberMarkers();
    @StructMember(2) protected native CAFRegion setNumberMarkers(int numberMarkers);
    @StructMember(3) protected native CAFMarker.CAFMarkerPtr getMarkers0();
    @StructMember(3) protected native CAFRegion setMarkers0(CAFMarker.CAFMarkerPtr markers0);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
