
package com.bugvm.ios.admob;

import com.bugvm.apple.foundation.NSErrorCode;

/** NSError codes for GAD error domain. */
public enum GADErrorCode implements NSErrorCode {
    /** Typically this is because the ad did not have the ad unit ID or root view controller set. */
    InvalidRequest,
    /** The ad request was successful, but no ad was returned. */
    NoFill,
    /** There was an error loading data from the network. */
    NetworkError,
    /** The ad server experienced a failure processing the request. */
    ServerError,
    /** The current device's OS is below the minimum required version. */
    OSVersionTooLow,
    /** The request was unable to be loaded before being timed out. */
    Timeout,
    /** Will not send request because the interstitial object has already been used. */
    InterstitialAlreadyUsed,
    /** The mediation response was invalid. */
    MediationDataError,
    /** Error finding or creating a mediation ad network adapter. */
    MediationAdapterError,
    /** The mediation request was successful, but no ad was returned from any ad networks. */
    MediationNoFill,
    /** Attempting to pass an invalid ad size to an adapter. */
    MediationInvalidAdSize;

    @Override
    public long value () {
        return ordinal();
    }
}
