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
package com.bugvm.apple.externalaccessory;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("ExternalAccessory") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EAAccessoryManager/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {
    
    public static class Notifications {
        /**
         * @since Available in iOS 3.0 and later.
         */
        public static NSObject observeAccessoryDidConnect(EAAccessoryManager object, final VoidBlock3<EAAccessoryManager, EAAccessory, EAAccessory> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(AccessoryDidConnectNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    NSDictionary<?, ?> data = a.getUserInfo();
                    EAAccessory accessory = null;
                    EAAccessory selectedAccessory = null;
                    if (data.containsKey(AccessoryKey())) {
                        accessory = (EAAccessory) data.get(AccessoryKey());
                    }
                    if (data.containsKey(AccessorySelectedKey())) {
                        selectedAccessory = (EAAccessory) data.get(AccessorySelectedKey());
                    }
                    block.invoke((EAAccessoryManager)a.getObject(), accessory, selectedAccessory);
                }
            });
        }
        /**
         * @since Available in iOS 3.0 and later.
         */
        public static NSObject observeAccessoryDidDisconnect(EAAccessoryManager object, final VoidBlock2<EAAccessoryManager, EAAccessory> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(AccessoryDidDisconnectNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    NSDictionary<?, ?> data = a.getUserInfo();
                    EAAccessory accessory = null;
                    if (data.containsKey(AccessoryKey())) {
                        accessory = (EAAccessory) data.get(AccessoryKey());
                    }
                    block.invoke((EAAccessoryManager)a.getObject(), accessory);
                }
            });
        }
    }

    /*<ptr>*/public static class EAAccessoryManagerPtr extends Ptr<EAAccessoryManager, EAAccessoryManagerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EAAccessoryManager.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EAAccessoryManager() {}
    protected EAAccessoryManager(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "connectedAccessories")
    public native NSArray<EAAccessory> getConnectedAccessories();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @GlobalValue(symbol="EAAccessoryDidConnectNotification", optional=true)
    public static native NSString AccessoryDidConnectNotification();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @GlobalValue(symbol="EAAccessoryDidDisconnectNotification", optional=true)
    public static native NSString AccessoryDidDisconnectNotification();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @GlobalValue(symbol="EAAccessoryKey", optional=true)
    protected static native NSString AccessoryKey();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="EAAccessorySelectedKey", optional=true)
    protected static native NSString AccessorySelectedKey();
    
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "showBluetoothAccessoryPickerWithNameFilter:completion:")
    public native void showBluetoothAccessoryPicker(NSPredicate predicate, @Block VoidBlock1<NSError> completion);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "registerForLocalNotifications")
    public native void registerForLocalNotifications();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "unregisterForLocalNotifications")
    public native void unregisterForLocalNotifications();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "sharedAccessoryManager")
    public static native EAAccessoryManager getSharedAccessoryManager();
    /*</methods>*/
}
