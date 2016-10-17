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
package com.bugvm.apple.avfoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.mediatoolbox.*;
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.audiounit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioPlayerNode/*</name>*/ 
    extends /*<extends>*/AVAudioNode/*</extends>*/ 
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
    public native AVAudio3DMixingRenderingAlgorithm getRenderingAlgorithm();
    @Property(selector = "setRenderingAlgorithm:")
    public native void setRenderingAlgorithm(AVAudio3DMixingRenderingAlgorithm v);
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
    public native @ByVal AVAudio3DPoint getPosition();
    @Property(selector = "setPosition:")
    public native void setPosition(@ByVal AVAudio3DPoint v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "scheduleBuffer:completionHandler:")
    public native void scheduleBuffer(AVAudioPCMBuffer buffer, @Block Runnable completionHandler);
    @Method(selector = "scheduleBuffer:atTime:options:completionHandler:")
    public native void scheduleBuffer(AVAudioPCMBuffer buffer, AVAudioTime when, AVAudioPlayerNodeBufferOptions options, @Block Runnable completionHandler);
    @Method(selector = "scheduleFile:atTime:completionHandler:")
    public native void scheduleFile(AVAudioFile file, AVAudioTime when, @Block Runnable completionHandler);
    @Method(selector = "scheduleSegment:startingFrame:frameCount:atTime:completionHandler:")
    public native void scheduleSegment(AVAudioFile file, long startFrame, int numberFrames, AVAudioTime when, @Block Runnable completionHandler);
    @Method(selector = "stop")
    public native void stop();
    @Method(selector = "prepareWithFrameCount:")
    public native void prepare(int frameCount);
    @Method(selector = "play")
    public native void play();
    @Method(selector = "playAtTime:")
    public native void playAtTime(AVAudioTime when);
    @Method(selector = "pause")
    public native void pause();
    @Method(selector = "nodeTimeForPlayerTime:")
    public native AVAudioTime convertPlayerTimeToNodeTime(AVAudioTime playerTime);
    @Method(selector = "playerTimeForNodeTime:")
    public native AVAudioTime convertNodeTimeToPlayerTime(AVAudioTime nodeTime);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "destinationForMixer:bus:")
    public native AVAudioMixingDestination getDestinationForMixer(AVAudioNode mixer, @MachineSizedUInt long bus);
    /*</methods>*/
}
