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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("SpriteKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SK3DNode/*</name>*/ 
    extends /*<extends>*/SKNode/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SK3DNodePtr extends Ptr<SK3DNode, SK3DNodePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SK3DNode.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SK3DNode() {}
    protected SK3DNode(SkipInit skipInit) { super(skipInit); }
    public SK3DNode(@ByVal CGSize viewportSize) { super((SkipInit) null); initObject(init(viewportSize)); }
    public SK3DNode(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "viewportSize")
    public native @ByVal CGSize getViewportSize();
    @Property(selector = "setViewportSize:")
    public native void setViewportSize(@ByVal CGSize v);
    @WeaklyLinked
    @Property(selector = "scnScene")
    public native SCNScene getSceneKitScene();
    @WeaklyLinked
    @Property(selector = "setScnScene:")
    public native void setSceneKitScene(SCNScene v);
    @Property(selector = "sceneTime")
    public native double getSceneTime();
    @Property(selector = "setSceneTime:")
    public native void setSceneTime(double v);
    @Property(selector = "isPlaying")
    public native boolean isPlaying();
    @Property(selector = "setPlaying:")
    public native void setPlaying(boolean v);
    @Property(selector = "loops")
    public native boolean loops();
    @Property(selector = "setLoops:")
    public native void setLoops(boolean v);
    @WeaklyLinked
    @Property(selector = "pointOfView")
    public native SCNNode getPointOfView();
    @WeaklyLinked
    @Property(selector = "setPointOfView:")
    public native void setPointOfView(SCNNode v);
    @Property(selector = "autoenablesDefaultLighting")
    public native boolean autoenablesDefaultLighting();
    @Property(selector = "setAutoenablesDefaultLighting:")
    public native void setAutoenablesDefaultLighting(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithViewportSize:")
    protected native @Pointer long init(@ByVal CGSize viewportSize);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @WeaklyLinked
    @Method(selector = "hitTest:options:")
    public native NSArray<SCNHitTestResult> hitTest(@ByVal CGPoint point, SCNHitTestOptions options);
    @Method(selector = "projectPoint:")
    public native @ByVal SKVector3 projectPoint(@ByVal SKVector3 point);
    @Method(selector = "unprojectPoint:")
    public native @ByVal SKVector3 unprojectPoint(@ByVal SKVector3 point);
    /*</methods>*/
}
