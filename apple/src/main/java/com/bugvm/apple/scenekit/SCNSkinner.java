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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNSkinner/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNSkinnerPtr extends Ptr<SCNSkinner, SCNSkinnerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNSkinner.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNSkinner() {}
    protected SCNSkinner(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "skeleton")
    public native SCNNode getSkeleton();
    @Property(selector = "setSkeleton:")
    public native void setSkeleton(SCNNode v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "baseGeometry")
    public native SCNGeometry getBaseGeometry();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setBaseGeometry:")
    public native void setBaseGeometry(SCNGeometry v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "baseGeometryBindTransform")
    public native @ByVal SCNMatrix4 getBaseGeometryBindTransform();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setBaseGeometryBindTransform:")
    public native void setBaseGeometryBindTransform(@ByVal SCNMatrix4 v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "boneInverseBindTransforms")
    public native @com.bugvm.rt.bro.annotation.Marshaler(SCNMatrix4.AsListMarshaler.class) List<SCNMatrix4> getBoneInverseBindTransforms();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "bones")
    public native NSArray<SCNNode> getBones();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "boneWeights")
    public native SCNGeometrySource getBoneWeights();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "boneIndices")
    public native SCNGeometrySource getBoneIndices();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "skinnerWithBaseGeometry:bones:boneInverseBindTransforms:boneWeights:boneIndices:")
    public static native SCNSkinner create(SCNGeometry baseGeometry, NSArray<SCNNode> bones, @com.bugvm.rt.bro.annotation.Marshaler(SCNMatrix4.AsListMarshaler.class) List<SCNMatrix4> boneInverseBindTransforms, SCNGeometrySource boneWeights, SCNGeometrySource boneIndices);
    /*</methods>*/
}
