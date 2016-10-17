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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMutableCharacterSet/*</name>*/ 
    extends /*<extends>*/NSCharacterSet/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSMutableCharacterSetPtr extends Ptr<NSMutableCharacterSet, NSMutableCharacterSetPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSMutableCharacterSet.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMutableCharacterSet() {}
    protected NSMutableCharacterSet(SkipInit skipInit) { super(skipInit); }
    public NSMutableCharacterSet(@ByVal NSRange aRange) { super(create(aRange)); retain(getHandle()); }
    public NSMutableCharacterSet(String aString) { super(create(aString)); retain(getHandle()); }
    public NSMutableCharacterSet(NSData data) { super(create(data)); retain(getHandle()); }
    /*</constructors>*/
    public NSMutableCharacterSet(File file) {
        super(createWithFile(file));
        retain(getHandle());
    }
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    private static long createWithFile(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }
        return createWithFile(file.getAbsolutePath());
    }
    /*<methods>*/
    @Method(selector = "addCharactersInRange:")
    public native void addCharacters(@ByVal NSRange aRange);
    @Method(selector = "removeCharactersInRange:")
    public native void removeCharacters(@ByVal NSRange aRange);
    @Method(selector = "addCharactersInString:")
    public native void addCharacters(String aString);
    @Method(selector = "removeCharactersInString:")
    public native void removeCharacters(String aString);
    @Method(selector = "formUnionWithCharacterSet:")
    public native void formUnion(NSCharacterSet otherSet);
    @Method(selector = "formIntersectionWithCharacterSet:")
    public native void formIntersection(NSCharacterSet otherSet);
    @Method(selector = "invert")
    public native void invert();
    @Method(selector = "controlCharacterSet")
    public static native NSMutableCharacterSet getControlCharacterSet();
    @Method(selector = "whitespaceCharacterSet")
    public static native NSMutableCharacterSet getWhitespaceCharacterSet();
    @Method(selector = "whitespaceAndNewlineCharacterSet")
    public static native NSMutableCharacterSet getWhitespaceAndNewlineCharacterSet();
    @Method(selector = "decimalDigitCharacterSet")
    public static native NSMutableCharacterSet getDecimalDigitCharacterSet();
    @Method(selector = "letterCharacterSet")
    public static native NSMutableCharacterSet getLetterCharacterSet();
    @Method(selector = "lowercaseLetterCharacterSet")
    public static native NSMutableCharacterSet getLowercaseLetterCharacterSet();
    @Method(selector = "uppercaseLetterCharacterSet")
    public static native NSMutableCharacterSet getUppercaseLetterCharacterSet();
    @Method(selector = "nonBaseCharacterSet")
    public static native NSMutableCharacterSet getNonBaseCharacterSet();
    @Method(selector = "alphanumericCharacterSet")
    public static native NSMutableCharacterSet getAlphanumericCharacterSet();
    @Method(selector = "decomposableCharacterSet")
    public static native NSMutableCharacterSet getDecomposableCharacterSet();
    @Method(selector = "illegalCharacterSet")
    public static native NSMutableCharacterSet getIllegalCharacterSet();
    @Method(selector = "punctuationCharacterSet")
    public static native NSMutableCharacterSet getPunctuationCharacterSet();
    @Method(selector = "capitalizedLetterCharacterSet")
    public static native NSMutableCharacterSet getCapitalizedLetterCharacterSet();
    @Method(selector = "symbolCharacterSet")
    public static native NSMutableCharacterSet getSymbolCharacterSet();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Method(selector = "newlineCharacterSet")
    public static native NSMutableCharacterSet getNewlineCharacterSet();
    @Method(selector = "characterSetWithRange:")
    protected static native @Pointer long create(@ByVal NSRange aRange);
    @Method(selector = "characterSetWithCharactersInString:")
    protected static native @Pointer long create(String aString);
    @Method(selector = "characterSetWithBitmapRepresentation:")
    protected static native @Pointer long create(NSData data);
    @Method(selector = "characterSetWithContentsOfFile:")
    private static native @Pointer long createWithFile(String fName);
    /*</methods>*/
}
