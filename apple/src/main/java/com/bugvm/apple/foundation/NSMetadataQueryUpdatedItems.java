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
/*<annotations>*/@Library("Foundation")/*</annotations>*/
@Marshaler(/*<name>*/NSMetadataQueryUpdatedItems/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMetadataQueryUpdatedItems/*</name>*/ 
    extends /*<extends>*/NSDictionaryWrapper/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static NSMetadataQueryUpdatedItems toObject(Class<NSMetadataQueryUpdatedItems> cls, long handle, long flags) {
            NSDictionary o = (NSDictionary) NSObject.Marshaler.toObject(NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new NSMetadataQueryUpdatedItems(o);
        }
        @MarshalsPointer
        public static long toNative(NSMetadataQueryUpdatedItems o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<NSMetadataQueryUpdatedItems> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSDictionary> o = (NSArray<NSDictionary>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<NSMetadataQueryUpdatedItems> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(new NSMetadataQueryUpdatedItems(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<NSMetadataQueryUpdatedItems> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSDictionary> array = new NSMutableArray<>();
            for (NSMetadataQueryUpdatedItems i : l) {
                array.add(i.getDictionary());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constructors>*/
    NSMetadataQueryUpdatedItems(NSDictionary data) {
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
    

    /**
     * @since Available in iOS 8.0 and later.
     */
    public NSArray<NSMetadataItem> getAddedItems() {
        if (has(Keys.UpdateAddedItems())) {
            NSArray<NSMetadataItem> val = (NSArray<NSMetadataItem>) get(Keys.UpdateAddedItems());
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public NSArray<NSMetadataItem> getChangedItems() {
        if (has(Keys.UpdateChangedItems())) {
            NSArray<NSMetadataItem> val = (NSArray<NSMetadataItem>) get(Keys.UpdateChangedItems());
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public NSArray<NSMetadataItem> getRemovedItems() {
        if (has(Keys.UpdateRemovedItems())) {
            NSArray<NSMetadataItem> val = (NSArray<NSMetadataItem>) get(Keys.UpdateRemovedItems());
            return val;
        }
        return null;
    }
    /*</methods>*/
    
    /*<keys>*/
    @Library("Foundation")
    public static class Keys {
        static { Bro.bind(Keys.class); }
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="NSMetadataQueryUpdateAddedItemsKey", optional=true)
        public static native NSString UpdateAddedItems();
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="NSMetadataQueryUpdateChangedItemsKey", optional=true)
        public static native NSString UpdateChangedItems();
        /**
         * @since Available in iOS 8.0 and later.
         */
        @GlobalValue(symbol="NSMetadataQueryUpdateRemovedItemsKey", optional=true)
        public static native NSString UpdateRemovedItems();
    }
    /*</keys>*/
}
