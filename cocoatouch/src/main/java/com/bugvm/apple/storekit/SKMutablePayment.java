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
package com.bugvm.apple.storekit;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("StoreKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKMutablePayment/*</name>*/ 
    extends /*<extends>*/SKPayment/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKMutablePaymentPtr extends Ptr<SKMutablePayment, SKMutablePaymentPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKMutablePayment.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKMutablePayment() {}
    protected SKMutablePayment(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    public SKMutablePayment(SKProduct product) {
        super(create(product));
        retain(getHandle());
    }
    @Method(selector = "paymentWithProduct:")
    protected static native @Pointer long create(SKProduct product);
    /*<properties>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "applicationUsername")
    public native String getApplicationUsername();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setApplicationUsername:")
    public native void setApplicationUsername(String v);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "productIdentifier")
    public native String getProductIdentifier();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "setProductIdentifier:")
    public native void setProductIdentifier(String v);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "quantity")
    public native @MachineSizedSInt long getQuantity();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "setQuantity:")
    public native void setQuantity(@MachineSizedSInt long v);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "requestData")
    public native NSData getRequestData();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "setRequestData:")
    public native void setRequestData(NSData v);
    /**
     * @since Available in iOS 8.3 and later.
     */
    @Property(selector = "simulatesAskToBuyInSandbox")
    public native boolean simulatesAskToBuyInSandbox();
    /**
     * @since Available in iOS 8.3 and later.
     */
    @Property(selector = "setSimulatesAskToBuyInSandbox:")
    public native void setSimulatesAskToBuyInSandbox(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
