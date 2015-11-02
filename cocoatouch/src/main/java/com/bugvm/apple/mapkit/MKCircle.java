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
package com.bugvm.apple.mapkit;

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
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MapKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKCircle/*</name>*/ 
    extends /*<extends>*/MKShape/*</extends>*/ 
    /*<implements>*/implements MKOverlay/*</implements>*/ {

    /*<ptr>*/public static class MKCirclePtr extends Ptr<MKCircle, MKCirclePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKCircle.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKCircle() {}
    protected MKCircle(SkipInit skipInit) { super(skipInit); }
    public MKCircle(@ByVal CLLocationCoordinate2D coord, double radius) { super(create(coord, radius)); retain(getHandle()); }
    public MKCircle(@ByVal MKMapRect mapRect) { super(create(mapRect)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "coordinate")
    public native @ByVal CLLocationCoordinate2D getCoordinate();
    @Property(selector = "radius")
    public native double getRadius();
    @Property(selector = "boundingMapRect")
    public native @ByVal MKMapRect getBoundingMapRect();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "circleWithCenterCoordinate:radius:")
    private static native @Pointer long create(@ByVal CLLocationCoordinate2D coord, double radius);
    @Method(selector = "circleWithMapRect:")
    private static native @Pointer long create(@ByVal MKMapRect mapRect);
    @Method(selector = "intersectsMapRect:")
    public native boolean intersects(@ByVal MKMapRect mapRect);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "canReplaceMapContent")
    public native boolean canReplaceMapContent();
    /*</methods>*/
}
