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
package com.bugvm.apple.networkextension;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("NetworkExtension") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NEEvaluateConnectionRule/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NEEvaluateConnectionRulePtr extends Ptr<NEEvaluateConnectionRule, NEEvaluateConnectionRulePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NEEvaluateConnectionRule.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NEEvaluateConnectionRule() {}
    protected NEEvaluateConnectionRule(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public NEEvaluateConnectionRule(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> domains, NEEvaluateConnectionRuleAction action) { super((SkipInit) null); initObject(init(domains, action)); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "action")
    public native NEEvaluateConnectionRuleAction getAction();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "matchDomains")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getMatchDomains();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "useDNSServers")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getDNSServers();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setUseDNSServers:")
    public native void setDNSServers(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "probeURL")
    public native NSURL getProbeURL();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setProbeURL:")
    public native void setProbeURL(NSURL v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "initWithMatchDomains:andAction:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> domains, NEEvaluateConnectionRuleAction action);
    /*</methods>*/
}
