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
package com.bugvm.apple.modelio;

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
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("ModelIO") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLSubmesh/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements MDLNamed/*</implements>*/ {

    /*<ptr>*/public static class MDLSubmeshPtr extends Ptr<MDLSubmesh, MDLSubmeshPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLSubmesh.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLSubmesh() {}
    protected MDLSubmesh(SkipInit skipInit) { super(skipInit); }
    public MDLSubmesh(String name, MDLMeshBuffer indexBuffer, @MachineSizedUInt long indexCount, MDLIndexBitDepth indexType, MDLGeometryType geometryType, MDLMaterial material) { super((SkipInit) null); initObject(init(name, indexBuffer, indexCount, indexType, geometryType, material)); }
    public MDLSubmesh(MDLMeshBuffer indexBuffer, @MachineSizedUInt long indexCount, MDLIndexBitDepth indexType, MDLGeometryType geometryType, MDLMaterial material) { super((SkipInit) null); initObject(init(indexBuffer, indexCount, indexType, geometryType, material)); }
    public MDLSubmesh(String name, MDLMeshBuffer indexBuffer, @MachineSizedUInt long indexCount, MDLIndexBitDepth indexType, MDLGeometryType geometryType, MDLMaterial material, MDLSubmeshTopology topology) { super((SkipInit) null); initObject(init(name, indexBuffer, indexCount, indexType, geometryType, material, topology)); }
    public MDLSubmesh(MDLSubmesh submesh, MDLIndexBitDepth indexType, MDLGeometryType geometryType) { super((SkipInit) null); initObject(init(submesh, indexType, geometryType)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "indexBuffer")
    public native MDLMeshBuffer getIndexBuffer();
    @Property(selector = "indexCount")
    public native @MachineSizedUInt long getIndexCount();
    @Property(selector = "indexType")
    public native MDLIndexBitDepth getIndexType();
    @Property(selector = "geometryType")
    public native MDLGeometryType getGeometryType();
    @Property(selector = "material")
    public native MDLMaterial getMaterial();
    @Property(selector = "setMaterial:")
    public native void setMaterial(MDLMaterial v);
    @Property(selector = "topology")
    public native MDLSubmeshTopology getTopology();
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "setName:")
    public native void setName(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithName:indexBuffer:indexCount:indexType:geometryType:material:")
    protected native @Pointer long init(String name, MDLMeshBuffer indexBuffer, @MachineSizedUInt long indexCount, MDLIndexBitDepth indexType, MDLGeometryType geometryType, MDLMaterial material);
    @Method(selector = "initWithIndexBuffer:indexCount:indexType:geometryType:material:")
    protected native @Pointer long init(MDLMeshBuffer indexBuffer, @MachineSizedUInt long indexCount, MDLIndexBitDepth indexType, MDLGeometryType geometryType, MDLMaterial material);
    @Method(selector = "initWithName:indexBuffer:indexCount:indexType:geometryType:material:topology:")
    protected native @Pointer long init(String name, MDLMeshBuffer indexBuffer, @MachineSizedUInt long indexCount, MDLIndexBitDepth indexType, MDLGeometryType geometryType, MDLMaterial material, MDLSubmeshTopology topology);
    @Method(selector = "initWithMDLSubmesh:indexType:geometryType:")
    protected native @Pointer long init(MDLSubmesh submesh, MDLIndexBitDepth indexType, MDLGeometryType geometryType);
    /*</methods>*/
}
