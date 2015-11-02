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
package com.bugvm.apple.coremidi;

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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIObjectAddRemoveNotification/*</name>*/ 
    extends /*<extends>*/Struct<MIDIObjectAddRemoveNotification>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIObjectAddRemoveNotificationPtr extends Ptr<MIDIObjectAddRemoveNotification, MIDIObjectAddRemoveNotificationPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MIDIObjectAddRemoveNotification() {}
    public MIDIObjectAddRemoveNotification(MIDINotificationMessageID messageID, int messageSize, MIDIObject parent, MIDIObjectType parentType, MIDIObject child, MIDIObjectType childType) {
        this.setMessageID(messageID);
        this.setMessageSize(messageSize);
        this.setParent(parent);
        this.setParentType(parentType);
        this.setChild(child);
        this.setChildType(childType);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native MIDINotificationMessageID getMessageID();
    @StructMember(0) public native MIDIObjectAddRemoveNotification setMessageID(MIDINotificationMessageID messageID);
    @StructMember(1) public native int getMessageSize();
    @StructMember(1) public native MIDIObjectAddRemoveNotification setMessageSize(int messageSize);
    @StructMember(2) public native MIDIObject getParent();
    @StructMember(2) public native MIDIObjectAddRemoveNotification setParent(MIDIObject parent);
    @StructMember(3) public native MIDIObjectType getParentType();
    @StructMember(3) public native MIDIObjectAddRemoveNotification setParentType(MIDIObjectType parentType);
    @StructMember(4) public native MIDIObject getChild();
    @StructMember(4) public native MIDIObjectAddRemoveNotification setChild(MIDIObject child);
    @StructMember(5) public native MIDIObjectType getChildType();
    @StructMember(5) public native MIDIObjectAddRemoveNotification setChildType(MIDIObjectType childType);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
