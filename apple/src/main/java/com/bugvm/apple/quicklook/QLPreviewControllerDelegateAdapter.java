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
package com.bugvm.apple.quicklook;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/QLPreviewControllerDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements QLPreviewControllerDelegate/*</implements>*/ {

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
    @NotImplemented("previewControllerWillDismiss:")
    public void willDismiss(QLPreviewController controller) {}
    @NotImplemented("previewControllerDidDismiss:")
    public void didDismiss(QLPreviewController controller) {}
    @NotImplemented("previewController:shouldOpenURL:forPreviewItem:")
    public boolean shouldOpenURL(QLPreviewController controller, NSURL url, QLPreviewItem item) { return false; }
    @NotImplemented("previewController:frameForPreviewItem:inSourceView:")
    public @ByVal CGRect getFrame(QLPreviewController controller, QLPreviewItem item, UIView.UIViewPtr view) { return null; }
    @NotImplemented("previewController:transitionImageForPreviewItem:contentRect:")
    public UIImage getTransitionImage(QLPreviewController controller, QLPreviewItem item, @ByVal CGRect contentRect) { return null; }
    /*</methods>*/
}
