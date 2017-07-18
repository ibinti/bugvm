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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIDocumentInteractionControllerDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements UIDocumentInteractionControllerDelegate/*</implements>*/ {

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
    @NotImplemented("documentInteractionControllerViewControllerForPreview:")
    public UIViewController getViewControllerForPreview(UIDocumentInteractionController controller) { return null; }
    @NotImplemented("documentInteractionControllerRectForPreview:")
    public @ByVal CGRect getRectForPreview(UIDocumentInteractionController controller) { return null; }
    @NotImplemented("documentInteractionControllerViewForPreview:")
    public UIView getViewForPreview(UIDocumentInteractionController controller) { return null; }
    @NotImplemented("documentInteractionControllerWillBeginPreview:")
    public void willBeginPreview(UIDocumentInteractionController controller) {}
    @NotImplemented("documentInteractionControllerDidEndPreview:")
    public void didEndPreview(UIDocumentInteractionController controller) {}
    @NotImplemented("documentInteractionControllerWillPresentOptionsMenu:")
    public void willPresentOptionsMenu(UIDocumentInteractionController controller) {}
    @NotImplemented("documentInteractionControllerDidDismissOptionsMenu:")
    public void didDismissOptionsMenu(UIDocumentInteractionController controller) {}
    @NotImplemented("documentInteractionControllerWillPresentOpenInMenu:")
    public void willPresentOpenInMenu(UIDocumentInteractionController controller) {}
    @NotImplemented("documentInteractionControllerDidDismissOpenInMenu:")
    public void didDismissOpenInMenu(UIDocumentInteractionController controller) {}
    @NotImplemented("documentInteractionController:willBeginSendingToApplication:")
    public void willBeginSendingToApplication(UIDocumentInteractionController controller, String application) {}
    @NotImplemented("documentInteractionController:didEndSendingToApplication:")
    public void didEndSendingToApplication(UIDocumentInteractionController controller, String application) {}
    /*</methods>*/
}
