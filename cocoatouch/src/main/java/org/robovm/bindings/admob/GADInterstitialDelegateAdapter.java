
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObject;

public class GADInterstitialDelegateAdapter extends NSObject implements GADInterstitialDelegate {
	@Override
	public void didReceiveAd (GADInterstitial ad) {
	}

	@Override
	public void didFailToReceiveAd (GADInterstitial ad, GADRequestError error) {
	}

	@Override
	public void willPresentScreen (GADInterstitial ad) {
	}

	@Override
	public void willDismissScreen (GADInterstitial ad) {
	}

	@Override
	public void didDismissScreen (GADInterstitial ad) {
	}

	@Override
	public void willLeaveApplication (GADInterstitial ad) {
	}
}
