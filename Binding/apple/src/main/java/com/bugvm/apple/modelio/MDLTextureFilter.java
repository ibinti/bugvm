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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MDLTextureFilter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MDLTextureFilterPtr extends Ptr<MDLTextureFilter, MDLTextureFilterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MDLTextureFilter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MDLTextureFilter() {}
    protected MDLTextureFilter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "sWrapMode")
    public native MDLMaterialTextureWrapMode getSWrapMode();
    @Property(selector = "setSWrapMode:")
    public native void setSWrapMode(MDLMaterialTextureWrapMode v);
    @Property(selector = "tWrapMode")
    public native MDLMaterialTextureWrapMode getTWrapMode();
    @Property(selector = "setTWrapMode:")
    public native void setTWrapMode(MDLMaterialTextureWrapMode v);
    @Property(selector = "rWrapMode")
    public native MDLMaterialTextureWrapMode getRWrapMode();
    @Property(selector = "setRWrapMode:")
    public native void setRWrapMode(MDLMaterialTextureWrapMode v);
    @Property(selector = "minFilter")
    public native MDLMaterialTextureFilterMode getMinFilter();
    @Property(selector = "setMinFilter:")
    public native void setMinFilter(MDLMaterialTextureFilterMode v);
    @Property(selector = "magFilter")
    public native MDLMaterialTextureFilterMode getMagFilter();
    @Property(selector = "setMagFilter:")
    public native void setMagFilter(MDLMaterialTextureFilterMode v);
    @Property(selector = "mipFilter")
    public native MDLMaterialMipMapFilterMode getMipFilter();
    @Property(selector = "setMipFilter:")
    public native void setMipFilter(MDLMaterialMipMapFilterMode v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
