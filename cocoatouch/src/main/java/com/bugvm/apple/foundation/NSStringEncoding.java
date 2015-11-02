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
/*<annotations>*//*</annotations>*/
public enum /*<name>*/NSStringEncoding/*</name>*/ implements ValuedEnum {
    /*<values>*/
    ASCII(1L),
    NEXTSTEP(2L),
    JapaneseEUC(3L),
    UTF8(4L),
    ISOLatin1(5L),
    Symbol(6L),
    NonLossyASCII(7L),
    ShiftJIS(8L),
    ISOLatin2(9L),
    Unicode(10L),
    WindowsCP1251(11L),
    WindowsCP1252(12L),
    WindowsCP1253(13L),
    WindowsCP1254(14L),
    WindowsCP1250(15L),
    ISO2022JP(21L),
    MacOSRoman(30L),
    UTF16(10L),
    UTF16BigEndian(2415919360L),
    UTF16LittleEndian(2483028224L),
    UTF32(2348810496L),
    UTF32BigEndian(2550137088L),
    UTF32LittleEndian(2617245952L),
    Proprietary(65536L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/NSStringEncoding/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/NSStringEncoding/*</name>*/ valueOf(long n) {
        for (/*<name>*/NSStringEncoding/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/NSStringEncoding/*</name>*/.class.getName());
    }
}
