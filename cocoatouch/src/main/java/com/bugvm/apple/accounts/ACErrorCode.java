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

/*</javadoc>*/
@ForceLinkClass(ACError.class)
/*<annotations>*//*</annotations>*/
public enum /*<name>*/ACErrorCode/*</name>*/ implements NSErrorCode {
    /*<values>*/
    Unknown(1L),
    AccountMissingRequiredProperty(2L),
    AccountAuthenticationFailed(3L),
    AccountTypeInvalid(4L),
    AccountAlreadyExists(5L),
    AccountNotFound(6L),
    PermissionDenied(7L),
    AccessInfoInvalid(8L),
    ClientPermissionDenied(9L),
    AccessDeniedByProtectionPolicy(10L),
    CredentialNotFound(11L),
    FetchCredentialFailed(12L),
    StoreCredentialFailed(13L),
    RemoveCredentialFailed(14L),
    UpdatingNonexistentAccount(15L),
    InvalidClientBundleID(16L),
    DeniedByPlugin(17L),
    CoreDataSaveFailed(18L),
    FailedSerializingAccountInfo(19L),
    InvalidCommand(20L),
    MissingTransportMessageID(21L),
    CredentialItemNotFound(22L),
    CredentialItemNotExpired(23L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/ACErrorCode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/ACErrorCode/*</name>*/ valueOf(long n) {
        for (/*<name>*/ACErrorCode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/ACErrorCode/*</name>*/.class.getName());
    }
}
