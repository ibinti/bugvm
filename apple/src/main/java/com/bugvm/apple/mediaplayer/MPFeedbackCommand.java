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
 * @since Available in iOS 7.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPFeedbackCommand/*</name>*/ 
    extends /*<extends>*/MPRemoteCommand/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPFeedbackCommandPtr extends Ptr<MPFeedbackCommand, MPFeedbackCommandPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPFeedbackCommand.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MPFeedbackCommand() {}
    protected MPFeedbackCommand(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isActive")
    public native boolean isActive();
    @Property(selector = "setActive:")
    public native void setActive(boolean v);
    @Property(selector = "localizedTitle")
    public native String getLocalizedTitle();
    @Property(selector = "setLocalizedTitle:")
    public native void setLocalizedTitle(String v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "localizedShortTitle")
    public native String getLocalizedShortTitle();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setLocalizedShortTitle:")
    public native void setLocalizedShortTitle(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
