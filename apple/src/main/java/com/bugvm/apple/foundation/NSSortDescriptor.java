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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSSortDescriptor/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSSortDescriptorPtr extends Ptr<NSSortDescriptor, NSSortDescriptorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSSortDescriptor.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    public NSSortDescriptor(NSSortIdentifier key, boolean ascending) {
        this(key.value().toString(), ascending);
    }
    public NSSortDescriptor(NSSortIdentifier key, boolean ascending, Selector selector) {
        this(key.value().toString(), ascending, selector);
    }
    public NSSortDescriptor(NSSortIdentifier key, boolean ascending, @Block Block2<NSObject, NSObject, NSComparisonResult> cmptr) {
        this(key.value().toString(), ascending, cmptr);
    }
    /*<constructors>*/
    public NSSortDescriptor() {}
    protected NSSortDescriptor(SkipInit skipInit) { super(skipInit); }
    public NSSortDescriptor(String key, boolean ascending) { super((SkipInit) null); initObject(init(key, ascending)); }
    public NSSortDescriptor(String key, boolean ascending, Selector selector) { super((SkipInit) null); initObject(init(key, ascending, selector)); }
    public NSSortDescriptor(NSCoder coder) { super((SkipInit) null); initObject(initWithCoder$(coder)); }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public NSSortDescriptor(String key, boolean ascending, @Block Block2<NSObject, NSObject, NSComparisonResult> cmptr) { super((SkipInit) null); initObject(init(key, ascending, cmptr)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "key")
    public native String getKey();
    @Property(selector = "ascending")
    public native boolean isAscending();
    @Property(selector = "selector")
    public native Selector getSelector();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "comparator")
    public native @Block Block2<NSObject, NSObject, NSComparisonResult> getComparator();
    @Property(selector = "reversedSortDescriptor")
    public native NSSortDescriptor getReversedSortDescriptor();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithKey:ascending:")
    protected native @Pointer long init(String key, boolean ascending);
    @Method(selector = "initWithKey:ascending:selector:")
    protected native @Pointer long init(String key, boolean ascending, Selector selector);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long initWithCoder$(NSCoder coder);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "allowEvaluation")
    public native void allowEvaluation();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "initWithKey:ascending:comparator:")
    protected native @Pointer long init(String key, boolean ascending, @Block Block2<NSObject, NSObject, NSComparisonResult> cmptr);
    @Method(selector = "compareObject:toObject:")
    public native NSComparisonResult compare(NSObject object1, NSObject object2);
    /*</methods>*/
}
