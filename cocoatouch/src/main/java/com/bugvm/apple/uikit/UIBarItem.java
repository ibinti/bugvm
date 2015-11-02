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
import com.bugvm.apple.corefoundation.CFDictionary;
import com.bugvm.apple.coremedia.CMTextMarkupAttributes;

/*<javadoc>*/
/**
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIBarItem/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements UIAppearanceContainer/*</implements>*/ {

    /*<ptr>*/public static class UIBarItemPtr extends Ptr<UIBarItem, UIBarItemPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIBarItem.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIBarItem() {}
    protected UIBarItem(SkipInit skipInit) { super(skipInit); }
    public UIBarItem(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isEnabled")
    public native boolean isEnabled();
    @Property(selector = "setEnabled:")
    public native void setEnabled(boolean v);
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "setTitle:")
    public native void setTitle(String v);
    @Property(selector = "image")
    public native UIImage getImage();
    @Property(selector = "setImage:")
    public native void setImage(UIImage v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "landscapeImagePhone")
    public native UIImage getLandscapeImagePhone();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setLandscapeImagePhone:")
    public native void setLandscapeImagePhone(UIImage v);
    @Property(selector = "imageInsets")
    public native @ByVal UIEdgeInsets getImageInsets();
    @Property(selector = "setImageInsets:")
    public native void setImageInsets(@ByVal UIEdgeInsets v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "landscapeImagePhoneInsets")
    public native @ByVal UIEdgeInsets getLandscapeImagePhoneInsets();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setLandscapeImagePhoneInsets:")
    public native void setLandscapeImagePhoneInsets(@ByVal UIEdgeInsets v);
    @Property(selector = "tag")
    public native @MachineSizedSInt long getTag();
    @Property(selector = "setTag:")
    public native void setTag(@MachineSizedSInt long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    public void setTitleTextAttributes(NSAttributedStringAttributes attributes, UIControlState state) {
        if (attributes == null) {
            setTitleTextAttributesDictionary(null, state);
        } else {
            setTitleTextAttributesDictionary(attributes.getDictionary(), state);
        }
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public void setTitleTextMarkupAttributes(CMTextMarkupAttributes attributes, UIControlState state) {
        if (attributes == null) {
            setTitleTextAttributesDictionary(null, state);
        } else {
            setTitleTextAttributesDictionary(attributes.getDictionary().as(NSDictionary.class), state);
        }
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public void setTitleCoreTextAttributes(CTAttributedStringAttributes attributes, UIControlState state) {
        if (attributes == null) {
            setTitleTextAttributesDictionary(null, state);
        } else {
            setTitleTextAttributesDictionary(attributes.getDictionary().as(NSDictionary.class), state);
        }
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public NSAttributedStringAttributes getTitleTextAttributes(UIControlState state) {
        NSDictionary dict = getTitleTextAttributesDictionary(state);
        if (dict == null) return null;
        return new NSAttributedStringAttributes(dict);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public CMTextMarkupAttributes getTitleTextMarkupAttributes(UIControlState state) {
        NSDictionary dict = getTitleTextAttributesDictionary(state);
        if (dict == null) return null;
        return new CMTextMarkupAttributes(dict.as(CFDictionary.class));
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public CTAttributedStringAttributes getTitleCoreTextAttributes(UIControlState state) {
        NSDictionary dict = getTitleTextAttributesDictionary(state);
        if (dict == null) return null;
        return new CTAttributedStringAttributes(dict.as(CFDictionary.class));
    }
    /*<methods>*/
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setTitleTextAttributes:forState:")
    public native void setTitleTextAttributesDictionary(NSDictionary<NSString, ?> attributes, UIControlState state);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "titleTextAttributesForState:")
    public native NSDictionary<NSString, ?> getTitleTextAttributesDictionary(UIControlState state);
    /*</methods>*/
}
