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
package com.bugvm.apple.passkit;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.addressbook.*;
import com.bugvm.apple.contacts.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/PKPaymentMethodType/*</name>*/ extends Bits</*<name>*/PKPaymentMethodType/*</name>*/> {
    /*<values>*/
    public static final PKPaymentMethodType Unknown = new PKPaymentMethodType(0L);
    public static final PKPaymentMethodType Debit = new PKPaymentMethodType(1L);
    public static final PKPaymentMethodType Credit = new PKPaymentMethodType(2L);
    public static final PKPaymentMethodType Prepaid = new PKPaymentMethodType(3L);
    public static final PKPaymentMethodType Store = new PKPaymentMethodType(4L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/PKPaymentMethodType/*</name>*/[] values = _values(/*<name>*/PKPaymentMethodType/*</name>*/.class);

    public /*<name>*/PKPaymentMethodType/*</name>*/(long value) { super(value); }
    private /*<name>*/PKPaymentMethodType/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/PKPaymentMethodType/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/PKPaymentMethodType/*</name>*/(value, mask);
    }
    protected /*<name>*/PKPaymentMethodType/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/PKPaymentMethodType/*</name>*/[] values() {
        return values.clone();
    }
}
