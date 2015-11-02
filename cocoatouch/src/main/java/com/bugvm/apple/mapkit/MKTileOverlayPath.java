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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKTileOverlayPath/*</name>*/ 
    extends /*<extends>*/Struct<MKTileOverlayPath>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKTileOverlayPathPtr extends Ptr<MKTileOverlayPath, MKTileOverlayPathPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKTileOverlayPath() {}
    public MKTileOverlayPath(@MachineSizedSInt long x, @MachineSizedSInt long y, @MachineSizedSInt long z, @MachineSizedFloat double contentScaleFactor) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        this.setContentScaleFactor(contentScaleFactor);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedSInt long getX();
    @StructMember(0) public native MKTileOverlayPath setX(@MachineSizedSInt long x);
    @StructMember(1) public native @MachineSizedSInt long getY();
    @StructMember(1) public native MKTileOverlayPath setY(@MachineSizedSInt long y);
    @StructMember(2) public native @MachineSizedSInt long getZ();
    @StructMember(2) public native MKTileOverlayPath setZ(@MachineSizedSInt long z);
    @StructMember(3) public native @MachineSizedFloat double getContentScaleFactor();
    @StructMember(3) public native MKTileOverlayPath setContentScaleFactor(@MachineSizedFloat double contentScaleFactor);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
