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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSURLCache/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSURLCachePtr extends Ptr<NSURLCache, NSURLCachePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSURLCache.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSURLCache() {}
    protected NSURLCache(SkipInit skipInit) { super(skipInit); }
    public NSURLCache(@MachineSizedUInt long memoryCapacity, @MachineSizedUInt long diskCapacity, String path) { super((SkipInit) null); initObject(init(memoryCapacity, diskCapacity, path)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "memoryCapacity")
    public native @MachineSizedUInt long getMemoryCapacity();
    @Property(selector = "setMemoryCapacity:")
    public native void setMemoryCapacity(@MachineSizedUInt long v);
    @Property(selector = "diskCapacity")
    public native @MachineSizedUInt long getDiskCapacity();
    @Property(selector = "setDiskCapacity:")
    public native void setDiskCapacity(@MachineSizedUInt long v);
    @Property(selector = "currentMemoryUsage")
    public native @MachineSizedUInt long getCurrentMemoryUsage();
    @Property(selector = "currentDiskUsage")
    public native @MachineSizedUInt long getCurrentDiskUsage();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithMemoryCapacity:diskCapacity:diskPath:")
    protected native @Pointer long init(@MachineSizedUInt long memoryCapacity, @MachineSizedUInt long diskCapacity, String path);
    @Method(selector = "cachedResponseForRequest:")
    public native NSCachedURLResponse getCachedResponse(NSURLRequest request);
    @Method(selector = "storeCachedResponse:forRequest:")
    public native void storeCachedResponse(NSCachedURLResponse cachedResponse, NSURLRequest request);
    @Method(selector = "removeCachedResponseForRequest:")
    public native void removeCachedResponse(NSURLRequest request);
    @Method(selector = "removeAllCachedResponses")
    public native void removeAllCachedResponses();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "removeCachedResponsesSinceDate:")
    public native void removeCachedResponsesSinceDate(NSDate date);
    @Method(selector = "sharedURLCache")
    public static native NSURLCache getSharedURLCache();
    @Method(selector = "setSharedURLCache:")
    public static native void setSharedURLCache(NSURLCache cache);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "storeCachedResponse:forDataTask:")
    public native void storeCachedResponse(NSCachedURLResponse cachedResponse, NSURLSessionDataTask dataTask);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "getCachedResponseForDataTask:completionHandler:")
    public native void getCachedResponse(NSURLSessionDataTask dataTask, @Block VoidBlock1<NSCachedURLResponse> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "removeCachedResponseForDataTask:")
    public native void removeCachedResponse(NSURLSessionDataTask dataTask);
    /*</methods>*/
}
