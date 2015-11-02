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
package com.bugvm.apple.mapkit;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/MKDirectionsTransportType/*</name>*/ extends Bits</*<name>*/MKDirectionsTransportType/*</name>*/> {
    /*<values>*/
    public static final MKDirectionsTransportType None = new MKDirectionsTransportType(0L);
    public static final MKDirectionsTransportType Automobile = new MKDirectionsTransportType(1L);
    public static final MKDirectionsTransportType Walking = new MKDirectionsTransportType(2L);
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final MKDirectionsTransportType Transit = new MKDirectionsTransportType(4L);
    public static final MKDirectionsTransportType Any = new MKDirectionsTransportType(268435455L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/MKDirectionsTransportType/*</name>*/[] values = _values(/*<name>*/MKDirectionsTransportType/*</name>*/.class);

    public /*<name>*/MKDirectionsTransportType/*</name>*/(long value) { super(value); }
    private /*<name>*/MKDirectionsTransportType/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/MKDirectionsTransportType/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/MKDirectionsTransportType/*</name>*/(value, mask);
    }
    protected /*<name>*/MKDirectionsTransportType/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/MKDirectionsTransportType/*</name>*/[] values() {
        return values.clone();
    }
}
