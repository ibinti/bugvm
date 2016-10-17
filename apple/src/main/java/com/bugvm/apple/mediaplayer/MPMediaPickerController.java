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
package com.bugvm.apple.mediaplayer;

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
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPMediaPickerController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPMediaPickerControllerPtr extends Ptr<MPMediaPickerController, MPMediaPickerControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPMediaPickerController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected MPMediaPickerController(SkipInit skipInit) { super(skipInit); }
    public MPMediaPickerController(MPMediaType mediaTypes) { super((SkipInit) null); initObject(init(mediaTypes)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "mediaTypes")
    public native MPMediaType getMediaTypes();
    @Property(selector = "delegate")
    public native MPMediaPickerControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(MPMediaPickerControllerDelegate v);
    @Property(selector = "allowsPickingMultipleItems")
    public native boolean allowsPickingMultipleItems();
    @Property(selector = "setAllowsPickingMultipleItems:")
    public native void setAllowsPickingMultipleItems(boolean v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "showsCloudItems")
    public native boolean showsCloudItems();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setShowsCloudItems:")
    public native void setShowsCloudItems(boolean v);
    @Property(selector = "prompt")
    public native String getPrompt();
    @Property(selector = "setPrompt:")
    public native void setPrompt(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithMediaTypes:")
    protected native @Pointer long init(MPMediaType mediaTypes);
    /*</methods>*/
}
