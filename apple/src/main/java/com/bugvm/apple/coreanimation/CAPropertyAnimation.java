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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAPropertyAnimation/*</name>*/ 
    extends /*<extends>*/CAAnimation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAPropertyAnimationPtr extends Ptr<CAPropertyAnimation, CAPropertyAnimationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CAPropertyAnimation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAPropertyAnimation() {}
    protected CAPropertyAnimation(long handle) { super(handle); }
    protected CAPropertyAnimation(SkipInit skipInit) { super(skipInit); }
    public CAPropertyAnimation(String path) { super(create(path)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "keyPath")
    public native String getKeyPath();
    @Property(selector = "setKeyPath:")
    public native void setKeyPath(String v);
    @Property(selector = "isAdditive")
    public native boolean isAdditive();
    @Property(selector = "setAdditive:")
    public native void setAdditive(boolean v);
    @Property(selector = "isCumulative")
    public native boolean isCumulative();
    @Property(selector = "setCumulative:")
    public native void setCumulative(boolean v);
    @Property(selector = "valueFunction")
    public native CAValueFunction getValueFunction();
    @Property(selector = "setValueFunction:")
    public native void setValueFunction(CAValueFunction v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "animationWithKeyPath:")
    protected static native @Pointer long create(String path);
    /*</methods>*/
}
