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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CIDetector/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CIDetectorPtr extends Ptr<CIDetector, CIDetectorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CIDetector.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CIDetector() {}
    protected CIDetector(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    
    public CIDetector(CIDetectorType type, CIContext context, CIDetectorOptions options) {
        super(init(type, context, options));
    }
    
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "featuresInImage:")
    public native NSArray<CIFeature> findFeatures(CIImage image);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "featuresInImage:options:")
    public native NSArray<CIFeature> findFeatures(CIImage image, CIDetectorFeatureOptions options);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "detectorOfType:context:options:")
    protected static native @Pointer long init(CIDetectorType type, CIContext context, CIDetectorOptions options);
    /*</methods>*/
}
