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
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIEvent/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIEventPtr extends Ptr<UIEvent, UIEventPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIEvent.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIEvent() {}
    protected UIEvent(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "type")
    public native UIEventType getType();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "subtype")
    public native UIEventSubtype getSubtype();
    @Property(selector = "timestamp")
    public native double getTimestamp();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "allTouches")
    public native NSSet<UITouch> getAllTouches();
    @Method(selector = "touchesForWindow:")
    public native NSSet<UITouch> getTouches(UIWindow window);
    @Method(selector = "touchesForView:")
    public native NSSet<UITouch> getTouches(UIView view);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Method(selector = "touchesForGestureRecognizer:")
    public native NSSet<UITouch> getTouches(UIGestureRecognizer gesture);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "coalescedTouchesForTouch:")
    public native NSArray<UITouch> getCoalescedTouches(UITouch touch);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "predictedTouchesForTouch:")
    public native NSArray<UITouch> getPredictedTouches(UITouch touch);
    /*</methods>*/
}
