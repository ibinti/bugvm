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
package com.bugvm.apple.corevideo;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public enum /*<name>*/CVReturn/*</name>*/ implements ValuedEnum {
    /*<values>*/
    Success(0L),
    First(-6660L),
    Error(-6660L),
    InvalidArgument(-6661L),
    AllocationFailed(-6662L),
    InvalidDisplay(-6670L),
    DisplayLinkAlreadyRunning(-6671L),
    DisplayLinkNotRunning(-6672L),
    DisplayLinkCallbacksNotSet(-6673L),
    InvalidPixelFormat(-6680L),
    InvalidSize(-6681L),
    InvalidPixelBufferAttributes(-6682L),
    PixelBufferNotOpenGLCompatible(-6683L),
    PixelBufferNotMetalCompatible(-6684L),
    WouldExceedAllocationThreshold(-6689L),
    PoolAllocationFailed(-6690L),
    InvalidPoolAttributes(-6691L),
    Last(-6699L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/CVReturn/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/CVReturn/*</name>*/ valueOf(long n) {
        for (/*<name>*/CVReturn/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/CVReturn/*</name>*/.class.getName());
    }
}
