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
package com.bugvm.apple.gamekit;

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
/**
 * @since Available in iOS 4.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("GameKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKFriendRequestComposeViewController/*</name>*/ 
    extends /*<extends>*/UINavigationController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKFriendRequestComposeViewControllerPtr extends Ptr<GKFriendRequestComposeViewController, GKFriendRequestComposeViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKFriendRequestComposeViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKFriendRequestComposeViewController() {}
    protected GKFriendRequestComposeViewController(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "composeViewDelegate")
    public native GKFriendRequestComposeViewControllerDelegate getComposeViewDelegate();
    @Property(selector = "setComposeViewDelegate:", strongRef = true)
    public native void setComposeViewDelegate(GKFriendRequestComposeViewControllerDelegate v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "setMessage:")
    public native void setMessage(String message);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "addRecipientPlayers:")
    public native void addRecipientPlayers(NSArray<GKPlayer> players);
    /**
     * @since Available in iOS 4.2 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Method(selector = "addRecipientsWithPlayerIDs:")
    public native void addRecipientsWithPlayerIDs(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> playerIDs);
    @Method(selector = "addRecipientsWithEmailAddresses:")
    public native void addRecipientsWithEmailAddresses(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> emailAddresses);
    @Method(selector = "maxNumberOfRecipients")
    public static native @MachineSizedUInt long getMaxNumberOfRecipients();
    /*</methods>*/
}
