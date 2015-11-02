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
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKTurnBasedEventListenerAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements GKTurnBasedEventListener/*</implements>*/ {

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
    /**
     * @since Available in iOS 8.0 and later.
     */
    @NotImplemented("player:didRequestMatchWithOtherPlayers:")
    public void didRequestMatch(GKPlayer player, NSArray<GKPlayer> playersToInvite) {}
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("player:receivedTurnEventForMatch:didBecomeActive:")
    public void receivedTurnEvent(GKPlayer player, GKTurnBasedMatch match, boolean didBecomeActive) {}
    @NotImplemented("player:matchEnded:")
    public void matchEnded(GKPlayer player, GKTurnBasedMatch match) {}
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("player:receivedExchangeRequest:forMatch:")
    public void receivedExchangeRequest(GKPlayer player, GKTurnBasedExchange exchange, GKTurnBasedMatch match) {}
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("player:receivedExchangeCancellation:forMatch:")
    public void receivedExchangeCancellation(GKPlayer player, GKTurnBasedExchange exchange, GKTurnBasedMatch match) {}
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("player:receivedExchangeReplies:forCompletedExchange:forMatch:")
    public void receivedExchangeReplies(GKPlayer player, NSArray<GKTurnBasedExchange> replies, GKTurnBasedExchange exchange, GKTurnBasedMatch match) {}
    /**
     * @since Available in iOS 9.0 and later.
     */
    @NotImplemented("player:wantsToQuitMatch:")
    public void wantsToQuitMatch(GKPlayer player, GKTurnBasedMatch match) {}
    /**
     * @since Available in iOS 7.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @NotImplemented("player:didRequestMatchWithPlayers:")
    public void didRequestMatch(GKPlayer player, @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> playerIDsToInvite) {}
    /*</methods>*/
}
