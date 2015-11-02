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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CKFetchRecordsOperation/*</name>*/ 
    extends /*<extends>*/CKDatabaseOperation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CKFetchRecordsOperationPtr extends Ptr<CKFetchRecordsOperation, CKFetchRecordsOperationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CKFetchRecordsOperation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CKFetchRecordsOperation() {}
    protected CKFetchRecordsOperation(SkipInit skipInit) { super(skipInit); }
    public CKFetchRecordsOperation(NSArray<CKRecordID> recordIDs) { super((SkipInit) null); initObject(init(recordIDs)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "recordIDs")
    public native NSArray<CKRecordID> getRecordIDs();
    @Property(selector = "setRecordIDs:")
    public native void setRecordIDs(NSArray<CKRecordID> v);
    @Property(selector = "desiredKeys")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getDesiredKeys();
    @Property(selector = "setDesiredKeys:")
    public native void setDesiredKeys(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "perRecordProgressBlock")
    public native @Block VoidBlock2<CKRecordID, Double> getPerRecordProgressBlock();
    @Property(selector = "setPerRecordProgressBlock:")
    public native void setPerRecordProgressBlock(@Block VoidBlock2<CKRecordID, Double> v);
    @Property(selector = "perRecordCompletionBlock")
    public native @Block VoidBlock3<CKRecord, CKRecordID, NSError> getPerRecordCompletionBlock();
    @Property(selector = "setPerRecordCompletionBlock:")
    public native void setPerRecordCompletionBlock(@Block VoidBlock3<CKRecord, CKRecordID, NSError> v);
    @Property(selector = "fetchRecordsCompletionBlock")
    public native @Block VoidBlock2<NSDictionary<CKRecordID, CKRecord>, NSError> getFetchRecordsCompletionBlock();
    @Property(selector = "setFetchRecordsCompletionBlock:")
    public native void setFetchRecordsCompletionBlock(@Block VoidBlock2<NSDictionary<CKRecordID, CKRecord>, NSError> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithRecordIDs:")
    protected native @Pointer long init(NSArray<CKRecordID> recordIDs);
    @Method(selector = "fetchCurrentUserRecordOperation")
    public static native CKFetchRecordsOperation createFetchCurrentUserRecordOperation();
    /*</methods>*/
}
