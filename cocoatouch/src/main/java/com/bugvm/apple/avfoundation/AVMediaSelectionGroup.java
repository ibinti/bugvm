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
package com.bugvm.apple.avfoundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.mediatoolbox.*;
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.audiounit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMediaSelectionGroup/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVMediaSelectionGroupPtr extends Ptr<AVMediaSelectionGroup, AVMediaSelectionGroupPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVMediaSelectionGroup.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVMediaSelectionGroup() {}
    protected AVMediaSelectionGroup(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "options")
    public native NSArray<AVMediaSelectionOption> getOptions();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "defaultOption")
    public native AVMediaSelectionOption getDefaultOption();
    @Property(selector = "allowsEmptySelection")
    public native boolean allowsEmptySelection();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "mediaSelectionOptionWithPropertyList:")
    public native AVMediaSelectionOption getMediaSelectionOption(NSPropertyList plist);
    @Method(selector = "playableMediaSelectionOptionsFromArray:")
    public static native NSArray<AVMediaSelectionOption> filterPlayableMediaSelectionOptions(NSArray<AVMediaSelectionOption> mediaSelectionOptions);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "mediaSelectionOptionsFromArray:filteredAndSortedAccordingToPreferredLanguages:")
    public static native NSArray<AVMediaSelectionOption> filterMediaSelectionOptionsByPreferredLanguages(NSArray<AVMediaSelectionOption> mediaSelectionOptions, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> preferredLanguages);
    @Method(selector = "mediaSelectionOptionsFromArray:withLocale:")
    public static native NSArray<AVMediaSelectionOption> filterMediaSelectionOptionsByLocale(NSArray<AVMediaSelectionOption> mediaSelectionOptions, NSLocale locale);
    @Method(selector = "mediaSelectionOptionsFromArray:withMediaCharacteristics:")
    public static native NSArray<AVMediaSelectionOption> filterMediaSelectionOptionsWithMediaCharacteristics(NSArray<AVMediaSelectionOption> mediaSelectionOptions, @com.bugvm.rt.bro.annotation.Marshaler(AVMediaCharacteristic.AsListMarshaler.class) List<AVMediaCharacteristic> mediaCharacteristics);
    @Method(selector = "mediaSelectionOptionsFromArray:withoutMediaCharacteristics:")
    public static native NSArray<AVMediaSelectionOption> filterMediaSelectionOptionsWithoutMediaCharacteristics(NSArray<AVMediaSelectionOption> mediaSelectionOptions, @com.bugvm.rt.bro.annotation.Marshaler(AVMediaCharacteristic.AsListMarshaler.class) List<AVMediaCharacteristic> mediaCharacteristics);
    /*</methods>*/
}
