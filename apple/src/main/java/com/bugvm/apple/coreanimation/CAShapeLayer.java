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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAShapeLayer/*</name>*/ 
    extends /*<extends>*/CALayer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAShapeLayerPtr extends Ptr<CAShapeLayer, CAShapeLayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CAShapeLayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAShapeLayer() {}
    protected CAShapeLayer(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "path")
    public native CGPath getPath();
    @Property(selector = "setPath:")
    public native void setPath(CGPath v);
    @Property(selector = "fillColor")
    public native CGColor getFillColor();
    @Property(selector = "setFillColor:")
    public native void setFillColor(CGColor v);
    @Property(selector = "fillRule")
    public native CAShapeFillRule getFillRule();
    @Property(selector = "setFillRule:")
    public native void setFillRule(CAShapeFillRule v);
    @Property(selector = "strokeColor")
    public native CGColor getStrokeColor();
    @Property(selector = "setStrokeColor:")
    public native void setStrokeColor(CGColor v);
    @Property(selector = "strokeStart")
    public native @MachineSizedFloat double getStrokeStart();
    @Property(selector = "setStrokeStart:")
    public native void setStrokeStart(@MachineSizedFloat double v);
    @Property(selector = "strokeEnd")
    public native @MachineSizedFloat double getStrokeEnd();
    @Property(selector = "setStrokeEnd:")
    public native void setStrokeEnd(@MachineSizedFloat double v);
    @Property(selector = "lineWidth")
    public native @MachineSizedFloat double getLineWidth();
    @Property(selector = "setLineWidth:")
    public native void setLineWidth(@MachineSizedFloat double v);
    @Property(selector = "miterLimit")
    public native @MachineSizedFloat double getMiterLimit();
    @Property(selector = "setMiterLimit:")
    public native void setMiterLimit(@MachineSizedFloat double v);
    @Property(selector = "lineCap")
    public native CALineCap getLineCap();
    @Property(selector = "setLineCap:")
    public native void setLineCap(CALineCap v);
    @Property(selector = "lineJoin")
    public native CALineJoin getLineJoin();
    @Property(selector = "setLineJoin:")
    public native void setLineJoin(CALineJoin v);
    @Property(selector = "lineDashPhase")
    public native @MachineSizedFloat double getLineDashPhase();
    @Property(selector = "setLineDashPhase:")
    public native void setLineDashPhase(@MachineSizedFloat double v);
    @Property(selector = "lineDashPattern")
    public native NSArray<NSNumber> getLineDashPattern();
    @Property(selector = "setLineDashPattern:")
    public native void setLineDashPattern(NSArray<NSNumber> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
