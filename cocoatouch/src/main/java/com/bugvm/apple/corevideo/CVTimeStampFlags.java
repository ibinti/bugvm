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
package com.bugvm.apple.corevideo;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CVTimeStampFlags/*</name>*/ extends Bits</*<name>*/CVTimeStampFlags/*</name>*/> {
    /*<values>*/
    public static final CVTimeStampFlags None = new CVTimeStampFlags(0L);
    public static final CVTimeStampFlags VideoTimeValid = new CVTimeStampFlags(1L);
    public static final CVTimeStampFlags HostTimeValid = new CVTimeStampFlags(2L);
    public static final CVTimeStampFlags SMPTETimeValid = new CVTimeStampFlags(4L);
    public static final CVTimeStampFlags VideoRefreshPeriodValid = new CVTimeStampFlags(8L);
    public static final CVTimeStampFlags RateScalarValid = new CVTimeStampFlags(16L);
    public static final CVTimeStampFlags TopField = new CVTimeStampFlags(65536L);
    public static final CVTimeStampFlags BottomField = new CVTimeStampFlags(131072L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/CVTimeStampFlags/*</name>*/[] values = _values(/*<name>*/CVTimeStampFlags/*</name>*/.class);

    public /*<name>*/CVTimeStampFlags/*</name>*/(long value) { super(value); }
    private /*<name>*/CVTimeStampFlags/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CVTimeStampFlags/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CVTimeStampFlags/*</name>*/(value, mask);
    }
    protected /*<name>*/CVTimeStampFlags/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CVTimeStampFlags/*</name>*/[] values() {
        return values.clone();
    }
}
