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
package com.bugvm.apple.spritekit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.avfoundation.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.scenekit.*;
import com.bugvm.apple.gameplaykit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("SpriteKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKTexture/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class SKTexturePtr extends Ptr<SKTexture, SKTexturePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKTexture.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKTexture() {}
    protected SKTexture(SkipInit skipInit) { super(skipInit); }
    public SKTexture(String name) { super(create(name)); retain(getHandle()); }
    public SKTexture(@ByVal CGRect rect, SKTexture texture) { super(create(rect, texture)); retain(getHandle()); }
    public SKTexture(CGImage image) { super(create(image)); retain(getHandle()); }
    public SKTexture(UIImage image) { super(create(image)); retain(getHandle()); }
    public SKTexture(NSData pixelData, @ByVal CGSize size) { super(create(pixelData, size)); retain(getHandle()); }
    public SKTexture(NSData pixelData, @ByVal CGSize size, boolean flipped) { super(create(pixelData, size, flipped)); retain(getHandle()); }
    public SKTexture(NSData pixelData, @ByVal CGSize size, int rowLength, int alignment) { super(create(pixelData, size, rowLength, alignment)); retain(getHandle()); }
    public SKTexture(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "filteringMode")
    public native SKTextureFilteringMode getFilteringMode();
    @Property(selector = "setFilteringMode:")
    public native void setFilteringMode(SKTextureFilteringMode v);
    @Property(selector = "usesMipmaps")
    public native boolean usesMipmaps();
    @Property(selector = "setUsesMipmaps:")
    public native void setUsesMipmaps(boolean v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "CGImage")
    public native CGImage getCGImage();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "textureByApplyingCIFilter:")
    public native SKTexture newTextureByApplyingCIFilter(CIFilter filter);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "textureByGeneratingNormalMap")
    public native SKTexture newTextureByGeneratingNormalMap();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "textureByGeneratingNormalMapWithSmoothness:contrast:")
    public native SKTexture newTextureByGeneratingNormalMap(@MachineSizedFloat double smoothness, @MachineSizedFloat double contrast);
    @Method(selector = "textureRect")
    public native @ByVal CGRect getTextureRect();
    @Method(selector = "size")
    public native @ByVal CGSize size();
    @Method(selector = "preloadWithCompletionHandler:")
    public native void preload(@Block Runnable completionHandler);
    @Method(selector = "textureWithImageNamed:")
    protected static native @Pointer long create(String name);
    @Method(selector = "textureWithRect:inTexture:")
    protected static native @Pointer long create(@ByVal CGRect rect, SKTexture texture);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "textureVectorNoiseWithSmoothness:size:")
    public static native SKTexture createVectorNoise(@MachineSizedFloat double smoothness, @ByVal CGSize size);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "textureNoiseWithSmoothness:size:grayscale:")
    public static native SKTexture createNoise(@MachineSizedFloat double smoothness, @ByVal CGSize size, boolean grayscale);
    @Method(selector = "textureWithCGImage:")
    protected static native @Pointer long create(CGImage image);
    @Method(selector = "textureWithImage:")
    protected static native @Pointer long create(UIImage image);
    @Method(selector = "textureWithData:size:")
    protected static native @Pointer long create(NSData pixelData, @ByVal CGSize size);
    @Method(selector = "textureWithData:size:flipped:")
    protected static native @Pointer long create(NSData pixelData, @ByVal CGSize size, boolean flipped);
    @Method(selector = "textureWithData:size:rowLength:alignment:")
    protected static native @Pointer long create(NSData pixelData, @ByVal CGSize size, int rowLength, int alignment);
    @Method(selector = "preloadTextures:withCompletionHandler:")
    public static native void preloadTextures(NSArray<SKTexture> textures, @Block Runnable completionHandler);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
