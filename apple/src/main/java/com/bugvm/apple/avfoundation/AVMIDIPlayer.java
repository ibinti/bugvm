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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMIDIPlayer/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVMIDIPlayerPtr extends Ptr<AVMIDIPlayer, AVMIDIPlayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVMIDIPlayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVMIDIPlayer() {}
    protected AVMIDIPlayer(SkipInit skipInit) { super(skipInit); }
    public AVMIDIPlayer(NSURL inURL, NSURL bankURL) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(inURL, bankURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    public AVMIDIPlayer(NSData data, NSURL bankURL) throws NSErrorException {
       super((SkipInit) null);
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       long handle = init(data, bankURL, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       initObject(handle);
    }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "duration")
    public native double getDuration();
    @Property(selector = "isPlaying")
    public native boolean isPlaying();
    @Property(selector = "rate")
    public native float getRate();
    @Property(selector = "setRate:")
    public native void setRate(float v);
    @Property(selector = "currentPosition")
    public native double getCurrentPosition();
    @Property(selector = "setCurrentPosition:")
    public native void setCurrentPosition(double v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithContentsOfURL:soundBankURL:error:")
    private native @Pointer long init(NSURL inURL, NSURL bankURL, NSError.NSErrorPtr outError);
    @Method(selector = "initWithData:soundBankURL:error:")
    private native @Pointer long init(NSData data, NSURL bankURL, NSError.NSErrorPtr outError);
    @Method(selector = "prepareToPlay")
    public native void prepareToPlay();
    @Method(selector = "play:")
    public native void play(@Block Runnable completionHandler);
    @Method(selector = "stop")
    public native void stop();
    /*</methods>*/
}
