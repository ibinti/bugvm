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
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("EventKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKReminder/*</name>*/ 
    extends /*<extends>*/EKCalendarItem/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKReminderPtr extends Ptr<EKReminder, EKReminderPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKReminder.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKReminder() {}
    protected EKReminder(SkipInit skipInit) { super(skipInit); }
    public EKReminder(EKEventStore eventStore) { super(create(eventStore)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "startDateComponents")
    public native NSDateComponents getStartDateComponents();
    @Property(selector = "setStartDateComponents:")
    public native void setStartDateComponents(NSDateComponents v);
    @Property(selector = "dueDateComponents")
    public native NSDateComponents getDueDateComponents();
    @Property(selector = "setDueDateComponents:")
    public native void setDueDateComponents(NSDateComponents v);
    @Property(selector = "isCompleted")
    public native boolean isCompleted();
    @Property(selector = "setCompleted:")
    public native void setCompleted(boolean v);
    @Property(selector = "completionDate")
    public native NSDate getCompletionDate();
    @Property(selector = "setCompletionDate:")
    public native void setCompletionDate(NSDate v);
    @Property(selector = "priority")
    public native @MachineSizedUInt long getPriority();
    @Property(selector = "setPriority:")
    public native void setPriority(@MachineSizedUInt long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "reminderWithEventStore:")
    private static native @Pointer long create(EKEventStore eventStore);
    /*</methods>*/
}
