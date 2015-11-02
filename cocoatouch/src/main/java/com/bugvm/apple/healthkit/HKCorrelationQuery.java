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
package com.bugvm.apple.healthkit;

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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("HealthKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/HKCorrelationQuery/*</name>*/ 
    extends /*<extends>*/HKQuery/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class HKCorrelationQueryPtr extends Ptr<HKCorrelationQuery, HKCorrelationQueryPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(HKCorrelationQuery.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public HKCorrelationQuery() {}
    protected HKCorrelationQuery(SkipInit skipInit) { super(skipInit); }
    public HKCorrelationQuery(HKCorrelationType correlationType, NSPredicate predicate, NSDictionary<HKSampleType, NSPredicate> samplePredicates, @Block VoidBlock3<HKCorrelationQuery, NSArray<HKCorrelation>, NSError> completion) { super((SkipInit) null); initObject(init(correlationType, predicate, samplePredicates, completion)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "correlationType")
    public native HKCorrelationType getCorrelationType();
    @Property(selector = "samplePredicates")
    public native NSDictionary<HKSampleType, NSPredicate> getSamplePredicates();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithType:predicate:samplePredicates:completion:")
    protected native @Pointer long init(HKCorrelationType correlationType, NSPredicate predicate, NSDictionary<HKSampleType, NSPredicate> samplePredicates, @Block VoidBlock3<HKCorrelationQuery, NSArray<HKCorrelation>, NSError> completion);
    /*</methods>*/
}
