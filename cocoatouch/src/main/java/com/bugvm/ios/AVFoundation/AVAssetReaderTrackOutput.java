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
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corefoundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetReaderTrackOutput/*</name>*/ 
    extends /*<extends>*/AVAssetReaderOutput/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetReaderTrackOutputPtr extends Ptr<AVAssetReaderTrackOutput, AVAssetReaderTrackOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetReaderTrackOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetReaderTrackOutput() {}
    protected AVAssetReaderTrackOutput(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public AVAssetReaderTrackOutput(com.bugvm.ios.AVFoundation.AVAssetTrack track, com.bugvm.ios.AVFoundation.AVAudioSettings outputSettings) {
        super((SkipInit)null);
        initObject(init(track, outputSettings.getDictionary()));
    }
    public AVAssetReaderTrackOutput(com.bugvm.ios.AVFoundation.AVAssetTrack track, com.bugvm.ios.AVFoundation.AVVideoSettings outputSettings) {
        super((SkipInit)null);
        initObject(init(track, outputSettings.getDictionary()));
    }
    public AVAssetReaderTrackOutput(com.bugvm.ios.AVFoundation.AVAssetTrack track, com.bugvm.ios.AVFoundation.AVPixelBufferAttributes outputSettings) {
        super((SkipInit)null);
        initObject(init(track, outputSettings.getDictionary().as(NSDictionary.class)));
    }
    
    public com.bugvm.ios.AVFoundation.AVAudioSettings getAudioOutputSettings() {
        return new com.bugvm.ios.AVFoundation.AVAudioSettings(getOutputSettings());
    }
    public com.bugvm.ios.AVFoundation.AVVideoSettings getVideoOutputSettings() {
        return new com.bugvm.ios.AVFoundation.AVVideoSettings(getOutputSettings());
    }
    @WeaklyLinked
    public com.bugvm.ios.AVFoundation.AVPixelBufferAttributes getPixelBufferOutputSettings() {
        return new com.bugvm.ios.AVFoundation.AVPixelBufferAttributes(getOutputSettings().as(CFDictionary.class));
    }
    /*<properties>*/
    @Property(selector = "track")
    public native com.bugvm.ios.AVFoundation.AVAssetTrack getTrack();
    @Property(selector = "outputSettings")
    protected native NSDictionary<?, ?> getOutputSettings();
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
    @Method(selector = "initWithTrack:outputSettings:")
    protected native @Pointer long init(com.bugvm.ios.AVFoundation.AVAssetTrack track, NSDictionary<?, ?> outputSettings);
    /*</methods>*/
}
