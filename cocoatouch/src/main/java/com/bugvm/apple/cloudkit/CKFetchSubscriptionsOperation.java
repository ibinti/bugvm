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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKFetchSubscriptionsOperation/*</name>*/ 
    extends /*<extends>*/CKDatabaseOperation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CKFetchSubscriptionsOperationPtr extends Ptr<CKFetchSubscriptionsOperation, CKFetchSubscriptionsOperationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CKFetchSubscriptionsOperation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CKFetchSubscriptionsOperation() {}
    protected CKFetchSubscriptionsOperation(SkipInit skipInit) { super(skipInit); }
    public CKFetchSubscriptionsOperation(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> subscriptionIDs) { super((SkipInit) null); initObject(init(subscriptionIDs)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "subscriptionIDs")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getSubscriptionIDs();
    @Property(selector = "setSubscriptionIDs:")
    public native void setSubscriptionIDs(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "fetchSubscriptionCompletionBlock")
    public native @Block VoidBlock2<NSDictionary<NSString, CKSubscription>, NSError> getFetchSubscriptionCompletionBlock();
    @Property(selector = "setFetchSubscriptionCompletionBlock:")
    public native void setFetchSubscriptionCompletionBlock(@Block VoidBlock2<NSDictionary<NSString, CKSubscription>, NSError> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithSubscriptionIDs:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> subscriptionIDs);
    @Method(selector = "fetchAllSubscriptionsOperation")
    public static native CKFetchSubscriptionsOperation createFetchAllSubscriptionsOperation();
    /*</methods>*/
}
