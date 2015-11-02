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
package com.bugvm.apple.passkit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.addressbook.*;
import com.bugvm.apple.contacts.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("PassKit") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/PKPaymentNetwork/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PKPaymentNetwork/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/PKPaymentNetwork/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static PKPaymentNetwork toObject(Class<PKPaymentNetwork> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return PKPaymentNetwork.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(PKPaymentNetwork o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<PKPaymentNetwork> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<PKPaymentNetwork> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(PKPaymentNetwork.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<PKPaymentNetwork> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (PKPaymentNetwork o : l) {
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
    public static final PKPaymentNetwork Amex = new PKPaymentNetwork("Amex");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final PKPaymentNetwork Discover = new PKPaymentNetwork("Discover");
    /**
     * @since Available in iOS 8.0 and later.
     */
    public static final PKPaymentNetwork MasterCard = new PKPaymentNetwork("MasterCard");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final PKPaymentNetwork PrivateLabel = new PKPaymentNetwork("PrivateLabel");
    /**
     * @since Available in iOS 8.0 and later.
     */
    public static final PKPaymentNetwork Visa = new PKPaymentNetwork("Visa");
    /*</constants>*/
    
    private static /*<name>*/PKPaymentNetwork/*</name>*/[] values = new /*<name>*/PKPaymentNetwork/*</name>*/[] {/*<value_list>*/Amex, Discover, MasterCard, PrivateLabel, Visa/*</value_list>*/};
    
    /*<name>*/PKPaymentNetwork/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/PKPaymentNetwork/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/PKPaymentNetwork/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/PKPaymentNetwork/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("PassKit") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="PKPaymentNetworkAmex", optional=true)
        public static native NSString Amex();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="PKPaymentNetworkDiscover", optional=true)
        public static native NSString Discover();
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="PKPaymentNetworkMasterCard", optional=true)
        public static native NSString MasterCard();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="PKPaymentNetworkPrivateLabel", optional=true)
        public static native NSString PrivateLabel();
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="PKPaymentNetworkVisa", optional=true)
        public static native NSString Visa();
        /*</values>*/
    }
}
