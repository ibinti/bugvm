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
package com.bugvm.apple.coregraphics;

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
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreGraphics")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CGPDFContentStream/*</name>*/ 
    extends /*<extends>*/NativeObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<?> toObject(Class<? extends CFType> cls, long handle, long flags) {
            CFArray o = (CFArray) CFType.Marshaler.toObject(cls, handle, flags);
            if (o == null) {
                return null;
            }
            return o.toList(CGPDFContentStream.class);
        }
        @MarshalsPointer
        public static long toNative(List<CGPDFContentStream> l, long flags) {
            if (l == null) {
                return 0L;
            }
            CFArray o = null;
            if (l instanceof CFArray) {
                o = (CFArray) l;
            } else {
                o = CFArray.create((List<CGPDFContentStream>) l);
            }
            return CFType.Marshaler.toNative(o, flags);
        }
    }
    
    /*<ptr>*/public static class CGPDFContentStreamPtr extends Ptr<CGPDFContentStream, CGPDFContentStreamPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CGPDFContentStream.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CGPDFContentStream() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFContentStreamCreateWithPage", optional=true)
    public static native CGPDFContentStream create(CGPDFPage page);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFContentStreamCreateWithStream", optional=true)
    public static native CGPDFContentStream create(CGPDFStream stream, CGPDFDictionary streamResources, CGPDFContentStream parent);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFContentStreamGetStreams", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CGPDFContentStream.AsListMarshaler.class) List<CGPDFContentStream> getStreams();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFContentStreamGetResource", optional=true)
    public native CGPDFObject getResource(@com.bugvm.rt.bro.annotation.Marshaler(StringMarshalers.AsAsciiZMarshaler.class) String category, @com.bugvm.rt.bro.annotation.Marshaler(StringMarshalers.AsAsciiZMarshaler.class) String name);
    /*</methods>*/
}
