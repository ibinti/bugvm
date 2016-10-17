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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreFoundation") @WeaklyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFMutableAttributedString/*</name>*/ 
    extends /*<extends>*/CFAttributedString/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFMutableAttributedStringPtr extends Ptr<CFMutableAttributedString, CFMutableAttributedStringPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFMutableAttributedString.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    protected CFMutableAttributedString() {}
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static CFMutableAttributedString createCopy(@MachineSizedSInt long maxLength, CFAttributedString aStr) {
        return createCopy(null, maxLength, aStr);
    }
    public static CFMutableAttributedString create(@MachineSizedSInt long maxLength) {
        return create(null, maxLength);
    }
    @WeaklyLinked
    public void setAttributes(@ByVal CFRange range, NSAttributedStringAttributes replacement, boolean clearOtherAttributes) {
        if (replacement == null) {
            setAttributesDictionary(range, null, clearOtherAttributes);
        } else {
            setAttributesDictionary(range, replacement.getDictionary().as(CFDictionary.class), clearOtherAttributes);
        }
    }
    @WeaklyLinked
    public void setAttributes(@ByVal CFRange range, CMTextMarkupAttributes replacement, boolean clearOtherAttributes) {
        if (replacement == null) {
            setAttributesDictionary(range, null, clearOtherAttributes);
        } else {
            setAttributesDictionary(range, replacement.getDictionary(), clearOtherAttributes);
        }
    }
    @WeaklyLinked
    public void setAttribute(@ByVal CFRange range, NSAttributedStringAttribute attribute, CFType value) {
        if (attribute == null) {
            throw new NullPointerException("attribute");
        }
        setAttribute(range, attribute.value().as(CFString.class), value);
    }
    @WeaklyLinked
    public void setAttribute(@ByVal CFRange range, CMTextMarkupAttribute attribute, CFType value) {
        if (attribute == null) {
            throw new NullPointerException("attribute");
        }
        setAttribute(range, attribute.value(), value);
    }
    @WeaklyLinked
    public void removeAttribute(@ByVal CFRange range, NSAttributedStringAttribute attribute) {
        if (attribute == null) {
            throw new NullPointerException("attribute");
        }
        removeAttribute(range, attribute.value().as(CFString.class));
    }
    @WeaklyLinked
    public void removeAttribute(@ByVal CFRange range, CMTextMarkupAttribute attribute) {
        if (attribute == null) {
            throw new NullPointerException("attribute");
        }
        removeAttribute(range, attribute.value());
    }
    /*<methods>*/
    @Bridge(symbol="CFAttributedStringCreateMutableCopy", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFMutableAttributedString createCopy(CFAllocator alloc, @MachineSizedSInt long maxLength, CFAttributedString aStr);
    @Bridge(symbol="CFAttributedStringCreateMutable", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFMutableAttributedString create(CFAllocator alloc, @MachineSizedSInt long maxLength);
    @Bridge(symbol="CFAttributedStringReplaceString", optional=true)
    public native void replaceString(@ByVal CFRange range, String replacement);
    @Bridge(symbol="CFAttributedStringGetMutableString", optional=true)
    public static native CFMutableString getMutableString(CFAttributedString aStr);
    @Bridge(symbol="CFAttributedStringSetAttributes", optional=true)
    public native void setAttributesDictionary(@ByVal CFRange range, CFDictionary replacement, boolean clearOtherAttributes);
    @Bridge(symbol="CFAttributedStringSetAttribute", optional=true)
    public native void setAttribute(@ByVal CFRange range, CFString attrName, CFType value);
    @Bridge(symbol="CFAttributedStringRemoveAttribute", optional=true)
    public native void removeAttribute(@ByVal CFRange range, CFString attrName);
    @Bridge(symbol="CFAttributedStringReplaceAttributedString", optional=true)
    public native void replaceAttributedString(@ByVal CFRange range, CFAttributedString replacement);
    @Bridge(symbol="CFAttributedStringBeginEditing", optional=true)
    public native void beginEditing();
    @Bridge(symbol="CFAttributedStringEndEditing", optional=true)
    public native void endEditing();
    /*</methods>*/
}
