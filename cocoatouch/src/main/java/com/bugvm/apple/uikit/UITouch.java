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
import com.bugvm.rt.annotation.WeaklyLinked;
import com.bugvm.apple.spritekit.SKNode;

/*<javadoc>*/
/**
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITouch/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UITouchPtr extends Ptr<UITouch, UITouchPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UITouch.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UITouch() {}
    protected UITouch(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "timestamp")
    public native double getTimestamp();
    @Property(selector = "phase")
    public native UITouchPhase getPhase();
    @Property(selector = "tapCount")
    public native @MachineSizedUInt long getTapCount();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "majorRadius")
    public native @MachineSizedFloat double getMajorRadius();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "majorRadiusTolerance")
    public native @MachineSizedFloat double getMajorRadiusTolerance();
    @Property(selector = "window")
    public native UIWindow getWindow();
    @Property(selector = "view")
    public native UIView getView();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Property(selector = "gestureRecognizers")
    public native NSArray<UIGestureRecognizer> getGestureRecognizers();
    /*</properties>*/
    /*<members>*//*</members>*/
    
    /* SpriteKit extensions */
    @WeaklyLinked
    public CGPoint getLocationInNode(SKNode node) {
        return com.bugvm.apple.spritekit.UITouchExtensions.getLocationInNode(this, node);
    }
    @WeaklyLinked
    public CGPoint getPreviousLocationInNode(SKNode node) {
        return com.bugvm.apple.spritekit.UITouchExtensions.getPreviousLocationInNode(this, node);
    }
    
    /*<methods>*/
    @Method(selector = "locationInView:")
    public native @ByVal CGPoint getLocationInView(UIView view);
    @Method(selector = "previousLocationInView:")
    public native @ByVal CGPoint getPreviousLocationInView(UIView view);
    /*</methods>*/
}
