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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/HKObjectType/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class HKObjectTypePtr extends Ptr<HKObjectType, HKObjectTypePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(HKObjectType.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public HKObjectType() {}
    protected HKObjectType(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "identifier")
    public native HKTypeIdentifier getIdentifier();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "quantityTypeForIdentifier:")
    public static native HKQuantityType getQuantityType(HKQuantityTypeIdentifier identifier);
    @Method(selector = "categoryTypeForIdentifier:")
    public static native HKCategoryType getCategoryType(HKCategoryTypeIdentifier identifier);
    @Method(selector = "characteristicTypeForIdentifier:")
    public static native HKCharacteristicType getCharacteristicType(HKCharacteristicTypeIdentifier identifier);
    @Method(selector = "correlationTypeForIdentifier:")
    public static native HKCorrelationType getCorrelationType(HKCorrelationTypeIdentifier identifier);
    @Method(selector = "workoutType")
    public static native HKWorkoutType getWorkoutType();
    /*</methods>*/
}
