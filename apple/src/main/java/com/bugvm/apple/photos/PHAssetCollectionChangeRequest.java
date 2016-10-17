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

/*</javadoc>*/
/*<annotations>*/@Library("Photos") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHAssetCollectionChangeRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHAssetCollectionChangeRequestPtr extends Ptr<PHAssetCollectionChangeRequest, PHAssetCollectionChangeRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHAssetCollectionChangeRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHAssetCollectionChangeRequest() {}
    protected PHAssetCollectionChangeRequest(SkipInit skipInit) { super(skipInit); }
    public PHAssetCollectionChangeRequest(PHAssetCollection assetCollection) { super(create(assetCollection)); retain(getHandle()); }
    public PHAssetCollectionChangeRequest(PHAssetCollection assetCollection, PHFetchResult<PHAsset> assets) { super(create(assetCollection, assets)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "placeholderForCreatedAssetCollection")
    public native PHObjectPlaceholder getPlaceholderForCreatedAssetCollection();
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "setTitle:")
    public native void setTitle(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "addAssets:")
    public native void addAssets(NSFastEnumeration assets);
    @Method(selector = "insertAssets:atIndexes:")
    public native void insertAssets(NSFastEnumeration assets, NSIndexSet indexes);
    @Method(selector = "removeAssets:")
    public native void removeAssets(NSFastEnumeration assets);
    @Method(selector = "removeAssetsAtIndexes:")
    public native void removeAssets(NSIndexSet indexes);
    @Method(selector = "replaceAssetsAtIndexes:withAssets:")
    public native void replaceAssets(NSIndexSet indexes, NSFastEnumeration assets);
    @Method(selector = "moveAssetsAtIndexes:toIndex:")
    public native void moveAssetsTo(NSIndexSet fromIndexes, @MachineSizedUInt long toIndex);
    @Method(selector = "creationRequestForAssetCollectionWithTitle:")
    public static native PHAssetCollectionChangeRequest createAssetCollectionCreationRequest(String title);
    @Method(selector = "deleteAssetCollections:")
    public static native void deleteAssetCollections(NSFastEnumeration assetCollections);
    @Method(selector = "changeRequestForAssetCollection:")
    protected static native @Pointer long create(PHAssetCollection assetCollection);
    @Method(selector = "changeRequestForAssetCollection:assets:")
    protected static native @Pointer long create(PHAssetCollection assetCollection, PHFetchResult<PHAsset> assets);
    /*</methods>*/
}
