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
import java.util.*;

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioEnvironmentNode/*</name>*/ 
    extends /*<extends>*/com.bugvm.ios.AVFoundation.AVAudioNode/*</extends>*/
    /*<implements>*/implements AVAudioMixing/*</implements>*/ {

    /*<ptr>*/public static class AVAudioEnvironmentNodePtr extends Ptr<AVAudioEnvironmentNode, AVAudioEnvironmentNodePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioEnvironmentNode.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioEnvironmentNode() {}
    protected AVAudioEnvironmentNode(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "outputVolume")
    public native float getOutputVolume();
    @Property(selector = "setOutputVolume:")
    public native void setOutputVolume(float v);
    @Property(selector = "nextAvailableInputBus")
    public native @MachineSizedUInt long getNextAvailableInputBus();
    @Property(selector = "listenerPosition")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVAudio3DPoint getListenerPosition();
    @Property(selector = "setListenerPosition:")
    public native void setListenerPosition(@ByVal com.bugvm.ios.AVFoundation.AVAudio3DPoint v);
    @Property(selector = "listenerVectorOrientation")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVAudio3DVectorOrientation getListenerVectorOrientation();
    @Property(selector = "setListenerVectorOrientation:")
    public native void setListenerVectorOrientation(@ByVal com.bugvm.ios.AVFoundation.AVAudio3DVectorOrientation v);
    @Property(selector = "listenerAngularOrientation")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVAudio3DAngularOrientation getListenerAngularOrientation();
    @Property(selector = "setListenerAngularOrientation:")
    public native void setListenerAngularOrientation(@ByVal com.bugvm.ios.AVFoundation.AVAudio3DAngularOrientation v);
    @Property(selector = "distanceAttenuationParameters")
    public native com.bugvm.ios.AVFoundation.AVAudioEnvironmentDistanceAttenuationParameters getDistanceAttenuationParameters();
    @Property(selector = "reverbParameters")
    public native com.bugvm.ios.AVFoundation.AVAudioEnvironmentReverbParameters getReverbParameters();
    @Property(selector = "applicableRenderingAlgorithms")
    public native @com.bugvm.rt.bro.annotation.Marshaler(com.bugvm.ios.AVFoundation.AVAudio3DMixingRenderingAlgorithm.AsListMarshaler.class) List<com.bugvm.ios.AVFoundation.AVAudio3DMixingRenderingAlgorithm> getApplicableRenderingAlgorithms();
    @Property(selector = "volume")
    public native float getVolume();
    @Property(selector = "setVolume:")
    public native void setVolume(float v);
    @Property(selector = "pan")
    public native float getPan();
    @Property(selector = "setPan:")
    public native void setPan(float v);
    @Property(selector = "renderingAlgorithm")
    public native com.bugvm.ios.AVFoundation.AVAudio3DMixingRenderingAlgorithm getRenderingAlgorithm();
    @Property(selector = "setRenderingAlgorithm:")
    public native void setRenderingAlgorithm(com.bugvm.ios.AVFoundation.AVAudio3DMixingRenderingAlgorithm v);
    @Property(selector = "rate")
    public native float getRate();
    @Property(selector = "setRate:")
    public native void setRate(float v);
    @Property(selector = "reverbBlend")
    public native float getReverbBlend();
    @Property(selector = "setReverbBlend:")
    public native void setReverbBlend(float v);
    @Property(selector = "obstruction")
    public native float getObstruction();
    @Property(selector = "setObstruction:")
    public native void setObstruction(float v);
    @Property(selector = "occlusion")
    public native float getOcclusion();
    @Property(selector = "setOcclusion:")
    public native void setOcclusion(float v);
    @Property(selector = "position")
    public native @ByVal
    com.bugvm.ios.AVFoundation.AVAudio3DPoint getPosition();
    @Property(selector = "setPosition:")
    public native void setPosition(@ByVal com.bugvm.ios.AVFoundation.AVAudio3DPoint v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "destinationForMixer:bus:")
    public native com.bugvm.ios.AVFoundation.AVAudioMixingDestination getDestinationForMixer(com.bugvm.ios.AVFoundation.AVAudioNode mixer, @MachineSizedUInt long bus);
    /*</methods>*/
}
