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
package com.bugvm.apple.contacts;

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
/*<annotations>*/@Library("Contacts") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/CNLabelPhoneNumber/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CNLabelPhoneNumber/*</name>*/ 
    extends /*<extends>*/CNLabel/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/CNLabelPhoneNumber/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static CNLabelPhoneNumber toObject(Class<CNLabelPhoneNumber> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return CNLabelPhoneNumber.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(CNLabelPhoneNumber o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<CNLabelPhoneNumber> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<CNLabelPhoneNumber> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(CNLabelPhoneNumber.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<CNLabelPhoneNumber> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (CNLabelPhoneNumber o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final CNLabelPhoneNumber iPhone = new CNLabelPhoneNumber("iPhone");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final CNLabelPhoneNumber Mobile = new CNLabelPhoneNumber("Mobile");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final CNLabelPhoneNumber Main = new CNLabelPhoneNumber("Main");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final CNLabelPhoneNumber HomeFax = new CNLabelPhoneNumber("HomeFax");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final CNLabelPhoneNumber WorkFax = new CNLabelPhoneNumber("WorkFax");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final CNLabelPhoneNumber OtherFax = new CNLabelPhoneNumber("OtherFax");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final CNLabelPhoneNumber Pager = new CNLabelPhoneNumber("Pager");
    /*</constants>*/
    
    private static /*<name>*/CNLabelPhoneNumber/*</name>*/[] values = new /*<name>*/CNLabelPhoneNumber/*</name>*/[] {/*<value_list>*/iPhone, Mobile, Main, HomeFax, WorkFax, OtherFax, Pager/*</value_list>*/};
    
    private CNLabelPhoneNumber(String getterName) {
        super(getterName);
    }
    
    public static /*<name>*/CNLabelPhoneNumber/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/CNLabelPhoneNumber/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/CNLabelPhoneNumber/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("Contacts") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="CNLabelPhoneNumberiPhone", optional=true)
        public static native NSString iPhone();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="CNLabelPhoneNumberMobile", optional=true)
        public static native NSString Mobile();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="CNLabelPhoneNumberMain", optional=true)
        public static native NSString Main();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="CNLabelPhoneNumberHomeFax", optional=true)
        public static native NSString HomeFax();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="CNLabelPhoneNumberWorkFax", optional=true)
        public static native NSString WorkFax();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="CNLabelPhoneNumberOtherFax", optional=true)
        public static native NSString OtherFax();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="CNLabelPhoneNumberPager", optional=true)
        public static native NSString Pager();
        /*</values>*/
    }
}
