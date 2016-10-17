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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNText/*</name>*/ 
    extends /*<extends>*/SCNGeometry/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SCNTextPtr extends Ptr<SCNText, SCNTextPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SCNText.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SCNText() {}
    protected SCNText(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "extrusionDepth")
    public native @MachineSizedFloat double getExtrusionDepth();
    @Property(selector = "setExtrusionDepth:")
    public native void setExtrusionDepth(@MachineSizedFloat double v);
    @Property(selector = "string")
    public native NSAttributedString getString();
    @Property(selector = "setString:")
    public native void setString(NSAttributedString v);
    @Property(selector = "font")
    public native UIFont getFont();
    @Property(selector = "setFont:")
    public native void setFont(UIFont v);
    @Property(selector = "isWrapped")
    public native boolean isWrapped();
    @Property(selector = "setWrapped:")
    public native void setWrapped(boolean v);
    @Property(selector = "containerFrame")
    public native @ByVal CGRect getContainerFrame();
    @Property(selector = "setContainerFrame:")
    public native void setContainerFrame(@ByVal CGRect v);
    @Property(selector = "truncationMode")
    public native CATextTruncationMode getTruncationMode();
    @Property(selector = "setTruncationMode:")
    public native void setTruncationMode(CATextTruncationMode v);
    @Property(selector = "alignmentMode")
    public native CATextAlignmentMode getAlignmentMode();
    @Property(selector = "setAlignmentMode:")
    public native void setAlignmentMode(CATextAlignmentMode v);
    @Property(selector = "chamferRadius")
    public native @MachineSizedFloat double getChamferRadius();
    @Property(selector = "setChamferRadius:")
    public native void setChamferRadius(@MachineSizedFloat double v);
    @Property(selector = "chamferProfile")
    public native UIBezierPath getChamferProfile();
    @Property(selector = "setChamferProfile:")
    public native void setChamferProfile(UIBezierPath v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "flatness")
    public native @MachineSizedFloat double getFlatness();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFlatness:")
    public native void setFlatness(@MachineSizedFloat double v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "textWithString:extrusionDepth:")
    public static native SCNText create(NSAttributedString string, @MachineSizedFloat double extrusionDepth);
    /*</methods>*/
}
