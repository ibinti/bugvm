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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSNotificationQueue/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSNotificationQueuePtr extends Ptr<NSNotificationQueue, NSNotificationQueuePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSNotificationQueue.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected NSNotificationQueue(SkipInit skipInit) { super(skipInit); }
    public NSNotificationQueue(NSNotificationCenter notificationCenter) { super((SkipInit) null); initObject(init(notificationCenter)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    public void enqueueNotification(NSNotification notification, NSPostingStyle postingStyle, NSNotificationCoalescing coalesceMask, NSRunLoopMode...modes) {
        List<String> list = new ArrayList<>();
        for (NSRunLoopMode mode : modes) {
            list.add(mode.value().toString());
        }
        enqueueNotification(notification, postingStyle, coalesceMask, list);
    }
    /*<methods>*/
    @Method(selector = "initWithNotificationCenter:")
    protected native @Pointer long init(NSNotificationCenter notificationCenter);
    @Method(selector = "enqueueNotification:postingStyle:")
    public native void enqueueNotification(NSNotification notification, NSPostingStyle postingStyle);
    @Method(selector = "enqueueNotification:postingStyle:coalesceMask:forModes:")
    public native void enqueueNotification(NSNotification notification, NSPostingStyle postingStyle, NSNotificationCoalescing coalesceMask, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> modes);
    @Method(selector = "dequeueNotificationsMatching:coalesceMask:")
    public native void dequeueNotificationsMatching(NSNotification notification, NSNotificationCoalescing coalesceMask);
    @Method(selector = "defaultQueue")
    public static native NSNotificationQueue getDefaultQueue();
    /*</methods>*/
}
