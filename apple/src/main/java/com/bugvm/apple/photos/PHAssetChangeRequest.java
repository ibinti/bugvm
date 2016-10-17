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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHAssetChangeRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHAssetChangeRequestPtr extends Ptr<PHAssetChangeRequest, PHAssetChangeRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHAssetChangeRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHAssetChangeRequest() {}
    protected PHAssetChangeRequest(long handle) { super(handle); }
    protected PHAssetChangeRequest(SkipInit skipInit) { super(skipInit); }
    public PHAssetChangeRequest(PHAsset asset) { super(create(asset)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "placeholderForCreatedAsset")
    public native PHObjectPlaceholder getPlaceholderForCreatedAsset();
    @Property(selector = "creationDate")
    public native NSDate getCreationDate();
    @Property(selector = "setCreationDate:")
    public native void setCreationDate(NSDate v);
    @WeaklyLinked
    @Property(selector = "location")
    public native CLLocation getLocation();
    @WeaklyLinked
    @Property(selector = "setLocation:")
    public native void setLocation(CLLocation v);
    @Property(selector = "isFavorite")
    public native boolean isFavorite();
    @Property(selector = "setFavorite:")
    public native void setFavorite(boolean v);
    @Property(selector = "isHidden")
    public native boolean isHidden();
    @Property(selector = "setHidden:")
    public native void setHidden(boolean v);
    @Property(selector = "contentEditingOutput")
    public native PHContentEditingOutput getContentEditingOutput();
    @Property(selector = "setContentEditingOutput:")
    public native void setContentEditingOutput(PHContentEditingOutput v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "revertAssetContentToOriginal")
    public native void revertAssetContentToOriginal();
    @WeaklyLinked
    @Method(selector = "creationRequestForAssetFromImage:")
    public static native PHAssetChangeRequest createImageAssetCreationRequest(UIImage image);
    @Method(selector = "creationRequestForAssetFromImageAtFileURL:")
    public static native PHAssetChangeRequest createImageAssetCreationRequest(NSURL fileURL);
    @Method(selector = "creationRequestForAssetFromVideoAtFileURL:")
    public static native PHAssetChangeRequest createVideoAssetCreationRequest(NSURL fileURL);
    @Method(selector = "deleteAssets:")
    public static native void deleteAssets(NSFastEnumeration assets);
    @Method(selector = "changeRequestForAsset:")
    protected static native @Pointer long create(PHAsset asset);
    /*</methods>*/
}
