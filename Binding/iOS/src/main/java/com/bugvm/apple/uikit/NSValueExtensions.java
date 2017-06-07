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
/*<visibility>*/public final/*</visibility>*/ class /*<name>*/NSValueExtensions/*</name>*/ 
    extends /*<extends>*/NSExtensions/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSValueExtensions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    private NSValueExtensions() {}
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "CGPointValue")
    public static native @ByVal CGPoint getPointValue(NSValue thiz);
    @Method(selector = "CGVectorValue")
    public static native @ByVal CGVector getVectorValue(NSValue thiz);
    @Method(selector = "CGSizeValue")
    public static native @ByVal CGSize getSizeValue(NSValue thiz);
    @Method(selector = "CGRectValue")
    public static native @ByVal CGRect getRectValue(NSValue thiz);
    @Method(selector = "CGAffineTransformValue")
    public static native @ByVal CGAffineTransform getAffineTransformValue(NSValue thiz);
    @Method(selector = "UIEdgeInsetsValue")
    public static native @ByVal UIEdgeInsets getEdgeInsetsValue(NSValue thiz);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "UIOffsetValue")
    public static native @ByVal UIOffset getOffsetValue(NSValue thiz);
    @Method(selector = "valueWithCGPoint:")
    protected static native NSValue create(ObjCClass clazz, @ByVal CGPoint point);
    public static NSValue create(@ByVal CGPoint point) { return create(ObjCClass.getByType(NSValue.class), point); }
    @Method(selector = "valueWithCGVector:")
    protected static native NSValue create(ObjCClass clazz, @ByVal CGVector vector);
    public static NSValue create(@ByVal CGVector vector) { return create(ObjCClass.getByType(NSValue.class), vector); }
    @Method(selector = "valueWithCGSize:")
    protected static native NSValue create(ObjCClass clazz, @ByVal CGSize size);
    public static NSValue create(@ByVal CGSize size) { return create(ObjCClass.getByType(NSValue.class), size); }
    @Method(selector = "valueWithCGRect:")
    protected static native NSValue create(ObjCClass clazz, @ByVal CGRect rect);
    public static NSValue create(@ByVal CGRect rect) { return create(ObjCClass.getByType(NSValue.class), rect); }
    @Method(selector = "valueWithCGAffineTransform:")
    protected static native NSValue create(ObjCClass clazz, @ByVal CGAffineTransform transform);
    public static NSValue create(@ByVal CGAffineTransform transform) { return create(ObjCClass.getByType(NSValue.class), transform); }
    @Method(selector = "valueWithUIEdgeInsets:")
    protected static native NSValue create(ObjCClass clazz, @ByVal UIEdgeInsets insets);
    public static NSValue create(@ByVal UIEdgeInsets insets) { return create(ObjCClass.getByType(NSValue.class), insets); }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "valueWithUIOffset:")
    protected static native NSValue create(ObjCClass clazz, @ByVal UIOffset insets);
    public static NSValue create(@ByVal UIOffset insets) { return create(ObjCClass.getByType(NSValue.class), insets); }
    /*</methods>*/
}
