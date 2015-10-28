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
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/NSHashTableOptions/*</name>*/ extends Bits</*<name>*/NSHashTableOptions/*</name>*/> {
    /*<values>*/
    public static final NSHashTableOptions None = new NSHashTableOptions(0L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSHashTableOptions StrongMemory = new NSHashTableOptions(0L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSHashTableOptions CopyIn = new NSHashTableOptions(65536L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSHashTableOptions ObjectPointerPersonality = new NSHashTableOptions(512L);
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final NSHashTableOptions WeakMemory = new NSHashTableOptions(5L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/NSHashTableOptions/*</name>*/[] values = _values(/*<name>*/NSHashTableOptions/*</name>*/.class);

    public /*<name>*/NSHashTableOptions/*</name>*/(long value) { super(value); }
    private /*<name>*/NSHashTableOptions/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/NSHashTableOptions/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/NSHashTableOptions/*</name>*/(value, mask);
    }
    protected /*<name>*/NSHashTableOptions/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/NSHashTableOptions/*</name>*/[] values() {
        return values.clone();
    }
}