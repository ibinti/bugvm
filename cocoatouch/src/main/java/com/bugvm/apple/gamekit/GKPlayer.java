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
package com.bugvm.apple.gamekit;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("GameKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKPlayer/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {
    
    public static class Notifications {
        public static NSObject observeDidChange(GKPlayer object, final VoidBlock1<GKPlayer> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(DidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((GKPlayer) a.getObject());
                }
            });
        }
    }
    /*<ptr>*/public static class GKPlayerPtr extends Ptr<GKPlayer, GKPlayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKPlayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKPlayer() {}
    protected GKPlayer(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "playerID")
    public native String getPlayerID();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "displayName")
    public native String getDisplayName();
    @Property(selector = "alias")
    public native String getAlias();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "guestIdentifier")
    public native String getGuestIdentifier();
    /**
     * @since Available in iOS 4.1 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Property(selector = "isFriend")
    public native boolean isFriend();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="GKPlayerDidChangeNotificationName", optional=true)
    public static native NSString DidChangeNotification();
    
    @Method(selector = "loadPlayersForIdentifiers:withCompletionHandler:")
    public static native void loadPlayers(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> identifiers, @Block VoidBlock2<NSArray<GKPlayer>, NSError> completionHandler);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "anonymousGuestPlayerWithIdentifier:")
    public static native GKPlayer getAnonymousGuestPlayer(String guestIdentifier);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "loadPhotoForSize:withCompletionHandler:")
    public native void loadPhoto(GKPhotoSize size, @Block VoidBlock2<UIImage, NSError> completionHandler);
    /*</methods>*/
}
