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
/*<annotations>*/@Library("CFNetwork")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFNetDiagnostic/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFNetDiagnosticPtr extends Ptr<CFNetDiagnostic, CFNetDiagnosticPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFNetDiagnostic.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFNetDiagnostic() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFNetDiagnostic create(NSInputStream readStream, NSOutputStream writeStream) {
        return create(null, readStream, writeStream);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFNetDiagnostic create(NSURL url) {
        return create(null, url);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public CFNetDiagnosticStatus getNetworkStatusPassively() {
        return getNetworkStatusPassively(null);
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public String getNetworkStatusDescriptionPassively() {
        NSString.NSStringPtr ptr = new NSString.NSStringPtr();
        getNetworkStatusPassively(ptr);
        NSString desc = ptr.get();
        if (desc != null) return desc.toString();
        return null;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetDiagnosticCreateWithStreams", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFNetDiagnostic create(CFAllocator alloc, NSInputStream readStream, NSOutputStream writeStream);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetDiagnosticCreateWithURL", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFNetDiagnostic create(CFAllocator alloc, NSURL url);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetDiagnosticSetName", optional=true)
    public native void setName(String name);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetDiagnosticDiagnoseProblemInteractively", optional=true)
    public native CFNetDiagnosticStatus diagnoseProblemInteractively();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFNetDiagnosticCopyNetworkStatusPassively", optional=true)
    private native CFNetDiagnosticStatus getNetworkStatusPassively(NSString.NSStringPtr description);
    /*</methods>*/
}
