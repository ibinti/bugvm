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
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("GameKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKMatchmakerViewController/*</name>*/ 
    extends /*<extends>*/UINavigationController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKMatchmakerViewControllerPtr extends Ptr<GKMatchmakerViewController, GKMatchmakerViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKMatchmakerViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKMatchmakerViewController() {}
    protected GKMatchmakerViewController(SkipInit skipInit) { super(skipInit); }
    public GKMatchmakerViewController(GKMatchRequest request) { super((SkipInit) null); initObject(init(request)); }
    public GKMatchmakerViewController(GKInvite invite) { super((SkipInit) null); initObject(init(invite)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "matchmakerDelegate")
    public native GKMatchmakerViewControllerDelegate getMatchmakerDelegate();
    @Property(selector = "setMatchmakerDelegate:", strongRef = true)
    public native void setMatchmakerDelegate(GKMatchmakerViewControllerDelegate v);
    @Property(selector = "matchRequest")
    public native GKMatchRequest getMatchRequest();
    @Property(selector = "isHosted")
    public native boolean isHosted();
    @Property(selector = "setHosted:")
    public native void setHosted(boolean v);
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 7.0.
     */
    @Deprecated
    @Property(selector = "defaultInvitationMessage")
    public native String getDefaultInvitationMessage();
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 7.0.
     */
    @Deprecated
    @Property(selector = "setDefaultInvitationMessage:")
    public native void setDefaultInvitationMessage(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithMatchRequest:")
    protected native @Pointer long init(GKMatchRequest request);
    @Method(selector = "initWithInvite:")
    protected native @Pointer long init(GKInvite invite);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "addPlayersToMatch:")
    public native void addPlayersToMatch(GKMatch match);
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Method(selector = "setHostedPlayer:connected:")
    public native void setHostedPlayer(String playerID, boolean connected);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setHostedPlayer:didConnect:")
    public native void setHostedPlayer(GKPlayer player, boolean connected);
    /*</methods>*/
}
