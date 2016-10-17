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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("PassKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PKPaymentAuthorizationViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PKPaymentAuthorizationViewControllerPtr extends Ptr<PKPaymentAuthorizationViewController, PKPaymentAuthorizationViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PKPaymentAuthorizationViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PKPaymentAuthorizationViewController() {}
    protected PKPaymentAuthorizationViewController(SkipInit skipInit) { super(skipInit); }
    public PKPaymentAuthorizationViewController(PKPaymentRequest request) { super((SkipInit) null); initObject(init(request)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native PKPaymentAuthorizationViewControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(PKPaymentAuthorizationViewControllerDelegate v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithPaymentRequest:")
    protected native @Pointer long init(PKPaymentRequest request);
    @Method(selector = "canMakePayments")
    public static native boolean canMakePayments();
    @Method(selector = "canMakePaymentsUsingNetworks:")
    public static native boolean canMakePaymentsUsingNetworks(@com.bugvm.rt.bro.annotation.Marshaler(PKPaymentNetwork.AsListMarshaler.class) List<PKPaymentNetwork> supportedNetworks);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "canMakePaymentsUsingNetworks:capabilities:")
    public static native boolean canMakePaymentsUsingNetworks(@com.bugvm.rt.bro.annotation.Marshaler(PKPaymentNetwork.AsListMarshaler.class) List<PKPaymentNetwork> supportedNetworks, PKMerchantCapability capabilties);
    /*</methods>*/
}
