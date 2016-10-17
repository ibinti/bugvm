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
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITabBarController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*/implements UITabBarDelegate, NSCoding/*</implements>*/ {

    /*<ptr>*/public static class UITabBarControllerPtr extends Ptr<UITabBarController, UITabBarControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UITabBarController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UITabBarController() {}
    protected UITabBarController(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "viewControllers")
    public native NSArray<UIViewController> getViewControllers();
    @Property(selector = "setViewControllers:")
    public native void setViewControllers(NSArray<UIViewController> v);
    @Property(selector = "selectedViewController")
    public native UIViewController getSelectedViewController();
    @Property(selector = "setSelectedViewController:", strongRef = true)
    public native void setSelectedViewController(UIViewController v);
    @Property(selector = "selectedIndex")
    public native @MachineSizedUInt long getSelectedIndex();
    @Property(selector = "setSelectedIndex:")
    public native void setSelectedIndex(@MachineSizedUInt long v);
    @Property(selector = "moreNavigationController")
    public native UINavigationController getMoreNavigationController();
    @Property(selector = "customizableViewControllers")
    public native NSArray<UIViewController> getCustomizableViewControllers();
    @Property(selector = "setCustomizableViewControllers:")
    public native void setCustomizableViewControllers(NSArray<UIViewController> v);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "tabBar")
    public native UITabBar getTabBar();
    @Property(selector = "delegate")
    public native UITabBarControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(UITabBarControllerDelegate v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "setViewControllers:animated:")
    public native void setViewControllers(NSArray<UIViewController> viewControllers, boolean animated);
    @Method(selector = "tabBar:didSelectItem:")
    public native void didSelectItem(UITabBar tabBar, UITabBarItem item);
    @Method(selector = "tabBar:willBeginCustomizingItems:")
    public native void willBeginCustomizingItems(UITabBar tabBar, NSArray<UITabBarItem> items);
    @Method(selector = "tabBar:didBeginCustomizingItems:")
    public native void didBeginCustomizingItems(UITabBar tabBar, NSArray<UITabBarItem> items);
    @Method(selector = "tabBar:willEndCustomizingItems:changed:")
    public native void willEndCustomizingItems(UITabBar tabBar, NSArray<UITabBarItem> items, boolean changed);
    @Method(selector = "tabBar:didEndCustomizingItems:changed:")
    public native void didEndCustomizingItems(UITabBar tabBar, NSArray<UITabBarItem> items, boolean changed);
    /*</methods>*/
}
