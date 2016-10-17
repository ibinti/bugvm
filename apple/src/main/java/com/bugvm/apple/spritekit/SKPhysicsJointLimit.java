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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKPhysicsJointLimit/*</name>*/ 
    extends /*<extends>*/SKPhysicsJoint/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKPhysicsJointLimitPtr extends Ptr<SKPhysicsJointLimit, SKPhysicsJointLimitPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKPhysicsJointLimit.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKPhysicsJointLimit() {}
    protected SKPhysicsJointLimit(SkipInit skipInit) { super(skipInit); }
    public SKPhysicsJointLimit(SKPhysicsBody bodyA, SKPhysicsBody bodyB, @ByVal CGPoint anchorA, @ByVal CGPoint anchorB) { super(create(bodyA, bodyB, anchorA, anchorB)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "maxLength")
    public native @MachineSizedFloat double getMaxLength();
    @Property(selector = "setMaxLength:")
    public native void setMaxLength(@MachineSizedFloat double v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "jointWithBodyA:bodyB:anchorA:anchorB:")
    protected static native @Pointer long create(SKPhysicsBody bodyA, SKPhysicsBody bodyB, @ByVal CGPoint anchorA, @ByVal CGPoint anchorB);
    /*</methods>*/
}
