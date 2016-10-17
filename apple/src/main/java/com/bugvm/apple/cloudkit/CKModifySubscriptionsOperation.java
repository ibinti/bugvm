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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKModifySubscriptionsOperation/*</name>*/ 
    extends /*<extends>*/CKDatabaseOperation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CKModifySubscriptionsOperationPtr extends Ptr<CKModifySubscriptionsOperation, CKModifySubscriptionsOperationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CKModifySubscriptionsOperation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CKModifySubscriptionsOperation() {}
    protected CKModifySubscriptionsOperation(SkipInit skipInit) { super(skipInit); }
    public CKModifySubscriptionsOperation(NSArray<CKSubscription> subscriptionsToSave, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> subscriptionIDsToDelete) { super((SkipInit) null); initObject(init(subscriptionsToSave, subscriptionIDsToDelete)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "subscriptionsToSave")
    public native NSArray<CKSubscription> getSubscriptionsToSave();
    @Property(selector = "setSubscriptionsToSave:")
    public native void setSubscriptionsToSave(NSArray<CKSubscription> v);
    @Property(selector = "subscriptionIDsToDelete")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getSubscriptionIDsToDelete();
    @Property(selector = "setSubscriptionIDsToDelete:")
    public native void setSubscriptionIDsToDelete(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "modifySubscriptionsCompletionBlock")
    public native @Block VoidBlock3<NSArray<CKSubscription>, NSArray<NSString>, NSError> getModifySubscriptionsCompletionBlock();
    @Property(selector = "setModifySubscriptionsCompletionBlock:")
    public native void setModifySubscriptionsCompletionBlock(@Block VoidBlock3<NSArray<CKSubscription>, NSArray<NSString>, NSError> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithSubscriptionsToSave:subscriptionIDsToDelete:")
    protected native @Pointer long init(NSArray<CKSubscription> subscriptionsToSave, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> subscriptionIDsToDelete);
    /*</methods>*/
}
