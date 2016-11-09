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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSDecimal/*</name>*/ 
    extends /*<extends>*/Struct<NSDecimal>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSDecimalPtr extends Ptr<NSDecimal, NSDecimalPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(NSDecimal.class); }/*</bind>*/
    /*<constants>*//*</constants>*/

    @StructMember(0) private native int fields();
    @StructMember(1) private native @Array(8) ShortBuffer mantissa();

    @Override
    public String toString() {
        return toString(NSLocale.getCurrentLocale());
    }
    
    public String toString(NSLocale locale) {
        return toString(this, locale);
    }
    
    /*<methods>*/
    @Bridge(symbol="NSDecimalCompact", optional=true)
    public static native void compact(NSDecimal number);
    @Bridge(symbol="NSDecimalCompare", optional=true)
    public static native NSComparisonResult compare(NSDecimal leftOperand, NSDecimal rightOperand);
    @Bridge(symbol="NSDecimalRound", optional=true)
    public static native void round(NSDecimal result, NSDecimal number, @MachineSizedSInt long scale, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalNormalize", optional=true)
    public static native NSCalculationError normalize(NSDecimal number1, NSDecimal number2, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalAdd", optional=true)
    public static native NSCalculationError add(NSDecimal result, NSDecimal leftOperand, NSDecimal rightOperand, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalSubtract", optional=true)
    public static native NSCalculationError subtract(NSDecimal result, NSDecimal leftOperand, NSDecimal rightOperand, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalMultiply", optional=true)
    public static native NSCalculationError multiply(NSDecimal result, NSDecimal leftOperand, NSDecimal rightOperand, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalDivide", optional=true)
    public static native NSCalculationError divide(NSDecimal result, NSDecimal leftOperand, NSDecimal rightOperand, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalPower", optional=true)
    public static native NSCalculationError power(NSDecimal result, NSDecimal number, @MachineSizedUInt long power, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalMultiplyByPowerOf10", optional=true)
    public static native NSCalculationError multiplyByPowerOf10(NSDecimal result, NSDecimal number, short power, NSRoundingMode roundingMode);
    @Bridge(symbol="NSDecimalString", optional=true)
    protected static native String toString(NSDecimal dcm, NSObject locale);
    /*</methods>*/
}
