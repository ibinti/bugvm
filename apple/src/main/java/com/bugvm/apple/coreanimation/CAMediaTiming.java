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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/CAMediaTiming/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    @Property(selector = "beginTime")
    double getBeginTime();
    @Property(selector = "setBeginTime:")
    void setBeginTime(double v);
    @Property(selector = "duration")
    double getDuration();
    @Property(selector = "setDuration:")
    void setDuration(double v);
    @Property(selector = "speed")
    float getSpeed();
    @Property(selector = "setSpeed:")
    void setSpeed(float v);
    @Property(selector = "timeOffset")
    double getTimeOffset();
    @Property(selector = "setTimeOffset:")
    void setTimeOffset(double v);
    @Property(selector = "repeatCount")
    float getRepeatCount();
    @Property(selector = "setRepeatCount:")
    void setRepeatCount(float v);
    @Property(selector = "repeatDuration")
    double getRepeatDuration();
    @Property(selector = "setRepeatDuration:")
    void setRepeatDuration(double v);
    @Property(selector = "autoreverses")
    boolean autoreverses();
    @Property(selector = "setAutoreverses:")
    void setAutoreverses(boolean v);
    @Property(selector = "fillMode")
    CAFillMode getFillMode();
    @Property(selector = "setFillMode:")
    void setFillMode(CAFillMode v);
    /*</properties>*/
    /*<methods>*/
    
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
