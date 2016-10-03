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
package com.bugvm.ios.CoreMIDI;

/*<imports>*/

import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
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
    public MIDIObjectAddRemoveNotification(MIDINotificationMessageID messageID, int messageSize, com.bugvm.ios.CoreMIDI.MIDIObject parent, com.bugvm.ios.CoreMIDI.MIDIObjectType parentType, com.bugvm.ios.CoreMIDI.MIDIObject child, com.bugvm.ios.CoreMIDI.MIDIObjectType childType) {
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
    @StructMember(2) public native com.bugvm.ios.CoreMIDI.MIDIObject getParent();
    @StructMember(2) public native MIDIObjectAddRemoveNotification setParent(com.bugvm.ios.CoreMIDI.MIDIObject parent);
    @StructMember(3) public native com.bugvm.ios.CoreMIDI.MIDIObjectType getParentType();
    @StructMember(3) public native MIDIObjectAddRemoveNotification setParentType(com.bugvm.ios.CoreMIDI.MIDIObjectType parentType);
    @StructMember(4) public native com.bugvm.ios.CoreMIDI.MIDIObject getChild();
    @StructMember(4) public native MIDIObjectAddRemoveNotification setChild(com.bugvm.ios.CoreMIDI.MIDIObject child);
    @StructMember(5) public native com.bugvm.ios.CoreMIDI.MIDIObjectType getChildType();
    @StructMember(5) public native MIDIObjectAddRemoveNotification setChildType(com.bugvm.ios.CoreMIDI.MIDIObjectType childType);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
