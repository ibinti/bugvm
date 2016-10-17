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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Photos") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/PHPhotoLibrary/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class PHPhotoLibraryPtr extends Ptr<PHPhotoLibrary, PHPhotoLibraryPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(PHPhotoLibrary.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public PHPhotoLibrary() {}
    protected PHPhotoLibrary(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "performChanges:completionHandler:")
    public native void performChanges(@Block Runnable changeBlock, @Block VoidBlock2<Boolean, NSError> completionHandler);
    public boolean performChangesAndWait(@Block Runnable changeBlock) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = performChangesAndWait(changeBlock, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "performChangesAndWait:error:")
    private native boolean performChangesAndWait(@Block Runnable changeBlock, NSError.NSErrorPtr error);
    @Method(selector = "registerChangeObserver:")
    public native void registerChangeObserver(PHPhotoLibraryChangeObserver observer);
    @Method(selector = "unregisterChangeObserver:")
    public native void unregisterChangeObserver(PHPhotoLibraryChangeObserver observer);
    @Method(selector = "sharedPhotoLibrary")
    public static native PHPhotoLibrary getSharedPhotoLibrary();
    @Method(selector = "authorizationStatus")
    public static native PHAuthorizationStatus getAuthorizationStatus();
    @Method(selector = "requestAuthorization:")
    public static native void requestAuthorization(@Block VoidBlock1<PHAuthorizationStatus> handler);
    /*</methods>*/
}
