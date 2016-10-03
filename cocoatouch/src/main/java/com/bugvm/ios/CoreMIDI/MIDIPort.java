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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIPort/*</name>*/ 
    extends /*<extends>*/MIDIObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIPortPtr extends Ptr<MIDIPort, MIDIPortPtr> {}/*</ptr>*/
    private static java.util.concurrent.atomic.AtomicLong refconId = new java.util.concurrent.atomic.AtomicLong();
    protected long localRefconId;
    private static LongMap<com.bugvm.ios.CoreMIDI.MIDIReadProc> readProcs = new LongMap<>();
    private static final java.lang.reflect.Method cbReadProc;
    
    static {
        try {
            cbReadProc = MIDIPort.class.getDeclaredMethod("cbReadProc", com.bugvm.ios.CoreMIDI.MIDIPacketList.class, long.class, long.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(MIDIPort.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static void cbReadProc(com.bugvm.ios.CoreMIDI.MIDIPacketList pktlist, @Pointer long readProcRefCon, @Pointer long srcConnRefCon) {
        com.bugvm.ios.CoreMIDI.MIDIReadProc callback = null;
        synchronized (readProcs) {
            callback = readProcs.get(readProcRefCon);
        }
        callback.read(pktlist);
    }
    /**
     * @since Available in iOS 4.2 and later.
     */
    public static MIDIPort createInputPort(com.bugvm.ios.CoreMIDI.MIDIClient client, String portName, com.bugvm.ios.CoreMIDI.MIDIReadProc readProc) {
        long refconId = MIDIPort.refconId.getAndIncrement();
        MIDIPortPtr ptr = new MIDIPortPtr();
        com.bugvm.ios.CoreMIDI.MIDIError err = createInputPort(client, portName, new FunctionPtr(cbReadProc), refconId, ptr);
        if (err == com.bugvm.ios.CoreMIDI.MIDIError.No) {
            synchronized (readProcs) {
                readProcs.put(refconId, readProc);
            }
            MIDIPort port = ptr.get();
            port.localRefconId = refconId;
            return port;
        }
        return null;
    }
    /**
     * @since Available in iOS 4.2 and later.
     */
    public static MIDIPort createOutputPort(com.bugvm.ios.CoreMIDI.MIDIClient client, String portName) {
        long refconId = MIDIPort.refconId.getAndIncrement();
        MIDIPortPtr ptr = new MIDIPortPtr();
        createOutputPort(client, portName, ptr);
        MIDIPort port = ptr.get();
        port.localRefconId = refconId;
        return port;
    }
    /**
     * @since Available in iOS 4.2 and later.
     */
    public com.bugvm.ios.CoreMIDI.MIDIError connectSource(com.bugvm.ios.CoreMIDI.MIDIEndpoint source) {
        return connectSource(source, localRefconId);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIInputPortCreate", optional=true)
    protected static native com.bugvm.ios.CoreMIDI.MIDIError createInputPort(com.bugvm.ios.CoreMIDI.MIDIClient client, String portName, FunctionPtr readProc, @Pointer long refCon, MIDIPort.MIDIPortPtr outPort);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIOutputPortCreate", optional=true)
    protected static native com.bugvm.ios.CoreMIDI.MIDIError createOutputPort(com.bugvm.ios.CoreMIDI.MIDIClient client, String portName, MIDIPort.MIDIPortPtr outPort);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIPortDispose", optional=true)
    public native com.bugvm.ios.CoreMIDI.MIDIError dispose();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIPortConnectSource", optional=true)
    protected native com.bugvm.ios.CoreMIDI.MIDIError connectSource(com.bugvm.ios.CoreMIDI.MIDIEndpoint source, @Pointer long connRefCon);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIPortDisconnectSource", optional=true)
    public native com.bugvm.ios.CoreMIDI.MIDIError disconnectSource(com.bugvm.ios.CoreMIDI.MIDIEndpoint source);
    /*</methods>*/
}
