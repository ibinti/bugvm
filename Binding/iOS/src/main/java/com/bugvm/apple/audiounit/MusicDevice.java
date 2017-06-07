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
/*<annotations>*/@Library("AudioToolbox")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MusicDevice/*</name>*/ 
    extends /*<extends>*/AudioComponentInstance/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(MusicDevice.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public static MusicDevice create(AudioComponent component) throws OSStatusException {
        AudioComponentInstance result = AudioComponentInstance.create(component);
        if (result != null) {
            return result.as(MusicDevice.class);
        }
        return null;
    }
    /**
     * @since Available in iOS 3.0 and later.
     */
    public boolean canDo(MusicDeviceSelector inSelectorID) {
        return super.canDo((short) inSelectorID.value());
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void midiEvent(int status, int data1, int data2, int offsetSampleFrame) throws OSStatusException {
        OSStatus s = midiEvent0(status, data1, data2, offsetSampleFrame);
        OSStatusException.throwIfNecessary(s);
    }

    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void sysEx(byte[] data) throws OSStatusException {
        OSStatus status = sysEx0(VM.getArrayValuesAddress(data), data.length);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public int startNote(int groupID, int offsetSampleFrame, MusicDeviceNoteParams params) throws OSStatusException {
        IntPtr result = new IntPtr();
        OSStatus status = startNote0(0xFFFFFFFF, groupID, result, offsetSampleFrame, params);
        OSStatusException.throwIfNecessary(status);
        return result.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void stopNote(int groupID, int noteInstanceID, int offsetSampleFrame) throws OSStatusException {
        OSStatus status = stopNote0(groupID, noteInstanceID, offsetSampleFrame);
        OSStatusException.throwIfNecessary(status);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicDeviceMIDIEvent", optional=true)
    protected native OSStatus midiEvent0(int status, int data1, int data2, int offsetSampleFrame);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicDeviceSysEx", optional=true)
    protected native OSStatus sysEx0(@Pointer long data, int length);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicDeviceStartNote", optional=true)
    protected native OSStatus startNote0(int inInstrument, int inGroupID, IntPtr outNoteInstanceID, int inOffsetSampleFrame, MusicDeviceNoteParams inParams);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicDeviceStopNote", optional=true)
    protected native OSStatus stopNote0(int groupID, int noteInstanceID, int offsetSampleFrame);
    /*</methods>*/
}
