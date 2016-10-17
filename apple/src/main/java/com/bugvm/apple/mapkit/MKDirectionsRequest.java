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
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MapKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKDirectionsRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKDirectionsRequestPtr extends Ptr<MKDirectionsRequest, MKDirectionsRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKDirectionsRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKDirectionsRequest() {}
    protected MKDirectionsRequest(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 6.0 and later.
     */
    public MKDirectionsRequest(NSURL url) { super((SkipInit) null); initObject(init(url)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "source")
    public native MKMapItem getSource();
    @Property(selector = "setSource:")
    public native void setSource(MKMapItem v);
    @Property(selector = "destination")
    public native MKMapItem getDestination();
    @Property(selector = "setDestination:")
    public native void setDestination(MKMapItem v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "transportType")
    public native MKDirectionsTransportType getTransportType();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setTransportType:")
    public native void setTransportType(MKDirectionsTransportType v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "requestsAlternateRoutes")
    public native boolean requestsAlternateRoutes();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setRequestsAlternateRoutes:")
    public native void setRequestsAlternateRoutes(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "departureDate")
    public native NSDate getDepartureDate();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setDepartureDate:")
    public native void setDepartureDate(NSDate v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "arrivalDate")
    public native NSDate getArrivalDate();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setArrivalDate:")
    public native void setArrivalDate(NSDate v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "initWithContentsOfURL:")
    protected native @Pointer long init(NSURL url);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "isDirectionsRequestURL:")
    public static native boolean isDirectionsRequestURL(NSURL url);
    /*</methods>*/
}
