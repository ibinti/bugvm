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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIActivityIndicatorView/*</name>*/ 
    extends /*<extends>*/UIView/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class UIActivityIndicatorViewPtr extends Ptr<UIActivityIndicatorView, UIActivityIndicatorViewPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIActivityIndicatorView.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIActivityIndicatorView() {}
    protected UIActivityIndicatorView(SkipInit skipInit) { super(skipInit); }
    public UIActivityIndicatorView(UIActivityIndicatorViewStyle style) { super((SkipInit) null); initObject(init(style)); }
    public UIActivityIndicatorView(@ByVal CGRect frame) { super((SkipInit) null); initObject(init(frame)); }
    public UIActivityIndicatorView(NSCoder coder) { super((SkipInit) null); initObject(init(coder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "activityIndicatorViewStyle")
    public native UIActivityIndicatorViewStyle getActivityIndicatorViewStyle();
    @Property(selector = "setActivityIndicatorViewStyle:")
    public native void setActivityIndicatorViewStyle(UIActivityIndicatorViewStyle v);
    @Property(selector = "hidesWhenStopped")
    public native boolean hidesWhenStopped();
    @Property(selector = "setHidesWhenStopped:")
    public native void setHidesWhenStopped(boolean v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "color")
    public native UIColor getColor();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setColor:")
    public native void setColor(UIColor v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithActivityIndicatorStyle:")
    protected native @Pointer long init(UIActivityIndicatorViewStyle style);
    @Method(selector = "initWithFrame:")
    protected native @Pointer long init(@ByVal CGRect frame);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder coder);
    @Method(selector = "startAnimating")
    public native void startAnimating();
    @Method(selector = "stopAnimating")
    public native void stopAnimating();
    @Method(selector = "isAnimating")
    public native boolean isAnimating();
    /*</methods>*/
}
