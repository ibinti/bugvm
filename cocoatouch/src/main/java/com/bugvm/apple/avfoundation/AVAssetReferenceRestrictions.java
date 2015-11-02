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
package com.bugvm.apple.avfoundation;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.mediatoolbox.*;
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.audiounit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/AVAssetReferenceRestrictions/*</name>*/ extends Bits</*<name>*/AVAssetReferenceRestrictions/*</name>*/> {
    /*<values>*/
    public static final AVAssetReferenceRestrictions None = new AVAssetReferenceRestrictions(0L);
    public static final AVAssetReferenceRestrictions RemoteReferenceToLocal = new AVAssetReferenceRestrictions(1L);
    public static final AVAssetReferenceRestrictions LocalReferenceToRemote = new AVAssetReferenceRestrictions(2L);
    public static final AVAssetReferenceRestrictions CrossSiteReference = new AVAssetReferenceRestrictions(4L);
    public static final AVAssetReferenceRestrictions LocalReferenceToLocal = new AVAssetReferenceRestrictions(8L);
    public static final AVAssetReferenceRestrictions All = new AVAssetReferenceRestrictions(65535L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/AVAssetReferenceRestrictions/*</name>*/[] values = _values(/*<name>*/AVAssetReferenceRestrictions/*</name>*/.class);

    public /*<name>*/AVAssetReferenceRestrictions/*</name>*/(long value) { super(value); }
    private /*<name>*/AVAssetReferenceRestrictions/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/AVAssetReferenceRestrictions/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/AVAssetReferenceRestrictions/*</name>*/(value, mask);
    }
    protected /*<name>*/AVAssetReferenceRestrictions/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/AVAssetReferenceRestrictions/*</name>*/[] values() {
        return values.clone();
    }
}
