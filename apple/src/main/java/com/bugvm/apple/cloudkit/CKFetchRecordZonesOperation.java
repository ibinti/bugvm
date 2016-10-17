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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKFetchRecordZonesOperation/*</name>*/ 
    extends /*<extends>*/CKDatabaseOperation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CKFetchRecordZonesOperationPtr extends Ptr<CKFetchRecordZonesOperation, CKFetchRecordZonesOperationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CKFetchRecordZonesOperation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CKFetchRecordZonesOperation() {}
    protected CKFetchRecordZonesOperation(SkipInit skipInit) { super(skipInit); }
    public CKFetchRecordZonesOperation(NSArray<CKRecordZoneID> zoneIDs) { super((SkipInit) null); initObject(init(zoneIDs)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "recordZoneIDs")
    public native NSArray<CKRecordZoneID> getRecordZoneIDs();
    @Property(selector = "setRecordZoneIDs:")
    public native void setRecordZoneIDs(NSArray<CKRecordZoneID> v);
    @Property(selector = "fetchRecordZonesCompletionBlock")
    public native @Block VoidBlock2<NSDictionary<CKRecordZoneID, CKRecordZone>, NSError> getFetchRecordZonesCompletionBlock();
    @Property(selector = "setFetchRecordZonesCompletionBlock:")
    public native void setFetchRecordZonesCompletionBlock(@Block VoidBlock2<NSDictionary<CKRecordZoneID, CKRecordZone>, NSError> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithRecordZoneIDs:")
    protected native @Pointer long init(NSArray<CKRecordZoneID> zoneIDs);
    @Method(selector = "fetchAllRecordZonesOperation")
    public static native CKFetchRecordZonesOperation createFetchAllRecordZonesOperation();
    /*</methods>*/
}
