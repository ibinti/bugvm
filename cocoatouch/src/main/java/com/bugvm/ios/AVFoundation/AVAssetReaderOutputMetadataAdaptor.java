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
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetReaderOutputMetadataAdaptor/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetReaderOutputMetadataAdaptorPtr extends Ptr<AVAssetReaderOutputMetadataAdaptor, AVAssetReaderOutputMetadataAdaptorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetReaderOutputMetadataAdaptor.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetReaderOutputMetadataAdaptor() {}
    protected AVAssetReaderOutputMetadataAdaptor(SkipInit skipInit) { super(skipInit); }
    public AVAssetReaderOutputMetadataAdaptor(AVAssetReaderTrackOutput trackOutput) { super((SkipInit) null); initObject(init(trackOutput)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "assetReaderTrackOutput")
    public native AVAssetReaderTrackOutput getAssetReaderTrackOutput();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAssetReaderTrackOutput:")
    protected native @Pointer long init(AVAssetReaderTrackOutput trackOutput);
    @Method(selector = "nextTimedMetadataGroup")
    public native com.bugvm.ios.AVFoundation.AVTimedMetadataGroup nextTimedMetadataGroup();
    /*</methods>*/
}
