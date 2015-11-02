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
package com.bugvm.apple.scenekit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.spritekit.*;
import com.bugvm.apple.opengles.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("SceneKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNTorus/*</name>*/ 
    extends /*<extends>*/SCNGeometry/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNTorusPtr extends Ptr<SCNTorus, SCNTorusPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNTorus.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNTorus() {}
    protected SCNTorus(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "ringRadius")
    public native @MachineSizedFloat double getRingRadius();
    @Property(selector = "setRingRadius:")
    public native void setRingRadius(@MachineSizedFloat double v);
    @Property(selector = "pipeRadius")
    public native @MachineSizedFloat double getPipeRadius();
    @Property(selector = "setPipeRadius:")
    public native void setPipeRadius(@MachineSizedFloat double v);
    @Property(selector = "ringSegmentCount")
    public native @MachineSizedSInt long getRingSegmentCount();
    @Property(selector = "setRingSegmentCount:")
    public native void setRingSegmentCount(@MachineSizedSInt long v);
    @Property(selector = "pipeSegmentCount")
    public native @MachineSizedSInt long getPipeSegmentCount();
    @Property(selector = "setPipeSegmentCount:")
    public native void setPipeSegmentCount(@MachineSizedSInt long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "torusWithRingRadius:pipeRadius:")
    public static native SCNTorus create(@MachineSizedFloat double ringRadius, @MachineSizedFloat double pipeRadius);
    /*</methods>*/
}
