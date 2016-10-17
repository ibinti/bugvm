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
package com.bugvm.apple.mediaplayer;

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
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPMediaPropertyPredicate/*</name>*/ 
    extends /*<extends>*/MPMediaPredicate/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPMediaPropertyPredicatePtr extends Ptr<MPMediaPropertyPredicate, MPMediaPropertyPredicatePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPMediaPropertyPredicate.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MPMediaPropertyPredicate() {}
    protected MPMediaPropertyPredicate(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public MPMediaEntityProperty getProperty() {
        return MPMediaEntityProperty.valueOf(getPropertyName());
    }
    public static MPMediaPropertyPredicate create(MPMediaEntityProperty property, NSObject value) {
        return create(value, property.value());
    }
    public static MPMediaPropertyPredicate create(MPMediaEntityProperty property, NSObject value, MPMediaPredicateComparison comparisonType) {
        return create(value, property.value(), comparisonType);
    }
    /*<properties>*/
    @Property(selector = "property")
    public native NSString getPropertyName();
    @Property(selector = "value")
    public native NSObject getValue();
    @Property(selector = "comparisonType")
    public native MPMediaPredicateComparison getComparisonType();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "predicateWithValue:forProperty:")
    protected static native MPMediaPropertyPredicate create(NSObject value, NSString property);
    @Method(selector = "predicateWithValue:forProperty:comparisonType:")
    protected static native MPMediaPropertyPredicate create(NSObject value, NSString property, MPMediaPredicateComparison comparisonType);
    /*</methods>*/
}
