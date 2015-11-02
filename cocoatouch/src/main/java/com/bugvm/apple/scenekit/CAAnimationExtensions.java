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
/*</javadoc>*/
/*<annotations>*/@Library("SceneKit")/*</annotations>*/
/*<visibility>*/public final/*</visibility>*/ class /*<name>*/CAAnimationExtensions/*</name>*/ 
    extends /*<extends>*/NSExtensions/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CAAnimationExtensions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    private CAAnimationExtensions() {}
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "usesSceneTimeBase")
    public static native boolean usesSceneTimeBase(CAAnimation thiz);
    @Property(selector = "setUsesSceneTimeBase:")
    public static native void setUsesSceneTimeBase(CAAnimation thiz, boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "fadeInDuration")
    public static native @MachineSizedFloat double getFadeInDuration(CAAnimation thiz);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFadeInDuration:")
    public static native void setFadeInDuration(CAAnimation thiz, @MachineSizedFloat double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "fadeOutDuration")
    public static native @MachineSizedFloat double getFadeOutDuration(CAAnimation thiz);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFadeOutDuration:")
    public static native void setFadeOutDuration(CAAnimation thiz, @MachineSizedFloat double v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "animationEvents")
    public static native NSArray<SCNAnimationEvent> getAnimationEvents(CAAnimation thiz);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setAnimationEvents:")
    public static native void setAnimationEvents(CAAnimation thiz, NSArray<SCNAnimationEvent> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
