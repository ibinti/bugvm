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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKMutableTexture/*</name>*/ 
    extends /*<extends>*/SKTexture/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKMutableTexturePtr extends Ptr<SKMutableTexture, SKMutableTexturePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKMutableTexture.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKMutableTexture() {}
    protected SKMutableTexture(SkipInit skipInit) { super(skipInit); }
    public SKMutableTexture(@ByVal CGSize size) { super((SkipInit) null); initObject(init(size)); }
    public SKMutableTexture(@ByVal CGSize size, int format) { super((SkipInit) null); initObject(init(size, format)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithSize:")
    protected native @Pointer long init(@ByVal CGSize size);
    @Method(selector = "initWithSize:pixelFormat:")
    protected native @Pointer long init(@ByVal CGSize size, int format);
    @Method(selector = "modifyPixelDataWithBlock:")
    public native void modifyPixelData(@Block("(,@MachineSizedUInt)") VoidBlock2<VoidPtr, Long> block);
    /*</methods>*/
}
