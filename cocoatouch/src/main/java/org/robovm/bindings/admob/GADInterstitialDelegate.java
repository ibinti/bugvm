
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/** Delegate for receiving state change messages from a GADInterstitial such as interstitial ad requests succeeding/failing. */
interface GADInterstitialDelegate extends NSObjectProtocol {
	/** Sent when an interstitial ad request succeeded. Show it at the next transition point in your application such as when
	 * transitioning between view controllers. */
	@Method(selector = "interstitialDidReceiveAd:")
	void didReceiveAd (GADInterstitial ad);

	/** Sent when an interstitial ad request completed without an interstitial to show. This is common since interstitials are shown
	 * sparingly to users. */
	@Method(selector = "interstitial:didFailToReceiveAdWithError:")
	void didFailToReceiveAd (GADInterstitial ad, GADRequestError error);

	/** Sent just before presenting an interstitial. After this method finishes the interstitial will animate onto the screen. Use
	 * this opportunity to stop animations and save the state of your application in case the user leaves while the interstitial is
	 * on screen (e.g. to visit the App Store from a link on the interstitial). */
	@Method(selector = "interstitialWillPresentScreen:")
	void willPresentScreen (GADInterstitial ad);

	/** Sent before the interstitial is to be animated off the screen. */
	@Method(selector = "interstitialWillDismissScreen:")
	void willDismissScreen (GADInterstitial ad);

	/** Sent just after dismissing an interstitial and it has animated off the screen. */
	@Method(selector = "interstitialDidDismissScreen:")
	void didDismissScreen (GADInterstitial ad);

	/** Sent just before the application will background or terminate because the user clicked on an ad that will launch another
	 * application (such as the App Store). The normal UIApplicationDelegate methods, like applicationDidEnterBackground:, will be
	 * called immediately before this. */
	@Method(selector = "interstitialWillLeaveApplication:")
	void willLeaveApplication (GADInterstitial ad);
}
