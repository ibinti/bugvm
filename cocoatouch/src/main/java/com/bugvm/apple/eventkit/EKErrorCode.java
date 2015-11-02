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

/*</javadoc>*/
@ForceLinkClass(EKError.class)
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/EKErrorCode/*</name>*/ implements NSErrorCode {
    /*<values>*/
    EventNotMutable(0L),
    NoCalendar(1L),
    NoStartDate(2L),
    NoEndDate(3L),
    DatesInverted(4L),
    InternalFailure(5L),
    CalendarReadOnly(6L),
    DurationGreaterThanRecurrence(7L),
    AlarmGreaterThanRecurrence(8L),
    StartDateTooFarInFuture(9L),
    StartDateCollidesWithOtherOccurrence(10L),
    ObjectBelongsToDifferentStore(11L),
    InvitesCannotBeMoved(12L),
    InvalidSpan(13L),
    CalendarHasNoSource(14L),
    CalendarSourceCannotBeModified(15L),
    CalendarIsImmutable(16L),
    SourceDoesNotAllowCalendarAddDelete(17L),
    RecurringReminderRequiresDueDate(18L),
    StructuredLocationsNotSupported(19L),
    ReminderLocationsNotSupported(20L),
    AlarmProximityNotSupported(21L),
    CalendarDoesNotAllowEvents(22L),
    CalendarDoesNotAllowReminders(23L),
    SourceDoesNotAllowReminders(24L),
    SourceDoesNotAllowEvents(25L),
    PriorityIsInvalid(26L),
    InvalidEntityType(27L),
    ProcedureAlarmsNotMutable(28L),
    EventStoreNotAuthorized(29L),
    OSNotSupported(30L),
    Last(31L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/EKErrorCode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/EKErrorCode/*</name>*/ valueOf(long n) {
        for (/*<name>*/EKErrorCode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/EKErrorCode/*</name>*/.class.getName());
    }
}
