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
package com.bugvm.apple.metalkit;

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
import com.bugvm.apple.metal.*;
import com.bugvm.apple.modelio.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreanimation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MetalKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MTKTextureLoader/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MTKTextureLoaderPtr extends Ptr<MTKTextureLoader, MTKTextureLoaderPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MTKTextureLoader.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MTKTextureLoader() {}
    protected MTKTextureLoader(SkipInit skipInit) { super(skipInit); }
    public MTKTextureLoader(MTLDevice device) { super((SkipInit) null); initObject(init(device)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "device")
    public native MTLDevice getDevice();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithDevice:")
    protected native @Pointer long init(MTLDevice device);
    @Method(selector = "newTextureWithContentsOfURL:options:completionHandler:")
    public native void newTexture(NSURL URL, MTKTextureLoaderOptions options, @Block VoidBlock2<MTLTexture, NSError> completionHandler);
    @Method(selector = "newTextureWithData:options:completionHandler:")
    public native void newTexture(NSData data, MTKTextureLoaderOptions options, @Block VoidBlock2<MTLTexture, NSError> completionHandler);
    @Method(selector = "newTextureWithCGImage:options:completionHandler:")
    public native void newTexture(CGImage cgImage, MTKTextureLoaderOptions options, @Block VoidBlock2<MTLTexture, NSError> completionHandler);
    public MTLTexture newTexture(NSURL URL, MTKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       MTLTexture result = newTexture(URL, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "newTextureWithContentsOfURL:options:error:")
    private native MTLTexture newTexture(NSURL URL, MTKTextureLoaderOptions options, NSError.NSErrorPtr error);
    public MTLTexture newTexture(NSData data, MTKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       MTLTexture result = newTexture(data, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "newTextureWithData:options:error:")
    private native MTLTexture newTexture(NSData data, MTKTextureLoaderOptions options, NSError.NSErrorPtr error);
    public MTLTexture newTexture(CGImage cgImage, MTKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       MTLTexture result = newTexture(cgImage, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "newTextureWithCGImage:options:error:")
    private native MTLTexture newTexture(CGImage cgImage, MTKTextureLoaderOptions options, NSError.NSErrorPtr error);
    /*</methods>*/
}
