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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/UIViewContentMode/*</name>*/ implements ValuedEnum {
    /*<values>*/
    ScaleToFill(0L),
    ScaleAspectFit(1L),
    ScaleAspectFill(2L),
    Redraw(3L),
    Center(4L),
    Top(5L),
    Bottom(6L),
    Left(7L),
    Right(8L),
    TopLeft(9L),
    TopRight(10L),
    BottomLeft(11L),
    BottomRight(12L);
    /*</values>*/

    private final long n;

    private /*<name>*/UIViewContentMode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/UIViewContentMode/*</name>*/ valueOf(long n) {
        for (/*<name>*/UIViewContentMode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/UIViewContentMode/*</name>*/.class.getName());
    }
}
