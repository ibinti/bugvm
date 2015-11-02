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
package com.bugvm.apple.iad;

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
import com.bugvm.apple.mediaplayer.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.avkit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 7.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("iAd") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ADClient/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class ADClientPtr extends Ptr<ADClient, ADClientPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(ADClient.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected ADClient(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 7.1 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "determineAppInstallationAttributionWithCompletionHandler:")
    public native void determineAppInstallationAttribution(@Block VoidBooleanBlock completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "lookupAdConversionDetails:")
    public native void lookupAdConversionDetails(@Block VoidBlock2<NSDate, NSDate> completionHandler);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "requestAttributionDetailsWithBlock:")
    public native void requestAttributionDetails(@Block VoidBlock2<NSDictionary<?, ?>, NSError> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "addClientToSegments:replaceExisting:")
    public native void addClientToSegments(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> segmentIdentifiers, boolean replaceExisting);
    /**
     * @since Available in iOS 7.1 and later.
     */
    @Method(selector = "sharedClient")
    public static native ADClient getSharedClient();
    /*</methods>*/
}
