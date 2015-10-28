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

import com.bugvm.apple.coreaudio.AudioChannelLayout;
import com.bugvm.apple.coreaudio.AudioChannelLayoutTag;
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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioChannelLayout/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioChannelLayoutPtr extends Ptr<AVAudioChannelLayout, AVAudioChannelLayoutPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioChannelLayout.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioChannelLayout() {}
    protected AVAudioChannelLayout(SkipInit skipInit) { super(skipInit); }
    public AVAudioChannelLayout(AudioChannelLayoutTag layoutTag) { super((SkipInit) null); initObject(init(layoutTag)); }
    @WeaklyLinked
    public AVAudioChannelLayout(AudioChannelLayout layout) { super((SkipInit) null); initObject(init(layout)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "layoutTag")
    public native AudioChannelLayoutTag getLayoutTag();
    @WeaklyLinked
    @Property(selector = "layout")
    public native AudioChannelLayout getLayout();
    @Property(selector = "channelCount")
    public native int getChannelCount();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithLayoutTag:")
    protected native @Pointer long init(AudioChannelLayoutTag layoutTag);
    @WeaklyLinked
    @Method(selector = "initWithLayout:")
    protected native @Pointer long init(AudioChannelLayout layout);
    @Method(selector = "isEqual:")
    public native boolean equalsTo(AVAudioChannelLayout object);
    /*</methods>*/
}
