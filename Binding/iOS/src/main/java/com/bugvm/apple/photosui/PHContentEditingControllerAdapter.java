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
package com.bugvm.apple.photosui;

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
import com.bugvm.apple.photos.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHContentEditingControllerAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements PHContentEditingController/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    @NotImplemented("shouldShowCancelConfirmation")
    public boolean shouldShowCancelConfirmation() { return false; }
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @NotImplemented("canHandleAdjustmentData:")
    public boolean canHandleAdjustmentData(PHAdjustmentData adjustmentData) { return false; }
    @NotImplemented("startContentEditingWithInput:placeholderImage:")
    public void startContentEditing(PHContentEditingInput contentEditingInput, UIImage placeholderImage) {}
    @NotImplemented("finishContentEditingWithCompletionHandler:")
    public void finishContentEditing(@Block VoidBlock1<PHContentEditingOutput> completionHandler) {}
    @NotImplemented("cancelContentEditing")
    public void cancelContentEditing() {}
    /*</methods>*/
}
