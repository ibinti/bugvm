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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAsset/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements AVAsynchronousKeyValueLoading/*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 9.0 and later.
         */
        public static NSObject observeDurationDidChange(AVAsset object, final VoidBlock1<AVAsset> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(DurationDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVAsset) notification.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 9.0 and later.
         */
        public static NSObject observeChapterMetadataGroupsDidChange(AVAsset object, final VoidBlock1<AVAsset> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(ChapterMetadataGroupsDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVAsset) notification.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 9.0 and later.
         */
        public static NSObject observeMediaSelectionGroupsDidChange(AVAsset object, final VoidBlock1<AVAsset> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(MediaSelectionGroupsDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVAsset) notification.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class AVAssetPtr extends Ptr<AVAsset, AVAssetPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAsset.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAsset() {}
    protected AVAsset(long handle) { super(handle); }
    protected AVAsset(SkipInit skipInit) { super(skipInit); }
    public AVAsset(NSURL URL) { super(create(URL)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "duration")
    public native @ByVal CMTime getDuration();
    @Property(selector = "preferredRate")
    public native float getPreferredRate();
    @Property(selector = "preferredVolume")
    public native float getPreferredVolume();
    @Property(selector = "preferredTransform")
    public native @ByVal CGAffineTransform getPreferredTransform();
    @Property(selector = "providesPreciseDurationAndTiming")
    public native boolean providesPreciseDurationAndTiming();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "referenceRestrictions")
    public native com.bugvm.ios.AVFoundation.AVAssetReferenceRestrictions getReferenceRestrictions();
    @Property(selector = "tracks")
    public native NSArray<? extends com.bugvm.ios.AVFoundation.AVAssetTrack> getTracks();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "trackGroups")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetTrackGroup> getTrackGroups();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "creationDate")
    public native com.bugvm.ios.AVFoundation.AVMetadataItem getCreationDate();
    @Property(selector = "lyrics")
    public native String getLyrics();
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
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "availableChapterLocales")
    public native NSArray<NSLocale> getAvailableChapterLocales();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "availableMediaCharacteristicsWithMediaSelectionOptions")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVMediaCharacteristic.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVMediaCharacteristic> getAvailableMediaCharacteristicsWithMediaSelectionOptions();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "preferredMediaSelection")
    public native com.bugvm.ios.AVFoundation.AVMediaSelection getPreferredMediaSelection();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "hasProtectedContent")
    public native boolean hasProtectedContent();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "canContainFragments")
    public native boolean canContainFragments();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "containsFragments")
    public native boolean containsFragments();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "isPlayable")
    public native boolean isPlayable();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "isExportable")
    public native boolean isExportable();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "isReadable")
    public native boolean isReadable();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Property(selector = "isComposable")
    public native boolean isComposable();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isCompatibleWithSavedPhotosAlbum")
    public native boolean isCompatibleWithSavedPhotosAlbum();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "isCompatibleWithAirPlayVideo")
    public native boolean isCompatibleWithAirPlayVideo();
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
    @GlobalValue(symbol="AVAssetDurationDidChangeNotification", optional=true)
    public static native NSString DurationDidChangeNotification();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="AVAssetChapterMetadataGroupsDidChangeNotification", optional=true)
    public static native NSString ChapterMetadataGroupsDidChangeNotification();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="AVAssetMediaSelectionGroupsDidChangeNotification", optional=true)
    public static native NSString MediaSelectionGroupsDidChangeNotification();
    
    @Method(selector = "assetWithURL:")
    protected static native @Pointer long create(NSURL URL);
    @Method(selector = "cancelLoading")
    public native void cancelLoading();
    @Method(selector = "trackWithTrackID:")
    public native com.bugvm.ios.AVFoundation.AVAssetTrack getTrack(int trackID);
    @Method(selector = "tracksWithMediaType:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetTrack> getTracksWithType(com.bugvm.ios.AVFoundation.AVMediaType mediaType);
    @Method(selector = "tracksWithMediaCharacteristic:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetTrack> getTracksWithCharacteristic(com.bugvm.ios.AVFoundation.AVMediaCharacteristic mediaCharacteristic);
    @Method(selector = "metadataForFormat:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVMetadataItem> getMetadata(com.bugvm.ios.AVFoundation.AVMetadataFormat format);
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Method(selector = "chapterMetadataGroupsWithTitleLocale:containingItemsWithCommonKeys:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVTimedMetadataGroup> getChapterMetadataGroupsContainingItemsWithCommonKeys(NSLocale locale, @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVMetadataKey.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVMetadataKey> commonKeys);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "chapterMetadataGroupsBestMatchingPreferredLanguages:")
    public native NSArray<com.bugvm.ios.AVFoundation.AVTimedMetadataGroup> getChapterMetadataGroupsBestMatchingPreferredLanguages(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> preferredLanguages);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "mediaSelectionGroupForMediaCharacteristic:")
    public native com.bugvm.ios.AVFoundation.AVMediaSelectionGroup getMediaSelectionGroup(com.bugvm.ios.AVFoundation.AVMediaCharacteristic mediaCharacteristic);
    @Method(selector = "unusedTrackID")
    public native int getUnusedTrackID();
    @Method(selector = "statusOfValueForKey:error:")
    public native com.bugvm.ios.AVFoundation.AVKeyValueStatus getStatusOfValue(com.bugvm.ios.AVFoundation.AVMetadataKey key, NSError.NSErrorPtr outError);
    @Method(selector = "loadValuesAsynchronouslyForKeys:completionHandler:")
    public native void loadValuesAsynchronously(@com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVMetadataKey.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVMetadataKey> keys, @Block Runnable handler);
    /*</methods>*/
}
