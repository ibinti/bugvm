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
package com.bugvm.apple.avfoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.mediatoolbox.*;
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.audiounit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioRecorder/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioRecorderPtr extends Ptr<AVAudioRecorder, AVAudioRecorderPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioRecorder.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioRecorder() {}
    protected AVAudioRecorder(SkipInit skipInit) { super(skipInit); }
    public AVAudioRecorder(NSURL url, AVAudioSettings settings) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(url, settings, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isRecording")
    public native boolean isRecording();
    @Property(selector = "url")
    public native NSURL getUrl();
    @Property(selector = "settings")
    public native AVAudioSettings getSettings();
    @Property(selector = "delegate")
    public native AVAudioRecorderDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(AVAudioRecorderDelegate v);
    @Property(selector = "currentTime")
    public native double getCurrentTime();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "deviceCurrentTime")
    public native double getDeviceCurrentTime();
    @Property(selector = "isMeteringEnabled")
    public native boolean isMeteringEnabled();
    @Property(selector = "setMeteringEnabled:")
    public native void setMeteringEnabled(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "channelAssignments")
    public native NSArray<AVAudioSessionChannelDescription> getChannelAssignments();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setChannelAssignments:")
    public native void setChannelAssignments(NSArray<AVAudioSessionChannelDescription> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithURL:settings:error:")
    private native @Pointer long init(NSURL url, AVAudioSettings settings, NSError.NSErrorPtr outError);
    @Method(selector = "prepareToRecord")
    public native boolean prepareToRecord();
    @Method(selector = "record")
    public native boolean record();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "recordAtTime:")
    public native boolean recordAtTime(double time);
    @Method(selector = "recordForDuration:")
    public native boolean record(double duration);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "recordAtTime:forDuration:")
    public native boolean recordAtTime(double time, double duration);
    @Method(selector = "pause")
    public native void pause();
    @Method(selector = "stop")
    public native void stop();
    @Method(selector = "deleteRecording")
    public native boolean deleteRecording();
    @Method(selector = "updateMeters")
    public native void updateMeters();
    @Method(selector = "peakPowerForChannel:")
    public native float getPeakPowerForChannel(@MachineSizedUInt long channelNumber);
    @Method(selector = "averagePowerForChannel:")
    public native float getAveragePowerForChannel(@MachineSizedUInt long channelNumber);
    /*</methods>*/
}
