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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAScrollLayer/*</name>*/ 
    extends /*<extends>*/CALayer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAScrollLayerPtr extends Ptr<CAScrollLayer, CAScrollLayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CAScrollLayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAScrollLayer() {}
    protected CAScrollLayer(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "scrollMode")
    public native CAScrollMode getScrollMode();
    @Property(selector = "setScrollMode:")
    public native void setScrollMode(CAScrollMode v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "scrollToPoint:")
    public native void scrollTo(@ByVal CGPoint p);
    @Method(selector = "scrollToRect:")
    public native void scrollTo(@ByVal CGRect r);
    /*</methods>*/
}
