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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AUParameterStringFromValue/*</name>*/ 
    extends /*<extends>*/Struct<AUParameterStringFromValue>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AUParameterStringFromValuePtr extends Ptr<AUParameterStringFromValue, AUParameterStringFromValuePtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AUParameterStringFromValue() {}
    public AUParameterStringFromValue(int inParamID, FloatPtr inValue, String outString) {
        this.setInParamID(inParamID);
        this.setInValue(inValue);
        this.setOutString(outString);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native int getInParamID();
    @StructMember(0) public native AUParameterStringFromValue setInParamID(int inParamID);
    @StructMember(1) public native FloatPtr getInValue();
    @StructMember(1) public native AUParameterStringFromValue setInValue(FloatPtr inValue);
    @StructMember(2) public native String getOutString();
    @StructMember(2) public native AUParameterStringFromValue setOutString(String outString);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
