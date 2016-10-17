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
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSUUID/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSUUIDPtr extends Ptr<NSUUID, NSUUIDPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSUUID.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSUUID() {}
    protected NSUUID(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    
    public NSUUID(UUID uuid) {
        this(uuid.toString());
    }
    
    public NSUUID(String string) {
        super((SkipInit) null);
        initObject(init(string));
    }

    public NSUUID(byte[] bytes) {
        super((SkipInit) null);
        if (bytes == null) {
            throw new NullPointerException("bytes");
        }
        if (bytes.length != 16) {
            throw new IllegalArgumentException("bytes.length != 16 (" + bytes.length + ")");
        }
        initObject(init(VM.getArrayValuesAddress(bytes)));
    }

    /*<properties>*/
    @Property(selector = "UUIDString")
    public native String asString();
    /*</properties>*/
    /*<members>*//*</members>*/
    
    public byte[] getBytes() {
        byte[] bytes = new byte[16];
        getUUIDBytes(VM.getArrayValuesAddress(bytes));
        return bytes;
    }
    
    public UUID toUUID() {
        return UUID.fromString(asString());
    }
    
    /*<methods>*/
    @Method(selector = "initWithUUIDString:")
    protected native @Pointer long init(String string);
    @Method(selector = "initWithUUIDBytes:")
    protected native @Pointer long init(@Pointer long bytes);
    @Method(selector = "getUUIDBytes:")
    protected native void getUUIDBytes(@Pointer long uuid);
    /*</methods>*/
}
