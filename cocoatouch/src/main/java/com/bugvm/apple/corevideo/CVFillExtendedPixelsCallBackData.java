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
package com.bugvm.apple.corevideo;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*//*</visibility>*/ class /*<name>*/CVFillExtendedPixelsCallBackData/*</name>*/ 
    extends /*<extends>*/Struct<CVFillExtendedPixelsCallBackData>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CVFillExtendedPixelsCallBackDataPtr extends Ptr<CVFillExtendedPixelsCallBackData, CVFillExtendedPixelsCallBackDataPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CVFillExtendedPixelsCallBackData() {}
    public CVFillExtendedPixelsCallBackData(@MachineSizedSInt long version, FunctionPtr fillCallBack, @Pointer long refCon) {
        this.setVersion(version);
        this.setFillCallBack(fillCallBack);
        this.setRefCon(refCon);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @MachineSizedSInt long getVersion();
    @StructMember(0) public native CVFillExtendedPixelsCallBackData setVersion(@MachineSizedSInt long version);
    @StructMember(1) public native FunctionPtr getFillCallBack();
    @StructMember(1) public native CVFillExtendedPixelsCallBackData setFillCallBack(FunctionPtr fillCallBack);
    @StructMember(2) public native @Pointer long getRefCon();
    @StructMember(2) public native CVFillExtendedPixelsCallBackData setRefCon(@Pointer long refCon);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
