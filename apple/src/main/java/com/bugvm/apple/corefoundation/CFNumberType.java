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
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/CFNumberType/*</name>*/ implements ValuedEnum {
    /*<values>*/
    SInt8Type(1L),
    SInt16Type(2L),
    SInt32Type(3L),
    SInt64Type(4L),
    Float32Type(5L),
    Float64Type(6L),
    CharType(7L),
    ShortType(8L),
    IntType(9L),
    LongType(10L),
    LongLongType(11L),
    FloatType(12L),
    DoubleType(13L),
    CFIndexType(14L),
    /**
     * @since Available in iOS 2.0 and later.
     */
    NSIntegerType(15L),
    /**
     * @since Available in iOS 2.0 and later.
     */
    CGFloatType(16L),
    MaxType(16L);
    /*</values>*/

    private final long n;

    private /*<name>*/CFNumberType/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/CFNumberType/*</name>*/ valueOf(long n) {
        for (/*<name>*/CFNumberType/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/CFNumberType/*</name>*/.class.getName());
    }
}
