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
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSDecimalNumber/*</name>*/ 
    extends /*<extends>*/NSNumber/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSDecimalNumberPtr extends Ptr<NSDecimalNumber, NSDecimalNumberPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSDecimalNumber.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected NSDecimalNumber(SkipInit skipInit) { super(skipInit); }
    public NSDecimalNumber(long mantissa, short exponent, boolean flag) { super((SkipInit) null); initObject(init(mantissa, exponent, flag)); }
    public NSDecimalNumber(@ByVal NSDecimal dcm) { super((SkipInit) null); initObject(init(dcm)); }
    public NSDecimalNumber(String numberValue) { super((SkipInit) null); initObject(init(numberValue)); }
    public NSDecimalNumber(String numberValue, NSLocale locale) { super((SkipInit) null); initObject(init(numberValue, locale)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithMantissa:exponent:isNegative:")
    protected native @Pointer long init(long mantissa, short exponent, boolean flag);
    @Method(selector = "initWithDecimal:")
    protected native @Pointer long init(@ByVal NSDecimal dcm);
    @Method(selector = "initWithString:")
    protected native @Pointer long init(String numberValue);
    @Method(selector = "initWithString:locale:")
    protected native @Pointer long init(String numberValue, NSLocale locale);
    @Method(selector = "decimalNumberByAdding:")
    public native NSDecimalNumber add(NSDecimalNumber decimalNumber);
    @Method(selector = "decimalNumberByAdding:withBehavior:")
    public native NSDecimalNumber add(NSDecimalNumber decimalNumber, NSDecimalNumberBehaviors behavior);
    @Method(selector = "decimalNumberBySubtracting:")
    public native NSDecimalNumber subtract(NSDecimalNumber decimalNumber);
    @Method(selector = "decimalNumberBySubtracting:withBehavior:")
    public native NSDecimalNumber subtract(NSDecimalNumber decimalNumber, NSDecimalNumberBehaviors behavior);
    @Method(selector = "decimalNumberByMultiplyingBy:")
    public native NSDecimalNumber multiply(NSDecimalNumber decimalNumber);
    @Method(selector = "decimalNumberByMultiplyingBy:withBehavior:")
    public native NSDecimalNumber multiply(NSDecimalNumber decimalNumber, NSDecimalNumberBehaviors behavior);
    @Method(selector = "decimalNumberByDividingBy:")
    public native NSDecimalNumber divide(NSDecimalNumber decimalNumber);
    @Method(selector = "decimalNumberByDividingBy:withBehavior:")
    public native NSDecimalNumber divide(NSDecimalNumber decimalNumber, NSDecimalNumberBehaviors behavior);
    @Method(selector = "decimalNumberByRaisingToPower:")
    public native NSDecimalNumber raise(@MachineSizedUInt long power);
    @Method(selector = "decimalNumberByRaisingToPower:withBehavior:")
    public native NSDecimalNumber raise(@MachineSizedUInt long power, NSDecimalNumberBehaviors behavior);
    @Method(selector = "decimalNumberByMultiplyingByPowerOf10:")
    public native NSDecimalNumber multiplyByPowerOf10(short power);
    @Method(selector = "decimalNumberByMultiplyingByPowerOf10:withBehavior:")
    public native NSDecimalNumber multiplyByPowerOf10(short power, NSDecimalNumberBehaviors behavior);
    @Method(selector = "decimalNumberByRoundingAccordingToBehavior:")
    public native NSDecimalNumber round(NSDecimalNumberBehaviors behavior);
    @Method(selector = "zero")
    public static native NSDecimalNumber zero();
    @Method(selector = "one")
    public static native NSDecimalNumber one();
    @Method(selector = "minimumDecimalNumber")
    public static native NSDecimalNumber getMin();
    @Method(selector = "maximumDecimalNumber")
    public static native NSDecimalNumber getMax();
    @Method(selector = "notANumber")
    public static native NSDecimalNumber getNaN();
    @Method(selector = "setDefaultBehavior:")
    public static native void setDefaultBehavior(NSDecimalNumberBehaviors behavior);
    @Method(selector = "defaultBehavior")
    public static native NSDecimalNumberBehaviors getDefaultBehavior();
    /*</methods>*/
}
