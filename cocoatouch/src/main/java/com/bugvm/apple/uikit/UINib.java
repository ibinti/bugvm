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

import com.bugvm.apple.foundation.NSArray;
import com.bugvm.apple.foundation.NSBundle;
import com.bugvm.apple.foundation.NSData;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UINib/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UINibPtr extends Ptr<UINib, UINibPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UINib.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UINib() {}
    protected UINib(SkipInit skipInit) { super(skipInit); }
    public UINib(String name, NSBundle bundleOrNil) { super(create(name, bundleOrNil)); retain(getHandle()); }
    public UINib(NSData data, NSBundle bundleOrNil) { super(create(data, bundleOrNil)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "instantiateWithOwner:options:")
    public native NSArray<?> instantiate(NSObject ownerOrNil, UINibLoadingOptions optionsOrNil);
    @Method(selector = "nibWithNibName:bundle:")
    protected static native @Pointer long create(String name, NSBundle bundleOrNil);
    @Method(selector = "nibWithData:bundle:")
    protected static native @Pointer long create(NSData data, NSBundle bundleOrNil);
    /*</methods>*/
}
