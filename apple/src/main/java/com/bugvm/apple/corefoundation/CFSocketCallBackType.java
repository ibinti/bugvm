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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CFSocketCallBackType/*</name>*/ extends Bits</*<name>*/CFSocketCallBackType/*</name>*/> {
    /*<values>*/
    public static final CFSocketCallBackType None = new CFSocketCallBackType(0L);
    public static final CFSocketCallBackType NoCallBack = new CFSocketCallBackType(0L);
    public static final CFSocketCallBackType ReadCallBack = new CFSocketCallBackType(1L);
    public static final CFSocketCallBackType AcceptCallBack = new CFSocketCallBackType(2L);
    public static final CFSocketCallBackType DataCallBack = new CFSocketCallBackType(3L);
    public static final CFSocketCallBackType ConnectCallBack = new CFSocketCallBackType(4L);
    public static final CFSocketCallBackType WriteCallBack = new CFSocketCallBackType(8L);
    /*</values>*/

    private static final /*<name>*/CFSocketCallBackType/*</name>*/[] values = _values(/*<name>*/CFSocketCallBackType/*</name>*/.class);

    public /*<name>*/CFSocketCallBackType/*</name>*/(long value) { super(value); }
    private /*<name>*/CFSocketCallBackType/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CFSocketCallBackType/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CFSocketCallBackType/*</name>*/(value, mask);
    }
    protected /*<name>*/CFSocketCallBackType/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CFSocketCallBackType/*</name>*/[] values() {
        return values.clone();
    }
}
