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
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVPlayerItemVideoOutput/*</name>*/ 
    extends /*<extends>*/AVPlayerItemOutput/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVPlayerItemVideoOutputPtr extends Ptr<AVPlayerItemVideoOutput, AVPlayerItemVideoOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVPlayerItemVideoOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVPlayerItemVideoOutput() {}
    protected AVPlayerItemVideoOutput(SkipInit skipInit) { super(skipInit); }
    @WeaklyLinked
    public AVPlayerItemVideoOutput(CVPixelBufferAttributes pixelBufferAttributes) { super((SkipInit) null); initObject(init(pixelBufferAttributes)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native com.bugvm.ios.AVFoundation.AVPlayerItemOutputPullDelegate getDelegate();
    @WeaklyLinked
    @Property(selector = "delegateQueue")
    public native DispatchQueue getDelegateQueue();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "initWithPixelBufferAttributes:")
    protected native @Pointer long init(CVPixelBufferAttributes pixelBufferAttributes);
    @Method(selector = "hasNewPixelBufferForItemTime:")
    public native boolean hasNewPixelBufferForItemTime(@ByVal CMTime itemTime);
    @WeaklyLinked
    @Method(selector = "copyPixelBufferForItemTime:itemTimeForDisplay:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CVPixelBuffer getPixelBufferForItemTime(@ByVal CMTime itemTime, CMTime outItemTimeForDisplay);
    @WeaklyLinked
    @Method(selector = "setDelegate:queue:")
    public native void setDelegate(com.bugvm.ios.AVFoundation.AVPlayerItemOutputPullDelegate delegate, DispatchQueue delegateQueue);
    @Method(selector = "requestNotificationOfMediaDataChangeWithAdvanceInterval:")
    public native void requestNotificationOfMediaDataChange(double interval);
    /*</methods>*/
}
