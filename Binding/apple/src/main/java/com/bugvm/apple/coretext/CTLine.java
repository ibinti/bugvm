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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CTLine/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<?> toObject(Class<? extends CFType> cls, long handle, long flags) {
            CFArray o = (CFArray) CFType.Marshaler.toObject(CFArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            return o.toList(CTLine.class);
        }
        @MarshalsPointer
        public static long toNative(List<? extends CFType> l, long flags) {
            if (l == null) {
                return 0L;
            }
            CFArray o = null;
            if (l instanceof CFArray) {
                o = (CFArray) l;
            } else {
                o = CFArray.create((List<? extends CFType>) l);
            }
            return CFType.Marshaler.toNative(o, flags);
        }
    }
    
    /*<ptr>*/public static class CTLinePtr extends Ptr<CTLine, CTLinePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CTLine.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CTLine() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
    * @since Available in iOS 3.2 and later.
    */
    public @MachineSizedFloat double getWidth() {
        return getTypographicBounds(null, null, null);
    }
    /**
    * @since Available in iOS 3.2 and later.
    */
    public @MachineSizedFloat double getAscent() {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
         getTypographicBounds(ptr, null, null);
        return ptr.get();
    }
    /**
    * @since Available in iOS 3.2 and later.
    */
    public @MachineSizedFloat double getDescent() {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
        getTypographicBounds(null, ptr, null);         
        return ptr.get();
    }
    /**
    * @since Available in iOS 3.2 and later.
    */
    public @MachineSizedFloat double getLeading() {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
        getTypographicBounds(null, null, ptr);
        return ptr.get();
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public @MachineSizedFloat double getPrimaryOffset(@MachineSizedSInt long charIndex) {
        return getOffset(charIndex, null);
    }
    /**
     * @since Available in iOS 3.2 and later.
     */
    public @MachineSizedFloat double getSecondaryOffset(@MachineSizedSInt long charIndex) {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
        getOffset(charIndex, ptr);
        return ptr.get();
    }
    /*<methods>*/
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineCreateWithAttributedString", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTLine create(NSAttributedString string);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineCreateTruncatedLine", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTLine createTruncatedLine(double width, CTLineTruncationType truncationType, CTLine truncationToken);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineCreateJustifiedLine", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CTLine createJustifiedLine(@MachineSizedFloat double justificationFactor, double justificationWidth);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetGlyphCount", optional=true)
    public native @MachineSizedSInt long getGlyphCount();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetGlyphRuns", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CTRun.AsListMarshaler.class) List<CTRun> getGlyphRuns();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetStringRange", optional=true)
    public native @ByVal CFRange getStringRange();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetPenOffsetForFlush", optional=true)
    public native double getPenOffset(@MachineSizedFloat double flushFactor, double flushWidth);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineDraw", optional=true)
    public native void draw(CGContext context);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetTypographicBounds", optional=true)
    protected native double getTypographicBounds(MachineSizedFloatPtr ascent, MachineSizedFloatPtr descent, MachineSizedFloatPtr leading);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Bridge(symbol="CTLineGetBoundsWithOptions", optional=true)
    public native @ByVal CGRect getBounds(CTLineBoundsOptions options);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetTrailingWhitespaceWidth", optional=true)
    public native double getTrailingWhitespaceWidth();
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetImageBounds", optional=true)
    public native @ByVal CGRect getImageBounds(CGContext context);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetStringIndexForPosition", optional=true)
    public native @MachineSizedSInt long getStringIndex(@ByVal CGPoint position);
    /**
     * @since Available in iOS 3.2 and later.
     */
    @Bridge(symbol="CTLineGetOffsetForStringIndex", optional=true)
    protected native @MachineSizedFloat double getOffset(@MachineSizedSInt long charIndex, MachineSizedFloatPtr secondaryOffset);
    /*</methods>*/
}
