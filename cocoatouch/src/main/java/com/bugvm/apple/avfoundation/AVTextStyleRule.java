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
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVTextStyleRule/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVTextStyleRulePtr extends Ptr<AVTextStyleRule, AVTextStyleRulePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVTextStyleRule.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVTextStyleRule() {}
    protected AVTextStyleRule(SkipInit skipInit) { super(skipInit); }
    public AVTextStyleRule(CMTextMarkupAttributes textMarkupAttributes) { super((SkipInit) null); initObject(init(textMarkupAttributes)); }
    public AVTextStyleRule(CMTextMarkupAttributes textMarkupAttributes, String textSelector) { super((SkipInit) null); initObject(init(textMarkupAttributes, textSelector)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "textMarkupAttributes")
    public native CMTextMarkupAttributes getTextMarkupAttributes();
    @Property(selector = "textSelector")
    public native String getTextSelector();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithTextMarkupAttributes:")
    protected native @Pointer long init(CMTextMarkupAttributes textMarkupAttributes);
    @Method(selector = "initWithTextMarkupAttributes:textSelector:")
    protected native @Pointer long init(CMTextMarkupAttributes textMarkupAttributes, String textSelector);
    @Method(selector = "propertyListForTextStyleRules:")
    public static native NSPropertyList createPropertyList(NSArray<AVTextStyleRule> textStyleRules);
    @Method(selector = "textStyleRulesFromPropertyList:")
    public static native NSArray<AVTextStyleRule> createTextStyleRulesArray(NSPropertyList plist);
    /*</methods>*/
}
