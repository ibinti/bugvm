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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSOperatingSystemVersion/*</name>*/ 
    extends /*<extends>*/Struct<NSOperatingSystemVersion>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSOperatingSystemVersionPtr extends Ptr<NSOperatingSystemVersion, NSOperatingSystemVersionPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSOperatingSystemVersion() {}
    public NSOperatingSystemVersion(@MachineSizedSInt long majorVersion, @MachineSizedSInt long minorVersion, @MachineSizedSInt long patchVersion) {
        this.setMajorVersion(majorVersion);
        this.setMinorVersion(minorVersion);
        this.setPatchVersion(patchVersion);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedSInt long getMajorVersion();
    @StructMember(0) public native NSOperatingSystemVersion setMajorVersion(@MachineSizedSInt long majorVersion);
    @StructMember(1) public native @MachineSizedSInt long getMinorVersion();
    @StructMember(1) public native NSOperatingSystemVersion setMinorVersion(@MachineSizedSInt long minorVersion);
    @StructMember(2) public native @MachineSizedSInt long getPatchVersion();
    @StructMember(2) public native NSOperatingSystemVersion setPatchVersion(@MachineSizedSInt long patchVersion);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
