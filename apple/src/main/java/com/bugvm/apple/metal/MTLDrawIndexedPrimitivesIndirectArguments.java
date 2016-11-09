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
package com.bugvm.apple.metal;

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
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MTLDrawIndexedPrimitivesIndirectArguments/*</name>*/ 
    extends /*<extends>*/Struct<MTLDrawIndexedPrimitivesIndirectArguments>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MTLDrawIndexedPrimitivesIndirectArgumentsPtr extends Ptr<MTLDrawIndexedPrimitivesIndirectArguments, MTLDrawIndexedPrimitivesIndirectArgumentsPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MTLDrawIndexedPrimitivesIndirectArguments() {}
    public MTLDrawIndexedPrimitivesIndirectArguments(int indexCount, int instanceCount, int indexStart, int baseVertex, int baseInstance) {
        this.setIndexCount(indexCount);
        this.setInstanceCount(instanceCount);
        this.setIndexStart(indexStart);
        this.setBaseVertex(baseVertex);
        this.setBaseInstance(baseInstance);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native int getIndexCount();
    @StructMember(0) public native MTLDrawIndexedPrimitivesIndirectArguments setIndexCount(int indexCount);
    @StructMember(1) public native int getInstanceCount();
    @StructMember(1) public native MTLDrawIndexedPrimitivesIndirectArguments setInstanceCount(int instanceCount);
    @StructMember(2) public native int getIndexStart();
    @StructMember(2) public native MTLDrawIndexedPrimitivesIndirectArguments setIndexStart(int indexStart);
    @StructMember(3) public native int getBaseVertex();
    @StructMember(3) public native MTLDrawIndexedPrimitivesIndirectArguments setBaseVertex(int baseVertex);
    @StructMember(4) public native int getBaseInstance();
    @StructMember(4) public native MTLDrawIndexedPrimitivesIndirectArguments setBaseInstance(int baseInstance);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
