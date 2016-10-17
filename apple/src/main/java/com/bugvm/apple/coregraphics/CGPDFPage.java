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
package com.bugvm.apple.coregraphics;

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
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreGraphics")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CGPDFPage/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CGPDFPagePtr extends Ptr<CGPDFPage, CGPDFPagePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CGPDFPage.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CGPDFPage() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFPageGetDocument", optional=true)
    public native CGPDFDocument getDocument();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFPageGetPageNumber", optional=true)
    public native @MachineSizedUInt long getPageNumber();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFPageGetBoxRect", optional=true)
    public native @ByVal CGRect getBoxRect(CGPDFBox box);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFPageGetRotationAngle", optional=true)
    public native int getRotationAngle();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFPageGetDrawingTransform", optional=true)
    public native @ByVal CGAffineTransform getDrawingTransform(CGPDFBox box, @ByVal CGRect rect, int rotate, boolean preserveAspectRatio);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFPageGetDictionary", optional=true)
    public native CGPDFDictionary getDictionary();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFPageGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /*</methods>*/
}
