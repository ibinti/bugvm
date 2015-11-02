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
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVSpeechUtterance/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVSpeechUtterancePtr extends Ptr<AVSpeechUtterance, AVSpeechUtterancePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVSpeechUtterance.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVSpeechUtterance() {}
    protected AVSpeechUtterance(SkipInit skipInit) { super(skipInit); }
    public AVSpeechUtterance(String string) { super((SkipInit) null); initObject(init(string)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "voice")
    public native AVSpeechSynthesisVoice getVoice();
    @Property(selector = "setVoice:")
    public native void setVoice(AVSpeechSynthesisVoice v);
    @Property(selector = "speechString")
    public native String getSpeechString();
    @Property(selector = "rate")
    public native float getRate();
    @Property(selector = "setRate:")
    public native void setRate(float v);
    @Property(selector = "pitchMultiplier")
    public native float getPitchMultiplier();
    @Property(selector = "setPitchMultiplier:")
    public native void setPitchMultiplier(float v);
    @Property(selector = "volume")
    public native float getVolume();
    @Property(selector = "setVolume:")
    public native void setVolume(float v);
    @Property(selector = "preUtteranceDelay")
    public native double getPreUtteranceDelay();
    @Property(selector = "setPreUtteranceDelay:")
    public native void setPreUtteranceDelay(double v);
    @Property(selector = "postUtteranceDelay")
    public native double getPostUtteranceDelay();
    @Property(selector = "setPostUtteranceDelay:")
    public native void setPostUtteranceDelay(double v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="AVSpeechUtteranceMinimumSpeechRate", optional=true)
    public static native float getMinimumSpeechRate();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="AVSpeechUtteranceMaximumSpeechRate", optional=true)
    public static native float getMaximumSpeechRate();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="AVSpeechUtteranceDefaultSpeechRate", optional=true)
    public static native float getDefaultSpeechRate();
    
    @Method(selector = "initWithString:")
    protected native @Pointer long init(String string);
    /*</methods>*/
}
