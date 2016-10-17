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
package com.bugvm.apple.coredata;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreData") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSFetchRequestExpression/*</name>*/ 
    extends /*<extends>*/NSExpression/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSFetchRequestExpressionPtr extends Ptr<NSFetchRequestExpression, NSFetchRequestExpressionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSFetchRequestExpression.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSFetchRequestExpression() {}
    protected NSFetchRequestExpression(SkipInit skipInit) { super(skipInit); }
    public NSFetchRequestExpression(NSExpression fetch, NSExpression context, boolean countFlag) { super(create(fetch, context, countFlag)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "requestExpression")
    public native NSExpression getRequestExpression();
    @Property(selector = "contextExpression")
    public native NSExpression getContextExpression();
    @Property(selector = "isCountOnlyRequest")
    public native boolean isCountOnlyRequest();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "expressionForFetch:context:countOnly:")
    protected static native @Pointer long create(NSExpression fetch, NSExpression context, boolean countFlag);
    /*</methods>*/
}
