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
package com.bugvm.apple.coreanimation;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("QuartzCore") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CATextLayer/*</name>*/ 
    extends /*<extends>*/CALayer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CATextLayerPtr extends Ptr<CATextLayer, CATextLayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CATextLayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CATextLayer() {}
    protected CATextLayer(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "string")
    protected native @Pointer long getStringPtr();
    @Property(selector = "setString:")
    protected native void setStringPtr(@Pointer long v);
    @Property(selector = "font")
    protected native @Pointer long getFontPtr();
    @Property(selector = "setFont:")
    protected native void setFontPtr(@Pointer long v);
    @Property(selector = "fontSize")
    public native @MachineSizedFloat double getFontSize();
    @Property(selector = "setFontSize:")
    public native void setFontSize(@MachineSizedFloat double v);
    @Property(selector = "foregroundColor")
    public native CGColor getForegroundColor();
    @Property(selector = "setForegroundColor:")
    public native void setForegroundColor(CGColor v);
    @Property(selector = "isWrapped")
    public native boolean isWrapped();
    @Property(selector = "setWrapped:")
    public native void setWrapped(boolean v);
    @Property(selector = "truncationMode")
    public native CATextTruncationMode getTruncationMode();
    @Property(selector = "setTruncationMode:")
    public native void setTruncationMode(CATextTruncationMode v);
    @Property(selector = "alignmentMode")
    public native CATextAlignmentMode getAlignmentMode();
    @Property(selector = "setAlignmentMode:")
    public native void setAlignmentMode(CATextAlignmentMode v);
    @Property(selector = "allowsFontSubpixelQuantization")
    public native boolean allowsFontSubpixelQuantization();
    @Property(selector = "setAllowsFontSubpixelQuantization:")
    public native void setAllowsFontSubpixelQuantization(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/

    // String is either an NSString, or an NSAttributedString
    public Object getString() {
        long ptr = getStringPtr();
        if (ptr == 0) {
            return null;
        }
        NSObject obj = NSObject.Marshaler.toObject(NSObject.class, ptr, 0);
        if (obj instanceof NSString) {
            return obj.toString();
        }
        return obj;
    }
    public void setString(String string) {
        setStringPtr(new NSString(string).getHandle());
    }
    public void setString(NSAttributedString string) {
        setStringPtr(string.getHandle());
    }
    // Font is either a CTFontRef, a CGFontRef, an instance of NSFont (OS X only), or an NSString naming the font.
    /**
     * Returns the value of the {@code font} property. Either a  {@link CTFont},
     * {@link CGFont} or {@link String}.
     */
    public Object getFont() {
        long ptr = getFontPtr();
        if (ptr == 0) {
            return null;
        }
        com.bugvm.apple.corefoundation.CFType cfObj =
                com.bugvm.apple.corefoundation.CFType.Marshaler.toObject(
                        com.bugvm.apple.corefoundation.CFType.class, ptr, 0);
        if (cfObj instanceof com.bugvm.apple.corefoundation.CFString) {
            return cfObj.toString();
        }
        return cfObj;
    }
    @WeaklyLinked
    public void setFont(CTFont font) {
        setFontPtr(font.getHandle());
    }
    public void setFont(CGFont font) {
        setFontPtr(font.getHandle());
    }
    public void setFont(String font) {
        setFontPtr(new NSString(font).getHandle());
    }

    /*<methods>*/
    
    /*</methods>*/
}
