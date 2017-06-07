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
/*<visibility>*//*</visibility>*/ class /*<name>*/CFMessagePortContext/*</name>*/ 
    extends /*<extends>*/Struct<CFMessagePortContext>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFMessagePortContextPtr extends Ptr<CFMessagePortContext, CFMessagePortContextPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CFMessagePortContext() {}
    public CFMessagePortContext(@MachineSizedSInt long version, @Pointer long info, FunctionPtr retain, FunctionPtr release, FunctionPtr copyDescription) {
        this.setVersion(version);
        this.setInfo(info);
        this.setRetain(retain);
        this.setRelease(release);
        this.setCopyDescription(copyDescription);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedSInt long getVersion();
    @StructMember(0) public native CFMessagePortContext setVersion(@MachineSizedSInt long version);
    @StructMember(1) public native @Pointer long getInfo();
    @StructMember(1) public native CFMessagePortContext setInfo(@Pointer long info);
    @StructMember(2) public native FunctionPtr getRetain();
    @StructMember(2) public native CFMessagePortContext setRetain(FunctionPtr retain);
    @StructMember(3) public native FunctionPtr getRelease();
    @StructMember(3) public native CFMessagePortContext setRelease(FunctionPtr release);
    @StructMember(4) public native FunctionPtr getCopyDescription();
    @StructMember(4) public native CFMessagePortContext setCopyDescription(FunctionPtr copyDescription);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
