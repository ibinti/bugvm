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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CTFramesetter/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CTFramesetterPtr extends Ptr<CTFramesetter, CTFramesetterPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CTFramesetter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CTFramesetter() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFramesetterGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFramesetterCreateWithAttributedString", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTFramesetter create(NSAttributedString string);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFramesetterCreateFrame", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTFrame createFrame(@ByVal CFRange stringRange, CGPath path, CTFrameAttributes frameAttributes);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFramesetterGetTypesetter", optional=true)
    public native CTTypesetter getTypesetter();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFramesetterSuggestFrameSizeWithConstraints", optional=true)
    public native @ByVal CGSize suggestFrameSize(@ByVal CFRange stringRange, CTFrameAttributes frameAttributes, @ByVal CGSize constraints, CFRange fitRange);
    /*</methods>*/
}
