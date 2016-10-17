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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKLabelNode/*</name>*/ 
    extends /*<extends>*/SKNode/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKLabelNodePtr extends Ptr<SKLabelNode, SKLabelNodePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKLabelNode.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKLabelNode() {}
    protected SKLabelNode(SkipInit skipInit) { super(skipInit); }
    public SKLabelNode(String text) { super(create(text)); retain(getHandle()); }
    /*</constructors>*/
    public SKLabelNode(String text, String fontName) {
        this(text);
        setFontName(fontName);
    }
    /*<properties>*/
    @Property(selector = "verticalAlignmentMode")
    public native SKLabelVerticalAlignmentMode getVerticalAlignmentMode();
    @Property(selector = "setVerticalAlignmentMode:")
    public native void setVerticalAlignmentMode(SKLabelVerticalAlignmentMode v);
    @Property(selector = "horizontalAlignmentMode")
    public native SKLabelHorizontalAlignmentMode getHorizontalAlignmentMode();
    @Property(selector = "setHorizontalAlignmentMode:")
    public native void setHorizontalAlignmentMode(SKLabelHorizontalAlignmentMode v);
    @Property(selector = "fontName")
    public native String getFontName();
    @Property(selector = "setFontName:")
    public native void setFontName(String v);
    @Property(selector = "text")
    public native String getText();
    @Property(selector = "setText:")
    public native void setText(String v);
    @Property(selector = "fontSize")
    public native @MachineSizedFloat double getFontSize();
    @Property(selector = "setFontSize:")
    public native void setFontSize(@MachineSizedFloat double v);
    @Property(selector = "fontColor")
    public native UIColor getFontColor();
    @Property(selector = "setFontColor:")
    public native void setFontColor(UIColor v);
    @Property(selector = "colorBlendFactor")
    public native @MachineSizedFloat double getColorBlendFactor();
    @Property(selector = "setColorBlendFactor:")
    public native void setColorBlendFactor(@MachineSizedFloat double v);
    @Property(selector = "color")
    public native UIColor getColor();
    @Property(selector = "setColor:")
    public native void setColor(UIColor v);
    @Property(selector = "blendMode")
    public native SKBlendMode getBlendMode();
    @Property(selector = "setBlendMode:")
    public native void setBlendMode(SKBlendMode v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "labelNodeWithText:")
    protected static native @Pointer long create(String text);
    /*</methods>*/
}
