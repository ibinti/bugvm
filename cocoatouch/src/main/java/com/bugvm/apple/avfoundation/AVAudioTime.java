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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioTime/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioTimePtr extends Ptr<AVAudioTime, AVAudioTimePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioTime.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioTime() {}
    protected AVAudioTime(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public AVAudioTime(AudioTimeStamp ts, double sampleRate) { super((SkipInit) null); initObject(init(ts, sampleRate)); }
    public AVAudioTime(long hostTime) { super((SkipInit) null); initObject(init(hostTime)); }
    public AVAudioTime(long sampleTime, double sampleRate) { super((SkipInit) null); initObject(init(sampleTime, sampleRate)); }
    public AVAudioTime(long hostTime, long sampleTime, double sampleRate) { super((SkipInit) null); initObject(init(hostTime, sampleTime, sampleRate)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isHostTimeValid")
    public native boolean isHostTimeValid();
    @Property(selector = "hostTime")
    public native long getHostTime();
    @Property(selector = "isSampleTimeValid")
    public native boolean isSampleTimeValid();
    @Property(selector = "sampleTime")
    public native long getSampleTime();
    @Property(selector = "sampleRate")
    public native double getSampleRate();
    @WeaklyLinked
    @Property(selector = "audioTimeStamp")
    public native @ByVal AudioTimeStamp getAudioTimeStamp();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "initWithAudioTimeStamp:sampleRate:")
    protected native @Pointer long init(AudioTimeStamp ts, double sampleRate);
    @Method(selector = "initWithHostTime:")
    protected native @Pointer long init(long hostTime);
    @Method(selector = "initWithSampleTime:atRate:")
    protected native @Pointer long init(long sampleTime, double sampleRate);
    @Method(selector = "initWithHostTime:sampleTime:atRate:")
    protected native @Pointer long init(long hostTime, long sampleTime, double sampleRate);
    @Method(selector = "extrapolateTimeFromAnchor:")
    public native AVAudioTime extrapolateTimeFromAnchor(AVAudioTime anchorTime);
    @Method(selector = "hostTimeForSeconds:")
    public static native long convertSecondsToHostTime(double seconds);
    @Method(selector = "secondsForHostTime:")
    public static native double convertHostTimeToSeconds(long hostTime);
    /*</methods>*/
}
