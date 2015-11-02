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
package com.bugvm.apple.corebluetooth;

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
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CBCharacteristicProperties/*</name>*/ extends Bits</*<name>*/CBCharacteristicProperties/*</name>*/> {
    /*<values>*/
    public static final CBCharacteristicProperties None = new CBCharacteristicProperties(0L);
    public static final CBCharacteristicProperties Broadcast = new CBCharacteristicProperties(1L);
    public static final CBCharacteristicProperties Read = new CBCharacteristicProperties(2L);
    public static final CBCharacteristicProperties WriteWithoutResponse = new CBCharacteristicProperties(4L);
    public static final CBCharacteristicProperties Write = new CBCharacteristicProperties(8L);
    public static final CBCharacteristicProperties Notify = new CBCharacteristicProperties(16L);
    public static final CBCharacteristicProperties Indicate = new CBCharacteristicProperties(32L);
    public static final CBCharacteristicProperties AuthenticatedSignedWrites = new CBCharacteristicProperties(64L);
    public static final CBCharacteristicProperties ExtendedProperties = new CBCharacteristicProperties(128L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final CBCharacteristicProperties NotifyEncryptionRequired = new CBCharacteristicProperties(256L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final CBCharacteristicProperties IndicateEncryptionRequired = new CBCharacteristicProperties(512L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/CBCharacteristicProperties/*</name>*/[] values = _values(/*<name>*/CBCharacteristicProperties/*</name>*/.class);

    public /*<name>*/CBCharacteristicProperties/*</name>*/(long value) { super(value); }
    private /*<name>*/CBCharacteristicProperties/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CBCharacteristicProperties/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CBCharacteristicProperties/*</name>*/(value, mask);
    }
    protected /*<name>*/CBCharacteristicProperties/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CBCharacteristicProperties/*</name>*/[] values() {
        return values.clone();
    }
}
