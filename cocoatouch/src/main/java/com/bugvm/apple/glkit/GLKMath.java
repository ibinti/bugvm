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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GLKMath/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(GLKMath.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static GLKVector3 project(GLKVector3 object, GLKMatrix4 model, GLKMatrix4 projection, int[] viewport) {
        IntPtr ptr = new IntPtr();
        ptr.set(viewport);
        return project(object, model, projection, ptr);
    }
    public static GLKVector3 unproject(GLKVector3 window, GLKMatrix4 model, GLKMatrix4 projection, int[] viewport, BooleanPtr success) {
        IntPtr ptr = new IntPtr();
        ptr.set(viewport);
        return unproject(window, model, projection, ptr, success);
    }
    /*<methods>*/
    @Bridge(symbol="GLKMathProject", optional=true)
    private static native @ByVal GLKVector3 project(@ByVal GLKVector3 object, @ByVal GLKMatrix4 model, @ByVal GLKMatrix4 projection, IntPtr viewport);
    @Bridge(symbol="GLKMathUnproject", optional=true)
    private static native @ByVal GLKVector3 unproject(@ByVal GLKVector3 window, @ByVal GLKMatrix4 model, @ByVal GLKMatrix4 projection, IntPtr viewport, BooleanPtr success);
    /*</methods>*/
}
