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
/*</javadoc>*/
/*<annotations>*/@Library("GLKit")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GLKMatrixStack/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GLKMatrixStackPtr extends Ptr<GLKMatrixStack, GLKMatrixStackPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(GLKMatrixStack.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected GLKMatrixStack() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Bridge(symbol="GLKMatrixStackCreate", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) GLKMatrixStack create(CFAllocator alloc);
    @Bridge(symbol="GLKMatrixStackGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    @Bridge(symbol="GLKMatrixStackPush", optional=true)
    public native void push();
    @Bridge(symbol="GLKMatrixStackPop", optional=true)
    public native void pop();
    @Bridge(symbol="GLKMatrixStackSize", optional=true)
    public native int size();
    @Bridge(symbol="GLKMatrixStackLoadMatrix4", optional=true)
    public native void loadMatrix4(@ByVal GLKMatrix4 matrix);
    @Bridge(symbol="GLKMatrixStackGetMatrix4", optional=true)
    public native @ByVal GLKMatrix4 getMatrix4();
    @Bridge(symbol="GLKMatrixStackGetMatrix3", optional=true)
    public native @ByVal GLKMatrix3 getMatrix3();
    @Bridge(symbol="GLKMatrixStackGetMatrix2", optional=true)
    public native @ByVal GLKMatrix2 getMatrix2();
    @Bridge(symbol="GLKMatrixStackGetMatrix4Inverse", optional=true)
    public native @ByVal GLKMatrix4 getMatrix4Inverse();
    @Bridge(symbol="GLKMatrixStackGetMatrix4InverseTranspose", optional=true)
    public native @ByVal GLKMatrix4 getMatrix4InverseTranspose();
    @Bridge(symbol="GLKMatrixStackGetMatrix3Inverse", optional=true)
    public native @ByVal GLKMatrix3 getMatrix3Inverse();
    @Bridge(symbol="GLKMatrixStackGetMatrix3InverseTranspose", optional=true)
    public native @ByVal GLKMatrix3 getMatrix3InverseTranspose();
    @Bridge(symbol="GLKMatrixStackMultiplyMatrix4", optional=true)
    public native void multiplyMatrix4(@ByVal GLKMatrix4 matrix);
    @Bridge(symbol="GLKMatrixStackMultiplyMatrixStack", optional=true)
    public native void multiplyMatrixStack(GLKMatrixStack stackRight);
    @Bridge(symbol="GLKMatrixStackTranslate", optional=true)
    public native void translate(float tx, float ty, float tz);
    @Bridge(symbol="GLKMatrixStackTranslateWithVector3", optional=true)
    public native void translate(@ByVal GLKVector3 translationVector);
    @Bridge(symbol="GLKMatrixStackTranslateWithVector4", optional=true)
    public native void translate(@ByVal GLKVector4 translationVector);
    @Bridge(symbol="GLKMatrixStackScale", optional=true)
    public native void scale(float sx, float sy, float sz);
    @Bridge(symbol="GLKMatrixStackScaleWithVector3", optional=true)
    public native void scale(@ByVal GLKVector3 scaleVector);
    @Bridge(symbol="GLKMatrixStackScaleWithVector4", optional=true)
    public native void scale(@ByVal GLKVector4 scaleVector);
    @Bridge(symbol="GLKMatrixStackRotate", optional=true)
    public native void rotate(float radians, float x, float y, float z);
    @Bridge(symbol="GLKMatrixStackRotateWithVector3", optional=true)
    public native void rotate(float radians, @ByVal GLKVector3 axisVector);
    @Bridge(symbol="GLKMatrixStackRotateWithVector4", optional=true)
    public native void rotate(float radians, @ByVal GLKVector4 axisVector);
    @Bridge(symbol="GLKMatrixStackRotateX", optional=true)
    public native void rotateX(float radians);
    @Bridge(symbol="GLKMatrixStackRotateY", optional=true)
    public native void rotateY(float radians);
    @Bridge(symbol="GLKMatrixStackRotateZ", optional=true)
    public native void rotateZ(float radians);
    /*</methods>*/
}
