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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKSpriteNode/*</name>*/ 
    extends /*<extends>*/SKNode/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKSpriteNodePtr extends Ptr<SKSpriteNode, SKSpriteNodePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKSpriteNode.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKSpriteNode() {}
    protected SKSpriteNode(SkipInit skipInit) { super(skipInit); }
    public SKSpriteNode(SKTexture texture, UIColor color, @ByVal CGSize size) { super((SkipInit) null); initObject(init(texture, color, size)); }
    public SKSpriteNode(SKTexture texture) { super((SkipInit) null); initObject(init(texture)); }
    public SKSpriteNode(String name) { super((SkipInit) null); initObject(init(name)); }
    public SKSpriteNode(UIColor color, @ByVal CGSize size) { super((SkipInit) null); initObject(init(color, size)); }
    public SKSpriteNode(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    public SKSpriteNode(SKTexture texture, @ByVal CGSize size) { super(create(texture, size)); retain(getHandle()); }
    public SKSpriteNode(SKTexture texture, SKTexture normalMap) { super(create(texture, normalMap)); retain(getHandle()); }
    public SKSpriteNode(String name, boolean generateNormalMap) { super(create(name, generateNormalMap)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "texture")
    public native SKTexture getTexture();
    @Property(selector = "setTexture:")
    public native void setTexture(SKTexture v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "normalTexture")
    public native SKTexture getNormalTexture();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setNormalTexture:")
    public native void setNormalTexture(SKTexture v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "lightingBitMask")
    public native int getLightingBitMask();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setLightingBitMask:")
    public native void setLightingBitMask(int v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "shadowCastBitMask")
    public native int getShadowCastBitMask();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setShadowCastBitMask:")
    public native void setShadowCastBitMask(int v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "shadowedBitMask")
    public native int getShadowedBitMask();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setShadowedBitMask:")
    public native void setShadowedBitMask(int v);
    @Property(selector = "centerRect")
    public native @ByVal CGRect getCenterRect();
    @Property(selector = "setCenterRect:")
    public native void setCenterRect(@ByVal CGRect v);
    @Property(selector = "colorBlendFactor")
    public native @MachineSizedFloat double getColorBlendFactor();
    @Property(selector = "setColorBlendFactor:")
    public native void setColorBlendFactor(@MachineSizedFloat double v);
    @Property(selector = "color")
    public native UIColor getColor();
    @Property(selector = "setColor:")
    public native void setColor(UIColor v);
    @Property(selector = "blendMode")
    public native SKBlendMode getBlendMode();
    @Property(selector = "setBlendMode:")
    public native void setBlendMode(SKBlendMode v);
    @Property(selector = "anchorPoint")
    public native @ByVal CGPoint getAnchorPoint();
    @Property(selector = "setAnchorPoint:")
    public native void setAnchorPoint(@ByVal CGPoint v);
    @Property(selector = "size")
    public native @ByVal CGSize getSize();
    @Property(selector = "setSize:")
    public native void setSize(@ByVal CGSize v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "shader")
    public native SKShader getShader();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setShader:")
    public native void setShader(SKShader v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithTexture:color:size:")
    protected native @Pointer long init(SKTexture texture, UIColor color, @ByVal CGSize size);
    @Method(selector = "initWithTexture:")
    protected native @Pointer long init(SKTexture texture);
    @Method(selector = "initWithImageNamed:")
    protected native @Pointer long init(String name);
    @Method(selector = "initWithColor:size:")
    protected native @Pointer long init(UIColor color, @ByVal CGSize size);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "spriteNodeWithTexture:size:")
    protected static native @Pointer long create(SKTexture texture, @ByVal CGSize size);
    @Method(selector = "spriteNodeWithTexture:normalMap:")
    protected static native @Pointer long create(SKTexture texture, SKTexture normalMap);
    @Method(selector = "spriteNodeWithImageNamed:normalMapped:")
    protected static native @Pointer long create(String name, boolean generateNormalMap);
    /*</methods>*/
}
