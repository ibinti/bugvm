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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetImageGenerator/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetImageGeneratorPtr extends Ptr<AVAssetImageGenerator, AVAssetImageGeneratorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetImageGenerator.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetImageGenerator() {}
    protected AVAssetImageGenerator(SkipInit skipInit) { super(skipInit); }
    public AVAssetImageGenerator(AVAsset asset) { super((SkipInit) null); initObject(init(asset)); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "asset")
    public native AVAsset getAsset();
    @Property(selector = "appliesPreferredTrackTransform")
    public native boolean appliesPreferredTrackTransform();
    @Property(selector = "setAppliesPreferredTrackTransform:")
    public native void setAppliesPreferredTrackTransform(boolean v);
    @Property(selector = "maximumSize")
    public native @ByVal CGSize getMaximumSize();
    @Property(selector = "setMaximumSize:")
    public native void setMaximumSize(@ByVal CGSize v);
    @Property(selector = "apertureMode")
    public native AVAssetImageGeneratorApertureMode getApertureMode();
    @Property(selector = "setApertureMode:")
    public native void setApertureMode(AVAssetImageGeneratorApertureMode v);
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
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "requestedTimeToleranceBefore")
    public native @ByVal CMTime getRequestedTimeToleranceBefore();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setRequestedTimeToleranceBefore:")
    public native void setRequestedTimeToleranceBefore(@ByVal CMTime v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "requestedTimeToleranceAfter")
    public native @ByVal CMTime getRequestedTimeToleranceAfter();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setRequestedTimeToleranceAfter:")
    public native void setRequestedTimeToleranceAfter(@ByVal CMTime v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAsset:")
    protected native @Pointer long init(AVAsset asset);
    @WeaklyLinked
    public CGImage getCGImageAtTime(@ByVal CMTime requestedTime, CMTime actualTime) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       CGImage result = getCGImageAtTime(requestedTime, actualTime, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @WeaklyLinked
    @Method(selector = "copyCGImageAtTime:actualTime:error:")
    private native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CGImage getCGImageAtTime(@ByVal CMTime requestedTime, CMTime actualTime, NSError.NSErrorPtr outError);
    @Method(selector = "generateCGImagesAsynchronouslyForTimes:completionHandler:")
    public native void generateCGImagesAsynchronously(@com.bugvm.rt.bro.annotation.Marshaler(CMTime.AsValuedListMarshaler.class) List<CMTime> requestedTimes, @Block VoidBlock5<CMTime, CGImage, CMTime, AVAssetImageGeneratorResult, NSError> handler);
    @Method(selector = "cancelAllCGImageGeneration")
    public native void cancelAllCGImageGeneration();
    /*</methods>*/
}
