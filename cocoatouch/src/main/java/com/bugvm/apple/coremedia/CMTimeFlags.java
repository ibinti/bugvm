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
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CMTimeFlags/*</name>*/ extends Bits</*<name>*/CMTimeFlags/*</name>*/> {
    /*<values>*/
    public static final CMTimeFlags None = new CMTimeFlags(0L);
    public static final CMTimeFlags Valid = new CMTimeFlags(1L);
    public static final CMTimeFlags HasBeenRounded = new CMTimeFlags(2L);
    public static final CMTimeFlags PositiveInfinity = new CMTimeFlags(4L);
    public static final CMTimeFlags NegativeInfinity = new CMTimeFlags(8L);
    public static final CMTimeFlags Indefinite = new CMTimeFlags(16L);
    public static final CMTimeFlags ImpliedValueFlagsMask = new CMTimeFlags(28L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/CMTimeFlags/*</name>*/[] values = _values(/*<name>*/CMTimeFlags/*</name>*/.class);

    public /*<name>*/CMTimeFlags/*</name>*/(long value) { super(value); }
    private /*<name>*/CMTimeFlags/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CMTimeFlags/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CMTimeFlags/*</name>*/(value, mask);
    }
    protected /*<name>*/CMTimeFlags/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CMTimeFlags/*</name>*/[] values() {
        return values.clone();
    }
}
