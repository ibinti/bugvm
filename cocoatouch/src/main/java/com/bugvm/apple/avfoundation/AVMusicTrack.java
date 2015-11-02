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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMusicTrack/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVMusicTrackPtr extends Ptr<AVMusicTrack, AVMusicTrackPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVMusicTrack.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVMusicTrack() {}
    protected AVMusicTrack(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "destinationAudioUnit")
    public native AVAudioUnit getDestinationAudioUnit();
    @Property(selector = "setDestinationAudioUnit:")
    public native void setDestinationAudioUnit(AVAudioUnit v);
    @Property(selector = "destinationMIDIEndpoint")
    public native int getDestinationMIDIEndpoint();
    @Property(selector = "setDestinationMIDIEndpoint:")
    public native void setDestinationMIDIEndpoint(int v);
    @Property(selector = "loopRange")
    public native @ByVal AVBeatRange getLoopRange();
    @Property(selector = "setLoopRange:")
    public native void setLoopRange(@ByVal AVBeatRange v);
    @Property(selector = "isLoopingEnabled")
    public native boolean isLoopingEnabled();
    @Property(selector = "setLoopingEnabled:")
    public native void setLoopingEnabled(boolean v);
    @Property(selector = "numberOfLoops")
    public native @MachineSizedSInt long getNumberOfLoops();
    @Property(selector = "setNumberOfLoops:")
    public native void setNumberOfLoops(@MachineSizedSInt long v);
    @Property(selector = "offsetTime")
    public native double getOffsetTime();
    @Property(selector = "setOffsetTime:")
    public native void setOffsetTime(double v);
    @Property(selector = "isMuted")
    public native boolean isMuted();
    @Property(selector = "setMuted:")
    public native void setMuted(boolean v);
    @Property(selector = "isSoloed")
    public native boolean isSoloed();
    @Property(selector = "setSoloed:")
    public native void setSoloed(boolean v);
    @Property(selector = "lengthInBeats")
    public native double getLengthInBeats();
    @Property(selector = "setLengthInBeats:")
    public native void setLengthInBeats(double v);
    @Property(selector = "lengthInSeconds")
    public native double getLengthInSeconds();
    @Property(selector = "setLengthInSeconds:")
    public native void setLengthInSeconds(double v);
    @Property(selector = "timeResolution")
    public native @MachineSizedUInt long getTimeResolution();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
