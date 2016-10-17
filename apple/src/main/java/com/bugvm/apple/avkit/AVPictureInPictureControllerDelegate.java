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
package com.bugvm.apple.avkit;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.avfoundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.iad.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/AVPictureInPictureControllerDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "pictureInPictureControllerWillStartPictureInPicture:")
    void willStartPictureInPicture(AVPictureInPictureController pictureInPictureController);
    @Method(selector = "pictureInPictureControllerDidStartPictureInPicture:")
    void didStartPictureInPicture(AVPictureInPictureController pictureInPictureController);
    @Method(selector = "pictureInPictureController:failedToStartPictureInPictureWithError:")
    void failedToStartPictureInPicture(AVPictureInPictureController pictureInPictureController, NSError error);
    @Method(selector = "pictureInPictureControllerWillStopPictureInPicture:")
    void willStopPictureInPicture(AVPictureInPictureController pictureInPictureController);
    @Method(selector = "pictureInPictureControllerDidStopPictureInPicture:")
    void didStopPictureInPicture(AVPictureInPictureController pictureInPictureController);
    @Method(selector = "pictureInPictureController:restoreUserInterfaceForPictureInPictureStopWithCompletionHandler:")
    void restoreUserInterfaceForPictureInPictureStop(AVPictureInPictureController pictureInPictureController, @Block VoidBooleanBlock completionHandler);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
