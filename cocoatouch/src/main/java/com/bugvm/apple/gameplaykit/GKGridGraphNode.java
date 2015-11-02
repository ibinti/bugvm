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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKGridGraphNode/*</name>*/ 
    extends /*<extends>*/GKGraphNode/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKGridGraphNodePtr extends Ptr<GKGridGraphNode, GKGridGraphNodePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKGridGraphNode.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKGridGraphNode() {}
    protected GKGridGraphNode(SkipInit skipInit) { super(skipInit); }
    public GKGridGraphNode(VectorInt2 gridPosition) { super((SkipInit) null); initObject(init(gridPosition)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "gridPosition")
    public native VectorInt2 getGridPosition();
    @Property(selector = "setGridPosition:")
    public native void setGridPosition(VectorInt2 v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithGridPosition:")
    protected native @Pointer long init(VectorInt2 gridPosition);
    /*</methods>*/
}
