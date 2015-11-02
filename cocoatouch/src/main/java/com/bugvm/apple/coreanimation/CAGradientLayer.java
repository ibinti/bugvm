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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAGradientLayer/*</name>*/ 
    extends /*<extends>*/CALayer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAGradientLayerPtr extends Ptr<CAGradientLayer, CAGradientLayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CAGradientLayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAGradientLayer() {}
    protected CAGradientLayer(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public void setLocations(double... locations) {
        if (locations != null && locations.length > 0) {
            NSArray<NSNumber> loc = new NSMutableArray<>();
            for (double l : locations) {
                loc.add(NSNumber.valueOf(l));
            }
            setLocations(loc);
        }
    }
    /*<properties>*/
    @Property(selector = "colors")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CGColor.AsListMarshaler.class) List<CGColor> getColors();
    @Property(selector = "setColors:")
    public native void setColors(@com.bugvm.rt.bro.annotation.Marshaler(CGColor.AsListMarshaler.class) List<CGColor> v);
    @Property(selector = "locations")
    public native NSArray<NSNumber> getLocations();
    @Property(selector = "setLocations:")
    public native void setLocations(NSArray<NSNumber> v);
    @Property(selector = "startPoint")
    public native @ByVal CGPoint getStartPoint();
    @Property(selector = "setStartPoint:")
    public native void setStartPoint(@ByVal CGPoint v);
    @Property(selector = "endPoint")
    public native @ByVal CGPoint getEndPoint();
    @Property(selector = "setEndPoint:")
    public native void setEndPoint(@ByVal CGPoint v);
    @Property(selector = "type")
    public native CAGradientType getType();
    @Property(selector = "setType:")
    public native void setType(CAGradientType v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
