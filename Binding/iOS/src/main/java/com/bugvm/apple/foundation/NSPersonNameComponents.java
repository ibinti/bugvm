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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 9.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSPersonNameComponents/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSPersonNameComponentsPtr extends Ptr<NSPersonNameComponents, NSPersonNameComponentsPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSPersonNameComponents.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSPersonNameComponents() {}
    protected NSPersonNameComponents(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "namePrefix")
    public native String getNamePrefix();
    @Property(selector = "setNamePrefix:")
    public native void setNamePrefix(String v);
    @Property(selector = "givenName")
    public native String getGivenName();
    @Property(selector = "setGivenName:")
    public native void setGivenName(String v);
    @Property(selector = "middleName")
    public native String getMiddleName();
    @Property(selector = "setMiddleName:")
    public native void setMiddleName(String v);
    @Property(selector = "familyName")
    public native String getFamilyName();
    @Property(selector = "setFamilyName:")
    public native void setFamilyName(String v);
    @Property(selector = "nameSuffix")
    public native String getNameSuffix();
    @Property(selector = "setNameSuffix:")
    public native void setNameSuffix(String v);
    @Property(selector = "nickname")
    public native String getNickname();
    @Property(selector = "setNickname:")
    public native void setNickname(String v);
    @Property(selector = "phoneticRepresentation")
    public native NSPersonNameComponents getPhoneticRepresentation();
    @Property(selector = "setPhoneticRepresentation:")
    public native void setPhoneticRepresentation(NSPersonNameComponents v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
