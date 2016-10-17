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

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreData") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMappingModel/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSMappingModelPtr extends Ptr<NSMappingModel, NSMappingModelPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSMappingModel.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMappingModel() {}
    protected NSMappingModel(SkipInit skipInit) { super(skipInit); }
    public NSMappingModel(NSURL url) { super((SkipInit) null); initObject(init(url)); }
    public NSMappingModel(NSArray<NSBundle> bundles, NSManagedObjectModel sourceModel, NSManagedObjectModel destinationModel) { super(create(bundles, sourceModel, destinationModel)); retain(getHandle()); }
    /*</constructors>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    public NSMappingModel(NSManagedObjectModel sourceModel, NSManagedObjectModel destinationModel) throws NSErrorException {
        super(createInferred(sourceModel, destinationModel));
        retain(getHandle());
    }
    /*<properties>*/
    @Property(selector = "entityMappings")
    public native NSArray<NSEntityMapping> getEntityMappings();
    @Property(selector = "setEntityMappings:")
    public native void setEntityMappings(NSArray<NSEntityMapping> v);
    @Property(selector = "entityMappingsByName")
    public native NSDictionary<NSString, NSEntityMapping> getEntityMappingsByName();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithContentsOfURL:")
    protected native @Pointer long init(NSURL url);
    @Method(selector = "mappingModelFromBundles:forSourceModel:destinationModel:")
    protected static native @Pointer long create(NSArray<NSBundle> bundles, NSManagedObjectModel sourceModel, NSManagedObjectModel destinationModel);
    /**
     * @since Available in iOS 3.0 and later.
     */
    protected static @Pointer long createInferred(NSManagedObjectModel sourceModel, NSManagedObjectModel destinationModel) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long result = createInferred(sourceModel, destinationModel, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "inferredMappingModelForSourceModel:destinationModel:error:")
    private static native @Pointer long createInferred(NSManagedObjectModel sourceModel, NSManagedObjectModel destinationModel, NSError.NSErrorPtr error);
    /*</methods>*/
}
