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
public final class /*<name>*/AUScheduledAudioSliceFlags/*</name>*/ extends Bits</*<name>*/AUScheduledAudioSliceFlags/*</name>*/> {
    /*<values>*/
    public static final AUScheduledAudioSliceFlags None = new AUScheduledAudioSliceFlags(0L);
    public static final AUScheduledAudioSliceFlags Complete = new AUScheduledAudioSliceFlags(1L);
    public static final AUScheduledAudioSliceFlags BeganToRender = new AUScheduledAudioSliceFlags(2L);
    public static final AUScheduledAudioSliceFlags BeganToRenderLate = new AUScheduledAudioSliceFlags(4L);
    public static final AUScheduledAudioSliceFlags Loop = new AUScheduledAudioSliceFlags(8L);
    public static final AUScheduledAudioSliceFlags Interrupt = new AUScheduledAudioSliceFlags(16L);
    public static final AUScheduledAudioSliceFlags InterruptAtLoop = new AUScheduledAudioSliceFlags(32L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/AUScheduledAudioSliceFlags/*</name>*/[] values = _values(/*<name>*/AUScheduledAudioSliceFlags/*</name>*/.class);

    public /*<name>*/AUScheduledAudioSliceFlags/*</name>*/(long value) { super(value); }
    private /*<name>*/AUScheduledAudioSliceFlags/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/AUScheduledAudioSliceFlags/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/AUScheduledAudioSliceFlags/*</name>*/(value, mask);
    }
    protected /*<name>*/AUScheduledAudioSliceFlags/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/AUScheduledAudioSliceFlags/*</name>*/[] values() {
        return values.clone();
    }
}
