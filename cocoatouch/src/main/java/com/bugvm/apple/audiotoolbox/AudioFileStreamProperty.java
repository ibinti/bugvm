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
public enum /*<name>*/AudioFileStreamProperty/*</name>*/ implements ValuedEnum {
    /*<values>*/
    ReadyToProducePackets(1919247481L),
    FileFormat(1717988724L),
    DataFormat(1684434292L),
    FormatList(1718383476L),
    MagicCookieData(1835493731L),
    AudioDataByteCount(1650683508L),
    AudioDataPacketCount(1885564532L),
    MaximumPacketSize(1886616165L),
    DataOffset(1685022310L),
    ChannelLayout(1668112752L),
    PacketToFrame(1886086770L),
    FrameToPacket(1718775915L),
    PacketToByte(1886085753L),
    ByteToPacket(1652125803L),
    PacketTableInfo(1886283375L),
    PacketSizeUpperBound(1886090594L),
    AverageBytesPerPacket(1633841264L),
    BitRate(1651663220L),
    InfoDictionary(1768842863L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/AudioFileStreamProperty/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/AudioFileStreamProperty/*</name>*/ valueOf(long n) {
        for (/*<name>*/AudioFileStreamProperty/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/AudioFileStreamProperty/*</name>*/.class.getName());
    }
}
