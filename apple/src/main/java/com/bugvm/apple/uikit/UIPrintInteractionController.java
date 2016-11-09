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
 * @since Available in iOS 4.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIPrintInteractionController/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIPrintInteractionControllerPtr extends Ptr<UIPrintInteractionController, UIPrintInteractionControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIPrintInteractionController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIPrintInteractionController() {}
    protected UIPrintInteractionController(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "printInfo")
    public native UIPrintInfo getPrintInfo();
    @Property(selector = "setPrintInfo:")
    public native void setPrintInfo(UIPrintInfo v);
    @Property(selector = "delegate")
    public native UIPrintInteractionControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(UIPrintInteractionControllerDelegate v);
    @Property(selector = "showsPageRange")
    public native boolean showsPageRange();
    @Property(selector = "setShowsPageRange:")
    public native void setShowsPageRange(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "showsNumberOfCopies")
    public native boolean showsNumberOfCopies();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setShowsNumberOfCopies:")
    public native void setShowsNumberOfCopies(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "showsPaperSelectionForLoadedPapers")
    public native boolean showsPaperSelectionForLoadedPapers();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setShowsPaperSelectionForLoadedPapers:")
    public native void setShowsPaperSelectionForLoadedPapers(boolean v);
    @Property(selector = "printPaper")
    public native UIPrintPaper getPrintPaper();
    @Property(selector = "printPageRenderer")
    public native UIPrintPageRenderer getPrintPageRenderer();
    @Property(selector = "setPrintPageRenderer:")
    public native void setPrintPageRenderer(UIPrintPageRenderer v);
    @Property(selector = "printFormatter")
    public native UIPrintFormatter getPrintFormatter();
    @Property(selector = "setPrintFormatter:")
    public native void setPrintFormatter(UIPrintFormatter v);
    @Property(selector = "printingItem")
    public native NSObject getPrintingItem();
    @Property(selector = "setPrintingItem:")
    public native void setPrintingItem(NSObject v);
    @Property(selector = "printingItems")
    public native NSArray<?> getPrintingItems();
    @Property(selector = "setPrintingItems:")
    public native void setPrintingItems(NSArray<?> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "presentAnimated:completionHandler:")
    public native boolean present(boolean animated, @Block VoidBlock3<UIPrintInteractionController, Boolean, NSError> completion);
    @Method(selector = "presentFromRect:inView:animated:completionHandler:")
    public native boolean presentFromRectInView(@ByVal CGRect rect, UIView view, boolean animated, @Block VoidBlock3<UIPrintInteractionController, Boolean, NSError> completion);
    @Method(selector = "presentFromBarButtonItem:animated:completionHandler:")
    public native boolean presentFromBarButtonItem(UIBarButtonItem item, boolean animated, @Block VoidBlock3<UIPrintInteractionController, Boolean, NSError> completion);
    @Method(selector = "printToPrinter:completionHandler:")
    public native boolean print(UIPrinter printer, @Block VoidBlock3<UIPrintInteractionController, Boolean, NSError> completion);
    @Method(selector = "dismissAnimated:")
    public native void dismiss(boolean animated);
    @Method(selector = "isPrintingAvailable")
    public static native boolean isPrintingAvailable();
    @Method(selector = "printableUTIs")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getPrintableUTIs();
    @Method(selector = "canPrintURL:")
    public static native boolean canPrint(NSURL url);
    @Method(selector = "canPrintData:")
    public static native boolean canPrint(NSData data);
    @Method(selector = "sharedPrintController")
    public static native UIPrintInteractionController getSharedPrintController();
    /*</methods>*/
}
