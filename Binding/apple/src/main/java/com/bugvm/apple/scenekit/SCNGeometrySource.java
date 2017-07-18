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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNGeometrySource/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNGeometrySourcePtr extends Ptr<SCNGeometrySource, SCNGeometrySourcePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNGeometrySource.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNGeometrySource() {}
    protected SCNGeometrySource(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "data")
    public native NSData getData();
    @Property(selector = "semantic")
    public native SCNGeometrySourceSemantic getSemantic();
    @Property(selector = "vectorCount")
    public native @MachineSizedSInt long getVectorCount();
    @Property(selector = "floatComponents")
    public native boolean usesFloatComponents();
    @Property(selector = "componentsPerVector")
    public native @MachineSizedSInt long getComponentsPerVector();
    @Property(selector = "bytesPerComponent")
    public native @MachineSizedSInt long getBytesPerComponent();
    @Property(selector = "dataOffset")
    public native @MachineSizedSInt long getDataOffset();
    @Property(selector = "dataStride")
    public native @MachineSizedSInt long getDataStride();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "geometrySourceWithData:semantic:vectorCount:floatComponents:componentsPerVector:bytesPerComponent:dataOffset:dataStride:")
    public static native SCNGeometrySource createWithData(NSData data, SCNGeometrySourceSemantic semantic, @MachineSizedSInt long vectorCount, boolean floatComponents, @MachineSizedSInt long componentsPerVector, @MachineSizedSInt long bytesPerComponent, @MachineSizedSInt long offset, @MachineSizedSInt long stride);
    @Method(selector = "geometrySourceWithVertices:count:")
    public static native SCNGeometrySource createWithVertices(SCNVector3 vertices, @MachineSizedSInt long count);
    @Method(selector = "geometrySourceWithNormals:count:")
    public static native SCNGeometrySource createWithNormals(SCNVector3 normals, @MachineSizedSInt long count);
    @Method(selector = "geometrySourceWithTextureCoordinates:count:")
    public static native SCNGeometrySource createWithTextureCoordinates(CGPoint texcoord, @MachineSizedSInt long count);
    /*</methods>*/
}
