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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/Foundation/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(Foundation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    
    /**
     * Prints the specified message to the system log facility.
     * 
     * @param message the message to print to the log.
     */
    @Bridge(symbol = "NSLog")
    public native static void log(String message);
    
    /**
     * Formats a log message using the specified format string and argument and
     * prints it to the system log facility. Primitive value arguments must be 
     * wrapped in {@link NSNumber} instances.
     * 
     * @param format the format string.
     * @param arg the argument to be used in the format string.
     */
    @Bridge(symbol = "NSLog")
    @Variadic(1)
    public native static void log(String format, NSObject arg);

    /**
     * Formats a log message using the specified format string and arguments and
     * prints it to the system log facility. Primitive value arguments must be 
     * wrapped in {@link NSNumber} instances.
     * 
     * @param format the format string.
     * @param arg1 the first argument to be used in the format string.
     * @param arg2 the second argument to be used in the format string.
     */
    @Bridge(symbol = "NSLog")
    @Variadic(1)
    public native static void log(String format, NSObject arg1, NSObject arg2);

    /**
     * Formats a log message using the specified format string and arguments and
     * prints it to the system log facility. Primitive value arguments must be 
     * wrapped in {@link NSNumber} instances.
     * 
     * @param format the format string.
     * @param arg1 the first argument to be used in the format string.
     * @param arg2 the second argument to be used in the format string.
     * @param arg3 the third argument to be used in the format string.
     */
    @Bridge(symbol = "NSLog")
    @Variadic(1)
    public native static void log(String format, NSObject arg1, NSObject arg2, NSObject arg3);

    /**
     * Formats a log message using the specified format string and arguments and
     * prints it to the system log facility. Primitive value arguments must be 
     * wrapped in {@link NSNumber} instances.
     * 
     * @param format the format string.
     * @param arg1 the first argument to be used in the format string.
     * @param arg2 the second argument to be used in the format string.
     * @param arg3 the third argument to be used in the format string.
     * @param arg4 the forth argument to be used in the format string.
     */
    @Bridge(symbol = "NSLog")
    @Variadic(1)
    public native static void log(String format, NSObject arg1, NSObject arg2, NSObject arg3, NSObject arg4);

    /**
     * Formats a log message using the specified format string and arguments and
     * prints it to the system log facility. Primitive value arguments must be 
     * wrapped in {@link NSNumber} instances.
     * 
     * @param format the format string.
     * @param arg1 the first argument to be used in the format string.
     * @param arg2 the second argument to be used in the format string.
     * @param arg3 the third argument to be used in the format string.
     * @param arg4 the forth argument to be used in the format string.
     * @param arg5 the fifth argument to be used in the format string.
     */
    @Bridge(symbol = "NSLog")
    @Variadic(1)
    public native static void log(String format, NSObject arg1, NSObject arg2, NSObject arg3, NSObject arg4, NSObject arg5);
    
    private static String systemVersionString;
    private static int majorSystemVersion;
    private static int minorSystemVersion;
    private static int patchSystemVersion;
    
    /**
     * Cached convenience method for {@link UIDevice#getSystemVersion()}.
     * @return the OS version that this app is running on.
     */
    public static String getSystemVersionString() {
    	if (majorSystemVersion == 0) fetchSystemVersion(); // Lazily fetch the device's system version.
        return systemVersionString;
    }
    /**
     * @return the major part of the running OS version.
     */
    public static int getMajorSystemVersion() {
        if (majorSystemVersion == 0) fetchSystemVersion(); // Lazily fetch the device's system version.
        return majorSystemVersion;
    }
    /**
     * @return the minor part of the running OS version.
     */
    public static int getMinorSystemVersion() {
        if (majorSystemVersion == 0) fetchSystemVersion(); // Lazily fetch the device's system version.
        return minorSystemVersion;
    }
    /**
     * @return the patch part of the running OS version.
     */
    public static int getPatchSystemVersion() {
        if (majorSystemVersion == 0) fetchSystemVersion(); // Lazily fetch the device's system version.
        return patchSystemVersion;
    }
    
    /**
     * Retrieve and store the device system version.
     */
    @WeaklyLinked
    private static void fetchSystemVersion() {
        String version = UIDevice.getCurrentDevice().getSystemVersion();
        systemVersionString = version;
        
        if (version != null) {
            String[] parts = version.split("\\.");
            if (parts.length > 0) majorSystemVersion = Integer.valueOf(parts[0]);
            if (parts.length > 1) minorSystemVersion = Integer.valueOf(parts[1]);
            if (parts.length > 2) patchSystemVersion = Integer.valueOf(parts[2]);
        } else {
            // Default to minimum OS version that RoboVM supports.
            majorSystemVersion = 6;
        }
    }
    
    /*<methods>*/
    /*</methods>*/
}
