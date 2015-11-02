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
package com.bugvm.apple.eventkit;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.addressbook.*;
import com.bugvm.apple.mapkit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("EventKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKAlarm/*</name>*/ 
    extends /*<extends>*/EKObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKAlarmPtr extends Ptr<EKAlarm, EKAlarmPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKAlarm.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKAlarm() {}
    protected EKAlarm(SkipInit skipInit) { super(skipInit); }
    public EKAlarm(NSDate date) { super(create(date)); retain(getHandle()); }
    public EKAlarm(double offset) { super(create(offset)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "relativeOffset")
    public native double getRelativeOffset();
    @Property(selector = "setRelativeOffset:")
    public native void setRelativeOffset(double v);
    @Property(selector = "absoluteDate")
    public native NSDate getAbsoluteDate();
    @Property(selector = "setAbsoluteDate:")
    public native void setAbsoluteDate(NSDate v);
    @Property(selector = "structuredLocation")
    public native EKStructuredLocation getStructuredLocation();
    @Property(selector = "setStructuredLocation:")
    public native void setStructuredLocation(EKStructuredLocation v);
    @Property(selector = "proximity")
    public native EKAlarmProximity getProximity();
    @Property(selector = "setProximity:")
    public native void setProximity(EKAlarmProximity v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "alarmWithAbsoluteDate:")
    private static native @Pointer long create(NSDate date);
    @Method(selector = "alarmWithRelativeOffset:")
    private static native @Pointer long create(double offset);
    /*</methods>*/
}
