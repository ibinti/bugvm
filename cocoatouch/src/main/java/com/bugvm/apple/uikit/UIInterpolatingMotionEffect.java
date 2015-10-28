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

import com.bugvm.apple.foundation.NSCoder;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.apple.foundation.NSValue;
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
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIInterpolatingMotionEffect/*</name>*/ 
    extends /*<extends>*/UIMotionEffect/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIInterpolatingMotionEffectPtr extends Ptr<UIInterpolatingMotionEffect, UIInterpolatingMotionEffectPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIInterpolatingMotionEffect.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIInterpolatingMotionEffect() {}
    protected UIInterpolatingMotionEffect(NSObject.SkipInit skipInit) { super(skipInit); }
    public UIInterpolatingMotionEffect(String keyPath, UIInterpolatingMotionEffectType type) { super((NSObject.SkipInit) null); initObject(init(keyPath, type)); }
    public UIInterpolatingMotionEffect(NSCoder aDecoder) { super((NSObject.SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "keyPath")
    public native String getKeyPath();
    @Property(selector = "type")
    public native UIInterpolatingMotionEffectType getType();
    @Property(selector = "minimumRelativeValue")
    public native NSValue getMinimumRelativeValue();
    @Property(selector = "setMinimumRelativeValue:")
    public native void setMinimumRelativeValue(NSValue v);
    @Property(selector = "maximumRelativeValue")
    public native NSValue getMaximumRelativeValue();
    @Property(selector = "setMaximumRelativeValue:")
    public native void setMaximumRelativeValue(NSValue v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithKeyPath:type:")
    protected native @Pointer long init(String keyPath, UIInterpolatingMotionEffectType type);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
