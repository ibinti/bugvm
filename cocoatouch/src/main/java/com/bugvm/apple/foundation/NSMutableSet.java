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
import java.util.*;

import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMutableSet/*</name>*/ <T extends NSObject>
    extends /*<extends>*/NSSet/*</extends>*/ <T>
    /*<implements>*//*</implements>*/ {

    public static class NSMutableSetPtr<T extends NSObject> extends Ptr<NSMutableSet<T>, NSMutableSetPtr<T>> {}
    
    static class SetAdapter<U extends NSObject> extends NSSet.SetAdapter<U> {
        SetAdapter(NSSet<U> set) {
            super(set);
        }
        
        @Override
        public Iterator<U> iterator() {
            return new NSEnumerator.Iterator<U>(set.objectEnumerator()) {
                void remove(int index, U o) {
                    ((NSMutableSet<U>) set).removeObject(o);
                }
            };
        }
        
        @Override
        public boolean add(U e) {
            checkNull(e);
            boolean replaced = contains(e);
            ((NSMutableSet<U>) set).addObject(e);
            return replaced;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public boolean remove(Object o) {
            if (contains(o)) {
                ((NSMutableSet<U>) set).removeObject((U) o);
                return true;
            }
            return false;
        }
        
        @Override
        public void clear() {
            ((NSMutableSet<U>) set).removeAllObjects();
        }
    }
    
    /*<bind>*/static { ObjCRuntime.bind(NSMutableSet.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMutableSet() {}
    protected NSMutableSet(SkipInit skipInit) { super(skipInit); }
    public NSMutableSet(@MachineSizedUInt long numItems) { super((SkipInit) null); initObject(init(numItems)); }
    /*</constructors>*/
    
    public NSMutableSet(Collection<T> c) {
        super(c);
    }
    public NSMutableSet(T... objects) {
        super(objects);
    }
    
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    
    @Override
    protected AbstractSet<T> createAdapter() {
        return new SetAdapter<T>(this);
    }
    
    /*<methods>*/
    @Method(selector = "addObject:")
    protected native void addObject(NSObject object);
    @Method(selector = "removeObject:")
    protected native void removeObject(NSObject object);
    @Method(selector = "initWithCapacity:")
    protected native @Pointer long init(@MachineSizedUInt long numItems);
    @Method(selector = "removeAllObjects")
    protected native void removeAllObjects();
    /*</methods>*/
}
