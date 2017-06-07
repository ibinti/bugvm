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
/*</javadoc>*/
/*<annotations>*/@Library("HealthKit") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/HKCategoryTypeIdentifier/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/HKCategoryTypeIdentifier/*</name>*/ 
    extends /*<extends>*/HKTypeIdentifier/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/HKCategoryTypeIdentifier/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static HKCategoryTypeIdentifier toObject(Class<HKCategoryTypeIdentifier> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return HKCategoryTypeIdentifier.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(HKCategoryTypeIdentifier o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<HKCategoryTypeIdentifier> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<HKCategoryTypeIdentifier> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(HKCategoryTypeIdentifier.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<HKCategoryTypeIdentifier> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (HKCategoryTypeIdentifier o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    public static final HKCategoryTypeIdentifier SleepAnalysis = new HKCategoryTypeIdentifier("SleepAnalysis");
    /*</constants>*/
    
    private static /*<name>*/HKCategoryTypeIdentifier/*</name>*/[] values = new /*<name>*/HKCategoryTypeIdentifier/*</name>*/[] {/*<value_list>*/SleepAnalysis/*</value_list>*/};
    
    /*<name>*/HKCategoryTypeIdentifier/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/HKCategoryTypeIdentifier/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/HKCategoryTypeIdentifier/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/HKCategoryTypeIdentifier/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("HealthKit") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="HKCategoryTypeIdentifierSleepAnalysis", optional=true)
        public static native NSString SleepAnalysis();
        /*</values>*/
    }
}
