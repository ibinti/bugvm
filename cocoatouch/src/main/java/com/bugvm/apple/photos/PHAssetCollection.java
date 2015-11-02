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
package com.bugvm.apple.photos;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.avfoundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Photos") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHAssetCollection/*</name>*/ 
    extends /*<extends>*/PHCollection/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHAssetCollectionPtr extends Ptr<PHAssetCollection, PHAssetCollectionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHAssetCollection.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHAssetCollection() {}
    protected PHAssetCollection(SkipInit skipInit) { super(skipInit); }
    public PHAssetCollection(NSArray<PHAsset> assets, String title) { super(createTransientAssetCollection(assets, title)); retain(getHandle()); }
    public PHAssetCollection(PHFetchResult<PHAsset> fetchResult, String title) { super(createTransientAssetCollection(fetchResult, title)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "assetCollectionType")
    public native PHAssetCollectionType getAssetCollectionType();
    @Property(selector = "assetCollectionSubtype")
    public native PHAssetCollectionSubtype getAssetCollectionSubtype();
    @Property(selector = "estimatedAssetCount")
    public native @MachineSizedUInt long getEstimatedAssetCount();
    @Property(selector = "startDate")
    public native NSDate getStartDate();
    @Property(selector = "endDate")
    public native NSDate getEndDate();
    @WeaklyLinked
    @Property(selector = "approximateLocation")
    public native CLLocation getApproximateLocation();
    @Property(selector = "localizedLocationNames")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getLocalizedLocationNames();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "fetchAssetCollectionsWithLocalIdentifiers:options:")
    public static native PHFetchResult<PHAssetCollection> fetchAssetCollectionsWithLocalIdentifiers(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> identifiers, PHFetchOptions options);
    @Method(selector = "fetchAssetCollectionsWithType:subtype:options:")
    public static native PHFetchResult<PHAssetCollection> fetchAssetCollectionsWithType(PHAssetCollectionType type, PHAssetCollectionSubtype subtype, PHFetchOptions options);
    @Method(selector = "fetchAssetCollectionsContainingAsset:withType:options:")
    public static native PHFetchResult<PHAssetCollection> fetchAssetCollectionsContainingAsset(PHAsset asset, PHAssetCollectionType type, PHFetchOptions options);
    @Method(selector = "fetchAssetCollectionsWithALAssetGroupURLs:options:")
    public static native PHFetchResult<PHAssetCollection> fetchAssetCollectionsWithALAssetGroupURLs(NSArray<NSURL> assetGroupURLs, PHFetchOptions options);
    @Method(selector = "fetchMomentsInMomentList:options:")
    public static native PHFetchResult<PHAssetCollection> fetchMomentsInMomentList(PHCollectionList momentList, PHFetchOptions options);
    @Method(selector = "fetchMomentsWithOptions:")
    public static native PHFetchResult<PHAssetCollection> fetchMoments(PHFetchOptions options);
    @Method(selector = "transientAssetCollectionWithAssets:title:")
    protected static native @Pointer long createTransientAssetCollection(NSArray<PHAsset> assets, String title);
    @Method(selector = "transientAssetCollectionWithAssetFetchResult:title:")
    protected static native @Pointer long createTransientAssetCollection(PHFetchResult<PHAsset> fetchResult, String title);
    /*</methods>*/
}
