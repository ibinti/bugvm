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

import com.bugvm.apple.uikit.UINavigationController;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("GameKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKTurnBasedMatchmakerViewController/*</name>*/ 
    extends /*<extends>*/UINavigationController/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKTurnBasedMatchmakerViewControllerPtr extends Ptr<GKTurnBasedMatchmakerViewController, GKTurnBasedMatchmakerViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKTurnBasedMatchmakerViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKTurnBasedMatchmakerViewController() {}
    protected GKTurnBasedMatchmakerViewController(SkipInit skipInit) { super(skipInit); }
    public GKTurnBasedMatchmakerViewController(GKMatchRequest request) { super((SkipInit) null); initObject(init(request)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "turnBasedMatchmakerDelegate")
    public native GKTurnBasedMatchmakerViewControllerDelegate getTurnBasedMatchmakerDelegate();
    @Property(selector = "setTurnBasedMatchmakerDelegate:", strongRef = true)
    public native void setTurnBasedMatchmakerDelegate(GKTurnBasedMatchmakerViewControllerDelegate v);
    @Property(selector = "showExistingMatches")
    public native boolean showsExistingMatches();
    @Property(selector = "setShowExistingMatches:")
    public native void setShowsExistingMatches(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithMatchRequest:")
    protected native @Pointer long init(GKMatchRequest request);
    /*</methods>*/
}
