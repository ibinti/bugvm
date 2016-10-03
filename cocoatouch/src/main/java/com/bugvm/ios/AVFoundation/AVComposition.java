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
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVComposition/*</name>*/ 
    extends /*<extends>*/AVAsset/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVCompositionPtr extends Ptr<AVComposition, AVCompositionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVComposition.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVComposition() {}
    protected AVComposition(long handle) { super(handle); }
    protected AVComposition(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "tracks")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetTrack> getTracks();
    @Property(selector = "naturalSize")
    public native @ByVal CGSize getNaturalSize();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "URLAssetInitializationOptions")
    public native com.bugvm.ios.AVFoundation.AVURLAssetOptions getURLAssetInitializationOptions();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "trackWithTrackID:")
    public native com.bugvm.ios.AVFoundation.AVCompositionTrack getTrack(int trackID);
    @Method(selector = "tracksWithMediaType:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVCompositionTrack> getTracksForMediaType(com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    @Method(selector = "tracksWithMediaCharacteristic:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVCompositionTrack> getTracksForMediaCharacteristic(com.bugvm.ios.AVFoundation.AVMediaCharacteristic mediaCharacteristic);
    /*</methods>*/
}
