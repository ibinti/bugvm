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
package com.bugvm.apple.coredata;

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
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreData") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSConstraintConflict/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSConstraintConflictPtr extends Ptr<NSConstraintConflict, NSConstraintConflictPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSConstraintConflict.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSConstraintConflict() {}
    protected NSConstraintConflict(SkipInit skipInit) { super(skipInit); }
    public NSConstraintConflict(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> constraint, NSManagedObject databaseObject, NSDictionary<?, ?> databaseSnapshot, NSArray<NSManagedObject> conflictingObjects, NSArray<NSDictionary> conflictingSnapshots) { super((SkipInit) null); initObject(init(constraint, databaseObject, databaseSnapshot, conflictingObjects, conflictingSnapshots)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "constraint")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getConstraint();
    @Property(selector = "constraintValues")
    public native NSDictionary<?, ?> getConstraintValues();
    @Property(selector = "databaseObject")
    public native NSManagedObject getDatabaseObject();
    @Property(selector = "databaseSnapshot")
    public native NSDictionary<?, ?> getDatabaseSnapshot();
    @Property(selector = "conflictingObjects")
    public native NSArray<NSManagedObject> getConflictingObjects();
    @Property(selector = "conflictingSnapshots")
    public native NSArray<NSDictionary> getConflictingSnapshots();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithConstraint:databaseObject:databaseSnapshot:conflictingObjects:conflictingSnapshots:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> constraint, NSManagedObject databaseObject, NSDictionary<?, ?> databaseSnapshot, NSArray<NSManagedObject> conflictingObjects, NSArray<NSDictionary> conflictingSnapshots);
    /*</methods>*/
}
