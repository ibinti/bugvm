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
package com.bugvm.apple.pushkit;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("PushKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PKPushRegistry/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PKPushRegistryPtr extends Ptr<PKPushRegistry, PKPushRegistryPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PKPushRegistry.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PKPushRegistry() {}
    protected PKPushRegistry(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public PKPushRegistry(DispatchQueue queue) { super((SkipInit) null); initObject(init(queue)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native PKPushRegistryDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(PKPushRegistryDelegate v);
    @Property(selector = "desiredPushTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSSet.AsStringSetMarshaler.class) Set<String> getDesiredPushTypes();
    @Property(selector = "setDesiredPushTypes:")
    public native void setDesiredPushTypes(@com.bugvm.rt.bro.annotation.Marshaler(NSSet.AsStringSetMarshaler.class) Set<String> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "pushTokenForType:")
    public native NSData getPushTokenForType(String type);
    @WeaklyLinked
    @Method(selector = "initWithQueue:")
    protected native @Pointer long init(DispatchQueue queue);
    /*</methods>*/
}
