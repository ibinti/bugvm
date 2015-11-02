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
package com.bugvm.apple.coremedia;

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
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.audiotoolbox.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public enum /*<name>*/CMSampleBufferErrorCode/*</name>*/ implements ValuedEnum {
    /*<values>*/
    AllocationFailed(-12730L),
    RequiredParameterMissing(-12731L),
    AlreadyHasDataBuffer(-12732L),
    BufferNotReady(-12733L),
    SampleIndexOutOfRange(-12734L),
    BufferHasNoSampleSizes(-12735L),
    BufferHasNoSampleTimingInfo(-12736L),
    ArrayTooSmall(-12737L),
    InvalidEntryCount(-12738L),
    CannotSubdivide(-12739L),
    SampleTimingInfoInvalid(-12740L),
    InvalidMediaTypeForOperation(-12741L),
    InvalidSampleData(-12742L),
    InvalidMediaFormat(-12743L),
    Invalidated(-12744L),
    DataFailed(-12745L),
    DataCanceled(-12746L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/CMSampleBufferErrorCode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/CMSampleBufferErrorCode/*</name>*/ valueOf(long n) {
        for (/*<name>*/CMSampleBufferErrorCode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/CMSampleBufferErrorCode/*</name>*/.class.getName());
    }
}
