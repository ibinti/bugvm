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
/*<annotations>*/@Library("UIKit")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIActivityType/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(UIActivityType.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypePostToFacebook", optional=true)
    public static native String PostToFacebook();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypePostToTwitter", optional=true)
    public static native String PostToTwitter();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypePostToWeibo", optional=true)
    public static native String PostToWeibo();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeMessage", optional=true)
    public static native String Message();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeMail", optional=true)
    public static native String Mail();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypePrint", optional=true)
    public static native String Print();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeCopyToPasteboard", optional=true)
    public static native String CopyToPasteboard();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeAssignToContact", optional=true)
    public static native String AssignToContact();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeSaveToCameraRoll", optional=true)
    public static native String SaveToCameraRoll();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeAddToReadingList", optional=true)
    public static native String AddToReadingList();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypePostToFlickr", optional=true)
    public static native String PostToFlickr();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypePostToVimeo", optional=true)
    public static native String PostToVimeo();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypePostToTencentWeibo", optional=true)
    public static native String PostToTencentWeibo();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeAirDrop", optional=true)
    public static native String AirDrop();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="UIActivityTypeOpenInIBooks", optional=true)
    public static native String OpenInIBooks();
    /*</methods>*/
}
