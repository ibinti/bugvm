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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNPhysicsBody/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNPhysicsBodyPtr extends Ptr<SCNPhysicsBody, SCNPhysicsBodyPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNPhysicsBody.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNPhysicsBody() {}
    protected SCNPhysicsBody(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "type")
    public native SCNPhysicsBodyType getType();
    @Property(selector = "setType:")
    public native void setType(SCNPhysicsBodyType v);
    @Property(selector = "mass")
    public native @MachineSizedFloat double getMass();
    @Property(selector = "setMass:")
    public native void setMass(@MachineSizedFloat double v);
    @Property(selector = "charge")
    public native @MachineSizedFloat double getCharge();
    @Property(selector = "setCharge:")
    public native void setCharge(@MachineSizedFloat double v);
    @Property(selector = "friction")
    public native @MachineSizedFloat double getFriction();
    @Property(selector = "setFriction:")
    public native void setFriction(@MachineSizedFloat double v);
    @Property(selector = "restitution")
    public native @MachineSizedFloat double getRestitution();
    @Property(selector = "setRestitution:")
    public native void setRestitution(@MachineSizedFloat double v);
    @Property(selector = "rollingFriction")
    public native @MachineSizedFloat double getRollingFriction();
    @Property(selector = "setRollingFriction:")
    public native void setRollingFriction(@MachineSizedFloat double v);
    @Property(selector = "physicsShape")
    public native SCNPhysicsShape getPhysicsShape();
    @Property(selector = "setPhysicsShape:")
    public native void setPhysicsShape(SCNPhysicsShape v);
    @Property(selector = "isResting")
    public native boolean isResting();
    @Property(selector = "allowsResting")
    public native boolean allowsResting();
    @Property(selector = "setAllowsResting:")
    public native void setAllowsResting(boolean v);
    @Property(selector = "velocity")
    public native @ByVal SCNVector3 getVelocity();
    @Property(selector = "setVelocity:")
    public native void setVelocity(@ByVal SCNVector3 v);
    @Property(selector = "angularVelocity")
    public native @ByVal SCNVector4 getAngularVelocity();
    @Property(selector = "setAngularVelocity:")
    public native void setAngularVelocity(@ByVal SCNVector4 v);
    @Property(selector = "damping")
    public native @MachineSizedFloat double getDamping();
    @Property(selector = "setDamping:")
    public native void setDamping(@MachineSizedFloat double v);
    @Property(selector = "angularDamping")
    public native @MachineSizedFloat double getAngularDamping();
    @Property(selector = "setAngularDamping:")
    public native void setAngularDamping(@MachineSizedFloat double v);
    @Property(selector = "velocityFactor")
    public native @ByVal SCNVector3 getVelocityFactor();
    @Property(selector = "setVelocityFactor:")
    public native void setVelocityFactor(@ByVal SCNVector3 v);
    @Property(selector = "angularVelocityFactor")
    public native @ByVal SCNVector3 getAngularVelocityFactor();
    @Property(selector = "setAngularVelocityFactor:")
    public native void setAngularVelocityFactor(@ByVal SCNVector3 v);
    @Property(selector = "categoryBitMask")
    public native @MachineSizedUInt long getCategoryBitMask();
    @Property(selector = "setCategoryBitMask:")
    public native void setCategoryBitMask(@MachineSizedUInt long v);
    @Property(selector = "collisionBitMask")
    public native SCNPhysicsCollisionCategory getCollisionBitMask();
    @Property(selector = "setCollisionBitMask:", strongRef = true)
    public native void setCollisionBitMask(SCNPhysicsCollisionCategory v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "applyForce:impulse:")
    public native void applyForce(@ByVal SCNVector3 direction, boolean impulse);
    @Method(selector = "applyForce:atPosition:impulse:")
    public native void applyForce(@ByVal SCNVector3 direction, @ByVal SCNVector3 position, boolean impulse);
    @Method(selector = "applyTorque:impulse:")
    public native void applyTorque(@ByVal SCNVector4 torque, boolean impulse);
    @Method(selector = "clearAllForces")
    public native void clearAllForces();
    @Method(selector = "resetTransform")
    public native void resetTransform();
    @Method(selector = "staticBody")
    public static native SCNPhysicsBody createStaticBody();
    @Method(selector = "dynamicBody")
    public static native SCNPhysicsBody createDynamicBody();
    @Method(selector = "kinematicBody")
    public static native SCNPhysicsBody createKinematicBody();
    @Method(selector = "bodyWithType:shape:")
    public static native SCNPhysicsBody create(SCNPhysicsBodyType type, SCNPhysicsShape shape);
    /*</methods>*/
}
