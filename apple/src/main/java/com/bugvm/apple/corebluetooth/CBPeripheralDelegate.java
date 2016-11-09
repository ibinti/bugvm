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
package com.bugvm.apple.corebluetooth;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/CBPeripheralDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "peripheralDidUpdateName:")
    void didUpdateName(CBPeripheral peripheral);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "peripheral:didModifyServices:")
    void didModifyServices(CBPeripheral peripheral, NSArray<CBService> invalidatedServices);
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Method(selector = "peripheralDidUpdateRSSI:error:")
    void didUpdateRSSI(CBPeripheral peripheral, NSError error);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "peripheral:didReadRSSI:error:")
    void didReadRSSI(CBPeripheral peripheral, NSNumber RSSI, NSError error);
    @Method(selector = "peripheral:didDiscoverServices:")
    void didDiscoverServices(CBPeripheral peripheral, NSError error);
    @Method(selector = "peripheral:didDiscoverIncludedServicesForService:error:")
    void didDiscoverIncludedServices(CBPeripheral peripheral, CBService service, NSError error);
    @Method(selector = "peripheral:didDiscoverCharacteristicsForService:error:")
    void didDiscoverCharacteristics(CBPeripheral peripheral, CBService service, NSError error);
    @Method(selector = "peripheral:didUpdateValueForCharacteristic:error:")
    void didUpdateValue(CBPeripheral peripheral, CBCharacteristic characteristic, NSError error);
    @Method(selector = "peripheral:didWriteValueForCharacteristic:error:")
    void didWriteValue(CBPeripheral peripheral, CBCharacteristic characteristic, NSError error);
    @Method(selector = "peripheral:didUpdateNotificationStateForCharacteristic:error:")
    void didUpdateNotificationState(CBPeripheral peripheral, CBCharacteristic characteristic, NSError error);
    @Method(selector = "peripheral:didDiscoverDescriptorsForCharacteristic:error:")
    void didDiscoverDescriptors(CBPeripheral peripheral, CBCharacteristic characteristic, NSError error);
    @Method(selector = "peripheral:didUpdateValueForDescriptor:error:")
    void didUpdateValue(CBPeripheral peripheral, CBDescriptor descriptor, NSError error);
    @Method(selector = "peripheral:didWriteValueForDescriptor:error:")
    void didWriteValue(CBPeripheral peripheral, CBDescriptor descriptor, NSError error);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
