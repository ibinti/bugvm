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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CBPeripheralManagerDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements CBPeripheralManagerDelegate/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @NotImplemented("peripheralManagerDidUpdateState:")
    public void didUpdateState(CBPeripheralManager peripheral) {}
    @NotImplemented("peripheralManager:willRestoreState:")
    public void willRestoreState(CBPeripheralManager peripheral, CBPeripheralManagerRestoredState dict) {}
    @NotImplemented("peripheralManagerDidStartAdvertising:error:")
    public void didStartAdvertising(CBPeripheralManager peripheral, NSError error) {}
    @NotImplemented("peripheralManager:didAddService:error:")
    public void didAddService(CBPeripheralManager peripheral, CBService service, NSError error) {}
    @NotImplemented("peripheralManager:central:didSubscribeToCharacteristic:")
    public void didSubscribeToCharacteristic(CBPeripheralManager peripheral, CBCentral central, CBCharacteristic characteristic) {}
    @NotImplemented("peripheralManager:central:didUnsubscribeFromCharacteristic:")
    public void didUnsubscribeFromCharacteristic(CBPeripheralManager peripheral, CBCentral central, CBCharacteristic characteristic) {}
    @NotImplemented("peripheralManager:didReceiveReadRequest:")
    public void didReceiveReadRequest(CBPeripheralManager peripheral, CBATTRequest request) {}
    @NotImplemented("peripheralManager:didReceiveWriteRequests:")
    public void didReceiveWriteRequests(CBPeripheralManager peripheral, NSArray<CBATTRequest> requests) {}
    @NotImplemented("peripheralManagerIsReadyToUpdateSubscribers:")
    public void readyToUpdateSubscribers(CBPeripheralManager peripheral) {}
    /*</methods>*/
}
