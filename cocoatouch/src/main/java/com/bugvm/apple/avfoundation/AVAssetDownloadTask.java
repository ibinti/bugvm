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

import com.bugvm.apple.coremedia.CMTimeRange;
import com.bugvm.apple.foundation.NSURL;
import com.bugvm.apple.foundation.NSURLRequest;
import com.bugvm.apple.foundation.NSURLResponse;
import com.bugvm.apple.foundation.NSURLSessionTask;
import com.bugvm.objc.ObjCRuntime;
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
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetDownloadTask/*</name>*/ 
    extends /*<extends>*/NSURLSessionTask/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetDownloadTaskPtr extends Ptr<AVAssetDownloadTask, AVAssetDownloadTaskPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetDownloadTask.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetDownloadTask() {}
    protected AVAssetDownloadTask(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "URLAsset")
    public native AVURLAsset getURLAsset();
    @Property(selector = "destinationURL")
    public native NSURL getDestinationURL();
    @Property(selector = "options")
    public native AVAssetDownloadTaskOptions getOptions();
    @Property(selector = "loadedTimeRanges")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CMTimeRange.AsValuedListMarshaler.class) List<CMTimeRange> getLoadedTimeRanges();
    @Property(selector = "originalRequest")
    public native NSURLRequest getOriginalRequest();
    @Property(selector = "currentRequest")
    public native NSURLRequest getCurrentRequest();
    @Property(selector = "response")
    public native NSURLResponse getResponse();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
