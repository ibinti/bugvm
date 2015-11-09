
package com.bugvm.bindings.admob;

import com.bugvm.apple.foundation.NSObject;
import com.bugvm.apple.uikit.UIApplicationDelegate;
import com.bugvm.apple.uikit.UIApplicationLaunchOptions;
import com.bugvm.apple.storekit.SKPaymentTransaction;
import com.bugvm.apple.uikit.UIApplication;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.Property;
import com.bugvm.rt.bro.annotation.MachineSizedSInt;

/** The consumable in-app purchase item that has been purchased by the user. The purchase flow is handled by the Google Mobile Ads
 * SDK.
 * 
 * Instances of this class are created and passed to your in-app purchase delegate after the user has successfully paid for a
 * product. Your code must correctly deliver the product to the user and then call the didCompletePurchase method to finish the
 * transaction. */
public class GADDefaultInAppPurchase extends NSObject {
    /** Enables the default consumable product in-app purchase flow handled by the Google Mobile Ads SDK. The
     * GADDefaultInAppPurchaseDelegate object is retained while the default purchase flow is enabled. This method adds a
     * SKPaymentTransactionObserver to the default SKPaymentQueue. Remove any existing transaction observers before calling this
     * method.
     * 
     * Call this method early in your application to handle unfinished transactions from previous application sessions. For
     * example, call this method in your application delegate's
     * {@link UIApplicationDelegate#didFinishLaunching(UIApplication, UIApplicationLaunchOptions)} method.
     * @param delegate */
    @Method(selector = "enableDefaultPurchaseFlowWithDelegate:")
    public static native void enableDefaultPurchaseFlow (GADDefaultInAppPurchaseDelegate delegate);

    /** Disables the default in-app purchase flow handled by the Google Mobile Ads SDK and releases the associated
     * GADDefaultInAppPurchaseDelegate object. */
    @Method
    public static native void disableDefaultPurchaseFlow ();

    /** @return the in-app purchase product ID. */
    @Property
    public native String getProductID ();

    /** @return the product quantity. */
    @Property
    public native @MachineSizedSInt long getQuantity ();

    /** @return the purchased item's completed payment transaction. Your application can use this property's data to save a
     *         permanent record of the completed payment. The default purchase flow will finish the transaction on your behalf. Do
     *         not finish the transaction yourself. */
    @Property
    public native SKPaymentTransaction getPaymentTransaction ();

    /** The in-app purchase delegate object must first deliver the user's item and then call this method. Failure to call this
     * method will result in duplicate purchase notifications. */
    @Method
    public native void finishTransaction ();

}
