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
package com.bugvm.apple.metalkit;

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
import com.bugvm.apple.metal.*;
import com.bugvm.apple.modelio.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreanimation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MetalKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MTKMeshBuffer/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MTKMeshBufferPtr extends Ptr<MTKMeshBuffer, MTKMeshBufferPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MTKMeshBuffer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MTKMeshBuffer() {}
    protected MTKMeshBuffer(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "length")
    public native @MachineSizedUInt long getLength();
    @Property(selector = "allocator")
    public native MTKMeshBufferAllocator getAllocator();
    @Property(selector = "zone")
    public native MDLMeshBufferZone getZone();
    @Property(selector = "buffer")
    public native MTLBuffer getBuffer();
    @Property(selector = "offset")
    public native @MachineSizedUInt long getOffset();
    @Property(selector = "type")
    public native MDLMeshBufferType getType();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
