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
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIManagedDocument/*</name>*/ 
    extends /*<extends>*/UIDocument/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIManagedDocumentPtr extends Ptr<UIManagedDocument, UIManagedDocumentPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIManagedDocument.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIManagedDocument() {}
    protected UIManagedDocument(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @WeaklyLinked
    @Property(selector = "managedObjectContext")
    public native NSManagedObjectContext getManagedObjectContext();
    @WeaklyLinked
    @Property(selector = "managedObjectModel")
    public native NSManagedObjectModel getManagedObjectModel();
    @WeaklyLinked
    @Property(selector = "persistentStoreOptions")
    public native NSPersistentStoreOptions getPersistentStoreOptions();
    @WeaklyLinked
    @Property(selector = "setPersistentStoreOptions:")
    public native void setPersistentStoreOptions(NSPersistentStoreOptions v);
    @Property(selector = "modelConfiguration")
    public native String getModelConfiguration();
    @Property(selector = "setModelConfiguration:")
    public native void setModelConfiguration(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @WeaklyLinked
    public boolean configurePersistentStoreCoordinator(NSURL storeURL, String fileType, String configuration, NSPersistentStoreOptions storeOptions) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = configurePersistentStoreCoordinator(storeURL, fileType, configuration, storeOptions, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @WeaklyLinked
    @Method(selector = "configurePersistentStoreCoordinatorForURL:ofType:modelConfiguration:storeOptions:error:")
    private native boolean configurePersistentStoreCoordinator(NSURL storeURL, String fileType, String configuration, NSPersistentStoreOptions storeOptions, NSError.NSErrorPtr error);
    @Method(selector = "persistentStoreTypeForFileType:")
    public native String getPersistentStoreType(String fileType);
    public boolean readAdditionalContent(NSURL absoluteURL) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = readAdditionalContent(absoluteURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "readAdditionalContentFromURL:error:")
    private native boolean readAdditionalContent(NSURL absoluteURL, NSError.NSErrorPtr error);
    public NSObject getAdditionalContent(NSURL absoluteURL) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       NSObject result = getAdditionalContent(absoluteURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "additionalContentForURL:error:")
    private native NSObject getAdditionalContent(NSURL absoluteURL, NSError.NSErrorPtr error);
    public boolean writeAdditionalContent(NSObject content, NSURL absoluteURL, NSURL absoluteOriginalContentsURL) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = writeAdditionalContent(content, absoluteURL, absoluteOriginalContentsURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "writeAdditionalContent:toURL:originalContentsURL:error:")
    private native boolean writeAdditionalContent(NSObject content, NSURL absoluteURL, NSURL absoluteOriginalContentsURL, NSError.NSErrorPtr error);
    @Method(selector = "persistentStoreName")
    public static native String getPersistentStoreName();
    /*</methods>*/
}
