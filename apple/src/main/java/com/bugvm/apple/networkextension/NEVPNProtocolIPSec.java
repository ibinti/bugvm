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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NEVPNProtocolIPSec/*</name>*/ 
    extends /*<extends>*/NEVPNProtocol/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NEVPNProtocolIPSecPtr extends Ptr<NEVPNProtocolIPSec, NEVPNProtocolIPSecPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NEVPNProtocolIPSec.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NEVPNProtocolIPSec() {}
    protected NEVPNProtocolIPSec(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "authenticationMethod")
    public native NEVPNIKEAuthenticationMethod getAuthenticationMethod();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setAuthenticationMethod:")
    public native void setAuthenticationMethod(NEVPNIKEAuthenticationMethod v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "useExtendedAuthentication")
    public native boolean usesExtendedAuthentication();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setUseExtendedAuthentication:")
    public native void setUsesExtendedAuthentication(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "sharedSecretReference")
    public native NSData getSharedSecretReference();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setSharedSecretReference:")
    public native void setSharedSecretReference(NSData v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "localIdentifier")
    public native String getLocalIdentifier();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setLocalIdentifier:")
    public native void setLocalIdentifier(String v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "remoteIdentifier")
    public native String getRemoteIdentifier();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setRemoteIdentifier:")
    public native void setRemoteIdentifier(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
