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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/HMAccessoryDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "accessoryDidUpdateName:")
    void didUpdateName(HMAccessory accessory);
    @Method(selector = "accessory:didUpdateNameForService:")
    void didUpdateServiceName(HMAccessory accessory, HMService service);
    @Method(selector = "accessory:didUpdateAssociatedServiceTypeForService:")
    void didUpdateAssociatedServiceType(HMAccessory accessory, HMService service);
    @Method(selector = "accessoryDidUpdateServices:")
    void didUpdateServices(HMAccessory accessory);
    @Method(selector = "accessoryDidUpdateReachability:")
    void didUpdateReachability(HMAccessory accessory);
    @Method(selector = "accessory:service:didUpdateValueForCharacteristic:")
    void didUpdateCharacteristicValue(HMAccessory accessory, HMService service, HMCharacteristic characteristic);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
