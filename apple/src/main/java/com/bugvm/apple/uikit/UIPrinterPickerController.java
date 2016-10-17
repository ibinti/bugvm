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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIPrinterPickerController/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIPrinterPickerControllerPtr extends Ptr<UIPrinterPickerController, UIPrinterPickerControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIPrinterPickerController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIPrinterPickerController() {}
    protected UIPrinterPickerController(SkipInit skipInit) { super(skipInit); }
    public UIPrinterPickerController(UIPrinter printer) { super(create(printer)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "selectedPrinter")
    public native UIPrinter getSelectedPrinter();
    @Property(selector = "delegate")
    public native UIPrinterPickerControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(UIPrinterPickerControllerDelegate v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "presentAnimated:completionHandler:")
    public native boolean presentAnimated(boolean animated, @Block VoidBlock3<UIPrinterPickerController, Boolean, NSError> completion);
    @Method(selector = "presentFromRect:inView:animated:completionHandler:")
    public native boolean presentFromRectInView(@ByVal CGRect rect, UIView view, boolean animated, @Block VoidBlock3<UIPrinterPickerController, Boolean, NSError> completion);
    @Method(selector = "presentFromBarButtonItem:animated:completionHandler:")
    public native boolean presentFromBarButtonItem(UIBarButtonItem item, boolean animated, @Block VoidBlock3<UIPrinterPickerController, Boolean, NSError> completion);
    @Method(selector = "dismissAnimated:")
    public native void dismissAnimated(boolean animated);
    @Method(selector = "printerPickerControllerWithInitiallySelectedPrinter:")
    protected static native @Pointer long create(UIPrinter printer);
    /*</methods>*/
}
