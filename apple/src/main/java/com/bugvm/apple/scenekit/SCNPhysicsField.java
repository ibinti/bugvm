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

/*</javadoc>*/
/*<annotations>*/@Library("SceneKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNPhysicsField/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNPhysicsFieldPtr extends Ptr<SCNPhysicsField, SCNPhysicsFieldPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNPhysicsField.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNPhysicsField() {}
    protected SCNPhysicsField(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "strength")
    public native @MachineSizedFloat double getStrength();
    @Property(selector = "setStrength:")
    public native void setStrength(@MachineSizedFloat double v);
    @Property(selector = "falloffExponent")
    public native @MachineSizedFloat double getFalloffExponent();
    @Property(selector = "setFalloffExponent:")
    public native void setFalloffExponent(@MachineSizedFloat double v);
    @Property(selector = "minimumDistance")
    public native @MachineSizedFloat double getMinimumDistance();
    @Property(selector = "setMinimumDistance:")
    public native void setMinimumDistance(@MachineSizedFloat double v);
    @Property(selector = "isActive")
    public native boolean isActive();
    @Property(selector = "setActive:")
    public native void setActive(boolean v);
    @Property(selector = "isExclusive")
    public native boolean isExclusive();
    @Property(selector = "setExclusive:")
    public native void setExclusive(boolean v);
    @Property(selector = "halfExtent")
    public native @ByVal SCNVector3 getHalfExtent();
    @Property(selector = "setHalfExtent:")
    public native void setHalfExtent(@ByVal SCNVector3 v);
    @Property(selector = "usesEllipsoidalExtent")
    public native boolean usesEllipsoidalExtent();
    @Property(selector = "setUsesEllipsoidalExtent:")
    public native void setUsesEllipsoidalExtent(boolean v);
    @Property(selector = "scope")
    public native SCNPhysicsFieldScope getScope();
    @Property(selector = "setScope:")
    public native void setScope(SCNPhysicsFieldScope v);
    @Property(selector = "offset")
    public native @ByVal SCNVector3 getOffset();
    @Property(selector = "setOffset:")
    public native void setOffset(@ByVal SCNVector3 v);
    @Property(selector = "direction")
    public native @ByVal SCNVector3 getDirection();
    @Property(selector = "setDirection:")
    public native void setDirection(@ByVal SCNVector3 v);
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
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "dragField")
    public static native SCNPhysicsField createDragField();
    @Method(selector = "vortexField")
    public static native SCNPhysicsField createVortexField();
    @Method(selector = "radialGravityField")
    public static native SCNPhysicsField createRadialGravityField();
    @Method(selector = "linearGravityField")
    public static native SCNPhysicsField createLinearGravityField();
    @Method(selector = "noiseFieldWithSmoothness:animationSpeed:")
    public static native SCNPhysicsField createNoiseField(@MachineSizedFloat double smoothness, @MachineSizedFloat double speed);
    @Method(selector = "turbulenceFieldWithSmoothness:animationSpeed:")
    public static native SCNPhysicsField createTurbulenceField(@MachineSizedFloat double smoothness, @MachineSizedFloat double speed);
    @Method(selector = "springField")
    public static native SCNPhysicsField createSpringField();
    @Method(selector = "electricField")
    public static native SCNPhysicsField createElectricField();
    @Method(selector = "magneticField")
    public static native SCNPhysicsField createMagneticField();
    @Method(selector = "customFieldWithEvaluationBlock:")
    public static native SCNPhysicsField createCustomField(@Block Block5<SCNVector3, SCNVector3, Float, Float, Double, SCNVector3> block);
    /*</methods>*/
}
