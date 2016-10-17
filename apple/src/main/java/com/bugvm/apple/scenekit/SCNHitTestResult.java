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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNHitTestResult/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNHitTestResultPtr extends Ptr<SCNHitTestResult, SCNHitTestResultPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNHitTestResult.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNHitTestResult() {}
    protected SCNHitTestResult(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "node")
    public native SCNNode getNode();
    @Property(selector = "geometryIndex")
    public native @MachineSizedSInt long getGeometryIndex();
    @Property(selector = "faceIndex")
    public native @MachineSizedSInt long getFaceIndex();
    @Property(selector = "localCoordinates")
    public native @ByVal SCNVector3 getLocalCoordinates();
    @Property(selector = "worldCoordinates")
    public native @ByVal SCNVector3 getWorldCoordinates();
    @Property(selector = "localNormal")
    public native @ByVal SCNVector3 getLocalNormal();
    @Property(selector = "worldNormal")
    public native @ByVal SCNVector3 getWorldNormal();
    @Property(selector = "modelTransform")
    public native @ByVal SCNMatrix4 getModelTransform();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "textureCoordinatesWithMappingChannel:")
    public native @ByVal CGPoint getTextureCoordinatesWithMappingChannel(@MachineSizedSInt long channel);
    /*</methods>*/
}
