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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIAlertController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIAlertControllerPtr extends Ptr<UIAlertController, UIAlertControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIAlertController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIAlertController() {}
    protected UIAlertController(SkipInit skipInit) { super(skipInit); }
    public UIAlertController(String title, String message, UIAlertControllerStyle preferredStyle) { super(create(title, message, preferredStyle)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "actions")
    public native NSArray<UIAlertAction> getActions();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "preferredAction")
    public native UIAlertAction getPreferredAction();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setPreferredAction:")
    public native void setPreferredAction(UIAlertAction v);
    @Property(selector = "textFields")
    public native NSArray<UITextField> getTextFields();
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "setTitle:")
    public native void setTitle(String v);
    @Property(selector = "message")
    public native String getMessage();
    @Property(selector = "setMessage:")
    public native void setMessage(String v);
    @Property(selector = "preferredStyle")
    public native UIAlertControllerStyle getPreferredStyle();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "addAction:")
    public native void addAction(UIAlertAction action);
    @Method(selector = "addTextFieldWithConfigurationHandler:")
    public native void addTextField(@Block VoidBlock1<UITextField> configurationHandler);
    @Method(selector = "alertControllerWithTitle:message:preferredStyle:")
    protected static native @Pointer long create(String title, String message, UIAlertControllerStyle preferredStyle);
    /*</methods>*/
}
