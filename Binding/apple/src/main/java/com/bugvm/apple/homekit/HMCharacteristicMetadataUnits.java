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
package com.bugvm.apple.homekit;

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
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("HomeKit") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/HMCharacteristicMetadataUnits/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/HMCharacteristicMetadataUnits/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/HMCharacteristicMetadataUnits/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static HMCharacteristicMetadataUnits toObject(Class<HMCharacteristicMetadataUnits> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return HMCharacteristicMetadataUnits.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(HMCharacteristicMetadataUnits o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<HMCharacteristicMetadataUnits> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<HMCharacteristicMetadataUnits> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(HMCharacteristicMetadataUnits.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<HMCharacteristicMetadataUnits> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (HMCharacteristicMetadataUnits o : l) {
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
    public static final HMCharacteristicMetadataUnits Celsius = new HMCharacteristicMetadataUnits("Celsius");
    /**
     * @since Available in iOS 8.0 and later.
     */
    public static final HMCharacteristicMetadataUnits Fahrenheit = new HMCharacteristicMetadataUnits("Fahrenheit");
    /**
     * @since Available in iOS 8.0 and later.
     */
    public static final HMCharacteristicMetadataUnits Percentage = new HMCharacteristicMetadataUnits("Percentage");
    /**
     * @since Available in iOS 8.0 and later.
     */
    public static final HMCharacteristicMetadataUnits ArcDegree = new HMCharacteristicMetadataUnits("ArcDegree");
    /**
     * @since Available in iOS 8.3 and later.
     */
    public static final HMCharacteristicMetadataUnits Seconds = new HMCharacteristicMetadataUnits("Seconds");
    /*</constants>*/
    
    private static /*<name>*/HMCharacteristicMetadataUnits/*</name>*/[] values = new /*<name>*/HMCharacteristicMetadataUnits/*</name>*/[] {/*<value_list>*/Celsius, Fahrenheit, Percentage, ArcDegree, Seconds/*</value_list>*/};
    
    /*<name>*/HMCharacteristicMetadataUnits/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/HMCharacteristicMetadataUnits/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/HMCharacteristicMetadataUnits/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/HMCharacteristicMetadataUnits/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("HomeKit") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="HMCharacteristicMetadataUnitsCelsius", optional=true)
        public static native NSString Celsius();
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="HMCharacteristicMetadataUnitsFahrenheit", optional=true)
        public static native NSString Fahrenheit();
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="HMCharacteristicMetadataUnitsPercentage", optional=true)
        public static native NSString Percentage();
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="HMCharacteristicMetadataUnitsArcDegree", optional=true)
        public static native NSString ArcDegree();
        /**
         * @since Available in iOS 8.3 and later.
         */
        @GlobalValue(symbol="HMCharacteristicMetadataUnitsSeconds", optional=true)
        public static native NSString Seconds();
        /*</values>*/
    }
}
