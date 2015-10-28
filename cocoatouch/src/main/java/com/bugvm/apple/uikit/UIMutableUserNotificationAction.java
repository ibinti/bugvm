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
package com.bugvm.apple.uikit;

/*<imports>*/

import com.bugvm.apple.foundation.NSDictionary;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIMutableUserNotificationAction/*</name>*/ 
    extends /*<extends>*/UIUserNotificationAction/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIMutableUserNotificationActionPtr extends Ptr<UIMutableUserNotificationAction, UIMutableUserNotificationActionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIMutableUserNotificationAction.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIMutableUserNotificationAction() {}
    protected UIMutableUserNotificationAction(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "identifier")
    public native String getIdentifier();
    @Property(selector = "setIdentifier:")
    public native void setIdentifier(String v);
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "setTitle:")
    public native void setTitle(String v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "behavior")
    public native UIUserNotificationActionBehavior getBehavior();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setBehavior:")
    public native void setBehavior(UIUserNotificationActionBehavior v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "parameters")
    public native NSDictionary<?, ?> getParameters();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setParameters:")
    public native void setParameters(NSDictionary<?, ?> v);
    @Property(selector = "activationMode")
    public native UIUserNotificationActivationMode getActivationMode();
    @Property(selector = "setActivationMode:")
    public native void setActivationMode(UIUserNotificationActivationMode v);
    @Property(selector = "isAuthenticationRequired")
    public native boolean isAuthenticationRequired();
    @Property(selector = "setAuthenticationRequired:")
    public native void setAuthenticationRequired(boolean v);
    @Property(selector = "isDestructive")
    public native boolean isDestructive();
    @Property(selector = "setDestructive:")
    public native void setDestructive(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
