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

import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.Selector;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSComparisonPredicate/*</name>*/ 
    extends /*<extends>*/NSPredicate/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSComparisonPredicatePtr extends Ptr<NSComparisonPredicate, NSComparisonPredicatePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSComparisonPredicate.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSComparisonPredicate() {}
    protected NSComparisonPredicate(SkipInit skipInit) { super(skipInit); }
    public NSComparisonPredicate(NSExpression lhs, NSExpression rhs, NSComparisonPredicateModifier modifier, NSPredicateOperatorType type, NSComparisonPredicateOptions options) { super((SkipInit) null); initObject(init(lhs, rhs, modifier, type, options)); }
    public NSComparisonPredicate(NSExpression lhs, NSExpression rhs, Selector selector) { super((SkipInit) null); initObject(init(lhs, rhs, selector)); }
    public NSComparisonPredicate(NSCoder coder) { super((SkipInit) null); initObject(init(coder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "predicateOperatorType")
    public native NSPredicateOperatorType getPredicateOperatorType();
    @Property(selector = "comparisonPredicateModifier")
    public native NSComparisonPredicateModifier getComparisonPredicateModifier();
    @Property(selector = "leftExpression")
    public native NSExpression getLeftExpression();
    @Property(selector = "rightExpression")
    public native NSExpression getRightExpression();
    @Property(selector = "customSelector")
    public native Selector getCustomSelector();
    @Property(selector = "options")
    public native NSComparisonPredicateOptions getOptions();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithLeftExpression:rightExpression:modifier:type:options:")
    protected native @Pointer long init(NSExpression lhs, NSExpression rhs, NSComparisonPredicateModifier modifier, NSPredicateOperatorType type, NSComparisonPredicateOptions options);
    @Method(selector = "initWithLeftExpression:rightExpression:customSelector:")
    protected native @Pointer long init(NSExpression lhs, NSExpression rhs, Selector selector);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder coder);
    /*</methods>*/
}
