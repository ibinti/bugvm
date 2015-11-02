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
package com.bugvm.apple.mediaplayer;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/MPMovieLoadState/*</name>*/ extends Bits</*<name>*/MPMovieLoadState/*</name>*/> {
    /*<values>*/
    public static final MPMovieLoadState None = new MPMovieLoadState(0L);
    public static final MPMovieLoadState Unknown = new MPMovieLoadState(0L);
    public static final MPMovieLoadState Playable = new MPMovieLoadState(1L);
    public static final MPMovieLoadState PlaythroughOK = new MPMovieLoadState(2L);
    public static final MPMovieLoadState Stalled = new MPMovieLoadState(4L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/MPMovieLoadState/*</name>*/[] values = _values(/*<name>*/MPMovieLoadState/*</name>*/.class);

    public /*<name>*/MPMovieLoadState/*</name>*/(long value) { super(value); }
    private /*<name>*/MPMovieLoadState/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/MPMovieLoadState/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/MPMovieLoadState/*</name>*/(value, mask);
    }
    protected /*<name>*/MPMovieLoadState/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/MPMovieLoadState/*</name>*/[] values() {
        return values.clone();
    }
}
