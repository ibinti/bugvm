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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIDevice/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        public static NSObject observeOrientationDidChange(final Runnable block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(OrientationDidChangeNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.run();
                }
            });
        }
        /**
         * @since Available in iOS 3.0 and later.
         */
        public static NSObject observeBatteryStateDidChange(final Runnable block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(BatteryStateDidChangeNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.run();
                }
            });
        }
        /**
         * @since Available in iOS 3.0 and later.
         */
        public static NSObject observeBatteryLevelDidChange(final Runnable block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(BatteryLevelDidChangeNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.run();
                }
            });
        }
        /**
         * @since Available in iOS 3.0 and later.
         */
        public static NSObject observeProximityStateDidChange(final Runnable block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(ProximityStateDidChangeNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.run();
                }
            });
        }
    }
    /*<ptr>*/public static class UIDevicePtr extends Ptr<UIDevice, UIDevicePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIDevice.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIDevice() {}
    protected UIDevice(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "model")
    public native String getModel();
    @Property(selector = "localizedModel")
    public native String getLocalizedModel();
    @Property(selector = "systemName")
    public native String getSystemName();
    @Property(selector = "systemVersion")
    public native String getSystemVersion();
    @Property(selector = "orientation")
    public native UIDeviceOrientation getOrientation();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "identifierForVendor")
    public native NSUUID getIdentifierForVendor();
    @Property(selector = "isGeneratingDeviceOrientationNotifications")
    public native boolean generatesDeviceOrientationNotifications();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "isBatteryMonitoringEnabled")
    public native boolean isBatteryMonitoringEnabled();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "setBatteryMonitoringEnabled:")
    public native void setBatteryMonitoringEnabled(boolean v);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "batteryState")
    public native UIDeviceBatteryState getBatteryState();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "batteryLevel")
    public native float getBatteryLevel();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "isProximityMonitoringEnabled")
    public native boolean isProximityMonitoringEnabled();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "setProximityMonitoringEnabled:")
    public native void setProximityMonitoringEnabled(boolean v);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "proximityState")
    public native boolean isProximityState();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "isMultitaskingSupported")
    public native boolean isMultitaskingSupported();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Property(selector = "userInterfaceIdiom")
    public native UIUserInterfaceIdiom getUserInterfaceIdiom();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="UIDeviceOrientationDidChangeNotification", optional=true)
    public static native NSString OrientationDidChangeNotification();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @GlobalValue(symbol="UIDeviceBatteryStateDidChangeNotification", optional=true)
    public static native NSString BatteryStateDidChangeNotification();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @GlobalValue(symbol="UIDeviceBatteryLevelDidChangeNotification", optional=true)
    public static native NSString BatteryLevelDidChangeNotification();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @GlobalValue(symbol="UIDeviceProximityStateDidChangeNotification", optional=true)
    public static native NSString ProximityStateDidChangeNotification();
    
    @Method(selector = "beginGeneratingDeviceOrientationNotifications")
    public native void beginGeneratingDeviceOrientationNotifications();
    @Method(selector = "endGeneratingDeviceOrientationNotifications")
    public native void endGeneratingDeviceOrientationNotifications();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Method(selector = "playInputClick")
    public native void playInputClick();
    @Method(selector = "currentDevice")
    public static native UIDevice getCurrentDevice();
    /*</methods>*/
}
