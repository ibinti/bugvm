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
package com.bugvm.apple.coregraphics;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreGraphics")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CGPattern/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CGPatternPtr extends Ptr<CGPattern, CGPatternPtr> {}/*</ptr>*/
  
    public interface DrawPattern {
        void drawPattern(CGContext context);
    }
    
    /*<bind>*/static { Bro.bind(CGPattern.class); }/*</bind>*/
    
    private static java.util.concurrent.atomic.AtomicLong infoId = new java.util.concurrent.atomic.AtomicLong();
    private static final LongMap<DrawPattern> infos = new LongMap<>();
    private static final java.lang.reflect.Method cbDrawPattern;
    private static final java.lang.reflect.Method cbReleaseInfo;
    
    static {
        try {
            cbDrawPattern = CGPattern.class.getDeclaredMethod("cbDrawPattern", long.class, CGContext.class);
            cbReleaseInfo = CGPattern.class.getDeclaredMethod("cbReleaseInfo", long.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CGPattern() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static CGPattern create(CGRect bounds, CGAffineTransform matrix, double xStep, double yStep, CGPatternTiling tiling, boolean isColored, DrawPattern drawPattern) {
        long infoId = CGPattern.infoId.getAndIncrement();
        CGPatternCallbacks callbacks = new CGPatternCallbacks();
        callbacks.setDrawPattern(new FunctionPtr(cbDrawPattern));
        callbacks.setReleaseInfo(new FunctionPtr(cbReleaseInfo));
        CGPattern result = create(infoId, bounds, matrix, xStep, yStep, tiling, isColored, callbacks);
        if (result != null) {
            synchronized (infos) {
                infos.put(infoId, drawPattern);
            }
        }
        return result;
    }
    
    @Callback
    private static void cbDrawPattern(@Pointer long infoId, CGContext context) {
        DrawPattern drawPattern = null;
        synchronized (infos) {
            drawPattern = infos.get(infoId);
        }
        drawPattern.drawPattern(context);
    }
    @Callback
    private static void cbReleaseInfo(@Pointer long infoId) {
        synchronized (infos) {
            infos.remove(infoId);
        }
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPatternGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPatternCreate", optional=true)
    private static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CGPattern create(@Pointer long info, @ByVal CGRect bounds, @ByVal CGAffineTransform matrix, @MachineSizedFloat double xStep, @MachineSizedFloat double yStep, CGPatternTiling tiling, boolean isColored, CGPatternCallbacks callbacks);
    /*</methods>*/
}
