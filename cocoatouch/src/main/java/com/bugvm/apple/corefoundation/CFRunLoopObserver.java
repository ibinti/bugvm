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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreFoundation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFRunLoopObserver/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFRunLoopObserverPtr extends Ptr<CFRunLoopObserver, CFRunLoopObserverPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFRunLoopObserver.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFRunLoopObserver() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static CFRunLoopObserver create(CFRunLoopActivity activities, boolean repeats, @MachineSizedSInt long order, VoidBlock2<CFRunLoopObserver, CFRunLoopActivity> block) {
        return create(null, activities, repeats, order, block);
    }
    /*<methods>*/
    @Bridge(symbol="CFRunLoopObserverGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFRunLoopObserverCreateWithHandler", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFRunLoopObserver create(CFAllocator allocator, CFRunLoopActivity activities, boolean repeats, @MachineSizedSInt long order, @Block VoidBlock2<CFRunLoopObserver, CFRunLoopActivity> block);
    @Bridge(symbol="CFRunLoopObserverGetActivities", optional=true)
    public native CFRunLoopActivity getActivities();
    @Bridge(symbol="CFRunLoopObserverDoesRepeat", optional=true)
    public native boolean doesRepeat();
    @Bridge(symbol="CFRunLoopObserverGetOrder", optional=true)
    public native @MachineSizedSInt long getOrder();
    @Bridge(symbol="CFRunLoopObserverInvalidate", optional=true)
    public native void invalidate();
    @Bridge(symbol="CFRunLoopObserverIsValid", optional=true)
    public native boolean isValid();
    /*</methods>*/
}
