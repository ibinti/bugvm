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
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIPopoverBackgroundView/*</name>*/ 
    extends /*<extends>*/UIView/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIPopoverBackgroundViewPtr extends Ptr<UIPopoverBackgroundView, UIPopoverBackgroundViewPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIPopoverBackgroundView.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIPopoverBackgroundView() {}
    protected UIPopoverBackgroundView(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    
    public UIPopoverBackgroundView(CGRect frame) {
        super(frame);
    }
    
    /*<properties>*/
    @Property(selector = "arrowOffset")
    public native @MachineSizedFloat double getArrowOffset();
    @Property(selector = "setArrowOffset:")
    public native void setArrowOffset(@MachineSizedFloat double v);
    @Property(selector = "arrowDirection")
    public native UIPopoverArrowDirection getArrowDirection();
    @Property(selector = "setArrowDirection:")
    public native void setArrowDirection(UIPopoverArrowDirection v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "wantsDefaultContentAppearance")
    public static native boolean wantsDefaultContentAppearance();
    /*</methods>*/
}
