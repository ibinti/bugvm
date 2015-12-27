
package com.bugvm.bindings.admob.mediation;

import com.bugvm.apple.uikit.UIViewController;

public class GADCustomEventInterstitialAdapter implements GADCustomEventInterstitial {
    @Override
    public void requestInterstitial (String serverParameter, String serverLabel, GADCustomEventRequest request) {
    }

    @Override
    public void present (UIViewController rootViewController) {
    }

    @Override
    public void setDelegate (GADCustomEventInterstitialDelegate delegate) {
    }

    @Override
    public GADCustomEventInterstitialDelegate getDelegate () {
        return null;
    }
}
