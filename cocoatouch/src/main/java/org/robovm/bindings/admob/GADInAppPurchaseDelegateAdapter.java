
package org.robovm.bindings.admob;

import org.robovm.objc.annotation.NotImplemented;

public class GADInAppPurchaseDelegateAdapter implements GADInAppPurchaseDelegate {
    @Override
    @NotImplemented("didReceiveInAppPurchase:")
    public void didReceiveInAppPurchase (GADInAppPurchase purchase) {
        throw new UnsupportedOperationException();
    }
}
