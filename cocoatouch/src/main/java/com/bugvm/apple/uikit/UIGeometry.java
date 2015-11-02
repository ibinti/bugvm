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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("UIKit")/*</annotations>*/
@Marshaler(NSString.AsStringMarshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIGeometry/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(UIGeometry.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Bridge(symbol="NSStringFromCGPoint", optional=true)
    public static native String toString(@ByVal CGPoint point);
    @Bridge(symbol="NSStringFromCGVector", optional=true)
    public static native String toString(@ByVal CGVector vector);
    @Bridge(symbol="NSStringFromCGSize", optional=true)
    public static native String toString(@ByVal CGSize size);
    @Bridge(symbol="NSStringFromCGRect", optional=true)
    public static native String toString(@ByVal CGRect rect);
    @Bridge(symbol="NSStringFromCGAffineTransform", optional=true)
    public static native String toString(@ByVal CGAffineTransform transform);
    @Bridge(symbol="CGPointFromString", optional=true)
    public static native @ByVal CGPoint stringToCGPoint(String string);
    @Bridge(symbol="CGVectorFromString", optional=true)
    public static native @ByVal CGVector stringToCGVector(String string);
    @Bridge(symbol="CGSizeFromString", optional=true)
    public static native @ByVal CGSize stringToCGSize(String string);
    @Bridge(symbol="CGRectFromString", optional=true)
    public static native @ByVal CGRect stringToCGRect(String string);
    @Bridge(symbol="CGAffineTransformFromString", optional=true)
    public static native @ByVal CGAffineTransform stringToCGAffineTransform(String string);
    /*</methods>*/
}
