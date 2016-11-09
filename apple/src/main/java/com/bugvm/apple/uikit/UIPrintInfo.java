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
 * @since Available in iOS 4.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIPrintInfo/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class UIPrintInfoPtr extends Ptr<UIPrintInfo, UIPrintInfoPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIPrintInfo.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIPrintInfo() {}
    protected UIPrintInfo(SkipInit skipInit) { super(skipInit); }
    public UIPrintInfo(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    public UIPrintInfo(NSDictionary<?, ?> dictionary) { super(create(dictionary)); retain(getHandle()); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "printerID")
    public native String getPrinterID();
    @Property(selector = "setPrinterID:")
    public native void setPrinterID(String v);
    @Property(selector = "jobName")
    public native String getJobName();
    @Property(selector = "setJobName:")
    public native void setJobName(String v);
    @Property(selector = "outputType")
    public native UIPrintInfoOutputType getOutputType();
    @Property(selector = "setOutputType:")
    public native void setOutputType(UIPrintInfoOutputType v);
    @Property(selector = "orientation")
    public native UIPrintInfoOrientation getOrientation();
    @Property(selector = "setOrientation:")
    public native void setOrientation(UIPrintInfoOrientation v);
    @Property(selector = "duplex")
    public native UIPrintInfoDuplex getDuplex();
    @Property(selector = "setDuplex:")
    public native void setDuplex(UIPrintInfoDuplex v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "dictionaryRepresentation")
    public native NSDictionary<?, ?> toDictionary();
    @Method(selector = "printInfoWithDictionary:")
    protected static native @Pointer long create(NSDictionary<?, ?> dictionary);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    /*</methods>*/
}
