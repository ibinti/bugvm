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
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIStepper/*</name>*/ 
    extends /*<extends>*/UIControl/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIStepperPtr extends Ptr<UIStepper, UIStepperPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIStepper.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIStepper() {}
    protected UIStepper(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    
    public UIStepper(CGRect frame) {
        super(frame);
    }
    
    /*<properties>*/
    @Property(selector = "isContinuous")
    public native boolean isContinuous();
    @Property(selector = "setContinuous:")
    public native void setContinuous(boolean v);
    @Property(selector = "autorepeat")
    public native boolean isAutorepeat();
    @Property(selector = "setAutorepeat:")
    public native void setAutorepeat(boolean v);
    @Property(selector = "wraps")
    public native boolean isWraps();
    @Property(selector = "setWraps:")
    public native void setWraps(boolean v);
    @Property(selector = "value")
    public native double getValue();
    @Property(selector = "setValue:")
    public native void setValue(double v);
    @Property(selector = "minimumValue")
    public native double getMinimumValue();
    @Property(selector = "setMinimumValue:")
    public native void setMinimumValue(double v);
    @Property(selector = "maximumValue")
    public native double getMaximumValue();
    @Property(selector = "setMaximumValue:")
    public native void setMaximumValue(double v);
    @Property(selector = "stepValue")
    public native double getStepValue();
    @Property(selector = "setStepValue:")
    public native void setStepValue(double v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "tintColor")
    public native UIColor getTintColor();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setTintColor:")
    public native void setTintColor(UIColor v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setBackgroundImage:forState:")
    public native void setBackgroundImage(UIImage image, UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "backgroundImageForState:")
    public native UIImage getBackgroundImage(UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setDividerImage:forLeftSegmentState:rightSegmentState:")
    public native void setDividerImage(UIImage image, UIControlState leftState, UIControlState rightState);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "dividerImageForLeftSegmentState:rightSegmentState:")
    public native UIImage getDividerImage(UIControlState leftState, UIControlState rightState);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setIncrementImage:forState:")
    public native void setIncrementImage(UIImage image, UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "incrementImageForState:")
    public native UIImage getIncrementImage(UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setDecrementImage:forState:")
    public native void setDecrementImage(UIImage image, UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "decrementImageForState:")
    public native UIImage getDecrementImage(UIControlState state);
    /*</methods>*/
}
