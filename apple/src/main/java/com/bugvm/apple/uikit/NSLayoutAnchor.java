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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSLayoutAnchor/*</name>*/ <T extends NSLayoutAnchor<?>>
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSLayoutAnchorPtr extends Ptr<NSLayoutAnchor, NSLayoutAnchorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSLayoutAnchor.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSLayoutAnchor() {}
    protected NSLayoutAnchor(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "constraintEqualToAnchor:")
    public native NSLayoutConstraint equalTo(NSLayoutAnchor<T> anchor);
    @Method(selector = "constraintGreaterThanOrEqualToAnchor:")
    public native NSLayoutConstraint greaterThanOrEqual(NSLayoutAnchor<T> anchor);
    @Method(selector = "constraintLessThanOrEqualToAnchor:")
    public native NSLayoutConstraint lessThanOrEqual(NSLayoutAnchor<T> anchor);
    @Method(selector = "constraintEqualToAnchor:constant:")
    public native NSLayoutConstraint equalTo(NSLayoutAnchor<T> anchor, @MachineSizedFloat double c);
    @Method(selector = "constraintGreaterThanOrEqualToAnchor:constant:")
    public native NSLayoutConstraint greaterThanOrEqualTo(NSLayoutAnchor<T> anchor, @MachineSizedFloat double c);
    @Method(selector = "constraintLessThanOrEqualToAnchor:constant:")
    public native NSLayoutConstraint lessThanOrEqualTo(NSLayoutAnchor<T> anchor, @MachineSizedFloat double c);
    /*</methods>*/
}
