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
package com.bugvm.apple.coretext;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreText")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CTTypesetter/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CTTypesetterPtr extends Ptr<CTTypesetter, CTTypesetterPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CTTypesetter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CTTypesetter() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterCreateWithAttributedString", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTTypesetter create(NSAttributedString string);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterCreateWithAttributedStringAndOptions", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTTypesetter create(NSAttributedString string, CTTypesetterOptions options);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterCreateLineWithOffset", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTLine createLine(@ByVal CFRange stringRange, double offset);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterCreateLine", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTLine createLine(@ByVal CFRange stringRange);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterSuggestLineBreakWithOffset", optional=true)
    public native @MachineSizedSInt long suggestLineBreak(@MachineSizedSInt long startIndex, double width, double offset);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterSuggestLineBreak", optional=true)
    public native @MachineSizedSInt long suggestLineBreak(@MachineSizedSInt long startIndex, double width);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterSuggestClusterBreakWithOffset", optional=true)
    public native @MachineSizedSInt long suggestClusterBreak(@MachineSizedSInt long startIndex, double width, double offset);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTTypesetterSuggestClusterBreak", optional=true)
    public native @MachineSizedSInt long suggestClusterBreak(@MachineSizedSInt long startIndex, double width);
    /*</methods>*/
}
