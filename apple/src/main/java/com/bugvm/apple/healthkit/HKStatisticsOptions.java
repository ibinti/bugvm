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
package com.bugvm.apple.healthkit;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/HKStatisticsOptions/*</name>*/ extends Bits</*<name>*/HKStatisticsOptions/*</name>*/> {
    /*<values>*/
    public static final HKStatisticsOptions None = new HKStatisticsOptions(0L);
    public static final HKStatisticsOptions SeparateBySource = new HKStatisticsOptions(1L);
    public static final HKStatisticsOptions DiscreteAverage = new HKStatisticsOptions(2L);
    public static final HKStatisticsOptions DiscreteMin = new HKStatisticsOptions(4L);
    public static final HKStatisticsOptions DiscreteMax = new HKStatisticsOptions(8L);
    public static final HKStatisticsOptions CumulativeSum = new HKStatisticsOptions(16L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/HKStatisticsOptions/*</name>*/[] values = _values(/*<name>*/HKStatisticsOptions/*</name>*/.class);

    public /*<name>*/HKStatisticsOptions/*</name>*/(long value) { super(value); }
    private /*<name>*/HKStatisticsOptions/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/HKStatisticsOptions/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/HKStatisticsOptions/*</name>*/(value, mask);
    }
    protected /*<name>*/HKStatisticsOptions/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/HKStatisticsOptions/*</name>*/[] values() {
        return values.clone();
    }
}
