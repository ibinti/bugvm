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
package com.bugvm.apple.assetslibrary;

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
import com.bugvm.apple.imageio.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 6.0 and later.
 * @deprecated Deprecated in iOS 9.0.
 */
@Deprecated
/*</javadoc>*/
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/ALAuthorizationStatus/*</name>*/ implements ValuedEnum {
    /*<values>*/
    /**
     * @since Available in iOS 6.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    NotDetermined(0L),
    /**
     * @since Available in iOS 6.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    Restricted(1L),
    /**
     * @since Available in iOS 6.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    Denied(2L),
    /**
     * @since Available in iOS 6.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    Authorized(3L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/ALAuthorizationStatus/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/ALAuthorizationStatus/*</name>*/ valueOf(long n) {
        for (/*<name>*/ALAuthorizationStatus/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/ALAuthorizationStatus/*</name>*/.class.getName());
    }
}
