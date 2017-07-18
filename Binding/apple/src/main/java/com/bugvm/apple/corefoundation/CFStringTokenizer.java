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
/*<annotations>*/@Library("CoreFoundation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFStringTokenizer/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFStringTokenizerPtr extends Ptr<CFStringTokenizer, CFStringTokenizerPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFStringTokenizer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFStringTokenizer() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    public static CFStringTokenizer create(String string, @ByVal CFRange range, CFStringTokenizerUnitOptions options, CFLocale locale) {
        return create(null, string, range, options, locale);
    }
    /**
     * @since Available in iOS 3.0 and later.
     */
    public CFRange[] getCurrentSubTokens(long maxRanges, List<String> derivedSubTokens) {
        CFRange.CFRangePtr ptr = new CFRange.CFRangePtr();
        long length = getCurrentSubTokens(ptr, maxRanges, derivedSubTokens);
        return ptr.get().toArray((int)length);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerCopyBestStringLanguage", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFString.AsStringNoRetainMarshaler.class) String getBestStringLanguage(String string, @ByVal CFRange range);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerCreate", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFStringTokenizer create(CFAllocator alloc, String string, @ByVal CFRange range, CFStringTokenizerUnitOptions options, CFLocale locale);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerSetString", optional=true)
    public native void setString(String string, @ByVal CFRange range);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerGoToTokenAtIndex", optional=true)
    public native CFStringTokenizerTokenType goToToken(@MachineSizedSInt long index);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerAdvanceToNextToken", optional=true)
    public native CFStringTokenizerTokenType advanceToNextToken();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerGetCurrentTokenRange", optional=true)
    public native @ByVal CFRange getCurrentTokenRange();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerCopyCurrentTokenAttribute", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFType getCurrentTokenAttribute(CFStringTokenizerUnitOptions attribute);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="CFStringTokenizerGetCurrentSubTokens", optional=true)
    protected native @MachineSizedSInt long getCurrentSubTokens(CFRange.CFRangePtr ranges, @MachineSizedSInt long maxRangeLength, @com.bugvm.rt.bro.annotation.Marshaler(CFArray.AsStringListMarshaler.class) List<String> derivedSubTokens);
    /*</methods>*/
}
