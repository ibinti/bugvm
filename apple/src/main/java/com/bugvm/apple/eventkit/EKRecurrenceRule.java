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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKRecurrenceRule/*</name>*/ 
    extends /*<extends>*/EKObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKRecurrenceRulePtr extends Ptr<EKRecurrenceRule, EKRecurrenceRulePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKRecurrenceRule.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKRecurrenceRule() {}
    protected EKRecurrenceRule(SkipInit skipInit) { super(skipInit); }
    public EKRecurrenceRule(EKRecurrenceFrequency type, @MachineSizedSInt long interval, EKRecurrenceEnd end) { super((SkipInit) null); initObject(init(type, interval, end)); }
    public EKRecurrenceRule(EKRecurrenceFrequency type, @MachineSizedSInt long interval, NSArray<EKRecurrenceDayOfWeek> days, NSArray<NSNumber> monthDays, NSArray<NSNumber> months, NSArray<NSNumber> weeksOfTheYear, NSArray<NSNumber> daysOfTheYear, NSArray<NSNumber> setPositions, EKRecurrenceEnd end) { super((SkipInit) null); initObject(init(type, interval, days, monthDays, months, weeksOfTheYear, daysOfTheYear, setPositions, end)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "calendarIdentifier")
    public native String getCalendarIdentifier();
    @Property(selector = "recurrenceEnd")
    public native EKRecurrenceEnd getRecurrenceEnd();
    @Property(selector = "setRecurrenceEnd:")
    public native void setRecurrenceEnd(EKRecurrenceEnd v);
    @Property(selector = "frequency")
    public native EKRecurrenceFrequency getFrequency();
    @Property(selector = "interval")
    public native @MachineSizedSInt long getInterval();
    @Property(selector = "firstDayOfTheWeek")
    public native @MachineSizedSInt long getFirstDayOfTheWeek();
    @Property(selector = "daysOfTheWeek")
    public native NSArray<EKRecurrenceDayOfWeek> getDaysOfTheWeek();
    @Property(selector = "daysOfTheMonth")
    public native NSArray<NSNumber> getDaysOfTheMonth();
    @Property(selector = "daysOfTheYear")
    public native NSArray<NSNumber> getDaysOfTheYear();
    @Property(selector = "weeksOfTheYear")
    public native NSArray<NSNumber> getWeeksOfTheYear();
    @Property(selector = "monthsOfTheYear")
    public native NSArray<NSNumber> getMonthsOfTheYear();
    @Property(selector = "setPositions")
    public native NSArray<NSNumber> getSetPositions();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initRecurrenceWithFrequency:interval:end:")
    protected native @Pointer long init(EKRecurrenceFrequency type, @MachineSizedSInt long interval, EKRecurrenceEnd end);
    @Method(selector = "initRecurrenceWithFrequency:interval:daysOfTheWeek:daysOfTheMonth:monthsOfTheYear:weeksOfTheYear:daysOfTheYear:setPositions:end:")
    protected native @Pointer long init(EKRecurrenceFrequency type, @MachineSizedSInt long interval, NSArray<EKRecurrenceDayOfWeek> days, NSArray<NSNumber> monthDays, NSArray<NSNumber> months, NSArray<NSNumber> weeksOfTheYear, NSArray<NSNumber> daysOfTheYear, NSArray<NSNumber> setPositions, EKRecurrenceEnd end);
    /*</methods>*/
}
