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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MIDINoteMessage/*</name>*/ 
    extends /*<extends>*/Struct<MIDINoteMessage>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MIDINoteMessagePtr extends Ptr<MIDINoteMessage, MIDINoteMessagePtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MIDINoteMessage() {}
    public MIDINoteMessage(byte channel, byte note, byte velocity, byte releaseVelocity, float duration) {
        this.setChannel(channel);
        this.setNote(note);
        this.setVelocity(velocity);
        this.setReleaseVelocity(releaseVelocity);
        this.setDuration(duration);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native byte getChannel();
    @StructMember(0) public native MIDINoteMessage setChannel(byte channel);
    @StructMember(1) public native byte getNote();
    @StructMember(1) public native MIDINoteMessage setNote(byte note);
    @StructMember(2) public native byte getVelocity();
    @StructMember(2) public native MIDINoteMessage setVelocity(byte velocity);
    @StructMember(3) public native byte getReleaseVelocity();
    @StructMember(3) public native MIDINoteMessage setReleaseVelocity(byte releaseVelocity);
    @StructMember(4) public native float getDuration();
    @StructMember(4) public native MIDINoteMessage setDuration(float duration);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
