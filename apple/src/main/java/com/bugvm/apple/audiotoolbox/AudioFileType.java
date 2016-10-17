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
package com.bugvm.apple.audiotoolbox;

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
import com.bugvm.apple.audiounit.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremidi.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedUIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/AudioFileType/*</name>*/ implements ValuedEnum {
    /*<values>*/
    AIFF(1095321158L),
    AIFC(1095321155L),
    WAVE(1463899717L),
    SoundDesigner2(1399075430L),
    Next(1315264596L),
    MP3(1297106739L),
    MP2(1297106738L),
    MP1(1297106737L),
    AC3(1633889587L),
    AAC_ADTS(1633973363L),
    MPEG4(1836069990L),
    M4A(1832149350L),
    M4B(1832149606L),
    CAF(1667327590L),
    _3GP(862417008L),
    _3GP2(862416946L),
    AMR(1634562662L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/AudioFileType/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/AudioFileType/*</name>*/ valueOf(long n) {
        for (/*<name>*/AudioFileType/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/AudioFileType/*</name>*/.class.getName());
    }
}
