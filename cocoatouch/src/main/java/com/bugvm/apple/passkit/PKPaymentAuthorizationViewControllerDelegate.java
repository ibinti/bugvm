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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/PKPaymentAuthorizationViewControllerDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "paymentAuthorizationViewController:didAuthorizePayment:completion:")
    void didAuthorizePayment(PKPaymentAuthorizationViewController controller, PKPayment payment, @Block VoidBlock1<PKPaymentAuthorizationStatus> completion);
    @Method(selector = "paymentAuthorizationViewControllerDidFinish:")
    void didFinish(PKPaymentAuthorizationViewController controller);
    /**
     * @since Available in iOS 8.3 and later.
     */
    @Method(selector = "paymentAuthorizationViewControllerWillAuthorizePayment:")
    void willAuthorizePayment(PKPaymentAuthorizationViewController controller);
    @Method(selector = "paymentAuthorizationViewController:didSelectShippingMethod:completion:")
    void didSelectShippingMethod(PKPaymentAuthorizationViewController controller, PKShippingMethod shippingMethod, @Block VoidBlock2<PKPaymentAuthorizationStatus, NSArray<PKPaymentSummaryItem>> completion);
    /**
     * @since Available in iOS 8.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "paymentAuthorizationViewController:didSelectShippingAddress:completion:")
    void didSelectShippingAddress(PKPaymentAuthorizationViewController controller, ABRecord address, @Block VoidBlock3<PKPaymentAuthorizationStatus, NSArray<PKShippingMethod>, NSArray<PKPaymentSummaryItem>> completion);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "paymentAuthorizationViewController:didSelectShippingContact:completion:")
    void didSelectShippingContact(PKPaymentAuthorizationViewController controller, PKContact contact, @Block VoidBlock3<PKPaymentAuthorizationStatus, NSArray<PKShippingMethod>, NSArray<PKPaymentSummaryItem>> completion);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "paymentAuthorizationViewController:didSelectPaymentMethod:completion:")
    void didSelectPaymentMethod(PKPaymentAuthorizationViewController controller, PKPaymentMethod paymentMethod, @Block VoidBlock1<NSArray<PKPaymentSummaryItem>> completion);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
