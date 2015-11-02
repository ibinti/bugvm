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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSPort/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    public static class Notifications {
        public static NSObject observeDidBecomeInvalid(NSPort object, final VoidBlock1<NSPort> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(DidBecomeInvalidNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((NSPort) a.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class NSPortPtr extends Ptr<NSPort, NSPortPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSPort.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSPort() {}
    protected NSPort(SkipInit skipInit) { super(skipInit); }
    public NSPort(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isValid")
    public native boolean isValid();
    @Property(selector = "reservedSpaceLength")
    public native @MachineSizedUInt long getReservedSpaceLength();
    /*</properties>*/
    /*<members>*//*</members>*/
    public void scheduleInRunLoop(NSRunLoop runLoop, NSRunLoopMode mode) {
        scheduleInRunLoop(runLoop, mode.value().toString());
    }
    public void removeFromRunLoop(NSRunLoop runLoop, NSRunLoopMode mode) {
        removeFromRunLoop(runLoop, mode.value().toString());
    }
    /*<methods>*/
    @GlobalValue(symbol="NSPortDidBecomeInvalidNotification", optional=true)
    public static native NSString DidBecomeInvalidNotification();
    
    @Method(selector = "invalidate")
    public native void invalidate();
    @Method(selector = "setDelegate:")
    public native void setDelegate(NSPortDelegate anObject);
    @Method(selector = "delegate")
    public native NSPortDelegate getDelegate();
    @Method(selector = "scheduleInRunLoop:forMode:")
    public native void scheduleInRunLoop(NSRunLoop runLoop, String mode);
    @Method(selector = "removeFromRunLoop:forMode:")
    public native void removeFromRunLoop(NSRunLoop runLoop, String mode);
    @Method(selector = "sendBeforeDate:components:from:reserved:")
    public native boolean send(NSDate limitDate, NSMutableArray<?> components, NSPort receivePort, @MachineSizedUInt long headerSpaceReserved);
    @Method(selector = "sendBeforeDate:msgid:components:from:reserved:")
    public native boolean send(NSDate limitDate, @MachineSizedUInt long msgID, NSMutableArray<?> components, NSPort receivePort, @MachineSizedUInt long headerSpaceReserved);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
