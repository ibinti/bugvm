
package org.robovm.bindings.admob;

import org.robovm.objc.annotation.NotImplemented;

public class GADDefaultInAppPurchaseDelegateAdapter implements GADDefaultInAppPurchaseDelegate {
    @Override
    @NotImplemented("userDidPayForPurchase:")
    public void userDidPay (GADDefaultInAppPurchase defaultInAppPurchase) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean shouldStartPurchase (String productID, long quantity) {
        return true;
    }
}
