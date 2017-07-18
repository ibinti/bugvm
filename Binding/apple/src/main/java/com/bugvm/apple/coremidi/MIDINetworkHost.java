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
package com.bugvm.apple.coremidi;

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
/**
 * @since Available in iOS 4.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreMIDI") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDINetworkHost/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDINetworkHostPtr extends Ptr<MIDINetworkHost, MIDINetworkHostPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MIDINetworkHost.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MIDINetworkHost() {}
    protected MIDINetworkHost(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "address")
    public native String getAddress();
    @Property(selector = "port")
    public native @MachineSizedUInt long getPort();
    @Property(selector = "netServiceName")
    public native String getNetServiceName();
    @Property(selector = "netServiceDomain")
    public native String getNetServiceDomain();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "hasSameAddressAs:")
    public native boolean hasSameAddressAs(MIDINetworkHost other);
    @Method(selector = "hostWithName:address:port:")
    public static native MIDINetworkHost create(String name, String address, @MachineSizedUInt long port);
    @Method(selector = "hostWithName:netService:")
    public static native MIDINetworkHost create(String name, NSNetService netService);
    @Method(selector = "hostWithName:netServiceName:netServiceDomain:")
    public static native MIDINetworkHost create(String name, String netServiceName, String netServiceDomain);
    /*</methods>*/
}
