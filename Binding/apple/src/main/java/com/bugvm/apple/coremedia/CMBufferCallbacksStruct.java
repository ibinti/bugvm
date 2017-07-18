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
package com.bugvm.apple.coremedia;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.audiotoolbox.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*//*</visibility>*/ class /*<name>*/CMBufferCallbacksStruct/*</name>*/ 
    extends /*<extends>*/Struct<CMBufferCallbacksStruct>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CMBufferCallbacksStructPtr extends Ptr<CMBufferCallbacksStruct, CMBufferCallbacksStructPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CMBufferCallbacksStruct() {}
    public CMBufferCallbacksStruct(int version, @Pointer long refcon, FunctionPtr getDecodeTimeStamp, FunctionPtr getPresentationTimeStamp, FunctionPtr getDuration, FunctionPtr isDataReady, FunctionPtr compare, String dataBecameReadyNotification, FunctionPtr getSize) {
        this.setVersion(version);
        this.setRefcon(refcon);
        this.setGetDecodeTimeStamp(getDecodeTimeStamp);
        this.setGetPresentationTimeStamp(getPresentationTimeStamp);
        this.setGetDuration(getDuration);
        this.setIsDataReady(isDataReady);
        this.setCompare(compare);
        this.setDataBecameReadyNotification(dataBecameReadyNotification);
        this.setGetSize(getSize);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native int getVersion();
    @StructMember(0) public native CMBufferCallbacksStruct setVersion(int version);
    @StructMember(1) public native @Pointer long getRefcon();
    @StructMember(1) public native CMBufferCallbacksStruct setRefcon(@Pointer long refcon);
    @StructMember(2) public native FunctionPtr getGetDecodeTimeStamp();
    @StructMember(2) public native CMBufferCallbacksStruct setGetDecodeTimeStamp(FunctionPtr getDecodeTimeStamp);
    @StructMember(3) public native FunctionPtr getGetPresentationTimeStamp();
    @StructMember(3) public native CMBufferCallbacksStruct setGetPresentationTimeStamp(FunctionPtr getPresentationTimeStamp);
    @StructMember(4) public native FunctionPtr getGetDuration();
    @StructMember(4) public native CMBufferCallbacksStruct setGetDuration(FunctionPtr getDuration);
    @StructMember(5) public native FunctionPtr getIsDataReady();
    @StructMember(5) public native CMBufferCallbacksStruct setIsDataReady(FunctionPtr isDataReady);
    @StructMember(6) public native FunctionPtr getCompare();
    @StructMember(6) public native CMBufferCallbacksStruct setCompare(FunctionPtr compare);
    @StructMember(7) public native String getDataBecameReadyNotification();
    @StructMember(7) public native CMBufferCallbacksStruct setDataBecameReadyNotification(String dataBecameReadyNotification);
    @StructMember(8) public native FunctionPtr getGetSize();
    @StructMember(8) public native CMBufferCallbacksStruct setGetSize(FunctionPtr getSize);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
