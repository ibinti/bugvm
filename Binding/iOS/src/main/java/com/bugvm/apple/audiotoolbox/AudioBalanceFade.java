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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioBalanceFade/*</name>*/ 
    extends /*<extends>*/Struct<AudioBalanceFade>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioBalanceFadePtr extends Ptr<AudioBalanceFade, AudioBalanceFadePtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioBalanceFade() {}
    public AudioBalanceFade(float leftRightBalance, float backFrontFade, AudioBalanceFadeType type, AudioChannelLayout channelLayout) {
        this.setLeftRightBalance(leftRightBalance);
        this.setBackFrontFade(backFrontFade);
        this.setType(type);
        this.setChannelLayout(channelLayout);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native float getLeftRightBalance();
    @StructMember(0) public native AudioBalanceFade setLeftRightBalance(float leftRightBalance);
    @StructMember(1) public native float getBackFrontFade();
    @StructMember(1) public native AudioBalanceFade setBackFrontFade(float backFrontFade);
    @StructMember(2) public native AudioBalanceFadeType getType();
    @StructMember(2) public native AudioBalanceFade setType(AudioBalanceFadeType type);
    @StructMember(3) public native AudioChannelLayout getChannelLayout();
    @StructMember(3) public native AudioBalanceFade setChannelLayout(AudioChannelLayout channelLayout);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
