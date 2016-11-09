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
package com.bugvm.apple.coreimage;

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
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.imageio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("CoreImage") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CIImage/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class CIImagePtr extends Ptr<CIImage, CIImagePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CIImage.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CIImage() {}
    protected CIImage(SkipInit skipInit) { super(skipInit); }
    public CIImage(CGImage image) { super((SkipInit) null); initObject(init(image)); }
    public CIImage(CGImage image, CIImageOptions d) { super((SkipInit) null); initObject(init(image, d)); }
    public CIImage(NSData data) { super((SkipInit) null); initObject(init(data)); }
    public CIImage(NSData data, CIImageOptions d) { super((SkipInit) null); initObject(init(data, d)); }
    public CIImage(CIImageOptions d, @MachineSizedUInt long bpr, @ByVal CGSize size, int f, CGColorSpace c) { super((SkipInit) null); initObject(init(d, bpr, size, f, c)); }
    /**
     * @since Available in iOS 6.0 and later.
     */
    public CIImage(int name, @ByVal CGSize size, boolean flag, CGColorSpace cs) { super((SkipInit) null); initObject(init(name, size, flag, cs)); }
    public CIImage(NSURL url) { super((SkipInit) null); initObject(init(url)); }
    public CIImage(NSURL url, CIImageOptions d) { super((SkipInit) null); initObject(init(url, d)); }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public CIImage(CVPixelBuffer buffer) { super((SkipInit) null); initObject(init(buffer)); }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public CIImage(CVPixelBuffer buffer, NSDictionary dict) { super((SkipInit) null); initObject(init(buffer, dict)); }
    public CIImage(CIColor color) { super((SkipInit) null); initObject(init(color)); }
    public CIImage(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CIImage(com.bugvm.apple.uikit.UIImage image) {
        super((SkipInit) null);
        CIImage i = com.bugvm.apple.uikit.CIImageExtensions.create(image);
        initObject(i.getHandle());
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CIImage(com.bugvm.apple.uikit.UIImage image, CIImageOptions options) {
        super((SkipInit) null);
        CIImage i = com.bugvm.apple.uikit.CIImageExtensions.create(image, options);
        initObject(i.getHandle());
    }
    /*<methods>*/
    @Method(selector = "initWithCGImage:")
    protected native @Pointer long init(CGImage image);
    @Method(selector = "initWithCGImage:options:")
    protected native @Pointer long init(CGImage image, CIImageOptions d);
    @Method(selector = "initWithData:")
    protected native @Pointer long init(NSData data);
    @Method(selector = "initWithData:options:")
    protected native @Pointer long init(NSData data, CIImageOptions d);
    @Method(selector = "initWithBitmapData:bytesPerRow:size:format:colorSpace:")
    protected native @Pointer long init(CIImageOptions d, @MachineSizedUInt long bpr, @ByVal CGSize size, int f, CGColorSpace c);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "initWithTexture:size:flipped:colorSpace:")
    protected native @Pointer long init(int name, @ByVal CGSize size, boolean flag, CGColorSpace cs);
    @Method(selector = "initWithContentsOfURL:")
    protected native @Pointer long init(NSURL url);
    @Method(selector = "initWithContentsOfURL:options:")
    protected native @Pointer long init(NSURL url, CIImageOptions d);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "initWithCVPixelBuffer:")
    protected native @Pointer long init(CVPixelBuffer buffer);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "initWithCVPixelBuffer:options:")
    protected native @Pointer long init(CVPixelBuffer buffer, NSDictionary dict);
    @Method(selector = "initWithColor:")
    protected native @Pointer long init(CIColor color);
    @Method(selector = "imageByApplyingTransform:")
    public native CIImage newImageByApplyingTransform(@ByVal CGAffineTransform matrix);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "imageByApplyingOrientation:")
    public native CIImage newImageByApplyingOrientation(CGImagePropertyOrientation orientation);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "imageTransformForOrientation:")
    public native @ByVal CGAffineTransform getImageTransformForOrientation(CGImagePropertyOrientation orientation);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "imageByCompositingOverImage:")
    public native CIImage newImageByCompositingOverImage(CIImage dest);
    @Method(selector = "imageByCroppingToRect:")
    public native CIImage newImageByCroppingToRect(@ByVal CGRect r);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "imageByClampingToExtent")
    public native CIImage newImageByClampingToExtent();
    @Method(selector = "extent")
    public native @ByVal CGRect getExtent();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "imageByApplyingFilter:withInputParameters:")
    public native CIImage newImageByApplyingFilter(String filterName, CIFilterInputParameters params);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "properties")
    public native CGImageProperties getProperties();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "regionOfInterestForImage:inRect:")
    public native @ByVal CGRect getRegionOfInterest(CIImage im, @ByVal CGRect r);
    @Method(selector = "emptyImage")
    public static native CIImage getEmptyImage();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "autoAdjustmentFilters")
    public native NSArray<CIFilter> getAutoAdjustmentFilters();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "autoAdjustmentFiltersWithOptions:")
    public native NSArray<CIFilter> getAutoAdjustmentFilters(CIImageAutoAdjustOptions options);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
