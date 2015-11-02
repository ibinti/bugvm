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
package com.bugvm.apple.audiounit;

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
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public enum /*<name>*/AUParameterMIDI/*</name>*/ implements AUParameterType {
    /*<values>*/
    Volume(7L),
    Sustain(64L),
    Sostenuto(66L),
    AllNotesOff(123L),
    ModWheel(1L),
    PitchBend(224L),
    AllSoundOff(120L),
    ResetAllControllers(121L),
    Pan(10L),
    Foot(4L),
    ChannelPressure(208L),
    KeyPressure(160L),
    Expression(11L),
    DataEntry(6L),
    Volume_LSB(39L),
    ModWheel_LSB(33L),
    Pan_LSB(42L),
    Foot_LSB(36L),
    Expression_LSB(43L),
    DataEntry_LSB(38L),
    KeyPressure_FirstKey(256L),
    KeyPressure_LastKey(383L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/AUParameterMIDI/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/AUParameterMIDI/*</name>*/ valueOf(long n) {
        for (/*<name>*/AUParameterMIDI/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/AUParameterMIDI/*</name>*/.class.getName());
    }
}
