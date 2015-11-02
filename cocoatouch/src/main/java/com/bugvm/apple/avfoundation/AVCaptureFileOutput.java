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
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVCaptureFileOutput/*</name>*/ 
    extends /*<extends>*/AVCaptureOutput/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVCaptureFileOutputPtr extends Ptr<AVCaptureFileOutput, AVCaptureFileOutputPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVCaptureFileOutput.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVCaptureFileOutput() {}
    protected AVCaptureFileOutput(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "outputFileURL")
    public native NSURL getOutputFileURL();
    @Property(selector = "isRecording")
    public native boolean isRecording();
    @Property(selector = "recordedDuration")
    public native @ByVal CMTime getRecordedDuration();
    @Property(selector = "recordedFileSize")
    public native long getRecordedFileSize();
    @Property(selector = "maxRecordedDuration")
    public native @ByVal CMTime getMaxRecordedDuration();
    @Property(selector = "setMaxRecordedDuration:")
    public native void setMaxRecordedDuration(@ByVal CMTime v);
    @Property(selector = "maxRecordedFileSize")
    public native long getMaxRecordedFileSize();
    @Property(selector = "setMaxRecordedFileSize:")
    public native void setMaxRecordedFileSize(long v);
    @Property(selector = "minFreeDiskSpaceLimit")
    public native long getMinFreeDiskSpaceLimit();
    @Property(selector = "setMinFreeDiskSpaceLimit:")
    public native void setMinFreeDiskSpaceLimit(long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "startRecordingToOutputFileURL:recordingDelegate:")
    public native void startRecording(NSURL outputFileURL, AVCaptureFileOutputRecordingDelegate delegate);
    @Method(selector = "stopRecording")
    public native void stopRecording();
    /*</methods>*/
}
