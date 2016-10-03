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
package com.bugvm.ios.AudioUnit;

/*<imports>*/
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioComponentDescription/*</name>*/ 
    extends /*<extends>*/Struct<AudioComponentDescription>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioComponentDescriptionPtr extends Ptr<AudioComponentDescription, AudioComponentDescriptionPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioComponentDescription() {}
    public AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType componentType, com.bugvm.ios.AudioUnit.AUSubType componentSubType, com.bugvm.ios.AudioUnit.AUManufacturer componentManufacturer, com.bugvm.ios.AudioUnit.AudioComponentFlags componentFlags, int componentFlagsMask) {
        this.setComponentType(componentType);
        this.setComponentSubType(componentSubType);
        this.setComponentManufacturer(componentManufacturer);
        this.setComponentFlags(componentFlags);
        this.setComponentFlagsMask(componentFlagsMask);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public static AudioComponentDescription create(com.bugvm.ios.AudioUnit.AUType type) {
        return new AudioComponentDescription(type, null, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription create(com.bugvm.ios.AudioUnit.AUType type, com.bugvm.ios.AudioUnit.AUSubType subType) {
        return new AudioComponentDescription(type, subType, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription createOutput(AUTypeIO type) {
        return new AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType.Output, type, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription createMusicDevice(com.bugvm.ios.AudioUnit.AUTypeMusicDevice type) {
        return new AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType.MusicDevice, type, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription createConverter(com.bugvm.ios.AudioUnit.AUTypeConverter type) {
        return new AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType.FormatConverter, type, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription createEffect(com.bugvm.ios.AudioUnit.AUTypeEffect type) {
        return new AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType.Effect, type, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription createMixer(com.bugvm.ios.AudioUnit.AUTypeMixer type) {
        return new AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType.Mixer, type, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription createPanner() {
        return new AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType.Mixer, null, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    public static AudioComponentDescription createGenerator(com.bugvm.ios.AudioUnit.AUTypeGenerator type) {
        return new AudioComponentDescription(com.bugvm.ios.AudioUnit.AUType.Generator, type, com.bugvm.ios.AudioUnit.AUManufacturer.Apple, com.bugvm.ios.AudioUnit.AudioComponentFlags.None, 0);
    }
    /*<members>*/
    @StructMember(0) public native com.bugvm.ios.AudioUnit.AUType getComponentType();
    @StructMember(0) public native AudioComponentDescription setComponentType(com.bugvm.ios.AudioUnit.AUType componentType);
    @StructMember(1) public native com.bugvm.ios.AudioUnit.AUSubType getComponentSubType();
    @StructMember(1) public native AudioComponentDescription setComponentSubType(com.bugvm.ios.AudioUnit.AUSubType componentSubType);
    @StructMember(2) public native com.bugvm.ios.AudioUnit.AUManufacturer getComponentManufacturer();
    @StructMember(2) public native AudioComponentDescription setComponentManufacturer(com.bugvm.ios.AudioUnit.AUManufacturer componentManufacturer);
    @StructMember(3) public native com.bugvm.ios.AudioUnit.AudioComponentFlags getComponentFlags();
    @StructMember(3) public native AudioComponentDescription setComponentFlags(com.bugvm.ios.AudioUnit.AudioComponentFlags componentFlags);
    @StructMember(4) public native int getComponentFlagsMask();
    @StructMember(4) public native AudioComponentDescription setComponentFlagsMask(int componentFlagsMask);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
