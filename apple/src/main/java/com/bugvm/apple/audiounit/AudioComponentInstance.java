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
package com.bugvm.apple.audiounit;

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
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("AudioToolbox")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioComponentInstance/*</name>*/ 
    extends /*<extends>*/NativeObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioComponentInstancePtr extends Ptr<AudioComponentInstance, AudioComponentInstancePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(AudioComponentInstance.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected AudioComponentInstance() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static AudioComponentInstance create(AudioComponent component) throws OSStatusException {
        AudioComponentInstance.AudioComponentInstancePtr ptr = new AudioComponentInstance.AudioComponentInstancePtr();
        OSStatus status = create0(component, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void dispose() throws OSStatusException {
        OSStatus status = dispose0();
        OSStatusException.throwIfNecessary(status);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioComponentInstanceNew", optional=true)
    protected static native OSStatus create0(AudioComponent inComponent, AudioComponentInstance.AudioComponentInstancePtr outInstance);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioComponentInstanceDispose", optional=true)
    protected native OSStatus dispose0();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioComponentInstanceGetComponent", optional=true)
    public native AudioComponent getComponent();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Bridge(symbol="AudioComponentInstanceCanDo", optional=true)
     native boolean canDo(short inSelectorID);
    /*</methods>*/
}
