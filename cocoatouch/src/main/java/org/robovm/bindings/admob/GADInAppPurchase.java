
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

/** The in-app purchase item to be purchased with the purchase flow handled by you, the application developer.
 * 
 * Instances of this class are created and passed to your GADInAppPurchaseDelegate object when users click a buy button. It is
 * important to report the result of the purchase back to the SDK in order to track metrics about the transaction. */
@NativeClass
public class GADInAppPurchase extends NSObject {

    /** @return the in-app purchase product ID. */
    @Property
    public native String getProductID ();

    /** @return the product quantity. */
    @Property
    public native @MachineSizedSInt long getQuantity ();

    /** The GADInAppPurchaseDelegate object must call this method after handling the in-app purchase for both successful and
     * unsuccessful purchase attempts. This method reports ad conversion and purchase status information to Google. */
    @Method(selector = "reportPurchaseStatus:")
    public native void reportPurchaseStatus (GADInAppPurchaseStatus purchaseStatus);
}
