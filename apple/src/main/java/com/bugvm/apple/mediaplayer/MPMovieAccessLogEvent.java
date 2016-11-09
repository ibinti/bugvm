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
package com.bugvm.apple.mediaplayer;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.3 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPMovieAccessLogEvent/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPMovieAccessLogEventPtr extends Ptr<MPMovieAccessLogEvent, MPMovieAccessLogEventPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPMovieAccessLogEvent.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MPMovieAccessLogEvent() {}
    protected MPMovieAccessLogEvent(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "numberOfSegmentsDownloaded")
    public native @MachineSizedUInt long getNumberOfSegmentsDownloaded();
    @Property(selector = "playbackStartDate")
    public native NSDate getPlaybackStartDate();
    @Property(selector = "URI")
    public native String getURI();
    @Property(selector = "serverAddress")
    public native String getServerAddress();
    @Property(selector = "numberOfServerAddressChanges")
    public native @MachineSizedUInt long getNumberOfServerAddressChanges();
    @Property(selector = "playbackSessionID")
    public native String getPlaybackSessionID();
    @Property(selector = "playbackStartOffset")
    public native double getPlaybackStartOffset();
    @Property(selector = "segmentsDownloadedDuration")
    public native double getSegmentsDownloadedDuration();
    @Property(selector = "durationWatched")
    public native double getDurationWatched();
    @Property(selector = "numberOfStalls")
    public native @MachineSizedSInt long getNumberOfStalls();
    @Property(selector = "numberOfBytesTransferred")
    public native long getNumberOfBytesTransferred();
    @Property(selector = "observedBitrate")
    public native double getObservedBitrate();
    @Property(selector = "indicatedBitrate")
    public native double getIndicatedBitrate();
    @Property(selector = "numberOfDroppedVideoFrames")
    public native @MachineSizedSInt long getNumberOfDroppedVideoFrames();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
