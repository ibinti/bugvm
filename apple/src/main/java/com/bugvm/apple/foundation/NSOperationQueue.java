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
/**
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSOperationQueue/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSOperationQueuePtr extends Ptr<NSOperationQueue, NSOperationQueuePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSOperationQueue.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSOperationQueue() {}
    protected NSOperationQueue(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "operations")
    public native NSArray<NSOperation> getOperations();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "operationCount")
    public native @MachineSizedUInt long getOperationCount();
    @Property(selector = "maxConcurrentOperationCount")
    public native @MachineSizedSInt long getMaxConcurrentOperationCount();
    @Property(selector = "setMaxConcurrentOperationCount:")
    public native void setMaxConcurrentOperationCount(@MachineSizedSInt long v);
    @Property(selector = "isSuspended")
    public native boolean isSuspended();
    @Property(selector = "setSuspended:")
    public native void setSuspended(boolean v);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "name")
    public native String getName();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "setName:")
    public native void setName(String v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "qualityOfService")
    public native NSQualityOfService getQualityOfService();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setQualityOfService:")
    public native void setQualityOfService(NSQualityOfService v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @WeaklyLinked
    @Property(selector = "underlyingQueue")
    public native DispatchQueue getUnderlyingQueue();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @WeaklyLinked
    @Property(selector = "setUnderlyingQueue:")
    public native void setUnderlyingQueue(DispatchQueue v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="NSOperationQueueDefaultMaxConcurrentOperationCount", optional=true)
    public static native @MachineSizedSInt long getDefaultMaxConcurrentOperationCount();
    
    @Method(selector = "addOperation:")
    public native void addOperation(NSOperation op);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "addOperations:waitUntilFinished:")
    public native void addOperations(NSArray<NSOperation> ops, boolean wait);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "addOperationWithBlock:")
    public native void addOperation(@Block Runnable block);
    @Method(selector = "cancelAllOperations")
    public native void cancelAllOperations();
    @Method(selector = "waitUntilAllOperationsAreFinished")
    public native void waitUntilAllOperationsAreFinished();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "currentQueue")
    public static native NSOperationQueue getCurrentQueue();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "mainQueue")
    public static native NSOperationQueue getMainQueue();
    /*</methods>*/
}
