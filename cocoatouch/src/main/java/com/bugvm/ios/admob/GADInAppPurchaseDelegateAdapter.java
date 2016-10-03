
package com.bugvm.ios.admob;

import com.bugvm.objc.annotation.NotImplemented;

public class GADInAppPurchaseDelegateAdapter implements GADInAppPurchaseDelegate {
    @Override
    @NotImplemented("didReceiveInAppPurchase:")
    public void didReceiveInAppPurchase (com.bugvm.ios.admob.GADInAppPurchase purchase) {
        throw new UnsupportedOperationException();
    }
}
