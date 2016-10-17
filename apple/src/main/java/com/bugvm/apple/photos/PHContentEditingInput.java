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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHContentEditingInput/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHContentEditingInputPtr extends Ptr<PHContentEditingInput, PHContentEditingInputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHContentEditingInput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHContentEditingInput() {}
    protected PHContentEditingInput(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "mediaType")
    public native PHAssetMediaType getMediaType();
    @Property(selector = "mediaSubtypes")
    public native PHAssetMediaSubtype getMediaSubtypes();
    @Property(selector = "creationDate")
    public native NSDate getCreationDate();
    @WeaklyLinked
    @Property(selector = "location")
    public native CLLocation getLocation();
    @Property(selector = "uniformTypeIdentifier")
    public native String getUniformTypeIdentifier();
    @Property(selector = "adjustmentData")
    public native PHAdjustmentData getAdjustmentData();
    @WeaklyLinked
    @Property(selector = "displaySizeImage")
    public native UIImage getDisplaySizeImage();
    @Property(selector = "fullSizeImageURL")
    public native NSURL getFullSizeImageURL();
    @WeaklyLinked
    @Property(selector = "fullSizeImageOrientation")
    public native com.bugvm.apple.imageio.CGImagePropertyOrientation getFullSizeImageOrientation();
    /**
     * @since Available in iOS 8.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @WeaklyLinked
    @Property(selector = "avAsset")
    public native AVAsset getAvAsset();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "audiovisualAsset")
    public native AVAsset getAudiovisualAsset();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
