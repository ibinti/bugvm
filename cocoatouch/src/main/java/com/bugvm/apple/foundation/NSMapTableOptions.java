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

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/NSMapTableOptions/*</name>*/ extends Bits</*<name>*/NSMapTableOptions/*</name>*/> {
    /*<values>*/
    public static final NSMapTableOptions None = new NSMapTableOptions(0L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSMapTableOptions StrongMemory = new NSMapTableOptions(0L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSMapTableOptions CopyIn = new NSMapTableOptions(65536L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSMapTableOptions ObjectPointerPersonality = new NSMapTableOptions(512L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSMapTableOptions WeakMemory = new NSMapTableOptions(5L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/NSMapTableOptions/*</name>*/[] values = _values(/*<name>*/NSMapTableOptions/*</name>*/.class);

    public /*<name>*/NSMapTableOptions/*</name>*/(long value) { super(value); }
    private /*<name>*/NSMapTableOptions/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/NSMapTableOptions/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/NSMapTableOptions/*</name>*/(value, mask);
    }
    protected /*<name>*/NSMapTableOptions/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/NSMapTableOptions/*</name>*/[] values() {
        return values.clone();
    }
}
