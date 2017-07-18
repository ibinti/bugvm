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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKRecurrenceDayOfWeek/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKRecurrenceDayOfWeekPtr extends Ptr<EKRecurrenceDayOfWeek, EKRecurrenceDayOfWeekPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKRecurrenceDayOfWeek.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKRecurrenceDayOfWeek() {}
    protected EKRecurrenceDayOfWeek(SkipInit skipInit) { super(skipInit); }
    public EKRecurrenceDayOfWeek(EKWeekday dayOfTheWeek, @MachineSizedSInt long weekNumber) { super((SkipInit) null); initObject(init(dayOfTheWeek, weekNumber)); }
    public EKRecurrenceDayOfWeek(EKWeekday dayOfTheWeek) { super(create(dayOfTheWeek)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "dayOfTheWeek")
    public native EKWeekday getDayOfTheWeek();
    @Property(selector = "weekNumber")
    public native @MachineSizedSInt long getWeekNumber();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithDayOfTheWeek:weekNumber:")
    protected native @Pointer long init(EKWeekday dayOfTheWeek, @MachineSizedSInt long weekNumber);
    @Method(selector = "dayOfWeek:")
    private static native @Pointer long create(EKWeekday dayOfTheWeek);
    /*</methods>*/
}
