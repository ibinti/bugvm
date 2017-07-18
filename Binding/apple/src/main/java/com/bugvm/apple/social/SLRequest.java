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
package com.bugvm.apple.social;

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
import com.bugvm.apple.accounts.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Social") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SLRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SLRequestPtr extends Ptr<SLRequest, SLRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SLRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SLRequest() {}
    protected SLRequest(SkipInit skipInit) { super(skipInit); }
    public SLRequest(SLServiceType serviceType, SLRequestMethod requestMethod, NSURL url, NSDictionary<NSString, ?> parameters) { super(create(serviceType, requestMethod, url, parameters)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @WeaklyLinked
    @Property(selector = "account")
    public native ACAccount getAccount();
    @WeaklyLinked
    @Property(selector = "setAccount:")
    public native void setAccount(ACAccount v);
    @Property(selector = "requestMethod")
    public native SLRequestMethod getRequestMethod();
    @Property(selector = "URL")
    public native NSURL getURL();
    @Property(selector = "parameters")
    public native NSDictionary<NSString, ?> getParameters();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "addMultipartData:withName:type:filename:")
    public native void addMultipartData(NSData data, String name, String type, String filename);
    @Method(selector = "preparedURLRequest")
    public native NSURLRequest getPreparedURLRequest();
    @Method(selector = "performRequestWithHandler:")
    public native void performRequest(@Block VoidBlock3<NSData, NSHTTPURLResponse, NSError> handler);
    @Method(selector = "requestForServiceType:requestMethod:URL:parameters:")
    protected static native @Pointer long create(SLServiceType serviceType, SLRequestMethod requestMethod, NSURL url, NSDictionary<NSString, ?> parameters);
    /*</methods>*/
}
