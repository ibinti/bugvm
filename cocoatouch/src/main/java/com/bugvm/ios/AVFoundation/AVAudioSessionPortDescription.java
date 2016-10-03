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
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAudioSessionPortDescription/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAudioSessionPortDescriptionPtr extends Ptr<AVAudioSessionPortDescription, AVAudioSessionPortDescriptionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAudioSessionPortDescription.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAudioSessionPortDescription() {}
    protected AVAudioSessionPortDescription(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "portType")
    public native AVAudioSessionPort getPortType();
    @Property(selector = "portName")
    public native String getPortName();
    @Property(selector = "UID")
    public native String getUID();
    @Property(selector = "channels")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAudioSessionChannelDescription> getChannels();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "dataSources")
    public native NSArray<com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription> getDataSources();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "selectedDataSource")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription getSelectedDataSource();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "preferredDataSource")
    public native com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription getPreferredDataSource();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    public boolean setPreferredDataSource(com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription dataSource) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = setPreferredDataSource(dataSource, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "setPreferredDataSource:error:")
    private native boolean setPreferredDataSource(com.bugvm.ios.AVFoundation.AVAudioSessionDataSourceDescription dataSource, NSError.NSErrorPtr outError);
    /*</methods>*/
}
