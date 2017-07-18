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
/*<annotations>*/@Library("AVFoundation")/*</annotations>*/
@Marshaler(/*<name>*/AVVideoCleanAperture/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVVideoCleanAperture/*</name>*/ 
    extends /*<extends>*/NSDictionaryWrapper/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static AVVideoCleanAperture toObject(Class<AVVideoCleanAperture> cls, long handle, long flags) {
            NSDictionary o = (NSDictionary) NSObject.Marshaler.toObject(NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new AVVideoCleanAperture(o);
        }
        @MarshalsPointer
        public static long toNative(AVVideoCleanAperture o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<AVVideoCleanAperture> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSDictionary> o = (NSArray<NSDictionary>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<AVVideoCleanAperture> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(new AVVideoCleanAperture(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<AVVideoCleanAperture> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSDictionary> array = new NSMutableArray<>();
            for (AVVideoCleanAperture i : l) {
                array.add(i.getDictionary());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constructors>*/
    AVVideoCleanAperture(NSDictionary data) {
        super(data);
    }
    public AVVideoCleanAperture() {}
    /*</constructors>*/

    /*<methods>*/
    public boolean has(NSString key) {
        return data.containsKey(key);
    }
    public NSObject get(NSString key) {
        if (has(key)) {
            return data.get(key);
        }
        return null;
    }
    public AVVideoCleanAperture set(NSString key, NSObject value) {
        data.put(key, value);
        return this;
    }
    

    /**
     * @since Available in iOS 4.0 and later.
     */
    public long getWidth() {
        if (has(Keys.Width())) {
            NSNumber val = (NSNumber) get(Keys.Width());
            return val.longValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public AVVideoCleanAperture setWidth(long width) {
        set(Keys.Width(), NSNumber.valueOf(width));
        return this;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public long getHeight() {
        if (has(Keys.Height())) {
            NSNumber val = (NSNumber) get(Keys.Height());
            return val.longValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public AVVideoCleanAperture setHeight(long height) {
        set(Keys.Height(), NSNumber.valueOf(height));
        return this;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public long getHorizontalOffset() {
        if (has(Keys.HorizontalOffset())) {
            NSNumber val = (NSNumber) get(Keys.HorizontalOffset());
            return val.longValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public AVVideoCleanAperture setHorizontalOffset(long horizontalOffset) {
        set(Keys.HorizontalOffset(), NSNumber.valueOf(horizontalOffset));
        return this;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public long getVerticalOffset() {
        if (has(Keys.VerticalOffset())) {
            NSNumber val = (NSNumber) get(Keys.VerticalOffset());
            return val.longValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public AVVideoCleanAperture setVerticalOffset(long verticalOffset) {
        set(Keys.VerticalOffset(), NSNumber.valueOf(verticalOffset));
        return this;
    }
    /*</methods>*/
    
    /*<keys>*/
    @Library("AVFoundation")
    public static class Keys {
        static { Bro.bind(Keys.class); }
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoCleanApertureWidthKey", optional=true)
        public static native NSString Width();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoCleanApertureHeightKey", optional=true)
        public static native NSString Height();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoCleanApertureHorizontalOffsetKey", optional=true)
        public static native NSString HorizontalOffset();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVVideoCleanApertureVerticalOffsetKey", optional=true)
        public static native NSString VerticalOffset();
    }
    /*</keys>*/
}
