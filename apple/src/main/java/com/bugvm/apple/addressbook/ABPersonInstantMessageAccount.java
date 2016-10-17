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
package com.bugvm.apple.addressbook;

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
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("AddressBook")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class ABPersonInstantMessageAccount 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    private CFDictionary data;
    private CFString label;
    
    public ABPersonInstantMessageAccount(String username, ABPersonInstantMessageService service, String label) {
        this.data = CFMutableDictionary.create();
        setUsername(username);
        setService(service);
        this.label = new CFString(label);
    }
    public ABPersonInstantMessageAccount(String username, ABPersonInstantMessageService service, ABPropertyLabel label) {
        this.data = CFMutableDictionary.create();
        setUsername(username);
        setService(service);
        this.label = label.value();
    }
    protected ABPersonInstantMessageAccount(CFDictionary data, CFString label) {
        this.data = data;
        this.label = label;
    }
    /*<bind>*/static { Bro.bind(ABPersonInstantMessageAccount.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public CFDictionary getDictionary() {
        return data;
    }
    
    public String getLabel() {
        return label.toString();
    }
    public CFString getLabel0 () {
        return label;
    }
    
    public String getUsername() {
        if (data.containsKey(UsernameKey())) {
            CFString val = data.get(UsernameKey(), CFString.class);
            return val.toString();
        }
        return null;
    }
    public ABPersonInstantMessageAccount setUsername(String username) {
        data.put(UsernameKey(), new CFString(username));
        return this;
    }
    public ABPersonInstantMessageService getService() {
        if (data.containsKey(ServiceKey())) {
            CFString val = data.get(ServiceKey(), CFString.class);
            return ABPersonInstantMessageService.valueOf(val);
        }
        return null;
    }
    public ABPersonInstantMessageAccount setService(ABPersonInstantMessageService service) {
        data.put(ServiceKey(), service.value());
        return this;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @GlobalValue(symbol="kABPersonInstantMessageServiceKey", optional=true)
    protected static native CFString ServiceKey();
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @GlobalValue(symbol="kABPersonInstantMessageUsernameKey", optional=true)
    protected static native CFString UsernameKey();
    /*</methods>*/
    @Override
    public String toString() {
        if (data != null) return data.toString();
        return super.toString();
    }
}
