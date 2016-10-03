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
package com.bugvm.ios.AVFoundation;

/*<imports>*/

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureVideoPreviewLayer/*</name>*/ 
    extends /*<extends>*/CALayer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVCaptureVideoPreviewLayerPtr extends Ptr<AVCaptureVideoPreviewLayer, AVCaptureVideoPreviewLayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVCaptureVideoPreviewLayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVCaptureVideoPreviewLayer() {}
    protected AVCaptureVideoPreviewLayer(SkipInit skipInit) { super(skipInit); }
    public AVCaptureVideoPreviewLayer(com.bugvm.ios.AVFoundation.AVCaptureSession session) { super((SkipInit) null); initObject(init(session)); }
    /*</constructors>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    public AVCaptureVideoPreviewLayer(com.bugvm.ios.AVFoundation.AVCaptureSession session, boolean noConnection) {
        super((SkipInit) null);
        initObject(noConnection ? initWithNoConnection(session) : init(session));
    }
    /*<properties>*/
    @Property(selector = "session")
    public native com.bugvm.ios.AVFoundation.AVCaptureSession getSession();
    @Property(selector = "setSession:")
    public native void setSession(com.bugvm.ios.AVFoundation.AVCaptureSession v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "connection")
    public native AVCaptureConnection getConnection();
    @Property(selector = "videoGravity")
    public native com.bugvm.ios.AVFoundation.AVLayerVideoGravity getVideoGravity();
    @Property(selector = "setVideoGravity:")
    public native void setVideoGravity(com.bugvm.ios.AVFoundation.AVLayerVideoGravity v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithSession:")
    protected native @Pointer long init(com.bugvm.ios.AVFoundation.AVCaptureSession session);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "initWithSessionWithNoConnection:")
    protected native @Pointer long initWithNoConnection(com.bugvm.ios.AVFoundation.AVCaptureSession session);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setSessionWithNoConnection:")
    public native void setSessionWithNoConnection(com.bugvm.ios.AVFoundation.AVCaptureSession session);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "captureDevicePointOfInterestForPoint:")
    public native @ByVal CGPoint captureDevicePointOfInterest(@ByVal CGPoint pointInLayer);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "pointForCaptureDevicePointOfInterest:")
    public native @ByVal CGPoint getDevicePointOfInterest(@ByVal CGPoint captureDevicePointOfInterest);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "metadataOutputRectOfInterestForRect:")
    public native @ByVal CGRect getRectOfInterestInLayerCoordinates(@ByVal CGRect rectInLayerCoordinates);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "rectForMetadataOutputRectOfInterest:")
    public native @ByVal CGRect getRectOfInterestInMetadataOutputCoordinates(@ByVal CGRect rectInMetadataOutputCoordinates);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "transformedMetadataObjectForMetadataObject:")
    public native com.bugvm.ios.AVFoundation.AVMetadataObject getTransformedMetadataObject(com.bugvm.ios.AVFoundation.AVMetadataObject metadataObject);
    /*</methods>*/
}
