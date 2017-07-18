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
package com.bugvm.apple.spritekit;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.avfoundation.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.scenekit.*;
import com.bugvm.apple.gameplaykit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("SpriteKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKScene/*</name>*/ 
    extends /*<extends>*/SKEffectNode/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKScenePtr extends Ptr<SKScene, SKScenePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKScene.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKScene() {}
    protected SKScene(SkipInit skipInit) { super(skipInit); }
    public SKScene(@ByVal CGSize size) { super((SkipInit) null); initObject(init(size)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "size")
    public native @ByVal CGSize getSize();
    @Property(selector = "setSize:")
    public native void setSize(@ByVal CGSize v);
    @Property(selector = "scaleMode")
    public native SKSceneScaleMode getScaleMode();
    @Property(selector = "setScaleMode:")
    public native void setScaleMode(SKSceneScaleMode v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "camera")
    public native SKCameraNode getCamera();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setCamera:", strongRef = true)
    public native void setCamera(SKCameraNode v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "listener")
    public native SKNode getListener();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setListener:", strongRef = true)
    public native void setListener(SKNode v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "audioEngine")
    public native AVAudioEngine getAudioEngine();
    @Property(selector = "backgroundColor")
    public native UIColor getBackgroundColor();
    @Property(selector = "setBackgroundColor:")
    public native void setBackgroundColor(UIColor v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "delegate")
    public native SKSceneDelegate getDelegate();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(SKSceneDelegate v);
    @Property(selector = "anchorPoint")
    public native @ByVal CGPoint getAnchorPoint();
    @Property(selector = "setAnchorPoint:")
    public native void setAnchorPoint(@ByVal CGPoint v);
    @Property(selector = "physicsWorld")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSObject.Marshaler.class) SKPhysicsWorld getPhysicsWorld();
    @Property(selector = "view")
    public native SKView getView();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithSize:")
    protected native @Pointer long init(@ByVal CGSize size);
    @Method(selector = "convertPointFromView:")
    public native @ByVal CGPoint convertPointFromView(@ByVal CGPoint point);
    @Method(selector = "convertPointToView:")
    public native @ByVal CGPoint convertPointToView(@ByVal CGPoint point);
    @Method(selector = "update:")
    public native void update(double currentTime);
    @Method(selector = "didEvaluateActions")
    public native void didEvaluateActions();
    @Method(selector = "didSimulatePhysics")
    public native void didSimulatePhysics();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "didApplyConstraints")
    public native void didApplyConstraints();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "didFinishUpdate")
    public native void didFinishUpdate();
    @Method(selector = "didMoveToView:")
    public native void didMoveToView(SKView view);
    @Method(selector = "willMoveFromView:")
    public native void willMoveFromView(SKView view);
    @Method(selector = "didChangeSize:")
    public native void didChangeSize(@ByVal CGSize oldSize);
    /*</methods>*/
}
