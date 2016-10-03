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
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetWriter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetWriterPtr extends Ptr<AVAssetWriter, AVAssetWriterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetWriter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetWriter() {}
    protected AVAssetWriter(SkipInit skipInit) { super(skipInit); }
    public AVAssetWriter(NSURL outputURL, String outputFileType) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(outputURL, outputFileType, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "outputURL")
    public native NSURL getOutputURL();
    @Property(selector = "outputFileType")
    public native String getOutputFileType();
    @Property(selector = "availableMediaTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVMediaType.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVMediaType> getAvailableMediaTypes();
    @Property(selector = "status")
    public native AVAssetWriterStatus getStatus();
    @Property(selector = "error")
    public native NSError getError();
    @Property(selector = "metadata")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getMetadata();
    @Property(selector = "setMetadata:")
    public native void setMetadata(NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> v);
    @Property(selector = "shouldOptimizeForNetworkUse")
    public native boolean shouldOptimizeForNetworkUse();
    @Property(selector = "setShouldOptimizeForNetworkUse:")
    public native void setShouldOptimizeForNetworkUse(boolean v);
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
    @Property(selector = "inputs")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetWriterInput> getInputs();
    @Property(selector = "movieFragmentInterval")
    public native @ByVal CMTime getMovieFragmentInterval();
    @Property(selector = "setMovieFragmentInterval:")
    public native void setMovieFragmentInterval(@ByVal CMTime v);
    @Property(selector = "overallDurationHint")
    public native @ByVal CMTime getOverallDurationHint();
    @Property(selector = "setOverallDurationHint:")
    public native void setOverallDurationHint(@ByVal CMTime v);
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "movieTimeScale")
    public native int getMovieTimeScale();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "setMovieTimeScale:")
    public native void setMovieTimeScale(int v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "inputGroups")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetWriterInputGroup> getInputGroups();
    /*</properties>*/
    /*<members>*//*</members>*/
    public boolean canApplyOutputSettings(com.bugvm.ios.AVFoundation.AVAudioSettings outputSettings, com.bugvm.ios.AVFoundation.AVMediaType mediaType) {
        return canApplyOutputSettings(outputSettings.getDictionary(), mediaType);
    }
    public boolean canApplyOutputSettings(com.bugvm.ios.AVFoundation.AVVideoSettings outputSettings, com.bugvm.ios.AVFoundation.AVMediaType mediaType) {
        return canApplyOutputSettings(outputSettings.getDictionary(), mediaType);
    }
    @SuppressWarnings("unchecked")
    public boolean canApplyOutputSettings(com.bugvm.ios.AVFoundation.AVPixelBufferAttributes outputSettings, com.bugvm.ios.AVFoundation.AVMediaType mediaType) {
        return canApplyOutputSettings(outputSettings.getDictionary().as(NSDictionary.class), mediaType);
    }
    /*<methods>*/
    @Method(selector = "initWithURL:fileType:error:")
    private native @Pointer long init(NSURL outputURL, String outputFileType, NSError.NSErrorPtr outError);
    @Method(selector = "canApplyOutputSettings:forMediaType:")
    protected native boolean canApplyOutputSettings(NSDictionary<?, ?> outputSettings, com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    @Method(selector = "canAddInput:")
    public native boolean canAddInput(com.bugvm.ios.AVFoundation.AVAssetWriterInput input);
    @Method(selector = "addInput:")
    public native void addInput(com.bugvm.ios.AVFoundation.AVAssetWriterInput input);
    @Method(selector = "startWriting")
    public native boolean startWriting();
    @Method(selector = "startSessionAtSourceTime:")
    public native void startSession(@ByVal CMTime startTime);
    @Method(selector = "endSessionAtSourceTime:")
    public native void endSession(@ByVal CMTime endTime);
    @Method(selector = "cancelWriting")
    public native void cancelWriting();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "finishWritingWithCompletionHandler:")
    public native void finishWriting(@Block Runnable handler);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "canAddInputGroup:")
    public native boolean canAddInputGroup(com.bugvm.ios.AVFoundation.AVAssetWriterInputGroup inputGroup);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "addInputGroup:")
    public native void addInputGroup(com.bugvm.ios.AVFoundation.AVAssetWriterInputGroup inputGroup);
    /*</methods>*/
}
