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
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureSession/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeRuntimeError(AVCaptureSession object, final VoidBlock2<AVCaptureSession, NSError> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(RuntimeErrorNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    NSDictionary<?, ?> data = a.getUserInfo();
                    NSError error = null;
                    if (data.containsKey(NotificationErrorKey())) {
                        error = (NSError) data.get(NotificationErrorKey());
                    }
                    block.invoke((AVCaptureSession)a.getObject(), error);
                }
            });
        }
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeDidStartRunning(AVCaptureSession object, final VoidBlock1<AVCaptureSession> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(DidStartRunningNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((AVCaptureSession)a.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeDidStopRunning(AVCaptureSession object, final VoidBlock1<AVCaptureSession> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(DidStopRunningNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((AVCaptureSession)a.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeWasInterrupted(AVCaptureSession object, final VoidBlock2<AVCaptureSession, AVCaptureSessionInterruptionReason> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(WasInterruptedNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    AVCaptureSessionInterruptionReason reason = AVCaptureSessionInterruptionReason.Unavailable;
                    if (Foundation.getMajorSystemVersion() >= 9) {
                        NSDictionary<?, ?> data = notification.getUserInfo();
                        int value = data.getInt(NotificationInterruptionReasonKey(), 0);
                        if (value != 0) {
                            reason = AVCaptureSessionInterruptionReason.valueOf(value);
                        }
                    }
                    block.invoke((AVCaptureSession)notification.getObject(), reason);
                }
            });
        }
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeInterruptionEnded(AVCaptureSession object, final VoidBlock1<AVCaptureSession> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(InterruptionEndedNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((AVCaptureSession)a.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class AVCaptureSessionPtr extends Ptr<AVCaptureSession, AVCaptureSessionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVCaptureSession.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVCaptureSession() {}
    protected AVCaptureSession(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "sessionPreset")
    public native com.bugvm.ios.AVFoundation.AVCaptureSessionPreset getSessionPreset();
    @Property(selector = "setSessionPreset:")
    public native void setSessionPreset(com.bugvm.ios.AVFoundation.AVCaptureSessionPreset v);
    @Property(selector = "inputs")
    public native NSArray<com.bugvm.ios.AVFoundation.AVCaptureInput> getInputs();
    @Property(selector = "outputs")
    public native NSArray<com.bugvm.ios.AVFoundation.AVCaptureOutput> getOutputs();
    @Property(selector = "isRunning")
    public native boolean isRunning();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "isInterrupted")
    public native boolean isInterrupted();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "usesApplicationAudioSession")
    public native boolean usesApplicationAudioSession();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setUsesApplicationAudioSession:")
    public native void setUsesApplicationAudioSession(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "automaticallyConfiguresApplicationAudioSession")
    public native boolean automaticallyConfiguresApplicationAudioSession();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setAutomaticallyConfiguresApplicationAudioSession:")
    public native void setAutomaticallyConfiguresApplicationAudioSession(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "masterClock")
    public native CMClock getMasterClock();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureSessionRuntimeErrorNotification", optional=true)
    public static native NSString RuntimeErrorNotification();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureSessionErrorKey", optional=true)
    protected static native NSString NotificationErrorKey();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureSessionDidStartRunningNotification", optional=true)
    public static native NSString DidStartRunningNotification();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureSessionDidStopRunningNotification", optional=true)
    public static native NSString DidStopRunningNotification();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureSessionWasInterruptedNotification", optional=true)
    public static native NSString WasInterruptedNotification();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="AVCaptureSessionInterruptionReasonKey", optional=true)
    protected static native NSString NotificationInterruptionReasonKey();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVCaptureSessionInterruptionEndedNotification", optional=true)
    public static native NSString InterruptionEndedNotification();
    
    @Method(selector = "canSetSessionPreset:")
    public native boolean canSetSessionPreset(com.bugvm.ios.AVFoundation.AVCaptureSessionPreset preset);
    @Method(selector = "canAddInput:")
    public native boolean canAddInput(com.bugvm.ios.AVFoundation.AVCaptureInput input);
    @Method(selector = "addInput:")
    public native void addInput(com.bugvm.ios.AVFoundation.AVCaptureInput input);
    @Method(selector = "removeInput:")
    public native void removeInput(com.bugvm.ios.AVFoundation.AVCaptureInput input);
    @Method(selector = "canAddOutput:")
    public native boolean canAddOutput(com.bugvm.ios.AVFoundation.AVCaptureOutput output);
    @Method(selector = "addOutput:")
    public native void addOutput(com.bugvm.ios.AVFoundation.AVCaptureOutput output);
    @Method(selector = "removeOutput:")
    public native void removeOutput(com.bugvm.ios.AVFoundation.AVCaptureOutput output);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "addInputWithNoConnections:")
    public native void addInputWithNoConnections(com.bugvm.ios.AVFoundation.AVCaptureInput input);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "addOutputWithNoConnections:")
    public native void addOutputWithNoConnections(com.bugvm.ios.AVFoundation.AVCaptureOutput output);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "canAddConnection:")
    public native boolean canAddConnection(com.bugvm.ios.AVFoundation.AVCaptureConnection connection);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "addConnection:")
    public native void addConnection(com.bugvm.ios.AVFoundation.AVCaptureConnection connection);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "removeConnection:")
    public native void removeConnection(com.bugvm.ios.AVFoundation.AVCaptureConnection connection);
    @Method(selector = "beginConfiguration")
    public native void beginConfiguration();
    @Method(selector = "commitConfiguration")
    public native void commitConfiguration();
    @Method(selector = "startRunning")
    public native void startRunning();
    @Method(selector = "stopRunning")
    public native void stopRunning();
    /*</methods>*/
}
