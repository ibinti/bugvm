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
package com.bugvm.apple.modelio;

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
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("ModelIO") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLCheckerboardTexture/*</name>*/ 
    extends /*<extends>*/MDLTexture/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MDLCheckerboardTexturePtr extends Ptr<MDLCheckerboardTexture, MDLCheckerboardTexturePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLCheckerboardTexture.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLCheckerboardTexture() {}
    protected MDLCheckerboardTexture(SkipInit skipInit) { super(skipInit); }
    public MDLCheckerboardTexture(float divisions, String name, VectorInt2 dimensions, int channelCount, MDLTextureChannelEncoding channelEncoding, CGColor color1, CGColor color2) { super((SkipInit) null); initObject(init(divisions, name, dimensions, channelCount, channelEncoding, color1, color2)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "divisions")
    public native float getDivisions();
    @Property(selector = "setDivisions:")
    public native void setDivisions(float v);
    @Property(selector = "color1")
    public native CGColor getColor1();
    @Property(selector = "setColor1:")
    public native void setColor1(CGColor v);
    @Property(selector = "color2")
    public native CGColor getColor2();
    @Property(selector = "setColor2:")
    public native void setColor2(CGColor v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithDivisions:name:dimensions:channelCount:channelEncoding:color1:color2:")
    protected native @Pointer long init(float divisions, String name, VectorInt2 dimensions, int channelCount, MDLTextureChannelEncoding channelEncoding, CGColor color1, CGColor color2);
    /*</methods>*/
}
