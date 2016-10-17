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
package com.bugvm.apple.security;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("Security")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SecItem/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(SecItem.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static CFType getMatching(SecQuery query) throws OSStatusException {
        CFType.CFTypePtr ptr = new CFType.CFTypePtr();
        OSStatus status = getMatching0(query, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static CFType add(SecAttributes attributes) throws OSStatusException {
        CFType.CFTypePtr ptr = new CFType.CFTypePtr();
        OSStatus status = add0(attributes, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static void update(SecQuery query, SecAttributes attributesToUpdate) throws OSStatusException {
        OSStatus status = update0(query, attributesToUpdate);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static void delete(SecQuery query) throws OSStatusException {
        OSStatus status = delete0(query);
        OSStatusException.throwIfNecessary(status);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="SecItemCopyMatching", optional=true)
    protected static native OSStatus getMatching0(SecQuery query, CFType.CFTypePtr result);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="SecItemAdd", optional=true)
    protected static native OSStatus add0(SecAttributes attributes, CFType.CFTypePtr result);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="SecItemUpdate", optional=true)
    protected static native OSStatus update0(SecQuery query, SecAttributes attributesToUpdate);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="SecItemDelete", optional=true)
    protected static native OSStatus delete0(SecQuery query);
    /*</methods>*/
}
