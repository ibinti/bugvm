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
package com.bugvm.apple.spritekit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.avfoundation.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.scenekit.*;
import com.bugvm.apple.gameplaykit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("SpriteKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKShader/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class SKShaderPtr extends Ptr<SKShader, SKShaderPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKShader.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKShader() {}
    protected SKShader(SkipInit skipInit) { super(skipInit); }
    public SKShader(String source) { super((SkipInit) null); initObject(init(source)); }
    public SKShader(String source, NSArray<SKUniform> uniforms) { super((SkipInit) null); initObject(init(source, uniforms)); }
    public SKShader(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    public SKShader(File file) {
        super(createWithFile(file.getAbsolutePath()));
    }
    /*<properties>*/
    @Property(selector = "source")
    public native String getSource();
    @Property(selector = "setSource:")
    public native void setSource(String v);
    @Property(selector = "uniforms")
    public native NSArray<SKUniform> getUniforms();
    @Property(selector = "setUniforms:")
    public native void setUniforms(NSArray<SKUniform> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithSource:")
    protected native @Pointer long init(String source);
    @Method(selector = "initWithSource:uniforms:")
    protected native @Pointer long init(String source, NSArray<SKUniform> uniforms);
    @Method(selector = "addUniform:")
    public native void addUniform(SKUniform uniform);
    @Method(selector = "uniformNamed:")
    public native SKUniform getUniform(String name);
    @Method(selector = "removeUniformNamed:")
    public native void removeUniform(String name);
    @Method(selector = "shaderWithFileNamed:")
    protected static native @Pointer long createWithFile(String name);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
