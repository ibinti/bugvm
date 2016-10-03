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
package com.bugvm.ios.AVFoundation;

/*<imports>*/
import java.util.*;

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMediaSelectionOption/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVMediaSelectionOptionPtr extends Ptr<AVMediaSelectionOption, AVMediaSelectionOptionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVMediaSelectionOption.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVMediaSelectionOption() {}
    protected AVMediaSelectionOption(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "mediaType")
    public native AVMediaType getMediaType();
    @Property(selector = "mediaSubTypes")
    public native NSArray<NSNumber> getMediaSubTypes();
    @Property(selector = "isPlayable")
    public native boolean isPlayable();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "extendedLanguageTag")
    public native String getExtendedLanguageTag();
    @Property(selector = "locale")
    public native NSLocale getLocale();
    @Property(selector = "commonMetadata")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getCommonMetadata();
    @Property(selector = "availableMetadataFormats")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVMetadataFormat.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVMetadataFormat> getAvailableMetadataFormats();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "displayName")
    public native String getDisplayName();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "hasMediaCharacteristic:")
    public native boolean hasMediaCharacteristic(com.bugvm.ios.AVFoundation.AVMediaCharacteristic mediaCharacteristic);
    @Method(selector = "metadataForFormat:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getMetadata(com.bugvm.ios.AVFoundation.AVMetadataFormat format);
    @Method(selector = "associatedMediaSelectionOptionInMediaSelectionGroup:")
    public native AVMediaSelectionOption getAssociatedMediaSelectionOption(com.bugvm.ios.AVFoundation.AVMediaSelectionGroup mediaSelectionGroup);
    @Method(selector = "propertyList")
    public native NSPropertyList getPropertyList();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "displayNameWithLocale:")
    public native String getDisplayName(NSLocale locale);
    /*</methods>*/
}
