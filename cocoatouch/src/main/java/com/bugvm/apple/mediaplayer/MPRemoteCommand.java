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
package com.bugvm.apple.mediaplayer;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 7.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPRemoteCommand/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPRemoteCommandPtr extends Ptr<MPRemoteCommand, MPRemoteCommandPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPRemoteCommand.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    
    public interface OnCommandListener {
        void onCommand(MPRemoteCommandEvent event);
    }
    
    private Set<ListenerWrapper> listeners = new HashSet<>();
    
    private static final Selector handleCommand = Selector.register("handleCommand");
    private static class ListenerWrapper extends NSObject {
        private final OnCommandListener listener;
        private ListenerWrapper(OnCommandListener listener) {
            this.listener = listener;
        }
        @Method(selector = "handleCommand")
        private void handleCommand(MPRemoteCommandEvent event) {
            listener.onCommand(event);
        }
    }
    
    /*<constructors>*/
    public MPRemoteCommand() {}
    protected MPRemoteCommand(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isEnabled")
    public native boolean isEnabled();
    @Property(selector = "setEnabled:")
    public native void setEnabled(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    public void addListener(OnCommandListener listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }
        ListenerWrapper wrapper = new ListenerWrapper(listener);
        addTarget(wrapper, handleCommand);
        addStrongRef(wrapper);
        synchronized (listeners) {
            listeners.add(wrapper);
        }
    }
    public void removeListener(OnCommandListener listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }
        synchronized (listeners) {
            ListenerWrapper l = null;
            for (ListenerWrapper wrapper : listeners) {
                if (wrapper.listener == listener) {
                    removeTarget(wrapper, handleCommand);
                    l = wrapper;
                    break;
                }
            }
            if (l != null) {
                listeners.remove(l);
                removeStrongRef(l);
            }
        }
    }
    /*<methods>*/
    @Method(selector = "addTarget:action:")
    public native void addTarget(NSObject target, Selector action);
    @Method(selector = "removeTarget:action:")
    public native void removeTarget(NSObject target, Selector action);
    @Method(selector = "removeTarget:")
    public native void removeTarget(NSObject target);
    @Method(selector = "addTargetWithHandler:")
    public native NSObject addTarget(@Block Block1<MPRemoteCommandEvent, MPRemoteCommandHandlerStatus> handler);
    /*</methods>*/
}
