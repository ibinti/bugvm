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
package com.bugvm.apple.webkit;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.security.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("WebKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/WKWebViewConfiguration/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class WKWebViewConfigurationPtr extends Ptr<WKWebViewConfiguration, WKWebViewConfigurationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(WKWebViewConfiguration.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public WKWebViewConfiguration() {}
    protected WKWebViewConfiguration(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "processPool")
    public native WKProcessPool getProcessPool();
    @Property(selector = "setProcessPool:")
    public native void setProcessPool(WKProcessPool v);
    @Property(selector = "preferences")
    public native WKPreferences getPreferences();
    @Property(selector = "setPreferences:")
    public native void setPreferences(WKPreferences v);
    @Property(selector = "userContentController")
    public native WKUserContentController getUserContentController();
    @Property(selector = "setUserContentController:")
    public native void setUserContentController(WKUserContentController v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "websiteDataStore")
    public native WKWebsiteDataStore getWebsiteDataStore();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setWebsiteDataStore:")
    public native void setWebsiteDataStore(WKWebsiteDataStore v);
    @Property(selector = "suppressesIncrementalRendering")
    public native boolean suppressesIncrementalRendering();
    @Property(selector = "setSuppressesIncrementalRendering:")
    public native void setSuppressesIncrementalRendering(boolean v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "applicationNameForUserAgent")
    public native String getApplicationNameForUserAgent();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setApplicationNameForUserAgent:")
    public native void setApplicationNameForUserAgent(String v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "allowsAirPlayForMediaPlayback")
    public native boolean allowsAirPlayForMediaPlayback();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setAllowsAirPlayForMediaPlayback:")
    public native void setAllowsAirPlayForMediaPlayback(boolean v);
    @Property(selector = "allowsInlineMediaPlayback")
    public native boolean allowsInlineMediaPlayback();
    @Property(selector = "setAllowsInlineMediaPlayback:")
    public native void setAllowsInlineMediaPlayback(boolean v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "requiresUserActionForMediaPlayback")
    public native boolean requiresUserActionForMediaPlayback();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setRequiresUserActionForMediaPlayback:")
    public native void setRequiresUserActionForMediaPlayback(boolean v);
    @Property(selector = "selectionGranularity")
    public native WKSelectionGranularity getSelectionGranularity();
    @Property(selector = "setSelectionGranularity:")
    public native void setSelectionGranularity(WKSelectionGranularity v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "allowsPictureInPictureMediaPlayback")
    public native boolean allowsPictureInPictureMediaPlayback();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setAllowsPictureInPictureMediaPlayback:")
    public native void setAllowsPictureInPictureMediaPlayback(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Property(selector = "mediaPlaybackRequiresUserAction")
    public native boolean mediaPlaybackRequiresUserAction();
    /**
     * @since Available in iOS 8.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Property(selector = "setMediaPlaybackRequiresUserAction:")
    public native void setMediaPlaybackRequiresUserAction(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Property(selector = "mediaPlaybackAllowsAirPlay")
    public native boolean mediaPlaybackAllowsAirPlay();
    /**
     * @since Available in iOS 8.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Property(selector = "setMediaPlaybackAllowsAirPlay:")
    public native void setMediaPlaybackAllowsAirPlay(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
