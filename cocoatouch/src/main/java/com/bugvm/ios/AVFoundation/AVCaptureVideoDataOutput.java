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
import java.util.*;

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureVideoDataOutput/*</name>*/ 
    extends /*<extends>*/AVCaptureOutput/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVCaptureVideoDataOutputPtr extends Ptr<AVCaptureVideoDataOutput, AVCaptureVideoDataOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVCaptureVideoDataOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVCaptureVideoDataOutput() {}
    protected AVCaptureVideoDataOutput(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public com.bugvm.ios.AVFoundation.AVVideoSettings getVideoSettings() {
        return new com.bugvm.ios.AVFoundation.AVVideoSettings(getVideoSettings0());
    }
    public void setVideoSettings(com.bugvm.ios.AVFoundation.AVVideoSettings videoSettings) {
        setVideoSettings0(videoSettings.getDictionary());
    }
    @WeaklyLinked
    public com.bugvm.ios.AVFoundation.AVPixelBufferAttributes getPixelBufferSettings() {
        return new com.bugvm.ios.AVFoundation.AVPixelBufferAttributes(getVideoSettings0().as(CFDictionary.class));
    }
    @SuppressWarnings("unchecked")
    public void setPixelBufferSettings(com.bugvm.ios.AVFoundation.AVPixelBufferAttributes videoSettings) {
        setVideoSettings0(videoSettings.getDictionary().as(NSDictionary.class));
    }
    /*<properties>*/
    @Property(selector = "sampleBufferDelegate")
    public native com.bugvm.ios.AVFoundation.AVCaptureVideoDataOutputSampleBufferDelegate getSampleBufferDelegate();
    @WeaklyLinked
    @Property(selector = "sampleBufferCallbackQueue")
    public native DispatchQueue getSampleBufferCallbackQueue();
    @Property(selector = "videoSettings")
    protected native NSDictionary<?, ?> getVideoSettings0();
    @Property(selector = "setVideoSettings:")
    protected native void setVideoSettings0(NSDictionary<?, ?> v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Property(selector = "availableVideoCVPixelFormatTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CVPixelFormatType.AsListMarshaler.class) List<CVPixelFormatType> getAvailableVideoCVPixelFormatTypes();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "availableVideoCodecTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CMVideoCodecType.AsListMarshaler.class) List<CMVideoCodecType> getAvailableVideoCodecTypes();
    @Property(selector = "alwaysDiscardsLateVideoFrames")
    public native boolean alwaysDiscardsLateVideoFrames();
    @Property(selector = "setAlwaysDiscardsLateVideoFrames:")
    public native void setAlwaysDiscardsLateVideoFrames(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    public com.bugvm.ios.AVFoundation.AVVideoSettings getRecommendedVideoSettings(String outputFileType) {
        return new com.bugvm.ios.AVFoundation.AVVideoSettings(getRecommendedVideoSettings0(outputFileType));
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @WeaklyLinked
    public com.bugvm.ios.AVFoundation.AVPixelBufferAttributes getRecommendedPixelBufferSettings(String outputFileType) {
        return new com.bugvm.ios.AVFoundation.AVPixelBufferAttributes(getRecommendedVideoSettings0(outputFileType).as(CFDictionary.class));
    }
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "setSampleBufferDelegate:queue:")
    public native void setSampleBufferDelegate(com.bugvm.ios.AVFoundation.AVCaptureVideoDataOutputSampleBufferDelegate sampleBufferDelegate, DispatchQueue sampleBufferCallbackQueue);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "recommendedVideoSettingsForAssetWriterWithOutputFileType:")
    protected native NSDictionary<?, ?> getRecommendedVideoSettings0(String outputFileType);
    /*</methods>*/
}
