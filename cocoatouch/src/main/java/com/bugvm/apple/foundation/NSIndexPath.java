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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSIndexPath/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSIndexPathPtr extends Ptr<NSIndexPath, NSIndexPathPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSIndexPath.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSIndexPath() {}
    protected NSIndexPath(SkipInit skipInit) { super(skipInit); }
    public NSIndexPath(@MachineSizedUInt long index) { super((SkipInit) null); initObject(init(index)); }
    /*</constructors>*/
    
    public NSIndexPath(long[] indexes) {
        super((SkipInit) null);
        if (indexes == null) {
            throw new NullPointerException("indexes");
        }
        MachineSizedUIntPtr p = Struct.allocate(MachineSizedUIntPtr.class, indexes.length);
        p.set(indexes);
        initObject(init(p, indexes.length));
    }
    
    /*<properties>*/
    @Property(selector = "length")
    public native @MachineSizedUInt long getLength();
    /*</properties>*/
    /*<members>*//*</members>*/
    
    public int[] getIndexes() {
        int n = (int) getLength();
        MachineSizedUIntPtr p = Struct.allocate(MachineSizedUIntPtr.class, n);
        getIndexes(p);
        return p.toIntArray(n);
    }
    /**
    * @since Available in iOS 7.0 and later.
    */
    public int[] getIndexes(NSRange positionRange) {
        int n = (int) getLength();
        MachineSizedUIntPtr p = Struct.allocate(MachineSizedUIntPtr.class, (int)positionRange.getLength());
        getIndexes(p, positionRange);
        return p.toIntArray(n);
    }
    
    
    /* UIKit extensions */
    @WeaklyLinked
    public int getSection() {
        return (int) NSIndexPathExtensions.getSection(this);
    }
    @WeaklyLinked
    public int getRow() {
        return (int) NSIndexPathExtensions.getRow(this);
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @WeaklyLinked
    public int getItem() {
        return (int) NSIndexPathExtensions.getItem(this);
    }
    @WeaklyLinked
    public static NSIndexPath row(@MachineSizedSInt long row, @MachineSizedSInt long section) {
        return NSIndexPathExtensions.createIndexPathForRowInSection(row, section);
    }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @WeaklyLinked
    public static NSIndexPath item(@MachineSizedSInt long item, @MachineSizedSInt long section) {
        return NSIndexPathExtensions.createIndexPathForItemInSection(item, section);
    }
    
    /*<methods>*/
    @Method(selector = "initWithIndexes:length:")
    private native @Pointer long init(MachineSizedUIntPtr indexes, @MachineSizedUInt long length);
    @Method(selector = "initWithIndex:")
    protected native @Pointer long init(@MachineSizedUInt long index);
    @Method(selector = "indexPathByAddingIndex:")
    public native NSIndexPath addIndex(@MachineSizedUInt long index);
    @Method(selector = "indexPathByRemovingLastIndex")
    public native NSIndexPath removeLastIndex();
    @Method(selector = "indexAtPosition:")
    public native @MachineSizedUInt long getIndexAt(@MachineSizedUInt long position);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "getIndexes:range:")
    private native void getIndexes(MachineSizedUIntPtr indexes, @ByVal NSRange positionRange);
    @Method(selector = "compare:")
    public native NSComparisonResult compare(NSIndexPath otherObject);
    @Method(selector = "getIndexes:")
    private native void getIndexes(MachineSizedUIntPtr indexes);
    /*</methods>*/
}
