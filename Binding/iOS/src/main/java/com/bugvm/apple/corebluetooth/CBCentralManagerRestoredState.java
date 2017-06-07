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
/*<annotations>*/@Library("CoreBluetooth")/*</annotations>*/
@Marshaler(/*<name>*/CBCentralManagerRestoredState/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CBCentralManagerRestoredState/*</name>*/ 
    extends /*<extends>*/NSDictionaryWrapper/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static CBCentralManagerRestoredState toObject(Class<CBCentralManagerRestoredState> cls, long handle, long flags) {
            NSDictionary o = (NSDictionary) NSObject.Marshaler.toObject(NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new CBCentralManagerRestoredState(o);
        }
        @MarshalsPointer
        public static long toNative(CBCentralManagerRestoredState o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<CBCentralManagerRestoredState> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSDictionary> o = (NSArray<NSDictionary>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<CBCentralManagerRestoredState> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(new CBCentralManagerRestoredState(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<CBCentralManagerRestoredState> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSDictionary> array = new NSMutableArray<>();
            for (CBCentralManagerRestoredState i : l) {
                array.add(i.getDictionary());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constructors>*/
    CBCentralManagerRestoredState(NSDictionary data) {
        super(data);
    }
    /*</constructors>*/

    /*<methods>*/
    public boolean has(NSString key) {
        return data.containsKey(key);
    }
    public NSObject get(NSString key) {
        if (has(key)) {
            return data.get(key);
        }
        return null;
    }
    

    /**
     * @since Available in iOS 7.0 and later.
     */
    public NSArray<CBPeripheral> getPeripherals() {
        if (has(Keys.Peripherals())) {
            NSArray<CBPeripheral> val = (NSArray<CBPeripheral>) get(Keys.Peripherals());
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public NSArray<CBUUID> getScanServices() {
        if (has(Keys.ScanServices())) {
            NSArray<CBUUID> val = (NSArray<CBUUID>) get(Keys.ScanServices());
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public CBCentralManagerScanOptions getScanOptions() {
        if (has(Keys.ScanOptions())) {
            NSDictionary val = (NSDictionary) get(Keys.ScanOptions());
            return new CBCentralManagerScanOptions(val);
        }
        return null;
    }
    /*</methods>*/
    
    /*<keys>*/
    @Library("CoreBluetooth")
    public static class Keys {
        static { Bro.bind(Keys.class); }
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="CBCentralManagerRestoredStatePeripheralsKey", optional=true)
        public static native NSString Peripherals();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="CBCentralManagerRestoredStateScanServicesKey", optional=true)
        public static native NSString ScanServices();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="CBCentralManagerRestoredStateScanOptionsKey", optional=true)
        public static native NSString ScanOptions();
    }
    /*</keys>*/
}
