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
package com.bugvm.apple.coredata;

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
/*</imports>*/
import com.bugvm.apple.foundation.NSError.NSErrorPtr;

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreData") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSAtomicStore/*</name>*/ 
    extends /*<extends>*/NSPersistentStore/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSAtomicStorePtr extends Ptr<NSAtomicStore, NSAtomicStorePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSAtomicStore.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSAtomicStore() {}
    protected NSAtomicStore(SkipInit skipInit) { super(skipInit); }
    public NSAtomicStore(NSPersistentStoreCoordinator coordinator, String configurationName, NSURL url, NSPersistentStoreOptions options) { super((SkipInit) null); initObject(init(coordinator, configurationName, url, options)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithPersistentStoreCoordinator:configurationName:URL:options:")
    protected native @Pointer long init(NSPersistentStoreCoordinator coordinator, String configurationName, NSURL url, NSPersistentStoreOptions options);
    public boolean load() throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = load(ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "load:")
    private native boolean load(NSError.NSErrorPtr error);
    public boolean save() throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = save(ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "save:")
    private native boolean save(NSError.NSErrorPtr error);
    @Method(selector = "newCacheNodeForManagedObject:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSObject.NoRetainMarshaler.class) NSAtomicStoreCacheNode newCacheNode(NSManagedObject managedObject);
    @Method(selector = "updateCacheNode:fromManagedObject:")
    public native void updateCacheNode(NSAtomicStoreCacheNode node, NSManagedObject managedObject);
    @Method(selector = "cacheNodes")
    public native NSSet<NSAtomicStoreCacheNode> getCacheNodes();
    @Method(selector = "addCacheNodes:")
    public native void addCacheNodes(NSSet<NSAtomicStoreCacheNode> cacheNodes);
    @Method(selector = "willRemoveCacheNodes:")
    public native void willRemoveCacheNodes(NSSet<NSAtomicStoreCacheNode> cacheNodes);
    @Method(selector = "cacheNodeForObjectID:")
    public native NSAtomicStoreCacheNode getCacheNode(NSManagedObjectID objectID);
    @Method(selector = "objectIDForEntity:referenceObject:")
    public native NSManagedObjectID getObjectID(NSEntityDescription entity, NSObject data);
    @Method(selector = "newReferenceObjectForManagedObject:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSObject.NoRetainMarshaler.class) NSObject newReferenceObject(NSManagedObject managedObject);
    @Method(selector = "referenceObjectForObjectID:")
    public native NSObject getReferenceObject(NSManagedObjectID objectID);
    /*</methods>*/
}
