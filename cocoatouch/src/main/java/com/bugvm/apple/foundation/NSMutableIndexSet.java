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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMutableIndexSet/*</name>*/ 
    extends /*<extends>*/NSIndexSet/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSMutableIndexSetPtr extends Ptr<NSMutableIndexSet, NSMutableIndexSetPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSMutableIndexSet.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSMutableIndexSet() {}
    protected NSMutableIndexSet(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "addIndexes:")
    public native void addIndexes(NSIndexSet indexSet);
    @Method(selector = "removeIndexes:")
    public native void removeIndexes(NSIndexSet indexSet);
    @Method(selector = "removeAllIndexes")
    public native void removeAllIndexes();
    @Method(selector = "addIndex:")
    public native void addIndex(@MachineSizedUInt long value);
    @Method(selector = "removeIndex:")
    public native void removeIndex(@MachineSizedUInt long value);
    @Method(selector = "addIndexesInRange:")
    public native void addIndexes(@ByVal NSRange range);
    @Method(selector = "removeIndexesInRange:")
    public native void removeIndexes(@ByVal NSRange range);
    @Method(selector = "shiftIndexesStartingAtIndex:by:")
    public native void shiftIndexes(@MachineSizedUInt long index, @MachineSizedSInt long delta);
    /*</methods>*/
}
