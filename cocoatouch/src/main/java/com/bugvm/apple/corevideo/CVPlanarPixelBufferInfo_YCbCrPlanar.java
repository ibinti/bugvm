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
package com.bugvm.apple.corevideo;

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
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CVPlanarPixelBufferInfo_YCbCrPlanar/*</name>*/ 
    extends /*<extends>*/Struct<CVPlanarPixelBufferInfo_YCbCrPlanar>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CVPlanarPixelBufferInfo_YCbCrPlanarPtr extends Ptr<CVPlanarPixelBufferInfo_YCbCrPlanar, CVPlanarPixelBufferInfo_YCbCrPlanarPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CVPlanarPixelBufferInfo_YCbCrPlanar() {}
    public CVPlanarPixelBufferInfo_YCbCrPlanar(CVPlanarComponentInfo componentInfoY, CVPlanarComponentInfo componentInfoCb, CVPlanarComponentInfo componentInfoCr) {
        this.setComponentInfoY(componentInfoY);
        this.setComponentInfoCb(componentInfoCb);
        this.setComponentInfoCr(componentInfoCr);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @ByVal CVPlanarComponentInfo getComponentInfoY();
    @StructMember(0) public native CVPlanarPixelBufferInfo_YCbCrPlanar setComponentInfoY(@ByVal CVPlanarComponentInfo componentInfoY);
    @StructMember(1) public native @ByVal CVPlanarComponentInfo getComponentInfoCb();
    @StructMember(1) public native CVPlanarPixelBufferInfo_YCbCrPlanar setComponentInfoCb(@ByVal CVPlanarComponentInfo componentInfoCb);
    @StructMember(2) public native @ByVal CVPlanarComponentInfo getComponentInfoCr();
    @StructMember(2) public native CVPlanarPixelBufferInfo_YCbCrPlanar setComponentInfoCr(@ByVal CVPlanarComponentInfo componentInfoCr);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
