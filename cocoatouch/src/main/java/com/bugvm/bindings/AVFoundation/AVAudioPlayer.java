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
package com.bugvm.bindings.AVFoundation;

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
 * @since Available in iOS 2.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioPlayer/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioPlayerPtr extends Ptr<AVAudioPlayer, AVAudioPlayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioPlayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioPlayer() {}
    protected AVAudioPlayer(SkipInit skipInit) { super(skipInit); }
    public AVAudioPlayer(NSURL url) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(url, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    public AVAudioPlayer(NSData data) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(data, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public AVAudioPlayer(NSURL url, String utiString) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(url, utiString, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public AVAudioPlayer(NSData data, String utiString) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(data, utiString, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isPlaying")
    public native boolean isPlaying();
    @Property(selector = "numberOfChannels")
    public native @MachineSizedUInt long getNumberOfChannels();
    @Property(selector = "duration")
    public native double getDuration();
    @Property(selector = "delegate")
    public native AVAudioPlayerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(AVAudioPlayerDelegate v);
    @Property(selector = "url")
    public native NSURL getUrl();
    @Property(selector = "data")
    public native NSData getData();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "pan")
    public native float getPan();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "setPan:")
    public native void setPan(float v);
    @Property(selector = "volume")
    public native float getVolume();
    @Property(selector = "setVolume:")
    public native void setVolume(float v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "enableRate")
    public native boolean isRateEnabled();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setEnableRate:")
    public native void setRateEnabled(boolean v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "rate")
    public native float getRate();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setRate:")
    public native void setRate(float v);
    @Property(selector = "currentTime")
    public native double getCurrentTime();
    @Property(selector = "setCurrentTime:")
    public native void setCurrentTime(double v);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "deviceCurrentTime")
    public native double getDeviceCurrentTime();
    @Property(selector = "numberOfLoops")
    public native @MachineSizedSInt long getNumberOfLoops();
    @Property(selector = "setNumberOfLoops:")
    public native void setNumberOfLoops(@MachineSizedSInt long v);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "settings")
    public native AVAudioSettings getSettings();
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
    @Method(selector = "initWithContentsOfURL:error:")
    private native @Pointer long init(NSURL url, NSError.NSErrorPtr outError);
    @Method(selector = "initWithData:error:")
    private native @Pointer long init(NSData data, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "initWithContentsOfURL:fileTypeHint:error:")
    private native @Pointer long init(NSURL url, String utiString, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "initWithData:fileTypeHint:error:")
    private native @Pointer long init(NSData data, String utiString, NSError.NSErrorPtr outError);
    @Method(selector = "prepareToPlay")
    public native boolean prepareToPlay();
    @Method(selector = "play")
    public native boolean play();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "playAtTime:")
    public native boolean playAtTime(double time);
    @Method(selector = "pause")
    public native void pause();
    @Method(selector = "stop")
    public native void stop();
    @Method(selector = "updateMeters")
    public native void updateMeters();
    @Method(selector = "peakPowerForChannel:")
    public native float getPeakPowerForChannel(@MachineSizedUInt long channelNumber);
    @Method(selector = "averagePowerForChannel:")
    public native float getAveragePowerForChannel(@MachineSizedUInt long channelNumber);
    /*</methods>*/
}
