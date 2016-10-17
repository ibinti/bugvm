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
package com.bugvm.apple.corevideo;

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
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreVideo")/*</annotations>*/
@Marshaler(/*<name>*/CVMetalTextureCacheAttributes/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CVMetalTextureCacheAttributes/*</name>*/ 
    extends /*<extends>*/CFDictionaryWrapper/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static CVMetalTextureCacheAttributes toObject(Class<CVMetalTextureCacheAttributes> cls, long handle, long flags) {
            CFDictionary o = (CFDictionary) CFType.Marshaler.toObject(CFDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new CVMetalTextureCacheAttributes(o);
        }
        @MarshalsPointer
        public static long toNative(CVMetalTextureCacheAttributes o, long flags) {
            if (o == null) {
                return 0L;
            }
            return CFType.Marshaler.toNative(o.data, flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<CVMetalTextureCacheAttributes> toObject(Class<? extends CFType> cls, long handle, long flags) {
            CFArray o = (CFArray) CFType.Marshaler.toObject(CFArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<CVMetalTextureCacheAttributes> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(new CVMetalTextureCacheAttributes(o.get(i, CFDictionary.class)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<CVMetalTextureCacheAttributes> l, long flags) {
            if (l == null) {
                return 0L;
            }
            CFArray array = CFMutableArray.create();
            for (CVMetalTextureCacheAttributes i : l) {
                array.add(i.getDictionary());
            }
            return CFType.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constructors>*/
    CVMetalTextureCacheAttributes(CFDictionary data) {
        super(data);
    }
    public CVMetalTextureCacheAttributes() {}
    /*</constructors>*/

    /*<methods>*/
    public boolean has(CFString key) {
        return data.containsKey(key);
    }
    public <T extends NativeObject> T get(CFString key, Class<T> type) {
        if (has(key)) {
            return data.get(key, type);
        }
        return null;
    }
    public CVMetalTextureCacheAttributes set(CFString key, NativeObject value) {
        data.put(key, value);
        return this;
    }
    

    /**
     * @since Available in iOS 8.0 and later.
     */
    public long getMaximumTextureAge() {
        if (has(Keys.MaximumTextureAge())) {
            CFNumber val = get(Keys.MaximumTextureAge(), CFNumber.class);
            return val.longValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public CVMetalTextureCacheAttributes setMaximumTextureAge(long maximumTextureAge) {
        set(Keys.MaximumTextureAge(), CFNumber.valueOf(maximumTextureAge));
        return this;
    }
    /*</methods>*/
    
    /*<keys>*/
    @Library("CoreVideo")
    public static class Keys {
        static { Bro.bind(Keys.class); }
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="kCVMetalTextureCacheMaximumTextureAgeKey", optional=true)
        public static native CFString MaximumTextureAge();
    }
    /*</keys>*/
}
