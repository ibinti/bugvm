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
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("HomeKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/HMCharacteristicEvent/*</name>*/ <T extends NSObject>
    extends /*<extends>*/HMEvent/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class HMCharacteristicEventPtr extends Ptr<HMCharacteristicEvent, HMCharacteristicEventPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(HMCharacteristicEvent.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected HMCharacteristicEvent(SkipInit skipInit) { super(skipInit); }
    public HMCharacteristicEvent(HMCharacteristic characteristic, T triggerValue) { super((SkipInit) null); initObject(init(characteristic, triggerValue)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "characteristic")
    public native HMCharacteristic getCharacteristic();
    @Property(selector = "triggerValue")
    public native T getTriggerValue();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithCharacteristic:triggerValue:")
    protected native @Pointer long init(HMCharacteristic characteristic, T triggerValue);
    @Method(selector = "updateTriggerValue:completionHandler:")
    public native void updateTriggerValue(T triggerValue, @Block VoidBlock1<NSError> completion);
    /*</methods>*/
}
