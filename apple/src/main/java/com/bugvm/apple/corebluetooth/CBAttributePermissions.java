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
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CBAttributePermissions/*</name>*/ extends Bits</*<name>*/CBAttributePermissions/*</name>*/> {
    /*<values>*/
    public static final CBAttributePermissions None = new CBAttributePermissions(0L);
    public static final CBAttributePermissions Readable = new CBAttributePermissions(1L);
    public static final CBAttributePermissions Writeable = new CBAttributePermissions(2L);
    public static final CBAttributePermissions ReadEncryptionRequired = new CBAttributePermissions(4L);
    public static final CBAttributePermissions WriteEncryptionRequired = new CBAttributePermissions(8L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/CBAttributePermissions/*</name>*/[] values = _values(/*<name>*/CBAttributePermissions/*</name>*/.class);

    public /*<name>*/CBAttributePermissions/*</name>*/(long value) { super(value); }
    private /*<name>*/CBAttributePermissions/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CBAttributePermissions/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CBAttributePermissions/*</name>*/(value, mask);
    }
    protected /*<name>*/CBAttributePermissions/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CBAttributePermissions/*</name>*/[] values() {
        return values.clone();
    }
}
