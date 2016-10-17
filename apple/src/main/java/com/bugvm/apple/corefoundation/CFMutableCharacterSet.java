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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreFoundation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFMutableCharacterSet/*</name>*/ 
    extends /*<extends>*/CFCharacterSet/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFMutableCharacterSetPtr extends Ptr<CFMutableCharacterSet, CFMutableCharacterSetPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFMutableCharacterSet.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    protected CFMutableCharacterSet() {}
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static CFMutableCharacterSet create() {
        return create((CFAllocator)null);
    }
    public static CFMutableCharacterSet createCopy(CFCharacterSet theSet) {
        return createCopy(null, theSet);
    }
    /*<methods>*/
    @Bridge(symbol="CFCharacterSetCreateMutable", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFMutableCharacterSet create(CFAllocator alloc);
    @Bridge(symbol="CFCharacterSetCreateMutableCopy", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFMutableCharacterSet createCopy(CFAllocator alloc, CFCharacterSet theSet);
    @Bridge(symbol="CFCharacterSetAddCharactersInRange", optional=true)
    public native void addCharactersInRange(@ByVal CFRange theRange);
    @Bridge(symbol="CFCharacterSetRemoveCharactersInRange", optional=true)
    public native void removeCharactersInRange(@ByVal CFRange theRange);
    @Bridge(symbol="CFCharacterSetAddCharactersInString", optional=true)
    public native void addCharactersInString(String theString);
    @Bridge(symbol="CFCharacterSetRemoveCharactersInString", optional=true)
    public native void removeCharactersInString(String theString);
    @Bridge(symbol="CFCharacterSetUnion", optional=true)
    public native void union(CFCharacterSet theOtherSet);
    @Bridge(symbol="CFCharacterSetIntersect", optional=true)
    public native void intersect(CFCharacterSet theOtherSet);
    @Bridge(symbol="CFCharacterSetInvert", optional=true)
    public native void invert();
    /*</methods>*/
}
