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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreFoundation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFBinaryHeap/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFBinaryHeapPtr extends Ptr<CFBinaryHeap, CFBinaryHeapPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFBinaryHeap.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFBinaryHeap() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static CFBinaryHeap create(long capacity) {
        return create(null, capacity);
    }
    public static CFBinaryHeap create(CFAllocator allocator, long capacity) {
        return create(allocator, capacity, getCopyStringCallBacks(), new CFBinaryHeapCompareContext());
    }
    public static CFBinaryHeap createCopy(long capacity, CFBinaryHeap heap) {
        return createCopy(null, capacity, heap);
    }
    public long count(CFType value) {
        return count(value.as(VoidPtr.class));
    }
    public long count(NSObject value) {
        return count(value.as(VoidPtr.class));
    }
    public long count(Struct<?> value) {
        return count(value.as(VoidPtr.class));
    }
    public boolean contains(CFType value) {
        return contains(value.as(VoidPtr.class));
    }
    public boolean contains(NSObject value) {
        return contains(value.as(VoidPtr.class));
    }
    public boolean contains(Struct<?> value) {
        return contains(value.as(VoidPtr.class));
    }
    public void add(CFType value) {
        add(value.as(VoidPtr.class));
    }
    public void add(NSObject value) {
        add(value.as(VoidPtr.class));
    }
    public void add(Struct<?> value) {
        add(value.as(VoidPtr.class));
    }

    /*<methods>*/
    @GlobalValue(symbol="kCFStringBinaryHeapCallBacks", optional=true)
    public static native @ByVal CFBinaryHeapCallBacks getCopyStringCallBacks();
    
    @Bridge(symbol="CFBinaryHeapGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    @Bridge(symbol="CFBinaryHeapCreate", optional=true)
    private static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFBinaryHeap create(CFAllocator allocator, @MachineSizedSInt long capacity, CFBinaryHeapCallBacks callBacks, CFBinaryHeapCompareContext compareContext);
    @Bridge(symbol="CFBinaryHeapCreateCopy", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFBinaryHeap createCopy(CFAllocator allocator, @MachineSizedSInt long capacity, CFBinaryHeap heap);
    @Bridge(symbol="CFBinaryHeapGetCount", optional=true)
    public native @MachineSizedSInt long size();
    @Bridge(symbol="CFBinaryHeapGetCountOfValue", optional=true)
    private native @MachineSizedSInt long count(VoidPtr value);
    @Bridge(symbol="CFBinaryHeapContainsValue", optional=true)
    private native boolean contains(VoidPtr value);
    @Bridge(symbol="CFBinaryHeapGetMinimum", optional=true)
    public native VoidPtr getMinimum();
    @Bridge(symbol="CFBinaryHeapGetMinimumIfPresent", optional=true)
    private native boolean getMinimumIfPresent(VoidPtr.VoidPtrPtr value);
    @Bridge(symbol="CFBinaryHeapGetValues", optional=true)
    private native void getValues(VoidPtr.VoidPtrPtr values);
    @Bridge(symbol="CFBinaryHeapAddValue", optional=true)
    private native void add(VoidPtr value);
    @Bridge(symbol="CFBinaryHeapRemoveMinimumValue", optional=true)
    public native void removeMinimum();
    @Bridge(symbol="CFBinaryHeapRemoveAllValues", optional=true)
    public native void clear();
    /*</methods>*/
}
