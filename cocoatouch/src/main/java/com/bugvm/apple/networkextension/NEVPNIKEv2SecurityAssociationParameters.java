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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NEVPNIKEv2SecurityAssociationParameters/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NEVPNIKEv2SecurityAssociationParametersPtr extends Ptr<NEVPNIKEv2SecurityAssociationParameters, NEVPNIKEv2SecurityAssociationParametersPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NEVPNIKEv2SecurityAssociationParameters.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NEVPNIKEv2SecurityAssociationParameters() {}
    protected NEVPNIKEv2SecurityAssociationParameters(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "encryptionAlgorithm")
    public native NEVPNIKEv2EncryptionAlgorithm getEncryptionAlgorithm();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setEncryptionAlgorithm:")
    public native void setEncryptionAlgorithm(NEVPNIKEv2EncryptionAlgorithm v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "integrityAlgorithm")
    public native NEVPNIKEv2IntegrityAlgorithm getIntegrityAlgorithm();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setIntegrityAlgorithm:")
    public native void setIntegrityAlgorithm(NEVPNIKEv2IntegrityAlgorithm v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "diffieHellmanGroup")
    public native NEVPNIKEv2DiffieHellmanGroup getDiffieHellmanGroup();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setDiffieHellmanGroup:")
    public native void setDiffieHellmanGroup(NEVPNIKEv2DiffieHellmanGroup v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "lifetimeMinutes")
    public native int getLifetimeMinutes();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setLifetimeMinutes:")
    public native void setLifetimeMinutes(int v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
