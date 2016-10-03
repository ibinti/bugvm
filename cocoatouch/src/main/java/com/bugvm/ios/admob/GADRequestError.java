
package com.bugvm.ios.admob;

import com.bugvm.apple.foundation.NSError;
import com.bugvm.objc.annotation.NativeClass;

/** This class represents the error generated due to invalid request parameters. */
@NativeClass
public class GADRequestError extends NSError {
    protected GADRequestError (SkipInit skipInit) {
        super(skipInit);
    }

    /** Google AdMob Ads error domain. */
    public static String getErrorDomain () {
        return GADRequestErrorConstants.errorDomain();
    }

    public com.bugvm.ios.admob.GADErrorCode getErrorCode () {
        long code = getCode();
        if (code >= 0 && code < com.bugvm.ios.admob.GADErrorCode.values().length) {
            return com.bugvm.ios.admob.GADErrorCode.values()[(int)code];
        }
        return null;
    }
}
