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
package com.bugvm.apple.avfoundation;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.mediatoolbox.*;
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.audiounit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/AVVideoProfileLevel/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVVideoProfileLevel/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/AVVideoProfileLevel/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static AVVideoProfileLevel toObject(Class<AVVideoProfileLevel> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return AVVideoProfileLevel.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(AVVideoProfileLevel o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<AVVideoProfileLevel> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<AVVideoProfileLevel> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(AVVideoProfileLevel.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<AVVideoProfileLevel> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (AVVideoProfileLevel o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVVideoProfileLevel H264Baseline30 = new AVVideoProfileLevel("H264Baseline30");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVVideoProfileLevel H264Baseline31 = new AVVideoProfileLevel("H264Baseline31");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final AVVideoProfileLevel H264Baseline41 = new AVVideoProfileLevel("H264Baseline41");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final AVVideoProfileLevel H264BaselineAutoLevel = new AVVideoProfileLevel("H264BaselineAutoLevel");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVVideoProfileLevel H264Main30 = new AVVideoProfileLevel("H264Main30");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVVideoProfileLevel H264Main31 = new AVVideoProfileLevel("H264Main31");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final AVVideoProfileLevel H264Main32 = new AVVideoProfileLevel("H264Main32");
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static final AVVideoProfileLevel H264Main41 = new AVVideoProfileLevel("H264Main41");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final AVVideoProfileLevel H264MainAutoLevel = new AVVideoProfileLevel("H264MainAutoLevel");
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final AVVideoProfileLevel H264High40 = new AVVideoProfileLevel("H264High40");
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final AVVideoProfileLevel H264High41 = new AVVideoProfileLevel("H264High41");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final AVVideoProfileLevel H264HighAutoLevel = new AVVideoProfileLevel("H264HighAutoLevel");
    /*</constants>*/
    
    private static /*<name>*/AVVideoProfileLevel/*</name>*/[] values = new /*<name>*/AVVideoProfileLevel/*</name>*/[] {/*<value_list>*/H264Baseline30, H264Baseline31, H264Baseline41, H264BaselineAutoLevel, H264Main30, H264Main31, H264Main32, H264Main41, H264MainAutoLevel, H264High40, H264High41, H264HighAutoLevel/*</value_list>*/};
    
    /*<name>*/AVVideoProfileLevel/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/AVVideoProfileLevel/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/AVVideoProfileLevel/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/AVVideoProfileLevel/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("AVFoundation") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264Baseline30", optional=true)
        public static native NSString H264Baseline30();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264Baseline31", optional=true)
        public static native NSString H264Baseline31();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264Baseline41", optional=true)
        public static native NSString H264Baseline41();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264BaselineAutoLevel", optional=true)
        public static native NSString H264BaselineAutoLevel();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264Main30", optional=true)
        public static native NSString H264Main30();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264Main31", optional=true)
        public static native NSString H264Main31();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264Main32", optional=true)
        public static native NSString H264Main32();
        /**
         * @since Available in iOS 5.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264Main41", optional=true)
        public static native NSString H264Main41();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264MainAutoLevel", optional=true)
        public static native NSString H264MainAutoLevel();
        /**
         * @since Available in iOS 6.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264High40", optional=true)
        public static native NSString H264High40();
        /**
         * @since Available in iOS 6.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264High41", optional=true)
        public static native NSString H264High41();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="AVVideoProfileLevelH264HighAutoLevel", optional=true)
        public static native NSString H264HighAutoLevel();
        /*</values>*/
    }
}
