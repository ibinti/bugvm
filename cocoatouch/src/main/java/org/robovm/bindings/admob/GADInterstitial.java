
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** An interstitial ad. This is a full-screen advertisement shown at natural transition points in your application such as between
 * game levels or news stories.
 * 
 * Interstitials are shown sparingly. Expect low to no fill. */
@NativeClass
public class GADInterstitial extends NSObject {
    @Property
    public native String getAdUnitID ();

    /** Required value created in the AdSense website. Create a new ad unit for every unique placement of an ad in your
     * application. Set this to the ID assigned for this placement. Ad units are important for targeting and stats. Example values
     * for different request types:
     * 
     * <pre>
     * AdMob: a0123456789ABCD
     * DFP: /0123/ca-pub-0123456789012345/my-ad-identifier 
     * AdSense: ca-mb-app-pub-0123456789012345/my-ad-identifier
     * </pre> */
    @Property
    public native void setAdUnitID (String adUnitID);

    @Property
    public native GADInterstitialDelegate getDelegate ();

    /** Optional delegate object that receives state change notifications from this GADInterstitalAd. */
    @Property(strongRef = true)
    public native void setDelegate (GADInterstitialDelegate delegate);

    @Property
    public native GADInAppPurchaseDelegate getInAppPurchaseDelegate ();

    /** Optional delegate object that receives in-app purchase notifications from this ad. Required for the custom in-app purchase
     * flow, but ignored when using the default in-app purchase flow. Remember to set the delegate to null before deallocating
     * this object.
     * @param delegate */
    @Property(strongRef = true)
    public native void setInAppPurchaseDelegate (GADInAppPurchaseDelegate delegate);

    /** Makes an interstitial ad request. Additional targeting options can be supplied with a request object. Only one interstitial
     * request is allowed at a time.
     * 
     * This is best to do several seconds before the interstitial is needed to preload its content. Then when transitioning
     * between view controllers show the interstitial with {@link #present(UIViewController)}.
     * @param request */
    @Method(selector = "loadRequest:")
    public native void loadRequest (GADRequest request);

    /** @return {@code true} if the interstitial is ready to be displayed. The delegate's interstitialAdDidReceiveAd: will be called
     *         when this switches from {@code false} to {@code true} . */
    @Property(selector = "isReady")
    public native boolean isReady ();

    /** @return {@code true} if the interstitial object has already shown an interstitial. Note that an interstitial object can only
     *         be used once even with different requests. */
    @Property(selector = "hasBeenUsed")
    public native boolean isBeenUsed ();

    /** @return the ad network class name that fetched the current ad. Returns {@code null} while the latest ad request is in
     *         progress or if the latest ad request failed. For both standard and mediated Google AdMob ads, this method returns
     *         "GADMAdapterGoogleAdMobAds". For ads fetched via mediation custom events, this method returns
     *         "GADMAdapterCustomEvents". */
    @Property
    public native String getAdNetworkClassName ();

    /** Presents the interstitial ad which takes over the entire screen until the user dismisses it. This has no effect unless
     * {@link #isReady()} returns {@code true} and/or the delegate's {@link GADInterstitialDelegate#didReceiveAd(GADInterstitial)}
     * has been received.
     * 
     * Set rootViewController to the current view controller at the time this method is called. If your application does not use
     * view controllers pass in {@code null} and your views will be removed from the window to show the interstitial and restored
     * when done. After the interstitial has been removed, the delegate's
     * {@link GADInterstitialDelegate#didDismissScreen(GADInterstitial)} will be called.
     * @param rootViewController */
    @Method(selector = "presentFromRootViewController:")
    public native void present (UIViewController rootViewController);
}
