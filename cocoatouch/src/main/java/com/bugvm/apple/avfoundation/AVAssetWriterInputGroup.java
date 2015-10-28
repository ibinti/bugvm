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

import com.bugvm.apple.foundation.NSArray;
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
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetWriterInputGroup/*</name>*/ 
    extends /*<extends>*/AVMediaSelectionGroup/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVAssetWriterInputGroupPtr extends Ptr<AVAssetWriterInputGroup, AVAssetWriterInputGroupPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetWriterInputGroup.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetWriterInputGroup() {}
    protected AVAssetWriterInputGroup(NSObject.SkipInit skipInit) { super(skipInit); }
    public AVAssetWriterInputGroup(NSArray<AVAssetWriterInput> inputs, AVAssetWriterInput defaultInput) { super((NSObject.SkipInit) null); initObject(init(inputs, defaultInput)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "inputs")
    public native NSArray<AVAssetWriterInput> getInputs();
    @Property(selector = "defaultInput")
    public native AVAssetWriterInput getDefaultInput();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithInputs:defaultInput:")
    protected native @Pointer long init(NSArray<AVAssetWriterInput> inputs, AVAssetWriterInput defaultInput);
    /*</methods>*/
}
