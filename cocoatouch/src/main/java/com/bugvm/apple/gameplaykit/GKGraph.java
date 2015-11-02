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
package com.bugvm.apple.gameplaykit;

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
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("GameplayKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKGraph/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKGraphPtr extends Ptr<GKGraph, GKGraphPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKGraph.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKGraph() {}
    protected GKGraph(SkipInit skipInit) { super(skipInit); }
    public GKGraph(NSArray<GKGraph> nodes) { super((SkipInit) null); initObject(init(nodes)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "nodes")
    public native NSArray<GKGraph> getNodes();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithNodes:")
    protected native @Pointer long init(NSArray<GKGraph> nodes);
    @Method(selector = "connectNodeToLowestCostNode:bidirectional:")
    public native void connectNodeToLowestCostNode(GKGraphNode node, boolean bidirectional);
    @Method(selector = "removeNodes:")
    public native void removeNodes(NSArray<GKGraph> nodes);
    @Method(selector = "addNodes:")
    public native void addNodes(NSArray<GKGraph> nodes);
    @Method(selector = "findPathFromNode:toNode:")
    public native NSArray<GKGraphNode> findPathBetweenNodes(GKGraphNode startNode, GKGraphNode endNode);
    /*</methods>*/
}
