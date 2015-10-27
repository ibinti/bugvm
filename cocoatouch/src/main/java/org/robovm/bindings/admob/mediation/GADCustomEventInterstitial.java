
package org.robovm.bindings.admob.mediation;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;

public interface GADCustomEventInterstitial extends NSObjectProtocol {
	/** This method is called by Mediation when your Custom Event is scheduled to be executed. Your implementation should begin
	 * retrieval of the interstitial ad, usually from a backend server, or from an ad network SDK. Results of the execution should
	 * be reported back via the delegate. Note that you should wait until -presentFromRootViewController is called before
	 * displaying the interstitial ad. Do not automatically display the ad when you receive the ad. Instead, retain the ad and
	 * display it when presentFromRootViewController is called. |serverParameter| and |serverLabel| are the parameter and label
	 * configured in the AdMob Mediation UI for the Custom Event. |request| contains information about the ad request, some of
	 * those are from GADRequest.
	 * @param serverParameter
	 * @param serverLabel
	 * @param request */
	@Method(selector = "requestInterstitialAdWithParameter:label:request:")
	void requestInterstitial (String serverParameter, String serverLabel, GADCustomEventRequest request);

	/** Present the interstitial ad as a modal view using the provided view controller. This is called only after your Custom Event
	 * calls back to the delegate with the message -customEvent:didReceiveAd: .
	 * @param rootViewController */
	@Method(selector = "presentFromRootViewController:")
	void present (UIViewController rootViewController);

	/** Setter for delegate You should call back to the |delegate| with the results of the execution to ensure Mediation behaves
	 * correctly. The delegate is assigned, not retained, to prevent memory leak caused by circular retention.
	 * 
	 * You can create accessor methods either by doing
	 * 
	 * @synthesize delegate;
	 * 
	 *             in your class implementation, or define the methods -delegate and -setDelegate: yourself.
	 * 
	 *             In your object's -dealloc method, remember to nil out the delegate.
	 * @param delegate */
	@Method(selector = "setDelegate:")
	void setDelegate (GADCustomEventInterstitialDelegate delegate);

	/** Getter for Delegate You should call back to the |delegate| with the results of the execution to ensure Mediation behaves
	 * correctly. The delegate is assigned, not retained, to prevent memory leak caused by circular retention.
	 * 
	 * You can create accessor methods either by doing
	 * 
	 * @synthesize delegate;
	 * 
	 *             in your class implementation, or define the methods -delegate and -setDelegate: yourself.
	 * 
	 *             In your object's -dealloc method, remember to nil out the delegate.
	 * @return */
	@Method(selector = "delegate")
	GADCustomEventInterstitialDelegate getDelegate ();
}
