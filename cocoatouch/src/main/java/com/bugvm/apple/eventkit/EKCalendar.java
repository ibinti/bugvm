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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKCalendar/*</name>*/ 
    extends /*<extends>*/EKObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKCalendarPtr extends Ptr<EKCalendar, EKCalendarPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKCalendar.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKCalendar() {}
    protected EKCalendar(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 6.0 and later.
     */
    public EKCalendar(EKEntityType entityType, EKEventStore eventStore) { super(create(entityType, eventStore)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "source")
    public native EKSource getSource();
    @Property(selector = "setSource:")
    public native void setSource(EKSource v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "calendarIdentifier")
    public native String getCalendarIdentifier();
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "setTitle:")
    public native void setTitle(String v);
    @Property(selector = "type")
    public native EKCalendarType getType();
    @Property(selector = "allowsContentModifications")
    public native boolean allowsContentModifications();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isSubscribed")
    public native boolean isSubscribed();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isImmutable")
    public native boolean isImmutable();
    @WeaklyLinked
    @Property(selector = "CGColor")
    public native CGColor getCGColor();
    @WeaklyLinked
    @Property(selector = "setCGColor:")
    public native void setCGColor(CGColor v);
    @Property(selector = "supportedEventAvailabilities")
    public native EKCalendarEventAvailabilityMask getSupportedEventAvailabilities();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "allowedEntityTypes")
    public native EKEntityMask getAllowedEntityTypes();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "calendarForEntityType:eventStore:")
    private static native @Pointer long create(EKEntityType entityType, EKEventStore eventStore);
    /*</methods>*/
}
