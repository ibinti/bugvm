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
/*<annotations>*/@Library("CoreVideo")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CVOpenGLESTexture/*</name>*/ 
    extends /*<extends>*/CVImageBuffer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CVOpenGLESTexturePtr extends Ptr<CVOpenGLESTexture, CVOpenGLESTexturePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CVOpenGLESTexture.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    public float[] getCleanTexCoords() {
        FloatPtr lowerLeft = new FloatPtr();
        FloatPtr lowerRight = new FloatPtr();
        FloatPtr upperRight = new FloatPtr();
        FloatPtr upperLeft = new FloatPtr();
        getCleanTexCoords(lowerLeft, lowerRight, upperRight, upperLeft);
        float[] coords = {lowerLeft.get(), lowerRight.get(), upperRight.get(), upperLeft.get()};
        return coords;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureGetTarget", optional=true)
    public native int getTarget();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureGetName", optional=true)
    public native int getName();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureIsFlipped", optional=true)
    public native boolean isFlipped();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureGetCleanTexCoords", optional=true)
    protected native void getCleanTexCoords(FloatPtr lowerLeft, FloatPtr lowerRight, FloatPtr upperRight, FloatPtr upperLeft);
    /*</methods>*/
}
