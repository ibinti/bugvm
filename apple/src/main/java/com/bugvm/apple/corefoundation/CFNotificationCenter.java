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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFNotificationCenter/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public interface NotificationCallback {
        void invoke(CFNotificationCenter center, CFType observer, String name, CFType object, NSDictionary<NSString, ?> userInfo);
    }
    
    private static final LongMap<NotificationCallback> callbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbNotification;
    
    static {
        try {
            cbNotification = CFNotificationCenter.class.getDeclaredMethod("cbNotification", CFNotificationCenter.class, CFType.class, String.class, CFType.class, NSDictionary.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<ptr>*/public static class CFNotificationCenterPtr extends Ptr<CFNotificationCenter, CFNotificationCenterPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFNotificationCenter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFNotificationCenter() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static void cbNotification(CFNotificationCenter center, CFType observer, String name, CFType object, NSDictionary<NSString, ?> userInfo) {
        NotificationCallback callback = null;
        synchronized (callbacks) {
            long id = getCallbackIdForNotification(observer, name, object);
            callback = callbacks.get(id);
        }
        // We don't store observer callbacks for every possible combination of observer, name and object.
        // Therefore a callback for the current combination is not registered and will be null.
        if (callback != null) {
            callback.invoke(center, observer, name, object, userInfo);
        }
    }
    
    public void addObserver(CFType observer, NotificationCallback callBack, String name, CFType object, CFNotificationSuspensionBehavior suspensionBehavior) {
        synchronized(callbacks) {
            long id = getCallbackIdForNotification(observer, name, object);
            callbacks.put(id, callBack);
        }
        addObserver(observer, new FunctionPtr(cbNotification), name, object, suspensionBehavior);
    }
    
    private static long getCallbackIdForNotification(CFType observer, String name, CFType object) {
        final int prime = 31;
        long id = name.hashCode();
        if (observer != null) {
            id = id * prime + observer.hash();
        }
        if (object != null) {
            id = id * prime + object.hash();
        }
        return id;
    }
    /*<methods>*/
    @Bridge(symbol="CFNotificationCenterGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    @Bridge(symbol="CFNotificationCenterGetLocalCenter", optional=true)
    public static native CFNotificationCenter getLocalCenter();
    @Bridge(symbol="CFNotificationCenterGetDarwinNotifyCenter", optional=true)
    public static native CFNotificationCenter getDarwinNotifyCenter();
    @Bridge(symbol="CFNotificationCenterAddObserver", optional=true)
    private native void addObserver(CFType observer, FunctionPtr callBack, String name, CFType object, CFNotificationSuspensionBehavior suspensionBehavior);
    @Bridge(symbol="CFNotificationCenterRemoveObserver", optional=true)
    public native void removeObserver(CFType observer, String name, CFType object);
    @Bridge(symbol="CFNotificationCenterRemoveEveryObserver", optional=true)
    public native void removeEveryObserver(CFType observer);
    @Bridge(symbol="CFNotificationCenterPostNotification", optional=true)
    public native void postNotification(String name, CFType object, NSDictionary userInfo, boolean deliverImmediately);
    @Bridge(symbol="CFNotificationCenterPostNotificationWithOptions", optional=true)
    public native void postNotification(String name, CFType object, NSDictionary userInfo, CFNotificationPostingOptions options);
    /*</methods>*/
}
