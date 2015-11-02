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
package com.bugvm.apple.scenekit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.spritekit.*;
import com.bugvm.apple.opengles.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("SceneKit")/*</annotations>*/
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
    @Property(selector = "SCNVector3Value")
    public static native @ByVal SCNVector3 getSCNVector3Value(NSValue thiz);
    @Property(selector = "SCNVector4Value")
    public static native @ByVal SCNVector4 getSCNVector4Value(NSValue thiz);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "SCNMatrix4Value")
    public static native @ByVal SCNMatrix4 getSCNMatrix4Value(NSValue thiz);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "valueWithSCNVector3:")
    protected static native NSValue create(ObjCClass clazz, @ByVal SCNVector3 v);
    public static NSValue create(@ByVal SCNVector3 v) { return create(ObjCClass.getByType(NSValue.class), v); }
    @Method(selector = "valueWithSCNVector4:")
    protected static native NSValue create(ObjCClass clazz, @ByVal SCNVector4 v);
    public static NSValue create(@ByVal SCNVector4 v) { return create(ObjCClass.getByType(NSValue.class), v); }
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "valueWithSCNMatrix4:")
    protected static native NSValue create(ObjCClass clazz, @ByVal SCNMatrix4 v);
    public static NSValue create(@ByVal SCNMatrix4 v) { return create(ObjCClass.getByType(NSValue.class), v); }
    /*</methods>*/
}
