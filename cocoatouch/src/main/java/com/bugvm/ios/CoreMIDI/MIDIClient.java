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
package com.bugvm.ios.CoreMIDI;

/*<imports>*/

import com.bugvm.objc.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreMIDI")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIClient/*</name>*/ 
    extends /*<extends>*/MIDIObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIClientPtr extends Ptr<MIDIClient, MIDIClientPtr> {}/*</ptr>*/
    private static java.util.concurrent.atomic.AtomicLong refconId = new java.util.concurrent.atomic.AtomicLong();
    private static LongMap<com.bugvm.ios.CoreMIDI.MIDINotifyProc> notifyProcs = new LongMap<>();
    private static final java.lang.reflect.Method cbNotifyProc;
    
    static {
        try {
            cbNotifyProc = MIDIClient.class.getDeclaredMethod("cbNotifyProc", com.bugvm.ios.CoreMIDI.MIDINotification.class, long.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(MIDIClient.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static void cbNotifyProc(com.bugvm.ios.CoreMIDI.MIDINotification message, @Pointer long refCon) {
        com.bugvm.ios.CoreMIDI.MIDINotifyProc callback = null;
        synchronized (notifyProcs) {
            callback = notifyProcs.get(refCon);
        }
        callback.notify(message);
    }
    public static MIDIClient create(String name, com.bugvm.ios.CoreMIDI.MIDINotifyProc notifyProc) {
        long refconId = MIDIClient.refconId.getAndIncrement();
        MIDIClientPtr ptr = new MIDIClientPtr();
        com.bugvm.ios.CoreMIDI.MIDIError err = create(name, new FunctionPtr(cbNotifyProc), refconId, ptr);
        if (err == com.bugvm.ios.CoreMIDI.MIDIError.No) {
            synchronized (notifyProcs) {
                notifyProcs.put(refconId, notifyProc);
            }
            return ptr.get();
        }
        return null;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIClientCreate", optional=true)
    protected static native com.bugvm.ios.CoreMIDI.MIDIError create(String name, FunctionPtr notifyProc, @Pointer long notifyRefCon, MIDIClient.MIDIClientPtr outClient);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIClientDispose", optional=true)
    public native com.bugvm.ios.CoreMIDI.MIDIError dispose();
    /*</methods>*/
}
