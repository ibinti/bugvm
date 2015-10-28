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

import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Block;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.block.VoidBlock1;
import com.bugvm.objc.block.VoidBlock3;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSURLSessionStreamTask/*</name>*/ 
    extends /*<extends>*/NSURLSessionTask/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSURLSessionStreamTaskPtr extends Ptr<NSURLSessionStreamTask, NSURLSessionStreamTaskPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSURLSessionStreamTask.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSURLSessionStreamTask() {}
    protected NSURLSessionStreamTask(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "readDataOfMinLength:maxLength:timeout:completionHandler:")
    public native void readData(@MachineSizedUInt long minBytes, @MachineSizedUInt long maxBytes, double timeout, @Block VoidBlock3<NSData, Boolean, NSError> completionHandler);
    @Method(selector = "writeData:timeout:completionHandler:")
    public native void writeData(NSData data, double timeout, @Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "captureStreams")
    public native void captureStreams();
    @Method(selector = "closeWrite")
    public native void closeWrite();
    @Method(selector = "closeRead")
    public native void closeRead();
    @Method(selector = "startSecureConnection")
    public native void startSecureConnection();
    @Method(selector = "stopSecureConnection")
    public native void stopSecureConnection();
    /*</methods>*/
}
