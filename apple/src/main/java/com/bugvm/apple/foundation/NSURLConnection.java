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
import com.bugvm.rt.annotation.WeaklyLinked;
import com.bugvm.apple.newsstandkit.NKAssetDownload;

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSURLConnection/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSURLConnectionPtr extends Ptr<NSURLConnection, NSURLConnectionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSURLConnection.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSURLConnection() {}
    protected NSURLConnection(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    public NSURLConnection(NSURLRequest request, NSURLConnectionDelegate delegate, boolean startImmediately) { super((SkipInit) null); initObject(init(request, delegate, startImmediately)); }
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    public NSURLConnection(NSURLRequest request, NSURLConnectionDelegate delegate) { super((SkipInit) null); initObject(init(request, delegate)); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "originalRequest")
    public native NSURLRequest getOriginalRequest();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "currentRequest")
    public native NSURLRequest getCurrentRequest();
    /*</properties>*/
    /*<members>*//*</members>*/
    public void scheduleInRunLoop(NSRunLoop aRunLoop, NSRunLoopMode mode) {
        scheduleInRunLoop(aRunLoop, mode.value().toString());
    }
    public void unscheduleFromRunLoop(NSRunLoop aRunLoop, NSRunLoopMode mode) {
        unscheduleFromRunLoop(aRunLoop, mode.value().toString());
    }

    /* NewsstandKit extensions */
    @WeaklyLinked
    public NKAssetDownload getNewsstandAssetDownload() {
        return com.bugvm.apple.newsstandkit.NSURLConnectionExtensions.getNewsstandAssetDownload(this);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "initWithRequest:delegate:startImmediately:")
    protected native @Pointer long init(NSURLRequest request, NSURLConnectionDelegate delegate, boolean startImmediately);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "initWithRequest:delegate:")
    protected native @Pointer long init(NSURLRequest request, NSURLConnectionDelegate delegate);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Method(selector = "start")
    public native void start();
    @Method(selector = "cancel")
    public native void cancel();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Method(selector = "scheduleInRunLoop:forMode:")
    public native void scheduleInRunLoop(NSRunLoop aRunLoop, String mode);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Method(selector = "unscheduleFromRunLoop:forMode:")
    public native void unscheduleFromRunLoop(NSRunLoop aRunLoop, String mode);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setDelegateQueue:")
    public native void setDelegateQueue(NSOperationQueue queue);
    @Method(selector = "canHandleRequest:")
    public static native boolean canHandleRequest(NSURLRequest request);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    public static NSData sendSynchronousRequest(NSURLRequest request, NSURLResponse.NSURLResponsePtr response) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       NSData result = sendSynchronousRequest(request, response, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "sendSynchronousRequest:returningResponse:error:")
    private static native NSData sendSynchronousRequest(NSURLRequest request, NSURLResponse.NSURLResponsePtr response, NSError.NSErrorPtr error);
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "sendAsynchronousRequest:queue:completionHandler:")
    public static native void sendAsynchronousRequest(NSURLRequest request, NSOperationQueue queue, @Block VoidBlock3<NSURLResponse, NSData, NSError> handler);
    /*</methods>*/
}
