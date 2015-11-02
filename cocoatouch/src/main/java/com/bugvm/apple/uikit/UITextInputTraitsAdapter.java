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
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITextInputTraitsAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements UITextInputTraits/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    @NotImplemented("autocapitalizationType")
    public UITextAutocapitalizationType getAutocapitalizationType() { return null; }
    @NotImplemented("setAutocapitalizationType:")
    public void setAutocapitalizationType(UITextAutocapitalizationType v) {}
    @NotImplemented("autocorrectionType")
    public UITextAutocorrectionType getAutocorrectionType() { return null; }
    @NotImplemented("setAutocorrectionType:")
    public void setAutocorrectionType(UITextAutocorrectionType v) {}
    /**
     * @since Available in iOS 5.0 and later.
     */
    @NotImplemented("spellCheckingType")
    public UITextSpellCheckingType getSpellCheckingType() { return null; }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @NotImplemented("setSpellCheckingType:")
    public void setSpellCheckingType(UITextSpellCheckingType v) {}
    @NotImplemented("keyboardType")
    public UIKeyboardType getKeyboardType() { return null; }
    @NotImplemented("setKeyboardType:")
    public void setKeyboardType(UIKeyboardType v) {}
    @NotImplemented("keyboardAppearance")
    public UIKeyboardAppearance getKeyboardAppearance() { return null; }
    @NotImplemented("setKeyboardAppearance:")
    public void setKeyboardAppearance(UIKeyboardAppearance v) {}
    @NotImplemented("returnKeyType")
    public UIReturnKeyType getReturnKeyType() { return null; }
    @NotImplemented("setReturnKeyType:")
    public void setReturnKeyType(UIReturnKeyType v) {}
    @NotImplemented("enablesReturnKeyAutomatically")
    public boolean enablesReturnKeyAutomatically() { return false; }
    @NotImplemented("setEnablesReturnKeyAutomatically:")
    public void setEnablesReturnKeyAutomatically(boolean v) {}
    @NotImplemented("isSecureTextEntry")
    public boolean isSecureTextEntry() { return false; }
    @NotImplemented("setSecureTextEntry:")
    public void setSecureTextEntry(boolean v) {}
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
