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
package com.bugvm.ios.CoreAudio;

/*<imports>*/

import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
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
    public AudioChannelLayout(AudioChannelLayoutTag channelLayoutTag, com.bugvm.ios.CoreAudio.AudioChannelBits channelBitmap) {
        this.setChannelLayoutTag(channelLayoutTag);
        this.setChannelBitmap(channelBitmap);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public int getChannelDescriptionCount() {
        return getNumberChannelDescriptions();
    }
    
    public com.bugvm.ios.CoreAudio.AudioChannelDescription getChannelDescription(int index) {
        if (index >= getNumberChannelDescriptions()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return getChannelDescriptions0().next(index).get();
    }
    public AudioChannelLayout setChannelDescription(int index, com.bugvm.ios.CoreAudio.AudioChannelDescription value) {
        if (index >= getNumberChannelDescriptions()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        getChannelDescriptions0().next(index).set(value);
        return this;
    }
    
    public com.bugvm.ios.CoreAudio.AudioChannelDescription[] getChannelDescriptions() {
        int count = getChannelDescriptionCount();
        com.bugvm.ios.CoreAudio.AudioChannelDescription[] array = new com.bugvm.ios.CoreAudio.AudioChannelDescription[count];
        com.bugvm.ios.CoreAudio.AudioChannelDescription.AudioChannelDescriptionPtr ptr = getChannelDescriptions0();
        for (int i = 0; i < count; i++) {
            array[i] = ptr.next(i).get();
        }
        return array;
    }
    public AudioChannelLayout setChannelDescriptions(com.bugvm.ios.CoreAudio.AudioChannelDescription[] channelDescriptions) {
        this.setNumberChannelDescriptions(channelDescriptions.length);
        getChannelDescriptions0().set(channelDescriptions);
        return this;
    }
    /*<members>*/
    @StructMember(0) public native AudioChannelLayoutTag getChannelLayoutTag();
    @StructMember(0) public native AudioChannelLayout setChannelLayoutTag(AudioChannelLayoutTag channelLayoutTag);
    @StructMember(1) public native com.bugvm.ios.CoreAudio.AudioChannelBits getChannelBitmap();
    @StructMember(1) public native AudioChannelLayout setChannelBitmap(com.bugvm.ios.CoreAudio.AudioChannelBits channelBitmap);
    @StructMember(2) protected native int getNumberChannelDescriptions();
    @StructMember(2) protected native AudioChannelLayout setNumberChannelDescriptions(int numberChannelDescriptions);
    @StructMember(3) protected native com.bugvm.ios.CoreAudio.AudioChannelDescription.AudioChannelDescriptionPtr getChannelDescriptions0();
    @StructMember(3) protected native AudioChannelLayout setChannelDescriptions0(com.bugvm.ios.CoreAudio.AudioChannelDescription.AudioChannelDescriptionPtr channelDescriptions0);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
