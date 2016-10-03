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
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVVideoCompositionValidationHandlingAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements AVVideoCompositionValidationHandling/*</implements>*/ {

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
     * @since Available in iOS 5.0 and later.
     */
    @NotImplemented("videoComposition:shouldContinueValidatingAfterFindingInvalidValueForKey:")
    public boolean shouldContinueValidatingAfterFindingInvalidValue(com.bugvm.ios.AVFoundation.AVVideoComposition videoComposition, String key) { return false; }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @NotImplemented("videoComposition:shouldContinueValidatingAfterFindingEmptyTimeRange:")
    public boolean shouldContinueValidatingAfterFindingEmptyTimeRange(com.bugvm.ios.AVFoundation.AVVideoComposition videoComposition, @ByVal CMTimeRange timeRange) { return false; }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @NotImplemented("videoComposition:shouldContinueValidatingAfterFindingInvalidTimeRangeInInstruction:")
    public boolean shouldContinueValidatingAfterFindingInvalidTimeRange(com.bugvm.ios.AVFoundation.AVVideoComposition videoComposition, com.bugvm.ios.AVFoundation.AVVideoCompositionInstruction videoCompositionInstruction) { return false; }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @NotImplemented("videoComposition:shouldContinueValidatingAfterFindingInvalidTrackIDInInstruction:layerInstruction:asset:")
    public boolean shouldContinueValidatingAfterFindingInvalidTrackID(com.bugvm.ios.AVFoundation.AVVideoComposition videoComposition, com.bugvm.ios.AVFoundation.AVVideoCompositionInstruction videoCompositionInstruction, com.bugvm.ios.AVFoundation.AVVideoCompositionLayerInstruction layerInstruction, com.bugvm.ios.AVFoundation.AVAsset asset) { return false; }
    /*</methods>*/
}
