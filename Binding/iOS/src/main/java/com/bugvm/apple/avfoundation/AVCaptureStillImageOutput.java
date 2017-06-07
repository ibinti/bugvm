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
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureStillImageOutput/*</name>*/ 
    extends /*<extends>*/AVCaptureOutput/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVCaptureStillImageOutputPtr extends Ptr<AVCaptureStillImageOutput, AVCaptureStillImageOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVCaptureStillImageOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVCaptureStillImageOutput() {}
    protected AVCaptureStillImageOutput(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public AVVideoSettings getVideoOutputSettings() {
        return new AVVideoSettings(getOutputSettings0());
    }
    public void setVideoOutputSettings(AVVideoSettings outputSettings) {
        setOutputSettings0(outputSettings.getDictionary());
    }
    @WeaklyLinked
    public AVPixelBufferAttributes getPixelBufferOutputSettings() {
        return new AVPixelBufferAttributes(getOutputSettings0().as(CFDictionary.class));
    }
    @SuppressWarnings("unchecked")
    public void setPixelBufferOutputSettings(AVPixelBufferAttributes outputSettings) {
        setOutputSettings0(outputSettings.getDictionary().as(NSDictionary.class));
    }
    /*<properties>*/
    @Property(selector = "outputSettings")
    protected native NSDictionary<?, ?> getOutputSettings0();
    @Property(selector = "setOutputSettings:")
    protected native void setOutputSettings0(NSDictionary<?, ?> v);
    @Property(selector = "availableImageDataCVPixelFormatTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CVPixelFormatType.AsListMarshaler.class) List<CVPixelFormatType> getAvailableImageDataCVPixelFormatTypes();
    @Property(selector = "availableImageDataCodecTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CMVideoCodecType.AsListMarshaler.class) List<CMVideoCodecType> getAvailableImageDataCodecTypes();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isStillImageStabilizationSupported")
    public native boolean isStillImageStabilizationSupported();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "automaticallyEnablesStillImageStabilizationWhenAvailable")
    public native boolean automaticallyEnablesStillImageStabilizationWhenAvailable();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setAutomaticallyEnablesStillImageStabilizationWhenAvailable:")
    public native void setAutomaticallyEnablesStillImageStabilizationWhenAvailable(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isStillImageStabilizationActive")
    public native boolean isStillImageStabilizationActive();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "isHighResolutionStillImageOutputEnabled")
    public native boolean isHighResolutionStillImageOutputEnabled();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setHighResolutionStillImageOutputEnabled:")
    public native void setHighResolutionStillImageOutputEnabled(boolean v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isCapturingStillImage")
    public native boolean isCapturingStillImage();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "maxBracketedCaptureStillImageCount")
    public native @MachineSizedUInt long getMaxBracketedCaptureStillImageCount();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "isLensStabilizationDuringBracketedCaptureSupported")
    public native boolean isLensStabilizationDuringBracketedCaptureSupported();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "isLensStabilizationDuringBracketedCaptureEnabled")
    public native boolean isLensStabilizationDuringBracketedCaptureEnabled();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setLensStabilizationDuringBracketedCaptureEnabled:")
    public native void setLensStabilizationDuringBracketedCaptureEnabled(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "captureStillImageAsynchronouslyFromConnection:completionHandler:")
    public native void captureStillImageAsynchronously(AVCaptureConnection connection, @Block VoidBlock2<CMSampleBuffer, NSError> handler);
    @Method(selector = "jpegStillImageNSDataRepresentation:")
    public static native NSData createJPEGStillImageNSDataRepresentation(CMSampleBuffer jpegSampleBuffer);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "prepareToCaptureStillImageBracketFromConnection:withSettingsArray:completionHandler:")
    public native void prepareToCaptureStillImageBracket(AVCaptureConnection connection, NSArray<AVCaptureBracketedStillImageSettings> settings, @Block VoidBlock2<Boolean, NSError> handler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "captureStillImageBracketAsynchronouslyFromConnection:withSettingsArray:completionHandler:")
    public native void captureStillImageBracketAsynchronously(AVCaptureConnection connection, NSArray<AVCaptureBracketedStillImageSettings> settings, @Block VoidBlock3<CMSampleBuffer, AVCaptureBracketedStillImageSettings, NSError> handler);
    /*</methods>*/
}
