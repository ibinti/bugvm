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
package com.bugvm.apple.coremedia;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.audiotoolbox.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreMedia") @WeaklyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CMVideoFormatDescription/*</name>*/ 
    extends /*<extends>*/CMFormatDescription/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CMVideoFormatDescriptionPtr extends Ptr<CMVideoFormatDescription, CMVideoFormatDescriptionPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CMVideoFormatDescription.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @throws OSStatusException 
     * @since Available in iOS 4.0 and later.
     */
    public static CMVideoFormatDescription create(CMVideoCodecType codecType, int width, int height, CMVideoFormatDescriptionExtension extensions) throws OSStatusException {
        CMVideoFormatDescription.CMVideoFormatDescriptionPtr ptr = new CMVideoFormatDescription.CMVideoFormatDescriptionPtr();
        OSStatus status = create0(null, codecType, width, height, extensions, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    public static CMVideoFormatDescription create(CVImageBuffer imageBuffer) throws OSStatusException {
        CMVideoFormatDescription.CMVideoFormatDescriptionPtr ptr = new CMVideoFormatDescription.CMVideoFormatDescriptionPtr();
        OSStatus status = create0(null, imageBuffer, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }

    /**
     * @throws OSStatusException 
     * @since Available in iOS 8.0 and later.
     */
    public static CMVideoFormatDescription createFromBigEndianImageDescriptionData(BytePtr imageDescriptionData, @MachineSizedUInt long imageDescriptionSize, int imageDescriptionStringEncoding, String imageDescriptionFlavor) throws OSStatusException {
        CMVideoFormatDescription.CMVideoFormatDescriptionPtr ptr = new CMVideoFormatDescription.CMVideoFormatDescriptionPtr();
        OSStatus status = createFromBigEndianImageDescriptionData0(null, imageDescriptionData, imageDescriptionSize, imageDescriptionStringEncoding, imageDescriptionFlavor, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 8.0 and later.
     */
    public static CMVideoFormatDescription createFromBigEndianImageDescriptionBlockBuffer(CMBlockBuffer imageDescriptionBlockBuffer, int imageDescriptionStringEncoding, String imageDescriptionFlavor) throws OSStatusException {
        CMVideoFormatDescription.CMVideoFormatDescriptionPtr ptr = new CMVideoFormatDescription.CMVideoFormatDescriptionPtr();
        OSStatus status = createFromBigEndianImageDescriptionBlockBuffer0(null, imageDescriptionBlockBuffer, imageDescriptionStringEncoding, imageDescriptionFlavor, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 8.0 and later.
     */
    public static CMBlockBuffer copyAsBigEndianImageDescriptionBlockBuffer(CFAllocator allocator, CMVideoFormatDescription videoFormatDescription, int imageDescriptionStringEncoding, String imageDescriptionFlavor) throws OSStatusException {
        CMBlockBuffer.CMBlockBufferPtr ptr = new CMBlockBuffer.CMBlockBufferPtr();
        OSStatus status = copyAsBigEndianImageDescriptionBlockBuffer0(null, videoFormatDescription, imageDescriptionStringEncoding, imageDescriptionFlavor, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionCreate", optional=true)
    private static native OSStatus create0(CFAllocator allocator, CMVideoCodecType codecType, int width, int height, CMVideoFormatDescriptionExtension extensions, CMVideoFormatDescription.CMVideoFormatDescriptionPtr outDesc);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionCreateForImageBuffer", optional=true)
    private static native OSStatus create0(CFAllocator allocator, CVImageBuffer imageBuffer, CMVideoFormatDescription.CMVideoFormatDescriptionPtr outDesc);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionGetDimensions", optional=true)
    public native @ByVal CMVideoDimensions getDimensions();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    @Bridge(symbol="CMVideoFormatDescriptionGetPresentationDimensions", optional=true)
    public native @ByVal CGSize getPresentationDimensions(boolean usePixelAspectRatio, boolean useCleanAperture);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    @Bridge(symbol="CMVideoFormatDescriptionGetCleanAperture", optional=true)
    public native @ByVal CGRect getCleanAperture(boolean originIsAtTopLeft);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionGetExtensionKeysCommonWithImageBuffers", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFArray.AsStringListMarshaler.class) List<String> getExtensionKeysCommonWithImageBuffers();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionMatchesImageBuffer", optional=true)
    public native boolean matchesImageBuffer(CVImageBuffer imageBuffer);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionCreateFromBigEndianImageDescriptionData", optional=true)
    private static native OSStatus createFromBigEndianImageDescriptionData0(CFAllocator allocator, BytePtr imageDescriptionData, @MachineSizedUInt long imageDescriptionSize, int imageDescriptionStringEncoding, String imageDescriptionFlavor, CMVideoFormatDescription.CMVideoFormatDescriptionPtr videoFormatDescriptionOut);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionCreateFromBigEndianImageDescriptionBlockBuffer", optional=true)
    private static native OSStatus createFromBigEndianImageDescriptionBlockBuffer0(CFAllocator allocator, CMBlockBuffer imageDescriptionBlockBuffer, int imageDescriptionStringEncoding, String imageDescriptionFlavor, CMVideoFormatDescription.CMVideoFormatDescriptionPtr videoFormatDescriptionOut);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Bridge(symbol="CMVideoFormatDescriptionCopyAsBigEndianImageDescriptionBlockBuffer", optional=true)
    private static native OSStatus copyAsBigEndianImageDescriptionBlockBuffer0(CFAllocator allocator, CMVideoFormatDescription videoFormatDescription, int imageDescriptionStringEncoding, String imageDescriptionFlavor, CMBlockBuffer.CMBlockBufferPtr imageDescriptionBlockBufferOut);
    /*</methods>*/
}
