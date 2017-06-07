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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKMapCamera/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKMapCameraPtr extends Ptr<MKMapCamera, MKMapCameraPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKMapCamera.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKMapCamera() {}
    protected MKMapCamera(SkipInit skipInit) { super(skipInit); }
    public MKMapCamera(@ByVal CLLocationCoordinate2D centerCoordinate, @ByVal CLLocationCoordinate2D eyeCoordinate, double eyeAltitude) { super(create(centerCoordinate, eyeCoordinate, eyeAltitude)); retain(getHandle()); }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public MKMapCamera(@ByVal CLLocationCoordinate2D centerCoordinate, double distance, @MachineSizedFloat double pitch, double heading) { super(create(centerCoordinate, distance, pitch, heading)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "centerCoordinate")
    public native @ByVal CLLocationCoordinate2D getCenterCoordinate();
    @Property(selector = "setCenterCoordinate:")
    public native void setCenterCoordinate(@ByVal CLLocationCoordinate2D v);
    @Property(selector = "heading")
    public native double getHeading();
    @Property(selector = "setHeading:")
    public native void setHeading(double v);
    @Property(selector = "pitch")
    public native @MachineSizedFloat double getPitch();
    @Property(selector = "setPitch:")
    public native void setPitch(@MachineSizedFloat double v);
    @Property(selector = "altitude")
    public native double getAltitude();
    @Property(selector = "setAltitude:")
    public native void setAltitude(double v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "cameraLookingAtCenterCoordinate:fromEyeCoordinate:eyeAltitude:")
    private static native @Pointer long create(@ByVal CLLocationCoordinate2D centerCoordinate, @ByVal CLLocationCoordinate2D eyeCoordinate, double eyeAltitude);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "cameraLookingAtCenterCoordinate:fromDistance:pitch:heading:")
    private static native @Pointer long create(@ByVal CLLocationCoordinate2D centerCoordinate, double distance, @MachineSizedFloat double pitch, double heading);
    /*</methods>*/
}
