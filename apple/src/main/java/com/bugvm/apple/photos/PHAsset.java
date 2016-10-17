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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHAsset/*</name>*/ 
    extends /*<extends>*/PHObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHAssetPtr extends Ptr<PHAsset, PHAssetPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHAsset.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHAsset() {}
    protected PHAsset(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "mediaType")
    public native PHAssetMediaType getMediaType();
    @Property(selector = "mediaSubtypes")
    public native PHAssetMediaSubtype getMediaSubtypes();
    @Property(selector = "pixelWidth")
    public native @MachineSizedUInt long getPixelWidth();
    @Property(selector = "pixelHeight")
    public native @MachineSizedUInt long getPixelHeight();
    @Property(selector = "creationDate")
    public native NSDate getCreationDate();
    @Property(selector = "modificationDate")
    public native NSDate getModificationDate();
    @WeaklyLinked
    @Property(selector = "location")
    public native CLLocation getLocation();
    @Property(selector = "duration")
    public native double getDuration();
    @Property(selector = "isHidden")
    public native boolean isHidden();
    @Property(selector = "isFavorite")
    public native boolean isFavorite();
    @Property(selector = "burstIdentifier")
    public native String getBurstIdentifier();
    @Property(selector = "burstSelectionTypes")
    public native PHAssetBurstSelectionType getBurstSelectionTypes();
    @Property(selector = "representsBurst")
    public native boolean representsBurst();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "sourceType")
    public native PHAssetSourceType getSourceType();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "canPerformEditOperation:")
    public native boolean canPerformEditOperation(PHAssetEditOperation editOperation);
    @Method(selector = "fetchAssetsInAssetCollection:options:")
    public static native PHFetchResult<PHAsset> fetchAssetsInAssetCollection(PHAssetCollection assetCollection, PHFetchOptions options);
    @Method(selector = "fetchAssetsWithLocalIdentifiers:options:")
    public static native PHFetchResult<PHAsset> fetchAssetsWithLocalIdentifiers(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> identifiers, PHFetchOptions options);
    @Method(selector = "fetchKeyAssetsInAssetCollection:options:")
    public static native PHFetchResult<PHAsset> fetchKeyAssetsInAssetCollection(PHAssetCollection assetCollection, PHFetchOptions options);
    @Method(selector = "fetchAssetsWithBurstIdentifier:options:")
    public static native PHFetchResult<PHAsset> fetchAssetsWithBurstIdentifier(String burstIdentifier, PHFetchOptions options);
    @Method(selector = "fetchAssetsWithOptions:")
    public static native PHFetchResult<PHAsset> fetchAssets(PHFetchOptions options);
    @Method(selector = "fetchAssetsWithMediaType:options:")
    public static native PHFetchResult<PHAsset> fetchAssetsWithMediaType(PHAssetMediaType mediaType, PHFetchOptions options);
    @Method(selector = "fetchAssetsWithALAssetURLs:options:")
    public static native PHFetchResult<PHAsset> fetchAssetsWithALAssetURLs(NSArray<NSURL> assetURLs, PHFetchOptions options);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "requestContentEditingInputWithOptions:completionHandler:")
    public native @MachineSizedUInt long requestContentEditingInput(PHContentEditingInputRequestOptions options, @Block VoidBlock2<PHContentEditingInput, NSDictionary<NSString, NSObject>> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "cancelContentEditingInputRequest:")
    public native void cancelContentEditingInputRequest(@MachineSizedUInt long requestID);
    /*</methods>*/
}
