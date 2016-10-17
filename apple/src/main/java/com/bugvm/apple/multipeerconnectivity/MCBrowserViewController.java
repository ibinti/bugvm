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
package com.bugvm.apple.multipeerconnectivity;

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
import com.bugvm.apple.security.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MultipeerConnectivity") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MCBrowserViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*/implements MCNearbyServiceBrowserDelegate/*</implements>*/ {

    /*<ptr>*/public static class MCBrowserViewControllerPtr extends Ptr<MCBrowserViewController, MCBrowserViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MCBrowserViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MCBrowserViewController() {}
    protected MCBrowserViewController(SkipInit skipInit) { super(skipInit); }
    public MCBrowserViewController(String serviceType, MCSession session) { super((SkipInit) null); initObject(init(serviceType, session)); }
    public MCBrowserViewController(MCNearbyServiceBrowser browser, MCSession session) { super((SkipInit) null); initObject(init(browser, session)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native MCBrowserViewControllerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(MCBrowserViewControllerDelegate v);
    @Property(selector = "browser")
    public native MCNearbyServiceBrowser getBrowser();
    @Property(selector = "session")
    public native MCSession getSession();
    @Property(selector = "minimumNumberOfPeers")
    public native @MachineSizedUInt long getMinimumNumberOfPeers();
    @Property(selector = "setMinimumNumberOfPeers:")
    public native void setMinimumNumberOfPeers(@MachineSizedUInt long v);
    @Property(selector = "maximumNumberOfPeers")
    public native @MachineSizedUInt long getMaximumNumberOfPeers();
    @Property(selector = "setMaximumNumberOfPeers:")
    public native void setMaximumNumberOfPeers(@MachineSizedUInt long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithServiceType:session:")
    protected native @Pointer long init(String serviceType, MCSession session);
    @Method(selector = "initWithBrowser:session:")
    protected native @Pointer long init(MCNearbyServiceBrowser browser, MCSession session);
    @Method(selector = "browser:foundPeer:withDiscoveryInfo:")
    public native void foundPeer(MCNearbyServiceBrowser browser, MCPeerID peerID, @com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringStringMapMarshaler.class) Map<String, String> info);
    @Method(selector = "browser:lostPeer:")
    public native void lostPeer(MCNearbyServiceBrowser browser, MCPeerID peerID);
    @Method(selector = "browser:didNotStartBrowsingForPeers:")
    public native void didNotStartBrowsing(MCNearbyServiceBrowser browser, NSError error);
    /*</methods>*/
}
