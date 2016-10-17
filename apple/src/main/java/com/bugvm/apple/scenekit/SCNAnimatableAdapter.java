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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNAnimatableAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements SCNAnimatable/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @NotImplemented("addAnimation:forKey:")
    public void addAnimation(CAAnimation animation, String key) {}
    @NotImplemented("removeAllAnimations")
    public void removeAllAnimations() {}
    @NotImplemented("removeAnimationForKey:")
    public void removeAnimation(String key) {}
    @NotImplemented("animationKeys")
    public @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAnimationKeys() { return null; }
    @NotImplemented("animationForKey:")
    public CAAnimation getAnimation(String key) { return null; }
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("pauseAnimationForKey:")
    public void pauseAnimation(String key) {}
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("resumeAnimationForKey:")
    public void resumeAnimation(String key) {}
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("isAnimationForKeyPaused:")
    public boolean isAnimationPaused(String key) { return false; }
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("removeAnimationForKey:fadeOutDuration:")
    public void removeAnimation(String key, @MachineSizedFloat double duration) {}
    /*</methods>*/
}
