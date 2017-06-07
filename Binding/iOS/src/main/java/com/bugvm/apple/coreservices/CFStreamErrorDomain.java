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
package com.bugvm.apple.coreservices;

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
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CFNetwork") @StronglyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFStreamErrorDomain/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<Integer>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/CFStreamErrorDomain/*</name>*/.class); }


    /*<constants>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain NetDB = new CFStreamErrorDomain("NetDB");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain SystemConfiguration = new CFStreamErrorDomain("SystemConfiguration");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain Mach = new CFStreamErrorDomain("Mach");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain NetServices = new CFStreamErrorDomain("NetServices");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain WinSock = new CFStreamErrorDomain("WinSock");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain SOCKS = new CFStreamErrorDomain("SOCKS");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain SSL = new CFStreamErrorDomain("SSL");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain FTP = new CFStreamErrorDomain("FTP");
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStreamErrorDomain HTTP = new CFStreamErrorDomain("HTTP");
    /*</constants>*/
    
    private static /*<name>*/CFStreamErrorDomain/*</name>*/[] values = new /*<name>*/CFStreamErrorDomain/*</name>*/[] {/*<value_list>*/NetDB, SystemConfiguration, Mach, NetServices, WinSock, SOCKS, SSL, FTP, HTTP/*</value_list>*/};
    
    /*<name>*/CFStreamErrorDomain/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/CFStreamErrorDomain/*</name>*/ valueOf(/*<type>*/Integer/*</type>*/ value) {
        for (/*<name>*/CFStreamErrorDomain/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/CFStreamErrorDomain/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("CFNetwork") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainNetDB", optional=true)
        public static native int NetDB();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainSystemConfiguration", optional=true)
        public static native int SystemConfiguration();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainMach", optional=true)
        public static native int Mach();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainNetServices", optional=true)
        public static native int NetServices();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainWinSock", optional=true)
        public static native int WinSock();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainSOCKS", optional=true)
        public static native int SOCKS();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainSSL", optional=true)
        public static native int SSL();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainFTP", optional=true)
        public static native int FTP();
        /**
         * @since Available in iOS 2.0 and later.
         */
        @GlobalValue(symbol="kCFStreamErrorDomainHTTP", optional=true)
        public static native int HTTP();
        /*</values>*/
    }
}
