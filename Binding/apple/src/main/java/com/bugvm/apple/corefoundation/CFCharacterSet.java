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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFCharacterSet/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFCharacterSetPtr extends Ptr<CFCharacterSet, CFCharacterSetPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFCharacterSet.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFCharacterSet() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static CFCharacterSet create(CFRange theRange) {
        return create(null, theRange);
    }
    public static CFCharacterSet create(String theString) {
        return create(null, theString);
    }
    public static CFCharacterSet create(CFData theData) {
        return create(null, theData);
    }
    public CFCharacterSet getInvertedSet() {
        return createInvertedSet(null, this);
    }
    public CFData getBitmapRepresentation() {
        return createBitmapRepresentation(null, this);
    }
    public CFData getBitmapRepresentation(CFAllocator allocator) {
        return createBitmapRepresentation(allocator, this);
    }
    /*<methods>*/
    @Bridge(symbol="CFCharacterSetGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    @Bridge(symbol="CFCharacterSetGetPredefined", optional=true)
    public static native CFCharacterSet getPredefined(CFCharacterSetPredefinedSet theSetIdentifier);
    @Bridge(symbol="CFCharacterSetCreateWithCharactersInRange", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFCharacterSet create(CFAllocator alloc, @ByVal CFRange theRange);
    @Bridge(symbol="CFCharacterSetCreateWithCharactersInString", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFCharacterSet create(CFAllocator alloc, String theString);
    @Bridge(symbol="CFCharacterSetCreateWithBitmapRepresentation", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFCharacterSet create(CFAllocator alloc, CFData theData);
    @Bridge(symbol="CFCharacterSetCreateInvertedSet", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFCharacterSet createInvertedSet(CFAllocator alloc, CFCharacterSet theSet);
    @Bridge(symbol="CFCharacterSetIsSupersetOfSet", optional=true)
    public native boolean isSupersetOf(CFCharacterSet theOtherset);
    @Bridge(symbol="CFCharacterSetHasMemberInPlane", optional=true)
    public native boolean hasMemberInPlane(@MachineSizedSInt long thePlane);
    @Bridge(symbol="CFCharacterSetCreateCopy", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFCharacterSet createCopy(CFAllocator alloc, CFCharacterSet theSet);
    @Bridge(symbol="CFCharacterSetIsCharacterMember", optional=true)
    public native boolean isCharacterMember(short theChar);
    @Bridge(symbol="CFCharacterSetIsLongCharacterMember", optional=true)
    public native boolean isLongCharacterMember(int theChar);
    @Bridge(symbol="CFCharacterSetCreateBitmapRepresentation", optional=true)
    private static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFData createBitmapRepresentation(CFAllocator alloc, CFCharacterSet theSet);
    /*</methods>*/
}
