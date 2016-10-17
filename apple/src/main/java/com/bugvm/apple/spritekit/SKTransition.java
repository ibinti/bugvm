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
package com.bugvm.apple.spritekit;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.avfoundation.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.scenekit.*;
import com.bugvm.apple.gameplaykit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("SpriteKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKTransition/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKTransitionPtr extends Ptr<SKTransition, SKTransitionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKTransition.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKTransition() {}
    protected SKTransition(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public SKTransition(CIFilter filter, double sec) { super(create(filter, sec)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "pausesIncomingScene")
    public native boolean pausesIncomingScene();
    @Property(selector = "setPausesIncomingScene:")
    public native void setPausesIncomingScene(boolean v);
    @Property(selector = "pausesOutgoingScene")
    public native boolean pausesOutgoingScene();
    @Property(selector = "setPausesOutgoingScene:")
    public native void setPausesOutgoingScene(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "crossFadeWithDuration:")
    public static native SKTransition crossFade(double sec);
    @Method(selector = "fadeWithDuration:")
    public static native SKTransition fade(double sec);
    @Method(selector = "fadeWithColor:duration:")
    public static native SKTransition fade(UIColor color, double sec);
    @Method(selector = "flipHorizontalWithDuration:")
    public static native SKTransition flipHorizontal(double sec);
    @Method(selector = "flipVerticalWithDuration:")
    public static native SKTransition flipVertical(double sec);
    @Method(selector = "revealWithDirection:duration:")
    public static native SKTransition reveal(SKTransitionDirection direction, double sec);
    @Method(selector = "moveInWithDirection:duration:")
    public static native SKTransition moveIn(SKTransitionDirection direction, double sec);
    @Method(selector = "pushWithDirection:duration:")
    public static native SKTransition push(SKTransitionDirection direction, double sec);
    @Method(selector = "doorsOpenHorizontalWithDuration:")
    public static native SKTransition doorsOpenHorizontal(double sec);
    @Method(selector = "doorsOpenVerticalWithDuration:")
    public static native SKTransition doorsOpenVertical(double sec);
    @Method(selector = "doorsCloseHorizontalWithDuration:")
    public static native SKTransition doorsCloseHorizontal(double sec);
    @Method(selector = "doorsCloseVerticalWithDuration:")
    public static native SKTransition doorsCloseVertical(double sec);
    @Method(selector = "doorwayWithDuration:")
    public static native SKTransition doorway(double sec);
    @WeaklyLinked
    @Method(selector = "transitionWithCIFilter:duration:")
    protected static native @Pointer long create(CIFilter filter, double sec);
    /*</methods>*/
}
