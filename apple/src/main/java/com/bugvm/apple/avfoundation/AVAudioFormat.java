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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioFormat/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioFormatPtr extends Ptr<AVAudioFormat, AVAudioFormatPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioFormat.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioFormat() {}
    protected AVAudioFormat(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public AVAudioFormat(AudioStreamBasicDescription asbd) { super((SkipInit) null); initObject(init(asbd)); }
    public AVAudioFormat(AudioStreamBasicDescription asbd, AVAudioChannelLayout layout) { super((SkipInit) null); initObject(init(asbd, layout)); }
    public AVAudioFormat(double sampleRate, int channels) { super((SkipInit) null); initObject(init(sampleRate, channels)); }
    public AVAudioFormat(double sampleRate, AVAudioChannelLayout layout) { super((SkipInit) null); initObject(init(sampleRate, layout)); }
    public AVAudioFormat(AVAudioCommonFormat format, double sampleRate, int channels, boolean interleaved) { super((SkipInit) null); initObject(init(format, sampleRate, channels, interleaved)); }
    public AVAudioFormat(AVAudioCommonFormat format, double sampleRate, boolean interleaved, AVAudioChannelLayout layout) { super((SkipInit) null); initObject(init(format, sampleRate, interleaved, layout)); }
    public AVAudioFormat(AVAudioSettings settings) { super((SkipInit) null); initObject(init(settings)); }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public AVAudioFormat(CMAudioFormatDescription formatDescription) { super((SkipInit) null); initObject(init(formatDescription)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isStandard")
    public native boolean isStandard();
    @Property(selector = "commonFormat")
    public native AVAudioCommonFormat getCommonFormat();
    @Property(selector = "channelCount")
    public native int getChannelCount();
    @Property(selector = "sampleRate")
    public native double getSampleRate();
    @Property(selector = "isInterleaved")
    public native boolean isInterleaved();
    @WeaklyLinked
    @Property(selector = "streamDescription")
    public native AudioStreamBasicDescription getStreamDescription();
    @Property(selector = "channelLayout")
    public native AVAudioChannelLayout getChannelLayout();
    @Property(selector = "settings")
    public native AVAudioSettings getSettings();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "formatDescription")
    public native CMAudioFormatDescription getFormatDescription();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "initWithStreamDescription:")
    protected native @Pointer long init(AudioStreamBasicDescription asbd);
    @Method(selector = "initWithStreamDescription:channelLayout:")
    protected native @Pointer long init(AudioStreamBasicDescription asbd, AVAudioChannelLayout layout);
    @Method(selector = "initStandardFormatWithSampleRate:channels:")
    protected native @Pointer long init(double sampleRate, int channels);
    @Method(selector = "initStandardFormatWithSampleRate:channelLayout:")
    protected native @Pointer long init(double sampleRate, AVAudioChannelLayout layout);
    @Method(selector = "initWithCommonFormat:sampleRate:channels:interleaved:")
    protected native @Pointer long init(AVAudioCommonFormat format, double sampleRate, int channels, boolean interleaved);
    @Method(selector = "initWithCommonFormat:sampleRate:interleaved:channelLayout:")
    protected native @Pointer long init(AVAudioCommonFormat format, double sampleRate, boolean interleaved, AVAudioChannelLayout layout);
    @Method(selector = "initWithSettings:")
    protected native @Pointer long init(AVAudioSettings settings);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "initWithCMAudioFormatDescription:")
    protected native @Pointer long init(CMAudioFormatDescription formatDescription);
    @Method(selector = "isEqual:")
    public native boolean equalsTo(AVAudioFormat object);
    /*</methods>*/
}
