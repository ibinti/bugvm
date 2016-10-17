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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UILocalizedIndexedCollation/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UILocalizedIndexedCollationPtr extends Ptr<UILocalizedIndexedCollation, UILocalizedIndexedCollationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UILocalizedIndexedCollation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UILocalizedIndexedCollation() {}
    protected UILocalizedIndexedCollation(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "sectionTitles")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getSectionTitles();
    @Property(selector = "sectionIndexTitles")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getSectionIndexTitles();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "sectionForSectionIndexTitleAtIndex:")
    public native @MachineSizedSInt long getSection(@MachineSizedSInt long indexTitleIndex);
    @Method(selector = "sectionForObject:collationStringSelector:")
    public native @MachineSizedSInt long getSection(NSObject object, Selector selector);
    @Method(selector = "sortedArrayFromArray:collationStringSelector:")
    public native NSArray<?> sortArray(NSArray<?> array, Selector selector);
    @Method(selector = "currentCollation")
    public static native UILocalizedIndexedCollation getCurrentCollation();
    /*</methods>*/
}
