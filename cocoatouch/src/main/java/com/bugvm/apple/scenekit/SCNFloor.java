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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNFloor/*</name>*/ 
    extends /*<extends>*/SCNGeometry/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNFloorPtr extends Ptr<SCNFloor, SCNFloorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNFloor.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNFloor() {}
    protected SCNFloor(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "reflectivity")
    public native @MachineSizedFloat double getReflectivity();
    @Property(selector = "setReflectivity:")
    public native void setReflectivity(@MachineSizedFloat double v);
    @Property(selector = "reflectionFalloffStart")
    public native @MachineSizedFloat double getReflectionFalloffStart();
    @Property(selector = "setReflectionFalloffStart:")
    public native void setReflectionFalloffStart(@MachineSizedFloat double v);
    @Property(selector = "reflectionFalloffEnd")
    public native @MachineSizedFloat double getReflectionFalloffEnd();
    @Property(selector = "setReflectionFalloffEnd:")
    public native void setReflectionFalloffEnd(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "reflectionResolutionScaleFactor")
    public native @MachineSizedFloat double getReflectionResolutionScaleFactor();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setReflectionResolutionScaleFactor:")
    public native void setReflectionResolutionScaleFactor(@MachineSizedFloat double v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "floor")
    public static native SCNFloor create();
    /*</methods>*/
}
