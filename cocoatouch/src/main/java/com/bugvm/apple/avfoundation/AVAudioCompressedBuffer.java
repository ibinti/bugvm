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

import com.bugvm.apple.coreaudio.AudioStreamPacketDescription;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioCompressedBuffer/*</name>*/ 
    extends /*<extends>*/AVAudioBuffer/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioCompressedBufferPtr extends Ptr<AVAudioCompressedBuffer, AVAudioCompressedBufferPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioCompressedBuffer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioCompressedBuffer() {}
    protected AVAudioCompressedBuffer(NSObject.SkipInit skipInit) { super(skipInit); }
    public AVAudioCompressedBuffer(AVAudioFormat format, int packetCapacity, @MachineSizedSInt long maximumPacketSize) { super((NSObject.SkipInit) null); initObject(init(format, packetCapacity, maximumPacketSize)); }
    public AVAudioCompressedBuffer(AVAudioFormat format, int packetCapacity) { super((NSObject.SkipInit) null); initObject(init(format, packetCapacity)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "packetCapacity")
    public native int getPacketCapacity();
    @Property(selector = "packetCount")
    public native int getPacketCount();
    @Property(selector = "setPacketCount:")
    public native void setPacketCount(int v);
    @Property(selector = "maximumPacketSize")
    public native @MachineSizedSInt long getMaximumPacketSize();
    @Property(selector = "data")
    public native @Pointer long getDataPointer();
    @Property(selector = "packetDescriptions")
    public native AudioStreamPacketDescription getPacketDescriptions();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithFormat:packetCapacity:maximumPacketSize:")
    protected native @Pointer long init(AVAudioFormat format, int packetCapacity, @MachineSizedSInt long maximumPacketSize);
    @Method(selector = "initWithFormat:packetCapacity:")
    protected native @Pointer long init(AVAudioFormat format, int packetCapacity);
    /*</methods>*/
}
