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
/*<annotations>*/@Library("Metal") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MTLDepthStencilDescriptor/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MTLDepthStencilDescriptorPtr extends Ptr<MTLDepthStencilDescriptor, MTLDepthStencilDescriptorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MTLDepthStencilDescriptor.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MTLDepthStencilDescriptor() {}
    protected MTLDepthStencilDescriptor(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "depthCompareFunction")
    public native MTLCompareFunction getDepthCompareFunction();
    @Property(selector = "setDepthCompareFunction:")
    public native void setDepthCompareFunction(MTLCompareFunction v);
    @Property(selector = "isDepthWriteEnabled")
    public native boolean isDepthWriteEnabled();
    @Property(selector = "setDepthWriteEnabled:")
    public native void setDepthWriteEnabled(boolean v);
    @Property(selector = "frontFaceStencil")
    public native MTLStencilDescriptor getFrontFaceStencil();
    @Property(selector = "setFrontFaceStencil:")
    public native void setFrontFaceStencil(MTLStencilDescriptor v);
    @Property(selector = "backFaceStencil")
    public native MTLStencilDescriptor getBackFaceStencil();
    @Property(selector = "setBackFaceStencil:")
    public native void setBackFaceStencil(MTLStencilDescriptor v);
    @Property(selector = "label")
    public native String getLabel();
    @Property(selector = "setLabel:")
    public native void setLabel(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
