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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("SpriteKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKConstraint/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class SKConstraintPtr extends Ptr<SKConstraint, SKConstraintPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKConstraint.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKConstraint() {}
    protected SKConstraint(SkipInit skipInit) { super(skipInit); }
    public SKConstraint(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "enabled")
    public native boolean isEnabled();
    @Property(selector = "setEnabled:")
    public native void setEnabled(boolean v);
    @Property(selector = "referenceNode")
    public native SKNode getReferenceNode();
    @Property(selector = "setReferenceNode:")
    public native void setReferenceNode(SKNode v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "positionX:")
    public static native SKConstraint positionX(SKRange range);
    @Method(selector = "positionY:")
    public static native SKConstraint positionY(SKRange range);
    @Method(selector = "positionX:Y:")
    public static native SKConstraint positionXY(SKRange xRange, SKRange yRange);
    @Method(selector = "distance:toNode:")
    public static native SKConstraint distanceToNode(SKRange range, SKNode node);
    @Method(selector = "distance:toPoint:")
    public static native SKConstraint distanceToPoint(SKRange range, @ByVal CGPoint point);
    @Method(selector = "distance:toPoint:inNode:")
    public static native SKConstraint distanceToPointInNode(SKRange range, @ByVal CGPoint point, SKNode node);
    @Method(selector = "zRotation:")
    public static native SKConstraint zRotation(SKRange zRange);
    @Method(selector = "orientToNode:offset:")
    public static native SKConstraint orientToNode(SKNode node, SKRange radians);
    @Method(selector = "orientToPoint:offset:")
    public static native SKConstraint orientToPoint(@ByVal CGPoint point, SKRange radians);
    @Method(selector = "orientToPoint:inNode:offset:")
    public static native SKConstraint orientToPointInNode(@ByVal CGPoint point, SKNode node, SKRange radians);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
