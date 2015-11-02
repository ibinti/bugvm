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
package com.bugvm.apple.audiounit;

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
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public final class /*<name>*/AUParameterFlags/*</name>*/ extends Bits</*<name>*/AUParameterFlags/*</name>*/> {
    /*<values>*/
    public static final AUParameterFlags None = new AUParameterFlags(0L);
    public static final AUParameterFlags CFNameRelease = new AUParameterFlags(16L);
    public static final AUParameterFlags OmitFromPresets = new AUParameterFlags(8192L);
    public static final AUParameterFlags PlotHistory = new AUParameterFlags(16384L);
    public static final AUParameterFlags MeterReadOnly = new AUParameterFlags(32768L);
    public static final AUParameterFlags DisplayMask = new AUParameterFlags(4653056L);
    public static final AUParameterFlags DisplaySquareRoot = new AUParameterFlags(65536L);
    public static final AUParameterFlags DisplaySquared = new AUParameterFlags(131072L);
    public static final AUParameterFlags DisplayCubed = new AUParameterFlags(196608L);
    public static final AUParameterFlags DisplayCubeRoot = new AUParameterFlags(262144L);
    public static final AUParameterFlags DisplayExponential = new AUParameterFlags(327680L);
    public static final AUParameterFlags HasClump = new AUParameterFlags(1048576L);
    public static final AUParameterFlags ValuesHaveStrings = new AUParameterFlags(2097152L);
    public static final AUParameterFlags DisplayLogarithmic = new AUParameterFlags(4194304L);
    public static final AUParameterFlags IsHighResolution = new AUParameterFlags(8388608L);
    public static final AUParameterFlags NonRealTime = new AUParameterFlags(16777216L);
    public static final AUParameterFlags CanRamp = new AUParameterFlags(33554432L);
    public static final AUParameterFlags ExpertMode = new AUParameterFlags(67108864L);
    public static final AUParameterFlags HasCFNameString = new AUParameterFlags(134217728L);
    public static final AUParameterFlags IsGlobalMeta = new AUParameterFlags(268435456L);
    public static final AUParameterFlags IsElementMeta = new AUParameterFlags(536870912L);
    public static final AUParameterFlags IsReadable = new AUParameterFlags(1073741824L);
    public static final AUParameterFlags IsWritable = new AUParameterFlags(-2147483648L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/AUParameterFlags/*</name>*/[] values = _values(/*<name>*/AUParameterFlags/*</name>*/.class);

    public /*<name>*/AUParameterFlags/*</name>*/(long value) { super(value); }
    private /*<name>*/AUParameterFlags/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/AUParameterFlags/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/AUParameterFlags/*</name>*/(value, mask);
    }
    protected /*<name>*/AUParameterFlags/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/AUParameterFlags/*</name>*/[] values() {
        return values.clone();
    }
}
