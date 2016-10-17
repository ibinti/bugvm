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
public enum /*<name>*/CAFChunkType/*</name>*/ implements ValuedEnum {
    /*<values>*/
    StreamDescriptionChunkID(1684370275L),
    AudioDataChunkID(1684108385L),
    ChannelLayoutChunkID(1667785070L),
    FillerChunkID(1718773093L),
    MarkerChunkID(1835102827L),
    RegionChunkID(1919248238L),
    InstrumentChunkID(1768846196L),
    MagicCookieID(1802857321L),
    InfoStringsChunkID(1768842863L),
    EditCommentsChunkID(1701077876L),
    PacketTableChunkID(1885432692L),
    StringsChunkID(1937011303L),
    UUIDChunkID(1970628964L),
    PeakChunkID(1885692267L),
    OverviewChunkID(1870034551L),
    MIDIChunkID(1835623529L),
    UMIDChunkID(1970104676L),
    FormatListID(1818522467L),
    iXMLChunkID(1767394636L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/CAFChunkType/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/CAFChunkType/*</name>*/ valueOf(long n) {
        for (/*<name>*/CAFChunkType/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/CAFChunkType/*</name>*/.class.getName());
    }
}
