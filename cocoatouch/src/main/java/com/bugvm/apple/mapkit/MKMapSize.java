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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKMapSize/*</name>*/ 
    extends /*<extends>*/Struct<MKMapSize>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKMapSizePtr extends Ptr<MKMapSize, MKMapSizePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(MKMapSize.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKMapSize() {}
    public MKMapSize(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public boolean equalsTo(MKMapSize other) {
        return getWidth() == other.getWidth() && getHeight() == other.getHeight();
    }
    public boolean equals(Object obj) {
        return obj instanceof MKMapSize && equalsTo((MKMapSize)obj);
    }
    
    public String toString() {
        return String.format("{%.1f, %.1f}", getWidth(), getHeight());
    }
    /*<members>*/
    @StructMember(0) public native double getWidth();
    @StructMember(0) public native MKMapSize setWidth(double width);
    @StructMember(1) public native double getHeight();
    @StructMember(1) public native MKMapSize setHeight(double height);
    /*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="MKMapSizeWorld", optional=true)
    public static native @ByVal MKMapSize World();
    /*</methods>*/
}
