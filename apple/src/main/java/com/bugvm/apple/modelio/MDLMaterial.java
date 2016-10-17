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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLMaterial/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements MDLNamed, NSFastEnumeration/*</implements>*/ {

    /*<ptr>*/public static class MDLMaterialPtr extends Ptr<MDLMaterial, MDLMaterialPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLMaterial.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLMaterial() {}
    protected MDLMaterial(SkipInit skipInit) { super(skipInit); }
    public MDLMaterial(String name, MDLScatteringFunction scatteringFunction) { super((SkipInit) null); initObject(init(name, scatteringFunction)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "scatteringFunction")
    public native MDLScatteringFunction getScatteringFunction();
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "setName:")
    public native void setName(String v);
    @Property(selector = "baseMaterial")
    public native MDLMaterial getBaseMaterial();
    @Property(selector = "setBaseMaterial:")
    public native void setBaseMaterial(MDLMaterial v);
    @Property(selector = "count")
    public native @MachineSizedUInt long getCount();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithName:scatteringFunction:")
    protected native @Pointer long init(String name, MDLScatteringFunction scatteringFunction);
    @Method(selector = "setProperty:")
    public native void setProperty(MDLMaterialProperty property);
    @Method(selector = "removeProperty:")
    public native void removeProperty(MDLMaterialProperty property);
    @Method(selector = "propertyNamed:")
    public native MDLMaterialProperty getProperty(String name);
    @Method(selector = "propertyWithSemantic:")
    public native MDLMaterialProperty getProperty(MDLMaterialSemantic semantic);
    @Method(selector = "removeAllProperties")
    public native void removeAllProperties();
    @Method(selector = "objectAtIndexedSubscript:")
    public native MDLMaterialProperty getProperty(@MachineSizedUInt long idx);
    /*</methods>*/
}
