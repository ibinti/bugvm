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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPMediaLibrary/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {
    
    public static class Notifications {
        public static NSObject observeDidChange(final Runnable block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(DidChangeNotification(), null, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke (NSNotification a) {
                    block.run();
                }
            });
        }
    }

    /*<ptr>*/public static class MPMediaLibraryPtr extends Ptr<MPMediaLibrary, MPMediaLibraryPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPMediaLibrary.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MPMediaLibrary() {}
    protected MPMediaLibrary(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "lastModifiedDate")
    public native NSDate getLastModifiedDate();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="MPMediaLibraryDidChangeNotification", optional=true)
    public static native NSString DidChangeNotification();
    
    @Method(selector = "beginGeneratingLibraryChangeNotifications")
    public native void beginGeneratingLibraryChangeNotifications();
    @Method(selector = "endGeneratingLibraryChangeNotifications")
    public native void endGeneratingLibraryChangeNotifications();
    @Method(selector = "defaultMediaLibrary")
    public static native MPMediaLibrary getDefaultMediaLibrary();
    /*</methods>*/

//    + (MPMediaLibraryAuthorizationStatus)authorizationStatus NS_AVAILABLE_IOS(9_3);
    @Method(selector = "authorizationStatus")
    public static native MPMediaLibraryAuthorizationStatus getAuthorizationStatus();

//+ (void)requestAuthorization:(void (^)(MPMediaLibraryAuthorizationStatus status))handler NS_AVAILABLE_IOS(9_3);
    @Method(selector = "requestAuthorization:")
    public static native void requestAuthorization(@Block VoidBlock1<MPMediaLibraryAuthorizationStatus> status);

}
