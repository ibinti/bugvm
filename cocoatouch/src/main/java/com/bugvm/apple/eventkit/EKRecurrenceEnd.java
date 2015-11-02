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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKRecurrenceEnd/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKRecurrenceEndPtr extends Ptr<EKRecurrenceEnd, EKRecurrenceEndPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKRecurrenceEnd.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKRecurrenceEnd() {}
    protected EKRecurrenceEnd(SkipInit skipInit) { super(skipInit); }
    public EKRecurrenceEnd(NSDate endDate) { super(create(endDate)); retain(getHandle()); }
    public EKRecurrenceEnd(@MachineSizedUInt long occurrenceCount) { super(create(occurrenceCount)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "endDate")
    public native NSDate getEndDate();
    @Property(selector = "occurrenceCount")
    public native @MachineSizedUInt long getOccurrenceCount();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "recurrenceEndWithEndDate:")
    private static native @Pointer long create(NSDate endDate);
    @Method(selector = "recurrenceEndWithOccurrenceCount:")
    private static native @Pointer long create(@MachineSizedUInt long occurrenceCount);
    /*</methods>*/
}
