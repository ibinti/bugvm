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
import java.util.*;

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioSession/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 6.0 and later.
         */
        public static NSObject observeInterruption(final VoidBlock1<AVAudioSessionInterruptionNotification> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(InterruptionNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    NSDictionary<?, ?> userInfo = a.getUserInfo();
                    AVAudioSessionInterruptionNotification data = null;
                    if (userInfo != null) {
                        data = new AVAudioSessionInterruptionNotification(userInfo);
                    }
                    block.invoke(data);
                }
            });
        }
        
        /**
         * @since Available in iOS 6.0 and later.
         */
        public static NSObject observeRouteChange(final VoidBlock1<com.bugvm.ios.AVFoundation.AVAudioSessionRouteChangeNotification> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(RouteChangeNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    NSDictionary<?, ?> userInfo = a.getUserInfo();
                    com.bugvm.ios.AVFoundation.AVAudioSessionRouteChangeNotification data = null;
                    if (userInfo != null) {
                        data = new com.bugvm.ios.AVFoundation.AVAudioSessionRouteChangeNotification(userInfo);
                    }
                    block.invoke(data);
                }
            });
        }
        /**
         * @since Available in iOS 7.0 and later.
         */
        public static NSObject observeMediaServicesWereLost(final Runnable block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(MediaServicesWereLostNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.run();
                }
            });
        }
        /**
         * @since Available in iOS 6.0 and later.
         */
        public static NSObject observeMediaServicesWereReset(final Runnable block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(MediaServicesWereResetNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.run();
                }
            });
        }
        /**
         * @since Available in iOS 8.0 and later.
         */
        public static NSObject observeSilenceSecondaryAudioHint(final VoidBlock1<com.bugvm.ios.AVFoundation.AVAudioSessionSilenceSecondaryAudioHintType> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(SilenceSecondaryAudioHintNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    NSDictionary<?, ?> userInfo = a.getUserInfo();
                    com.bugvm.ios.AVFoundation.AVAudioSessionSilenceSecondaryAudioHintType type = null;
                    if (userInfo.containsKey(SilenceSecondaryAudioHintTypeKey())) {
                        NSNumber val = (NSNumber)userInfo.get(SilenceSecondaryAudioHintTypeKey());
                        type = com.bugvm.ios.AVFoundation.AVAudioSessionSilenceSecondaryAudioHintType.valueOf(val.intValue());
                    }
                    block.invoke(type);
                }
            });
        }
    }
    
    /*<ptr>*/public static class AVAudioSessionPtr extends Ptr<AVAudioSession, AVAudioSessionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioSession.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioSession() {}
    protected AVAudioSession(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "availableCategories")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVAudioSessionCategory.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVAudioSessionCategory> getAvailableCategories();
    @Property(selector = "category")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionCategory getCategory();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "categoryOptions")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionCategoryOptions getCategoryOptions();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "availableModes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVAudioSessionMode.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVAudioSessionMode> getAvailableModes();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "mode")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionMode getMode();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "isOtherAudioPlaying")
    public native boolean isOtherAudioPlaying();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "secondaryAudioShouldBeSilencedHint")
    public native boolean secondaryAudioShouldBeSilencedHint();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "currentRoute")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionRouteDescription getCurrentRoute();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "preferredInput")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionPortDescription getPreferredInput();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "availableInputs")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAudioSessionPortDescription> getAvailableInputs();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "preferredSampleRate")
    public native double getPreferredSampleRate();
    @Property(selector = "preferredIOBufferDuration")
    public native double getPreferredIOBufferDuration();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "preferredInputNumberOfChannels")
    public native @MachineSizedSInt long getPreferredInputNumberOfChannels();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "preferredOutputNumberOfChannels")
    public native @MachineSizedSInt long getPreferredOutputNumberOfChannels();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "maximumInputNumberOfChannels")
    public native @MachineSizedSInt long getMaximumInputNumberOfChannels();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "maximumOutputNumberOfChannels")
    public native @MachineSizedSInt long getMaximumOutputNumberOfChannels();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "inputGain")
    public native float getInputGain();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "isInputGainSettable")
    public native boolean isInputGainSettable();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "isInputAvailable")
    public native boolean isInputAvailable();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "inputDataSources")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription> getInputDataSources();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "inputDataSource")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription getInputDataSource();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "outputDataSources")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription> getOutputDataSources();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "outputDataSource")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription getOutputDataSource();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "sampleRate")
    public native double getSampleRate();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "inputNumberOfChannels")
    public native @MachineSizedSInt long getInputNumberOfChannels();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "outputNumberOfChannels")
    public native @MachineSizedSInt long getOutputNumberOfChannels();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "outputVolume")
    public native float getOutputVolume();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "inputLatency")
    public native double getInputLatency();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "outputLatency")
    public native double getOutputLatency();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "IOBufferDuration")
    public native double getIOBufferDuration();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="AVAudioSessionInterruptionNotification", optional=true)
    public static native NSString InterruptionNotification();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="AVAudioSessionRouteChangeNotification", optional=true)
    public static native NSString RouteChangeNotification();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="AVAudioSessionMediaServicesWereLostNotification", optional=true)
    public static native NSString MediaServicesWereLostNotification();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="AVAudioSessionMediaServicesWereResetNotification", optional=true)
    public static native NSString MediaServicesWereResetNotification();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="AVAudioSessionSilenceSecondaryAudioHintNotification", optional=true)
    public static native NSString SilenceSecondaryAudioHintNotification();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="AVAudioSessionSilenceSecondaryAudioHintTypeKey", optional=true)
    protected static native NSString SilenceSecondaryAudioHintTypeKey();
    
    public boolean setActive(boolean active) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setActive(active, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "setActive:error:")
    private native boolean setActive(boolean active, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean setActive(boolean active, com.bugvm.ios.AVFoundation.AVAudioSessionSetActiveOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setActive(active, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setActive:withOptions:error:")
    private native boolean setActive(boolean active, com.bugvm.ios.AVFoundation.AVAudioSessionSetActiveOptions options, NSError.NSErrorPtr outError);
    public boolean setCategory(com.bugvm.ios.AVFoundation.AVAudioSessionCategory category) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setCategory(category, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "setCategory:error:")
    private native boolean setCategory(com.bugvm.ios.AVFoundation.AVAudioSessionCategory category, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean setCategory(com.bugvm.ios.AVFoundation.AVAudioSessionCategory category, com.bugvm.ios.AVFoundation.AVAudioSessionCategoryOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setCategory(category, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setCategory:withOptions:error:")
    private native boolean setCategory(com.bugvm.ios.AVFoundation.AVAudioSessionCategory category, com.bugvm.ios.AVFoundation.AVAudioSessionCategoryOptions options, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "recordPermission")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionRecordPermission getRecordPermission();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "requestRecordPermission:")
    public native void requestRecordPermission(@Block VoidBooleanBlock response);
    /**
     * @since Available in iOS 5.0 and later.
     */
    public boolean setMode(com.bugvm.ios.AVFoundation.AVAudioSessionMode mode) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setMode(mode, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setMode:error:")
    private native boolean setMode(com.bugvm.ios.AVFoundation.AVAudioSessionMode mode, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean overrideOutputAudioPort(com.bugvm.ios.AVFoundation.AVAudioSessionPortOverride portOverride) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = overrideOutputAudioPort(portOverride, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "overrideOutputAudioPort:error:")
    private native boolean overrideOutputAudioPort(com.bugvm.ios.AVFoundation.AVAudioSessionPortOverride portOverride, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 7.0 and later.
     */
    public boolean setPreferredInput(com.bugvm.ios.AVFoundation.AVAudioSessionPortDescription inPort) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setPreferredInput(inPort, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "setPreferredInput:error:")
    private native boolean setPreferredInput(com.bugvm.ios.AVFoundation.AVAudioSessionPortDescription inPort, NSError.NSErrorPtr outError);
    @Method(selector = "sharedInstance")
    public static native AVAudioSession getSharedInstance();
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean setPreferredSampleRate(double sampleRate) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setPreferredSampleRate(sampleRate, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setPreferredSampleRate:error:")
    private native boolean setPreferredSampleRate(double sampleRate, NSError.NSErrorPtr outError);
    public boolean setPreferredIOBufferDuration(double duration) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setPreferredIOBufferDuration(duration, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "setPreferredIOBufferDuration:error:")
    private native boolean setPreferredIOBufferDuration(double duration, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 7.0 and later.
     */
    public boolean setPreferredInputNumberOfChannels(@MachineSizedSInt long count) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setPreferredInputNumberOfChannels(count, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "setPreferredInputNumberOfChannels:error:")
    private native boolean setPreferredInputNumberOfChannels(@MachineSizedSInt long count, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 7.0 and later.
     */
    public boolean setPreferredOutputNumberOfChannels(@MachineSizedSInt long count) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setPreferredOutputNumberOfChannels(count, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "setPreferredOutputNumberOfChannels:error:")
    private native boolean setPreferredOutputNumberOfChannels(@MachineSizedSInt long count, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean setInputGain(float gain) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setInputGain(gain, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setInputGain:error:")
    private native boolean setInputGain(float gain, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean setInputDataSource(com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription dataSource) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setInputDataSource(dataSource, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setInputDataSource:error:")
    private native boolean setInputDataSource(com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription dataSource, NSError.NSErrorPtr outError);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public boolean setOutputDataSource(com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription dataSource) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setOutputDataSource(dataSource, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setOutputDataSource:error:")
    private native boolean setOutputDataSource(com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription dataSource, NSError.NSErrorPtr outError);
    /*</methods>*/
}
