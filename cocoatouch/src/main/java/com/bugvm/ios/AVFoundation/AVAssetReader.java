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
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetReader/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetReaderPtr extends Ptr<AVAssetReader, AVAssetReaderPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetReader.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetReader() {}
    protected AVAssetReader(SkipInit skipInit) { super(skipInit); }
    public AVAssetReader(com.bugvm.ios.AVFoundation.AVAsset asset) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(asset, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "asset")
    public native com.bugvm.ios.AVFoundation.AVAsset getAsset();
    @Property(selector = "status")
    public native AVAssetReaderStatus getStatus();
    @Property(selector = "error")
    public native NSError getError();
    @Property(selector = "timeRange")
    public native @ByVal CMTimeRange getTimeRange();
    @Property(selector = "setTimeRange:")
    public native void setTimeRange(@ByVal CMTimeRange v);
    @Property(selector = "outputs")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAssetReaderOutput> getOutputs();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAsset:error:")
    private native @Pointer long init(com.bugvm.ios.AVFoundation.AVAsset asset, NSError.NSErrorPtr outError);
    @Method(selector = "canAddOutput:")
    public native boolean canAddOutput(com.bugvm.ios.AVFoundation.AVAssetReaderOutput output);
    @Method(selector = "addOutput:")
    public native void addOutput(com.bugvm.ios.AVFoundation.AVAssetReaderOutput output);
    @Method(selector = "startReading")
    public native boolean startReading();
    @Method(selector = "cancelReading")
    public native void cancelReading();
    /*</methods>*/
}
