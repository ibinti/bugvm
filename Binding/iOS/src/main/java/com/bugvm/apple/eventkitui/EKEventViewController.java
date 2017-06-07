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
package com.bugvm.apple.eventkitui;

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
import com.bugvm.apple.eventkit.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("EventKitUI") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EKEventViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EKEventViewControllerPtr extends Ptr<EKEventViewController, EKEventViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EKEventViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EKEventViewController() {}
    protected EKEventViewController(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "delegate")
    public native EKEventViewDelegate getDelegate();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(EKEventViewDelegate v);
    @Property(selector = "event")
    public native EKEvent getEvent();
    @Property(selector = "setEvent:")
    public native void setEvent(EKEvent v);
    @Property(selector = "allowsEditing")
    public native boolean allowsEditing();
    @Property(selector = "setAllowsEditing:")
    public native void setAllowsEditing(boolean v);
    @Property(selector = "allowsCalendarPreview")
    public native boolean allowsCalendarPreview();
    @Property(selector = "setAllowsCalendarPreview:")
    public native void setAllowsCalendarPreview(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
