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
/*<annotations>*//*</annotations>*/
/*<visibility>*//*</visibility>*/ class /*<name>*/timespec/*</name>*/ 
    extends /*<extends>*/Struct<timespec>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class timespecPtr extends Ptr<timespec, timespecPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public timespec() {}
    public timespec(@MachineSizedSInt long tv_sec, @MachineSizedSInt long tv_nsec) {
        this.setTv_sec(tv_sec);
        this.setTv_nsec(tv_nsec);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedSInt long getTv_sec();
    @StructMember(0) public native timespec setTv_sec(@MachineSizedSInt long tv_sec);
    @StructMember(1) public native @MachineSizedSInt long getTv_nsec();
    @StructMember(1) public native timespec setTv_nsec(@MachineSizedSInt long tv_nsec);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
