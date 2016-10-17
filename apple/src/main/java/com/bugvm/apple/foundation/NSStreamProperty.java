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
@Marshaler(/*<name>*/NSStreamProperty/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSStreamProperty/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<NSString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/NSStreamProperty/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static NSStreamProperty toObject(Class<NSStreamProperty> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return NSStreamProperty.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(NSStreamProperty o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<NSStreamProperty> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<NSStreamProperty> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(NSStreamProperty.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<NSStreamProperty> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (NSStreamProperty o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final NSStreamProperty SocketSecurityLevel = new NSStreamProperty("SocketSecurityLevel");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final NSStreamProperty SOCKSProxyConfiguration = new NSStreamProperty("SOCKSProxyConfiguration");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final NSStreamProperty DataWrittenToMemoryStream = new NSStreamProperty("DataWrittenToMemoryStream");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final NSStreamProperty FileCurrentOffset = new NSStreamProperty("FileCurrentOffset");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final NSStreamProperty NetworkServiceType = new NSStreamProperty("NetworkServiceType");
    /*</constants>*/
    
    private static /*<name>*/NSStreamProperty/*</name>*/[] values = new /*<name>*/NSStreamProperty/*</name>*/[] {/*<value_list>*/SocketSecurityLevel, SOCKSProxyConfiguration, DataWrittenToMemoryStream, FileCurrentOffset, NetworkServiceType/*</value_list>*/};
    
    /*<name>*/NSStreamProperty/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/NSStreamProperty/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/NSStreamProperty/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/NSStreamProperty/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("Foundation") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="NSStreamSocketSecurityLevelKey", optional=true)
        public static native NSString SocketSecurityLevel();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="NSStreamSOCKSProxyConfigurationKey", optional=true)
        public static native NSString SOCKSProxyConfiguration();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="NSStreamDataWrittenToMemoryStreamKey", optional=true)
        public static native NSString DataWrittenToMemoryStream();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="NSStreamFileCurrentOffsetKey", optional=true)
        public static native NSString FileCurrentOffset();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="NSStreamNetworkServiceType", optional=true)
        public static native NSString NetworkServiceType();
        /*</values>*/
    }
}
