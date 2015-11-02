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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVVideoCompositionLayerInstruction/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {
    /*<ptr>*/public static class AVVideoCompositionLayerInstructionPtr extends Ptr<AVVideoCompositionLayerInstruction, AVVideoCompositionLayerInstructionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVVideoCompositionLayerInstruction.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVVideoCompositionLayerInstruction() {}
    protected AVVideoCompositionLayerInstruction(long handle) { super(handle); }
    protected AVVideoCompositionLayerInstruction(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "trackID")
    public native int getTrackID();
    /*</properties>*/
    /*<members>*//*</members>*/
    public AVTimeRamp<CGAffineTransform> getTransformRamp(CMTime time) {
        CGAffineTransform.CGAffineTransformPtr start = new CGAffineTransform.CGAffineTransformPtr();
        CGAffineTransform.CGAffineTransformPtr end = new CGAffineTransform.CGAffineTransformPtr();
        CMTimeRange.CMTimeRangePtr timeRange = new CMTimeRange.CMTimeRangePtr();
        boolean valid = getTransformRamp(time, start, end, timeRange);
        if (valid) {
            return new AVTimeRamp<CGAffineTransform>(start.get(), end.get(), timeRange.get());
        }
        return null;
    }
    public AVTimeRamp<Float> getOpacityRamp(CMTime time) {
        FloatPtr start = new FloatPtr();
        FloatPtr end = new FloatPtr();
        CMTimeRange.CMTimeRangePtr timeRange = new CMTimeRange.CMTimeRangePtr();
        boolean valid = getOpacityRamp(time, start, end, timeRange);
        if (valid) {
            return new AVTimeRamp<Float>(start.get(), end.get(), timeRange.get());
        }
        return null;
    }
    public AVTimeRamp<CGRect> getCropRectangleRamp(CMTime time) {
        CGRect.CGRectPtr start = new CGRect.CGRectPtr();
        CGRect.CGRectPtr end = new CGRect.CGRectPtr();
        CMTimeRange.CMTimeRangePtr timeRange = new CMTimeRange.CMTimeRangePtr();
        boolean valid = getCropRectangleRamp(time, start, end, timeRange);
        if (valid) {
            return new AVTimeRamp<CGRect>(start.get(), end.get(), timeRange.get());
        }
        return null;
    }
    /*<methods>*/
    @Method(selector = "getTransformRampForTime:startTransform:endTransform:timeRange:")
    protected native boolean getTransformRamp(@ByVal CMTime time, CGAffineTransform.CGAffineTransformPtr startTransform, CGAffineTransform.CGAffineTransformPtr endTransform, CMTimeRange.CMTimeRangePtr timeRange);
    @Method(selector = "getOpacityRampForTime:startOpacity:endOpacity:timeRange:")
    protected native boolean getOpacityRamp(@ByVal CMTime time, FloatPtr startOpacity, FloatPtr endOpacity, CMTimeRange.CMTimeRangePtr timeRange);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "getCropRectangleRampForTime:startCropRectangle:endCropRectangle:timeRange:")
    protected native boolean getCropRectangleRamp(@ByVal CMTime time, CGRect.CGRectPtr startCropRectangle, CGRect.CGRectPtr endCropRectangle, CMTimeRange.CMTimeRangePtr timeRange);
    /*</methods>*/
}
