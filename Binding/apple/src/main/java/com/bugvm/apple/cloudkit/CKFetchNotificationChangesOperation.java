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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKFetchNotificationChangesOperation/*</name>*/ 
    extends /*<extends>*/CKOperation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CKFetchNotificationChangesOperationPtr extends Ptr<CKFetchNotificationChangesOperation, CKFetchNotificationChangesOperationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CKFetchNotificationChangesOperation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CKFetchNotificationChangesOperation() {}
    protected CKFetchNotificationChangesOperation(SkipInit skipInit) { super(skipInit); }
    public CKFetchNotificationChangesOperation(CKServerChangeToken previousServerChangeToken) { super((SkipInit) null); initObject(init(previousServerChangeToken)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "previousServerChangeToken")
    public native CKServerChangeToken getPreviousServerChangeToken();
    @Property(selector = "setPreviousServerChangeToken:")
    public native void setPreviousServerChangeToken(CKServerChangeToken v);
    @Property(selector = "resultsLimit")
    public native @MachineSizedUInt long getResultsLimit();
    @Property(selector = "setResultsLimit:")
    public native void setResultsLimit(@MachineSizedUInt long v);
    @Property(selector = "moreComing")
    public native boolean isMoreComing();
    @Property(selector = "notificationChangedBlock")
    public native @Block VoidBlock1<CKNotification> getNotificationChangedBlock();
    @Property(selector = "setNotificationChangedBlock:")
    public native void setNotificationChangedBlock(@Block VoidBlock1<CKNotification> v);
    @Property(selector = "fetchNotificationChangesCompletionBlock")
    public native @Block VoidBlock2<CKServerChangeToken, NSError> getFetchNotificationChangesCompletionBlock();
    @Property(selector = "setFetchNotificationChangesCompletionBlock:")
    public native void setFetchNotificationChangesCompletionBlock(@Block VoidBlock2<CKServerChangeToken, NSError> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithPreviousServerChangeToken:")
    protected native @Pointer long init(CKServerChangeToken previousServerChangeToken);
    /*</methods>*/
}
