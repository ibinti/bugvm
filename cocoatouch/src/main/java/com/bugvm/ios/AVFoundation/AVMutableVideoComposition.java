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
import com.bugvm.objc.block.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMutableVideoComposition/*</name>*/ 
    extends /*<extends>*/AVVideoComposition/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVMutableVideoCompositionPtr extends Ptr<AVMutableVideoComposition, AVMutableVideoCompositionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVMutableVideoComposition.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVMutableVideoComposition() {}
    protected AVMutableVideoComposition(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 6.0 and later.
     */
    public AVMutableVideoComposition(com.bugvm.ios.AVFoundation.AVAsset asset) { super(create(asset)); retain(getHandle()); }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public AVMutableVideoComposition(com.bugvm.ios.AVFoundation.AVAsset asset, @Block VoidBlock1<com.bugvm.ios.AVFoundation.AVAsynchronousCIImageFilteringRequest> ciFiltersApplier) { super(create(asset, ciFiltersApplier)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "customVideoCompositorClass")
    public native Class<? extends com.bugvm.ios.AVFoundation.AVVideoCompositing> getCustomVideoCompositorClass();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setCustomVideoCompositorClass:")
    public native void setCustomVideoCompositorClass(Class<? extends com.bugvm.ios.AVFoundation.AVVideoCompositing> v);
    @Property(selector = "frameDuration")
    public native @ByVal CMTime getFrameDuration();
    @Property(selector = "setFrameDuration:")
    public native void setFrameDuration(@ByVal CMTime v);
    @Property(selector = "renderSize")
    public native @ByVal CGSize getRenderSize();
    @Property(selector = "setRenderSize:")
    public native void setRenderSize(@ByVal CGSize v);
    @Property(selector = "renderScale")
    public native float getRenderScale();
    @Property(selector = "setRenderScale:")
    public native void setRenderScale(float v);
    @Property(selector = "instructions")
    public native NSArray<com.bugvm.ios.AVFoundation.AVVideoCompositionInstruction> getInstructions();
    @Property(selector = "setInstructions:")
    public native void setInstructions(NSArray<com.bugvm.ios.AVFoundation.AVVideoCompositionInstruction> v);
    @Property(selector = "animationTool")
    public native com.bugvm.ios.AVFoundation.AVVideoCompositionCoreAnimationTool getAnimationTool();
    @Property(selector = "setAnimationTool:")
    public native void setAnimationTool(com.bugvm.ios.AVFoundation.AVVideoCompositionCoreAnimationTool v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "videoCompositionWithPropertiesOfAsset:")
    protected static native @Pointer long create(com.bugvm.ios.AVFoundation.AVAsset asset);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "videoCompositionWithAsset:applyingCIFiltersWithHandler:")
    protected static native @Pointer long create(com.bugvm.ios.AVFoundation.AVAsset asset, @Block VoidBlock1<com.bugvm.ios.AVFoundation.AVAsynchronousCIImageFilteringRequest> ciFiltersApplier);
    /*</methods>*/
}
