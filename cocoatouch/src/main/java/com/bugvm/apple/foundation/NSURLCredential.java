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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSURLCredential/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSURLCredentialPtr extends Ptr<NSURLCredential, NSURLCredentialPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSURLCredential.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSURLCredential() {}
    protected NSURLCredential(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public NSURLCredential(String user, String password, NSURLCredentialPersistence persistence) { super((SkipInit) null); initObject(init(user, password, persistence)); }
    /**
     * @since Available in iOS 3.0 and later.
     */
    @WeaklyLinked
    public NSURLCredential(SecIdentity identity, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<SecCertificate> certArray, NSURLCredentialPersistence persistence) { super((SkipInit) null); initObject(init(identity, certArray, persistence)); }
    /**
     * @since Available in iOS 3.0 and later.
     */
    @WeaklyLinked
    public NSURLCredential(SecTrust trust) { super((SkipInit) null); initObject(init(trust)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "persistence")
    public native NSURLCredentialPersistence getPersistence();
    @Property(selector = "user")
    public native String getUser();
    @Property(selector = "password")
    public native String getPassword();
    @Property(selector = "hasPassword")
    public native boolean hasPassword();
    @WeaklyLinked
    @Property(selector = "identity")
    public native SecIdentity getIdentity();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "certificates")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<SecCertificate> getCertificates();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "initWithUser:password:persistence:")
    protected native @Pointer long init(String user, String password, NSURLCredentialPersistence persistence);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "initWithIdentity:certificates:persistence:")
    protected native @Pointer long init(SecIdentity identity, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<SecCertificate> certArray, NSURLCredentialPersistence persistence);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "initWithTrust:")
    protected native @Pointer long init(SecTrust trust);
    /*</methods>*/
}
