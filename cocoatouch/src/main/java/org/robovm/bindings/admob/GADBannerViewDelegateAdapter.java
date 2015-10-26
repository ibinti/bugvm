
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObject;

public class GADBannerViewDelegateAdapter extends NSObject implements GADBannerViewDelegate {
	@Override
	public void didReceiveAd (GADBannerView view) {
	}

	@Override
	public void didFailToReceiveAd (GADBannerView view, GADRequestError error) {
	}

	@Override
	public void willPresentScreen (GADBannerView view) {
	}

	@Override
	public void willDismissScreen (GADBannerView view) {
	}

	@Override
	public void didDismissScreen (GADBannerView view) {
	}

	@Override
	public void willLeaveApplication (GADBannerView view) {
	}
}
