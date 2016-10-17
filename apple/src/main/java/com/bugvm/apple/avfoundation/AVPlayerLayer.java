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
/*<annotations>*/@Library("AVFoundation") @NativeClass @WeaklyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVPlayerLayer/*</name>*/ 
    extends /*<extends>*/CALayer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVPlayerLayerPtr extends Ptr<AVPlayerLayer, AVPlayerLayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVPlayerLayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVPlayerLayer() {}
    protected AVPlayerLayer(SkipInit skipInit) { super(skipInit); }
    public AVPlayerLayer(AVPlayer player) { super(create(player)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "player")
    public native AVPlayer getPlayer();
    @Property(selector = "setPlayer:")
    public native void setPlayer(AVPlayer v);
    @Property(selector = "videoGravity")
    public native AVLayerVideoGravity getVideoGravity();
    @Property(selector = "setVideoGravity:")
    public native void setVideoGravity(AVLayerVideoGravity v);
    @Property(selector = "isReadyForDisplay")
    public native boolean isReadyForDisplay();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "videoRect")
    public native @ByVal CGRect getVideoRect();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "pixelBufferAttributes")
    public native CVPixelBufferAttributes getPixelBufferAttributes();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setPixelBufferAttributes:")
    public native void setPixelBufferAttributes(CVPixelBufferAttributes v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "playerLayerWithPlayer:")
    protected static native @Pointer long create(AVPlayer player);
    /*</methods>*/
}
