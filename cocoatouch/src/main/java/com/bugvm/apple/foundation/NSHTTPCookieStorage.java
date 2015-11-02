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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSHTTPCookieStorage/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        public static NSObject observeAcceptPolicyChanged(NSHTTPCookieStorage object, final VoidBlock1<NSHTTPCookieStorage> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(AcceptPolicyChangedNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((NSHTTPCookieStorage) a.getObject());
                }
            });
        }
        public static NSObject observeCookiesChanged(NSHTTPCookieStorage object, final VoidBlock1<NSHTTPCookieStorage> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(CookiesChangedNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((NSHTTPCookieStorage) a.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class NSHTTPCookieStoragePtr extends Ptr<NSHTTPCookieStorage, NSHTTPCookieStoragePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSHTTPCookieStorage.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSHTTPCookieStorage() {}
    protected NSHTTPCookieStorage(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "cookies")
    public native NSArray<NSHTTPCookie> getCookies();
    @Property(selector = "cookieAcceptPolicy")
    public native NSHTTPCookieAcceptPolicy getCookieAcceptPolicy();
    @Property(selector = "setCookieAcceptPolicy:")
    public native void setCookieAcceptPolicy(NSHTTPCookieAcceptPolicy v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="NSHTTPCookieManagerAcceptPolicyChangedNotification", optional=true)
    public static native NSString AcceptPolicyChangedNotification();
    @GlobalValue(symbol="NSHTTPCookieManagerCookiesChangedNotification", optional=true)
    public static native NSString CookiesChangedNotification();
    
    @Method(selector = "setCookie:")
    public native void setCookie(NSHTTPCookie cookie);
    @Method(selector = "deleteCookie:")
    public native void deleteCookie(NSHTTPCookie cookie);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "removeCookiesSinceDate:")
    public native void removeCookiesSinceDate(NSDate date);
    @Method(selector = "cookiesForURL:")
    public native NSArray<NSHTTPCookie> getCookiesForURL(NSURL URL);
    @Method(selector = "setCookies:forURL:mainDocumentURL:")
    public native void setCookiesForURL(NSArray<NSHTTPCookie> cookies, NSURL URL, NSURL mainDocumentURL);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "sortedCookiesUsingDescriptors:")
    public native NSArray<NSHTTPCookie> getSortedCookies(NSArray<NSSortDescriptor> sortOrder);
    @Method(selector = "sharedHTTPCookieStorage")
    public static native NSHTTPCookieStorage getSharedHTTPCookieStorage();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "sharedCookieStorageForGroupContainerIdentifier:")
    public static native NSHTTPCookieStorage getSharedCookieStorageForGroupContainer(String identifier);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "storeCookies:forTask:")
    public native void storeCookiesForTask(NSArray<NSHTTPCookie> cookies, NSURLSessionTask task);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "getCookiesForTask:completionHandler:")
    public native void getCookiesForTask(NSURLSessionTask task, @Block VoidBlock1<NSArray<NSHTTPCookie>> completionHandler);
    /*</methods>*/
}
