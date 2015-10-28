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

import com.bugvm.apple.corelocation.CLLocationCoordinate2D;
import com.bugvm.apple.foundation.NSArray;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MapKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKPolygon/*</name>*/ 
    extends /*<extends>*/MKMultiPoint/*</extends>*/ 
    /*<implements>*/implements MKOverlay/*</implements>*/ {

    /*<ptr>*/public static class MKPolygonPtr extends Ptr<MKPolygon, MKPolygonPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKPolygon.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKPolygon() {}
    protected MKPolygon(NSObject.SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public MKPolygon(MKMapPoint[] points) {
        super(create0(points));
        NSObject.retain(getHandle());
    }
    public MKPolygon(MKMapPoint[] points, NSArray<MKPolygon> interiorPolygons) {
        super(create0(points, interiorPolygons));
        NSObject.retain(getHandle());
    }
    public MKPolygon(CLLocationCoordinate2D[] coords) {
        super(create0(coords));
        NSObject.retain(getHandle());
    }
    public MKPolygon(CLLocationCoordinate2D[] coords, NSArray<MKPolygon> interiorPolygons) {
        super(create0(coords, interiorPolygons));
        NSObject.retain(getHandle());
    }
    /*<properties>*/
    @Property(selector = "interiorPolygons")
    public native NSArray<MKPolygon> getInteriorPolygons();
    @Property(selector = "coordinate")
    public native @ByVal CLLocationCoordinate2D getCoordinate();
    @Property(selector = "boundingMapRect")
    public native @ByVal MKMapRect getBoundingMapRect();
    /*</properties>*/
    /*<members>*//*</members>*/
    private static long create0(MKMapPoint[] points) {
        MKMapPoint first = Struct.allocate(MKMapPoint.class, points.length);
        first.update(points);
        return create(first, points.length);
    }
    private static long create0(MKMapPoint[] points, NSArray<MKPolygon> interiorPolygons) {
        MKMapPoint first = Struct.allocate(MKMapPoint.class, points.length);
        first.update(points);
        return create(first, points.length, interiorPolygons);
    }
    private static long create0(CLLocationCoordinate2D[] coords) {
        CLLocationCoordinate2D first = Struct.allocate(CLLocationCoordinate2D.class, coords.length);
        first.update(coords);
        return create(first, coords.length);
    }
    private static long create0(CLLocationCoordinate2D[] coords, NSArray<MKPolygon> interiorPolygons) {
        CLLocationCoordinate2D first = Struct.allocate(CLLocationCoordinate2D.class, coords.length);
        first.update(coords);
        return create(first, coords.length, interiorPolygons);
    }
    /*<methods>*/
    @Method(selector = "polygonWithPoints:count:")
    private static native @Pointer long create(MKMapPoint points, @MachineSizedUInt long count);
    @Method(selector = "polygonWithPoints:count:interiorPolygons:")
    private static native @Pointer long create(MKMapPoint points, @MachineSizedUInt long count, NSArray<MKPolygon> interiorPolygons);
    @Method(selector = "polygonWithCoordinates:count:")
    private static native @Pointer long create(CLLocationCoordinate2D coords, @MachineSizedUInt long count);
    @Method(selector = "polygonWithCoordinates:count:interiorPolygons:")
    private static native @Pointer long create(CLLocationCoordinate2D coords, @MachineSizedUInt long count, NSArray<MKPolygon> interiorPolygons);
    @Method(selector = "intersectsMapRect:")
    public native boolean intersects(@ByVal MKMapRect mapRect);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "canReplaceMapContent")
    public native boolean canReplaceMapContent();
    /*</methods>*/
}
