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

import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.Selector;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSInvocation/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSInvocationPtr extends Ptr<NSInvocation, NSInvocationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSInvocation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSInvocation() {}
    protected NSInvocation(SkipInit skipInit) { super(skipInit); }
    public NSInvocation(NSMethodSignature sig) { super(create(sig)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "methodSignature")
    public native NSMethodSignature getMethodSignature();
    @Property(selector = "argumentsRetained")
    public native boolean argumentsRetained();
    @Property(selector = "target")
    public native NSObject getTarget();
    @Property(selector = "setTarget:", strongRef = true)
    public native void setTarget(NSObject v);
    @Property(selector = "selector")
    public native Selector getSelector();
    @Property(selector = "setSelector:")
    public native void setSelector(Selector v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "retainArguments")
    public native void retainArguments();
    @Method(selector = "getReturnValue:")
    public native void getReturnValue(VoidPtr retLoc);
    @Method(selector = "setReturnValue:")
    public native void setReturnValue(VoidPtr retLoc);
    @Method(selector = "getArgument:atIndex:")
    public native void getArgument(VoidPtr argumentLocation, @MachineSizedSInt long idx);
    @Method(selector = "setArgument:atIndex:")
    public native void setArgument(VoidPtr argumentLocation, @MachineSizedSInt long idx);
    @Method(selector = "invoke")
    public native void invoke();
    @Method(selector = "invokeWithTarget:")
    public native void invoke(NSObject target);
    @Method(selector = "invocationWithMethodSignature:")
    protected static native @Pointer long create(NSMethodSignature sig);
    /*</methods>*/
}
