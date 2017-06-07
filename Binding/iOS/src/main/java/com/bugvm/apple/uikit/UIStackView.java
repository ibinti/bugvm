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
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIStackView/*</name>*/ 
    extends /*<extends>*/UIView/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIStackViewPtr extends Ptr<UIStackView, UIStackViewPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIStackView.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIStackView() {}
    protected UIStackView(SkipInit skipInit) { super(skipInit); }
    public UIStackView(NSArray<UIView> views) { super((SkipInit) null); initObject(init(views)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "arrangedSubviews")
    public native NSArray<UIView> getArrangedSubviews();
    @Property(selector = "axis")
    public native UILayoutConstraintAxis getAxis();
    @Property(selector = "setAxis:")
    public native void setAxis(UILayoutConstraintAxis v);
    @Property(selector = "distribution")
    public native UIStackViewDistribution getDistribution();
    @Property(selector = "setDistribution:")
    public native void setDistribution(UIStackViewDistribution v);
    @Property(selector = "alignment")
    public native UIStackViewAlignment getAlignment();
    @Property(selector = "setAlignment:")
    public native void setAlignment(UIStackViewAlignment v);
    @Property(selector = "spacing")
    public native @MachineSizedFloat double getSpacing();
    @Property(selector = "setSpacing:")
    public native void setSpacing(@MachineSizedFloat double v);
    @Property(selector = "isBaselineRelativeArrangement")
    public native boolean isBaselineRelativeArrangement();
    @Property(selector = "setBaselineRelativeArrangement:")
    public native void setBaselineRelativeArrangement(boolean v);
    @Property(selector = "isLayoutMarginsRelativeArrangement")
    public native boolean isLayoutMarginsRelativeArrangement();
    @Property(selector = "setLayoutMarginsRelativeArrangement:")
    public native void setLayoutMarginsRelativeArrangement(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithArrangedSubviews:")
    protected native @Pointer long init(NSArray<UIView> views);
    @Method(selector = "addArrangedSubview:")
    public native void addArrangedSubview(UIView view);
    @Method(selector = "removeArrangedSubview:")
    public native void removeArrangedSubview(UIView view);
    @Method(selector = "insertArrangedSubview:atIndex:")
    public native void insertArrangedSubview(UIView view, @MachineSizedUInt long stackIndex);
    /*</methods>*/
}
