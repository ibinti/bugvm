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
package com.bugvm.apple.imageio;

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
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("ImageIO") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/CGImagePropertyGIF/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CGImagePropertyGIF/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<CFString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/CGImagePropertyGIF/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static CGImagePropertyGIF toObject(Class<CGImagePropertyGIF> cls, long handle, long flags) {
            CFString o = (CFString) CFType.Marshaler.toObject(CFString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return CGImagePropertyGIF.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(CGImagePropertyGIF o, long flags) {
            if (o == null) {
                return 0L;
            }
            return CFType.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<CGImagePropertyGIF> toObject(Class<? extends CFType> cls, long handle, long flags) {
            CFArray o = (CFArray) CFType.Marshaler.toObject(CFArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<CGImagePropertyGIF> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(CGImagePropertyGIF.valueOf(o.get(i, CFString.class)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<CGImagePropertyGIF> l, long flags) {
            if (l == null) {
                return 0L;
            }
            CFArray array = CFMutableArray.create();
            for (CGImagePropertyGIF o : l) {
                array.add(o.value());
            }
            return CFType.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF LoopCount = new CGImagePropertyGIF("LoopCount");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF DelayTime = new CGImagePropertyGIF("DelayTime");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF ImageColorMap = new CGImagePropertyGIF("ImageColorMap");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF HasGlobalColorMap = new CGImagePropertyGIF("HasGlobalColorMap");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF UnclampedDelayTime = new CGImagePropertyGIF("UnclampedDelayTime");
    /*</constants>*/
    
    private static /*<name>*/CGImagePropertyGIF/*</name>*/[] values = new /*<name>*/CGImagePropertyGIF/*</name>*/[] {/*<value_list>*/LoopCount, DelayTime, ImageColorMap, HasGlobalColorMap, UnclampedDelayTime/*</value_list>*/};
    
    /*<name>*/CGImagePropertyGIF/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/CGImagePropertyGIF/*</name>*/ valueOf(/*<type>*/CFString/*</type>*/ value) {
        for (/*<name>*/CGImagePropertyGIF/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/CGImagePropertyGIF/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("ImageIO") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="kCGImagePropertyGIFLoopCount", optional=true)
        public static native CFString LoopCount();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="kCGImagePropertyGIFDelayTime", optional=true)
        public static native CFString DelayTime();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="kCGImagePropertyGIFImageColorMap", optional=true)
        public static native CFString ImageColorMap();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="kCGImagePropertyGIFHasGlobalColorMap", optional=true)
        public static native CFString HasGlobalColorMap();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="kCGImagePropertyGIFUnclampedDelayTime", optional=true)
        public static native CFString UnclampedDelayTime();
        /*</values>*/
    }
}
