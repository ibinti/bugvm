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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EAAccessory/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EAAccessoryPtr extends Ptr<EAAccessory, EAAccessoryPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EAAccessory.class); }/*</bind>*/
    /*<constants>*/
    public static final int ConnectionIDNone = 0;
    /*</constants>*/
    /*<constructors>*/
    public EAAccessory() {}
    protected EAAccessory(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "isConnected")
    public native boolean isConnected();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "connectionID")
    public native @MachineSizedUInt long getConnectionID();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "manufacturer")
    public native String getManufacturer();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "name")
    public native String getName();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "modelNumber")
    public native String getModelNumber();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "serialNumber")
    public native String getSerialNumber();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "firmwareRevision")
    public native String getFirmwareRevision();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "hardwareRevision")
    public native String getHardwareRevision();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "dockType")
    public native String getDockType();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "protocolStrings")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getProtocolStrings();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "delegate")
    public native EAAccessoryDelegate getDelegate();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(EAAccessoryDelegate v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
