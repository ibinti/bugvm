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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMassFormatter/*</name>*/ 
    extends /*<extends>*/NSFormatter/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSMassFormatterPtr extends Ptr<NSMassFormatter, NSMassFormatterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSMassFormatter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMassFormatter() {}
    protected NSMassFormatter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "numberFormatter")
    public native NSNumberFormatter getNumberFormatter();
    @Property(selector = "setNumberFormatter:")
    public native void setNumberFormatter(NSNumberFormatter v);
    @Property(selector = "unitStyle")
    public native NSFormattingUnitStyle getUnitStyle();
    @Property(selector = "setUnitStyle:")
    public native void setUnitStyle(NSFormattingUnitStyle v);
    @Property(selector = "isForPersonMassUse")
    public native boolean isForPersonMassUse();
    @Property(selector = "setForPersonMassUse:")
    public native void setForPersonMassUse(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    public String formatUnitKilograms(double numberInKilograms) {
        return formatUnitKilograms(numberInKilograms, new MachineSizedSIntPtr());
    }
    /*<methods>*/
    @Method(selector = "stringFromValue:unit:")
    public native String format(double value, NSMassFormatterUnit unit);
    @Method(selector = "stringFromKilograms:")
    public native String formatKilograms(double numberInKilograms);
    @Method(selector = "unitStringFromValue:unit:")
    public native String formatUnit(double value, NSMassFormatterUnit unit);
    @Method(selector = "unitStringFromKilograms:usedUnit:")
    protected native String formatUnitKilograms(double numberInKilograms, MachineSizedSIntPtr unitp);
    /*</methods>*/
}
