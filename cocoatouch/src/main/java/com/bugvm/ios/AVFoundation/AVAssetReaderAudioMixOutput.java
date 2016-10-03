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
package com.bugvm.ios.AVFoundation;

/*<imports>*/

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetReaderAudioMixOutput/*</name>*/ 
    extends /*<extends>*/AVAssetReaderOutput/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetReaderAudioMixOutputPtr extends Ptr<AVAssetReaderAudioMixOutput, AVAssetReaderAudioMixOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetReaderAudioMixOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetReaderAudioMixOutput() {}
    protected AVAssetReaderAudioMixOutput(SkipInit skipInit) { super(skipInit); }
    public AVAssetReaderAudioMixOutput(NSArray<com.bugvm.ios.AVFoundation.AVAssetTrack> audioTracks, com.bugvm.ios.AVFoundation.AVAudioSettings audioSettings) { super((SkipInit) null); initObject(init(audioTracks, audioSettings)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "audioTracks")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetTrack> getAudioTracks();
    @Property(selector = "audioSettings")
    public native com.bugvm.ios.AVFoundation.AVAudioSettings getAudioSettings();
    @Property(selector = "audioMix")
    public native com.bugvm.ios.AVFoundation.AVAudioMix getAudioMix();
    @Property(selector = "setAudioMix:")
    public native void setAudioMix(com.bugvm.ios.AVFoundation.AVAudioMix v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "audioTimePitchAlgorithm")
    public native com.bugvm.ios.AVFoundation.AVAudioTimePitchAlgorithm getAudioTimePitchAlgorithm();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setAudioTimePitchAlgorithm:")
    public native void setAudioTimePitchAlgorithm(com.bugvm.ios.AVFoundation.AVAudioTimePitchAlgorithm v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAudioTracks:audioSettings:")
    protected native @Pointer long init(NSArray<com.bugvm.ios.AVFoundation.AVAssetTrack> audioTracks, com.bugvm.ios.AVFoundation.AVAudioSettings audioSettings);
    /*</methods>*/
}
