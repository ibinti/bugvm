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
package com.bugvm.ios.AudioUnit;

/*<imports>*/

import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AUDependentParameter/*</name>*/ 
    extends /*<extends>*/Struct<AUDependentParameter>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AUDependentParameterPtr extends Ptr<AUDependentParameter, AUDependentParameterPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AUDependentParameter() {}
    public AUDependentParameter(AUScope scope, com.bugvm.ios.AudioUnit.AUParameterType type) {
        this.setScope(scope);
        this.setType(type);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native AUScope getScope();
    @StructMember(0) public native AUDependentParameter setScope(AUScope scope);
    @StructMember(1) public native com.bugvm.ios.AudioUnit.AUParameterType getType();
    @StructMember(1) public native AUDependentParameter setType(com.bugvm.ios.AudioUnit.AUParameterType type);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
