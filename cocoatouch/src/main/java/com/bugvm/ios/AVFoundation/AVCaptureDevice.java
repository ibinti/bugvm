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
import com.bugvm.objc.block.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureDevice/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeWasConnected(final VoidBlock1<AVCaptureDevice> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(WasConnectedNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((AVCaptureDevice) a.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeWasDisconnected(final VoidBlock1<AVCaptureDevice> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(WasDisconnectedNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((AVCaptureDevice) a.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 5.0 and later.
         */
        public static NSObject observeSubjectAreaDidChange(AVCaptureDevice object, final VoidBlock1<AVCaptureDevice> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(SubjectAreaDidChangeNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((AVCaptureDevice) a.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class AVCaptureDevicePtr extends Ptr<AVCaptureDevice, AVCaptureDevicePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVCaptureDevice.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVCaptureDevice() {}
    protected AVCaptureDevice(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "uniqueID")
    public native String getUniqueID();
    @Property(selector = "modelID")
    public native String getModelID();
    @Property(selector = "localizedName")
    public native String getLocalizedName();
    @Property(selector = "isConnected")
    public native boolean isConnected();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "formats")
    public native NSArray<AVCaptureDeviceFormat> getFormats();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "activeFormat")
    public native AVCaptureDeviceFormat getActiveFormat();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setActiveFormat:")
    public native void setActiveFormat(AVCaptureDeviceFormat v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "activeVideoMinFrameDuration")
    public native @ByVal CMTime getActiveVideoMinFrameDuration();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setActiveVideoMinFrameDuration:")
    public native void setActiveVideoMinFrameDuration(@ByVal CMTime v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "activeVideoMaxFrameDuration")
    public native @ByVal CMTime getActiveVideoMaxFrameDuration();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setActiveVideoMaxFrameDuration:")
    public native void setActiveVideoMaxFrameDuration(@ByVal CMTime v);
    @Property(selector = "position")
    public native com.bugvm.ios.AVFoundation.AVCaptureDevicePosition getPosition();
    @Property(selector = "hasFlash")
    public native boolean hasFlash();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isFlashAvailable")
    public native boolean isFlashAvailable();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isFlashActive")
    public native boolean isFlashActive();
    @Property(selector = "flashMode")
    public native com.bugvm.ios.AVFoundation.AVCaptureFlashMode getFlashMode();
    @Property(selector = "setFlashMode:")
    public native void setFlashMode(com.bugvm.ios.AVFoundation.AVCaptureFlashMode v);
    @Property(selector = "hasTorch")
    public native boolean hasTorch();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isTorchAvailable")
    public native boolean isTorchAvailable();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "isTorchActive")
    public native boolean isTorchActive();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "torchLevel")
    public native float getTorchLevel();
    @Property(selector = "torchMode")
    public native com.bugvm.ios.AVFoundation.AVCaptureTorchMode getTorchMode();
    @Property(selector = "setTorchMode:")
    public native void setTorchMode(com.bugvm.ios.AVFoundation.AVCaptureTorchMode v);
    @Property(selector = "focusMode")
    public native com.bugvm.ios.AVFoundation.AVCaptureFocusMode getFocusMode();
    @Property(selector = "setFocusMode:")
    public native void setFocusMode(com.bugvm.ios.AVFoundation.AVCaptureFocusMode v);
    @Property(selector = "isFocusPointOfInterestSupported")
    public native boolean isFocusPointOfInterestSupported();
    @Property(selector = "focusPointOfInterest")
    public native @ByVal CGPoint getFocusPointOfInterest();
    @Property(selector = "setFocusPointOfInterest:")
    public native void setFocusPointOfInterest(@ByVal CGPoint v);
    @Property(selector = "isAdjustingFocus")
    public native boolean isAdjustingFocus();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isAutoFocusRangeRestrictionSupported")
    public native boolean isAutoFocusRangeRestrictionSupported();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "autoFocusRangeRestriction")
    public native com.bugvm.ios.AVFoundation.AVCaptureAutoFocusRangeRestriction getAutoFocusRangeRestriction();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setAutoFocusRangeRestriction:")
    public native void setAutoFocusRangeRestriction(com.bugvm.ios.AVFoundation.AVCaptureAutoFocusRangeRestriction v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isSmoothAutoFocusSupported")
    public native boolean isSmoothAutoFocusSupported();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isSmoothAutoFocusEnabled")
    public native boolean isSmoothAutoFocusEnabled();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setSmoothAutoFocusEnabled:")
    public native void setSmoothAutoFocusEnabled(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "lensPosition")
    public native float getLensPosition();
    @Property(selector = "exposureMode")
    public native com.bugvm.ios.AVFoundation.AVCaptureExposureMode getExposureMode();
    @Property(selector = "setExposureMode:")
    public native void setExposureMode(com.bugvm.ios.AVFoundation.AVCaptureExposureMode v);
    @Property(selector = "isExposurePointOfInterestSupported")
    public native boolean isExposurePointOfInterestSupported();
    @Property(selector = "exposurePointOfInterest")
    public native @ByVal CGPoint getExposurePointOfInterest();
    @Property(selector = "setExposurePointOfInterest:")
    public native void setExposurePointOfInterest(@ByVal CGPoint v);
    @Property(selector = "isAdjustingExposure")
    public native boolean isAdjustingExposure();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "lensAperture")
    public native float getLensAperture();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "exposureDuration")
    public native @ByVal CMTime getExposureDuration();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "ISO")
    public native float getISO();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "exposureTargetOffset")
    public native float getExposureTargetOffset();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "exposureTargetBias")
    public native float getExposureTargetBias();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "minExposureTargetBias")
    public native float getMinExposureTargetBias();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "maxExposureTargetBias")
    public native float getMaxExposureTargetBias();
    @Property(selector = "whiteBalanceMode")
    public native com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceMode getWhiteBalanceMode();
    @Property(selector = "setWhiteBalanceMode:")
    public native void setWhiteBalanceMode(com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceMode v);
    @Property(selector = "isAdjustingWhiteBalance")
    public native boolean isAdjustingWhiteBalance();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "deviceWhiteBalanceGains")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains getDeviceWhiteBalanceGains();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "grayWorldDeviceWhiteBalanceGains")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains getGrayWorldDeviceWhiteBalanceGains();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "maxWhiteBalanceGain")
    public native float getMaxWhiteBalanceGain();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isSubjectAreaChangeMonitoringEnabled")
    public native boolean isSubjectAreaChangeMonitoringEnabled();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setSubjectAreaChangeMonitoringEnabled:")
    public native void setSubjectAreaChangeMonitoringEnabled(boolean v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "isLowLightBoostSupported")
    public native boolean isLowLightBoostSupported();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "isLowLightBoostEnabled")
    public native boolean isLowLightBoostEnabled();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "automaticallyEnablesLowLightBoostWhenAvailable")
    public native boolean automaticallyEnablesLowLightBoostWhenAvailable();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setAutomaticallyEnablesLowLightBoostWhenAvailable:")
    public native void setAutomaticallyEnablesLowLightBoostWhenAvailable(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "videoZoomFactor")
    public native @MachineSizedFloat double getVideoZoomFactor();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setVideoZoomFactor:")
    public native void setVideoZoomFactor(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isRampingVideoZoom")
    public native boolean isRampingVideoZoom();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "automaticallyAdjustsVideoHDREnabled")
    public native boolean automaticallyAdjustsVideoHDREnabled();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setAutomaticallyAdjustsVideoHDREnabled:")
    public native void setAutomaticallyAdjustsVideoHDREnabled(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "isVideoHDREnabled")
    public native boolean isVideoHDREnabled();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setVideoHDREnabled:")
    public native void setVideoHDREnabled(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureDeviceWasConnectedNotification", optional=true)
    public static native NSString WasConnectedNotification();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureDeviceWasDisconnectedNotification", optional=true)
    public static native NSString WasDisconnectedNotification();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalValue(symbol="AVCaptureDeviceSubjectAreaDidChangeNotification", optional=true)
    public static native NSString SubjectAreaDidChangeNotification();
    @GlobalValue(symbol="AVCaptureMaxAvailableTorchLevel", optional=true)
    public static native float getMaxAvailableTorchLevel();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="AVCaptureLensPositionCurrent", optional=true)
    public static native float getLensPositionCurrent();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="AVCaptureExposureDurationCurrent", optional=true)
    public static native @ByVal CMTime getExposureDurationCurrent();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="AVCaptureISOCurrent", optional=true)
    public static native float getISOCurrent();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="AVCaptureExposureTargetBiasCurrent", optional=true)
    public static native float getExposureTargetBiasCurrent();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="AVCaptureWhiteBalanceGainsCurrent", optional=true)
    public static native @ByVal
    com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains getWhiteBalanceGainsCurrent();
    
    @Method(selector = "hasMediaType:")
    public native boolean hasMediaType(com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    public boolean lockForConfiguration() throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = lockForConfiguration(ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "lockForConfiguration:")
    private native boolean lockForConfiguration(NSError.NSErrorPtr outError);
    @Method(selector = "unlockForConfiguration")
    public native void unlockForConfiguration();
    @Method(selector = "supportsAVCaptureSessionPreset:")
    public native boolean supportsAVCaptureSessionPreset(com.bugvm.ios.AVFoundation.AVCaptureSessionPreset preset);
    @Method(selector = "devices")
    public static native NSArray<AVCaptureDevice> getDevices();
    @Method(selector = "devicesWithMediaType:")
    public static native NSArray<AVCaptureDevice> getDevicesForMediaType(com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    @Method(selector = "defaultDeviceWithMediaType:")
    public static native AVCaptureDevice getDefaultDeviceForMediaType(com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    @Method(selector = "deviceWithUniqueID:")
    public static native AVCaptureDevice getDeviceWithUniqueID(String deviceUniqueID);
    @Method(selector = "isFlashModeSupported:")
    public native boolean isFlashModeSupported(com.bugvm.ios.AVFoundation.AVCaptureFlashMode flashMode);
    @Method(selector = "isTorchModeSupported:")
    public native boolean isTorchModeSupported(com.bugvm.ios.AVFoundation.AVCaptureTorchMode torchMode);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean setTorchModeOn(float torchLevel) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setTorchModeOn(torchLevel, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setTorchModeOnWithLevel:error:")
    private native boolean setTorchModeOn(float torchLevel, NSError.NSErrorPtr outError);
    @Method(selector = "isFocusModeSupported:")
    public native boolean isFocusModeSupported(com.bugvm.ios.AVFoundation.AVCaptureFocusMode focusMode);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setFocusModeLockedWithLensPosition:completionHandler:")
    public native void setFocusModeLocked(float lensPosition, @Block VoidBlock1<CMTime> handler);
    @Method(selector = "isExposureModeSupported:")
    public native boolean isExposureModeSupported(com.bugvm.ios.AVFoundation.AVCaptureExposureMode exposureMode);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setExposureModeCustomWithDuration:ISO:completionHandler:")
    public native void setExposureModeCustom(@ByVal CMTime duration, float ISO, @Block VoidBlock1<CMTime> handler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setExposureTargetBias:completionHandler:")
    public native void setExposureTargetBias(float bias, @Block VoidBlock1<CMTime> handler);
    @Method(selector = "isWhiteBalanceModeSupported:")
    public native boolean isWhiteBalanceModeSupported(com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceMode whiteBalanceMode);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setWhiteBalanceModeLockedWithDeviceWhiteBalanceGains:completionHandler:")
    public native void setWhiteBalanceModeLocked(@ByVal com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains whiteBalanceGains, @Block VoidBlock1<CMTime> handler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "chromaticityValuesForDeviceWhiteBalanceGains:")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceChromaticityValues convertDeviceWhiteBalanceGainsToChromaticityValues(@ByVal com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains whiteBalanceGains);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "deviceWhiteBalanceGainsForChromaticityValues:")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains convertChromaticityValuesToDeviceWhiteBalanceGains(@ByVal com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceChromaticityValues chromaticityValues);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "temperatureAndTintValuesForDeviceWhiteBalanceGains:")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceTemperatureAndTintValues convertDeviceWhiteBalanceGainsToTemperatureAndTintValues(@ByVal com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains whiteBalanceGains);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "deviceWhiteBalanceGainsForTemperatureAndTintValues:")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceGains convertTemperatureAndTintValuesToDeviceWhiteBalanceGains(@ByVal com.bugvm.ios.AVFoundation.AVCaptureWhiteBalanceTemperatureAndTintValues tempAndTintValues);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "rampToVideoZoomFactor:withRate:")
    public native void rampToVideoZoomFactor(@MachineSizedFloat double factor, float rate);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "cancelVideoZoomRamp")
    public native void cancelVideoZoomRamp();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "authorizationStatusForMediaType:")
    public static native com.bugvm.ios.AVFoundation.AVAuthorizationStatus getAuthorizationStatusForMediaType(com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "requestAccessForMediaType:completionHandler:")
    public static native void requestAccessForMediaType(com.bugvm.ios.AVFoundation.AVMediaType mediaType, @Block VoidBooleanBlock handler);
    /*</methods>*/
}
