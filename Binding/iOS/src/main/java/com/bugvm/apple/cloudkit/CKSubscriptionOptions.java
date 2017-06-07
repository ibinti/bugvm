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
package com.bugvm.apple.cloudkit;

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
import com.bugvm.apple.contacts.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CKSubscriptionOptions/*</name>*/ extends Bits</*<name>*/CKSubscriptionOptions/*</name>*/> {
    /*<values>*/
    public static final CKSubscriptionOptions None = new CKSubscriptionOptions(0L);
    public static final CKSubscriptionOptions OnRecordCreation = new CKSubscriptionOptions(1L);
    public static final CKSubscriptionOptions OnRecordUpdate = new CKSubscriptionOptions(2L);
    public static final CKSubscriptionOptions OnRecordDeletion = new CKSubscriptionOptions(4L);
    public static final CKSubscriptionOptions Once = new CKSubscriptionOptions(8L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/CKSubscriptionOptions/*</name>*/[] values = _values(/*<name>*/CKSubscriptionOptions/*</name>*/.class);

    public /*<name>*/CKSubscriptionOptions/*</name>*/(long value) { super(value); }
    private /*<name>*/CKSubscriptionOptions/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CKSubscriptionOptions/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CKSubscriptionOptions/*</name>*/(value, mask);
    }
    protected /*<name>*/CKSubscriptionOptions/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CKSubscriptionOptions/*</name>*/[] values() {
        return values.clone();
    }
}
