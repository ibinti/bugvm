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
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("WebKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/WKWebsiteDataStore/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class WKWebsiteDataStorePtr extends Ptr<WKWebsiteDataStore, WKWebsiteDataStorePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(WKWebsiteDataStore.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public WKWebsiteDataStore() {}
    protected WKWebsiteDataStore(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isPersistent")
    public native boolean isPersistent();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "fetchDataRecordsOfTypes:completionHandler:")
    public native void fetchDataRecords(@com.bugvm.rt.bro.annotation.Marshaler(WKWebsiteDataType.AsSetMarshaler.class) Set<WKWebsiteDataType> dataTypes, @Block VoidBlock1<NSArray<WKWebsiteDataRecord>> completionHandler);
    @Method(selector = "removeDataOfTypes:forDataRecords:completionHandler:")
    public native void removeData(@com.bugvm.rt.bro.annotation.Marshaler(WKWebsiteDataType.AsSetMarshaler.class) Set<WKWebsiteDataType> dataTypes, NSArray<WKWebsiteDataRecord> dataRecords, @Block Runnable completionHandler);
    @Method(selector = "removeDataOfTypes:modifiedSince:completionHandler:")
    public native void removeData(@com.bugvm.rt.bro.annotation.Marshaler(WKWebsiteDataType.AsSetMarshaler.class) Set<WKWebsiteDataType> websiteDataTypes, NSDate date, @Block Runnable completionHandler);
    @Method(selector = "defaultDataStore")
    public static native WKWebsiteDataStore getDefaultDataStore();
    @Method(selector = "nonPersistentDataStore")
    public static native WKWebsiteDataStore getNonPersistentDataStore();
    @Method(selector = "allWebsiteDataTypes")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(WKWebsiteDataType.AsSetMarshaler.class) Set<WKWebsiteDataType> getAllWebsiteDataTypes();
    /*</methods>*/
}
