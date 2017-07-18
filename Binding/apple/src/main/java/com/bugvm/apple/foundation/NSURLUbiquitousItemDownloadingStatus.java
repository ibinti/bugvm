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
@Marshaler(/*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static NSURLUbiquitousItemDownloadingStatus toObject(Class<NSURLUbiquitousItemDownloadingStatus> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return NSURLUbiquitousItemDownloadingStatus.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(NSURLUbiquitousItemDownloadingStatus o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<NSURLUbiquitousItemDownloadingStatus> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<NSURLUbiquitousItemDownloadingStatus> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(NSURLUbiquitousItemDownloadingStatus.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<NSURLUbiquitousItemDownloadingStatus> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (NSURLUbiquitousItemDownloadingStatus o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final NSURLUbiquitousItemDownloadingStatus NotDownloaded = new NSURLUbiquitousItemDownloadingStatus("NotDownloaded");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final NSURLUbiquitousItemDownloadingStatus Downloaded = new NSURLUbiquitousItemDownloadingStatus("Downloaded");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final NSURLUbiquitousItemDownloadingStatus Current = new NSURLUbiquitousItemDownloadingStatus("Current");
    /*</constants>*/
    
    private static /*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/[] values = new /*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/[] {/*<value_list>*/NotDownloaded, Downloaded, Current/*</value_list>*/};
    
    /*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/NSURLUbiquitousItemDownloadingStatus/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("Foundation") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="NSURLUbiquitousItemDownloadingStatusNotDownloaded", optional=true)
        public static native NSString NotDownloaded();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="NSURLUbiquitousItemDownloadingStatusDownloaded", optional=true)
        public static native NSString Downloaded();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="NSURLUbiquitousItemDownloadingStatusCurrent", optional=true)
        public static native NSString Current();
        /*</values>*/
    }
}
