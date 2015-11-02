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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKPaymentQueue/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKPaymentQueuePtr extends Ptr<SKPaymentQueue, SKPaymentQueuePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKPaymentQueue.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKPaymentQueue() {}
    protected SKPaymentQueue(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "transactions")
    public native NSArray<SKPaymentTransaction> getTransactions();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "addPayment:")
    public native void addPayment(SKPayment payment);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "restoreCompletedTransactions")
    public native void restoreCompletedTransactions();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "restoreCompletedTransactionsWithApplicationUsername:")
    public native void restoreCompletedTransactions(String username);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "finishTransaction:")
    public native void finishTransaction(SKPaymentTransaction transaction);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "startDownloads:")
    public native void startDownloads(NSArray<SKDownload> downloads);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "pauseDownloads:")
    public native void pauseDownloads(NSArray<SKDownload> downloads);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "resumeDownloads:")
    public native void resumeDownloads(NSArray<SKDownload> downloads);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "cancelDownloads:")
    public native void cancelDownloads(NSArray<SKDownload> downloads);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "addTransactionObserver:")
    public native void addTransactionObserver(SKPaymentTransactionObserver observer);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "removeTransactionObserver:")
    public native void removeTransactionObserver(SKPaymentTransactionObserver observer);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "defaultQueue")
    public static native SKPaymentQueue getDefaultQueue();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "canMakePayments")
    public static native boolean canMakePayments();
    /*</methods>*/
}
