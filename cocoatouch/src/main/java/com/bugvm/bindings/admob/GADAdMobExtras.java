
package com.bugvm.bindings.admob;

import com.bugvm.apple.foundation.NSDictionary;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;

/** The additional parameters publishers may send to the AdMob network. */
@NativeClass
public class GADAdMobExtras extends GADAdNetworkExtras {
    @Property
    public native void setAdditionalParameters (NSDictionary<?, ?> additionalParameters);

    @Property
    public native NSDictionary<?, ?> getAdditionalParameters ();
}
