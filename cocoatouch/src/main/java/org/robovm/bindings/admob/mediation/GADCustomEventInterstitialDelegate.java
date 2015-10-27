
package org.robovm.bindings.admob.mediation;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/** Call back to this delegate in your custom event. You must call customEventInterstitial:didReceiveAd: when there is an ad to
 * show, or customEventInterstitial:didFailAd: when there is no ad to show. Otherwise, if enough time passed (several seconds)
 * after the SDK called the requestInterstitialAdWithParameter: method of your custom event, the mediation SDK will consider the
 * request timed out, and move on to the next ad network. */
public interface GADCustomEventInterstitialDelegate extends NSObjectProtocol {
	/** Your Custom Event object must call this when it receives or creates an interstitial ad. If there is an ad object, pass it in
	 * the method call. Pass nil if the ad object is not available.
	 * @param customEvent
	 * @param ad */
	@Method(selector = "customEventInterstitial:didReceiveAd:")
	void didReceiveAd (GADCustomEventInterstitial customEvent, NSObject ad);

	/** Your Custom Event object must call this when it fails to receive or create the ad. Pass along any error object sent from the
	 * ad network's SDK, or an NSError describing the error. Pass nil if not available.
	 * @param customEvent
	 * @param error */
	@Method(selector = "customEventInterstitial:didFailAd:")
	void didFailAd (GADCustomEventInterstitial customEvent, NSError error);

	/** Your Custom Event should call this when the interstitial is being displayed.
	 * @param customEvent */
	@Method(selector = "customEventInterstitialWillPresent:")
	void willPresent (GADCustomEventInterstitial customEvent);

	/** Your Custom Event should call this when the interstitial is about to be dismissed.
	 * @param customEvent */
	@Method(selector = "customEventInterstitialWillDismiss:")
	void willDismiss (GADCustomEventInterstitial customEvent);

	/** Your Custom Event should call this when the interstitial has been dismissed.
	 * @param customEvent */
	@Method(selector = "customEventInterstitialDidDismiss:")
	void didDismiss (GADCustomEventInterstitial customEvent);

	/** Your Custom Event should call this method when a user action will result in App switching.
	 * @param customEvent */
	@Method(selector = "customEventInterstitialWillLeaveApplication:")
	void willLeaveApplication (GADCustomEventInterstitial customEvent);
}
