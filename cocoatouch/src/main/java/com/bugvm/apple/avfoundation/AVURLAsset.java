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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVURLAsset/*</name>*/ 
    extends /*<extends>*/AVAsset/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVURLAssetPtr extends Ptr<AVURLAsset, AVURLAssetPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVURLAsset.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVURLAsset() {}
    protected AVURLAsset(long handle) { super(handle); }
    protected AVURLAsset(SkipInit skipInit) { super(skipInit); }
    public AVURLAsset(NSURL URL, AVURLAssetOptions options) { super((SkipInit) null); initObject(init(URL, options)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "URL")
    public native NSURL getURL();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "resourceLoader")
    public native AVAssetResourceLoader getResourceLoader();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithURL:options:")
    protected native @Pointer long init(NSURL URL, AVURLAssetOptions options);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "audiovisualTypes")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAudiovisualTypes();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "audiovisualMIMETypes")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAudiovisualMIMETypes();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "isPlayableExtendedMIMEType:")
    public static native boolean isPlayableExtendedMIMEType(String extendedMIMEType);
    @Method(selector = "compatibleTrackForCompositionTrack:")
    public native AVAssetTrack getCompatibleTrack(AVCompositionTrack compositionTrack);
    /*</methods>*/
}
