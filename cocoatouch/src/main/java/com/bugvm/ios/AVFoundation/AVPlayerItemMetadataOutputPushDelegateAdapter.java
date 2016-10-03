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
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVPlayerItemMetadataOutputPushDelegateAdapter/*</name>*/ 
    extends /*<extends>*/AVPlayerItemOutputPushDelegateAdapter/*</extends>*/
    /*<implements>*/implements com.bugvm.ios.AVFoundation.AVPlayerItemMetadataOutputPushDelegate/*</implements>*/ {

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
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("metadataOutput:didOutputTimedMetadataGroups:fromPlayerItemTrack:")
    public void didOutputTimedMetadataGroups(com.bugvm.ios.AVFoundation.AVPlayerItemMetadataOutput output, NSArray<com.bugvm.ios.AVFoundation.AVTimedMetadataGroup> groups, com.bugvm.ios.AVFoundation.AVPlayerItemTrack track) {}
    /*</methods>*/
}
