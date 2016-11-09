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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSFileProviderExtension/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSFileProviderExtensionPtr extends Ptr<NSFileProviderExtension, NSFileProviderExtensionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSFileProviderExtension.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSFileProviderExtension() {}
    protected NSFileProviderExtension(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "providerIdentifier")
    public native String getProviderIdentifier();
    @Method(selector = "documentStorageURL")
    public native NSURL getDocumentStorageURL();
    @Method(selector = "URLForItemWithPersistentIdentifier:")
    public native NSURL getURLForItem(String identifier);
    @Method(selector = "persistentIdentifierForItemAtURL:")
    public native String getPersistentIdentifierForItem(NSURL url);
    @Method(selector = "providePlaceholderAtURL:completionHandler:")
    public native void providePlaceholder(NSURL url, @Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "startProvidingItemAtURL:completionHandler:")
    public native void startProvidingItem(NSURL url, @Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "itemChangedAtURL:")
    public native void itemChanged(NSURL url);
    @Method(selector = "stopProvidingItemAtURL:")
    public native void stopProvidingItem(NSURL url);
    public static boolean writePlaceholder(NSURL placeholderURL, NSURLProperties metadata) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = writePlaceholder(placeholderURL, metadata, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "writePlaceholderAtURL:withMetadata:error:")
    private static native boolean writePlaceholder(NSURL placeholderURL, NSURLProperties metadata, NSError.NSErrorPtr error);
    @Method(selector = "placeholderURLForURL:")
    public static native NSURL getPlaceholderURL(NSURL url);
    /*</methods>*/
}
