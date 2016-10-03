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
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureVideoDataOutputSampleBufferDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements AVCaptureVideoDataOutputSampleBufferDelegate/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @NotImplemented("captureOutput:didOutputSampleBuffer:fromConnection:")
    public void didOutputSampleBuffer(com.bugvm.ios.AVFoundation.AVCaptureOutput captureOutput, CMSampleBuffer sampleBuffer, com.bugvm.ios.AVFoundation.AVCaptureConnection connection) {}
    /**
     * @since Available in iOS 6.0 and later.
     */
    @NotImplemented("captureOutput:didDropSampleBuffer:fromConnection:")
    public void didDropSampleBuffer(com.bugvm.ios.AVFoundation.AVCaptureOutput captureOutput, CMSampleBuffer sampleBuffer, com.bugvm.ios.AVFoundation.AVCaptureConnection connection) {}
    /*</methods>*/
}
