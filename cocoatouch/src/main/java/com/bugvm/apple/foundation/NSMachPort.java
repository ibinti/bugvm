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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMachPort/*</name>*/ 
    extends /*<extends>*/NSPort/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSMachPortPtr extends Ptr<NSMachPort, NSMachPortPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSMachPort.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMachPort() {}
    protected NSMachPort(SkipInit skipInit) { super(skipInit); }
    public NSMachPort(int machPort) { super((SkipInit) null); initObject(init(machPort)); }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public NSMachPort(int machPort, NSMachPortRights f) { super((SkipInit) null); initObject(init(machPort, f)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "machPort")
    public native int getMachPort();
    /*</properties>*/
    /*<members>*//*</members>*/
    public void scheduleInRunLoop(NSRunLoop aRunLoop, NSRunLoopMode mode) {
        scheduleInRunLoop(aRunLoop, mode.value().toString());
    }
    public void removeFromRunLoop(NSRunLoop aRunLoop, NSRunLoopMode mode) {
        removeFromRunLoop(aRunLoop, mode.value().toString());
    }
    /*<methods>*/
    @Method(selector = "initWithMachPort:")
    protected native @Pointer long init(int machPort);
    @Method(selector = "setDelegate:")
    public native void setDelegate(NSMachPortDelegate anObject);
    @Method(selector = "delegate")
    public native NSMachPortDelegate getMachDelegate();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Method(selector = "initWithMachPort:options:")
    protected native @Pointer long init(int machPort, NSMachPortRights f);
    @Method(selector = "scheduleInRunLoop:forMode:")
    public native void scheduleInRunLoop(NSRunLoop runLoop, String mode);
    @Method(selector = "removeFromRunLoop:forMode:")
    public native void removeFromRunLoop(NSRunLoop runLoop, String mode);
    /*</methods>*/
}
