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

/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVFragmentedAsset/*</name>*/ 
    extends /*<extends>*/AVURLAsset/*</extends>*/
    /*<implements>*/implements com.bugvm.ios.AVFoundation.AVFragmentMinding/*</implements>*/ {

    /*<ptr>*/public static class AVFragmentedAssetPtr extends Ptr<AVFragmentedAsset, AVFragmentedAssetPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVFragmentedAsset.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVFragmentedAsset() {}
    protected AVFragmentedAsset(SkipInit skipInit) { super(skipInit); }
    public AVFragmentedAsset(NSURL URL, com.bugvm.ios.AVFoundation.AVURLAssetOptions options) { super(create(URL, options)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "tracks")
    public native NSArray<com.bugvm.ios.AVFoundation.AVFragmentedAssetTrack> getTracks();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "fragmentedAssetWithURL:options:")
    protected static native @Pointer long create(NSURL URL, com.bugvm.ios.AVFoundation.AVURLAssetOptions options);
    @Method(selector = "trackWithTrackID:")
    public native com.bugvm.ios.AVFoundation.AVFragmentedAssetTrack getTrack(int trackID);
    @Method(selector = "tracksWithMediaType:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVFragmentedAssetTrack> getTracksForMediaType(com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    @Method(selector = "tracksWithMediaCharacteristic:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVFragmentedAssetTrack> getTracksForMediaCharacteristic(com.bugvm.ios.AVFoundation.AVMediaCharacteristic mediaCharacteristic);
    /*</methods>*/
}
