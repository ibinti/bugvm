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
package com.bugvm.ios.iAd;

/*<imports>*/

import com.bugvm.objc.annotation.*;
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ADInterstitialAdDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements ADInterstitialAdDelegate/*</implements>*/ {

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
    @NotImplemented("interstitialAdDidUnload:")
    public void didUnload(com.bugvm.ios.iAd.ADInterstitialAd interstitialAd) {}
    @NotImplemented("interstitialAd:didFailWithError:")
    public void didFail(com.bugvm.ios.iAd.ADInterstitialAd interstitialAd, NSError error) {}
    /**
     * @since Available in iOS 5.0 and later.
     */
    @NotImplemented("interstitialAdWillLoad:")
    public void willLoad(com.bugvm.ios.iAd.ADInterstitialAd interstitialAd) {}
    @NotImplemented("interstitialAdDidLoad:")
    public void didLoad(com.bugvm.ios.iAd.ADInterstitialAd interstitialAd) {}
    @NotImplemented("interstitialAdActionShouldBegin:willLeaveApplication:")
    public boolean actionShouldBegin(com.bugvm.ios.iAd.ADInterstitialAd interstitialAd, boolean willLeave) { return false; }
    @NotImplemented("interstitialAdActionDidFinish:")
    public void actionDidFinish(com.bugvm.ios.iAd.ADInterstitialAd interstitialAd) {}
    /*</methods>*/
}
