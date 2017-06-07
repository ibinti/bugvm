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
package com.bugvm.apple.gamekit;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 * @deprecated Deprecated in iOS 7.0.
 */
@Deprecated
/*</javadoc>*/
@ForceLinkClass(GKVoiceChatServiceError.class)
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/GKVoiceChatServiceErrorCode/*</name>*/ implements NSErrorCode {
    /*<values>*/
    Internal(32000L),
    NoRemotePackets(32001L),
    UnableToConnect(32002L),
    RemoteParticipantHangup(32003L),
    InvalidCallID(32004L),
    AudioUnavailable(32005L),
    UninitializedClient(32006L),
    ClientMissingRequiredMethods(32007L),
    RemoteParticipantBusy(32008L),
    RemoteParticipantCancelled(32009L),
    RemoteParticipantResponseInvalid(32010L),
    RemoteParticipantDeclinedInvite(32011L),
    MethodCurrentlyInvalid(32012L),
    NetworkConfiguration(32013L),
    UnsupportedRemoteVersion(32014L),
    OutOfMemory(32015L),
    InvalidParameter(32016L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/GKVoiceChatServiceErrorCode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/GKVoiceChatServiceErrorCode/*</name>*/ valueOf(long n) {
        for (/*<name>*/GKVoiceChatServiceErrorCode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/GKVoiceChatServiceErrorCode/*</name>*/.class.getName());
    }
}
