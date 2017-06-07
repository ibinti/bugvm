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
@Marshaler(/*<name>*/AVMediaType/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMediaType/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/AVMediaType/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static AVMediaType toObject(Class<AVMediaType> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return AVMediaType.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(AVMediaType o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<AVMediaType> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<AVMediaType> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(AVMediaType.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<AVMediaType> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (AVMediaType o : l) {
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
    public static final AVMediaType Video = new AVMediaType("Video");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMediaType Audio = new AVMediaType("Audio");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMediaType Text = new AVMediaType("Text");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMediaType ClosedCaption = new AVMediaType("ClosedCaption");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMediaType Subtitle = new AVMediaType("Subtitle");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMediaType Timecode = new AVMediaType("Timecode");
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final AVMediaType Metadata = new AVMediaType("Metadata");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMediaType Muxed = new AVMediaType("Muxed");
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final AVMediaType MetadataObject = new AVMediaType("MetadataObject");
    /*</constants>*/
    
    private static /*<name>*/AVMediaType/*</name>*/[] values = new /*<name>*/AVMediaType/*</name>*/[] {/*<value_list>*/Video, Audio, Text, ClosedCaption, Subtitle, Timecode, Metadata, Muxed, MetadataObject/*</value_list>*/};
    
    /*<name>*/AVMediaType/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/AVMediaType/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/AVMediaType/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/AVMediaType/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("AVFoundation") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeVideo", optional=true)
        public static native NSString Video();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeAudio", optional=true)
        public static native NSString Audio();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeText", optional=true)
        public static native NSString Text();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeClosedCaption", optional=true)
        public static native NSString ClosedCaption();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeSubtitle", optional=true)
        public static native NSString Subtitle();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeTimecode", optional=true)
        public static native NSString Timecode();
        /**
         * @since Available in iOS 6.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeMetadata", optional=true)
        public static native NSString Metadata();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeMuxed", optional=true)
        public static native NSString Muxed();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="AVMediaTypeMetadataObject", optional=true)
        public static native NSString MetadataObject();
        /*</values>*/
    }
}
