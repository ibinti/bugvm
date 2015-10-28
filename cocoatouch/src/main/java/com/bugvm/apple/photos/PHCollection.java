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

import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Photos") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHCollection/*</name>*/ 
    extends /*<extends>*/PHObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHCollectionPtr extends Ptr<PHCollection, PHCollectionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHCollection.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHCollection() {}
    protected PHCollection(long handle) { super(handle); }
    protected PHCollection(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "canContainAssets")
    public native boolean canContainAssets();
    @Property(selector = "canContainCollections")
    public native boolean canContainCollections();
    @Property(selector = "localizedTitle")
    public native String getLocalizedTitle();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "canPerformEditOperation:")
    public native boolean canPerformEditOperation(PHCollectionEditOperation anOperation);
    @Method(selector = "fetchCollectionsInCollectionList:options:")
    public static native PHFetchResult<PHCollection> fetchCollectionsInCollectionList(PHCollectionList collectionList, PHFetchOptions options);
    @Method(selector = "fetchTopLevelUserCollectionsWithOptions:")
    public static native PHFetchResult<PHCollection> fetchTopLevelUserCollections(PHFetchOptions options);
    /*</methods>*/
}
