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
package com.bugvm.apple.scenekit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.spritekit.*;
import com.bugvm.apple.opengles.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("SceneKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNMaterialProperty/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements SCNAnimatable/*</implements>*/ {

    /*<ptr>*/public static class SCNMaterialPropertyPtr extends Ptr<SCNMaterialProperty, SCNMaterialPropertyPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNMaterialProperty.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNMaterialProperty() {}
    protected SCNMaterialProperty(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "contents")
    public native NSObject getContents();
    @Property(selector = "setContents:")
    public native void setContents(NSObject v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "intensity")
    public native @MachineSizedFloat double getIntensity();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setIntensity:")
    public native void setIntensity(@MachineSizedFloat double v);
    @Property(selector = "minificationFilter")
    public native SCNFilterMode getMinificationFilter();
    @Property(selector = "setMinificationFilter:")
    public native void setMinificationFilter(SCNFilterMode v);
    @Property(selector = "magnificationFilter")
    public native SCNFilterMode getMagnificationFilter();
    @Property(selector = "setMagnificationFilter:")
    public native void setMagnificationFilter(SCNFilterMode v);
    @Property(selector = "mipFilter")
    public native SCNFilterMode getMipFilter();
    @Property(selector = "setMipFilter:")
    public native void setMipFilter(SCNFilterMode v);
    @Property(selector = "contentsTransform")
    public native @ByVal SCNMatrix4 getContentsTransform();
    @Property(selector = "setContentsTransform:")
    public native void setContentsTransform(@ByVal SCNMatrix4 v);
    @Property(selector = "wrapS")
    public native SCNWrapMode getWrapS();
    @Property(selector = "setWrapS:")
    public native void setWrapS(SCNWrapMode v);
    @Property(selector = "wrapT")
    public native SCNWrapMode getWrapT();
    @Property(selector = "setWrapT:")
    public native void setWrapT(SCNWrapMode v);
    @Property(selector = "borderColor")
    public native NSObject getBorderColor();
    @Property(selector = "setBorderColor:")
    public native void setBorderColor(NSObject v);
    @Property(selector = "mappingChannel")
    public native @MachineSizedSInt long getMappingChannel();
    @Property(selector = "setMappingChannel:")
    public native void setMappingChannel(@MachineSizedSInt long v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "maxAnisotropy")
    public native @MachineSizedFloat double getMaxAnisotropy();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setMaxAnisotropy:")
    public native void setMaxAnisotropy(@MachineSizedFloat double v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "materialPropertyWithContents:")
    public static native SCNMaterialProperty create(NSObject contents);
    @Method(selector = "addAnimation:forKey:")
    public native void addAnimation(CAAnimation animation, String key);
    @Method(selector = "removeAllAnimations")
    public native void removeAllAnimations();
    @Method(selector = "removeAnimationForKey:")
    public native void removeAnimation(String key);
    @Method(selector = "animationKeys")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAnimationKeys();
    @Method(selector = "animationForKey:")
    public native CAAnimation getAnimation(String key);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "pauseAnimationForKey:")
    public native void pauseAnimation(String key);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "resumeAnimationForKey:")
    public native void resumeAnimation(String key);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "isAnimationForKeyPaused:")
    public native boolean isAnimationPaused(String key);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "removeAnimationForKey:fadeOutDuration:")
    public native void removeAnimation(String key, @MachineSizedFloat double duration);
    /*</methods>*/
}
