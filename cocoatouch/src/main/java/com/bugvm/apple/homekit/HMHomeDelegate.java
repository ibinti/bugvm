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
package com.bugvm.apple.homekit;

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
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/HMHomeDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "homeDidUpdateName:")
    void didUpdateName(HMHome home);
    @Method(selector = "home:didAddAccessory:")
    void didAddAccessory(HMHome home, HMAccessory accessory);
    @Method(selector = "home:didRemoveAccessory:")
    void didRemoveAccessory(HMHome home, HMAccessory accessory);
    @Method(selector = "home:didAddUser:")
    void didAddUser(HMHome home, HMUser user);
    @Method(selector = "home:didRemoveUser:")
    void didRemoveUser(HMHome home, HMUser user);
    @Method(selector = "home:didUpdateRoom:forAccessory:")
    void didUpdateRoom(HMHome home, HMRoom room, HMAccessory accessory);
    @Method(selector = "home:didAddRoom:")
    void didAddRoom(HMHome home, HMRoom room);
    @Method(selector = "home:didRemoveRoom:")
    void didRemoveRoom(HMHome home, HMRoom room);
    @Method(selector = "home:didUpdateNameForRoom:")
    void didUpdateRoomName(HMHome home, HMRoom room);
    @Method(selector = "home:didAddZone:")
    void didAddZone(HMHome home, HMZone zone);
    @Method(selector = "home:didRemoveZone:")
    void didRemoveZone(HMHome home, HMZone zone);
    @Method(selector = "home:didUpdateNameForZone:")
    void didUpdateZoneName(HMHome home, HMZone zone);
    @Method(selector = "home:didAddRoom:toZone:")
    void didAddRoomToZone(HMHome home, HMRoom room, HMZone zone);
    @Method(selector = "home:didRemoveRoom:fromZone:")
    void didRemoveRoomFromZone(HMHome home, HMRoom room, HMZone zone);
    @Method(selector = "home:didAddServiceGroup:")
    void didAddServiceGroup(HMHome home, HMServiceGroup group);
    @Method(selector = "home:didRemoveServiceGroup:")
    void didRemoveServiceGroup(HMHome home, HMServiceGroup group);
    @Method(selector = "home:didUpdateNameForServiceGroup:")
    void didUpdateServiceGroupName(HMHome home, HMServiceGroup group);
    @Method(selector = "home:didAddService:toServiceGroup:")
    void didAddServiceToServiceGroup(HMHome home, HMService service, HMServiceGroup group);
    @Method(selector = "home:didRemoveService:fromServiceGroup:")
    void didRemoveServiceFromServiceGroup(HMHome home, HMService service, HMServiceGroup group);
    @Method(selector = "home:didAddActionSet:")
    void didAddActionSet(HMHome home, HMActionSet actionSet);
    @Method(selector = "home:didRemoveActionSet:")
    void didRemoveActionSet(HMHome home, HMActionSet actionSet);
    @Method(selector = "home:didUpdateNameForActionSet:")
    void didUpdateActionSetName(HMHome home, HMActionSet actionSet);
    @Method(selector = "home:didUpdateActionsForActionSet:")
    void didUpdateActions(HMHome home, HMActionSet actionSet);
    @Method(selector = "home:didAddTrigger:")
    void didAddTrigger(HMHome home, HMTrigger trigger);
    @Method(selector = "home:didRemoveTrigger:")
    void didRemoveTrigger(HMHome home, HMTrigger trigger);
    @Method(selector = "home:didUpdateNameForTrigger:")
    void didUpdateTriggerName(HMHome home, HMTrigger trigger);
    @Method(selector = "home:didUpdateTrigger:")
    void didUpdateTrigger(HMHome home, HMTrigger trigger);
    @Method(selector = "home:didUnblockAccessory:")
    void didUnblockAccessory(HMHome home, HMAccessory accessory);
    @Method(selector = "home:didEncounterError:forAccessory:")
    void didEncounterError(HMHome home, NSError error, HMAccessory accessory);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
