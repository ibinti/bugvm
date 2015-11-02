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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MusicDeviceNoteParams/*</name>*/ 
    extends /*<extends>*/Struct<MusicDeviceNoteParams>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MusicDeviceNoteParamsPtr extends Ptr<MusicDeviceNoteParams, MusicDeviceNoteParamsPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    public MusicDeviceNoteParams() {
        setArgCount(2);
    }
    public MusicDeviceNoteParams(float pitch, float velocity, NoteParamsControlValue[] controls) {
        this.setPitch(pitch);
        this.setVelocity(velocity);
        setControls(controls);
    }
    
    public int getControlsCount() {
        return getArgCount() - 2;
    }
    
    public NoteParamsControlValue getControl(int index) {
        if (index >= getControlsCount()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return getControls0().next(index).get();
    }
    public MusicDeviceNoteParams setControl(int index, NoteParamsControlValue value) {
        if (index >= getControlsCount()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        getControls0().next(index).set(value);
        return this;
    }
    public NoteParamsControlValue[] getControls() {
        int count = getControlsCount();
        NoteParamsControlValue[] array = new NoteParamsControlValue[count];
        NoteParamsControlValue.NoteParamsControlValuePtr ptr = getControls0();
        for (int i = 0; i < count; i++) {
            array[i] = ptr.next(i).get();
        }
        return array;
    }
    public MusicDeviceNoteParams setControls(NoteParamsControlValue... controls) {
        this.setArgCount(controls.length + 2);
        getControls0().set(controls);
        return this;
    }
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) private native int getArgCount();
    @StructMember(0) private native MusicDeviceNoteParams setArgCount(int argCount);
    @StructMember(1) public native float getPitch();
    @StructMember(1) public native MusicDeviceNoteParams setPitch(float pitch);
    @StructMember(2) public native float getVelocity();
    @StructMember(2) public native MusicDeviceNoteParams setVelocity(float velocity);
    /*</members>*/
    @StructMember(3) protected native @ByVal NoteParamsControlValue.NoteParamsControlValuePtr getControls0();
    /*<methods>*//*</methods>*/
}
