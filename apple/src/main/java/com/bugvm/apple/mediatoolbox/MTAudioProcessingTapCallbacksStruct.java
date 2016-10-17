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
package com.bugvm.apple.mediatoolbox;

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
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.audiotoolbox.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*//*</visibility>*/ class /*<name>*/MTAudioProcessingTapCallbacksStruct/*</name>*/ 
    extends /*<extends>*/Struct<MTAudioProcessingTapCallbacksStruct>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MTAudioProcessingTapCallbacksStructPtr extends Ptr<MTAudioProcessingTapCallbacksStruct, MTAudioProcessingTapCallbacksStructPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MTAudioProcessingTapCallbacksStruct() {}
    public MTAudioProcessingTapCallbacksStruct(int version, @Pointer long clientInfo, FunctionPtr init, FunctionPtr finalizeCbk, FunctionPtr prepare, FunctionPtr unprepare, FunctionPtr process) {
        this.setVersion(version);
        this.setClientInfo(clientInfo);
        this.setInit(init);
        this.setFinalizeCbk(finalizeCbk);
        this.setPrepare(prepare);
        this.setUnprepare(unprepare);
        this.setProcess(process);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native int getVersion();
    @StructMember(0) public native MTAudioProcessingTapCallbacksStruct setVersion(int version);
    @StructMember(1) public native @Pointer long getClientInfo();
    @StructMember(1) public native MTAudioProcessingTapCallbacksStruct setClientInfo(@Pointer long clientInfo);
    @StructMember(2) public native FunctionPtr getInit();
    @StructMember(2) public native MTAudioProcessingTapCallbacksStruct setInit(FunctionPtr init);
    @StructMember(3) public native FunctionPtr getFinalizeCbk();
    @StructMember(3) public native MTAudioProcessingTapCallbacksStruct setFinalizeCbk(FunctionPtr finalizeCbk);
    @StructMember(4) public native FunctionPtr getPrepare();
    @StructMember(4) public native MTAudioProcessingTapCallbacksStruct setPrepare(FunctionPtr prepare);
    @StructMember(5) public native FunctionPtr getUnprepare();
    @StructMember(5) public native MTAudioProcessingTapCallbacksStruct setUnprepare(FunctionPtr unprepare);
    @StructMember(6) public native FunctionPtr getProcess();
    @StructMember(6) public native MTAudioProcessingTapCallbacksStruct setProcess(FunctionPtr process);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
