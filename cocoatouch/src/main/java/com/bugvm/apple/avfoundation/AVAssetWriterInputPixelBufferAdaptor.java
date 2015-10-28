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

import com.bugvm.apple.coremedia.CMTime;
import com.bugvm.apple.corevideo.CVPixelBuffer;
import com.bugvm.apple.corevideo.CVPixelBufferAttributes;
import com.bugvm.apple.corevideo.CVPixelBufferPool;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
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
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetWriterInputPixelBufferAdaptor/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetWriterInputPixelBufferAdaptorPtr extends Ptr<AVAssetWriterInputPixelBufferAdaptor, AVAssetWriterInputPixelBufferAdaptorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetWriterInputPixelBufferAdaptor.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetWriterInputPixelBufferAdaptor() {}
    protected AVAssetWriterInputPixelBufferAdaptor(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public AVAssetWriterInputPixelBufferAdaptor(AVAssetWriterInput input, CVPixelBufferAttributes sourcePixelBufferAttributes) { super((SkipInit) null); initObject(init(input, sourcePixelBufferAttributes)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "assetWriterInput")
    public native AVAssetWriterInput getAssetWriterInput();
    @WeaklyLinked
    @Property(selector = "sourcePixelBufferAttributes")
    public native CVPixelBufferAttributes getSourcePixelBufferAttributes();
    @WeaklyLinked
    @Property(selector = "pixelBufferPool")
    public native CVPixelBufferPool getPixelBufferPool();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "initWithAssetWriterInput:sourcePixelBufferAttributes:")
    protected native @Pointer long init(AVAssetWriterInput input, CVPixelBufferAttributes sourcePixelBufferAttributes);
    @WeaklyLinked
    @Method(selector = "appendPixelBuffer:withPresentationTime:")
    public native boolean appendPixelBuffer(CVPixelBuffer pixelBuffer, @ByVal CMTime presentationTime);
    /*</methods>*/
}
