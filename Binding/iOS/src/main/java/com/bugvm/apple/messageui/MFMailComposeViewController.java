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
package com.bugvm.apple.messageui;

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
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("MessageUI") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MFMailComposeViewController/*</name>*/ 
    extends /*<extends>*/UINavigationController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MFMailComposeViewControllerPtr extends Ptr<MFMailComposeViewController, MFMailComposeViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MFMailComposeViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MFMailComposeViewController() {}
    protected MFMailComposeViewController(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "mailComposeDelegate")
    public native MFMailComposeViewControllerDelegate getMailComposeDelegate();
    @Property(selector = "setMailComposeDelegate:", strongRef = true)
    public native void setMailComposeDelegate(MFMailComposeViewControllerDelegate v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "setSubject:")
    public native void setSubject(String subject);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "setToRecipients:")
    public native void setToRecipients(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> toRecipients);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "setCcRecipients:")
    public native void setCcRecipients(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> ccRecipients);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "setBccRecipients:")
    public native void setBccRecipients(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> bccRecipients);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "setMessageBody:isHTML:")
    public native void setMessageBody(String body, boolean isHTML);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "addAttachmentData:mimeType:fileName:")
    public native void addAttachmentData(NSData attachment, String mimeType, String filename);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "canSendMail")
    public static native boolean canSendMail();
    /*</methods>*/
}
