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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetExportSession/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetExportSessionPtr extends Ptr<AVAssetExportSession, AVAssetExportSessionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetExportSession.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetExportSession() {}
    protected AVAssetExportSession(SkipInit skipInit) { super(skipInit); }
    public AVAssetExportSession(AVAsset asset, AVAssetExportPreset presetName) { super((SkipInit) null); initObject(init(asset, presetName)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "presetName")
    public native AVAssetExportPreset getPresetName();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "asset")
    public native AVAsset getAsset();
    @Property(selector = "outputFileType")
    public native String getOutputFileType();
    @Property(selector = "setOutputFileType:")
    public native void setOutputFileType(String v);
    @Property(selector = "outputURL")
    public native NSURL getOutputURL();
    @Property(selector = "setOutputURL:")
    public native void setOutputURL(NSURL v);
    @Property(selector = "shouldOptimizeForNetworkUse")
    public native boolean shouldOptimizeForNetworkUse();
    @Property(selector = "setShouldOptimizeForNetworkUse:")
    public native void setShouldOptimizeForNetworkUse(boolean v);
    @Property(selector = "status")
    public native AVAssetExportSessionStatus getStatus();
    @Property(selector = "error")
    public native NSError getError();
    @Property(selector = "progress")
    public native float getProgress();
    @Property(selector = "supportedFileTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getSupportedFileTypes();
    @Property(selector = "timeRange")
    public native @ByVal CMTimeRange getTimeRange();
    @Property(selector = "setTimeRange:")
    public native void setTimeRange(@ByVal CMTimeRange v);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "maxDuration")
    public native @ByVal CMTime getMaxDuration();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "estimatedOutputFileLength")
    public native long getEstimatedOutputFileLength();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "fileLengthLimit")
    public native long getFileLengthLimit();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "setFileLengthLimit:")
    public native void setFileLengthLimit(long v);
    @Property(selector = "metadata")
    public native NSArray<AVMetadataItem> getMetadata();
    @Property(selector = "setMetadata:")
    public native void setMetadata(NSArray<AVMetadataItem> v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "metadataItemFilter")
    public native AVMetadataItemFilter getMetadataItemFilter();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setMetadataItemFilter:")
    public native void setMetadataItemFilter(AVMetadataItemFilter v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "audioTimePitchAlgorithm")
    public native AVAudioTimePitchAlgorithm getAudioTimePitchAlgorithm();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setAudioTimePitchAlgorithm:")
    public native void setAudioTimePitchAlgorithm(AVAudioTimePitchAlgorithm v);
    @Property(selector = "audioMix")
    public native AVAudioMix getAudioMix();
    @Property(selector = "setAudioMix:")
    public native void setAudioMix(AVAudioMix v);
    @Property(selector = "videoComposition")
    public native AVVideoComposition getVideoComposition();
    @Property(selector = "setVideoComposition:")
    public native void setVideoComposition(AVVideoComposition v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "customVideoCompositor")
    public native AVVideoCompositing getCustomVideoCompositor();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "canPerformMultiplePassesOverSourceMediaData")
    public native boolean canPerformMultiplePassesOverSourceMediaData();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setCanPerformMultiplePassesOverSourceMediaData:")
    public native void setCanPerformMultiplePassesOverSourceMediaData(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "directoryForTemporaryFiles")
    public native NSURL getDirectoryForTemporaryFiles();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setDirectoryForTemporaryFiles:")
    public native void setDirectoryForTemporaryFiles(NSURL v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAsset:presetName:")
    protected native @Pointer long init(AVAsset asset, AVAssetExportPreset presetName);
    @Method(selector = "exportAsynchronouslyWithCompletionHandler:")
    public native void exportAsynchronously(@Block Runnable handler);
    @Method(selector = "cancelExport")
    public native void cancelExport();
    @Method(selector = "allExportPresets")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(AVAssetExportPreset.AsListMarshaler.class) List<AVAssetExportPreset> getAllExportPresets();
    @Method(selector = "exportPresetsCompatibleWithAsset:")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(AVAssetExportPreset.AsListMarshaler.class) List<AVAssetExportPreset> getCompatibleExportPresets(AVAsset asset);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "determineCompatibilityOfExportPreset:withAsset:outputFileType:completionHandler:")
    public static native void determineCompatibilityOfExportPreset(AVAssetExportPreset presetName, AVAsset asset, String outputFileType, @Block VoidBooleanBlock handler);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "determineCompatibleFileTypesWithCompletionHandler:")
    public native void determineCompatibleFileTypes(@Block VoidBlock1<NSArray<NSString>> handler);
    /*</methods>*/
}
