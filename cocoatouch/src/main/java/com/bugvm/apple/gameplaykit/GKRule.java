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
package com.bugvm.apple.gameplaykit;

/*<imports>*/

import com.bugvm.apple.foundation.NSObject;
import com.bugvm.apple.foundation.NSPredicate;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Block;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.block.Block1;
import com.bugvm.objc.block.VoidBlock1;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("GameplayKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKRule/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKRulePtr extends Ptr<GKRule, GKRulePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKRule.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKRule() {}
    protected GKRule(SkipInit skipInit) { super(skipInit); }
    public GKRule(@Block Block1<GKRuleSystem, Boolean> predicate, @Block VoidBlock1<GKRuleSystem> action) { super(create(predicate, action)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "salience")
    public native @MachineSizedSInt long getSalience();
    @Property(selector = "setSalience:")
    public native void setSalience(@MachineSizedSInt long v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "evaluatePredicateWithSystem:")
    public native boolean evaluatePredicate(GKRuleSystem system);
    @Method(selector = "performActionWithSystem:")
    public native void performAction(GKRuleSystem system);
    @Method(selector = "ruleWithPredicate:assertingFact:grade:")
    public static native GKRule createAssertingFact(NSPredicate predicate, NSObject fact, float grade);
    @Method(selector = "ruleWithPredicate:retractingFact:grade:")
    public static native GKRule createRetractingFact(NSPredicate predicate, NSObject fact, float grade);
    @Method(selector = "ruleWithBlockPredicate:action:")
    private static native @Pointer long create(@Block Block1<GKRuleSystem, Boolean> predicate, @Block VoidBlock1<GKRuleSystem> action);
    /*</methods>*/
}
