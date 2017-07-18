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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/PKMerchantCapability/*</name>*/ extends Bits</*<name>*/PKMerchantCapability/*</name>*/> {
    /*<values>*/
    public static final PKMerchantCapability None = new PKMerchantCapability(0L);
    public static final PKMerchantCapability _3DS = new PKMerchantCapability(1L);
    public static final PKMerchantCapability EMV = new PKMerchantCapability(2L);
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final PKMerchantCapability Credit = new PKMerchantCapability(4L);
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final PKMerchantCapability Debit = new PKMerchantCapability(8L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/PKMerchantCapability/*</name>*/[] values = _values(/*<name>*/PKMerchantCapability/*</name>*/.class);

    public /*<name>*/PKMerchantCapability/*</name>*/(long value) { super(value); }
    private /*<name>*/PKMerchantCapability/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/PKMerchantCapability/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/PKMerchantCapability/*</name>*/(value, mask);
    }
    protected /*<name>*/PKMerchantCapability/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/PKMerchantCapability/*</name>*/[] values() {
        return values.clone();
    }
}
