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
package com.bugvm.apple.coreanimation;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("QuartzCore") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CABasicAnimation/*</name>*/ 
    extends /*<extends>*/CAPropertyAnimation/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CABasicAnimationPtr extends Ptr<CABasicAnimation, CABasicAnimationPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CABasicAnimation.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CABasicAnimation() {}
    protected CABasicAnimation(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public CABasicAnimation(String path) {
        super(create(path));
        retain(getHandle());
    }
    
    public double getNumericFromValue() {
        NSObject val = getFromValue();
        if (val instanceof NSNumber) {
            return ((NSNumber) val).doubleValue();
        }
        return 0;
    }
    public void setNumericFromValue(double value) {
        setFromValue(NSNumber.valueOf(value));
    }
    public double getNumericToValue() {
        NSObject val = getToValue();
        if (val instanceof NSNumber) {
            return ((NSNumber) val).doubleValue();
        }
        return 0;
    }
    public void setNumericToValue(double value) {
        setToValue(NSNumber.valueOf(value));
    }
    public double getNumericByValue() {
        NSObject val = getByValue();
        if (val instanceof NSNumber) {
            return ((NSNumber) val).doubleValue();
        }
        return 0;
    }
    public void setNumericByValue(double value) {
        setByValue(NSNumber.valueOf(value));
    }
    /*<properties>*/
    @Property(selector = "fromValue")
    public native NSObject getFromValue();
    @Property(selector = "setFromValue:")
    public native void setFromValue(NSObject v);
    @Property(selector = "toValue")
    public native NSObject getToValue();
    @Property(selector = "setToValue:")
    public native void setToValue(NSObject v);
    @Property(selector = "byValue")
    public native NSObject getByValue();
    @Property(selector = "setByValue:")
    public native void setByValue(NSObject v);
    /*</properties>*/
    /*<members>*//*</members>*/

    @Method(selector = "animationWithKeyPath:")
    protected static native @Pointer long create(String path);
    /*<methods>*/
    
    /*</methods>*/
}
