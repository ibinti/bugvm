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
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreData") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSBatchDeleteRequest/*</name>*/ 
    extends /*<extends>*/NSPersistentStoreRequest/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSBatchDeleteRequestPtr extends Ptr<NSBatchDeleteRequest, NSBatchDeleteRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSBatchDeleteRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSBatchDeleteRequest() {}
    protected NSBatchDeleteRequest(SkipInit skipInit) { super(skipInit); }
    public NSBatchDeleteRequest(NSFetchRequest fetch) { super((SkipInit) null); initObject(init(fetch)); }
    public NSBatchDeleteRequest(NSArray<NSManagedObjectID> objects) { super((SkipInit) null); initObject(init(objects)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "resultType")
    public native NSBatchDeleteRequestResultType getResultType();
    @Property(selector = "setResultType:")
    public native void setResultType(NSBatchDeleteRequestResultType v);
    @Property(selector = "fetchRequest")
    public native NSFetchRequest getFetchRequest();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithFetchRequest:")
    protected native @Pointer long init(NSFetchRequest fetch);
    @Method(selector = "initWithObjectIDs:")
    protected native @Pointer long init(NSArray<NSManagedObjectID> objects);
    /*</methods>*/
}
