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
import com.bugvm.apple.foundation.NSCoder;
import com.bugvm.apple.foundation.NSCoding;
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
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UILayoutGuide/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class UILayoutGuidePtr extends Ptr<UILayoutGuide, UILayoutGuidePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UILayoutGuide.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UILayoutGuide() {}
    protected UILayoutGuide(SkipInit skipInit) { super(skipInit); }
    public UILayoutGuide(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "layoutFrame")
    public native @ByVal
    CGRect getLayoutFrame();
    @Property(selector = "owningView")
    public native UIView getOwningView();
    @Property(selector = "setOwningView:", strongRef = true)
    public native void setOwningView(UIView v);
    @Property(selector = "identifier")
    public native String getIdentifier();
    @Property(selector = "setIdentifier:")
    public native void setIdentifier(String v);
    @Property(selector = "leadingAnchor")
    public native NSLayoutXAxisAnchor getLeadingAnchor();
    @Property(selector = "trailingAnchor")
    public native NSLayoutXAxisAnchor getTrailingAnchor();
    @Property(selector = "leftAnchor")
    public native NSLayoutXAxisAnchor getLeftAnchor();
    @Property(selector = "rightAnchor")
    public native NSLayoutXAxisAnchor getRightAnchor();
    @Property(selector = "topAnchor")
    public native NSLayoutYAxisAnchor getTopAnchor();
    @Property(selector = "bottomAnchor")
    public native NSLayoutYAxisAnchor getBottomAnchor();
    @Property(selector = "widthAnchor")
    public native NSLayoutDimension getWidthAnchor();
    @Property(selector = "heightAnchor")
    public native NSLayoutDimension getHeightAnchor();
    @Property(selector = "centerXAnchor")
    public native NSLayoutXAxisAnchor getCenterXAnchor();
    @Property(selector = "centerYAnchor")
    public native NSLayoutYAxisAnchor getCenterYAnchor();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
