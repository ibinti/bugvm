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
package com.bugvm.apple.watchconnectivity;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)/*</annotations>*/
@ForceLinkClass(WCError.class)
public enum /*<name>*/WCErrorCode/*</name>*/ implements NSErrorCode {
    /*<values>*/
    GenericError(7001L),
    SessionNotSupported(7002L),
    SessionMissingDelegate(7003L),
    SessionNotActivated(7004L),
    DeviceNotPaired(7005L),
    WatchAppNotInstalled(7006L),
    NotReachable(7007L),
    InvalidParameter(7008L),
    PayloadTooLarge(7009L),
    PayloadUnsupportedTypes(7010L),
    MessageReplyFailed(7011L),
    MessageReplyTimedOut(7012L),
    FileAccessDenied(7013L),
    DeliveryFailed(7014L),
    InsufficientSpace(7015L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/WCErrorCode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/WCErrorCode/*</name>*/ valueOf(long n) {
        for (/*<name>*/WCErrorCode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/WCErrorCode/*</name>*/.class.getName());
    }
}
