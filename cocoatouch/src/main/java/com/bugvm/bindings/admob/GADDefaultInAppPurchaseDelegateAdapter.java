
package com.bugvm.bindings.admob;

import com.bugvm.objc.annotation.NotImplemented;

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
