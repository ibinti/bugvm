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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVPlayerItem/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 5.0 and later.
         */
        public static NSObject observeTimeJumped(AVPlayerItem object, final VoidBlock1<AVPlayerItem> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(TimeJumpedNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVPlayerItem)notification.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 4.0 and later.
         */
        public static NSObject observeDidPlayToEndTime(AVPlayerItem object, final VoidBlock1<AVPlayerItem> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(DidPlayToEndTimeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVPlayerItem)notification.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 4.3 and later.
         */
        public static NSObject observeFailedToPlayToEndTime(AVPlayerItem object, final VoidBlock2<AVPlayerItem, NSError> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(FailedToPlayToEndTimeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    NSDictionary<?, ?> data = notification.getUserInfo();
                    NSError error = null;
                    if (data.containsKey(FailedToPlayToEndTimeErrorKey())) {
                        error = (NSError) data.get(FailedToPlayToEndTimeErrorKey());
                    }
                    block.invoke((AVPlayerItem)notification.getObject(), error);
                }
            });
        }
        /**
         * @since Available in iOS 6.0 and later.
         */
        public static NSObject observePlaybackStalled(AVPlayerItem object, final VoidBlock1<AVPlayerItem> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(PlaybackStalledNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVPlayerItem)notification.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 6.0 and later.
         */
        public static NSObject observeNewAccessLogEntry(AVPlayerItem object, final VoidBlock1<AVPlayerItem> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(NewAccessLogEntryNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVPlayerItem)notification.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 6.0 and later.
         */
        public static NSObject observeNewErrorLogEntry(AVPlayerItem object, final VoidBlock1<AVPlayerItem> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(NewErrorLogEntryNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVPlayerItem)notification.getObject());
                }
            });
        }
    }
    
    
    /*<ptr>*/public static class AVPlayerItemPtr extends Ptr<AVPlayerItem, AVPlayerItemPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVPlayerItem.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVPlayerItem() {}
    protected AVPlayerItem(SkipInit skipInit) { super(skipInit); }
    public AVPlayerItem(NSURL URL) { super((SkipInit) null); initObject(init(URL)); }
    public AVPlayerItem(com.bugvm.ios.AVFoundation.AVAsset asset) { super((SkipInit) null); initObject(init(asset)); }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public AVPlayerItem(com.bugvm.ios.AVFoundation.AVAsset asset, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> automaticallyLoadedAssetKeys) { super((SkipInit) null); initObject(init(asset, automaticallyLoadedAssetKeys)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "status")
    public native AVPlayerItemStatus getStatus();
    @Property(selector = "error")
    public native NSError getError();
    @Property(selector = "asset")
    public native com.bugvm.ios.AVFoundation.AVAsset getAsset();
    @Property(selector = "tracks")
    public native NSArray<com.bugvm.ios.AVFoundation.AVPlayerItemTrack> getTracks();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "duration")
    public native @ByVal CMTime getDuration();
    @Property(selector = "presentationSize")
    public native @ByVal CGSize getPresentationSize();
    @Property(selector = "timedMetadata")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getTimedMetadata();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "automaticallyLoadedAssetKeys")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAutomaticallyLoadedAssetKeys();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "canPlayFastForward")
    public native boolean canPlayFastForward();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "canPlaySlowForward")
    public native boolean canPlaySlowForward();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "canPlayReverse")
    public native boolean canPlayReverse();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "canPlaySlowReverse")
    public native boolean canPlaySlowReverse();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "canPlayFastReverse")
    public native boolean canPlayFastReverse();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "canStepForward")
    public native boolean canStepForward();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "canStepBackward")
    public native boolean canStepBackward();
    @Property(selector = "forwardPlaybackEndTime")
    public native @ByVal CMTime getForwardPlaybackEndTime();
    @Property(selector = "setForwardPlaybackEndTime:")
    public native void setForwardPlaybackEndTime(@ByVal CMTime v);
    @Property(selector = "reversePlaybackEndTime")
    public native @ByVal CMTime getReversePlaybackEndTime();
    @Property(selector = "setReversePlaybackEndTime:")
    public native void setReversePlaybackEndTime(@ByVal CMTime v);
    @Property(selector = "seekableTimeRanges")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CMTimeRange.AsValuedListMarshaler.class) List<CMTimeRange> getSeekableTimeRanges();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "timebase")
    public native CMTimebase getTimebase();
    @Property(selector = "videoComposition")
    public native com.bugvm.ios.AVFoundation.AVVideoComposition getVideoComposition();
    @Property(selector = "setVideoComposition:")
    public native void setVideoComposition(com.bugvm.ios.AVFoundation.AVVideoComposition v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "customVideoCompositor")
    public native com.bugvm.ios.AVFoundation.AVVideoCompositing getCustomVideoCompositor();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "seekingWaitsForVideoCompositionRendering")
    public native boolean seekingWaitsForVideoCompositionRendering();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setSeekingWaitsForVideoCompositionRendering:")
    public native void seekingWaitsForVideoCompositionRendering(boolean v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "textStyleRules")
    public native NSArray<com.bugvm.ios.AVFoundation.AVTextStyleRule> getTextStyleRules();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setTextStyleRules:")
    public native void setTextStyleRules(NSArray<com.bugvm.ios.AVFoundation.AVTextStyleRule> v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "audioTimePitchAlgorithm")
    public native String getAudioTimePitchAlgorithm();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setAudioTimePitchAlgorithm:")
    public native void setAudioTimePitchAlgorithm(String v);
    @Property(selector = "audioMix")
    public native com.bugvm.ios.AVFoundation.AVAudioMix getAudioMix();
    @Property(selector = "setAudioMix:")
    public native void setAudioMix(com.bugvm.ios.AVFoundation.AVAudioMix v);
    @Property(selector = "loadedTimeRanges")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CMTimeRange.AsValuedListMarshaler.class) List<CMTimeRange> getLoadedTimeRanges();
    @Property(selector = "isPlaybackLikelyToKeepUp")
    public native boolean isPlaybackLikelyToKeepUp();
    @Property(selector = "isPlaybackBufferFull")
    public native boolean isPlaybackBufferFull();
    @Property(selector = "isPlaybackBufferEmpty")
    public native boolean isPlaybackBufferEmpty();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "canUseNetworkResourcesForLiveStreamingWhilePaused")
    public native boolean canUseNetworkResourcesForLiveStreamingWhilePaused();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setCanUseNetworkResourcesForLiveStreamingWhilePaused:")
    public native void setCanUseNetworkResourcesForLiveStreamingWhilePaused(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "preferredPeakBitRate")
    public native double getPreferredPeakBitRate();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setPreferredPeakBitRate:")
    public native void setPreferredPeakBitRate(double v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "currentMediaSelection")
    public native com.bugvm.ios.AVFoundation.AVMediaSelection getCurrentMediaSelection();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "outputs")
    public native NSArray<com.bugvm.ios.AVFoundation.AVPlayerItemOutput> getOutputs();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalValue(symbol="AVPlayerItemTimeJumpedNotification", optional=true)
    public static native NSString TimeJumpedNotification();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalValue(symbol="AVPlayerItemDidPlayToEndTimeNotification", optional=true)
    public static native NSString DidPlayToEndTimeNotification();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @GlobalValue(symbol="AVPlayerItemFailedToPlayToEndTimeNotification", optional=true)
    public static native NSString FailedToPlayToEndTimeNotification();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="AVPlayerItemPlaybackStalledNotification", optional=true)
    public static native NSString PlaybackStalledNotification();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="AVPlayerItemNewAccessLogEntryNotification", optional=true)
    public static native NSString NewAccessLogEntryNotification();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="AVPlayerItemNewErrorLogEntryNotification", optional=true)
    public static native NSString NewErrorLogEntryNotification();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @GlobalValue(symbol="AVPlayerItemFailedToPlayToEndTimeErrorKey", optional=true)
    protected static native NSString FailedToPlayToEndTimeErrorKey();
    
    @Method(selector = "initWithURL:")
    protected native @Pointer long init(NSURL URL);
    @Method(selector = "initWithAsset:")
    protected native @Pointer long init(com.bugvm.ios.AVFoundation.AVAsset asset);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "initWithAsset:automaticallyLoadedAssetKeys:")
    protected native @Pointer long init(com.bugvm.ios.AVFoundation.AVAsset asset, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> automaticallyLoadedAssetKeys);
    @Method(selector = "currentTime")
    public native @ByVal CMTime getCurrentTime();
    @Method(selector = "seekToTime:")
    public native void seekToTime(@ByVal CMTime time);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "seekToTime:completionHandler:")
    public native void seekToTime(@ByVal CMTime time, @Block VoidBooleanBlock completionHandler);
    @Method(selector = "seekToTime:toleranceBefore:toleranceAfter:")
    public native void seekToTime(@ByVal CMTime time, @ByVal CMTime toleranceBefore, @ByVal CMTime toleranceAfter);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "seekToTime:toleranceBefore:toleranceAfter:completionHandler:")
    public native void seekToTime(@ByVal CMTime time, @ByVal CMTime toleranceBefore, @ByVal CMTime toleranceAfter, @Block VoidBooleanBlock completionHandler);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "cancelPendingSeeks")
    public native void cancelPendingSeeks();
    @Method(selector = "currentDate")
    public native NSDate getCurrentDate();
    @Method(selector = "seekToDate:")
    public native boolean seekToDate(NSDate date);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "seekToDate:completionHandler:")
    public native boolean seekToDate(NSDate date, @Block VoidBooleanBlock completionHandler);
    @Method(selector = "stepByCount:")
    public native void stepByCount(@MachineSizedSInt long stepCount);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "selectMediaOption:inMediaSelectionGroup:")
    public native void selectMediaOption(com.bugvm.ios.AVFoundation.AVMediaSelectionOption mediaSelectionOption, com.bugvm.ios.AVFoundation.AVMediaSelectionGroup mediaSelectionGroup);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "selectMediaOptionAutomaticallyInMediaSelectionGroup:")
    public native void selectMediaOptionAutomatically(com.bugvm.ios.AVFoundation.AVMediaSelectionGroup mediaSelectionGroup);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "selectedMediaOptionInMediaSelectionGroup:")
    public native com.bugvm.ios.AVFoundation.AVMediaSelectionOption getSelectedMediaOption(com.bugvm.ios.AVFoundation.AVMediaSelectionGroup mediaSelectionGroup);
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Method(selector = "accessLog")
    public native com.bugvm.ios.AVFoundation.AVPlayerItemAccessLog getAccessLog();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Method(selector = "errorLog")
    public native com.bugvm.ios.AVFoundation.AVPlayerItemErrorLog getErrorLog();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "addOutput:")
    public native void addOutput(com.bugvm.ios.AVFoundation.AVPlayerItemOutput output);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "removeOutput:")
    public native void removeOutput(com.bugvm.ios.AVFoundation.AVPlayerItemOutput output);
    /*</methods>*/
}
