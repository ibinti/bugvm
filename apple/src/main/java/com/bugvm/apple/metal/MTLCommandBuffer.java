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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Metal") @NativeProtocolProxy/*</annotations>*/
/*<visibility>*/public final/*</visibility>*/ class /*<name>*/MTLCommandBuffer/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/public static class MTLCommandBufferPtr extends Ptr<MTLCommandBuffer, MTLCommandBufferPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MTLCommandBuffer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "device")
    public native MTLDevice getDevice();
    @Property(selector = "commandQueue")
    public native MTLCommandQueue getCommandQueue();
    @Property(selector = "retainedReferences")
    public native boolean maintainsRetainedReferences();
    @Property(selector = "label")
    public native String getLabel();
    @Property(selector = "setLabel:")
    public native void setLabel(String v);
    @Property(selector = "status")
    public native MTLCommandBufferStatus getStatus();
    @Property(selector = "error")
    public native NSError getError();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "enqueue")
    public native void enqueue();
    @Method(selector = "commit")
    public native void commit();
    @Method(selector = "addScheduledHandler:")
    public native void addScheduledHandler(@Block VoidBlock1<MTLCommandBuffer> block);
    @Method(selector = "presentDrawable:")
    public native void presentDrawable(MTLDrawable drawable);
    @Method(selector = "presentDrawable:atTime:")
    public native void presentDrawableAtTime(MTLDrawable drawable, double presentationTime);
    @Method(selector = "waitUntilScheduled")
    public native void waitUntilScheduled();
    @Method(selector = "addCompletedHandler:")
    public native void addCompletedHandler(@Block VoidBlock1<MTLCommandBuffer> block);
    @Method(selector = "waitUntilCompleted")
    public native void waitUntilCompleted();
    @Method(selector = "blitCommandEncoder")
    public native MTLBlitCommandEncoder newBlitCommandEncoder();
    @Method(selector = "renderCommandEncoderWithDescriptor:")
    public native MTLRenderCommandEncoder newRenderCommandEncoder(MTLRenderPassDescriptor renderPassDescriptor);
    @Method(selector = "computeCommandEncoder")
    public native MTLComputeCommandEncoder newComputeCommandEncoder();
    @Method(selector = "parallelRenderCommandEncoderWithDescriptor:")
    public native MTLParallelRenderCommandEncoder newParallelRenderCommandEncoder(MTLRenderPassDescriptor renderPassDescriptor);
    /*</methods>*/
}
