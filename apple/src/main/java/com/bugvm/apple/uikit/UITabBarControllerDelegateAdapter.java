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
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITabBarControllerDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements UITabBarControllerDelegate/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @NotImplemented("tabBarController:shouldSelectViewController:")
    public boolean shouldSelectViewController(UITabBarController tabBarController, UIViewController viewController) { return false; }
    @NotImplemented("tabBarController:didSelectViewController:")
    public void didSelectViewController(UITabBarController tabBarController, UIViewController viewController) {}
    /**
     * @since Available in iOS 3.0 and later.
     */
    @NotImplemented("tabBarController:willBeginCustomizingViewControllers:")
    public void willBeginCustomizingViewControllers(UITabBarController tabBarController, NSArray<UIViewController> viewControllers) {}
    /**
     * @since Available in iOS 3.0 and later.
     */
    @NotImplemented("tabBarController:willEndCustomizingViewControllers:changed:")
    public void willEndCustomizingViewControllers(UITabBarController tabBarController, NSArray<UIViewController> viewControllers, boolean changed) {}
    @NotImplemented("tabBarController:didEndCustomizingViewControllers:changed:")
    public void didEndCustomizingViewControllers(UITabBarController tabBarController, NSArray<UIViewController> viewControllers, boolean changed) {}
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("tabBarControllerSupportedInterfaceOrientations:")
    public UIInterfaceOrientation getSupportedInterfaceOrientations(UITabBarController tabBarController) { return null; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("tabBarControllerPreferredInterfaceOrientationForPresentation:")
    public UIInterfaceOrientation getPreferredInterfaceOrientation(UITabBarController tabBarController) { return null; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("tabBarController:interactionControllerForAnimationController:")
    public UIViewControllerInteractiveTransitioning getInteractionController(UITabBarController tabBarController, UIViewControllerAnimatedTransitioning animationController) { return null; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("tabBarController:animationControllerForTransitionFromViewController:toViewController:")
    public UIViewControllerAnimatedTransitioning getAnimationController(UITabBarController tabBarController, UIViewController fromVC, UIViewController toVC) { return null; }
    /*</methods>*/
}
