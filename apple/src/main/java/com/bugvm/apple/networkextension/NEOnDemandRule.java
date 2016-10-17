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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NEOnDemandRule/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NEOnDemandRulePtr extends Ptr<NEOnDemandRule, NEOnDemandRulePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NEOnDemandRule.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NEOnDemandRule() {}
    protected NEOnDemandRule(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "action")
    public native NEOnDemandRuleAction getAction();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "DNSSearchDomainMatch")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getDNSSearchDomainMatch();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setDNSSearchDomainMatch:")
    public native void setDNSSearchDomainMatch(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "DNSServerAddressMatch")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getDNSServerAddressMatch();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setDNSServerAddressMatch:")
    public native void setDNSServerAddressMatch(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "interfaceTypeMatch")
    public native NEOnDemandRuleInterfaceType getInterfaceTypeMatch();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setInterfaceTypeMatch:")
    public native void setInterfaceTypeMatch(NEOnDemandRuleInterfaceType v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "SSIDMatch")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getSSIDMatch();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setSSIDMatch:")
    public native void setSSIDMatch(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
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
    
    /*</methods>*/
}
