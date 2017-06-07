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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioUnitComponent/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {
    
    public static class Notifications {
        /**
         * @since Available in iOS 9.0 and later.
         */
        public static NSObject observeTagsDidChange(AVAudioUnitComponent object, final VoidBlock1<AVAudioUnitComponent> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(TagsDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVAudioUnitComponent) notification.getObject());
                }
            });
        }
    }

    /*<ptr>*/public static class AVAudioUnitComponentPtr extends Ptr<AVAudioUnitComponent, AVAudioUnitComponentPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioUnitComponent.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioUnitComponent() {}
    protected AVAudioUnitComponent(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "name")
    public native String getName();
    @Property(selector = "typeName")
    public native String getTypeName();
    @Property(selector = "localizedTypeName")
    public native String getLocalizedTypeName();
    @Property(selector = "manufacturerName")
    public native String getManufacturerName();
    @Property(selector = "version")
    public native @MachineSizedUInt long getVersion();
    @Property(selector = "versionString")
    public native String getVersionString();
    @Property(selector = "isSandboxSafe")
    public native boolean isSandboxSafe();
    @Property(selector = "hasMIDIInput")
    public native boolean hasMIDIInput();
    @Property(selector = "hasMIDIOutput")
    public native boolean hasMIDIOutput();
    @Property(selector = "audioComponent")
    public native AudioComponent getAudioComponent();
    @Property(selector = "allTagNames")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAllTagNames();
    @Property(selector = "audioComponentDescription")
    public native @ByVal AudioComponentDescription getAudioComponentDescription();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="AVAudioUnitComponentTagsDidChangeNotification", optional=true)
    public static native NSString TagsDidChangeNotification();
    
    
    /*</methods>*/
}
