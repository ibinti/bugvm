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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLSubmeshTopology/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MDLSubmeshTopologyPtr extends Ptr<MDLSubmeshTopology, MDLSubmeshTopologyPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLSubmeshTopology.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLSubmeshTopology() {}
    protected MDLSubmeshTopology(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "faceTopology")
    public native MDLMeshBuffer getFaceTopology();
    @Property(selector = "setFaceTopology:")
    public native void setFaceTopology(MDLMeshBuffer v);
    @Property(selector = "faceCount")
    public native @MachineSizedUInt long getFaceCount();
    @Property(selector = "setFaceCount:")
    public native void setFaceCount(@MachineSizedUInt long v);
    @Property(selector = "vertexCreaseIndices")
    public native MDLMeshBuffer getVertexCreaseIndices();
    @Property(selector = "setVertexCreaseIndices:")
    public native void setVertexCreaseIndices(MDLMeshBuffer v);
    @Property(selector = "vertexCreases")
    public native MDLMeshBuffer getVertexCreases();
    @Property(selector = "setVertexCreases:")
    public native void setVertexCreases(MDLMeshBuffer v);
    @Property(selector = "vertexCreaseCount")
    public native @MachineSizedUInt long getVertexCreaseCount();
    @Property(selector = "setVertexCreaseCount:")
    public native void setVertexCreaseCount(@MachineSizedUInt long v);
    @Property(selector = "edgeCreaseIndices")
    public native MDLMeshBuffer getEdgeCreaseIndices();
    @Property(selector = "setEdgeCreaseIndices:")
    public native void setEdgeCreaseIndices(MDLMeshBuffer v);
    @Property(selector = "edgeCreases")
    public native MDLMeshBuffer getEdgeCreases();
    @Property(selector = "setEdgeCreases:")
    public native void setEdgeCreases(MDLMeshBuffer v);
    @Property(selector = "edgeCreaseCount")
    public native @MachineSizedUInt long getEdgeCreaseCount();
    @Property(selector = "setEdgeCreaseCount:")
    public native void setEdgeCreaseCount(@MachineSizedUInt long v);
    @Property(selector = "holes")
    public native MDLMeshBuffer getHoles();
    @Property(selector = "setHoles:")
    public native void setHoles(MDLMeshBuffer v);
    @Property(selector = "holeCount")
    public native @MachineSizedUInt long getHoleCount();
    @Property(selector = "setHoleCount:")
    public native void setHoleCount(@MachineSizedUInt long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
