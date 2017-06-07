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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLMeshBufferMap/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MDLMeshBufferMapPtr extends Ptr<MDLMeshBufferMap, MDLMeshBufferMapPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLMeshBufferMap.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLMeshBufferMap() {}
    protected MDLMeshBufferMap(SkipInit skipInit) { super(skipInit); }
    public MDLMeshBufferMap(@Pointer long bytes, @Block Runnable deallocator) { super((SkipInit) null); initObject(init(bytes, deallocator)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "bytes")
    public native @Pointer long getBytes();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithBytes:deallocator:")
    protected native @Pointer long init(@Pointer long bytes, @Block Runnable deallocator);
    /*</methods>*/
}
