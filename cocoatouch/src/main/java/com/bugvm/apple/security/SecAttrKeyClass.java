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
package com.bugvm.apple.security;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("Security") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/SecAttrKeyClass/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SecAttrKeyClass/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<CFType>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/SecAttrKeyClass/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static SecAttrKeyClass toObject(Class<SecAttrKeyClass> cls, long handle, long flags) {
            CFType o = (CFType) CFType.Marshaler.toObject(CFType.class, handle, flags);
            if (o == null) {
                return null;
            }
            return SecAttrKeyClass.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(SecAttrKeyClass o, long flags) {
            if (o == null) {
                return 0L;
            }
            return CFType.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<SecAttrKeyClass> toObject(Class<? extends CFType> cls, long handle, long flags) {
            CFArray o = (CFArray) CFType.Marshaler.toObject(CFArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<SecAttrKeyClass> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(SecAttrKeyClass.valueOf(o.get(i, CFType.class)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<SecAttrKeyClass> l, long flags) {
            if (l == null) {
                return 0L;
            }
            CFArray array = CFMutableArray.create();
            for (SecAttrKeyClass o : l) {
                array.add(o.value());
            }
            return CFType.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final SecAttrKeyClass Public = new SecAttrKeyClass("Public");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final SecAttrKeyClass Private = new SecAttrKeyClass("Private");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final SecAttrKeyClass Symmetric = new SecAttrKeyClass("Symmetric");
    /*</constants>*/
    
    private static /*<name>*/SecAttrKeyClass/*</name>*/[] values = new /*<name>*/SecAttrKeyClass/*</name>*/[] {/*<value_list>*/Public, Private, Symmetric/*</value_list>*/};
    
    /*<name>*/SecAttrKeyClass/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/SecAttrKeyClass/*</name>*/ valueOf(/*<type>*/CFType/*</type>*/ value) {
        for (/*<name>*/SecAttrKeyClass/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/SecAttrKeyClass/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("Security") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kSecAttrKeyClassPublic", optional=true)
        public static native CFType Public();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kSecAttrKeyClassPrivate", optional=true)
        public static native CFType Private();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kSecAttrKeyClassSymmetric", optional=true)
        public static native CFType Symmetric();
        /*</values>*/
    }
}
