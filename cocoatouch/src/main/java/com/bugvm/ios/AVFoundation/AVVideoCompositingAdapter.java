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

import com.bugvm.objc.annotation.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corevideo.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVVideoCompositingAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements AVVideoCompositing/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    @WeaklyLinked
    @NotImplemented("sourcePixelBufferAttributes")
    public CVPixelBufferAttributes getSourcePixelBufferAttributes() { return null; }
    @WeaklyLinked
    @NotImplemented("requiredPixelBufferAttributesForRenderContext")
    public CVPixelBufferAttributes getRequiredPixelBufferAttributesForRenderContext() { return null; }
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @NotImplemented("renderContextChanged:")
    public void renderContextChanged(com.bugvm.ios.AVFoundation.AVVideoCompositionRenderContext newRenderContext) {}
    @NotImplemented("startVideoCompositionRequest:")
    public void startVideoCompositionRequest(com.bugvm.ios.AVFoundation.AVAsynchronousVideoCompositionRequest asyncVideoCompositionRequest) {}
    @NotImplemented("cancelAllPendingVideoCompositionRequests")
    public void cancelAllPendingVideoCompositionRequests() {}
    /*</methods>*/
}
