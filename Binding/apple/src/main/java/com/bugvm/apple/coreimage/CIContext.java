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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CIContext/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CIContextPtr extends Ptr<CIContext, CIContextPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CIContext.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CIContext() {}
    protected CIContext(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    
    public CIContext(CIContextOptions options) {
        super(init(options));
    }
    public CIContext(EAGLContext eaglContext) {
        super(init(eaglContext));
    }
    public CIContext(EAGLContext eaglContext, CIContextOptions options) {
        super(init(eaglContext, options));
    }
    
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 6.0.
     */
    @Deprecated
    @Method(selector = "drawImage:atPoint:fromRect:")
    public native void drawImage(CIImage im, @ByVal CGPoint p, @ByVal CGRect src);
    @Method(selector = "drawImage:inRect:fromRect:")
    public native void drawImage(CIImage im, @ByVal CGRect dest, @ByVal CGRect src);
    @WeaklyLinked
    @Method(selector = "createCGImage:fromRect:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CGImage createCGImage(CIImage im, @ByVal CGRect r);
    @WeaklyLinked
    @Method(selector = "createCGImage:fromRect:format:colorSpace:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CGImage createCGImage(CIImage im, @ByVal CGRect r, int f, CGColorSpace cs);
    @WeaklyLinked
    @Method(selector = "render:toBitmap:rowBytes:bounds:format:colorSpace:")
    public native void render(CIImage im, VoidPtr data, @MachineSizedSInt long rb, @ByVal CGRect r, int f, CGColorSpace cs);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "render:toCVPixelBuffer:")
    public native void render(CIImage image, CVPixelBuffer buffer);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "render:toCVPixelBuffer:bounds:colorSpace:")
    public native void render(CIImage image, CVPixelBuffer buffer, @ByVal CGRect r, CGColorSpace cs);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "inputImageMaximumSize")
    public native @ByVal CGSize getInputImageMaximumSize();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "outputImageMaximumSize")
    public native @ByVal CGSize getOutputImageMaximumSize();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "contextWithOptions:")
    protected static native @Pointer long init(CIContextOptions options);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "contextWithEAGLContext:")
    protected static native @Pointer long init(EAGLContext eaglContext);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Method(selector = "contextWithEAGLContext:options:")
    protected static native @Pointer long init(EAGLContext eaglContext, CIContextOptions options);
    /*</methods>*/
}
