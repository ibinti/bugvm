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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetTrack/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements AVAsynchronousKeyValueLoading/*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 9.0 and later.
         */
        public static NSObject observeTrackAssociationsDidChange(AVAssetTrack object, final VoidBlock1<AVAssetTrack> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(TrackAssociationsDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVAssetTrack) notification.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class AVAssetTrackPtr extends Ptr<AVAssetTrack, AVAssetTrackPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetTrack.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetTrack() {}
    protected AVAssetTrack(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "asset")
    public native com.bugvm.ios.AVFoundation.AVAsset getAsset();
    @Property(selector = "trackID")
    public native int getTrackID();
    @Property(selector = "mediaType")
    public native String getMediaType();
    @Property(selector = "formatDescriptions")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<CMFormatDescription> getFormatDescriptions();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isPlayable")
    public native boolean isPlayable();
    @Property(selector = "isEnabled")
    public native boolean isEnabled();
    @Property(selector = "isSelfContained")
    public native boolean isSelfContained();
    @Property(selector = "totalSampleDataLength")
    public native long getTotalSampleDataLength();
    @Property(selector = "timeRange")
    public native @ByVal CMTimeRange getTimeRange();
    @Property(selector = "naturalTimeScale")
    public native int getNaturalTimeScale();
    @Property(selector = "estimatedDataRate")
    public native float getEstimatedDataRate();
    @Property(selector = "languageCode")
    public native String getLanguageCode();
    @Property(selector = "extendedLanguageTag")
    public native String getExtendedLanguageTag();
    @Property(selector = "naturalSize")
    public native @ByVal CGSize getNaturalSize();
    @Property(selector = "preferredTransform")
    public native @ByVal CGAffineTransform getPreferredTransform();
    @Property(selector = "preferredVolume")
    public native float getPreferredVolume();
    @Property(selector = "nominalFrameRate")
    public native float getNominalFrameRate();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "minFrameDuration")
    public native @ByVal CMTime getMinFrameDuration();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "requiresFrameReordering")
    public native boolean requiresFrameReordering();
    @Property(selector = "segments")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetTrackSegment> getSegments();
    @Property(selector = "commonMetadata")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getCommonMetadata();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "metadata")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getMetadata();
    @Property(selector = "availableMetadataFormats")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVMetadataFormat.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVMetadataFormat> getAvailableMetadataFormats();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "availableTrackAssociationTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVTrackAssociationType.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVTrackAssociationType> getAvailableTrackAssociationTypes();
    /*</properties>*/
    /*<members>*//*</members>*/
    /**
     * 
     * @param key
     * @return
     * @throws NSErrorException
     */
    public com.bugvm.ios.AVFoundation.AVKeyValueStatus getStatusOfValue(com.bugvm.ios.AVFoundation.AVMetadataKey key) throws NSErrorException {
        NSError.NSErrorPtr err = new NSError.NSErrorPtr();
        com.bugvm.ios.AVFoundation.AVKeyValueStatus result = getStatusOfValue(key, err);
        if (err.get() != null) {
            throw new NSErrorException(err.get());
        }
        return result;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="AVAssetTrackTrackAssociationsDidChangeNotification", optional=true)
    public static native NSString TrackAssociationsDidChangeNotification();
    
    @Method(selector = "hasMediaCharacteristic:")
    public native boolean hasMediaCharacteristic(com.bugvm.ios.AVFoundation.AVMediaCharacteristic mediaCharacteristic);
    @Method(selector = "segmentForTrackTime:")
    public native com.bugvm.ios.AVFoundation.AVAssetTrackSegment getSegment(@ByVal CMTime trackTime);
    @Method(selector = "samplePresentationTimeForTrackTime:")
    public native @ByVal CMTime getSamplePresentationTime(@ByVal CMTime trackTime);
    @Method(selector = "metadataForFormat:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getMetadataForFormat(com.bugvm.ios.AVFoundation.AVMetadataFormat format);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "associatedTracksOfType:")
    public native NSArray<AVAssetTrack> getAssociatedTracksOfType(com.bugvm.ios.AVFoundation.AVTrackAssociationType trackAssociationType);
    @Method(selector = "statusOfValueForKey:error:")
    public native com.bugvm.ios.AVFoundation.AVKeyValueStatus getStatusOfValue(com.bugvm.ios.AVFoundation.AVMetadataKey key, NSError.NSErrorPtr outError);
    @Method(selector = "loadValuesAsynchronouslyForKeys:completionHandler:")
    public native void loadValuesAsynchronously(@com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVMetadataKey.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVMetadataKey> keys, @Block Runnable handler);
    /*</methods>*/
}
