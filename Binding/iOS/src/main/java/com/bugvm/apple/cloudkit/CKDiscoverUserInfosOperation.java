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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CloudKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKDiscoverUserInfosOperation/*</name>*/ 
    extends /*<extends>*/CKOperation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CKDiscoverUserInfosOperationPtr extends Ptr<CKDiscoverUserInfosOperation, CKDiscoverUserInfosOperationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CKDiscoverUserInfosOperation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CKDiscoverUserInfosOperation() {}
    protected CKDiscoverUserInfosOperation(SkipInit skipInit) { super(skipInit); }
    public CKDiscoverUserInfosOperation(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> emailAddresses, NSArray<CKRecordID> userRecordIDs) { super((SkipInit) null); initObject(init(emailAddresses, userRecordIDs)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "emailAddresses")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getEmailAddresses();
    @Property(selector = "setEmailAddresses:")
    public native void setEmailAddresses(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "userRecordIDs")
    public native NSArray<CKRecordID> getUserRecordIDs();
    @Property(selector = "setUserRecordIDs:")
    public native void setUserRecordIDs(NSArray<CKRecordID> v);
    @Property(selector = "discoverUserInfosCompletionBlock")
    public native @Block VoidBlock3<NSDictionary<NSString, CKDiscoveredUserInfo>, NSDictionary<CKRecordID, CKDiscoveredUserInfo>, NSError> getDiscoverUserInfosCompletionBlock();
    @Property(selector = "setDiscoverUserInfosCompletionBlock:")
    public native void setDiscoverUserInfosCompletionBlock(@Block VoidBlock3<NSDictionary<NSString, CKDiscoveredUserInfo>, NSDictionary<CKRecordID, CKDiscoveredUserInfo>, NSError> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithEmailAddresses:userRecordIDs:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> emailAddresses, NSArray<CKRecordID> userRecordIDs);
    /*</methods>*/
}
