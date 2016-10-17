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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSURLCredentialStorage/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        public static NSObject observeChanged(NSURLCredentialStorage object, final VoidBlock1<NSURLCredentialStorage> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(ChangedNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification a) {
                    block.invoke((NSURLCredentialStorage)a.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class NSURLCredentialStoragePtr extends Ptr<NSURLCredentialStorage, NSURLCredentialStoragePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSURLCredentialStorage.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSURLCredentialStorage() {}
    protected NSURLCredentialStorage(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "allCredentials")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringMapMarshaler.class) Map<String, NSURLCredential> getAllCredentials();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="NSURLCredentialStorageChangedNotification", optional=true)
    public static native NSString ChangedNotification();
    
    @Method(selector = "credentialsForProtectionSpace:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringMapMarshaler.class) Map<String, NSURLCredential> getCredentials(NSURLProtectionSpace space);
    @Method(selector = "setCredential:forProtectionSpace:")
    public native void setCredential(NSURLCredential credential, NSURLProtectionSpace space);
    @Method(selector = "removeCredential:forProtectionSpace:")
    public native void removeCredential(NSURLCredential credential, NSURLProtectionSpace space);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "removeCredential:forProtectionSpace:options:")
    public native void removeCredential(NSURLCredential credential, NSURLProtectionSpace space, NSURLCredentialStorageRemovalOptions options);
    @Method(selector = "defaultCredentialForProtectionSpace:")
    public native NSURLCredential getDefaultCredential(NSURLProtectionSpace space);
    @Method(selector = "setDefaultCredential:forProtectionSpace:")
    public native void setDefaultCredential(NSURLCredential credential, NSURLProtectionSpace space);
    @Method(selector = "sharedCredentialStorage")
    public static native NSURLCredentialStorage getSharedCredentialStorage();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "getCredentialsForProtectionSpace:task:completionHandler:")
    public native void getCredentials(NSURLProtectionSpace protectionSpace, NSURLSessionTask task, @Block VoidBlock1<NSDictionary<NSString, NSURLCredential>> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setCredential:forProtectionSpace:task:")
    public native void setCredential(NSURLCredential credential, NSURLProtectionSpace protectionSpace, NSURLSessionTask task);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "removeCredential:forProtectionSpace:options:task:")
    public native void removeCredential(NSURLCredential credential, NSURLProtectionSpace protectionSpace, NSURLCredentialStorageRemovalOptions options, NSURLSessionTask task);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "getDefaultCredentialForProtectionSpace:task:completionHandler:")
    public native void getDefaultCredential(NSURLProtectionSpace space, NSURLSessionTask task, @Block VoidBlock1<NSURLCredential> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setDefaultCredential:forProtectionSpace:task:")
    public native void setDefaultCredential(NSURLCredential credential, NSURLProtectionSpace protectionSpace, NSURLSessionTask task);
    /*</methods>*/
}
