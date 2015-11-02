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

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSCharacterSet/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class NSCharacterSetPtr extends Ptr<NSCharacterSet, NSCharacterSetPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSCharacterSet.class); }/*</bind>*/
    /*<constants>*/
    public static final int OpenStepUnicodeReservedBase = 62464;
    /*</constants>*/
    /*<constructors>*/
    public NSCharacterSet() {}
    protected NSCharacterSet(long handle) { super(handle); }
    protected NSCharacterSet(SkipInit skipInit) { super(skipInit); }
    public NSCharacterSet(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    public NSCharacterSet(@ByVal NSRange aRange) { super(create(aRange)); retain(getHandle()); }
    public NSCharacterSet(String aString) { super(create(aString)); retain(getHandle()); }
    public NSCharacterSet(NSData data) { super(create(data)); retain(getHandle()); }
    /*</constructors>*/
    public NSCharacterSet(File file) {
        super(createWithFile(file));
    }
    private static long createWithFile(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }
        return createWithFile(file.getAbsolutePath());
    }
    /*<properties>*/
    @Property(selector = "bitmapRepresentation")
    public native NSData getBitmapRepresentation();
    @Property(selector = "invertedSet")
    public native NSCharacterSet getInvertedSet();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "characterIsMember:")
    public native boolean isMember(short aCharacter);
    @Method(selector = "longCharacterIsMember:")
    public native boolean isMember(int theLongChar);
    @Method(selector = "isSupersetOfSet:")
    public native boolean isSuperset(NSCharacterSet theOtherSet);
    @Method(selector = "hasMemberInPlane:")
    public native boolean hasMemberInPlane(byte thePlane);
    @Method(selector = "controlCharacterSet")
    public static native NSCharacterSet getControlCharacterSet();
    @Method(selector = "whitespaceCharacterSet")
    public static native NSCharacterSet getWhitespaceCharacterSet();
    @Method(selector = "whitespaceAndNewlineCharacterSet")
    public static native NSCharacterSet getWhitespaceAndNewlineCharacterSet();
    @Method(selector = "decimalDigitCharacterSet")
    public static native NSCharacterSet getDecimalDigitCharacterSet();
    @Method(selector = "letterCharacterSet")
    public static native NSCharacterSet getLetterCharacterSet();
    @Method(selector = "lowercaseLetterCharacterSet")
    public static native NSCharacterSet getLowercaseLetterCharacterSet();
    @Method(selector = "uppercaseLetterCharacterSet")
    public static native NSCharacterSet getUppercaseLetterCharacterSet();
    @Method(selector = "nonBaseCharacterSet")
    public static native NSCharacterSet getNonBaseCharacterSet();
    @Method(selector = "alphanumericCharacterSet")
    public static native NSCharacterSet getAlphanumericCharacterSet();
    @Method(selector = "decomposableCharacterSet")
    public static native NSCharacterSet getDecomposableCharacterSet();
    @Method(selector = "illegalCharacterSet")
    public static native NSCharacterSet getIllegalCharacterSet();
    @Method(selector = "punctuationCharacterSet")
    public static native NSCharacterSet getPunctuationCharacterSet();
    @Method(selector = "capitalizedLetterCharacterSet")
    public static native NSCharacterSet getCapitalizedLetterCharacterSet();
    @Method(selector = "symbolCharacterSet")
    public static native NSCharacterSet getSymbolCharacterSet();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Method(selector = "newlineCharacterSet")
    public static native NSCharacterSet getNewlineCharacterSet();
    @Method(selector = "characterSetWithRange:")
    protected static native @Pointer long create(@ByVal NSRange aRange);
    @Method(selector = "characterSetWithCharactersInString:")
    protected static native @Pointer long create(String aString);
    @Method(selector = "characterSetWithBitmapRepresentation:")
    protected static native @Pointer long create(NSData data);
    @Method(selector = "characterSetWithContentsOfFile:")
    private static native @Pointer long createWithFile(String fName);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "URLUserAllowedCharacterSet")
    public static native NSCharacterSet getURLUserAllowedCharacterSet();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "URLPasswordAllowedCharacterSet")
    public static native NSCharacterSet getURLPasswordAllowedCharacterSet();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "URLHostAllowedCharacterSet")
    public static native NSCharacterSet getURLHostAllowedCharacterSet();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "URLPathAllowedCharacterSet")
    public static native NSCharacterSet getURLPathAllowedCharacterSet();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "URLQueryAllowedCharacterSet")
    public static native NSCharacterSet getURLQueryAllowedCharacterSet();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "URLFragmentAllowedCharacterSet")
    public static native NSCharacterSet getURLFragmentAllowedCharacterSet();
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    /*</methods>*/
}
