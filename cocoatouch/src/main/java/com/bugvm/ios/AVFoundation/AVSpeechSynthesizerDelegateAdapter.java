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

import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVSpeechSynthesizerDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements AVSpeechSynthesizerDelegate/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @NotImplemented("speechSynthesizer:didStartSpeechUtterance:")
    public void didStartSpeechUtterance(com.bugvm.ios.AVFoundation.AVSpeechSynthesizer synthesizer, com.bugvm.ios.AVFoundation.AVSpeechUtterance utterance) {}
    @NotImplemented("speechSynthesizer:didFinishSpeechUtterance:")
    public void didFinishSpeechUtterance(com.bugvm.ios.AVFoundation.AVSpeechSynthesizer synthesizer, com.bugvm.ios.AVFoundation.AVSpeechUtterance utterance) {}
    @NotImplemented("speechSynthesizer:didPauseSpeechUtterance:")
    public void didPauseSpeechUtterance(com.bugvm.ios.AVFoundation.AVSpeechSynthesizer synthesizer, com.bugvm.ios.AVFoundation.AVSpeechUtterance utterance) {}
    @NotImplemented("speechSynthesizer:didContinueSpeechUtterance:")
    public void didContinueSpeechUtterance(com.bugvm.ios.AVFoundation.AVSpeechSynthesizer synthesizer, com.bugvm.ios.AVFoundation.AVSpeechUtterance utterance) {}
    @NotImplemented("speechSynthesizer:didCancelSpeechUtterance:")
    public void didCancelSpeechUtterance(com.bugvm.ios.AVFoundation.AVSpeechSynthesizer synthesizer, com.bugvm.ios.AVFoundation.AVSpeechUtterance utterance) {}
    @NotImplemented("speechSynthesizer:willSpeakRangeOfSpeechString:utterance:")
    public void willSpeak(com.bugvm.ios.AVFoundation.AVSpeechSynthesizer synthesizer, @ByVal NSRange characterRange, com.bugvm.ios.AVFoundation.AVSpeechUtterance utterance) {}
    /*</methods>*/
}
