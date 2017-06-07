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
package com.bugvm.apple.coremedia;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.audiotoolbox.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedUIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/CMPixelFormatType/*</name>*/ implements ValuedEnum {
    /*<values>*/
    _32ARGB(32L),
    _32BGRA(1111970369L),
    _24RGB(24L),
    _16BE555(16L),
    _16BE565(1110783541L),
    _16LE555(1278555445L),
    _16LE565(1278555701L),
    _16LE5551(892679473L),
    _422YpCbCr8(846624121L),
    _422YpCbCr8_yuvs(2037741171L),
    _444YpCbCr8(1983066168L),
    _4444YpCbCrA8(1983131704L),
    _422YpCbCr16(1983000886L),
    _422YpCbCr10(1983000880L),
    _444YpCbCr10(1983131952L),
    _8IndexedGray_WhiteIsZero(40L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/CMPixelFormatType/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/CMPixelFormatType/*</name>*/ valueOf(long n) {
        for (/*<name>*/CMPixelFormatType/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/CMPixelFormatType/*</name>*/.class.getName());
    }
}
