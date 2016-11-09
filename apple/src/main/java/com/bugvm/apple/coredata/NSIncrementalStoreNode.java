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
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreData") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSIncrementalStoreNode/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSIncrementalStoreNodePtr extends Ptr<NSIncrementalStoreNode, NSIncrementalStoreNodePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSIncrementalStoreNode.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSIncrementalStoreNode() {}
    protected NSIncrementalStoreNode(SkipInit skipInit) { super(skipInit); }
    public NSIncrementalStoreNode(NSManagedObjectID objectID, NSDictionary<NSString, ?> values, long version) { super((SkipInit) null); initObject(init(objectID, values, version)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "objectID")
    public native NSManagedObjectID getObjectID();
    @Property(selector = "version")
    public native long getVersion();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithObjectID:withValues:version:")
    protected native @Pointer long init(NSManagedObjectID objectID, NSDictionary<NSString, ?> values, long version);
    @Method(selector = "updateWithValues:version:")
    public native void update(NSDictionary<NSString, ?> values, long version);
    @Method(selector = "valueForPropertyDescription:")
    public native NSObject getValue(NSPropertyDescription prop);
    /*</methods>*/
}
