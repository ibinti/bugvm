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
package com.bugvm.apple.coreanimation;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("QuartzCore") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/CAEmitterRenderMode/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAEmitterRenderMode/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/CAEmitterRenderMode/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static CAEmitterRenderMode toObject(Class<CAEmitterRenderMode> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return CAEmitterRenderMode.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(CAEmitterRenderMode o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<CAEmitterRenderMode> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<CAEmitterRenderMode> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(CAEmitterRenderMode.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<CAEmitterRenderMode> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (CAEmitterRenderMode o : l) {
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
    public static final CAEmitterRenderMode Unordered = new CAEmitterRenderMode("Unordered");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final CAEmitterRenderMode OldestFirst = new CAEmitterRenderMode("OldestFirst");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final CAEmitterRenderMode OldestLast = new CAEmitterRenderMode("OldestLast");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final CAEmitterRenderMode BackToFront = new CAEmitterRenderMode("BackToFront");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final CAEmitterRenderMode Additive = new CAEmitterRenderMode("Additive");
    /*</constants>*/
    
    private static /*<name>*/CAEmitterRenderMode/*</name>*/[] values = new /*<name>*/CAEmitterRenderMode/*</name>*/[] {/*<value_list>*/Unordered, OldestFirst, OldestLast, BackToFront, Additive/*</value_list>*/};
    
    /*<name>*/CAEmitterRenderMode/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/CAEmitterRenderMode/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/CAEmitterRenderMode/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/CAEmitterRenderMode/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("QuartzCore") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="kCAEmitterLayerUnordered", optional=true)
        public static native NSString Unordered();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="kCAEmitterLayerOldestFirst", optional=true)
        public static native NSString OldestFirst();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="kCAEmitterLayerOldestLast", optional=true)
        public static native NSString OldestLast();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="kCAEmitterLayerBackToFront", optional=true)
        public static native NSString BackToFront();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="kCAEmitterLayerAdditive", optional=true)
        public static native NSString Additive();
        /*</values>*/
    }
}
