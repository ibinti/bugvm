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
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MapKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKPlacemark/*</name>*/ 
    extends /*<extends>*/CLPlacemark/*</extends>*/ 
    /*<implements>*/implements MKAnnotation/*</implements>*/ {

    /*<ptr>*/public static class MKPlacemarkPtr extends Ptr<MKPlacemark, MKPlacemarkPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKPlacemark.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    public MKPlacemark(CLPlacemark placemark) {
        super(placemark);
    }
    /*<constructors>*/
    protected MKPlacemark(SkipInit skipInit) { super(skipInit); }
    public MKPlacemark(@ByVal CLLocationCoordinate2D coordinate, com.bugvm.apple.addressbook.ABPersonAddress addressDictionary) { super((SkipInit) null); initObject(init(coordinate, addressDictionary)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "countryCode")
    public native String getCountryCode();
    @Property(selector = "coordinate")
    public native @ByVal CLLocationCoordinate2D getCoordinate();
    @Property(selector = "setCoordinate:")
    public native void setCoordinate(@ByVal CLLocationCoordinate2D v);
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "subtitle")
    public native String getSubtitle();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithCoordinate:addressDictionary:")
    protected native @Pointer long init(@ByVal CLLocationCoordinate2D coordinate, com.bugvm.apple.addressbook.ABPersonAddress addressDictionary);
    /*</methods>*/
}
