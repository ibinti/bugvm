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
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSExpression/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSExpressionPtr extends Ptr<NSExpression, NSExpressionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSExpression.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSExpression() {}
    protected NSExpression(long handle) { super(handle); }
    protected NSExpression(SkipInit skipInit) { super(skipInit); }
    public NSExpression(NSExpressionType type) { super((SkipInit) null); initObject(init(type)); }
    public NSExpression(NSCoder coder) { super((SkipInit) null); initObject(init(coder)); }
    /**
     * @since Available in iOS 4.0 and later.
     */
    public NSExpression(String expressionFormat, NSArray<?> arguments) { super(create(expressionFormat, arguments)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "expressionType")
    public native NSExpressionType getExpressionType();
    @Property(selector = "constantValue")
    public native NSObject getConstantValue();
    @Property(selector = "keyPath")
    public native String getKeyPath();
    @Property(selector = "function")
    public native String getFunction();
    @Property(selector = "variable")
    public native String getVariable();
    @Property(selector = "operand")
    public native NSExpression getOperand();
    @Property(selector = "arguments")
    public native NSArray<?> getArguments();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "collection")
    public native NSObject getCollection();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "predicate")
    public native NSPredicate getPredicate();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "leftExpression")
    public native NSExpression getLeftExpression();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "rightExpression")
    public native NSExpression getRightExpression();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "trueExpression")
    public native NSExpression getTrueExpression();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "falseExpression")
    public native NSExpression getFalseExpression();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "expressionBlock")
    public native @Block Block3<NSObject, NSArray<NSExpression>, NSMutableDictionary<?, ?>, NSObject> getExpressionBlock();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithExpressionType:")
    protected native @Pointer long init(NSExpressionType type);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder coder);
    @Method(selector = "expressionValueWithObject:context:")
    public native NSObject evaluate(NSObject object, NSMutableDictionary<?, ?> context);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "allowEvaluation")
    public native void allowEvaluation();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "expressionWithFormat:argumentArray:")
    protected static native @Pointer long create(String expressionFormat, NSArray<?> arguments);
    @Method(selector = "expressionForConstantValue:")
    public static native NSExpression createForConstantValue(NSObject obj);
    @Method(selector = "expressionForEvaluatedObject")
    public static native NSExpression createForEvaluatedObject();
    @Method(selector = "expressionForVariable:")
    public static native NSExpression createForVariable(String string);
    @Method(selector = "expressionForKeyPath:")
    public static native NSExpression createForKeyPath(String keyPath);
    @Method(selector = "expressionForFunction:arguments:")
    public static native NSExpression createForFunction(String name, NSArray<?> parameters);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "expressionForAggregate:")
    public static native NSExpression createForAggregate(NSArray<?> subexpressions);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "expressionForUnionSet:with:")
    public static native NSExpression createForUnionSet(NSExpression left, NSExpression right);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "expressionForIntersectSet:with:")
    public static native NSExpression createForIntersectSet(NSExpression left, NSExpression right);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "expressionForMinusSet:with:")
    public static native NSExpression createForMinusSet(NSExpression left, NSExpression right);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "expressionForSubquery:usingIteratorVariable:predicate:")
    public static native NSExpression createForSubquery(NSExpression expression, String variable, NSObject predicate);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Method(selector = "expressionForFunction:selectorName:arguments:")
    public static native NSExpression createForFunction(NSExpression target, String name, NSArray<?> parameters);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "expressionForAnyKey")
    public static native NSExpression createForAnyKey();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "expressionForBlock:arguments:")
    public static native NSExpression createForBlock(@Block Block3<NSObject, NSArray<NSExpression>, NSMutableDictionary<?, ?>, NSObject> block, NSArray<?> arguments);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "expressionForConditional:trueExpression:falseExpression:")
    public static native NSExpression createForConditional(NSPredicate predicate, NSExpression trueExpression, NSExpression falseExpression);
    /*</methods>*/
}
