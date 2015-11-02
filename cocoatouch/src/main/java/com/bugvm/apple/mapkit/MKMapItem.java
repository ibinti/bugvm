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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKMapItem/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKMapItemPtr extends Ptr<MKMapItem, MKMapItemPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKMapItem.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKMapItem() {}
    protected MKMapItem(SkipInit skipInit) { super(skipInit); }
    public MKMapItem(MKPlacemark placemark) { super((SkipInit) null); initObject(init(placemark)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "placemark")
    public native MKPlacemark getPlacemark();
    @Property(selector = "isCurrentLocation")
    public native boolean isCurrentLocation();
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "setName:")
    public native void setName(String v);
    @Property(selector = "phoneNumber")
    public native String getPhoneNumber();
    @Property(selector = "setPhoneNumber:")
    public native void setPhoneNumber(String v);
    @Property(selector = "url")
    public native NSURL getUrl();
    @Property(selector = "setUrl:")
    public native void setUrl(NSURL v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "timeZone")
    public native NSTimeZone getTimeZone();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setTimeZone:")
    public native void setTimeZone(NSTimeZone v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithPlacemark:")
    protected native @Pointer long init(MKPlacemark placemark);
    @Method(selector = "openInMapsWithLaunchOptions:")
    public native boolean openInMaps(MKLaunchOptions launchOptions);
    @Method(selector = "mapItemForCurrentLocation")
    public static native MKMapItem getMapItemForCurrentLocation();
    @Method(selector = "openMapsWithItems:launchOptions:")
    public static native boolean openMaps(NSArray<MKMapItem> mapItems, MKLaunchOptions launchOptions);
    /*</methods>*/
}
