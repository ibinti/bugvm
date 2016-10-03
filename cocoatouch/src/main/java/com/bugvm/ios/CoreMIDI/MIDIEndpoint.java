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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIEndpoint/*</name>*/ 
    extends /*<extends>*/MIDIObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIEndpointPtr extends Ptr<MIDIEndpoint, MIDIEndpointPtr> {}/*</ptr>*/
    private static java.util.concurrent.atomic.AtomicLong refconId = new java.util.concurrent.atomic.AtomicLong();
    private static LongMap<com.bugvm.ios.CoreMIDI.MIDIReadProc> readProcs = new LongMap<>();
    private static final java.lang.reflect.Method cbReadProc;
    
    static {
        try {
            cbReadProc = MIDIEndpoint.class.getDeclaredMethod("cbReadProc", com.bugvm.ios.CoreMIDI.MIDIPacketList.class, long.class, long.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(MIDIEndpoint.class); }/*</bind>*/
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
    public com.bugvm.ios.CoreMIDI.MIDIEntity getEntity() {
        com.bugvm.ios.CoreMIDI.MIDIEntity.MIDIEntityPtr ptr = new com.bugvm.ios.CoreMIDI.MIDIEntity.MIDIEntityPtr();
        getEntity(ptr);
        return ptr.get();
    }
    public static MIDIEndpoint createDestination(com.bugvm.ios.CoreMIDI.MIDIClient client, String name, com.bugvm.ios.CoreMIDI.MIDIReadProc readProc) {
        long refconId = MIDIEndpoint.refconId.getAndIncrement();
        MIDIEndpointPtr ptr = new MIDIEndpointPtr();
        com.bugvm.ios.CoreMIDI.MIDIError err = createDestination(client, name, new FunctionPtr(cbReadProc), refconId, ptr);
        if (err == com.bugvm.ios.CoreMIDI.MIDIError.No) {
            synchronized (readProcs) {
                readProcs.put(refconId, readProc);
            }
            return ptr.get();
        }
        return null;
    }
    public static MIDIEndpoint createSource(com.bugvm.ios.CoreMIDI.MIDIClient client, String name) {
        MIDIEndpointPtr ptr = new MIDIEndpointPtr();
        createSource(client, name, ptr);
        return ptr.get();
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIEndpointGetEntity", optional=true)
    protected native com.bugvm.ios.CoreMIDI.MIDIError getEntity(com.bugvm.ios.CoreMIDI.MIDIEntity.MIDIEntityPtr outEntity);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIDestinationCreate", optional=true)
    protected static native com.bugvm.ios.CoreMIDI.MIDIError createDestination(com.bugvm.ios.CoreMIDI.MIDIClient client, String name, FunctionPtr readProc, @Pointer long refCon, MIDIEndpoint.MIDIEndpointPtr outDest);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDISourceCreate", optional=true)
    protected static native com.bugvm.ios.CoreMIDI.MIDIError createSource(com.bugvm.ios.CoreMIDI.MIDIClient client, String name, MIDIEndpoint.MIDIEndpointPtr outSrc);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIEndpointDispose", optional=true)
    public native com.bugvm.ios.CoreMIDI.MIDIError dispose();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIReceived", optional=true)
    public native com.bugvm.ios.CoreMIDI.MIDIError received(com.bugvm.ios.CoreMIDI.MIDIPacketList pktlist);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIEndpointSetRefCons", optional=true)
    protected native com.bugvm.ios.CoreMIDI.MIDIError setRefCons(@Pointer long ref1, @Pointer long ref2);
    /*</methods>*/
}
