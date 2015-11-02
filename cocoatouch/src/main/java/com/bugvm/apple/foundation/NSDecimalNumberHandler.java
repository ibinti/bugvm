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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSDecimalNumberHandler/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSDecimalNumberBehaviors, NSCoding/*</implements>*/ {

    /*<ptr>*/public static class NSDecimalNumberHandlerPtr extends Ptr<NSDecimalNumberHandler, NSDecimalNumberHandlerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSDecimalNumberHandler.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected NSDecimalNumberHandler(SkipInit skipInit) { super(skipInit); }
    public NSDecimalNumberHandler(NSRoundingMode roundingMode, short scale, boolean exact, boolean overflow, boolean underflow, boolean divideByZero) { super((SkipInit) null); initObject(init(roundingMode, scale, exact, overflow, underflow, divideByZero)); }
    public NSDecimalNumberHandler(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithRoundingMode:scale:raiseOnExactness:raiseOnOverflow:raiseOnUnderflow:raiseOnDivideByZero:")
    protected native @Pointer long init(NSRoundingMode roundingMode, short scale, boolean exact, boolean overflow, boolean underflow, boolean divideByZero);
    @Method(selector = "defaultDecimalNumberHandler")
    public static native NSDecimalNumberHandler getDefaultDecimalNumberHandler();
    @Method(selector = "roundingMode")
    public native NSRoundingMode getRoundingMode();
    @Method(selector = "scale")
    public native short getScale();
    @Method(selector = "exceptionDuringOperation:error:leftOperand:rightOperand:")
    public native NSDecimalNumber exceptionDuringOperation(Selector operation, NSCalculationError error, NSDecimalNumber leftOperand, NSDecimalNumber rightOperand);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
