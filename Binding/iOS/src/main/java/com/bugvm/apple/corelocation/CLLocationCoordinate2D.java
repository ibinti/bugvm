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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CLLocationCoordinate2D/*</name>*/ 
    extends /*<extends>*/Struct<CLLocationCoordinate2D>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CLLocationCoordinate2DPtr extends Ptr<CLLocationCoordinate2D, CLLocationCoordinate2DPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CLLocationCoordinate2D.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CLLocationCoordinate2D() {}
    public CLLocationCoordinate2D(double latitude, double longitude) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native double getLatitude();
    @StructMember(0) public native CLLocationCoordinate2D setLatitude(double latitude);
    @StructMember(1) public native double getLongitude();
    @StructMember(1) public native CLLocationCoordinate2D setLongitude(double longitude);
    /*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="kCLLocationCoordinate2DInvalid", optional=true)
    public static native @ByVal CLLocationCoordinate2D Invalid();
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CLLocationCoordinate2DIsValid", optional=true)
    private static native boolean isValid(@ByVal CLLocationCoordinate2D coord);
    /*</methods>*/
}
