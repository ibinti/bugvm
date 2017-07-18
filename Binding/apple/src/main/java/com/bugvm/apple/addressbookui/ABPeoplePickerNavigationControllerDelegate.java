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
package com.bugvm.apple.addressbookui;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.addressbook.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/ABPeoplePickerNavigationControllerDelegate/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "peoplePickerNavigationController:didSelectPerson:")
    void didSelectPerson(ABPeoplePickerNavigationController peoplePicker, ABPerson person);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "peoplePickerNavigationController:didSelectPerson:property:identifier:")
    void didSelectPerson(ABPeoplePickerNavigationController peoplePicker, ABPerson person, ABProperty property, int identifier);
    @Method(selector = "peoplePickerNavigationControllerDidCancel:")
    void didCancel(ABPeoplePickerNavigationController peoplePicker);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Method(selector = "peoplePickerNavigationController:shouldContinueAfterSelectingPerson:")
    boolean shouldContinueAfterSelectingPerson(ABPeoplePickerNavigationController peoplePicker, ABPerson person);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Method(selector = "peoplePickerNavigationController:shouldContinueAfterSelectingPerson:property:identifier:")
    boolean shouldContinueAfterSelectingPerson(ABPeoplePickerNavigationController peoplePicker, ABPerson person, ABProperty property, int identifier);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
