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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIDocumentPickerViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIDocumentPickerViewControllerPtr extends Ptr<UIDocumentPickerViewController, UIDocumentPickerViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIDocumentPickerViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIDocumentPickerViewController() {}
    protected UIDocumentPickerViewController(SkipInit skipInit) { super(skipInit); }
    public UIDocumentPickerViewController(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> allowedUTIs, UIDocumentPickerMode mode) { super((SkipInit) null); initObject(init(allowedUTIs, mode)); }
    public UIDocumentPickerViewController(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    public UIDocumentPickerViewController(NSURL url, UIDocumentPickerMode mode) { super((SkipInit) null); initObject(init(url, mode)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native UIDocumentPickerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(UIDocumentPickerDelegate v);
    @Property(selector = "documentPickerMode")
    public native UIDocumentPickerMode getDocumentPickerMode();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithDocumentTypes:inMode:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> allowedUTIs, UIDocumentPickerMode mode);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "initWithURL:inMode:")
    protected native @Pointer long init(NSURL url, UIDocumentPickerMode mode);
    /*</methods>*/
}
