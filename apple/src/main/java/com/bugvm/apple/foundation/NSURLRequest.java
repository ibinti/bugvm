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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSURLRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSURLRequestPtr extends Ptr<NSURLRequest, NSURLRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSURLRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSURLRequest() {}
    protected NSURLRequest(SkipInit skipInit) { super(skipInit); }
    public NSURLRequest(NSURL URL) { super((SkipInit) null); initObject(init(URL)); }
    public NSURLRequest(NSURL URL, NSURLRequestCachePolicy cachePolicy, double timeoutInterval) { super((SkipInit) null); initObject(init(URL, cachePolicy, timeoutInterval)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "URL")
    public native NSURL getURL();
    @Property(selector = "cachePolicy")
    public native NSURLRequestCachePolicy getCachePolicy();
    @Property(selector = "timeoutInterval")
    public native double getTimeoutInterval();
    @Property(selector = "mainDocumentURL")
    public native NSURL getMainDocumentURL();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "networkServiceType")
    public native NSURLRequestNetworkServiceType getNetworkServiceType();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "allowsCellularAccess")
    public native boolean allowsCellularAccess();
    @Property(selector = "HTTPMethod")
    public native String getHTTPMethod();
    @Property(selector = "allHTTPHeaderFields")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringStringMapMarshaler.class) Map<String, String> getAllHTTPHeaderFields();
    @Property(selector = "HTTPBody")
    public native NSData getHTTPBody();
    @Property(selector = "HTTPBodyStream")
    public native NSInputStream getHTTPBodyStream();
    @Property(selector = "HTTPShouldHandleCookies")
    public native boolean shouldHandleHTTPCookies();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "HTTPShouldUsePipelining")
    public native boolean shouldUseHTTPPipelining();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithURL:")
    protected native @Pointer long init(NSURL URL);
    @Method(selector = "initWithURL:cachePolicy:timeoutInterval:")
    protected native @Pointer long init(NSURL URL, NSURLRequestCachePolicy cachePolicy, double timeoutInterval);
    @Method(selector = "supportsSecureCoding")
    public static native boolean supportsSecureCoding();
    @Method(selector = "valueForHTTPHeaderField:")
    public native String getHTTPHeaderFieldValue(String field);
    /*</methods>*/
}
