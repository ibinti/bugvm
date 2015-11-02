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
package com.bugvm.apple.cloudkit;

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
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.contacts.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CloudKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKNotification/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CKNotificationPtr extends Ptr<CKNotification, CKNotificationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CKNotification.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CKNotification() {}
    protected CKNotification(SkipInit skipInit) { super(skipInit); }
    public CKNotification(com.bugvm.apple.uikit.UIRemoteNotification notificationDictionary) { super(create(notificationDictionary)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "notificationType")
    public native CKNotificationType getNotificationType();
    @Property(selector = "notificationID")
    public native CKNotificationID getNotificationID();
    @Property(selector = "containerIdentifier")
    public native String getContainerIdentifier();
    @Property(selector = "isPruned")
    public native boolean isPruned();
    @Property(selector = "alertBody")
    public native String getAlertBody();
    @Property(selector = "alertLocalizationKey")
    public native String getAlertLocalizationKey();
    @Property(selector = "alertLocalizationArgs")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAlertLocalizationArgs();
    @Property(selector = "alertActionLocalizationKey")
    public native String getAlertActionLocalizationKey();
    @Property(selector = "alertLaunchImage")
    public native String getAlertLaunchImage();
    @Property(selector = "badge")
    public native NSNumber getBadge();
    @Property(selector = "soundName")
    public native String getSoundName();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "subscriptionID")
    public native String getSubscriptionID();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "category")
    public native String getCategory();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "notificationFromRemoteNotificationDictionary:")
    protected static native @Pointer long create(com.bugvm.apple.uikit.UIRemoteNotification notificationDictionary);
    /*</methods>*/
}
