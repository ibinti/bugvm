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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioUnitSampler/*</name>*/ 
    extends /*<extends>*/AVAudioUnitMIDIInstrument/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioUnitSamplerPtr extends Ptr<AVAudioUnitSampler, AVAudioUnitSamplerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioUnitSampler.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioUnitSampler() {}
    protected AVAudioUnitSampler(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "stereoPan")
    public native float getStereoPan();
    @Property(selector = "setStereoPan:")
    public native void setStereoPan(float v);
    @Property(selector = "masterGain")
    public native float getMasterGain();
    @Property(selector = "setMasterGain:")
    public native void setMasterGain(float v);
    @Property(selector = "globalTuning")
    public native float getGlobalTuning();
    @Property(selector = "setGlobalTuning:")
    public native void setGlobalTuning(float v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    public boolean loadSoundBankInstrument(NSURL bankURL, byte program, byte bankMSB, byte bankLSB) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = loadSoundBankInstrument(bankURL, program, bankMSB, bankLSB, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "loadSoundBankInstrumentAtURL:program:bankMSB:bankLSB:error:")
    private native boolean loadSoundBankInstrument(NSURL bankURL, byte program, byte bankMSB, byte bankLSB, NSError.NSErrorPtr outError);
    public boolean loadInstrument(NSURL instrumentURL) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = loadInstrument(instrumentURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "loadInstrumentAtURL:error:")
    private native boolean loadInstrument(NSURL instrumentURL, NSError.NSErrorPtr outError);
    public boolean loadAudioFiles(NSArray<NSURL> audioFiles) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = loadAudioFiles(audioFiles, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    @Method(selector = "loadAudioFilesAtURLs:error:")
    private native boolean loadAudioFiles(NSArray<NSURL> audioFiles, NSError.NSErrorPtr outError);
    /*</methods>*/
}
