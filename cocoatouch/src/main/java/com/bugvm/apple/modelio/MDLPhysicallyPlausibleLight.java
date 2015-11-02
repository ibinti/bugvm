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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLPhysicallyPlausibleLight/*</name>*/ 
    extends /*<extends>*/MDLLight/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MDLPhysicallyPlausibleLightPtr extends Ptr<MDLPhysicallyPlausibleLight, MDLPhysicallyPlausibleLightPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLPhysicallyPlausibleLight.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLPhysicallyPlausibleLight() {}
    protected MDLPhysicallyPlausibleLight(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "color")
    public native CGColor getColor();
    @Property(selector = "setColor:")
    public native void setColor(CGColor v);
    @Property(selector = "lumens")
    public native float getLumens();
    @Property(selector = "setLumens:")
    public native void setLumens(float v);
    @Property(selector = "innerConeAngle")
    public native float getInnerConeAngle();
    @Property(selector = "setInnerConeAngle:")
    public native void setInnerConeAngle(float v);
    @Property(selector = "outerConeAngle")
    public native float getOuterConeAngle();
    @Property(selector = "setOuterConeAngle:")
    public native void setOuterConeAngle(float v);
    @Property(selector = "attenuationStartDistance")
    public native float getAttenuationStartDistance();
    @Property(selector = "setAttenuationStartDistance:")
    public native void setAttenuationStartDistance(float v);
    @Property(selector = "attenuationEndDistance")
    public native float getAttenuationEndDistance();
    @Property(selector = "setAttenuationEndDistance:")
    public native void setAttenuationEndDistance(float v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "setColorByTemperature:")
    public native void setColorByTemperature(float temperature);
    /*</methods>*/
}
