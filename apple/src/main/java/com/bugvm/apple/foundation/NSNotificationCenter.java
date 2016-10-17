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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSNotificationCenter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSNotificationCenterPtr extends Ptr<NSNotificationCenter, NSNotificationCenterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSNotificationCenter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSNotificationCenter() {}
    protected NSNotificationCenter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    public void addObserver(NSObject observer, Selector selector, String name, NSObject object) {
        addObserver(observer, selector, new NSString(name), object);
    }
    public void postNotification(String name, NSObject object) {
        postNotification(new NSString(name), object);
    }
    public void postNotification(String name, NSObject object, NSDictionary<?, ?> userInfo) {
        postNotification(new NSString(name), object, userInfo);
    }
    public void postNotification(NSString name, NSObject object, UIRemoteNotification userInfo) {
        postNotification(name, object, userInfo.getDictionary());
    }
    public void postNotification(String name, NSObject object, UIRemoteNotification userInfo) {
        postNotification(new NSString(name), object, userInfo.getDictionary());
    }
    public void postNotification(NSString name, NSObject object, UILocalNotification userInfo) {
        postNotification(name, object, userInfo.getUserInfo());
    }
    public void postNotification(String name, NSObject object, UILocalNotification userInfo) {
        postNotification(new NSString(name), object, userInfo.getUserInfo());
    }
    public void removeObserver(NSObject observer, String name, NSObject object) {
        removeObserver(observer, new NSString(name), object);
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public NSObject addObserver(String name, NSObject object, NSOperationQueue queue, @Block VoidBlock1<NSNotification> block) {
        return addObserver(new NSString(name), object, queue, block);
    }
    /*<methods>*/
    @Method(selector = "addObserver:selector:name:object:")
    public native void addObserver(NSObject observer, Selector aSelector, NSString name, NSObject anObject);
    @Method(selector = "postNotification:")
    public native void postNotification(NSNotification notification);
    @Method(selector = "postNotificationName:object:")
    public native void postNotification(NSString name, NSObject anObject);
    @Method(selector = "postNotificationName:object:userInfo:")
    public native void postNotification(NSString name, NSObject anObject, NSDictionary<?, ?> userInfo);
    @Method(selector = "removeObserver:")
    public native void removeObserver(NSObject observer);
    @Method(selector = "removeObserver:name:object:")
    public native void removeObserver(NSObject observer, NSString name, NSObject anObject);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "addObserverForName:object:queue:usingBlock:")
    public native NSObject addObserver(NSString name, NSObject obj, NSOperationQueue queue, @Block VoidBlock1<NSNotification> block);
    @Method(selector = "defaultCenter")
    public static native NSNotificationCenter getDefaultCenter();
    /*</methods>*/
}
