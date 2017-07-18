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
package com.bugvm.apple.security;

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
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public enum /*<name>*/SSLSessionOption/*</name>*/ implements ValuedEnum {
    /*<values>*/
    BreakOnServerAuth(0L),
    BreakOnCertRequested(1L),
    BreakOnClientAuth(2L),
    FalseStart(3L),
    SendOneByteRecord(4L),
    AllowServerIdentityChange(5L),
    Fallback(6L),
    BreakOnClientHello(7L);
    /*</values>*/

    private final long n;

    private /*<name>*/SSLSessionOption/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/SSLSessionOption/*</name>*/ valueOf(long n) {
        for (/*<name>*/SSLSessionOption/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/SSLSessionOption/*</name>*/.class.getName());
    }
}
