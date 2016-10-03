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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioPlayerNode/*</name>*/ 
    extends /*<extends>*/com.bugvm.ios.AVFoundation.AVAudioNode/*</extends>*/
    /*<implements>*/implements AVAudioMixing/*</implements>*/ {

    /*<ptr>*/public static class AVAudioPlayerNodePtr extends Ptr<AVAudioPlayerNode, AVAudioPlayerNodePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioPlayerNode.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioPlayerNode() {}
    protected AVAudioPlayerNode(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isPlaying")
    public native boolean isPlaying();
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
    @Method(selector = "scheduleBuffer:completionHandler:")
    public native void scheduleBuffer(com.bugvm.ios.AVFoundation.AVAudioPCMBuffer buffer, @Block Runnable completionHandler);
    @Method(selector = "scheduleBuffer:atTime:options:completionHandler:")
    public native void scheduleBuffer(com.bugvm.ios.AVFoundation.AVAudioPCMBuffer buffer, com.bugvm.ios.AVFoundation.AVAudioTime when, com.bugvm.ios.AVFoundation.AVAudioPlayerNodeBufferOptions options, @Block Runnable completionHandler);
    @Method(selector = "scheduleFile:atTime:completionHandler:")
    public native void scheduleFile(com.bugvm.ios.AVFoundation.AVAudioFile file, com.bugvm.ios.AVFoundation.AVAudioTime when, @Block Runnable completionHandler);
    @Method(selector = "scheduleSegment:startingFrame:frameCount:atTime:completionHandler:")
    public native void scheduleSegment(com.bugvm.ios.AVFoundation.AVAudioFile file, long startFrame, int numberFrames, com.bugvm.ios.AVFoundation.AVAudioTime when, @Block Runnable completionHandler);
    @Method(selector = "stop")
    public native void stop();
    @Method(selector = "prepareWithFrameCount:")
    public native void prepare(int frameCount);
    @Method(selector = "play")
    public native void play();
    @Method(selector = "playAtTime:")
    public native void playAtTime(com.bugvm.ios.AVFoundation.AVAudioTime when);
    @Method(selector = "pause")
    public native void pause();
    @Method(selector = "nodeTimeForPlayerTime:")
    public native com.bugvm.ios.AVFoundation.AVAudioTime convertPlayerTimeToNodeTime(com.bugvm.ios.AVFoundation.AVAudioTime playerTime);
    @Method(selector = "playerTimeForNodeTime:")
    public native com.bugvm.ios.AVFoundation.AVAudioTime convertNodeTimeToPlayerTime(com.bugvm.ios.AVFoundation.AVAudioTime nodeTime);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "destinationForMixer:bus:")
    public native com.bugvm.ios.AVFoundation.AVAudioMixingDestination getDestinationForMixer(com.bugvm.ios.AVFoundation.AVAudioNode mixer, @MachineSizedUInt long bus);
    /*</methods>*/
}
