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
 * @since Available in iOS 3.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIDocumentInteractionController/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements UIActionSheetDelegate/*</implements>*/ {

    /*<ptr>*/public static class UIDocumentInteractionControllerPtr extends Ptr<UIDocumentInteractionController, UIDocumentInteractionControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIDocumentInteractionController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIDocumentInteractionController() {}
    protected UIDocumentInteractionController(SkipInit skipInit) { super(skipInit); }
    public UIDocumentInteractionController(NSURL url) { super(create(url)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native UIDocumentInteractionControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(UIDocumentInteractionControllerDelegate v);
    @Property(selector = "URL")
    public native NSURL getURL();
    @Property(selector = "setURL:")
    public native void setURL(NSURL v);
    @Property(selector = "UTI")
    public native String getUTI();
    @Property(selector = "setUTI:")
    public native void setUTI(String v);
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "setName:")
    public native void setName(String v);
    @Property(selector = "icons")
    public native NSArray<UIImage> getIcons();
    @Property(selector = "annotation")
    public native NSObject getAnnotation();
    @Property(selector = "setAnnotation:")
    public native void setAnnotation(NSObject v);
    @Property(selector = "gestureRecognizers")
    public native NSArray<UIGestureRecognizer> getGestureRecognizers();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "presentOptionsMenuFromRect:inView:animated:")
    public native boolean presentOptionsMenu(@ByVal CGRect rect, UIView view, boolean animated);
    @Method(selector = "presentOptionsMenuFromBarButtonItem:animated:")
    public native boolean presentOptionsMenu(UIBarButtonItem item, boolean animated);
    @Method(selector = "presentPreviewAnimated:")
    public native boolean presentPreview(boolean animated);
    @Method(selector = "presentOpenInMenuFromRect:inView:animated:")
    public native boolean presentOpenInMenu(@ByVal CGRect rect, UIView view, boolean animated);
    @Method(selector = "presentOpenInMenuFromBarButtonItem:animated:")
    public native boolean presentOpenInMenu(UIBarButtonItem item, boolean animated);
    @Method(selector = "dismissPreviewAnimated:")
    public native void dismissPreview(boolean animated);
    @Method(selector = "dismissMenuAnimated:")
    public native void dismissMenu(boolean animated);
    @Method(selector = "interactionControllerWithURL:")
    protected static native @Pointer long create(NSURL url);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.3.
     */
    @Deprecated
    @Method(selector = "actionSheet:clickedButtonAtIndex:")
    public native void clicked(UIActionSheet actionSheet, @MachineSizedSInt long buttonIndex);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.3.
     */
    @Deprecated
    @Method(selector = "actionSheetCancel:")
    public native void cancel(UIActionSheet actionSheet);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.3.
     */
    @Deprecated
    @Method(selector = "willPresentActionSheet:")
    public native void willPresent(UIActionSheet actionSheet);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.3.
     */
    @Deprecated
    @Method(selector = "didPresentActionSheet:")
    public native void didPresent(UIActionSheet actionSheet);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.3.
     */
    @Deprecated
    @Method(selector = "actionSheet:willDismissWithButtonIndex:")
    public native void willDismiss(UIActionSheet actionSheet, @MachineSizedSInt long buttonIndex);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.3.
     */
    @Deprecated
    @Method(selector = "actionSheet:didDismissWithButtonIndex:")
    public native void didDismiss(UIActionSheet actionSheet, @MachineSizedSInt long buttonIndex);
    /*</methods>*/
}
