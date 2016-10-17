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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioComponentPlugInInterface/*</name>*/ 
    extends /*<extends>*/Struct<AudioComponentPlugInInterface>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioComponentPlugInInterfacePtr extends Ptr<AudioComponentPlugInInterface, AudioComponentPlugInInterfacePtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioComponentPlugInInterface() {}
    public AudioComponentPlugInInterface(FunctionPtr Open, FunctionPtr Close, FunctionPtr Lookup, VoidPtr reserved) {
        this.setOpen(Open);
        this.setClose(Close);
        this.setLookup(Lookup);
        this.setReserved(reserved);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native FunctionPtr getOpen();
    @StructMember(0) public native AudioComponentPlugInInterface setOpen(FunctionPtr Open);
    @StructMember(1) public native FunctionPtr getClose();
    @StructMember(1) public native AudioComponentPlugInInterface setClose(FunctionPtr Close);
    @StructMember(2) public native FunctionPtr getLookup();
    @StructMember(2) public native AudioComponentPlugInInterface setLookup(FunctionPtr Lookup);
    @StructMember(3) public native VoidPtr getReserved();
    @StructMember(3) public native AudioComponentPlugInInterface setReserved(VoidPtr reserved);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
