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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/NSFileWrapperWritingOptions/*</name>*/ extends Bits</*<name>*/NSFileWrapperWritingOptions/*</name>*/> {
    /*<values>*/
    public static final NSFileWrapperWritingOptions None = new NSFileWrapperWritingOptions(0L);
    public static final NSFileWrapperWritingOptions Atomic = new NSFileWrapperWritingOptions(1L);
    public static final NSFileWrapperWritingOptions WithNameUpdating = new NSFileWrapperWritingOptions(2L);
    /*</values>*/

    private static final /*<name>*/NSFileWrapperWritingOptions/*</name>*/[] values = _values(/*<name>*/NSFileWrapperWritingOptions/*</name>*/.class);

    public /*<name>*/NSFileWrapperWritingOptions/*</name>*/(long value) { super(value); }
    private /*<name>*/NSFileWrapperWritingOptions/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/NSFileWrapperWritingOptions/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/NSFileWrapperWritingOptions/*</name>*/(value, mask);
    }
    protected /*<name>*/NSFileWrapperWritingOptions/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/NSFileWrapperWritingOptions/*</name>*/[] values() {
        return values.clone();
    }
}
