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
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/CBPeripheralManagerDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "peripheralManagerDidUpdateState:")
    void didUpdateState(CBPeripheralManager peripheral);
    @Method(selector = "peripheralManager:willRestoreState:")
    void willRestoreState(CBPeripheralManager peripheral, CBPeripheralManagerRestoredState dict);
    @Method(selector = "peripheralManagerDidStartAdvertising:error:")
    void didStartAdvertising(CBPeripheralManager peripheral, NSError error);
    @Method(selector = "peripheralManager:didAddService:error:")
    void didAddService(CBPeripheralManager peripheral, CBService service, NSError error);
    @Method(selector = "peripheralManager:central:didSubscribeToCharacteristic:")
    void didSubscribeToCharacteristic(CBPeripheralManager peripheral, CBCentral central, CBCharacteristic characteristic);
    @Method(selector = "peripheralManager:central:didUnsubscribeFromCharacteristic:")
    void didUnsubscribeFromCharacteristic(CBPeripheralManager peripheral, CBCentral central, CBCharacteristic characteristic);
    @Method(selector = "peripheralManager:didReceiveReadRequest:")
    void didReceiveReadRequest(CBPeripheralManager peripheral, CBATTRequest request);
    @Method(selector = "peripheralManager:didReceiveWriteRequests:")
    void didReceiveWriteRequests(CBPeripheralManager peripheral, NSArray<CBATTRequest> requests);
    @Method(selector = "peripheralManagerIsReadyToUpdateSubscribers:")
    void readyToUpdateSubscribers(CBPeripheralManager peripheral);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
