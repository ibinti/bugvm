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
package com.bugvm.apple.coreanimation;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public final class /*<name>*/CAEdgeAntialiasingMask/*</name>*/ extends Bits</*<name>*/CAEdgeAntialiasingMask/*</name>*/> {
    /*<values>*/
    public static final CAEdgeAntialiasingMask None = new CAEdgeAntialiasingMask(0L);
    public static final CAEdgeAntialiasingMask LeftEdge = new CAEdgeAntialiasingMask(1L);
    public static final CAEdgeAntialiasingMask RightEdge = new CAEdgeAntialiasingMask(2L);
    public static final CAEdgeAntialiasingMask BottomEdge = new CAEdgeAntialiasingMask(4L);
    public static final CAEdgeAntialiasingMask TopEdge = new CAEdgeAntialiasingMask(8L);
    /*</values>*/

    private static final /*<name>*/CAEdgeAntialiasingMask/*</name>*/[] values = _values(/*<name>*/CAEdgeAntialiasingMask/*</name>*/.class);

    public /*<name>*/CAEdgeAntialiasingMask/*</name>*/(long value) { super(value); }
    private /*<name>*/CAEdgeAntialiasingMask/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CAEdgeAntialiasingMask/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CAEdgeAntialiasingMask/*</name>*/(value, mask);
    }
    protected /*<name>*/CAEdgeAntialiasingMask/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CAEdgeAntialiasingMask/*</name>*/[] values() {
        return values.clone();
    }
}
