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
package com.bugvm.apple.contacts;

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
/*<annotations>*/@Library("Contacts") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CNContactFetchRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CNContactFetchRequestPtr extends Ptr<CNContactFetchRequest, CNContactFetchRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CNContactFetchRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CNContactFetchRequest() {}
    protected CNContactFetchRequest(SkipInit skipInit) { super(skipInit); }
    public CNContactFetchRequest(@com.bugvm.rt.bro.annotation.Marshaler(CNContactPropertyKey.AsListMarshaler.class) List<CNContactPropertyKey> keysToFetch) { super((SkipInit) null); initObject(init(keysToFetch)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "predicate")
    public native NSPredicate getPredicate();
    @Property(selector = "setPredicate:")
    public native void setPredicate(NSPredicate v);
    @Property(selector = "keysToFetch")
    public native @com.bugvm.rt.bro.annotation.Marshaler(CNContactPropertyKey.AsListMarshaler.class) List<CNContactPropertyKey> getKeysToFetch();
    @Property(selector = "setKeysToFetch:")
    public native void setKeysToFetch(@com.bugvm.rt.bro.annotation.Marshaler(CNContactPropertyKey.AsListMarshaler.class) List<CNContactPropertyKey> v);
    @Property(selector = "mutableObjects")
    public native boolean isMutableObjects();
    @Property(selector = "setMutableObjects:")
    public native void setMutableObjects(boolean v);
    @Property(selector = "unifyResults")
    public native boolean isUnifyResults();
    @Property(selector = "setUnifyResults:")
    public native void setUnifyResults(boolean v);
    @Property(selector = "sortOrder")
    public native CNContactSortOrder getSortOrder();
    @Property(selector = "setSortOrder:")
    public native void setSortOrder(CNContactSortOrder v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithKeysToFetch:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(CNContactPropertyKey.AsListMarshaler.class) List<CNContactPropertyKey> keysToFetch);
    /*</methods>*/
}
