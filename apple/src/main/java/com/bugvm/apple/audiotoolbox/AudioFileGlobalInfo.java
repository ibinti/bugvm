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
public enum /*<name>*/AudioFileGlobalInfo/*</name>*/ implements ValuedEnum {
    /*<values>*/
    ReadableTypes(1634103910L),
    WritableTypes(1634105190L),
    FileTypeName(1718906477L),
    AvailableStreamDescriptionsForFormat(1935960420L),
    AvailableFormatIDs(1718446436L),
    AllExtensions(1634498676L),
    AllHFSTypeCodes(1634231923L),
    AllUTIs(1635087465L),
    AllMIMETypes(1634560365L),
    ExtensionsForType(1717926004L),
    HFSTypeCodesForType(1718118003L),
    UTIsForType(1718973545L),
    MIMETypesForType(1718446445L),
    TypesForMIMEType(1953327469L),
    TypesForUTI(1953854569L),
    TypesForHFSTypeCode(1952999027L),
    TypesForExtension(1952807028L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/AudioFileGlobalInfo/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/AudioFileGlobalInfo/*</name>*/ valueOf(long n) {
        for (/*<name>*/AudioFileGlobalInfo/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/AudioFileGlobalInfo/*</name>*/.class.getName());
    }
}
