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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CNSaveRequest/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CNSaveRequestPtr extends Ptr<CNSaveRequest, CNSaveRequestPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CNSaveRequest.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CNSaveRequest() {}
    protected CNSaveRequest(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "addContact:toContainerWithIdentifier:")
    public native void addContactToContainer(CNMutableContact contact, String identifier);
    @Method(selector = "updateContact:")
    public native void updateContact(CNMutableContact contact);
    @Method(selector = "deleteContact:")
    public native void deleteContact(CNMutableContact contact);
    @Method(selector = "addGroup:toContainerWithIdentifier:")
    public native void addGroupToContainer(CNMutableGroup group, String identifier);
    @Method(selector = "updateGroup:")
    public native void updateGroup(CNMutableGroup group);
    @Method(selector = "deleteGroup:")
    public native void deleteGroup(CNMutableGroup group);
    @Method(selector = "addMember:toGroup:")
    public native void addMemberToGroup(CNContact contact, CNGroup group);
    @Method(selector = "removeMember:fromGroup:")
    public native void removeMemberFromGroup(CNContact contact, CNGroup group);
    /*</methods>*/
}
