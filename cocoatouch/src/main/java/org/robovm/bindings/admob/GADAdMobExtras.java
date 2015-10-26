
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The additional parameters publishers may send to the AdMob network. */
@NativeClass
public class GADAdMobExtras extends GADAdNetworkExtras {
    @Property
    public native void setAdditionalParameters (NSDictionary<?, ?> additionalParameters);

    @Property
    public native NSDictionary<?, ?> getAdditionalParameters ();
}
