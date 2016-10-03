
package com.bugvm.ios.admob;

import com.bugvm.apple.foundation.NSObjectProtocol;
import com.bugvm.objc.annotation.Method;

/** In-app purchase delegate protocol for custom purchase handling. The delegate must handle the product purchase flow then call
 * the GADInAppPurchase object's reportPurchaseStatus: method. */
public interface GADInAppPurchaseDelegate extends NSObjectProtocol {
    /** Called when the user clicks on the buy button of an in-app purchase ad. After the receiver handles the purchase, it must
     * call the {@link com.bugvm.ios.admob.GADInAppPurchase#reportPurchaseStatus(GADInAppPurchaseStatus)} method.
     * @param purchase */
    @Method(selector = "didReceiveInAppPurchase:")
    void didReceiveInAppPurchase (com.bugvm.ios.admob.GADInAppPurchase purchase);
}
