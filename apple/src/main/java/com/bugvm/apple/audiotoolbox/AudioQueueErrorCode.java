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
package com.bugvm.apple.audiotoolbox;

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
import com.bugvm.apple.audiounit.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremidi.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public enum /*<name>*/AudioQueueErrorCode/*</name>*/ implements ValuedEnum {
    /*<values>*/
    InvalidBuffer(-66687L),
    BufferEmpty(-66686L),
    DisposalPending(-66685L),
    InvalidProperty(-66684L),
    InvalidPropertySize(-66683L),
    InvalidParameter(-66682L),
    CannotStart(-66681L),
    InvalidDevice(-66680L),
    BufferInQueue(-66679L),
    InvalidRunState(-66678L),
    InvalidQueueType(-66677L),
    Permissions(-66676L),
    InvalidPropertyValue(-66675L),
    PrimeTimedOut(-66674L),
    CodecNotFound(-66673L),
    InvalidCodecAccess(-66672L),
    QueueInvalidated(-66671L),
    TooManyTaps(-66670L),
    InvalidTapContext(-66669L),
    RecordUnderrun(-66668L),
    InvalidTapType(-66667L),
    BufferEnqueuedTwice(-66666L),
    EnqueueDuringReset(-66632L),
    InvalidOfflineMode(-66626L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/AudioQueueErrorCode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/AudioQueueErrorCode/*</name>*/ valueOf(long n) {
        for (/*<name>*/AudioQueueErrorCode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/AudioQueueErrorCode/*</name>*/.class.getName());
    }
}
