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
package com.bugvm.apple.dispatch;

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
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("System")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/DispatchQueueAttr/*</name>*/ 
    extends /*<extends>*/DispatchObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class DispatchQueueAttrPtr extends Ptr<DispatchQueueAttr, DispatchQueueAttrPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(DispatchQueueAttr.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected DispatchQueueAttr() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * 
     * @return null
     */
    public static DispatchQueueAttr Serial() {
        return null;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.3 and later.
     */
    @GlobalValue(symbol="_dispatch_queue_attr_concurrent", optional=true, dereference=false)
    public static native DispatchQueueAttr Concurrent();
    /*</methods>*/
}
