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
package com.bugvm.apple.externalaccessory;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/ extends Bits</*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/> {
    /*<values>*/
    public static final EAWiFiUnconfiguredAccessoryProperties None = new EAWiFiUnconfiguredAccessoryProperties(0L);
    public static final EAWiFiUnconfiguredAccessoryProperties AirPlay = new EAWiFiUnconfiguredAccessoryProperties(1L);
    public static final EAWiFiUnconfiguredAccessoryProperties AirPrint = new EAWiFiUnconfiguredAccessoryProperties(2L);
    public static final EAWiFiUnconfiguredAccessoryProperties HomeKit = new EAWiFiUnconfiguredAccessoryProperties(4L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/[] values = _values(/*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/.class);

    public /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/(long value) { super(value); }
    private /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/(value, mask);
    }
    protected /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/EAWiFiUnconfiguredAccessoryProperties/*</name>*/[] values() {
        return values.clone();
    }
}
