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
package com.bugvm.apple.cloudkit;

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
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.contacts.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CloudKit") @StronglyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKError/*</name>*/ 
    extends /*<extends>*/NSError/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    protected CKError(SkipInit skipInit) {
        super(skipInit);
    }
    
    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(CKError.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    private NSErrorUserInfo userInfo;
    
    /* Convenience methods */
    private NSErrorUserInfo getCachedUserInfo() {
        if (userInfo == null) {
            userInfo = getUserInfo();
        }
        return userInfo;
    }
    
    @Override
    public CKErrorCode getErrorCode() {
        CKErrorCode code = null;
        try {
            code = CKErrorCode.valueOf(getCode());
        } catch (IllegalArgumentException e) {
            // ignore
        }
        return code;
    }
    
    public NSDictionary<?, ?> getPartialErrors() {
        if (getCachedUserInfo().has(CKErrorUserInfoKey.PartialErrorsByItemID)) {
            NSDictionary<?, ?> val = (NSDictionary<?, ?>) getCachedUserInfo().get(CKErrorUserInfoKey.PartialErrorsByItemID);
            return val;
        }
        return null;
    }
    
    public CKRecord getAncestorRecord() {
        if (getCachedUserInfo().has(CKErrorUserInfoKey.AncestorRecord)) {
            CKRecord val = (CKRecord) getCachedUserInfo().get(CKErrorUserInfoKey.AncestorRecord);
            return val;
        }
        return null;
    }
    public CKRecord getServerRecord() {
        if (getCachedUserInfo().has(CKErrorUserInfoKey.ServerRecord)) {
            CKRecord val = (CKRecord) getCachedUserInfo().get(CKErrorUserInfoKey.ServerRecord);
            return val;
        }
        return null;
    }
    public CKRecord getClientRecord() {
        if (getCachedUserInfo().has(CKErrorUserInfoKey.ClientRecord)) {
            CKRecord val = (CKRecord) getCachedUserInfo().get(CKErrorUserInfoKey.ClientRecord);
            return val;
        }
        return null;
    }
    
    public double retriesAfterTime() {
        if (getCachedUserInfo().has(CKErrorUserInfoKey.RetryAfter)) {
            NSNumber val = (NSNumber) getCachedUserInfo().get(CKErrorUserInfoKey.RetryAfter);
            return val.doubleValue();
        }
        return -1;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="CKErrorDomain", optional=true)
    public static native String getClassDomain();
    /*</methods>*/
}
