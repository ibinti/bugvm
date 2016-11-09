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

/*</javadoc>*/
/*<annotations>*/@Library("MapKit")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKMapPoint/*</name>*/ 
    extends /*<extends>*/Struct<MKMapPoint>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKMapPointPtr extends Ptr<MKMapPoint, MKMapPointPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(MKMapPoint.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKMapPoint() {}
    public MKMapPoint(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
    /*</constructors>*/
    public MKMapPoint(CLLocationCoordinate2D coordinate) {
        super(create(coordinate));
    }
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native double getX();
    @StructMember(0) public native MKMapPoint setX(double x);
    @StructMember(1) public native double getY();
    @StructMember(1) public native MKMapPoint setY(double y);
    /*</members>*/
    public boolean equalsTo(MKMapPoint other) {
        return getX() == other.getX() && getY() == other.getY();
    }
    public boolean equals(Object obj) {
        return obj instanceof MKMapPoint && equalsTo((MKMapPoint)obj);
    }
    
    public String toString() {
        return String.format("{%.1f, %.1f}", getX(), getY());
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="MKMapPointForCoordinate", optional=true)
    private static native @Pointer long create(@ByVal CLLocationCoordinate2D coordinate);
    /**
     * @since Available in iOS 4.0 and later.
     */
    public CLLocationCoordinate2D toCoordinate() { return toCoordinate(this); }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="MKCoordinateForMapPoint", optional=true)
    private static native @ByVal CLLocationCoordinate2D toCoordinate(@ByVal MKMapPoint mapPoint);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="MKMetersPerMapPointAtLatitude", optional=true)
    public static native double getMetersPerMapPoint(double latitude);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="MKMapPointsPerMeterAtLatitude", optional=true)
    public static native double getMapPointsPerMeter(double latitude);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="MKMetersBetweenMapPoints", optional=true)
    public static native double getMetersBetween(@ByVal MKMapPoint a, @ByVal MKMapPoint b);
    /*</methods>*/
}
