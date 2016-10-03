
package com.bugvm.ios.admob.mediation;

import com.bugvm.apple.uikit.UIViewController;

public class GADCustomEventInterstitialAdapter implements GADCustomEventInterstitial {
    @Override
    public void requestInterstitial (String serverParameter, String serverLabel, com.bugvm.ios.admob.mediation.GADCustomEventRequest request) {
    }

    @Override
    public void present (UIViewController rootViewController) {
    }

    @Override
    public void setDelegate (com.bugvm.ios.admob.mediation.GADCustomEventInterstitialDelegate delegate) {
    }

    @Override
    public com.bugvm.ios.admob.mediation.GADCustomEventInterstitialDelegate getDelegate () {
        return null;
    }
}
