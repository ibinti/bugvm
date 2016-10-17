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
package com.bugvm.apple.imageio;

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
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("ImageIO")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CGImageDestination/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CGImageDestinationPtr extends Ptr<CGImageDestination, CGImageDestinationPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CGImageDestination.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CGImageDestination() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationCopyTypeIdentifiers", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFArray.AsStringListMarshaler.class) List<String> getTypeIdentifiers();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationCreateWithDataConsumer", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CGImageDestination create(CGDataConsumer consumer, String type, @MachineSizedUInt long count, NSDictionary options);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationCreateWithData", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CGImageDestination create(NSData data, String type, @MachineSizedUInt long count, NSDictionary options);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationCreateWithURL", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CGImageDestination create(NSURL url, String type, @MachineSizedUInt long count, NSDictionary options);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationSetProperties", optional=true)
    public native void setProperties(CGImageDestinationProperties properties);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationAddImage", optional=true)
    public native void addImage(CGImage image, CGImageDestinationProperties properties);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CGImageDestinationAddImageFromSource", optional=true)
    public native void addImageFromSource(CGImageSource isrc, @MachineSizedUInt long index, CGImageDestinationProperties properties);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Bridge(symbol="CGImageDestinationAddImageAndMetadata", optional=true)
    public native void addImageAndMetadata(CGImage image, CGImageMetadata metadata, NSDictionary options);
    /**
     * @since Available in iOS 7.0 and later.
     */
    public boolean copyImageSource(CGImageSource isrc, CGImageDestinationCopySourceOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = copyImageSource(isrc, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Bridge(symbol="CGImageDestinationCopyImageSource", optional=true)
    private native boolean copyImageSource(CGImageSource isrc, CGImageDestinationCopySourceOptions options, NSError.NSErrorPtr error);
    /*</methods>*/
}
