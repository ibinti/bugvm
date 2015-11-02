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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSDateComponentsFormatter/*</name>*/ 
    extends /*<extends>*/NSFormatter/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSDateComponentsFormatterPtr extends Ptr<NSDateComponentsFormatter, NSDateComponentsFormatterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSDateComponentsFormatter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSDateComponentsFormatter() {}
    protected NSDateComponentsFormatter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "unitsStyle")
    public native NSDateComponentsFormatterUnitsStyle getUnitsStyle();
    @Property(selector = "setUnitsStyle:")
    public native void setUnitsStyle(NSDateComponentsFormatterUnitsStyle v);
    @Property(selector = "allowedUnits")
    public native NSCalendarUnit getAllowedUnits();
    @Property(selector = "setAllowedUnits:")
    public native void setAllowedUnits(NSCalendarUnit v);
    @Property(selector = "zeroFormattingBehavior")
    public native NSDateComponentsFormatterZeroFormattingBehavior getZeroFormattingBehavior();
    @Property(selector = "setZeroFormattingBehavior:")
    public native void setZeroFormattingBehavior(NSDateComponentsFormatterZeroFormattingBehavior v);
    @Property(selector = "calendar")
    public native NSCalendar getCalendar();
    @Property(selector = "setCalendar:")
    public native void setCalendar(NSCalendar v);
    @Property(selector = "allowsFractionalUnits")
    public native boolean allowsFractionalUnits();
    @Property(selector = "setAllowsFractionalUnits:")
    public native void setAllowsFractionalUnits(boolean v);
    @Property(selector = "maximumUnitCount")
    public native @MachineSizedSInt long getMaximumUnitCount();
    @Property(selector = "setMaximumUnitCount:")
    public native void setMaximumUnitCount(@MachineSizedSInt long v);
    @Property(selector = "collapsesLargestUnit")
    public native boolean collapsesLargestUnit();
    @Property(selector = "setCollapsesLargestUnit:")
    public native void setCollapsesLargestUnit(boolean v);
    @Property(selector = "includesApproximationPhrase")
    public native boolean includesApproximationPhrase();
    @Property(selector = "setIncludesApproximationPhrase:")
    public native void setIncludesApproximationPhrase(boolean v);
    @Property(selector = "includesTimeRemainingPhrase")
    public native boolean includesTimeRemainingPhrase();
    @Property(selector = "setIncludesTimeRemainingPhrase:")
    public native void setIncludesTimeRemainingPhrase(boolean v);
    @Property(selector = "formattingContext")
    public native NSFormattingContext getFormattingContext();
    @Property(selector = "setFormattingContext:")
    public native void setFormattingContext(NSFormattingContext v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "stringForObjectValue:")
    public native String format(NSObject obj);
    @Method(selector = "stringFromDateComponents:")
    public native String format(NSDateComponents components);
    @Method(selector = "stringFromDate:toDate:")
    public native String format(NSDate startDate, NSDate endDate);
    @Method(selector = "stringFromTimeInterval:")
    public native String format(double ti);
    /*</methods>*/
}
