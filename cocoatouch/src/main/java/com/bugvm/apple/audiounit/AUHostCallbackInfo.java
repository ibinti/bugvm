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
package com.bugvm.apple.audiounit;

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
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AUHostCallbackInfo/*</name>*/ 
    extends /*<extends>*/Struct<AUHostCallbackInfo>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AUHostCallbackInfoPtr extends Ptr<AUHostCallbackInfo, AUHostCallbackInfoPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AUHostCallbackInfo() {}
    public AUHostCallbackInfo(@Pointer long hostUserData, FunctionPtr beatAndTempoProc, FunctionPtr musicalTimeLocationProc, FunctionPtr transportStateProc, FunctionPtr transportStateProc2) {
        this.setHostUserData(hostUserData);
        this.setBeatAndTempoProc(beatAndTempoProc);
        this.setMusicalTimeLocationProc(musicalTimeLocationProc);
        this.setTransportStateProc(transportStateProc);
        this.setTransportStateProc2(transportStateProc2);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @Pointer long getHostUserData();
    @StructMember(0) public native AUHostCallbackInfo setHostUserData(@Pointer long hostUserData);
    @StructMember(1) public native FunctionPtr getBeatAndTempoProc();
    @StructMember(1) public native AUHostCallbackInfo setBeatAndTempoProc(FunctionPtr beatAndTempoProc);
    @StructMember(2) public native FunctionPtr getMusicalTimeLocationProc();
    @StructMember(2) public native AUHostCallbackInfo setMusicalTimeLocationProc(FunctionPtr musicalTimeLocationProc);
    @StructMember(3) public native FunctionPtr getTransportStateProc();
    @StructMember(3) public native AUHostCallbackInfo setTransportStateProc(FunctionPtr transportStateProc);
    @StructMember(4) public native FunctionPtr getTransportStateProc2();
    @StructMember(4) public native AUHostCallbackInfo setTransportStateProc2(FunctionPtr transportStateProc2);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
