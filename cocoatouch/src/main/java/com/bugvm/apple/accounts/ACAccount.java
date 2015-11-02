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
package com.bugvm.apple.accounts;

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
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Accounts") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ACAccount/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class ACAccountPtr extends Ptr<ACAccount, ACAccountPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(ACAccount.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public ACAccount() {}
    protected ACAccount(SkipInit skipInit) { super(skipInit); }
    public ACAccount(ACAccountType type) { super((SkipInit) null); initObject(init(type)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "identifier")
    public native String getIdentifier();
    @Property(selector = "accountType")
    public native ACAccountType getAccountType();
    @Property(selector = "setAccountType:")
    public native void setAccountType(ACAccountType v);
    @Property(selector = "accountDescription")
    public native String getAccountDescription();
    @Property(selector = "setAccountDescription:")
    public native void setAccountDescription(String v);
    @Property(selector = "username")
    public native String getUsername();
    @Property(selector = "setUsername:")
    public native void setUsername(String v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "userFullName")
    public native String getUserFullName();
    @Property(selector = "credential")
    public native ACAccountCredential getCredential();
    @Property(selector = "setCredential:")
    public native void setCredential(ACAccountCredential v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAccountType:")
    protected native @Pointer long init(ACAccountType type);
    /*</methods>*/
}
