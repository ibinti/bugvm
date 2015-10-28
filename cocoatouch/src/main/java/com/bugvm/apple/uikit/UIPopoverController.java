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

import com.bugvm.apple.coregraphics.CGRect;
import com.bugvm.apple.coregraphics.CGSize;
import com.bugvm.apple.foundation.NSArray;
import com.bugvm.apple.foundation.NSObject;
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
 * @since Available in iOS 3.2 and later.
 * @deprecated Deprecated in iOS 9.0.
 */
@Deprecated
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIPopoverController/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*/implements UIAppearanceContainer/*</implements>*/ {

    /*<ptr>*/public static class UIPopoverControllerPtr extends Ptr<UIPopoverController, UIPopoverControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIPopoverController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIPopoverController() {}
    protected UIPopoverController(SkipInit skipInit) { super(skipInit); }
    public UIPopoverController(UIViewController viewController) { super((SkipInit) null); initObject(init(viewController)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native UIPopoverControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(UIPopoverControllerDelegate v);
    @Property(selector = "contentViewController")
    public native UIViewController getContentViewController();
    @Property(selector = "setContentViewController:")
    public native void setContentViewController(UIViewController v);
    @Property(selector = "popoverContentSize")
    public native @ByVal
    CGSize getPopoverContentSize();
    @Property(selector = "setPopoverContentSize:")
    public native void setPopoverContentSize(@ByVal CGSize v);
    @Property(selector = "isPopoverVisible")
    public native boolean isPopoverVisible();
    @Property(selector = "popoverArrowDirection")
    public native UIPopoverArrowDirection getPopoverArrowDirection();
    @Property(selector = "passthroughViews")
    public native NSArray<UIView> getPassthroughViews();
    @Property(selector = "setPassthroughViews:")
    public native void setPassthroughViews(NSArray<UIView> v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "backgroundColor")
    public native UIColor getBackgroundColor();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setBackgroundColor:")
    public native void setBackgroundColor(UIColor v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "popoverLayoutMargins")
    public native @ByVal UIEdgeInsets getPopoverLayoutMargins();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setPopoverLayoutMargins:")
    public native void setPopoverLayoutMargins(@ByVal UIEdgeInsets v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "popoverBackgroundViewClass")
    public native Class<? extends UIPopoverBackgroundView> getPopoverBackgroundViewClass();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setPopoverBackgroundViewClass:")
    public native void setPopoverBackgroundViewClass(Class<? extends UIPopoverBackgroundView> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithContentViewController:")
    protected native @Pointer long init(UIViewController viewController);
    @Method(selector = "setContentViewController:animated:")
    public native void setContentViewController(UIViewController viewController, boolean animated);
    @Method(selector = "setPopoverContentSize:animated:")
    public native void setPopoverContentSize(@ByVal CGSize size, boolean animated);
    @Method(selector = "presentPopoverFromRect:inView:permittedArrowDirections:animated:")
    public native void presentFromRectInView(@ByVal CGRect rect, UIView view, UIPopoverArrowDirection arrowDirections, boolean animated);
    @Method(selector = "presentPopoverFromBarButtonItem:permittedArrowDirections:animated:")
    public native void presentFromBarButtonItem(UIBarButtonItem item, UIPopoverArrowDirection arrowDirections, boolean animated);
    @Method(selector = "dismissPopoverAnimated:")
    public native void dismiss(boolean animated);
    /*</methods>*/
}
