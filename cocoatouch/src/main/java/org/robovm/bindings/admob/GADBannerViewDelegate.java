
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/** Delegate for receiving state change messages from a GADBannerView such as ad requests succeeding/failing or when an ad has been
 * clicked. */
public interface GADBannerViewDelegate extends NSObjectProtocol {
    /** Sent when an ad request loaded an ad. This is a good opportunity to add this view to the hierarchy if it has not yet been
     * added. If the ad was received as a part of the server-side auto refreshing, you can examine the hasAutoRefreshed property
     * of the view.
     * @param view */
    @Method(selector = "adViewDidReceiveAd:")
    void didReceiveAd (GADBannerView view);

    /** Sent when an ad request failed. Normally this is because no network connection was available or no ads were available (i.e.
     * no fill). If the error was received as a part of the server-side auto refreshing, you can examine the hasAutoRefreshed
     * property of the view.
     * @param error */
    @Method(selector = "adView:didFailToReceiveAdWithError:")
    void didFailToReceiveAd (GADBannerView view, GADRequestError error);

    /** Sent just before presenting the user a full screen view, such as a browser, in response to clicking on an ad. Use this
     * opportunity to stop animations, time sensitive interactions, etc.
     * 
     * Normally the user looks at the ad, dismisses it, and control returns to your application by calling
     * adViewDidDismissScreen:. However if the user hits the Home button or clicks on an App Store link your application will end.
     * On iOS 4.0+ the next method called will be applicationWillResignActive: of your UIViewController
     * (UIApplicationWillResignActiveNotification). Immediately after that adViewWillLeaveApplication: is called.
     * @param view */
    @Method(selector = "adViewWillPresentScreen:")
    void willPresentScreen (GADBannerView view);

    /** Sent just before dismissing a full screen view.
     * @param view */
    @Method(selector = "adViewWillDismissScreen:")
    void willDismissScreen (GADBannerView view);

    /** Sent just after dismissing a full screen view. Use this opportunity to restart anything you may have stopped as part of
     * adViewWillPresentScreen:.
     * @param view */
    @Method(selector = "adViewDidDismissScreen:")
    void didDismissScreen (GADBannerView view);

    /** Sent just before the application will background or terminate because the user clicked on an ad that will launch another
     * application (such as the App Store). The normal UIApplicationDelegate methods, like applicationDidEnterBackground:, will be
     * called immediately before this.
     * @param view */
    @Method(selector = "adViewWillLeaveApplication:")
    void willLeaveApplication (GADBannerView view);
}
