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
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSByteCountFormatter/*</name>*/ 
    extends /*<extends>*/NSFormatter/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSByteCountFormatterPtr extends Ptr<NSByteCountFormatter, NSByteCountFormatterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSByteCountFormatter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSByteCountFormatter() {}
    protected NSByteCountFormatter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "allowedUnits")
    public native NSByteCountFormatterUnits getAllowedUnits();
    @Property(selector = "setAllowedUnits:")
    public native void setAllowedUnits(NSByteCountFormatterUnits v);
    @Property(selector = "countStyle")
    public native NSByteCountFormatterCountStyle getCountStyle();
    @Property(selector = "setCountStyle:")
    public native void setCountStyle(NSByteCountFormatterCountStyle v);
    @Property(selector = "allowsNonnumericFormatting")
    public native boolean allowsNonnumericFormatting();
    @Property(selector = "setAllowsNonnumericFormatting:")
    public native void setAllowsNonnumericFormatting(boolean v);
    @Property(selector = "includesUnit")
    public native boolean includesUnit();
    @Property(selector = "setIncludesUnit:")
    public native void setIncludesUnit(boolean v);
    @Property(selector = "includesCount")
    public native boolean includesCount();
    @Property(selector = "setIncludesCount:")
    public native void setIncludesCount(boolean v);
    @Property(selector = "includesActualByteCount")
    public native boolean includesActualByteCount();
    @Property(selector = "setIncludesActualByteCount:")
    public native void setIncludesActualByteCount(boolean v);
    @Property(selector = "isAdaptive")
    public native boolean isAdaptive();
    @Property(selector = "setAdaptive:")
    public native void setAdaptive(boolean v);
    @Property(selector = "zeroPadsFractionDigits")
    public native boolean zeroPadsFractionDigits();
    @Property(selector = "setZeroPadsFractionDigits:")
    public native void setZeroPadsFractionDigits(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "formattingContext")
    public native NSFormattingContext getFormattingContext();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFormattingContext:")
    public native void setFormattingContext(NSFormattingContext v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "stringFromByteCount:")
    public native String format(long byteCount);
    @Method(selector = "stringFromByteCount:countStyle:")
    public static native String format(long byteCount, NSByteCountFormatterCountStyle countStyle);
    /*</methods>*/
}
