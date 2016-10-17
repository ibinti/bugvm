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
package com.bugvm.apple.passkit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.addressbook.*;
import com.bugvm.apple.contacts.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("PassKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PKPass/*</name>*/ 
    extends /*<extends>*/PKObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PKPassPtr extends Ptr<PKPass, PKPassPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PKPass.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PKPass() {}
    protected PKPass(SkipInit skipInit) { super(skipInit); }
    public PKPass(NSData data) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(data, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "passType")
    public native PKPassType getPassType();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "paymentPass")
    public native PKPaymentPass getPaymentPass();
    @Property(selector = "serialNumber")
    public native String getSerialNumber();
    @Property(selector = "passTypeIdentifier")
    public native String getPassTypeIdentifier();
    @Property(selector = "webServiceURL")
    public native NSURL getWebServiceURL();
    @Property(selector = "authenticationToken")
    public native String getAuthenticationToken();
    @Property(selector = "icon")
    public native UIImage getIcon();
    @Property(selector = "localizedName")
    public native String getLocalizedName();
    @Property(selector = "localizedDescription")
    public native String getLocalizedDescription();
    @Property(selector = "organizationName")
    public native String getOrganizationName();
    @Property(selector = "relevantDate")
    public native NSDate getRelevantDate();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "userInfo")
    public native NSDictionary<?, ?> getUserInfo();
    @Property(selector = "passURL")
    public native NSURL getPassURL();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "isRemotePass")
    public native boolean isRemotePass();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "deviceName")
    public native String getDeviceName();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithData:error:")
    private native @Pointer long init(NSData data, NSError.NSErrorPtr error);
    @Method(selector = "localizedValueForFieldKey:")
    public native NSObject getLocalizedValue(String key);
    /*</methods>*/
}
