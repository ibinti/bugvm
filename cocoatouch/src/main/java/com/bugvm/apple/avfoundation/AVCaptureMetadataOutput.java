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
package com.bugvm.apple.avfoundation;

/*<imports>*/
import java.util.*;

import com.bugvm.apple.coregraphics.CGRect;
import com.bugvm.apple.dispatch.DispatchQueue;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureMetadataOutput/*</name>*/ 
    extends /*<extends>*/AVCaptureOutput/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVCaptureMetadataOutputPtr extends Ptr<AVCaptureMetadataOutput, AVCaptureMetadataOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVCaptureMetadataOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVCaptureMetadataOutput() {}
    protected AVCaptureMetadataOutput(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "metadataObjectsDelegate")
    public native AVCaptureMetadataOutputObjectsDelegate getMetadataObjectsDelegate();
    @WeaklyLinked
    @Property(selector = "metadataObjectsCallbackQueue")
    public native DispatchQueue getMetadataObjectsCallbackQueue();
    @Property(selector = "availableMetadataObjectTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(AVMetadataObjectType.AsListMarshaler.class) List<AVMetadataObjectType> getAvailableMetadataObjectTypes();
    @Property(selector = "metadataObjectTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(AVMetadataObjectType.AsListMarshaler.class) List<AVMetadataObjectType> getMetadataObjectTypes();
    @Property(selector = "setMetadataObjectTypes:")
    public native void setMetadataObjectTypes(@com.bugvm.rt.bro.annotation.Marshaler(AVMetadataObjectType.AsListMarshaler.class) List<AVMetadataObjectType> v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "rectOfInterest")
    public native @ByVal
    CGRect getRectOfInterest();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setRectOfInterest:")
    public native void setRectOfInterest(@ByVal CGRect v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "setMetadataObjectsDelegate:queue:")
    public native void setMetadataObjectsDelegate(AVCaptureMetadataOutputObjectsDelegate objectsDelegate, DispatchQueue objectsCallbackQueue);
    /*</methods>*/
}
