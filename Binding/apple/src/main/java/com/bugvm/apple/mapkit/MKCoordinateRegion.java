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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKCoordinateRegion/*</name>*/ 
    extends /*<extends>*/Struct<MKCoordinateRegion>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKCoordinateRegionPtr extends Ptr<MKCoordinateRegion, MKCoordinateRegionPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(MKCoordinateRegion.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKCoordinateRegion() {}
    public MKCoordinateRegion(CLLocationCoordinate2D center, MKCoordinateSpan span) {
        this.setCenter(center);
        this.setSpan(span);
    }
    /*</constructors>*/
    public MKCoordinateRegion(CLLocationCoordinate2D centerCoordinate, double latitudinalMeters, double longitudinalMeters) {
        super(create(centerCoordinate, latitudinalMeters, longitudinalMeters));
    }
    public MKCoordinateRegion(MKMapRect rect) {
        super(create(rect));
    }
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @ByVal CLLocationCoordinate2D getCenter();
    @StructMember(0) public native MKCoordinateRegion setCenter(@ByVal CLLocationCoordinate2D center);
    @StructMember(1) public native @ByVal MKCoordinateSpan getSpan();
    @StructMember(1) public native MKCoordinateRegion setSpan(@ByVal MKCoordinateSpan span);
    /*</members>*/
    /*<methods>*/
    @Bridge(symbol="MKCoordinateRegionMakeWithDistance", optional=true)
    private static native @Pointer long create(@ByVal CLLocationCoordinate2D centerCoordinate, double latitudinalMeters, double longitudinalMeters);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="MKCoordinateRegionForMapRect", optional=true)
    private static native @Pointer long create(@ByVal MKMapRect rect);
    /*</methods>*/
}
