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
package com.bugvm.apple.audiotoolbox;

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
import com.bugvm.apple.audiounit.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremidi.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ExtendedAudioFormatInfo/*</name>*/ 
    extends /*<extends>*/Struct<ExtendedAudioFormatInfo>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class ExtendedAudioFormatInfoPtr extends Ptr<ExtendedAudioFormatInfo, ExtendedAudioFormatInfoPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public ExtendedAudioFormatInfo() {}
    public ExtendedAudioFormatInfo(AudioStreamBasicDescription ASBD, VoidPtr magicCookie, int magicCookieSize, AudioClassDescription classDescription) {
        this.setASBD(ASBD);
        this.setMagicCookie(magicCookie);
        this.setMagicCookieSize(magicCookieSize);
        this.setClassDescription(classDescription);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @ByVal AudioStreamBasicDescription getASBD();
    @StructMember(0) public native ExtendedAudioFormatInfo setASBD(@ByVal AudioStreamBasicDescription ASBD);
    @StructMember(1) public native VoidPtr getMagicCookie();
    @StructMember(1) public native ExtendedAudioFormatInfo setMagicCookie(VoidPtr magicCookie);
    @StructMember(2) public native int getMagicCookieSize();
    @StructMember(2) public native ExtendedAudioFormatInfo setMagicCookieSize(int magicCookieSize);
    @StructMember(3) public native @ByVal AudioClassDescription getClassDescription();
    @StructMember(3) public native ExtendedAudioFormatInfo setClassDescription(@ByVal AudioClassDescription classDescription);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
