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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GLKEffectPropertyMaterial/*</name>*/ 
    extends /*<extends>*/GLKEffectProperty/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GLKEffectPropertyMaterialPtr extends Ptr<GLKEffectPropertyMaterial, GLKEffectPropertyMaterialPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GLKEffectPropertyMaterial.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GLKEffectPropertyMaterial() {}
    protected GLKEffectPropertyMaterial(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "ambientColor")
    public native @ByVal GLKVector4 getAmbientColor();
    @Property(selector = "setAmbientColor:")
    public native void setAmbientColor(@ByVal GLKVector4 v);
    @Property(selector = "diffuseColor")
    public native @ByVal GLKVector4 getDiffuseColor();
    @Property(selector = "setDiffuseColor:")
    public native void setDiffuseColor(@ByVal GLKVector4 v);
    @Property(selector = "specularColor")
    public native @ByVal GLKVector4 getSpecularColor();
    @Property(selector = "setSpecularColor:")
    public native void setSpecularColor(@ByVal GLKVector4 v);
    @Property(selector = "emissiveColor")
    public native @ByVal GLKVector4 getEmissiveColor();
    @Property(selector = "setEmissiveColor:")
    public native void setEmissiveColor(@ByVal GLKVector4 v);
    @Property(selector = "shininess")
    public native float getShininess();
    @Property(selector = "setShininess:")
    public native void setShininess(float v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
