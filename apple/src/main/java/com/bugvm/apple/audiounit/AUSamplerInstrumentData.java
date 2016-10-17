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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AUSamplerInstrumentData/*</name>*/ 
    extends /*<extends>*/Struct<AUSamplerInstrumentData>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AUSamplerInstrumentDataPtr extends Ptr<AUSamplerInstrumentData, AUSamplerInstrumentDataPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AUSamplerInstrumentData() {}
    public AUSamplerInstrumentData(NSURL fileURL, AUInstrumentType instrumentType, byte bankMSB, byte bankLSB, byte presetID) {
        this.setFileURL(fileURL);
        this.setInstrumentType(instrumentType);
        this.setBankMSB(bankMSB);
        this.setBankLSB(bankLSB);
        this.setPresetID(presetID);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public void setBankMSB(AUSamplerBank bankMSB) {
        setBankMSB((byte)bankMSB.value());
    }
    public void setBankLSB(AUSamplerBank bankLSB) {
        setBankLSB((byte)bankLSB.value());
    }
    /*<members>*/
    @StructMember(0) public native NSURL getFileURL();
    @StructMember(0) public native AUSamplerInstrumentData setFileURL(NSURL fileURL);
    @StructMember(1) public native AUInstrumentType getInstrumentType();
    @StructMember(1) public native AUSamplerInstrumentData setInstrumentType(AUInstrumentType instrumentType);
    @StructMember(2) public native byte getBankMSB();
    @StructMember(2) public native AUSamplerInstrumentData setBankMSB(byte bankMSB);
    @StructMember(3) public native byte getBankLSB();
    @StructMember(3) public native AUSamplerInstrumentData setBankLSB(byte bankLSB);
    @StructMember(4) public native byte getPresetID();
    @StructMember(4) public native AUSamplerInstrumentData setPresetID(byte presetID);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
