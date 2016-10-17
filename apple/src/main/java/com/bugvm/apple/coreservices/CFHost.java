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
package com.bugvm.apple.coreservices;

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
import com.bugvm.apple.corefoundation.*;
/*</imports>*/
import com.bugvm.apple.coremedia.CMBufferQueueCallbacks;
import com.bugvm.apple.coremedia.CMBufferQueueTriggerToken;
import com.bugvm.apple.coremedia.CMTime;

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CFNetwork")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFHost/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFHostPtr extends Ptr<CFHost, CFHostPtr> {}/*</ptr>*/
    
    public interface ClientCallback {
        void invoke(CFHost host, CFHostInfoType infoType, CFStreamError error);
    }
    
    private static final java.util.concurrent.atomic.AtomicLong refconId = new java.util.concurrent.atomic.AtomicLong();
    private long localRefconId;
    private static final LongMap<ClientCallback> callbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbInvoke;
    
    static {
        try {
            cbInvoke = CFHost.class.getDeclaredMethod("cbInvoke", CFHost.class, CFHostInfoType.class, CFStreamError.CFStreamErrorPtr.class, long.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(CFHost.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFHost() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static void cbInvoke(CFHost host, CFHostInfoType infoType, CFStreamError.CFStreamErrorPtr error, @Pointer long refcon) {
        ClientCallback callback = null;
        synchronized (callbacks) {
            callback = callbacks.get(refcon);
        }
        CFStreamError err = null;
        if (error != null) err = error.get();
        callback.invoke(host, infoType, err);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFHost create(String hostname) {
       long refconId = CFHost.refconId.getAndIncrement();
       CFHost host = create(null, hostname);
       if (host != null) host.localRefconId = refconId;
       return host;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFHost create(NSData addr) {
        long refconId = CFHost.refconId.getAndIncrement();
        CFHost host = create(null, addr);
        if (host != null) host.localRefconId = refconId;
        return host;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFHost createCopy(CFHost host) {
        CFHost h = createCopy(null, host);
        if (host != null) h.localRefconId = host.localRefconId;
        return h;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public NSArray<NSData> getAddressing() {
        return getAddressing(null);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public List<String> getNames() {
        return getNames(null);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public NSData getReachability() {
        return getReachability(null);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public void setCallback(ClientCallback callback) {
        CFHostClientContext context = new CFHostClientContext();
        context.setInfo(localRefconId);
        synchronized (callbacks) {
            callbacks.put(localRefconId, callback);
        }
        setCallback(new FunctionPtr(cbInvoke), context);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public NSInputStream createSocketReadStream(int port) {
        NSInputStream.NSInputStreamPtr ptr = new NSInputStream.NSInputStreamPtr();
        createSocketStreamPair(null, this, port, ptr, null);
        return ptr.get();
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public NSOutputStream createSocketWriteStream(int port) {
        NSOutputStream.NSOutputStreamPtr ptr = new NSOutputStream.NSOutputStreamPtr();
        createSocketStreamPair(null, this, port, null, ptr);
        return ptr.get();
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostCreateWithName", optional=true)
    protected static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFHost create(CFAllocator allocator, String hostname);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostCreateWithAddress", optional=true)
    protected static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFHost create(CFAllocator allocator, NSData addr);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostCreateCopy", optional=true)
    protected static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFHost createCopy(CFAllocator alloc, CFHost host);
    /**
     * @since Available in iOS 2.0 and later.
     */
    public boolean startInfoResolution(CFHostInfoType info) throws CFStreamErrorException {
       CFStreamError.CFStreamErrorPtr ptr = new CFStreamError.CFStreamErrorPtr();
       boolean result = startInfoResolution(info, ptr);
       if (ptr.get() != null) { throw new CFStreamErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostStartInfoResolution", optional=true)
    private native boolean startInfoResolution(CFHostInfoType info, CFStreamError.CFStreamErrorPtr error);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostGetAddressing", optional=true)
    public native NSArray<NSData> getAddressing(BooleanPtr hasBeenResolved);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostGetNames", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFArray.AsStringListMarshaler.class) List<String> getNames(BooleanPtr hasBeenResolved);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostGetReachability", optional=true)
    public native NSData getReachability(BooleanPtr hasBeenResolved);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostCancelInfoResolution", optional=true)
    public native void cancelInfoResolution(CFHostInfoType info);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostSetClient", optional=true)
    private native boolean setCallback(FunctionPtr clientCB, CFHostClientContext clientContext);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostScheduleWithRunLoop", optional=true)
    public native void scheduleInRunLoop(CFRunLoop runLoop, String runLoopMode);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHostUnscheduleFromRunLoop", optional=true)
    public native void unscheduleFromRunLoop(CFRunLoop runLoop, String runLoopMode);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFStreamCreatePairWithSocketToCFHost", optional=true)
    private static native void createSocketStreamPair(CFAllocator alloc, CFHost host, int port, NSInputStream.NSInputStreamPtr readStream, NSOutputStream.NSOutputStreamPtr writeStream);
    /*</methods>*/
}
