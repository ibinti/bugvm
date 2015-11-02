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
package com.bugvm.apple.photos;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.avfoundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Photos") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHAssetResourceManager/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHAssetResourceManagerPtr extends Ptr<PHAssetResourceManager, PHAssetResourceManagerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHAssetResourceManager.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHAssetResourceManager() {}
    protected PHAssetResourceManager(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="PHInvalidAssetResourceDataRequestID", optional=true)
    public static native int getInvalidAssetResourceDataRequestID();
    
    @Method(selector = "requestDataForAssetResource:options:dataReceivedHandler:completionHandler:")
    public native int requestData(PHAssetResource resource, PHAssetResourceRequestOptions options, @Block VoidBlock1<NSData> handler, @Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "writeDataForAssetResource:toFile:options:completionHandler:")
    public native void writeData(PHAssetResource resource, NSURL fileURL, PHAssetResourceRequestOptions options, @Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "cancelDataRequest:")
    public native void cancelDataRequest(int requestID);
    @Method(selector = "defaultManager")
    public static native PHAssetResourceManager getDefaultManager();
    /*</methods>*/
}
