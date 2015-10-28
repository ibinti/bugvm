
package com.bugvm.bindings.admob.mediation;

import com.bugvm.apple.foundation.NSObject;
import com.bugvm.apple.foundation.NSError;

public class GADCustomEventInterstitialDelegateAdapter implements GADCustomEventInterstitialDelegate {
    @Override
    public void didReceiveAd (GADCustomEventInterstitial customEvent, NSObject ad) {
    }

    @Override
    public void didFailAd (GADCustomEventInterstitial customEvent, NSError error) {
    }

    @Override
    public void willPresent (GADCustomEventInterstitial customEvent) {
    }

    @Override
    public void willDismiss (GADCustomEventInterstitial customEvent) {
    }

    @Override
    public void didDismiss (GADCustomEventInterstitial customEvent) {
    }

    @Override
    public void willLeaveApplication (GADCustomEventInterstitial customEvent) {
    }
}
