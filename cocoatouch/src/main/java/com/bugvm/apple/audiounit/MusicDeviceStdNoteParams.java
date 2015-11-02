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
package com.bugvm.apple.audiounit;

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
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MusicDeviceStdNoteParams/*</name>*/ 
    extends /*<extends>*/Struct<MusicDeviceStdNoteParams>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MusicDeviceStdNoteParamsPtr extends Ptr<MusicDeviceStdNoteParams, MusicDeviceStdNoteParamsPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    public MusicDeviceStdNoteParams() {}
    public MusicDeviceStdNoteParams(float pitch, float velocity) {
        this.setPitch(pitch);
        this.setVelocity(velocity);
        this.setArgCount(2);
    }
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) private native int getArgCount();
    @StructMember(0) private native MusicDeviceStdNoteParams setArgCount(int argCount);
    @StructMember(1) public native float getPitch();
    @StructMember(1) public native MusicDeviceStdNoteParams setPitch(float pitch);
    @StructMember(2) public native float getVelocity();
    @StructMember(2) public native MusicDeviceStdNoteParams setVelocity(float velocity);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
