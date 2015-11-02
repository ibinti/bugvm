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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSCachedURLResponse/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSCachedURLResponsePtr extends Ptr<NSCachedURLResponse, NSCachedURLResponsePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSCachedURLResponse.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSCachedURLResponse() {}
    protected NSCachedURLResponse(SkipInit skipInit) { super(skipInit); }
    public NSCachedURLResponse(NSURLResponse response, NSData data) { super((SkipInit) null); initObject(init(response, data)); }
    public NSCachedURLResponse(NSURLResponse response, NSData data, NSDictionary<?, ?> userInfo, NSURLCacheStoragePolicy storagePolicy) { super((SkipInit) null); initObject(init(response, data, userInfo, storagePolicy)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "response")
    public native NSURLResponse getResponse();
    @Property(selector = "data")
    public native NSData getData();
    @Property(selector = "userInfo")
    public native NSDictionary<?, ?> getUserInfo();
    @Property(selector = "storagePolicy")
    public native NSURLCacheStoragePolicy getStoragePolicy();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithResponse:data:")
    protected native @Pointer long init(NSURLResponse response, NSData data);
    @Method(selector = "initWithResponse:data:userInfo:storagePolicy:")
    protected native @Pointer long init(NSURLResponse response, NSData data, NSDictionary<?, ?> userInfo, NSURLCacheStoragePolicy storagePolicy);
    /*</methods>*/
}
