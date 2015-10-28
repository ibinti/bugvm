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
package com.bugvm.apple.watchkit;

/*<imports>*/

import com.bugvm.apple.coregraphics.CGPoint;
import com.bugvm.apple.corelocation.CLLocationCoordinate2D;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.apple.mapkit.MKCoordinateRegion;
import com.bugvm.apple.mapkit.MKMapRect;
import com.bugvm.apple.uikit.UIImage;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("WatchKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/WKInterfaceMap/*</name>*/ 
    extends /*<extends>*/WKInterfaceObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class WKInterfaceMapPtr extends Ptr<WKInterfaceMap, WKInterfaceMapPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(WKInterfaceMap.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public WKInterfaceMap() {}
    protected WKInterfaceMap(NSObject.SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "setVisibleMapRect:")
    public native void setVisibleMapRect(@ByVal MKMapRect mapRect);
    @WeaklyLinked
    @Method(selector = "setRegion:")
    public native void setRegion(@ByVal MKCoordinateRegion coordinateRegion);
    @WeaklyLinked
    @Method(selector = "addAnnotation:withImage:centerOffset:")
    public native void addAnnotation(@ByVal CLLocationCoordinate2D location, UIImage image, @ByVal CGPoint offset);
    @WeaklyLinked
    @Method(selector = "addAnnotation:withImageNamed:centerOffset:")
    public native void addAnnotation(@ByVal CLLocationCoordinate2D location, String name, @ByVal CGPoint offset);
    @WeaklyLinked
    @Method(selector = "addAnnotation:withPinColor:")
    public native void addAnnotation(@ByVal CLLocationCoordinate2D location, WKInterfaceMapPinColor pinColor);
    @Method(selector = "removeAllAnnotations")
    public native void removeAllAnnotations();
    /*</methods>*/
}
