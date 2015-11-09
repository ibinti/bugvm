
package com.bugvm.bindings.admob;

import com.bugvm.apple.coregraphics.CGPoint;
import com.bugvm.apple.uikit.UIView;
import com.bugvm.apple.uikit.UIViewController;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.rt.bro.annotation.ByVal;
import com.bugvm.rt.bro.annotation.Pointer;

/** The view that displays banner ads. A minimum implementation to get an ad from within a UIViewController class is:
 * 
 * Create and setup the ad view, specifying the size and origin at {0, 0}.
 * 
 * <pre>
 * GADBannerView adView = new GADBannerView(GADAdSizeManager.banner());
 * adView.setRootViewController(this);
 * adView.setAdUnitID(&quot;ID created when registering my app&quot;);
 * </pre>
 * 
 * Place the ad view onto the screen.
 * 
 * <pre>
 * this.addSubview(adView);
 * </pre>
 * 
 * Request an ad without any additional targeting information.
 * 
 * <pre>
 * adView.loadRequest(null);
 * </pre> */
@NativeClass
public class GADBannerView extends UIView {

    /** Initializes a GADBannerView and sets it to the specified size, and specifies its placement at the top left of its
     * superview. If size is invalid, an instance of GADBannerView is not created and nil is returned instead.
     * @param size */
    public GADBannerView (GADAdSize size) {
        super((SkipInit)null);
        initObject(init(size));
    }

    /** Initializes a GADBannerView and sets it to the specified size, and specifies its placement within its superview bounds. If
     * |size| is invalid, an instance of GADBannerView is not created and nil is returned instead.
     * @param size
     * @param origin */
    public GADBannerView (GADAdSize size, CGPoint origin) {
        super((SkipInit)null);
        initObject(init(size, origin));
    }

    @Method(selector = "initWithAdSize:")
    private native @Pointer long init (@ByVal GADAdSize size);

    @Method(selector = "initWithAdSize:origin:")
    private native @Pointer long init (@ByVal GADAdSize size, @ByVal CGPoint origin);

    @Property
    public native String getAdUnitID ();

    /** Required value created in the AdSense website. Create a new ad unit for every unique placement of an ad in your
     * application. Set this to the ID assigned for this placement. Ad units are important for targeting and stats. Example values
     * for different request types: AdMob: a0123456789ABCD DFP: /0123/ca-pub-0123456789012345/my-ad-identifier AdSense:
     * ca-mb-app-pub-0123456789012345/my-ad-identifier Mediation: AB123456789ABCDE
     * @param adUnitID */
    @Property
    public native void setAdUnitID (String adUnitID);

    @Property
    public native UIViewController getRootViewController ();

    /** Required reference to the current root view controller. For example the root view controller in tab-based application would
     * be the UITabViewController.
     * @param viewController */
    @Property
    public native void setRootViewController (UIViewController viewController);

    @Property
    public native @ByVal GADAdSize getAdSize ();

    /** Required to set this banner view to a proper size. Never create your own GADAdSize directly. Use one of the predefined
     * standard ad sizes (such as kGADAdSizeBanner), or create one using the GADAdSizeFromCGSize method. If not using mediation,
     * then changing the adSize after an ad has been shown will cause a new request (for an ad of the new size) to be sent. If
     * using mediation, then a new request may not be sent.
     * @param adSize */
    @Property(strongRef = true)
    public native void setAdSize (@ByVal GADAdSize adSize);

    @Property
    public native GADBannerViewDelegate getDelegate ();

    /** Optional delegate object that receives state change notifications from this GADBannerView. Typically this is a
     * UIViewController, however, if you are unfamiliar with the delegate pattern it is recommended you subclass this
     * GADBannerView and make it the delegate. That avoids any chance of your application crashing if you forget to null out the
     * delegate.
     * @param delegate */
    @Property(strongRef = true)
    public native void setDelegate (GADBannerViewDelegate delegate);

    @Property
    public native GADInAppPurchaseDelegate getInAppPurchaseDelegate ();

    /** Optional delegate object that receives in-app purchase notifications from this ad. Required for the custom in-app purchase
     * flow, but ignored when using the default in-app purchase flow. Remember to set the delegate to null before deallocating
     * this object.
     * @param delegate */
    @Property(strongRef = true)
    public native void setInAppPurchaseDelegate (GADInAppPurchaseDelegate delegate);

    /** Makes an ad request. Additional targeting options can be supplied with a request object. Refresh the ad by calling this
     * method again.
     * @param request */
    @Method(selector = "loadRequest:")
    public native void loadRequest (GADRequest request);

    /** @return {@code true}, if the currently displayed ad (or most recent failure) was a result of auto refreshing as specified on
     *         server. This will be set to {@code false} after each {@link #loadRequest(GADRequest)} method. */
    @Property(selector = "hasAutoRefreshed")
    public native boolean isAutoRefreshed ();

    /** @deprecated Use {@link #getAdNetworkClassName()} instead.
     * @return the underlying ad view of the mediated ad network. You may use this to find out the actual size of the ad and
     *         adjust GADBannerView to fit the underlying ad view. */
    @Property
    @Deprecated()
    public native UIView getMediatedAdView ();

    /** @return the ad network class name that fetched the current ad. Returns nil while the latest ad request is in progress or if
     *         the latest ad request failed. For both standard and mediated Google AdMob ads, this method returns
     *         "GADMAdapterGoogleAdMobAds". For ads fetched via mediation custom events, this method returns
     *         "GADMAdapterCustomEvents". */
    @Property
    public native String getAdNetworkClassName ();
}
