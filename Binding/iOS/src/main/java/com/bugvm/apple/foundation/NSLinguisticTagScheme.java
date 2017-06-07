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
@Marshaler(/*<name>*/NSLinguisticTagScheme/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSLinguisticTagScheme/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/NSLinguisticTagScheme/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static NSLinguisticTagScheme toObject(Class<NSLinguisticTagScheme> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return NSLinguisticTagScheme.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(NSLinguisticTagScheme o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<NSLinguisticTagScheme> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<NSLinguisticTagScheme> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(NSLinguisticTagScheme.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<NSLinguisticTagScheme> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (NSLinguisticTagScheme o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final NSLinguisticTagScheme TokenType = new NSLinguisticTagScheme("TokenType");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final NSLinguisticTagScheme LexicalClass = new NSLinguisticTagScheme("LexicalClass");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final NSLinguisticTagScheme NameType = new NSLinguisticTagScheme("NameType");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final NSLinguisticTagScheme NameTypeOrLexicalClass = new NSLinguisticTagScheme("NameTypeOrLexicalClass");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final NSLinguisticTagScheme Lemma = new NSLinguisticTagScheme("Lemma");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final NSLinguisticTagScheme Language = new NSLinguisticTagScheme("Language");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final NSLinguisticTagScheme Script = new NSLinguisticTagScheme("Script");
    /*</constants>*/
    
    private static /*<name>*/NSLinguisticTagScheme/*</name>*/[] values = new /*<name>*/NSLinguisticTagScheme/*</name>*/[] {/*<value_list>*/TokenType, LexicalClass, NameType, NameTypeOrLexicalClass, Lemma, Language, Script/*</value_list>*/};
    
    /*<name>*/NSLinguisticTagScheme/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/NSLinguisticTagScheme/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/NSLinguisticTagScheme/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/NSLinguisticTagScheme/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("Foundation") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="NSLinguisticTagSchemeTokenType", optional=true)
        public static native NSString TokenType();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="NSLinguisticTagSchemeLexicalClass", optional=true)
        public static native NSString LexicalClass();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="NSLinguisticTagSchemeNameType", optional=true)
        public static native NSString NameType();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="NSLinguisticTagSchemeNameTypeOrLexicalClass", optional=true)
        public static native NSString NameTypeOrLexicalClass();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="NSLinguisticTagSchemeLemma", optional=true)
        public static native NSString Lemma();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="NSLinguisticTagSchemeLanguage", optional=true)
        public static native NSString Language();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="NSLinguisticTagSchemeScript", optional=true)
        public static native NSString Script();
        /*</values>*/
    }
}
