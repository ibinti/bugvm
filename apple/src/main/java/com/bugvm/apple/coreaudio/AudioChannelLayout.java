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
package com.bugvm.apple.coreaudio;

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
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioChannelLayout/*</name>*/ 
    extends /*<extends>*/Struct<AudioChannelLayout>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioChannelLayoutPtr extends Ptr<AudioChannelLayout, AudioChannelLayoutPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioChannelLayout() {}
    public AudioChannelLayout(AudioChannelLayoutTag channelLayoutTag, AudioChannelBits channelBitmap) {
        this.setChannelLayoutTag(channelLayoutTag);
        this.setChannelBitmap(channelBitmap);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public int getChannelDescriptionCount() {
        return getNumberChannelDescriptions();
    }
    
    public AudioChannelDescription getChannelDescription(int index) {
        if (index >= getNumberChannelDescriptions()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return getChannelDescriptions0().next(index).get();
    }
    public AudioChannelLayout setChannelDescription(int index, AudioChannelDescription value) {
        if (index >= getNumberChannelDescriptions()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        getChannelDescriptions0().next(index).set(value);
        return this;
    }
    
    public AudioChannelDescription[] getChannelDescriptions() {
        int count = getChannelDescriptionCount();
        AudioChannelDescription[] array = new AudioChannelDescription[count];
        AudioChannelDescription.AudioChannelDescriptionPtr ptr = getChannelDescriptions0();
        for (int i = 0; i < count; i++) {
            array[i] = ptr.next(i).get();
        }
        return array;
    }
    public AudioChannelLayout setChannelDescriptions(AudioChannelDescription[] channelDescriptions) {
        this.setNumberChannelDescriptions(channelDescriptions.length);
        getChannelDescriptions0().set(channelDescriptions);
        return this;
    }
    /*<members>*/
    @StructMember(0) public native AudioChannelLayoutTag getChannelLayoutTag();
    @StructMember(0) public native AudioChannelLayout setChannelLayoutTag(AudioChannelLayoutTag channelLayoutTag);
    @StructMember(1) public native AudioChannelBits getChannelBitmap();
    @StructMember(1) public native AudioChannelLayout setChannelBitmap(AudioChannelBits channelBitmap);
    @StructMember(2) protected native int getNumberChannelDescriptions();
    @StructMember(2) protected native AudioChannelLayout setNumberChannelDescriptions(int numberChannelDescriptions);
    @StructMember(3) protected native AudioChannelDescription.AudioChannelDescriptionPtr getChannelDescriptions0();
    @StructMember(3) protected native AudioChannelLayout setChannelDescriptions0(AudioChannelDescription.AudioChannelDescriptionPtr channelDescriptions0);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
