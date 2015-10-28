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
package com.bugvm.apple.homekit;

/*<imports>*/

import com.bugvm.apple.corelocation.CLRegion;
import com.bugvm.apple.foundation.NSError;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Block;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.block.VoidBlock1;
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
/*<annotations>*/@Library("HomeKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/HMLocationEvent/*</name>*/ 
    extends /*<extends>*/HMEvent/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class HMLocationEventPtr extends Ptr<HMLocationEvent, HMLocationEventPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(HMLocationEvent.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected HMLocationEvent(SkipInit skipInit) { super(skipInit); }
    public HMLocationEvent(CLRegion region) { super((SkipInit) null); initObject(init(region)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "region")
    public native CLRegion getRegion();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithRegion:")
    protected native @Pointer long init(CLRegion region);
    @Method(selector = "updateRegion:completionHandler:")
    public native void updateRegion(CLRegion region, @Block VoidBlock1<NSError> completion);
    /*</methods>*/
}
