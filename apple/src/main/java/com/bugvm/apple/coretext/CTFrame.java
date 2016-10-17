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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CTFrame/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CTFramePtr extends Ptr<CTFrame, CTFramePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CTFrame.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CTFrame() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 3.2 and later.
     */
    public CGPoint[] getLineOrigins(CFRange range) {
        if (range == null) throw new NullPointerException("range");
        int size = range.getLength() == 0 ? getLines().size() : (int)range.getLength();
        if (size == 0) {
            return new CGPoint[0];
        }
        CGPoint array = Struct.allocate(CGPoint.class, size);
        getLineOrigins(range, array);
        return array.toArray(size);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameGetStringRange", optional=true)
    public native @ByVal CFRange getStringRange();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameGetVisibleStringRange", optional=true)
    public native @ByVal CFRange getVisibleStringRange();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameGetPath", optional=true)
    public native CGPath getPath();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameGetFrameAttributes", optional=true)
    public native CTFrameAttributes getFrameAttributes();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameGetLines", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CTLine.AsListMarshaler.class) List<CTLine> getLines();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameGetLineOrigins", optional=true)
    protected native void getLineOrigins(@ByVal CFRange range, CGPoint origins);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTFrameDraw", optional=true)
    public native void draw(CGContext context);
    /*</methods>*/
}
