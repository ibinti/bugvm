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
package com.bugvm.apple.opengles;

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
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("OpenGLES") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/EAGLContext/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class EAGLContextPtr extends Ptr<EAGLContext, EAGLContextPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(EAGLContext.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public EAGLContext() {}
    protected EAGLContext(SkipInit skipInit) { super(skipInit); }
    public EAGLContext(EAGLRenderingAPI api) { super((SkipInit) null); initObject(init(api)); }
    public EAGLContext(EAGLRenderingAPI api, EAGLSharegroup sharegroup) { super((SkipInit) null); initObject(init(api, sharegroup)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "API")
    public native EAGLRenderingAPI getAPI();
    @Property(selector = "sharegroup")
    public native EAGLSharegroup getSharegroup();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "debugLabel")
    public native String getDebugLabel();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setDebugLabel:")
    public native void setDebugLabel(String v);
    /**
     * @since Available in iOS 7.1 and later.
     */
    @Property(selector = "isMultiThreaded")
    public native boolean isMultiThreaded();
    /**
     * @since Available in iOS 7.1 and later.
     */
    @Property(selector = "setMultiThreaded:")
    public native void setMultiThreaded(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAPI:")
    protected native @Pointer long init(EAGLRenderingAPI api);
    @Method(selector = "initWithAPI:sharegroup:")
    protected native @Pointer long init(EAGLRenderingAPI api, EAGLSharegroup sharegroup);
    @Method(selector = "setCurrentContext:")
    public static native boolean setCurrentContext(EAGLContext context);
    @Method(selector = "currentContext")
    public static native EAGLContext getCurrentContext();
    @Method(selector = "renderbufferStorage:fromDrawable:")
    public native boolean renderbufferStorage(@MachineSizedUInt long target, EAGLDrawable drawable);
    @Method(selector = "presentRenderbuffer:")
    public native boolean presentRenderbuffer(@MachineSizedUInt long target);
    /*</methods>*/
}
