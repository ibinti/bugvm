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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("UIKit")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIFloatRange/*</name>*/ 
    extends /*<extends>*/Struct<UIFloatRange>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIFloatRangePtr extends Ptr<UIFloatRange, UIFloatRangePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(UIFloatRange.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIFloatRange() {}
    public UIFloatRange(@MachineSizedFloat double minimum, @MachineSizedFloat double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedFloat double getMinimum();
    @StructMember(0) public native UIFloatRange setMinimum(@MachineSizedFloat double minimum);
    @StructMember(1) public native @MachineSizedFloat double getMaximum();
    @StructMember(1) public native UIFloatRange setMaximum(@MachineSizedFloat double maximum);
    /*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="UIFloatRangeZero", optional=true)
    public static native @ByVal UIFloatRange Zero();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="UIFloatRangeInfinite", optional=true)
    public static native @ByVal UIFloatRange Infinite();
    
    /**
     * @since Available in iOS 9.0 and later.
     */
    public boolean isInfinite() { return isInfinite(this); }
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Bridge(symbol="UIFloatRangeIsInfinite", optional=true)
    private static native boolean isInfinite(@ByVal UIFloatRange range);
    /**
     * @since Available in iOS 9.0 and later.
     */
    public boolean equalsTo(UIFloatRange otherRange) { return equalsTo(this, otherRange); }
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Bridge(symbol="UIFloatRangeIsEqualToRange", optional=true)
    private static native boolean equalsTo(@ByVal UIFloatRange range, @ByVal UIFloatRange otherRange);
    /*</methods>*/
}
