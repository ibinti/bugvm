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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHAssetResourceRequestOptions/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHAssetResourceRequestOptionsPtr extends Ptr<PHAssetResourceRequestOptions, PHAssetResourceRequestOptionsPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHAssetResourceRequestOptions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHAssetResourceRequestOptions() {}
    protected PHAssetResourceRequestOptions(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isNetworkAccessAllowed")
    public native boolean isNetworkAccessAllowed();
    @Property(selector = "setNetworkAccessAllowed:")
    public native void setNetworkAccessAllowed(boolean v);
    @Property(selector = "progressHandler")
    public native VoidBlock1<Double> getProgressHandler();
    @Property(selector = "setProgressHandler:")
    public native void setProgressHandler(VoidBlock1<Double> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
