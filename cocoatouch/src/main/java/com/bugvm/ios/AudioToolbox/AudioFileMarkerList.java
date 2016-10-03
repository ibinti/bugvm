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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioFileMarkerList/*</name>*/ 
    extends /*<extends>*/Struct<AudioFileMarkerList>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioFileMarkerListPtr extends Ptr<AudioFileMarkerList, AudioFileMarkerListPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioFileMarkerList() {}
    public AudioFileMarkerList(CAFSMPTETimeType SMPTETimeType) {
        this.setSMPTETimeType(SMPTETimeType);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public int getMarkerCount() {
        return getNumberMarkers();
    }
    
    public com.bugvm.ios.AudioToolbox.AudioFileMarker getMarker(int index) {
        if (index >= getMarkerCount()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return getMarkers0().next(index).get();
    }
    public AudioFileMarkerList setMarker(int index, com.bugvm.ios.AudioToolbox.AudioFileMarker value) {
        if (index >= getMarkerCount()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        getMarkers0().next(index).set(value);
        return this;
    }
    public com.bugvm.ios.AudioToolbox.AudioFileMarker[] getMarkers() {
        int count = getMarkerCount();
        com.bugvm.ios.AudioToolbox.AudioFileMarker[] array = new com.bugvm.ios.AudioToolbox.AudioFileMarker[count];
        com.bugvm.ios.AudioToolbox.AudioFileMarker.AudioFileMarkerPtr ptr = getMarkers0();
        for (int i = 0; i < count; i++) {
            array[i] = ptr.next(i).get();
        }
        return array;
    }
    public AudioFileMarkerList setMarkers(com.bugvm.ios.AudioToolbox.AudioFileMarker[] markers) {
        this.setNumberMarkers(markers.length);
        getMarkers0().set(markers);
        return this;
    }
    /*<members>*/
    @StructMember(0) public native CAFSMPTETimeType getSMPTETimeType();
    @StructMember(0) public native AudioFileMarkerList setSMPTETimeType(CAFSMPTETimeType SMPTETimeType);
    @StructMember(1) protected native int getNumberMarkers();
    @StructMember(1) protected native AudioFileMarkerList setNumberMarkers(int numberMarkers);
    @StructMember(2) protected native com.bugvm.ios.AudioToolbox.AudioFileMarker.AudioFileMarkerPtr getMarkers0();
    @StructMember(2) protected native AudioFileMarkerList setMarkers0(com.bugvm.ios.AudioToolbox.AudioFileMarker.AudioFileMarkerPtr markers0);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
