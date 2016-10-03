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
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVPlayerItemLegibleOutput/*</name>*/ 
    extends /*<extends>*/AVPlayerItemOutput/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVPlayerItemLegibleOutputPtr extends Ptr<AVPlayerItemLegibleOutput, AVPlayerItemLegibleOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVPlayerItemLegibleOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVPlayerItemLegibleOutput() {}
    protected AVPlayerItemLegibleOutput(SkipInit skipInit) { super(skipInit); }
    public AVPlayerItemLegibleOutput(NSArray<NSNumber> subtypes) { super((SkipInit) null); initObject(init(subtypes)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native com.bugvm.ios.AVFoundation.AVPlayerItemLegibleOutputPushDelegate getDelegate();
    @WeaklyLinked
    @Property(selector = "delegateQueue")
    public native DispatchQueue getDelegateQueue();
    @Property(selector = "advanceIntervalForDelegateInvocation")
    public native double getAdvanceIntervalForDelegateInvocation();
    @Property(selector = "setAdvanceIntervalForDelegateInvocation:")
    public native void setAdvanceIntervalForDelegateInvocation(double v);
    @Property(selector = "textStylingResolution")
    public native com.bugvm.ios.AVFoundation.AVPlayerItemLegibleOutputTextStylingResolution getTextStylingResolution();
    @Property(selector = "setTextStylingResolution:")
    public native void setTextStylingResolution(com.bugvm.ios.AVFoundation.AVPlayerItemLegibleOutputTextStylingResolution v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "setDelegate:queue:")
    public native void setDelegate(com.bugvm.ios.AVFoundation.AVPlayerItemLegibleOutputPushDelegate delegate, DispatchQueue delegateQueue);
    @Method(selector = "initWithMediaSubtypesForNativeRepresentation:")
    protected native @Pointer long init(NSArray<NSNumber> subtypes);
    /*</methods>*/
}
