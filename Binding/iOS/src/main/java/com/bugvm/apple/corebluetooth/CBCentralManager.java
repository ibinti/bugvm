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
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreBluetooth") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CBCentralManager/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CBCentralManagerPtr extends Ptr<CBCentralManager, CBCentralManagerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CBCentralManager.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CBCentralManager() {}
    protected CBCentralManager(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public CBCentralManager(CBCentralManagerDelegate delegate, DispatchQueue queue) { super((SkipInit) null); initObject(init(delegate, queue)); }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @WeaklyLinked
    public CBCentralManager(CBCentralManagerDelegate delegate, DispatchQueue queue, CBCentralManagerOptions options) { super((SkipInit) null); initObject(init(delegate, queue, options)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native CBCentralManagerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(CBCentralManagerDelegate v);
    @Property(selector = "state")
    public native CBCentralManagerState getState();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "isScanning")
    public native boolean isScanning();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "initWithDelegate:queue:")
    protected native @Pointer long init(CBCentralManagerDelegate delegate, DispatchQueue queue);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "initWithDelegate:queue:options:")
    protected native @Pointer long init(CBCentralManagerDelegate delegate, DispatchQueue queue, CBCentralManagerOptions options);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "retrievePeripheralsWithIdentifiers:")
    public native NSArray<CBPeripheral> retrievePeripheralsWithId(NSArray<NSUUID> identifiers);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "retrieveConnectedPeripheralsWithServices:")
    public native NSArray<CBPeripheral> retrieveConnectedPeripherals(NSArray<CBUUID> serviceUUIDs);
    @Method(selector = "scanForPeripheralsWithServices:options:")
    public native void scanForPeripherals(NSArray<CBUUID> serviceUUIDs, CBCentralManagerScanOptions options);
    @Method(selector = "stopScan")
    public native void stopScan();
    @Method(selector = "connectPeripheral:options:")
    public native void connectPeripheral(CBPeripheral peripheral, CBConnectPeripheralOptions options);
    @Method(selector = "cancelPeripheralConnection:")
    public native void cancelPeripheralConnection(CBPeripheral peripheral);
    /*</methods>*/
}
