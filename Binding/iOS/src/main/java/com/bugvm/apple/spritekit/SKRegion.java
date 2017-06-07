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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKRegion/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class SKRegionPtr extends Ptr<SKRegion, SKRegionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKRegion.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKRegion() {}
    protected SKRegion(SkipInit skipInit) { super(skipInit); }
    public SKRegion(float radius) { super((SkipInit) null); initObject(init(radius)); }
    public SKRegion(@ByVal CGSize size) { super((SkipInit) null); initObject(init(size)); }
    public SKRegion(CGPath path) { super((SkipInit) null); initObject(init(path)); }
    public SKRegion(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "path")
    public native CGPath getPath();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithRadius:")
    protected native @Pointer long init(float radius);
    @Method(selector = "initWithSize:")
    protected native @Pointer long init(@ByVal CGSize size);
    @Method(selector = "initWithPath:")
    protected native @Pointer long init(CGPath path);
    @Method(selector = "inverseRegion")
    public native SKRegion inverseRegion();
    @Method(selector = "regionByUnionWithRegion:")
    public native SKRegion newRegionByUnionWithRegion(SKRegion region);
    @Method(selector = "regionByDifferenceFromRegion:")
    public native SKRegion newRegionByDifferenceFromRegion(SKRegion region);
    @Method(selector = "regionByIntersectionWithRegion:")
    public native SKRegion newRegionByIntersectionWithRegion(SKRegion region);
    @Method(selector = "containsPoint:")
    public native boolean containsPoint(@ByVal CGPoint point);
    @Method(selector = "infiniteRegion")
    public static native SKRegion createInfiniteRegion();
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
