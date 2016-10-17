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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CBMutableCharacteristic/*</name>*/ 
    extends /*<extends>*/CBCharacteristic/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CBMutableCharacteristicPtr extends Ptr<CBMutableCharacteristic, CBMutableCharacteristicPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CBMutableCharacteristic.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CBMutableCharacteristic() {}
    protected CBMutableCharacteristic(SkipInit skipInit) { super(skipInit); }
    public CBMutableCharacteristic(CBUUID UUID, CBCharacteristicProperties properties, NSData value, CBAttributePermissions permissions) { super((SkipInit) null); initObject(init(UUID, properties, value, permissions)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "permissions")
    public native CBAttributePermissions getPermissions();
    @Property(selector = "setPermissions:")
    public native void setPermissions(CBAttributePermissions v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "subscribedCentrals")
    public native NSArray<CBCentral> getSubscribedCentrals();
    @Property(selector = "properties")
    public native CBCharacteristicProperties getProperties();
    @Property(selector = "setProperties:")
    public native void setProperties(CBCharacteristicProperties v);
    @Property(selector = "value")
    public native NSData getValue();
    @Property(selector = "setValue:")
    public native void setValue(NSData v);
    @Property(selector = "descriptors")
    public native NSArray<CBDescriptor> getDescriptors();
    @Property(selector = "setDescriptors:")
    public native void setDescriptors(NSArray<CBDescriptor> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithType:properties:value:permissions:")
    protected native @Pointer long init(CBUUID UUID, CBCharacteristicProperties properties, NSData value, CBAttributePermissions permissions);
    /*</methods>*/
}
