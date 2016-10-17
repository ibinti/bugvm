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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITextChecker/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UITextCheckerPtr extends Ptr<UITextChecker, UITextCheckerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UITextChecker.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UITextChecker() {}
    protected UITextChecker(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "rangeOfMisspelledWordInString:range:startingAt:wrap:language:")
    public native @ByVal NSRange getRangeOfMisspelledWordInString(String stringToCheck, @ByVal NSRange range, @MachineSizedSInt long startingOffset, boolean wrapFlag, String language);
    @Method(selector = "guessesForWordRange:inString:language:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getGuessesForWord(@ByVal NSRange range, String string, String language);
    @Method(selector = "completionsForPartialWordRange:inString:language:")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getCompletionsForPartialWord(@ByVal NSRange range, String string, String language);
    @Method(selector = "ignoreWord:")
    public native void ignoreWord(String wordToIgnore);
    @Method(selector = "ignoredWords")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getIgnoredWords();
    @Method(selector = "setIgnoredWords:")
    public native void setIgnoredWords(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> words);
    @Method(selector = "learnWord:")
    public static native void learnWord(String word);
    @Method(selector = "hasLearnedWord:")
    public static native boolean hasLearnedWord(String word);
    @Method(selector = "unlearnWord:")
    public static native void unlearnWord(String word);
    @Method(selector = "availableLanguages")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getAvailableLanguages();
    /*</methods>*/
}
