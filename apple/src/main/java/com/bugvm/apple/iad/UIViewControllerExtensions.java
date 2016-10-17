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
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.mediaplayer.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.avkit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("iAd")/*</annotations>*/
/*<visibility>*/public final/*</visibility>*/ class /*<name>*/UIViewControllerExtensions/*</name>*/ 
    extends /*<extends>*/NSExtensions/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIViewControllerExtensions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    private UIViewControllerExtensions() {}
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "interstitialPresentationPolicy")
    public static native ADInterstitialPresentationPolicy getInterstitialPresentationPolicy(UIViewController thiz);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setInterstitialPresentationPolicy:")
    public static native void setInterstitialPresentationPolicy(UIViewController thiz, ADInterstitialPresentationPolicy v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "canDisplayBannerAds")
    public static native boolean canDisplayBannerAds(UIViewController thiz);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setCanDisplayBannerAds:")
    public static native void setCanDisplayBannerAds(UIViewController thiz, boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "originalContentView")
    public static native UIView getOriginalContentView(UIViewController thiz);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isPresentingFullScreenAd")
    public static native boolean isPresentingFullScreenAd(UIViewController thiz);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isDisplayingBannerAd")
    public static native boolean isDisplayingBannerAd(UIViewController thiz);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "shouldPresentInterstitialAd")
    public static native boolean shouldPresentInterstitialAd(UIViewController thiz);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "requestInterstitialAdPresentation")
    public static native boolean requestInterstitialAdPresentation(UIViewController thiz);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "prepareInterstitialAds")
    protected static native void prepareInterstitialAds(ObjCClass clazz);
    public static void prepareInterstitialAds() { prepareInterstitialAds(ObjCClass.getByType(UIViewController.class)); }
    /*</methods>*/
}
