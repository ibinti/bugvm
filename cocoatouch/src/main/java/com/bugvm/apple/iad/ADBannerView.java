/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bugvm.apple.iad;

/*<imports>*/
import java.util.*;

import com.bugvm.apple.coregraphics.CGRect;
import com.bugvm.apple.coregraphics.CGSize;
import com.bugvm.apple.foundation.NSString;
import com.bugvm.apple.uikit.UIView;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("iAd") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ADBannerView/*</name>*/ 
    extends /*<extends>*/UIView/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class ADBannerViewPtr extends Ptr<ADBannerView, ADBannerViewPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(ADBannerView.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public ADBannerView() {}
    protected ADBannerView(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 6.0 and later.
     */
    public ADBannerView(ADAdType type) { super((SkipInit) null); initObject(init(type)); }
    /*</constructors>*/
    public ADBannerView(CGRect frame) {
    	super(frame);
    }
    /*<properties>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "adType")
    public native ADAdType getAdType();
    @Property(selector = "delegate")
    public native ADBannerViewDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(ADBannerViewDelegate v);
    @Property(selector = "isBannerLoaded")
    public native boolean isBannerLoaded();
    @Property(selector = "isBannerViewActionInProgress")
    public native boolean isBannerViewActionInProgress();
    @Property(selector = "advertisingSection")
    public native String getAdvertisingSection();
    @Property(selector = "setAdvertisingSection:")
    public native void setAdvertisingSection(String v);
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 6.0.
     */
    @Deprecated
    @Property(selector = "requiredContentSizeIdentifiers")
    public native @com.bugvm.rt.bro.annotation.Marshaler(ADBannerContentSizeIdentifier.AsListMarshaler.class) List<ADBannerContentSizeIdentifier> getRequiredContentSizeIdentifiers();
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 6.0.
     */
    @Deprecated
    @Property(selector = "setRequiredContentSizeIdentifiers:")
    public native void setRequiredContentSizeIdentifiers(@com.bugvm.rt.bro.annotation.Marshaler(ADBannerContentSizeIdentifier.AsListMarshaler.class) List<ADBannerContentSizeIdentifier> v);
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 6.0.
     */
    @Deprecated
    @Property(selector = "currentContentSizeIdentifier")
    public native ADBannerContentSizeIdentifier getCurrentContentSizeIdentifier();
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 6.0.
     */
    @Deprecated
    @Property(selector = "setCurrentContentSizeIdentifier:")
    public native void setCurrentContentSizeIdentifier(ADBannerContentSizeIdentifier v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "initWithAdType:")
    protected native @Pointer long init(ADAdType type);
    @Method(selector = "cancelBannerViewAction")
    public native void cancelBannerViewAction();
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 6.0.
     */
    @Deprecated
    @WeaklyLinked
    @Method(selector = "sizeFromBannerContentSizeIdentifier:")
    protected static native @ByVal
    CGSize getSizeForIdentifier(NSString contentSizeIdentifier);
    /*</methods>*/
}
