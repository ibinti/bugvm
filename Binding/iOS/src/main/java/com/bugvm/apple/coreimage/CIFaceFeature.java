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
package com.bugvm.apple.coreimage;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.imageio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("CoreImage") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CIFaceFeature/*</name>*/ 
    extends /*<extends>*/CIFeature/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CIFaceFeaturePtr extends Ptr<CIFaceFeature, CIFaceFeaturePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CIFaceFeature.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CIFaceFeature() {}
    protected CIFaceFeature(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "bounds")
    public native @ByVal CGRect getBounds();
    @Property(selector = "hasLeftEyePosition")
    public native boolean hasLeftEyePosition();
    @Property(selector = "leftEyePosition")
    public native @ByVal CGPoint getLeftEyePosition();
    @Property(selector = "hasRightEyePosition")
    public native boolean hasRightEyePosition();
    @Property(selector = "rightEyePosition")
    public native @ByVal CGPoint getRightEyePosition();
    @Property(selector = "hasMouthPosition")
    public native boolean hasMouthPosition();
    @Property(selector = "mouthPosition")
    public native @ByVal CGPoint getMouthPosition();
    @Property(selector = "hasTrackingID")
    public native boolean hasTrackingID();
    @Property(selector = "trackingID")
    public native int getTrackingID();
    @Property(selector = "hasTrackingFrameCount")
    public native boolean hasTrackingFrameCount();
    @Property(selector = "trackingFrameCount")
    public native int getTrackingFrameCount();
    @Property(selector = "hasFaceAngle")
    public native boolean hasFaceAngle();
    @Property(selector = "faceAngle")
    public native float getFaceAngle();
    @Property(selector = "hasSmile")
    public native boolean hasSmile();
    @Property(selector = "leftEyeClosed")
    public native boolean isLeftEyeClosed();
    @Property(selector = "rightEyeClosed")
    public native boolean isRightEyeClosed();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
