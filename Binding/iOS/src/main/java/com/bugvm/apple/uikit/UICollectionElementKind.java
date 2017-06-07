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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/UICollectionElementKind/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UICollectionElementKind/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/UICollectionElementKind/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static UICollectionElementKind toObject(Class<UICollectionElementKind> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return UICollectionElementKind.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(UICollectionElementKind o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<UICollectionElementKind> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<UICollectionElementKind> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(UICollectionElementKind.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<UICollectionElementKind> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (UICollectionElementKind o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final UICollectionElementKind SectionHeader = new UICollectionElementKind("SectionHeader");
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final UICollectionElementKind SectionFooter = new UICollectionElementKind("SectionFooter");
    /*</constants>*/
    
    private static /*<name>*/UICollectionElementKind/*</name>*/[] values = new /*<name>*/UICollectionElementKind/*</name>*/[] {/*<value_list>*/SectionHeader, SectionFooter/*</value_list>*/};
    
    /*<name>*/UICollectionElementKind/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/UICollectionElementKind/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/UICollectionElementKind/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/UICollectionElementKind/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("UIKit") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 6.0 and later.
         */
        @GlobalValue(symbol="UICollectionElementKindSectionHeader", optional=true)
        public static native NSString SectionHeader();
        /**
         * @since Available in iOS 6.0 and later.
         */
        @GlobalValue(symbol="UICollectionElementKindSectionFooter", optional=true)
        public static native NSString SectionFooter();
        /*</values>*/
    }
}
