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
package com.bugvm.apple.corelocation;

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
import com.bugvm.apple.addressbook.*;
import com.bugvm.apple.corebluetooth.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreLocation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CLLocationAccuracy/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(CLLocationAccuracy.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final double BestForNavigation = BestForNavigationValue();
    public static final double Best = BestValue();
    public static final double NearestTenMeters = NearestTenMetersValue();
    public static final double HundredMeters = HundredMetersValue();
    public static final double Kilometer = KilometerValue();
    public static final double ThreeKilometers = ThreeKilometersValue();
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="kCLLocationAccuracyBestForNavigation", optional=true)
    protected static native double BestForNavigationValue();
    @GlobalValue(symbol="kCLLocationAccuracyBest", optional=true)
    protected static native double BestValue();
    @GlobalValue(symbol="kCLLocationAccuracyNearestTenMeters", optional=true)
    protected static native double NearestTenMetersValue();
    @GlobalValue(symbol="kCLLocationAccuracyHundredMeters", optional=true)
    protected static native double HundredMetersValue();
    @GlobalValue(symbol="kCLLocationAccuracyKilometer", optional=true)
    protected static native double KilometerValue();
    @GlobalValue(symbol="kCLLocationAccuracyThreeKilometers", optional=true)
    protected static native double ThreeKilometersValue();
    /*</methods>*/
}
