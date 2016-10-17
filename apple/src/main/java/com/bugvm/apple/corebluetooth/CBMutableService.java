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
package com.bugvm.apple.corebluetooth;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreBluetooth") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CBMutableService/*</name>*/ 
    extends /*<extends>*/CBService/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CBMutableServicePtr extends Ptr<CBMutableService, CBMutableServicePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CBMutableService.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CBMutableService() {}
    protected CBMutableService(SkipInit skipInit) { super(skipInit); }
    public CBMutableService(CBUUID UUID, boolean isPrimary) { super((SkipInit) null); initObject(init(UUID, isPrimary)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "includedServices")
    public native NSArray<CBService> getIncludedServices();
    @Property(selector = "setIncludedServices:")
    public native void setIncludedServices(NSArray<CBService> v);
    @Property(selector = "characteristics")
    public native NSArray<CBCharacteristic> getCharacteristics();
    @Property(selector = "setCharacteristics:")
    public native void setCharacteristics(NSArray<CBCharacteristic> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithType:primary:")
    protected native @Pointer long init(CBUUID UUID, boolean isPrimary);
    /*</methods>*/
}
