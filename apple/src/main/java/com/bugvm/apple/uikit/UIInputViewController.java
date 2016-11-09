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
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIInputViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*/implements UITextInputDelegate/*</implements>*/ {

    /*<ptr>*/public static class UIInputViewControllerPtr extends Ptr<UIInputViewController, UIInputViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIInputViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIInputViewController() {}
    protected UIInputViewController(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "inputView")
    public native UIInputView getInputView();
    @Property(selector = "setInputView:")
    public native void setInputView(UIInputView v);
    @Property(selector = "textDocumentProxy")
    public native UITextDocumentProxy getTextDocumentProxy();
    @Property(selector = "primaryLanguage")
    public native String getPrimaryLanguage();
    @Property(selector = "setPrimaryLanguage:")
    public native void setPrimaryLanguage(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "dismissKeyboard")
    public native void dismissKeyboard();
    @Method(selector = "advanceToNextInputMode")
    public native void advanceToNextInputMode();
    @Method(selector = "requestSupplementaryLexiconWithCompletion:")
    public native void requestSupplementaryLexicon(@Block VoidBlock1<UILexicon> completionHandler);
    @Method(selector = "selectionWillChange:")
    public native void selectionWillChange(UITextInput textInput);
    @Method(selector = "selectionDidChange:")
    public native void selectionDidChange(UITextInput textInput);
    @Method(selector = "textWillChange:")
    public native void textWillChange(UITextInput textInput);
    @Method(selector = "textDidChange:")
    public native void textDidChange(UITextInput textInput);
    /*</methods>*/
}
