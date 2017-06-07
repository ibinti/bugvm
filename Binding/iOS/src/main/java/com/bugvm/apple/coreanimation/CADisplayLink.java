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
package com.bugvm.apple.coreanimation;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("QuartzCore") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CADisplayLink/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public interface OnUpdateListener {
        void onUpdate(CADisplayLink displayLink);
    }
    
    private static final LongMap<ListenerWrapper> listeners = new LongMap<>();
    private static final Selector handleUpdate = Selector.register("handleUpdate");
    private static class ListenerWrapper extends NSObject {
        private final OnUpdateListener listener;
        private ListenerWrapper(OnUpdateListener listener) {
            this.listener = listener;
        }
        @Method(selector = "handleUpdate")
        private void handleUpdate(CADisplayLink displayLink) {
            listener.onUpdate(displayLink);
        }
    }
    
    /*<ptr>*/public static class CADisplayLinkPtr extends Ptr<CADisplayLink, CADisplayLinkPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CADisplayLink.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CADisplayLink(SkipInit skipInit) { super(skipInit); }
    public CADisplayLink(NSObject target, Selector sel) { super(create(target, sel)); retain(getHandle()); }
    /*</constructors>*/
    public CADisplayLink(OnUpdateListener listener) {
        super(create(listener));
        retain(getHandle());
    }
    
    private static long create(OnUpdateListener listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }
        ListenerWrapper l = new ListenerWrapper(listener);
        long result = create(l, handleUpdate);
        CADisplayLink.listeners.put(result, l);
        return result;
    }
    /*<properties>*/
    @Property(selector = "timestamp")
    public native double getTimestamp();
    @Property(selector = "duration")
    public native double getDuration();
    @Property(selector = "isPaused")
    public native boolean isPaused();
    @Property(selector = "setPaused:")
    public native void setPaused(boolean v);
    @Property(selector = "frameInterval")
    public native @MachineSizedSInt long getFrameInterval();
    @Property(selector = "setFrameInterval:")
    public native void setFrameInterval(@MachineSizedSInt long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    public void addToRunLoop(NSRunLoop runloop, NSRunLoopMode mode) {
        addToRunLoop(runloop, mode.value().toString());
    }
    public void removeFromRunLoop(NSRunLoop runloop, NSRunLoopMode mode) {
        removeFromRunLoop(runloop, mode.value().toString());
    }
    
    @Override
    protected void dispose(boolean finalizing) {
        CADisplayLink.listeners.remove(getHandle());
        super.dispose(finalizing);
    }
    /*<methods>*/
    @Method(selector = "addToRunLoop:forMode:")
    public native void addToRunLoop(NSRunLoop runloop, String mode);
    @Method(selector = "removeFromRunLoop:forMode:")
    public native void removeFromRunLoop(NSRunLoop runloop, String mode);
    @Method(selector = "invalidate")
    public native void invalidate();
    @Method(selector = "displayLinkWithTarget:selector:")
    protected static native @Pointer long create(NSObject target, Selector sel);
    /*</methods>*/
}
