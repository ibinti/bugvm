
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/** In-app purchase delegate protocol for custom purchase handling. The delegate must handle the product purchase flow then call
 * the GADInAppPurchase object's reportPurchaseStatus: method. */
public interface GADInAppPurchaseDelegate extends NSObjectProtocol {
    /** Called when the user clicks on the buy button of an in-app purchase ad. After the receiver handles the purchase, it must
     * call the {@link GADInAppPurchase#reportPurchaseStatus(GADInAppPurchaseStatus)} method.
     * @param purchase */
    @Method(selector = "didReceiveInAppPurchase:")
    void didReceiveInAppPurchase (GADInAppPurchase purchase);
}
