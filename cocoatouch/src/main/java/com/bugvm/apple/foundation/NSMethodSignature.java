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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMethodSignature/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSMethodSignaturePtr extends Ptr<NSMethodSignature, NSMethodSignaturePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSMethodSignature.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMethodSignature() {}
    protected NSMethodSignature(SkipInit skipInit) { super(skipInit); }
    public NSMethodSignature(@com.bugvm.rt.bro.annotation.Marshaler(StringMarshalers.AsDefaultCharsetZMarshaler.class) String types) { super(create(types)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "numberOfArguments")
    public native @MachineSizedUInt long getNumberOfArguments();
    @Property(selector = "frameLength")
    public native @MachineSizedUInt long getFrameLength();
    @Property(selector = "methodReturnType")
    public native @com.bugvm.rt.bro.annotation.Marshaler(StringMarshalers.AsDefaultCharsetZMarshaler.class) String getMethodReturnType();
    @Property(selector = "methodReturnLength")
    public native @MachineSizedUInt long getMethodReturnLength();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "getArgumentTypeAtIndex:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(StringMarshalers.AsDefaultCharsetZMarshaler.class) String getArgumentType(@MachineSizedUInt long idx);
    @Method(selector = "isOneway")
    public native boolean isOneway();
    @Method(selector = "signatureWithObjCTypes:")
    protected static native @Pointer long create(@com.bugvm.rt.bro.annotation.Marshaler(StringMarshalers.AsDefaultCharsetZMarshaler.class) String types);
    /*</methods>*/
}
