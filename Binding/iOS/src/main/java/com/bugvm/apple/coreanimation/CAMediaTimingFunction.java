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
package com.bugvm.apple.coreanimation;

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
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("QuartzCore") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAMediaTimingFunction/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class CAMediaTimingFunctionPtr extends Ptr<CAMediaTimingFunction, CAMediaTimingFunctionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CAMediaTimingFunction.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAMediaTimingFunction() {}
    protected CAMediaTimingFunction(SkipInit skipInit) { super(skipInit); }
    public CAMediaTimingFunction(float c1x, float c1y, float c2x, float c2y) { super((SkipInit) null); initObject(init(c1x, c1y, c2x, c2y)); }
    public CAMediaTimingFunction(CAMediaTimingFunctionName name) { super(create(name)); retain(getHandle()); }
    public CAMediaTimingFunction(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    public float getControlPoint(@MachineSizedUInt long idx) {
        FloatPtr ptr = new FloatPtr();
        getControlPoint(idx, ptr);
        return ptr.get();
    }
    /*<methods>*/
    @Method(selector = "initWithControlPoints::::")
    protected native @Pointer long init(float c1x, float c1y, float c2x, float c2y);
    @Method(selector = "getControlPointAtIndex:values:")
    protected native void getControlPoint(@MachineSizedUInt long idx, FloatPtr ptr);
    @Method(selector = "functionWithName:")
    protected static native @Pointer long create(CAMediaTimingFunctionName name);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
