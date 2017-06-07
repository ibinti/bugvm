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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITextInputStringTokenizer/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements UITextInputTokenizer/*</implements>*/ {

    /*<ptr>*/public static class UITextInputStringTokenizerPtr extends Ptr<UITextInputStringTokenizer, UITextInputStringTokenizerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UITextInputStringTokenizer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UITextInputStringTokenizer() {}
    protected UITextInputStringTokenizer(SkipInit skipInit) { super(skipInit); }
    public UITextInputStringTokenizer(UITextInput textInput) { super((SkipInit) null); initObject(init(textInput)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithTextInput:")
    protected native @Pointer long init(UITextInput textInput);
    @Method(selector = "rangeEnclosingPosition:withGranularity:inDirection:")
    public native UITextRange getRangeEnclosingPosition(UITextPosition position, UITextGranularity granularity, UITextDirection direction);
    @Method(selector = "isPosition:atBoundary:inDirection:")
    public native boolean isPositionAtBoundary(UITextPosition position, UITextGranularity granularity, UITextDirection direction);
    @Method(selector = "positionFromPosition:toBoundary:inDirection:")
    public native UITextPosition getPosition(UITextPosition position, UITextGranularity granularity, UITextDirection direction);
    @Method(selector = "isPosition:withinTextUnit:inDirection:")
    public native boolean isPositionWithinTextUnit(UITextPosition position, UITextGranularity granularity, UITextDirection direction);
    /*</methods>*/
}
