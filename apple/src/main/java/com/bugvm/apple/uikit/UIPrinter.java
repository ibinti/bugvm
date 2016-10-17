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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIPrinter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIPrinterPtr extends Ptr<UIPrinter, UIPrinterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIPrinter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIPrinter() {}
    protected UIPrinter(SkipInit skipInit) { super(skipInit); }
    public UIPrinter(NSURL url) { super(create(url)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "URL")
    public native NSURL getURL();
    @Property(selector = "displayName")
    public native String getDisplayName();
    @Property(selector = "displayLocation")
    public native String getDisplayLocation();
    @Property(selector = "supportedJobTypes")
    public native UIPrinterJobTypes getSupportedJobTypes();
    @Property(selector = "makeAndModel")
    public native String getMakeAndModel();
    @Property(selector = "supportsColor")
    public native boolean supportsColor();
    @Property(selector = "supportsDuplex")
    public native boolean supportsDuplex();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "contactPrinter:")
    public native void contactPrinter(@Block VoidBooleanBlock completionHandler);
    @Method(selector = "printerWithURL:")
    protected static native @Pointer long create(NSURL url);
    /*</methods>*/
}
