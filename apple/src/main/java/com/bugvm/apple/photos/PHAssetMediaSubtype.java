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
package com.bugvm.apple.photos;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.avfoundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/PHAssetMediaSubtype/*</name>*/ extends Bits</*<name>*/PHAssetMediaSubtype/*</name>*/> {
    /*<values>*/
    public static final PHAssetMediaSubtype None = new PHAssetMediaSubtype(0L);
    public static final PHAssetMediaSubtype PhotoPanorama = new PHAssetMediaSubtype(1L);
    public static final PHAssetMediaSubtype PhotoHDR = new PHAssetMediaSubtype(2L);
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static final PHAssetMediaSubtype PhotoScreenshot = new PHAssetMediaSubtype(4L);
    public static final PHAssetMediaSubtype VideoStreamed = new PHAssetMediaSubtype(65536L);
    public static final PHAssetMediaSubtype VideoHighFrameRate = new PHAssetMediaSubtype(131072L);
    public static final PHAssetMediaSubtype VideoTimelapse = new PHAssetMediaSubtype(262144L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/PHAssetMediaSubtype/*</name>*/[] values = _values(/*<name>*/PHAssetMediaSubtype/*</name>*/.class);

    public /*<name>*/PHAssetMediaSubtype/*</name>*/(long value) { super(value); }
    private /*<name>*/PHAssetMediaSubtype/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/PHAssetMediaSubtype/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/PHAssetMediaSubtype/*</name>*/(value, mask);
    }
    protected /*<name>*/PHAssetMediaSubtype/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/PHAssetMediaSubtype/*</name>*/[] values() {
        return values.clone();
    }
}
