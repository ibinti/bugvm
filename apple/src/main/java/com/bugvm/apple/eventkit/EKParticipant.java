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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKParticipant/*</name>*/ 
    extends /*<extends>*/EKObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKParticipantPtr extends Ptr<EKParticipant, EKParticipantPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKParticipant.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKParticipant() {}
    protected EKParticipant(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "URL")
    public native NSURL getURL();
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "participantStatus")
    public native EKParticipantStatus getParticipantStatus();
    @Property(selector = "participantRole")
    public native EKParticipantRole getParticipantRole();
    @Property(selector = "participantType")
    public native EKParticipantType getParticipantType();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "isCurrentUser")
    public native boolean isCurrentUser();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "contactPredicate")
    public native NSPredicate getContactPredicate();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @WeaklyLinked
    @Method(selector = "ABRecordWithAddressBook:")
    public native ABRecord getAddessBookRecord(ABAddressBook addressBook);
    /*</methods>*/
}
