
package com.bugvm.bindings.admob;

import com.bugvm.objc.annotation.NotImplemented;

public class GADInAppPurchaseDelegateAdapter implements GADInAppPurchaseDelegate {
    @Override
    @NotImplemented("didReceiveInAppPurchase:")
    public void didReceiveInAppPurchase (GADInAppPurchase purchase) {
        throw new UnsupportedOperationException();
    }
}
