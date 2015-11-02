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
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioSequencer/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioSequencerPtr extends Ptr<AVAudioSequencer, AVAudioSequencerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioSequencer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioSequencer() {}
    protected AVAudioSequencer(SkipInit skipInit) { super(skipInit); }
    public AVAudioSequencer(AVAudioEngine engine) { super((SkipInit) null); initObject(init(engine)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "tracks")
    public native NSArray<AVMusicTrack> getTracks();
    @Property(selector = "tempoTrack")
    public native AVMusicTrack getTempoTrack();
    @Property(selector = "userInfo")
    public native NSDictionary<NSString, ?> getUserInfo();
    @Property(selector = "currentPositionInSeconds")
    public native double getCurrentPositionInSeconds();
    @Property(selector = "setCurrentPositionInSeconds:")
    public native void setCurrentPositionInSeconds(double v);
    @Property(selector = "currentPositionInBeats")
    public native double getCurrentPositionInBeats();
    @Property(selector = "setCurrentPositionInBeats:")
    public native void setCurrentPositionInBeats(double v);
    @Property(selector = "isPlaying")
    public native boolean isPlaying();
    @Property(selector = "rate")
    public native float getRate();
    @Property(selector = "setRate:")
    public native void setRate(float v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithAudioEngine:")
    protected native @Pointer long init(AVAudioEngine engine);
    public boolean load(NSURL fileURL, AVMusicSequenceLoadOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = load(fileURL, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "loadFromURL:options:error:")
    private native boolean load(NSURL fileURL, AVMusicSequenceLoadOptions options, NSError.NSErrorPtr outError);
    public boolean load(NSData data, AVMusicSequenceLoadOptions options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = load(data, options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "loadFromData:options:error:")
    private native boolean load(NSData data, AVMusicSequenceLoadOptions options, NSError.NSErrorPtr outError);
    public boolean write(NSURL fileURL, @MachineSizedSInt long resolution, boolean replace) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = write(fileURL, resolution, replace, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "writeToURL:SMPTEResolution:replaceExisting:error:")
    private native boolean write(NSURL fileURL, @MachineSizedSInt long resolution, boolean replace, NSError.NSErrorPtr outError);
    public NSData getData(@MachineSizedSInt long SMPTEResolution) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       NSData result = getData(SMPTEResolution, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "dataWithSMPTEResolution:error:")
    private native NSData getData(@MachineSizedSInt long SMPTEResolution, NSError.NSErrorPtr outError);
    @Method(selector = "secondsForBeats:")
    public native double convertBeatsToSeconds(double beats);
    @Method(selector = "beatsForSeconds:")
    public native double convertSecondsToBeats(double seconds);
    public long convertBeatsToHostTime(double beats) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long result = convertBeatsToHostTime(beats, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "hostTimeForBeats:error:")
    private native long convertBeatsToHostTime(double beats, NSError.NSErrorPtr outError);
    public double convertHostTimeToBeats(long hostTime) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       double result = convertHostTimeToBeats(hostTime, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "beatsForHostTime:error:")
    private native double convertHostTimeToBeats(long hostTime, NSError.NSErrorPtr outError);
    @Method(selector = "prepareToPlay")
    public native void prepareToPlay();
    public boolean start() throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = start(ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "startAndReturnError:")
    private native boolean start(NSError.NSErrorPtr outError);
    @Method(selector = "stop")
    public native void stop();
    /*</methods>*/
}
