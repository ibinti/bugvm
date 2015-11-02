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
package com.bugvm.apple.social;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.accounts.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Social") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SLComposeViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SLComposeViewControllerPtr extends Ptr<SLComposeViewController, SLComposeViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SLComposeViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SLComposeViewController() {}
    protected SLComposeViewController(SkipInit skipInit) { super(skipInit); }
    public SLComposeViewController(SLServiceType serviceType) { super(create(serviceType)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "serviceType")
    public native SLServiceType getServiceType();
    @Property(selector = "completionHandler")
    public native @Block VoidBlock1<SLComposeViewControllerResult> getCompletionHandler();
    @Property(selector = "setCompletionHandler:")
    public native void setCompletionHandler(@Block VoidBlock1<SLComposeViewControllerResult> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "setInitialText:")
    public native boolean setInitialText(String text);
    @Method(selector = "addImage:")
    public native boolean addImage(UIImage image);
    @Method(selector = "removeAllImages")
    public native boolean removeAllImages();
    @Method(selector = "addURL:")
    public native boolean addURL(NSURL url);
    @Method(selector = "removeAllURLs")
    public native boolean removeAllURLs();
    @Method(selector = "isAvailableForServiceType:")
    public static native boolean isAvailable(SLServiceType serviceType);
    @Method(selector = "composeViewControllerForServiceType:")
    protected static native @Pointer long create(SLServiceType serviceType);
    /*</methods>*/
}
