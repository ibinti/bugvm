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
package com.bugvm.apple.webkit;

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
import com.bugvm.apple.security.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/WKNavigationDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "webView:decidePolicyForNavigationAction:decisionHandler:")
    void decidePolicyForNavigationAction(WKWebView webView, WKNavigationAction navigationAction, @Block VoidBlock1<WKNavigationActionPolicy> decisionHandler);
    @Method(selector = "webView:decidePolicyForNavigationResponse:decisionHandler:")
    void decidePolicyForNavigationResponse(WKWebView webView, WKNavigationResponse navigationResponse, @Block VoidBlock1<WKNavigationResponsePolicy> decisionHandler);
    @Method(selector = "webView:didStartProvisionalNavigation:")
    void didStartProvisionalNavigation(WKWebView webView, WKNavigation navigation);
    @Method(selector = "webView:didReceiveServerRedirectForProvisionalNavigation:")
    void didReceiveServerRedirectForProvisionalNavigation(WKWebView webView, WKNavigation navigation);
    @Method(selector = "webView:didFailProvisionalNavigation:withError:")
    void didFailProvisionalNavigation(WKWebView webView, WKNavigation navigation, NSError error);
    @Method(selector = "webView:didCommitNavigation:")
    void didCommitNavigation(WKWebView webView, WKNavigation navigation);
    @Method(selector = "webView:didFinishNavigation:")
    void didFinishNavigation(WKWebView webView, WKNavigation navigation);
    @Method(selector = "webView:didFailNavigation:withError:")
    void didFailNavigation(WKWebView webView, WKNavigation navigation, NSError error);
    @Method(selector = "webView:didReceiveAuthenticationChallenge:completionHandler:")
    void didReceiveAuthenticationChallenge(WKWebView webView, NSURLAuthenticationChallenge challenge, @Block VoidBlock2<NSURLSessionAuthChallengeDisposition, NSURLCredential> completionHandler);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "webViewWebContentProcessDidTerminate:")
    void webContentProcessDidTerminate(WKWebView webView);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
