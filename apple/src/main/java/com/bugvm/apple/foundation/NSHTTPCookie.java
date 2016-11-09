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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSHTTPCookie/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSHTTPCookiePtr extends Ptr<NSHTTPCookie, NSHTTPCookiePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSHTTPCookie.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSHTTPCookie() {}
    protected NSHTTPCookie(SkipInit skipInit) { super(skipInit); }
    public NSHTTPCookie(NSHTTPCookieAttributes properties) { super((SkipInit) null); initObject(init(properties)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "properties")
    public native NSHTTPCookieAttributes getProperties();
    @Property(selector = "version")
    public native @MachineSizedUInt long getVersion();
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "value")
    public native String getValue();
    @Property(selector = "expiresDate")
    public native NSDate getExpiresDate();
    @Property(selector = "isSessionOnly")
    public native boolean isSessionOnly();
    @Property(selector = "domain")
    public native String getDomain();
    @Property(selector = "path")
    public native String getPath();
    @Property(selector = "isSecure")
    public native boolean isSecure();
    @Property(selector = "isHTTPOnly")
    public native boolean isHTTPOnly();
    @Property(selector = "comment")
    public native String getComment();
    @Property(selector = "commentURL")
    public native NSURL getCommentURL();
    @Property(selector = "portList")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsIntegerListMarshaler.class) List<Integer> getPortList();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithProperties:")
    protected native @Pointer long init(NSHTTPCookieAttributes properties);
    @Method(selector = "requestHeaderFieldsWithCookies:")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringStringMapMarshaler.class) Map<String, String> getRequestHeaderFieldsWithCookies(NSArray<NSHTTPCookie> cookies);
    @Method(selector = "cookiesWithResponseHeaderFields:forURL:")
    public static native NSArray<NSHTTPCookie> getCookiesWithResponseHeaderFields(@com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringStringMapMarshaler.class) Map<String, String> headerFields, NSURL url);
    /*</methods>*/
}
