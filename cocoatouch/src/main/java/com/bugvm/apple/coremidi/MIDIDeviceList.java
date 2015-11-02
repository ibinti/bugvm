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
/*<annotations>*/@Library("CoreMIDI")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDIDeviceList/*</name>*/ 
    extends /*<extends>*/MIDIObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDIDeviceListPtr extends Ptr<MIDIDeviceList, MIDIDeviceListPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(MIDIDeviceList.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIDeviceListGetNumberOfDevices", optional=true)
    public native @MachineSizedUInt long getNumberOfDevices();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIDeviceListGetDevice", optional=true)
    public native MIDIDevice getDevice(@MachineSizedUInt long index0);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIDeviceListAddDevice", optional=true)
    public native MIDIError addDevice(MIDIDevice dev);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Bridge(symbol="MIDIDeviceListDispose", optional=true)
    public native MIDIError dispose();
    /*</methods>*/
}
