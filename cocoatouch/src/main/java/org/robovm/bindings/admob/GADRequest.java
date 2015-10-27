
package org.robovm.bindings.admob;

import java.util.List;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** Specifies optional parameters for ad requests. */
@NativeClass
public class GADRequest extends NSObject {
    /** Constant for getting test ads on the simulator using the testDevices method. */
    public static final String GAD_SIMULATOR_ID = "Simulator";

    /** Creates an autoreleased GADRequest. */
    @Method(selector = "request")
    public native static GADRequest create ();

    /** Ad networks may have additional parameters they accept. To pass these parameters to them, create the ad network extras
     * object for that network, fill in the parameters, and register it here. The ad network should have a header defining the
     * interface for the 'extras' object to create. All networks will have access to the basic settings you've set in this
     * GADRequest (gender, birthday, testing mode, etc.). If you register an extras object that is the same class as one you have
     * registered before, the previous extras will be overwritten. */
    @Method(selector = "registerAdNetworkExtras:")
    public native void registerAdNetworkExtras (GADAdNetworkExtras extras);

    /** @param clazz
     * @return the network extras defined for an ad network. */
    public GADAdNetworkExtras getAdNetworkExtras (Class<? extends GADAdNetworkExtras> clazz) {
        return getAdNetworkExtras(ObjCClass.getByType(clazz));
    }

    @Method(selector = "adNetworkExtrasFor:")
    private native GADAdNetworkExtras getAdNetworkExtras (ObjCClass clazz);

    /** Unsets the extras for an ad network.
     * @param clazz the class which represents that network's extras type. */
    public void removeAdNetworkExtras (Class<? extends GADAdNetworkExtras> clazz) {
        removeAdNetworkExtras(ObjCClass.getByType(clazz));
    }

    @Method(selector = "removeAdNetworkExtrasFor:")
    private native void removeAdNetworkExtras (ObjCClass clazz);

    /** Extras sent to the mediation server (if using Mediation). For future use.
     * @param extras */
    @Property
    public native void setMediationExtras (NSDictionary<?, ?> extras);

    @Property
    public native NSDictionary<?, ?> getMediationExtras ();

    @Method(selector = "sdkVersion")
    public static native String getSDKVersion ();

    /** Add the device's identifier into this array for testing purposes.
     * @param testDevices */
    @Property
    public native void setTestDevices (
        @org.robovm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> testDevices);

    @Property
    public native @org.robovm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getTestDevices ();

    /** The user's gender may be used to deliver more relevant ads.
     * @param gender */
    @Property
    public native void setGender (GADGender gender);

    @Property
    public native GADGender getGender ();

    /** The user's birthday may be used to deliver more relevant ads.
     * @param month
     * @param day
     * @param year */
    @Method(selector = "setBirthdayWithMonth:day:year:")
    public native void setBirthday (int month, int day, int year);

    /** The user's current location may be used to deliver more relevant ads. However do not use Core Location just for
     * advertising, make sure it is used for more beneficial reasons as well. It is both a good idea and part of Apple's
     * guidelines.
     * @param latitude
     * @param longitude
     * @param accuracyInMeters */
    @Method(selector = "setLocationWithLatitude:longitude:accuracy:")
    public native void setLocation (float latitude, float longitude, float accuracyInMeters);

    /** When Core Location isn't available but the user's location is known supplying it here may deliver more relevant ads. It can
     * be any free-form text such as "Champs-Elysees Paris" or "94041 US".
     * @param description */
    @Method(selector = "setLocationWithDescription:")
    public native void setLocation (String description);

    /** This method allows you to specify whether you would like your app to be treated as child-directed for purposes of the
     * Children’s Online Privacy Protection Act (COPPA) - http://business.ftc.gov/privacy-and-security/childrens-privacy.
     * 
     * If you call this method with YES, you are indicating that your app should be treated as child-directed for purposes of the
     * Children’s Online Privacy Protection Act (COPPA). If you call this method with NO, you are indicating that your app should
     * not be treated as child-directed for purposes of the Children’s Online Privacy Protection Act (COPPA). If you do not call
     * this method, ad requests will include no indication of how you would like your app treated with respect to COPPA.
     * 
     * By setting this method, you certify that this notification is accurate and you are authorized to act on behalf of the owner
     * of the app. You understand that abuse of this setting may result in termination of your Google account.
     * 
     * Note: it may take some time for this designation to be fully implemented in applicable Google services. This designation
     * will only apply to ad requests for which you have set this method.
     * @param childDirectedTreatment */
    @Method(selector = "tagForChildDirectedTreatment:")
    public native void tagForChildDirectedTreatment (boolean childDirectedTreatment);

    /** A keyword is a word or phrase describing the current activity of the user such as "Sports Scores". To clear the keywords
     * set this to null.
     * @param keywords */
    @Property
    public native void setKeywords (
        @org.robovm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> keywords);

    @Property
    public native @org.robovm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getKeywords ();

    /** Convenience method for adding keywords one at a time such as @"Sports Scores" and then @"Football".
     * @param keyword */
    @Method(selector = "addKeyword:")
    public native void addKeyword (String keyword);
}
