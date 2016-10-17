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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSFileWrapper/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class NSFileWrapperPtr extends Ptr<NSFileWrapper, NSFileWrapperPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSFileWrapper.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSFileWrapper() {}
    protected NSFileWrapper(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public NSFileWrapper(NSURL url, NSFileWrapperReadingOptions options) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(url, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    public NSFileWrapper(@com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringMapMarshaler.class) Map<String, NSFileWrapper> childrenByPreferredName) { super((SkipInit) null); initObject(init(childrenByPreferredName)); }
    public NSFileWrapper(NSData contents) { super((SkipInit) null); initObject(init(contents)); }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public NSFileWrapper(NSURL url) { super((SkipInit) null); initObject(init(url)); }
    public NSFileWrapper(NSCoder inCoder) { super((SkipInit) null); initObject(init(inCoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isDirectory")
    public native boolean isDirectory();
    @Property(selector = "isRegularFile")
    public native boolean isRegularFile();
    @Property(selector = "isSymbolicLink")
    public native boolean isSymbolicLink();
    @Property(selector = "preferredFilename")
    public native String getPreferredFilename();
    @Property(selector = "setPreferredFilename:")
    public native void setPreferredFilename(String v);
    @Property(selector = "filename")
    public native String getFilename();
    @Property(selector = "setFilename:")
    public native void setFilename(String v);
    @Property(selector = "fileAttributes")
    public native NSFileAttributes getFileAttributes();
    @Property(selector = "setFileAttributes:")
    public native void setFileAttributes(NSFileAttributes v);
    @Property(selector = "serializedRepresentation")
    public native NSData getSerializedRepresentation();
    @Property(selector = "fileWrappers")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringMapMarshaler.class) Map<String, NSFileWrapper> getFileWrappers();
    @Property(selector = "regularFileContents")
    public native NSData getRegularFileContents();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "symbolicLinkDestinationURL")
    public native NSURL getSymbolicLinkDestinationURL();
    /*</properties>*/
    /*<members>*//*</members>*/
    
    public static NSFileWrapper deserialize(NSData data) {
        NSFileWrapper wrapper = new NSFileWrapper((SkipInit) null);
        long handle = wrapper.initSerialized(data);
        if (handle == 0) {
            return null;
        }
        wrapper.initObject(handle);
        return wrapper;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "initWithURL:options:error:")
    private native @Pointer long init(NSURL url, NSFileWrapperReadingOptions options, NSError.NSErrorPtr outError);
    @Method(selector = "initDirectoryWithFileWrappers:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringMapMarshaler.class) Map<String, NSFileWrapper> childrenByPreferredName);
    @Method(selector = "initRegularFileWithContents:")
    protected native @Pointer long init(NSData contents);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "initSymbolicLinkWithDestinationURL:")
    protected native @Pointer long init(NSURL url);
    @Method(selector = "initWithSerializedRepresentation:")
    protected native @Pointer long initSerialized(NSData serializeRepresentation);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder inCoder);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "matchesContentsOfURL:")
    public native boolean matchesContentsOfURL(NSURL url);
    /**
     * @since Available in iOS 4.0 and later.
     */
    public boolean readFromURL(NSURL url, NSFileWrapperReadingOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = readFromURL(url, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "readFromURL:options:error:")
    private native boolean readFromURL(NSURL url, NSFileWrapperReadingOptions options, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 4.0 and later.
     */
    public boolean writeToURL(NSURL url, NSFileWrapperWritingOptions options, NSURL originalContentsURL) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = writeToURL(url, options, originalContentsURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "writeToURL:options:originalContentsURL:error:")
    private native boolean writeToURL(NSURL url, NSFileWrapperWritingOptions options, NSURL originalContentsURL, NSError.NSErrorPtr outError);
    @Method(selector = "addFileWrapper:")
    public native String addFileWrapper(NSFileWrapper child);
    @Method(selector = "addRegularFileWithContents:preferredFilename:")
    public native String addRegularFile(NSData data, String fileName);
    @Method(selector = "removeFileWrapper:")
    public native void removeFileWrapper(NSFileWrapper child);
    @Method(selector = "keyForFileWrapper:")
    public native String getKeyForFileWrapper(NSFileWrapper child);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    /*</methods>*/
}
