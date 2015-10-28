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

import com.bugvm.apple.coregraphics.CGAffineTransform;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.annotation.NotImplemented;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIViewControllerTransitionCoordinatorContextAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*/implements UIViewControllerTransitionCoordinatorContext/*</implements>*/ {

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
    @NotImplemented("isAnimated")
    public boolean isAnimated() { return false; }
    @NotImplemented("presentationStyle")
    public UIModalPresentationStyle getPresentationStyle() { return null; }
    @NotImplemented("initiallyInteractive")
    public boolean isInitiallyInteractive() { return false; }
    @NotImplemented("isInteractive")
    public boolean isInteractive() { return false; }
    @NotImplemented("isCancelled")
    public boolean isCancelled() { return false; }
    @NotImplemented("transitionDuration")
    public double getTransitionDuration() { return 0; }
    @NotImplemented("percentComplete")
    public @MachineSizedFloat double getPercentComplete() { return 0; }
    @NotImplemented("completionVelocity")
    public @MachineSizedFloat double getCompletionVelocity() { return 0; }
    @NotImplemented("completionCurve")
    public UIViewAnimationCurve getCompletionCurve() { return null; }
    @NotImplemented("viewControllerForKey:")
    public UIViewController getViewController(String key) { return null; }
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("viewForKey:")
    public UIView getView(String key) { return null; }
    @NotImplemented("containerView")
    public UIView getContainerView() { return null; }
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("targetTransform")
    public @ByVal
    CGAffineTransform getTargetTransform() { return null; }
    /*</methods>*/
}