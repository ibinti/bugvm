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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioPanningInfo/*</name>*/ 
    extends /*<extends>*/Struct<AudioPanningInfo>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioPanningInfoPtr extends Ptr<AudioPanningInfo, AudioPanningInfoPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioPanningInfo() {}
    public AudioPanningInfo(AudioPanningMode panningMode, AudioChannelFlags coordinateFlags, float[] coordinates, float gainScale, AudioChannelLayout outputChannelMap) {
        this.setPanningMode(panningMode);
        this.setCoordinateFlags(coordinateFlags);
        this.setCoordinates(coordinates);
        this.setGainScale(gainScale);
        this.setOutputChannelMap(outputChannelMap);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public float getCoordinate(AudioChannelCoordinate coordinate) {
        return getCoordinates()[(int)coordinate.value()];
    }
    public AudioPanningInfo setCoordinate(AudioChannelCoordinate coordinate, float value) {
        float[] coords = getCoordinates();
        coords[(int)coordinate.value()] = value;
        setCoordinates(coords);
        return this;
    }
    public AudioPanningInfo setCoordinates(float x, float y, float z) {
        float[] coords = new float[] {x, y, z};
        setCoordinates(coords);
        return this;
    }
    /*<members>*/
    @StructMember(0) public native AudioPanningMode getPanningMode();
    @StructMember(0) public native AudioPanningInfo setPanningMode(AudioPanningMode panningMode);
    @StructMember(1) public native AudioChannelFlags getCoordinateFlags();
    @StructMember(1) public native AudioPanningInfo setCoordinateFlags(AudioChannelFlags coordinateFlags);
    @StructMember(2) public native @Array({3}) float[] getCoordinates();
    @StructMember(2) public native AudioPanningInfo setCoordinates(@Array({3}) float[] coordinates);
    @StructMember(3) public native float getGainScale();
    @StructMember(3) public native AudioPanningInfo setGainScale(float gainScale);
    @StructMember(4) public native AudioChannelLayout getOutputChannelMap();
    @StructMember(4) public native AudioPanningInfo setOutputChannelMap(AudioChannelLayout outputChannelMap);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
