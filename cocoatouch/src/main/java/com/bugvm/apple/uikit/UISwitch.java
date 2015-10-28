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
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UISwitch/*</name>*/ 
    extends /*<extends>*/UIControl/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class UISwitchPtr extends Ptr<UISwitch, UISwitchPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UISwitch.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UISwitch() {}
    protected UISwitch(NSObject.SkipInit skipInit) { super(skipInit); }
    public UISwitch(@ByVal CGRect frame) { super((NSObject.SkipInit) null); initObject(init(frame)); }
    public UISwitch(NSCoder aDecoder) { super((NSObject.SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "onTintColor")
    public native UIColor getOnTintColor();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setOnTintColor:")
    public native void setOnTintColor(UIColor v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "tintColor")
    public native UIColor getTintColor();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setTintColor:")
    public native void setTintColor(UIColor v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "thumbTintColor")
    public native UIColor getThumbTintColor();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setThumbTintColor:")
    public native void setThumbTintColor(UIColor v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "onImage")
    public native UIImage getOnImage();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setOnImage:")
    public native void setOnImage(UIImage v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "offImage")
    public native UIImage getOffImage();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setOffImage:")
    public native void setOffImage(UIImage v);
    @Property(selector = "isOn")
    public native boolean isOn();
    @Property(selector = "setOn:")
    public native void setOn(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithFrame:")
    protected native @Pointer long init(@ByVal CGRect frame);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "setOn:animated:")
    public native void setOn(boolean on, boolean animated);
    /*</methods>*/
}
