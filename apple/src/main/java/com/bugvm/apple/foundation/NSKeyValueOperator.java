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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/NSKeyValueOperator/*</name>*/.Marshaler.class)
/*<visibility>*/public final/*</visibility>*/ class /*<name>*/NSKeyValueOperator/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/NSKeyValueOperator/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static NSKeyValueOperator toObject(Class<NSKeyValueOperator> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return NSKeyValueOperator.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(NSKeyValueOperator o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<NSKeyValueOperator> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<NSKeyValueOperator> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(NSKeyValueOperator.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<NSKeyValueOperator> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (NSKeyValueOperator o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    public static final NSKeyValueOperator Average = new NSKeyValueOperator("Average");
    public static final NSKeyValueOperator Count = new NSKeyValueOperator("Count");
    public static final NSKeyValueOperator DistinctUnionOfArrays = new NSKeyValueOperator("DistinctUnionOfArrays");
    public static final NSKeyValueOperator DistinctUnionOfObjects = new NSKeyValueOperator("DistinctUnionOfObjects");
    public static final NSKeyValueOperator DistinctUnionOfSets = new NSKeyValueOperator("DistinctUnionOfSets");
    public static final NSKeyValueOperator Maximum = new NSKeyValueOperator("Maximum");
    public static final NSKeyValueOperator Minimum = new NSKeyValueOperator("Minimum");
    public static final NSKeyValueOperator Sum = new NSKeyValueOperator("Sum");
    public static final NSKeyValueOperator UnionOfArrays = new NSKeyValueOperator("UnionOfArrays");
    public static final NSKeyValueOperator UnionOfObjects = new NSKeyValueOperator("UnionOfObjects");
    public static final NSKeyValueOperator UnionOfSets = new NSKeyValueOperator("UnionOfSets");
    /*</constants>*/
    
    private static /*<name>*/NSKeyValueOperator/*</name>*/[] values = new /*<name>*/NSKeyValueOperator/*</name>*/[] {/*<value_list>*/Average, Count, DistinctUnionOfArrays, DistinctUnionOfObjects, DistinctUnionOfSets, Maximum, Minimum, Sum, UnionOfArrays, UnionOfObjects, UnionOfSets/*</value_list>*/};
    
    /*<name>*/NSKeyValueOperator/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/NSKeyValueOperator/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/NSKeyValueOperator/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/NSKeyValueOperator/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("Foundation") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        @GlobalValue(symbol="NSAverageKeyValueOperator", optional=true)
        public static native NSString Average();
        @GlobalValue(symbol="NSCountKeyValueOperator", optional=true)
        public static native NSString Count();
        @GlobalValue(symbol="NSDistinctUnionOfArraysKeyValueOperator", optional=true)
        public static native NSString DistinctUnionOfArrays();
        @GlobalValue(symbol="NSDistinctUnionOfObjectsKeyValueOperator", optional=true)
        public static native NSString DistinctUnionOfObjects();
        @GlobalValue(symbol="NSDistinctUnionOfSetsKeyValueOperator", optional=true)
        public static native NSString DistinctUnionOfSets();
        @GlobalValue(symbol="NSMaximumKeyValueOperator", optional=true)
        public static native NSString Maximum();
        @GlobalValue(symbol="NSMinimumKeyValueOperator", optional=true)
        public static native NSString Minimum();
        @GlobalValue(symbol="NSSumKeyValueOperator", optional=true)
        public static native NSString Sum();
        @GlobalValue(symbol="NSUnionOfArraysKeyValueOperator", optional=true)
        public static native NSString UnionOfArrays();
        @GlobalValue(symbol="NSUnionOfObjectsKeyValueOperator", optional=true)
        public static native NSString UnionOfObjects();
        @GlobalValue(symbol="NSUnionOfSetsKeyValueOperator", optional=true)
        public static native NSString UnionOfSets();
        /*</values>*/
    }
}
