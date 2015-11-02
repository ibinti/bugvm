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
import com.bugvm.apple.foundation.NSObject.SkipInit;

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSOutputStream/*</name>*/ 
    extends /*<extends>*/NSStream/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSOutputStreamPtr extends Ptr<NSOutputStream, NSOutputStreamPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSOutputStream.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected NSOutputStream(SkipInit skipInit) { super(skipInit); }
    public NSOutputStream() { super((SkipInit) null); initObject(init()); }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public NSOutputStream(NSURL url, boolean shouldAppend) { super((SkipInit) null); initObject(init(url, shouldAppend)); }
    public NSOutputStream(String path, boolean shouldAppend) { super((SkipInit) null); initObject(init(path, shouldAppend)); }
    /*</constructors>*/
    public NSOutputStream(byte[] bytes) {
        super((SkipInit) null);
        if (bytes == null) {
            throw new NullPointerException("bytes");
        }
        initObject(init(VM.getArrayValuesAddress(bytes), bytes.length));
    }
    public NSOutputStream(ByteBuffer bytes) {
        super((SkipInit) null);
        if (bytes == null) {
            throw new NullPointerException("bytes");
        }
        long handle = NSData.getEffectiveAddress(bytes) + bytes.position();
        initObject(init(handle, bytes.remaining()));
        addStrongRef(bytes);
    }
    /*<properties>*/
    @Property(selector = "hasSpaceAvailable")
    public native boolean hasSpaceAvailable();
    /*</properties>*/
    /*<members>*//*</members>*/

    public long write(BytePtr buffer, long len) {
        return write(buffer.getHandle(), len);
    }
    public long write(ByteBuffer bytes) {
        long handle = NSData.getEffectiveAddress(bytes) + bytes.position();
        return write(handle, bytes.remaining());
    }
    public long write(byte[] bytes) {
        return write(bytes, 0, bytes.length);
    }
    public long write(byte[] bytes, int offset, int length) {
        NSMutableData.checkOffsetAndCount(bytes.length, offset, length);
        if (length == 0) {
            return 0;
        }
        return write(VM.getArrayValuesAddress(bytes) + offset, length);
    }
    
    /*<methods>*/
    @Method(selector = "write:maxLength:")
    protected native @MachineSizedSInt long write(@Pointer long buffer, @MachineSizedUInt long len);
    @Method(selector = "initToMemory")
    protected native @Pointer long init();
    @Method(selector = "initToBuffer:capacity:")
    protected native @Pointer long init(@Pointer long buffer, @MachineSizedUInt long capacity);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "initWithURL:append:")
    protected native @Pointer long init(NSURL url, boolean shouldAppend);
    @Method(selector = "initToFileAtPath:append:")
    protected native @Pointer long init(String path, boolean shouldAppend);
    /*</methods>*/
}
