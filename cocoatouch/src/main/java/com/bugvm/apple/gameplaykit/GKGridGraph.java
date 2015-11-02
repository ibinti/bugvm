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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKGridGraph/*</name>*/ 
    extends /*<extends>*/GKGraph/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKGridGraphPtr extends Ptr<GKGridGraph, GKGridGraphPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKGridGraph.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKGridGraph() {}
    protected GKGridGraph(SkipInit skipInit) { super(skipInit); }
    public GKGridGraph(VectorInt2 position, int width, int height, boolean diagonalsAllowed) { super((SkipInit) null); initObject(init(position, width, height, diagonalsAllowed)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "gridOrigin")
    public native VectorInt2 getGridOrigin();
    @Property(selector = "gridWidth")
    public native @MachineSizedUInt long getGridWidth();
    @Property(selector = "gridHeight")
    public native @MachineSizedUInt long getGridHeight();
    @Property(selector = "diagonalsAllowed")
    public native boolean areDiagonalsAllowed();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initFromGridStartingAt:width:height:diagonalsAllowed:")
    protected native @Pointer long init(VectorInt2 position, int width, int height, boolean diagonalsAllowed);
    @Method(selector = "nodeAtGridPosition:")
    public native GKGridGraphNode getNodeAtGridPosition(VectorInt2 position);
    @Method(selector = "connectNodeToAdjacentNodes:")
    public native void connectNodeToAdjacentNodes(GKGridGraphNode node);
    /*</methods>*/
}
