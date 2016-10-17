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
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMutableOrderedSet/*</name>*/ <T extends NSObject>
    extends /*<extends>*/NSOrderedSet/*</extends>*/ <T>
    /*<implements>*//*</implements>*/ {

    public static class NSMutableOrderedSetPtr<T extends NSObject> extends Ptr<NSMutableOrderedSet<T>, NSMutableOrderedSetPtr<T>> {}
    
    static class SetAdapter<U extends NSObject> extends NSOrderedSet.SetAdapter<U> {

        SetAdapter(NSOrderedSet<U> set) {
            super(set);
        }

        // All updates are done through the ListAdapter except for remove(Object)
        @SuppressWarnings("unchecked")
        @Override
        public boolean remove(Object o) {
            if (contains(o)) {
                ((NSMutableOrderedSet<U>) set).removeObject((U) o);
                return true;
            }
            return false;
        }
    }
    
    static class ListAdapter<U extends NSObject> extends NSOrderedSet.ListAdapter<U> {

        ListAdapter(NSOrderedSet<U> array) {
            super(array);
        }
        
        @Override
        public void clear() {
            ((NSMutableOrderedSet<U>) set).removeAllObjects();
        }
        
        @Override
        public U set(int index, U element) {
            checkNull(element);
            checkIndex(index);
            U old = (U) set.getObjectAt(index);
            ((NSMutableOrderedSet<U>) set).replaceObject(index, element);
            return old;
        }
        
        @Override
        public void add(int index, U element) {
            checkNull(element);
            if (index != set.getCount() + 1) {
                checkIndex(index);
            }
            ((NSMutableOrderedSet<U>) set).insertObject(element, index);
        }
        
        @Override
        public U remove(int index) {
            checkIndex(index);
            U old = (U) set.getObjectAt(index);
            ((NSMutableOrderedSet<U>) set).removeObject(index);
            return old;
        }
    }
    
    /*<bind>*/static { ObjCRuntime.bind(NSMutableOrderedSet.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMutableOrderedSet() {}
    protected NSMutableOrderedSet(SkipInit skipInit) { super(skipInit); }
    public NSMutableOrderedSet(@MachineSizedUInt long numItems) { super((SkipInit) null); initObject(init(numItems)); }
    /*</constructors>*/
    
    public NSMutableOrderedSet(Collection<T> c) {
        super(c);
    }
    public NSMutableOrderedSet(T... objects) {
        super(objects);
    }
    
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    
    @Override
    protected AbstractSet<T> createSetAdapter() {
        return new SetAdapter<T>(this);
    }

    @Override
    protected AbstractList<T> createListAdapter() {
        return new ListAdapter<T>(this);
    }

    /*<methods>*/
    @Method(selector = "insertObject:atIndex:")
    protected native void insertObject(NSObject object, @MachineSizedUInt long idx);
    @Method(selector = "removeObjectAtIndex:")
    protected native void removeObject(@MachineSizedUInt long idx);
    @Method(selector = "replaceObjectAtIndex:withObject:")
    protected native void replaceObject(@MachineSizedUInt long idx, NSObject object);
    @Method(selector = "initWithCapacity:")
    protected native @Pointer long init(@MachineSizedUInt long numItems);
    @Method(selector = "removeAllObjects")
    protected native void removeAllObjects();
    @Method(selector = "removeObject:")
    protected native void removeObject(NSObject object);
    /*</methods>*/
}
