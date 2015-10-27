
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

/** In-app purchase delegate protocol for default purchase handling. The delegate must deliver the purchased item then call the
 * GADDefaultInAppPurchase object's finishTransaction method. */
public interface GADDefaultInAppPurchaseDelegate extends NSObjectProtocol {
    /** Called when the user successfully paid for a purchase. You must first deliver the purchased item to the user, then call
     * defaultInAppPurchase's finishTransaction method.
     * @param defaultInAppPurchase */
    @Method(selector = "userDidPayForPurchase:")
    void userDidPay (GADDefaultInAppPurchase defaultInAppPurchase);

    /** Called when the user clicks on the buy button of an in-app purchase ad.
     * @param productID
     * @param quantity
     * @return {@code true} if the default purchase flow should be started to purchase the item, otherwise return {@code false}.
     *         If not implemented, defaults to {@code true}. */
    @Method(selector = "shouldStartPurchaseForProductID:quantity:")
    boolean shouldStartPurchase (String productID, @MachineSizedSInt long quantity);
}
