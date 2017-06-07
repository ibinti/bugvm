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

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CFNetwork")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFProxySupport/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    public interface AutoConfigurationClientCallback {
        void invoke(List<CFProxy> proxyList, NSError error);
    }
    
    private static final java.util.concurrent.atomic.AtomicLong refconId = new java.util.concurrent.atomic.AtomicLong();
    private long localRefconId;
    private static final LongMap<AutoConfigurationClientCallback> callbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbInvoke;
    
    static {
        try {
            cbInvoke = CFProxySupport.class.getDeclaredMethod("cbInvoke", long.class, CFArray.class, NSError.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(CFProxySupport.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static void cbInvoke(@Pointer long refcon, CFArray proxyList0, NSError error) {
        AutoConfigurationClientCallback callback = null;
        synchronized (callbacks) {
            callback = callbacks.get(refcon);
        }
        List<CFProxy> proxyList = new ArrayList<CFProxy>();
        for (int i = 0; i < proxyList0.size(); i++) {
            proxyList.add(new CFProxy(proxyList0.get(i, CFDictionary.class)));
        }
        callback.invoke(proxyList, error);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFRunLoopSource executeProxyAutoConfigurationScript(String proxyAutoConfigurationScript, NSURL targetURL, AutoConfigurationClientCallback callback) {
        long refconId = CFProxySupport.refconId.getAndIncrement();
        CFStreamClientContext context = new CFStreamClientContext();
        context.setInfo(refconId);
        CFRunLoopSource source = executeProxyAutoConfigurationScript(proxyAutoConfigurationScript, targetURL, new FunctionPtr(cbInvoke), context);
        if (source != null) {
            synchronized (callbacks) {
                callbacks.put(refconId, callback);
            }
            return source;
        }
        return null;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFRunLoopSource executeProxyAutoConfigurationURL(NSURL proxyAutoConfigURL, NSURL targetURL, AutoConfigurationClientCallback callback) {
        long refconId = CFProxySupport.refconId.getAndIncrement();
        CFStreamClientContext context = new CFStreamClientContext();
        context.setInfo(refconId);
        CFRunLoopSource source = executeProxyAutoConfigurationURL(proxyAutoConfigURL, targetURL, new FunctionPtr(cbInvoke), context);
        if (source != null) {
            synchronized (callbacks) {
                callbacks.put(refconId, callback);
            }
            return source;
        }
        return null;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetworkCopySystemProxySettings", optional=true)
    public static native CFSystemProxySettings getSystemProxySettings();
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static List<CFProxy> getProxies(String proxyAutoConfigurationScript, NSURL targetURL) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       List<CFProxy> result = getProxies(proxyAutoConfigurationScript, targetURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetworkCopyProxiesForAutoConfigurationScript", optional=true)
    private static native @com.bugvm.rt.bro.annotation.Marshaler(CFProxy.AsListMarshaler.class) List<CFProxy> getProxies(String proxyAutoConfigurationScript, NSURL targetURL, NSError.NSErrorPtr error);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetworkExecuteProxyAutoConfigurationScript", optional=true)
    private static native CFRunLoopSource executeProxyAutoConfigurationScript(String proxyAutoConfigurationScript, NSURL targetURL, FunctionPtr cb, CFStreamClientContext clientContext);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetworkExecuteProxyAutoConfigurationURL", optional=true)
    private static native CFRunLoopSource executeProxyAutoConfigurationURL(NSURL proxyAutoConfigURL, NSURL targetURL, FunctionPtr cb, CFStreamClientContext clientContext);
    /*</methods>*/
}
