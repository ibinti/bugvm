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
package com.bugvm.apple.coretext;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*//*</visibility>*/ class /*<name>*/CTRunDelegateCallbacks/*</name>*/ 
    extends /*<extends>*/Struct<CTRunDelegateCallbacks>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CTRunDelegateCallbacksPtr extends Ptr<CTRunDelegateCallbacks, CTRunDelegateCallbacksPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CTRunDelegateCallbacks() {}
    public CTRunDelegateCallbacks(@MachineSizedSInt long version, FunctionPtr dealloc, FunctionPtr getAscent, FunctionPtr getDescent, FunctionPtr getWidth) {
        this.setVersion(version);
        this.setDealloc(dealloc);
        this.setGetAscent(getAscent);
        this.setGetDescent(getDescent);
        this.setGetWidth(getWidth);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedSInt long getVersion();
    @StructMember(0) public native CTRunDelegateCallbacks setVersion(@MachineSizedSInt long version);
    @StructMember(1) public native FunctionPtr getDealloc();
    @StructMember(1) public native CTRunDelegateCallbacks setDealloc(FunctionPtr dealloc);
    @StructMember(2) public native FunctionPtr getGetAscent();
    @StructMember(2) public native CTRunDelegateCallbacks setGetAscent(FunctionPtr getAscent);
    @StructMember(3) public native FunctionPtr getGetDescent();
    @StructMember(3) public native CTRunDelegateCallbacks setGetDescent(FunctionPtr getDescent);
    @StructMember(4) public native FunctionPtr getGetWidth();
    @StructMember(4) public native CTRunDelegateCallbacks setGetWidth(FunctionPtr getWidth);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
