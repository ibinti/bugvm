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
package com.bugvm.apple.coreimage;

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
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.imageio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreImage")/*</annotations>*/
@Marshaler(/*<name>*/CIFilterAttribute/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CIFilterAttribute/*</name>*/ 
    extends /*<extends>*/NSDictionaryWrapper/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static CIFilterAttribute toObject(Class<CIFilterAttribute> cls, long handle, long flags) {
            NSDictionary o = (NSDictionary) NSObject.Marshaler.toObject(NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new CIFilterAttribute(o);
        }
        @MarshalsPointer
        public static long toNative(CIFilterAttribute o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<CIFilterAttribute> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSDictionary> o = (NSArray<NSDictionary>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<CIFilterAttribute> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(new CIFilterAttribute(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<CIFilterAttribute> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSDictionary> array = new NSMutableArray<>();
            for (CIFilterAttribute i : l) {
                array.add(i.getDictionary());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constructors>*/
    CIFilterAttribute(NSDictionary data) {
        super(data);
    }
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
    

    public String getAttributeClassName() {
        if (has(Keys.Class())) {
            NSString val = (NSString) get(Keys.Class());
            return val.toString();
        }
        return null;
    }
    public CIFilterAttributeType getType() {
        if (has(Keys.Type())) {
            NSString val = (NSString) get(Keys.Type());
            return CIFilterAttributeType.valueOf(val);
        }
        return null;
    }
    public double getMin() {
        if (has(Keys.Min())) {
            NSNumber val = (NSNumber) get(Keys.Min());
            return val.doubleValue();
        }
        return 0;
    }
    public double getMax() {
        if (has(Keys.Max())) {
            NSNumber val = (NSNumber) get(Keys.Max());
            return val.doubleValue();
        }
        return 0;
    }
    public double getSliderMin() {
        if (has(Keys.SliderMin())) {
            NSNumber val = (NSNumber) get(Keys.SliderMin());
            return val.doubleValue();
        }
        return 0;
    }
    public double getSliderMax() {
        if (has(Keys.SliderMax())) {
            NSNumber val = (NSNumber) get(Keys.SliderMax());
            return val.doubleValue();
        }
        return 0;
    }
    public double getDefault() {
        if (has(Keys.Default())) {
            NSNumber val = (NSNumber) get(Keys.Default());
            return val.doubleValue();
        }
        return 0;
    }
    public double getIdentity() {
        if (has(Keys.Identity())) {
            NSNumber val = (NSNumber) get(Keys.Identity());
            return val.doubleValue();
        }
        return 0;
    }
    public String getName() {
        if (has(Keys.Name())) {
            NSString val = (NSString) get(Keys.Name());
            return val.toString();
        }
        return null;
    }
    public String getDisplayName() {
        if (has(Keys.DisplayName())) {
            NSString val = (NSString) get(Keys.DisplayName());
            return val.toString();
        }
        return null;
    }
    /*</methods>*/
    
    /*<keys>*/
    @Library("CoreImage")
    public static class Keys {
        static { Bro.bind(Keys.class); }
        @GlobalValue(symbol="kCIAttributeClass", optional=true)
        public static native NSString Class();
        @GlobalValue(symbol="kCIAttributeType", optional=true)
        public static native NSString Type();
        @GlobalValue(symbol="kCIAttributeMin", optional=true)
        public static native NSString Min();
        @GlobalValue(symbol="kCIAttributeMax", optional=true)
        public static native NSString Max();
        @GlobalValue(symbol="kCIAttributeSliderMin", optional=true)
        public static native NSString SliderMin();
        @GlobalValue(symbol="kCIAttributeSliderMax", optional=true)
        public static native NSString SliderMax();
        @GlobalValue(symbol="kCIAttributeDefault", optional=true)
        public static native NSString Default();
        @GlobalValue(symbol="kCIAttributeIdentity", optional=true)
        public static native NSString Identity();
        @GlobalValue(symbol="kCIAttributeName", optional=true)
        public static native NSString Name();
        @GlobalValue(symbol="kCIAttributeDisplayName", optional=true)
        public static native NSString DisplayName();
    }
    /*</keys>*/
}
