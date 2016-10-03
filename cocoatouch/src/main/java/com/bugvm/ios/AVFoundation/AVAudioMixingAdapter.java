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
package com.bugvm.ios.AVFoundation;

/*<imports>*/

import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioMixingAdapter/*</name>*/ 
    extends /*<extends>*/AVAudioStereoMixingAdapter/*</extends>*/
    /*<implements>*/implements com.bugvm.ios.AVFoundation.AVAudioMixing/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    @NotImplemented("volume")
    public float getVolume() { return 0; }
    @NotImplemented("setVolume:")
    public void setVolume(float v) {}
    /*</properties>*/
    /*<members>*//*</members>*/
    @NotImplemented("renderingAlgorithm")
    public com.bugvm.ios.AVFoundation.AVAudio3DMixingRenderingAlgorithm getRenderingAlgorithm() { throw new UnsupportedOperationException(); }
    @NotImplemented("setRenderingAlgorithm:")
    public void setRenderingAlgorithm(com.bugvm.ios.AVFoundation.AVAudio3DMixingRenderingAlgorithm v) { throw new UnsupportedOperationException(); }
    @NotImplemented("rate")
    public float getRate() { throw new UnsupportedOperationException(); }
    @NotImplemented("setRate:")
    public void setRate(float v) { throw new UnsupportedOperationException(); }
    @NotImplemented("reverbBlend")
    public float getReverbBlend() { throw new UnsupportedOperationException(); }
    @NotImplemented("setReverbBlend:")
    public void setReverbBlend(float v) { throw new UnsupportedOperationException(); }
    @NotImplemented("obstruction")
    public float getObstruction() { throw new UnsupportedOperationException(); }
    @NotImplemented("setObstruction:")
    public void setObstruction(float v) { throw new UnsupportedOperationException(); }
    @NotImplemented("occlusion")
    public float getOcclusion() { throw new UnsupportedOperationException(); }
    @NotImplemented("setOcclusion:")
    public void setOcclusion(float v) { throw new UnsupportedOperationException(); }
    @NotImplemented("position")
    public @ByVal
    com.bugvm.ios.AVFoundation.AVAudio3DPoint getPosition() { throw new UnsupportedOperationException(); }
    @NotImplemented("setPosition:")
    public void setPosition(@ByVal com.bugvm.ios.AVFoundation.AVAudio3DPoint v) { throw new UnsupportedOperationException(); }
    /*<methods>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    @NotImplemented("destinationForMixer:bus:")
    public com.bugvm.ios.AVFoundation.AVAudioMixingDestination getDestinationForMixer(com.bugvm.ios.AVFoundation.AVAudioNode mixer, @MachineSizedUInt long bus) { return null; }
    /*</methods>*/
}
