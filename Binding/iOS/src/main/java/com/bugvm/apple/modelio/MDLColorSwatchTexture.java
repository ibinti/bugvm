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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLColorSwatchTexture/*</name>*/ 
    extends /*<extends>*/MDLTexture/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MDLColorSwatchTexturePtr extends Ptr<MDLColorSwatchTexture, MDLColorSwatchTexturePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLColorSwatchTexture.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLColorSwatchTexture() {}
    protected MDLColorSwatchTexture(SkipInit skipInit) { super(skipInit); }
    public MDLColorSwatchTexture(float colorTemperature1, float colorTemperature2, String name, VectorInt2 textureDimensions) { super((SkipInit) null); initObject(init(colorTemperature1, colorTemperature2, name, textureDimensions)); }
    public MDLColorSwatchTexture(CGColor color1, CGColor color2, String name, VectorInt2 textureDimensions) { super((SkipInit) null); initObject(init(color1, color2, name, textureDimensions)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithColorTemperatureGradientFrom:toColorTemperature:name:textureDimensions:")
    protected native @Pointer long init(float colorTemperature1, float colorTemperature2, String name, VectorInt2 textureDimensions);
    @Method(selector = "initWithColorGradientFrom:toColor:name:textureDimensions:")
    protected native @Pointer long init(CGColor color1, CGColor color2, String name, VectorInt2 textureDimensions);
    /*</methods>*/
}
