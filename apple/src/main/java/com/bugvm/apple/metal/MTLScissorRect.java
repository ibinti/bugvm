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
package com.bugvm.apple.metal;

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
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MTLScissorRect/*</name>*/ 
    extends /*<extends>*/Struct<MTLScissorRect>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MTLScissorRectPtr extends Ptr<MTLScissorRect, MTLScissorRectPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MTLScissorRect() {}
    public MTLScissorRect(@MachineSizedUInt long x, @MachineSizedUInt long y, @MachineSizedUInt long width, @MachineSizedUInt long height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedUInt long getX();
    @StructMember(0) public native MTLScissorRect setX(@MachineSizedUInt long x);
    @StructMember(1) public native @MachineSizedUInt long getY();
    @StructMember(1) public native MTLScissorRect setY(@MachineSizedUInt long y);
    @StructMember(2) public native @MachineSizedUInt long getWidth();
    @StructMember(2) public native MTLScissorRect setWidth(@MachineSizedUInt long width);
    @StructMember(3) public native @MachineSizedUInt long getHeight();
    @StructMember(3) public native MTLScissorRect setHeight(@MachineSizedUInt long height);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
