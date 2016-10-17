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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFAllocatorContext/*</name>*/ 
    extends /*<extends>*/Struct<CFAllocatorContext>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFAllocatorContextPtr extends Ptr<CFAllocatorContext, CFAllocatorContextPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CFAllocatorContext() {}
    public CFAllocatorContext(@MachineSizedSInt long version, VoidPtr info, FunctionPtr retain, FunctionPtr release, FunctionPtr copyDescription, FunctionPtr allocate, FunctionPtr reallocate, FunctionPtr deallocate, FunctionPtr preferredSize) {
        this.setVersion(version);
        this.setInfo(info);
        this.setRetain(retain);
        this.setRelease(release);
        this.setCopyDescription(copyDescription);
        this.setAllocate(allocate);
        this.setReallocate(reallocate);
        this.setDeallocate(deallocate);
        this.setPreferredSize(preferredSize);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedSInt long getVersion();
    @StructMember(0) public native CFAllocatorContext setVersion(@MachineSizedSInt long version);
    @StructMember(1) public native VoidPtr getInfo();
    @StructMember(1) public native CFAllocatorContext setInfo(VoidPtr info);
    @StructMember(2) public native FunctionPtr getRetain();
    @StructMember(2) public native CFAllocatorContext setRetain(FunctionPtr retain);
    @StructMember(3) public native FunctionPtr getRelease();
    @StructMember(3) public native CFAllocatorContext setRelease(FunctionPtr release);
    @StructMember(4) public native FunctionPtr getCopyDescription();
    @StructMember(4) public native CFAllocatorContext setCopyDescription(FunctionPtr copyDescription);
    @StructMember(5) public native FunctionPtr getAllocate();
    @StructMember(5) public native CFAllocatorContext setAllocate(FunctionPtr allocate);
    @StructMember(6) public native FunctionPtr getReallocate();
    @StructMember(6) public native CFAllocatorContext setReallocate(FunctionPtr reallocate);
    @StructMember(7) public native FunctionPtr getDeallocate();
    @StructMember(7) public native CFAllocatorContext setDeallocate(FunctionPtr deallocate);
    @StructMember(8) public native FunctionPtr getPreferredSize();
    @StructMember(8) public native CFAllocatorContext setPreferredSize(FunctionPtr preferredSize);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
