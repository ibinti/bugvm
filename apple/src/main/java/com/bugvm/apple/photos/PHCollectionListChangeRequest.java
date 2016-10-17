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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHCollectionListChangeRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHCollectionListChangeRequestPtr extends Ptr<PHCollectionListChangeRequest, PHCollectionListChangeRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHCollectionListChangeRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHCollectionListChangeRequest() {}
    protected PHCollectionListChangeRequest(SkipInit skipInit) { super(skipInit); }
    public PHCollectionListChangeRequest(PHCollectionList collectionList) { super(create(collectionList)); retain(getHandle()); }
    public PHCollectionListChangeRequest(PHCollectionList collectionList, PHFetchResult childCollections) { super(create(collectionList, childCollections)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "placeholderForCreatedCollectionList")
    public native PHObjectPlaceholder getPlaceholderForCreatedCollectionList();
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "setTitle:")
    public native void setTitle(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "addChildCollections:")
    public native void addChildCollections(NSFastEnumeration collections);
    @Method(selector = "insertChildCollections:atIndexes:")
    public native void insertChildCollections(NSFastEnumeration collections, NSIndexSet indexes);
    @Method(selector = "removeChildCollections:")
    public native void removeChildCollections(NSFastEnumeration collections);
    @Method(selector = "removeChildCollectionsAtIndexes:")
    public native void removeChildCollections(NSIndexSet indexes);
    @Method(selector = "replaceChildCollectionsAtIndexes:withChildCollections:")
    public native void replaceChildCollections(NSIndexSet indexes, NSFastEnumeration collections);
    @Method(selector = "moveChildCollectionsAtIndexes:toIndex:")
    public native void moveChildCollectionsTo(NSIndexSet indexes, @MachineSizedUInt long toIndex);
    @Method(selector = "creationRequestForCollectionListWithTitle:")
    public static native PHCollectionListChangeRequest createCollectionListCreationRequest(String title);
    @Method(selector = "deleteCollectionLists:")
    public static native void deleteCollectionLists(NSFastEnumeration collectionLists);
    @Method(selector = "changeRequestForCollectionList:")
    protected static native @Pointer long create(PHCollectionList collectionList);
    @Method(selector = "changeRequestForCollectionList:childCollections:")
    protected static native @Pointer long create(PHCollectionList collectionList, PHFetchResult childCollections);
    /*</methods>*/
}
