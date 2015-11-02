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
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MapKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKGeodesicPolyline/*</name>*/ 
    extends /*<extends>*/MKPolyline/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKGeodesicPolylinePtr extends Ptr<MKGeodesicPolyline, MKGeodesicPolylinePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKGeodesicPolyline.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKGeodesicPolyline() {}
    protected MKGeodesicPolyline(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public MKGeodesicPolyline(MKMapPoint[] points) {
        super(create0(points));
        retain(getHandle());
    }
    public MKGeodesicPolyline(CLLocationCoordinate2D[] coords) {
        super(create0(coords));
        retain(getHandle());
    }
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    private static long create0(MKMapPoint[] points) {
        MKMapPoint first = Struct.allocate(MKMapPoint.class, points.length);
        first.update(points);
        return create(first, points.length);
    }
    private static long create0(CLLocationCoordinate2D[] coords) {
        CLLocationCoordinate2D first = Struct.allocate(CLLocationCoordinate2D.class, coords.length);
        first.update(coords);
        return create(first, coords.length);
    }
    /*<methods>*/
    @Method(selector = "polylineWithPoints:count:")
    private static native @Pointer long create(MKMapPoint points, @MachineSizedUInt long count);
    @Method(selector = "polylineWithCoordinates:count:")
    private static native @Pointer long create(CLLocationCoordinate2D coords, @MachineSizedUInt long count);
    /*</methods>*/
}
