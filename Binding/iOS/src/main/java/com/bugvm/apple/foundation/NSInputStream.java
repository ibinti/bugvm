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

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSInputStream/*</name>*/ 
    extends /*<extends>*/NSStream/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSInputStreamPtr extends Ptr<NSInputStream, NSInputStreamPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSInputStream.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSInputStream() {}
    protected NSInputStream(SkipInit skipInit) { super(skipInit); }
    public NSInputStream(NSData data) { super((SkipInit) null); initObject(init(data)); }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public NSInputStream(NSURL url) { super((SkipInit) null); initObject(init(url)); }
    public NSInputStream(String path) { super((SkipInit) null); initObject(init(path)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "hasBytesAvailable")
    public native boolean hasBytesAvailable();
    /*</properties>*/
    /*<members>*//*</members>*/
    
    public long read(BytePtr buffer, long len) {
        return read(buffer.getHandle(), len);
    }

    public long read(ByteBuffer bytes) {
        long handle = NSData.getEffectiveAddress(bytes) + bytes.position();
        return read(handle, bytes.remaining());
    }

    public long read(byte[] bytes) {
        return read(bytes, 0, bytes.length);
    }
    
    public long read(byte[] bytes, int offset, int length) {
        NSMutableData.checkOffsetAndCount(bytes.length, offset, length);
        if (length == 0) {
            return 0;
        }
        return read(VM.getArrayValuesAddress(bytes) + offset, length);
    }
    
    /*<methods>*/
    @Method(selector = "read:maxLength:")
    protected native @MachineSizedSInt long read(@Pointer long buffer, @MachineSizedUInt long len);
    @Method(selector = "initWithData:")
    protected native @Pointer long init(NSData data);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "initWithURL:")
    protected native @Pointer long init(NSURL url);
    @Method(selector = "initWithFileAtPath:")
    protected native @Pointer long init(String path);
    /*</methods>*/
}
