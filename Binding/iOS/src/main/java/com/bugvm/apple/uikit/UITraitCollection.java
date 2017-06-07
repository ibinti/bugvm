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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITraitCollection/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UITraitCollectionPtr extends Ptr<UITraitCollection, UITraitCollectionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UITraitCollection.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UITraitCollection() {}
    protected UITraitCollection(SkipInit skipInit) { super(skipInit); }
    public UITraitCollection(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "userInterfaceIdiom")
    public native UIUserInterfaceIdiom getUserInterfaceIdiom();
    @Property(selector = "displayScale")
    public native @MachineSizedFloat double getDisplayScale();
    @Property(selector = "horizontalSizeClass")
    public native UIUserInterfaceSizeClass getHorizontalSizeClass();
    @Property(selector = "verticalSizeClass")
    public native UIUserInterfaceSizeClass getVerticalSizeClass();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "containsTraitsInCollection:")
    public native boolean containsTraits(UITraitCollection trait);
    @Method(selector = "traitCollectionWithTraitsFromCollections:")
    public static native UITraitCollection createWithTraits(NSArray<UITraitCollection> traitCollections);
    @Method(selector = "traitCollectionWithUserInterfaceIdiom:")
    public static native UITraitCollection createWithUserInterfaceIdiom(UIUserInterfaceIdiom idiom);
    @Method(selector = "traitCollectionWithDisplayScale:")
    public static native UITraitCollection createWithDisplayScale(@MachineSizedFloat double scale);
    @Method(selector = "traitCollectionWithHorizontalSizeClass:")
    public static native UITraitCollection createWithHorizontalSizeClass(UIUserInterfaceSizeClass horizontalSizeClass);
    @Method(selector = "traitCollectionWithVerticalSizeClass:")
    public static native UITraitCollection createWithVerticalSizeClass(UIUserInterfaceSizeClass verticalSizeClass);
    /*</methods>*/
}
