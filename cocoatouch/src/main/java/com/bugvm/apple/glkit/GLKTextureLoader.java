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
package com.bugvm.apple.glkit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("GLKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GLKTextureLoader/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GLKTextureLoaderPtr extends Ptr<GLKTextureLoader, GLKTextureLoaderPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GLKTextureLoader.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GLKTextureLoader() {}
    protected GLKTextureLoader(SkipInit skipInit) { super(skipInit); }
    public GLKTextureLoader(EAGLSharegroup sharegroup) { super((SkipInit) null); initObject(init(sharegroup)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithSharegroup:")
    protected native @Pointer long init(EAGLSharegroup sharegroup);
    @WeaklyLinked
    @Method(selector = "textureWithContentsOfFile:options:queue:completionHandler:")
    public native void loadTexture(String path, GLKTextureLoaderOptions options, DispatchQueue queue, @Block VoidBlock2<GLKTextureInfo, NSError> block);
    @WeaklyLinked
    @Method(selector = "textureWithContentsOfURL:options:queue:completionHandler:")
    public native void loadTexture(NSURL url, GLKTextureLoaderOptions options, DispatchQueue queue, @Block VoidBlock2<GLKTextureInfo, NSError> block);
    @WeaklyLinked
    @Method(selector = "textureWithContentsOfData:options:queue:completionHandler:")
    public native void createTexture(NSData data, GLKTextureLoaderOptions options, DispatchQueue queue, @Block VoidBlock2<GLKTextureInfo, NSError> block);
    @WeaklyLinked
    @Method(selector = "textureWithCGImage:options:queue:completionHandler:")
    public native void createTexture(CGImage cgImage, GLKTextureLoaderOptions options, DispatchQueue queue, @Block VoidBlock2<GLKTextureInfo, NSError> block);
    @WeaklyLinked
    @Method(selector = "cubeMapWithContentsOfFiles:options:queue:completionHandler:")
    public native void loadCubeMap(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> paths, GLKTextureLoaderOptions options, DispatchQueue queue, @Block VoidBlock2<GLKTextureInfo, NSError> block);
    @WeaklyLinked
    @Method(selector = "cubeMapWithContentsOfFile:options:queue:completionHandler:")
    public native void loadCubeMap(String path, GLKTextureLoaderOptions options, DispatchQueue queue, @Block VoidBlock2<GLKTextureInfo, NSError> block);
    @WeaklyLinked
    @Method(selector = "cubeMapWithContentsOfURL:options:queue:completionHandler:")
    public native void loadCubeMap(NSURL url, GLKTextureLoaderOptions options, DispatchQueue queue, @Block VoidBlock2<GLKTextureInfo, NSError> block);
    public static GLKTextureInfo loadTexture(String path, GLKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       GLKTextureInfo result = loadTexture(path, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "textureWithContentsOfFile:options:error:")
    private static native GLKTextureInfo loadTexture(String path, GLKTextureLoaderOptions options, NSError.NSErrorPtr outError);
    public static GLKTextureInfo loadTexture(NSURL url, GLKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       GLKTextureInfo result = loadTexture(url, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "textureWithContentsOfURL:options:error:")
    private static native GLKTextureInfo loadTexture(NSURL url, GLKTextureLoaderOptions options, NSError.NSErrorPtr outError);
    public static GLKTextureInfo createTexture(NSData data, GLKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       GLKTextureInfo result = createTexture(data, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "textureWithContentsOfData:options:error:")
    private static native GLKTextureInfo createTexture(NSData data, GLKTextureLoaderOptions options, NSError.NSErrorPtr outError);
    public static GLKTextureInfo createTexture(CGImage cgImage, GLKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       GLKTextureInfo result = createTexture(cgImage, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "textureWithCGImage:options:error:")
    private static native GLKTextureInfo createTexture(CGImage cgImage, GLKTextureLoaderOptions options, NSError.NSErrorPtr outError);
    public static GLKTextureInfo loadCubeMap(List<String> paths, GLKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       GLKTextureInfo result = loadCubeMap(paths, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "cubeMapWithContentsOfFiles:options:error:")
    private static native GLKTextureInfo loadCubeMap(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> paths, GLKTextureLoaderOptions options, NSError.NSErrorPtr outError);
    public static GLKTextureInfo loadCubeMap(String path, GLKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       GLKTextureInfo result = loadCubeMap(path, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "cubeMapWithContentsOfFile:options:error:")
    private static native GLKTextureInfo loadCubeMap(String path, GLKTextureLoaderOptions options, NSError.NSErrorPtr outError);
    public static GLKTextureInfo loadCubeMap(NSURL url, GLKTextureLoaderOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       GLKTextureInfo result = loadCubeMap(url, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "cubeMapWithContentsOfURL:options:error:")
    private static native GLKTextureInfo loadCubeMap(NSURL url, GLKTextureLoaderOptions options, NSError.NSErrorPtr outError);
    /*</methods>*/
}
