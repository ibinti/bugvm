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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNCamera/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements SCNAnimatable, SCNTechniqueSupport/*</implements>*/ {

    /*<ptr>*/public static class SCNCameraPtr extends Ptr<SCNCamera, SCNCameraPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNCamera.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNCamera() {}
    protected SCNCamera(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "setName:")
    public native void setName(String v);
    @Property(selector = "xFov")
    public native double getXFov();
    @Property(selector = "setXFov:")
    public native void setXFov(double v);
    @Property(selector = "yFov")
    public native double getYFov();
    @Property(selector = "setYFov:")
    public native void setYFov(double v);
    @Property(selector = "zNear")
    public native double getZNear();
    @Property(selector = "setZNear:")
    public native void setZNear(double v);
    @Property(selector = "zFar")
    public native double getZFar();
    @Property(selector = "setZFar:")
    public native void setZFar(double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "automaticallyAdjustsZRange")
    public native boolean automaticallyAdjustsZRange();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setAutomaticallyAdjustsZRange:")
    public native void setAutomaticallyAdjustsZRange(boolean v);
    @Property(selector = "usesOrthographicProjection")
    public native boolean usesOrthographicProjection();
    @Property(selector = "setUsesOrthographicProjection:")
    public native void setUsesOrthographicProjection(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "orthographicScale")
    public native double getOrthographicScale();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setOrthographicScale:")
    public native void setOrthographicScale(double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "focalDistance")
    public native @MachineSizedFloat double getFocalDistance();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFocalDistance:")
    public native void setFocalDistance(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "focalSize")
    public native @MachineSizedFloat double getFocalSize();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFocalSize:")
    public native void setFocalSize(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "focalBlurRadius")
    public native @MachineSizedFloat double getFocalBlurRadius();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFocalBlurRadius:")
    public native void setFocalBlurRadius(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "aperture")
    public native @MachineSizedFloat double getAperture();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setAperture:")
    public native void setAperture(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "categoryBitMask")
    public native @MachineSizedUInt long getCategoryBitMask();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setCategoryBitMask:")
    public native void setCategoryBitMask(@MachineSizedUInt long v);
    @Property(selector = "technique")
    public native SCNTechnique getTechnique();
    @Property(selector = "setTechnique:")
    public native void setTechnique(SCNTechnique v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "projectionTransform")
    public native @ByVal SCNMatrix4 getProjectionTransform();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setProjectionTransform:")
    public native void setProjectionTransform(@ByVal SCNMatrix4 projectionTransform);
    @Method(selector = "camera")
    public static native SCNCamera create();
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
